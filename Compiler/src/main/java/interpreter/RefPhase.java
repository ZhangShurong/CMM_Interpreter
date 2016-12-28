package interpreter;


import gen.CMMBaseVisitor;
import gen.CMMParser;
import io.IOInterface;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.Stack;

/**
 * Created by vergil on 2016/12/7.
 */
public class RefPhase extends CMMBaseVisitor<ReturnValue> {

    private IOInterface io;

    ParseTreeProperty<Scope> scopes;
    Scope globals;
    Scope currentScope;

    Stack whilestack;

    public RefPhase(Scope globals, ParseTreeProperty<Scope> scopes, IOInterface io) {
        this.io = io;
        this.globals = globals;
        this.scopes = scopes;
        whilestack = new Stack();
    }

    @Override
    public ReturnValue visitProgram(CMMParser.ProgramContext ctx) {
        currentScope = globals;
        super.visitProgram(ctx);
        return null;
    }

    boolean meetBreak=false;
    @Override
    public ReturnValue visitStmtBlock(CMMParser.StmtBlockContext ctx) {
        currentScope = scopes.get(ctx);
//        super.visitStmtBlock(ctx);
        String c=ctx.getText();
        int len=appearNumber(c,";");
        if(c.contains("break")){
            for(int i=0;i<len;i++){
                if(!meetBreak){
                    super.visit(ctx.stmt(i));
                }
            }
        }else {
            super.visitStmtBlock(ctx);
        }

        currentScope = currentScope.getEnclosingScope();
        return null;
    }

    public ReturnValue visitDelassign(CMMParser.DelassignContext ctx)
    {
        super.visitDelassign(ctx);
        Token token = ctx.IDENT().getSymbol();
        String varName = token.getText();
        Symbol var = currentScope.resolve(varName);
        if(var == null){
            Error.undeclared_var_error(io, varName, token.getLine(),token.getCharPositionInLine());
            return null;
        }else{
            ExprCalculator exprCalculator = new ExprCalculator(currentScope, io);
            ReturnValue value = exprCalculator.visit(ctx.expr());
            Token assign = ctx.EQUAL().getSymbol();
            if(value == null || value.getType() == null || value.getValue(value.getType()) == null)
            {
                Error.unmatched_type_error(io, assign.getText(),assign.getLine(),assign.getCharPositionInLine());
                Error.unmatched_type_error(io, assign.getText(),assign.getLine(),assign.getCharPositionInLine());
                return null;
            }
            else {
                var.setValue(value.getValue(var.getType()));
            }
        }
        return null;
    }
    @Override
    public ReturnValue visitAssignStmt(CMMParser.AssignStmtContext ctx) {
        super.visitAssignStmt(ctx);
        if(ctx.value().IDENT() == null){
            //数组
            Token token = ctx.value().array().IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                Error.undeclared_var_error(io, varName, token.getLine(), token.getCharPositionInLine());
                return null;
            }else{
                ExprCalculator exprCalculator = new ExprCalculator(currentScope, io);
                ReturnValue value = exprCalculator.visit(ctx.expr());//得到表达式右边的值

                //计算数组index
                int varIndex;
                if(ctx.value().array().INTCONSTANT() != null){
                    varIndex = Integer.parseInt(ctx.value().array().INTCONSTANT().getText());
                }else{
                    ExprCalculator indexComputeVisitor = new ExprCalculator(currentScope, io);
                    ReturnValue indexValue = indexComputeVisitor.visit(ctx.value().array().expr());
                    if(indexValue.getType() != Type.tInt){
                        Error.invalid_type_error(io, varName,token.getLine(),token.getCharPositionInLine());
                        return null;
                    }
                    varIndex = (Integer) indexValue.getValue();
                }

                //开始赋值
                if(var.getType() == Type.tIntArray){
                    int[] varArray = (int[]) var.getValue();
                    if(0 <= varIndex && varIndex < varArray.length){
                        if(value.getValue(Type.tInt) != null)
                        {
                            varArray[varIndex] = (Integer) value.getValue(Type.tInt);
                            if(!(value.getValue() instanceof  Integer)){
                                Warning.unmatched_type_warning(io,varName,token.getLine(),token.getCharPositionInLine() );
                            }
                        }
                        else{
                            Error.unmatched_type_error(io,varName,token.getLine(),token.getCharPositionInLine() );
                            return null;
                        }
                    }else{
                        Error.out_of_boundary_error(io, varName,token.getLine(), token.getCharPositionInLine());
                        return null;
                    }

                }else if(var.getType() == Type.tDoubleArray){
                    double[] varArray = (double[]) var.getValue();
                    if(0 <= varIndex && varIndex < varArray.length){
                        if(value.getValue(Type.tDouble) != null)
                        {
                            varArray[varIndex] = (Double) value.getValue(Type.tDouble);
                            if(!(value.getValue() instanceof  Double)){
                                Warning.unmatched_type_warning(io,varName,token.getLine(),token.getCharPositionInLine() );
                            }
                        }
                        else{
                            Error.unmatched_type_error(io, varName,token.getLine(), token.getCharPositionInLine());
                            return null;
                        }
                    }else{
                        Error.out_of_boundary_error(io, varName, token.getLine(), token.getCharPositionInLine());
                        return null;
                    }
                }
                else {

                }
            }
        }else{
            Token token = ctx.value().IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                Error.undeclared_var_error(io, varName, token.getLine(),token.getCharPositionInLine());
                return null;
            }else{
                ExprCalculator exprCalculator = new ExprCalculator(currentScope, io);
                ReturnValue value = exprCalculator.visit(ctx.expr());
                Token assign = ctx.EQUAL().getSymbol();
                if(value.getValue(value.getType()) == null)
                {
                    Error.unmatched_type_error(io, assign.getText(),assign.getLine(),assign.getCharPositionInLine());
                    return null;
                }
                else {
                    var.setValue(value.getValue(var.getType()));
                }
            }
        }
        return null;
    }

    @Override
    public ReturnValue visitReadStmt(CMMParser.ReadStmtContext ctx) {
        super.visitReadStmt(ctx);
        Token token;
        String input = io.stdin(ctx.getText());
        if(ctx.IDENT() == null){
            token = ctx.array().IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                Error.undeclared_var_error(io, varName,token.getLine(),token.getCharPositionInLine());
                return null;
            }
            int varIndex = Integer.parseInt(ctx.array().INTCONSTANT().getText());
            if(var.getType() == Type.tIntArray){
                int[] varArray = (int[]) var.getValue();

                if(0 <= varIndex && varIndex < varArray.length){
                    //int in = Integer.parseInt(io.stdin());
                    int in = Integer.parseInt(input);
                    varArray[varIndex] = in;
                }else{
                    Error.out_of_boundary_error(io,varName,token.getLine(),token.getCharPositionInLine());
                }

            }else{ // double数组

                double[] varArray = (double[]) var.getValue();

                // 数组越界检查
                if(0 <= varIndex && varIndex < varArray.length){
                    //Double in = Double.parseDouble(io.stdin());
                    Double in = Double.parseDouble(input);
                    varArray[varIndex] = in;
                }else{
                    Error.out_of_boundary_error(io,varName,token.getLine(),token.getCharPositionInLine());
                }

            }
        }else{
            token = ctx.IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                Error.undeclared_var_error(io, varName, token.getLine(), token.getCharPositionInLine());
                return null;
            }
            if(var.getType() == Type.tInt){
                //int in = Integer.parseInt(io.stdin());
                int in = Integer.parseInt(input);
                var.setValue(in);
            }
            else if(var.getType() == Type.tDouble){
                //Double in = Double.parseDouble(io.stdin());
                Double in = Double.parseDouble(input);
                var.setValue(in);
            }
            else if(var.getType() == Type.tString)
            {
                var.setValue("\"" + input + "\"");
            }
            else if (var.getType() == Type.tBool)
            {
                int in = Integer.parseInt(input);
                var.setValue(in);
            }

        }
        return null;
    }

    @Override
    public ReturnValue visitWriteStmt(CMMParser.WriteStmtContext ctx) {
        super.visitWriteStmt(ctx);
        ExprCalculator exprCalculator = new ExprCalculator(currentScope, io);
        CMMParser.ExprContext m=ctx.expr();
        ReturnValue returnValue = exprCalculator.visit(ctx.expr());
        if(returnValue ==null){
            return null;
        }
        Object value = returnValue.getValue();
        if(value == null)
            value = "";
        if(returnValue.getType() == Type.tString)
        {
            io.stdout(value.toString());
        }
        else {
            io.stdout(value);
            io.stdout("\n");
        }
        return null;
    }



    public ReturnValue visitONLYIF(CMMParser.ONLYIFContext ctx)
    {
        if(isExprTrue(ctx.expr()) == 1){
            if(ctx.stmtBlock() != null)
                visit(ctx.stmtBlock());
            else
                visit(ctx.stmt());
        }
        return null;
    }

    public ReturnValue visitIFELSE(CMMParser.IFELSEContext ctx)
    {
        if(isExprTrue(ctx.expr()) == 1) {
            if(ctx.stmtBlock(0)!=null)
                visit(ctx.stmtBlock(0));
            else
                visit(ctx.stmt(0));
        }
        else {
            if(ctx.stmtBlock(1)!= null)
                visit(ctx.stmtBlock(1));
            else
                visit(ctx.stmt(1));
        }
        return null;
    }

    public ReturnValue visitIFELSELIST(CMMParser.IFELSELISTContext ctx)
    {
        if(isExprTrue(ctx.expr()) == 1)
        {
            if(ctx.stmtBlock()!=null)
                visit(ctx.stmtBlock());
            else
                visit(ctx.stmt());
        }
        else {
            visit(ctx.elseiflist());
        }
        return null;
    }

    public ReturnValue visitIFELSELISTELSE(CMMParser.IFELSELISTELSEContext ctx)
    {
        if(isExprTrue(ctx.expr()) == 1)
        {
            if(ctx.stmtBlock(0)!=null)
                visit(ctx.stmtBlock(0));
            else
                visit(ctx.stmt(0));
        }
        else {
            if(visit(ctx.elseiflist()).getValue().equals((int)0))
            {
                if(visit(ctx.stmtBlock(1))!= null)
                    visit(ctx.stmtBlock(1));
                else
                    visit(ctx.stmt(1));
            }
        }
        return null;
    }
    public ReturnValue visitElseiflist(CMMParser.ElseiflistContext ctx)
    {
        ReturnValue returnValue = new ReturnValue();
        returnValue.setType(Type.tBool);
        returnValue.setValue((int)0);
        for(int i = 0; i < ctx.elseif().size(); i++)
        {
            if(isExprTrue(ctx.elseif(i).expr()) == 1)
            {
                if(ctx.elseif(i).stmtBlock()!=null)
                    visit(ctx.elseif(i).stmtBlock());
                else
                    visit(ctx.elseif(i).stmt());
                returnValue.setValue((int)1);
                break;
            }
        }
        return returnValue;
    }
    private Integer isExprTrue(CMMParser.ExprContext ctx){
        ExprCalculator exprCalculator = new ExprCalculator(currentScope, io);
        ReturnValue value = exprCalculator.visit(ctx);
        if(value.getType() == Type.tBool){
            return (Integer) value.getValue();
        }else{
            if(value.getType() == Type.tDouble)
                return (Double)value.getValue() != 0?1:0;
            else
                return (Integer)value.getValue() != 0?1:0;
        }
    }

    public static int appearNumber(String srcText, String findText) {
        int count = 0;
        int index = 0;
        while ((index = srcText.indexOf(findText, index)) != -1) {
            index = index + findText.length();
            count++;
        }
        return count;
    }


    public ReturnValue visitWhileStmt(CMMParser.WhileStmtContext ctx)
    {
        whilestack.push(true);

        while (isExprTrue(ctx.expr()) == 1)
        {
            if(Constant.stop)
            {
                break;
            }
            if(ctx.stmt() != null){
                visit(ctx.stmt());
            }else{
                visit(ctx.stmtBlock());
//                String c=ctx.stmtBlock().getText();
//                if(c.contains("break")){
//                    int len=appearNumber(c,";");
//                    for(int i=0;i<len;i++){
//                        if(!meetBreak){
//                            visit(ctx.stmtBlock().stmt(i));
//                        }
//                    }
//                }else {
//                    visit(ctx.stmtBlock());
//                }
            }
            if(!(boolean)whilestack.peek())
                break;
        }
        whilestack.pop();
        return null;
    }

    public ReturnValue visitBreakStmt(CMMParser.BreakStmtContext ctx)
    {

        whilestack.pop();
        meetBreak=true;
        whilestack.push(false);
        return super.visitBreakStmt(ctx);
    }
}
