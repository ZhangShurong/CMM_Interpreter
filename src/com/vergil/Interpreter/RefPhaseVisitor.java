package com.vergil.Interpreter;

import com.vergil.Utils.IOInterface;
import gen.CMMBaseVisitor;
import gen.CMMParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

/**
 * Created by vergil on 2016/12/7.
 */
public class RefPhaseVisitor extends CMMBaseVisitor<ExprReturnVal> {

    private IOInterface io;

    ParseTreeProperty<Scope> scopes;
    GlobalScope globals;
    Scope currentScope;

    public RefPhaseVisitor(GlobalScope globals, ParseTreeProperty<Scope> scopes, IOInterface io) {
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

        if(ctx.value().IDENT() == null){
            Token token = ctx.value().array().IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                io.output("ERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }else{
                ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
                ExprReturnVal value = exprComputeVisitor.visit(ctx.expr()); // 右边表达式计算得到的值
                int varIndex;
                if(ctx.value().array().INTCONSTANT() != null){ // 索引为int常量
                    varIndex = Integer.parseInt(ctx.value().array().INTCONSTANT().getText());
                }else{ // 索引为表达式
                    ExprComputeVisitor indexComputeVisitor = new ExprComputeVisitor(currentScope, io);
                    ExprReturnVal indexValue = indexComputeVisitor.visit(ctx.value().array().expr());
                    if(indexValue.getType() != Type.tInt){
                        io.output("ERROR: invalid index for <"
                                + varName
                                + "> in line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
                        return null;
                    }
                    varIndex = (Integer) indexValue.getValue();
                }
                if(var.getType() == Type.tIntArray){ // int数组
                    int[] varArray = (int[]) var.getValue();
                    // 数组越界检查
                    if(0 <= varIndex && varIndex < varArray.length){
                        if(value.getValue() instanceof  Integer){
                            varArray[varIndex] = (Integer) value.getValue();
                        }else{
                            io.output("ERROR: unmatched or uncast type during assignment of <"
                                    + varName
                                    + "> in line "
                                    + token.getLine()
                                    +":"
                                    + token.getCharPositionInLine());
                            return null;
                        }
                    }else{
                        io.output("ERROR: index out of boundary of array <"
                                + varName
                                + "> in line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
                        return null;
                    }

                }else{ // double数组
                    double[] varArray = (double[]) var.getValue();
                    // 数组越界检查
                    if(0 <= varIndex && varIndex < varArray.length){
                        if(value.getValue() instanceof  Double){
                            varArray[varIndex] = (Double) value.getValue();
                        }else if(value.getValue() instanceof  Integer){
                            varArray[varIndex] = (Integer) value.getValue();
                        }else{
                            io.output("ERROR: unmatched or uncast type during assignment of <"
                                    + varName
                                    + "> in line "
                                    + token.getLine()
                                    +":"
                                    + token.getCharPositionInLine());
                            return null;
                        }
                    }else{
                        io.output("ERROR: index out of boundary of array <"
                                + varName
                                + "> in line "
                                + token.getLine()
                                + ":" + token.getCharPositionInLine());
                        return null;
                    }

                }
            }
        }else{ // 普通变量
            Token token = ctx.value().IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                io.output("ERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }else{ // 变量存在
                ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
                ExprReturnVal value = exprComputeVisitor.visit(ctx.expr());

                if(var.getType() != value.getType()){
                    Token assign = ctx.EQUAL().getSymbol(); // 找到等号方便定位错误
                    io.output("ERROR: unmatched type on two side of <"
                            + assign.getText()
                            + "> in line "
                            + assign.getLine()
                            +":"
                            + assign.getCharPositionInLine());
                    return null;
                }else{ // 新值覆盖旧值
                    var.setValue(value.getValue());
                }
            }
        }

        return null;
    }

    @Override
    public ExprReturnVal visitReadStmt(CMMParser.ReadStmtContext ctx) {
        super.visitReadStmt(ctx);
        Token token = null;
        if(ctx.IDENT() == null){
            token = ctx.array().IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                io.output("ERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }
            int varIndex = Integer.parseInt(ctx.array().INTCONSTANT().getText());
            if(var.getType() == Type.tIntArray){ // int数组

                int[] varArray = (int[]) var.getValue();

                // 数组越界检查
                if(0 <= varIndex && varIndex < varArray.length){
                    int in = Integer.parseInt(io.input());
                    varArray[varIndex] = in;
                }else{
                    io.output("ERROR: index out of boundary of array <"
                            + varName
                            + "> in line "
                            + token.getLine()
                            + ":" + token.getCharPositionInLine());
                }

            }else{ // double数组

                double[] varArray = (double[]) var.getValue();

                // 数组越界检查
                if(0 <= varIndex && varIndex < varArray.length){
                    Double in = Double.parseDouble(io.input());
                    varArray[varIndex] = in;
                }else{
                    io.output("ERROR: index out of boundary of array <"
                            + varName
                            + "> in line "
                            + token.getLine()
                            + ":" + token.getCharPositionInLine());
                }

            }
        }else{ // 普通变量
            token = ctx.IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = currentScope.resolve(varName);
            if(var == null){
                io.output("ERROR: no such variable <"
                        + varName
                        + "> in line "
                        + token.getLine()
                        + ":" + token.getCharPositionInLine());
                return null;
            }
            if(var.getType() == Type.tInt){
                int in = Integer.parseInt(io.input());
                var.setValue(in);
            }else{
                Double in = Double.parseDouble(io.input());
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
        io.output(value);
        return null;
    }

    // ==========下面是if else的各种变种，为了减少判断，特地在文法了进行了拆分

    @Override
    public ExprReturnVal visitI_S(CMMParser.I_SContext ctx) { // if stmt
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_SB(CMMParser.I_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_S_E_S(CMMParser.I_S_E_SContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt(0));
        }else{
            visit(ctx.stmt(1));
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_S_E_SB(CMMParser.I_S_E_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt());
        }else{
            visit(ctx.stmt_block());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_SB_E_S(CMMParser.I_SB_E_SContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block());
        }else{
            visit(ctx.stmt());
        }
        return null;
    }

    @Override
    public ExprReturnVal visitI_SB_E_SB(CMMParser.I_SB_E_SBContext ctx) {
        if(isExprTrue(ctx.expr())){
            visit(ctx.stmt_block(0));
        }else{
            visit(ctx.stmt_block(1));
        }
        return null;
    }

    private boolean isExprTrue(CMMParser.ExprContext ctx){
        ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
        ExprReturnVal value = exprComputeVisitor.visit(ctx);
        if(value.getType() == Type.tBool){
            return (Boolean) value.getValue();
        }else{
            return (Double) value.getValue() > 0;
        }
    }

    // ============================= end if else ==========================

    @Override
    public ExprReturnVal visitWhile_stmt(CMMParser.While_stmtContext ctx) {

        while (isExprTrue(ctx.expr())) {
            if(ctx.stmt() != null){ // while后面紧跟stmt
                visit(ctx.stmt());
            }else{ // while后面紧跟stmt_block
                visit(ctx.stmt_block());
            }
        }

        return null;
    }

    @Override
    public ExprReturnVal visitBreak_stmt(CMMParser.Break_stmtContext ctx) {
        return super.visitBreak_stmt(ctx);
    }


}
