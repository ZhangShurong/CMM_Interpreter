package interpreter;


import gen.CMMBaseVisitor;
import gen.CMMParser;
import io.IOInterface;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by vergil on 2016/12/7.
 */
public class RefPhaseVisitor extends CMMBaseVisitor<ExprReturnVal> {

    private IOInterface io;

    ParseTreeProperty<Scope> scopes;
    Scope globals;
    Scope currentScope;

    public RefPhaseVisitor(Scope globals, ParseTreeProperty<Scope> scopes, IOInterface io) {
        this.io = io;
        this.globals = globals;
        this.scopes = scopes;
    }

    @Override
    public ExprReturnVal visitProgram(CMMParser.ProgramContext ctx) {
        currentScope = globals;
        super.visitProgram(ctx);
        return null;
    }

    @Override
    public ExprReturnVal visitStmtBlock(CMMParser.StmtBlockContext ctx) {
        currentScope = scopes.get(ctx);
        super.visitStmtBlock(ctx);
        currentScope = currentScope.getEnclosingScope();
        return null;
    }

    @Override
    public ExprReturnVal visitAssignStmt(CMMParser.AssignStmtContext ctx) {
        super.visitAssignStmt(ctx);

        if(ctx.value().IDENT() == null){//非数组
            Token token = ctx.value().array().IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                io.stderr("error:'"+varName+"' undeclared "
                        + "\n\tline:"
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }else{//数组
                ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
                ExprReturnVal value = exprComputeVisitor.visit(ctx.expr());

                int varIndex;
                if(ctx.value().array().INTCONSTANT() != null){
                    varIndex = Integer.parseInt(ctx.value().array().INTCONSTANT().getText());
                }else{
                    ExprComputeVisitor indexComputeVisitor = new ExprComputeVisitor(currentScope, io);
                    ExprReturnVal indexValue = indexComputeVisitor.visit(ctx.value().array().expr());
                    if(indexValue.getType() != Type.tInt){
                        io.stderr(" error: invalid types for array "
                                + varName
                                + " subscipt"+
                                "\n\tin line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
                        return null;
                    }
                    varIndex = (Integer) indexValue.getValue();
                }

                if(var.getType() == Type.tIntArray){
                    int[] varArray = (int[]) var.getValue();
                    if(0 <= varIndex && varIndex < varArray.length){
                        if(value.getValue() instanceof  Integer){
                            varArray[varIndex] = (Integer) value.getValue();
                        }else{
                            io.stderr("error: unmatched or uncast type during assignment of '"
                                    + varName
                                    + "'"
                                    + "\n\tin line "
                                    + token.getLine()
                                    +":"
                                    + token.getCharPositionInLine());
                            return null;
                        }
                    }else{
                        io.stderr("error: index out of boundary of array '"
                                + varName
                                + "'"
                                +"\n\tin line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
                        return null;
                    }

                }else if(var.getType() == Type.tDoubleArray){
                    double[] varArray = (double[]) var.getValue();
                    if(0 <= varIndex && varIndex < varArray.length){
                        if(value.getValue() instanceof  Double){
                            varArray[varIndex] = (Double) value.getValue();
                        }else if(value.getValue() instanceof  Integer){
                            varArray[varIndex] = (Integer) value.getValue();
                        }else{
                            io.stderr("error: unmatched or uncast type during assignment of '"
                                    + varName
                                    + "'"
                                    + "\n\tin line "
                                    + token.getLine()
                                    +":"
                                    + token.getCharPositionInLine());
                            return null;
                        }
                    }else{
                        io.stderr("error: index out of boundary of array '"
                                + varName
                                + "'"
                                +"\n\tin line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
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
                io.stderr("error:'"+varName+"' undeclared "
                        + "\n\tline:"
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }else{
                ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
                ExprReturnVal value = exprComputeVisitor.visit(ctx.expr());
                if(var.getType() != value.getType()){
                    Token assign = ctx.EQUAL().getSymbol();
                    io.stderr("error: unmatched type '"
                            + assign.getText()
                            + "'"
                            +"\n\tin line "
                            + assign.getLine()
                            +":"
                            + assign.getCharPositionInLine());
                    return null;
                }else{
                    var.setValue(value.getValue());
                }
            }
        }
        return null;
    }

    @Override
    public ExprReturnVal visitReadStmt(CMMParser.ReadStmtContext ctx) {
        super.visitReadStmt(ctx);
        Token token;
        if(ctx.IDENT() == null){
            token = ctx.array().IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                io.stderr("error:'"+varName+"' undeclared "
                        + "\n\tin line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }
            int varIndex = Integer.parseInt(ctx.array().INTCONSTANT().getText());
            if(var.getType() == Type.tIntArray){
                int[] varArray = (int[]) var.getValue();

                if(0 <= varIndex && varIndex < varArray.length){
                    int in = Integer.parseInt(io.stdin());
                    varArray[varIndex] = in;
                }else{
                    io.stderr("error: index out of boundary of array '"
                            + varName
                            + "'"
                            +"\n\tin line "
                            + token.getLine()
                            + ":" + token.getCharPositionInLine());
                }

            }else{ // double数组

                double[] varArray = (double[]) var.getValue();

                // 数组越界检查
                if(0 <= varIndex && varIndex < varArray.length){
                    Double in = Double.parseDouble(io.stdin());
                    varArray[varIndex] = in;
                }else{
                    io.stderr("error: index out of boundary of array '"
                            + varName
                            + "'"
                            +"\n\tin line "
                            + token.getLine()
                            + ":" + token.getCharPositionInLine());
                }

            }
        }else{ // 普通变量
            token = ctx.IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                io.stderr("ERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }
            if(var.getType() == Type.tInt){
                int in = Integer.parseInt(io.stdin());
                var.setValue(in);
            }else{
                Double in = Double.parseDouble(io.stdin());
                var.setValue(in);
            }

        }
        return null;
    }

    @Override
    public ExprReturnVal visitWriteStmt(CMMParser.WriteStmtContext ctx) {
        super.visitWriteStmt(ctx);
        ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
        Object value = exprComputeVisitor.visit(ctx.expr()).getValue();
        io.stderr(value);
        return null;
    }



    public ExprReturnVal visitONLYIF(CMMParser.ONLYIFContext ctx)
    {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmtBlock());
        }
        return null;
    }

    public ExprReturnVal visitIFELSE(CMMParser.IFELSEContext ctx)
    {
        if(isExprTrue(ctx.expr())) {
            visit(ctx.stmtBlock(0));
        }
        else {
            visit(ctx.stmtBlock(1));
        }
        return null;
    }

    public ExprReturnVal visitIFELSELIST(CMMParser.IFELSELISTContext ctx)
    {
        if(isExprTrue(ctx.expr()))
        {
            visit(ctx.stmtBlock());
        }
        else {
            visit(ctx.elseiflist());
        }
        return null;
    }

    public ExprReturnVal visitIFELSELISTELSE(CMMParser.IFELSELISTELSEContext ctx)
    {
        if(isExprTrue(ctx.expr()))
        {
            visit(ctx.stmtBlock(0));
        }
        else {
            if(visit(ctx.elseiflist()).getValue().equals((int)0))
            {
                visit(ctx.stmtBlock(1));
            }
        }
        return null;
    }
    public  ExprReturnVal visitElseiflist(CMMParser.ElseiflistContext ctx)
    {
        ExprReturnVal exprReturnVal = new ExprReturnVal();
        exprReturnVal.setType(Type.tBool);
        exprReturnVal.setValue((int)0);
        for(int i = 0; i < ctx.elseif().size(); i++)
        {
            if(isExprTrue(ctx.elseif(i).expr()))
            {
                visit(ctx.elseif(i).stmtBlock());
                exprReturnVal.setValue((int)1);
                break;
            }
        }
        return exprReturnVal;
    }
    private boolean isExprTrue(CMMParser.ExprContext ctx){
        ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
        ExprReturnVal value = exprComputeVisitor.visit(ctx);
        if(value.getType() == Type.tBool){
            return (Boolean) value.getValue();
        }else{
            if(value.getType() == Type.tDouble)
                return (Double)value.getValue() != 0;
            else
                return (Integer)value.getValue() != 0;
        }
    }

    public ExprReturnVal visitWhileStmt(CMMParser.WhileStmtContext ctx)
    {
        while (isExprTrue(ctx.expr()))
        {
            if(ctx.stmt() != null){
                visit(ctx.stmt());
            }else{
                visit(ctx.stmtBlock());
            }
        }
        return null;
    }
    //todo
    public ExprReturnVal visitBreakStmt(CMMParser.BreakStmtContext ctx)
    {

        //return visitChildren(ctx);
        return super.visitBreakStmt(ctx);
    }
}
