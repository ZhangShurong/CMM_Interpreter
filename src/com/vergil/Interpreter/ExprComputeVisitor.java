package com.vergil.Interpreter;

import com.vergil.Utils.IOInterface;
import gen.CMMBaseVisitor;
import gen.CMMParser;
import org.antlr.v4.runtime.Token;

/**
 * Created by vergil on 2016/12/7.
 */
public class ExprComputeVisitor extends CMMBaseVisitor<ExprReturnVal> {
    Scope currentScope;
    private IOInterface io;

    public ExprComputeVisitor(Scope currentScope, IOInterface io) {
        this.currentScope = currentScope;
        this.io = io;
    }

    @Override
    public ExprReturnVal visitMultiplication(CMMParser.MultiplicationContext ctx) {
        Token op = ctx.MULT().getSymbol();
        ExprReturnVal leftValue = visit(ctx.mulDiv());
        ExprReturnVal rightValue = visit(ctx.unaryMinus());

        ExprReturnVal returnVal = new ExprReturnVal();
        if(leftValue.getType() == Type.tReal && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tReal);
            if(op.getText().equals("*")){
                returnVal.setValue((Double)leftValue.getValue() * (Integer) rightValue.getValue());
            }else if(op.getText().equals("/")){
                if((Integer)rightValue.getValue() == 0){
                    io.output("ERROR: divide zero"
                            + " in line "
                            + op.getLine()
                            +":"
                            + op.getCharPositionInLine());
                    return null;
                }
                returnVal.setValue((Double)leftValue.getValue() / (Integer) rightValue.getValue());
            }else if(op.getText().equals("%")){
                if((Integer)rightValue.getValue() == 0){
                    io.output("ERROR: divide zero"
                            + " in line "
                            + op.getLine()
                            +":"
                            + op.getCharPositionInLine());
                    return null;
                }
                returnVal.setValue((Double)leftValue.getValue() % (Integer) rightValue.getValue());
            }
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tReal){
            returnVal.setType(Type.tReal);
            if(op.getText().equals("*")){
                returnVal.setValue((Integer)leftValue.getValue() * (Double) rightValue.getValue());
            }else if(op.getText().equals("/")){
                returnVal.setValue((Integer)leftValue.getValue() / (Double) rightValue.getValue());
            }else if(op.getText().equals("%")){
                returnVal.setValue((Integer)leftValue.getValue() % (Double) rightValue.getValue());
            }
        }else if(leftValue.getType() == Type.tReal && rightValue.getType() == Type.tReal){
            returnVal.setType(Type.tReal);
            if(op.getText().equals("*")){
                returnVal.setValue((Double)leftValue.getValue() * (Double) rightValue.getValue());
            }else if(op.getText().equals("/")){
                returnVal.setValue((Double)leftValue.getValue() / (Double) rightValue.getValue());
            }else if(op.getText().equals("%")){
                returnVal.setValue((Double)leftValue.getValue() % (Double) rightValue.getValue());
            }
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tInt);
            if(op.getText().equals("*")){
                returnVal.setValue((Integer)leftValue.getValue() * (Integer) rightValue.getValue());
            }else if(op.getText().equals("/")){
                if((Integer)rightValue.getValue() == 0){
                    io.output("ERROR: divide zero"
                            + " in line "
                            + op.getLine()
                            +":"
                            + op.getCharPositionInLine());
                    return null;
                }
                returnVal.setValue((Integer)leftValue.getValue() / (Integer) rightValue.getValue());
            }else if(op.getText().equals("%")){
                if((Integer)rightValue.getValue() == 0){
                    io.output("ERROR: divide zero"
                            + " in line "
                            + op.getLine()
                            +":"
                            + op.getCharPositionInLine());
                    return null;
                }
                returnVal.setValue((Integer)leftValue.getValue() % (Integer) rightValue.getValue());
            }
        }else{
            io.output("ERROR: unmatched or uncast type on two side of <"
                    + op.getText()
                    + "> in line "
                    + op.getLine()
                    +":"
                    + op.getCharPositionInLine());
        }

        return returnVal;
    }

    @Override
    public ExprReturnVal visitAddMinExpr(CmmParser.AddMinExprContext ctx) {

        Token op = ctx.AddMin().getSymbol(); // 操作符
        ExprReturnVal leftValue = visit(ctx.expr(0)); // 左值
        ExprReturnVal rightValue = visit(ctx.expr(1)); // 右值
        ExprReturnVal returnVal = new ExprReturnVal();
        // 运算时做类型检查
        if(leftValue.getType() == Type.tReal && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tReal);
            if(op.getText().equals("+")){
                returnVal.setValue((Double)leftValue.getValue() + (Integer) rightValue.getValue());
            }else{
                returnVal.setValue((Double)leftValue.getValue() - (Integer) rightValue.getValue());
            }
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tReal){
            returnVal.setType(Type.tReal);
            if(op.getText().equals("+")){
                returnVal.setValue((Integer)leftValue.getValue() + (Double) rightValue.getValue());
            }else{
                returnVal.setValue((Integer)leftValue.getValue() - (Double) rightValue.getValue());
            }
        }else if(leftValue.getType() == Type.tReal && rightValue.getType() == Type.tReal){
            returnVal.setType(Type.tReal);
            if(op.getText().equals("+")){
                returnVal.setValue((Double)leftValue.getValue() + (Double) rightValue.getValue());
            }else{
                returnVal.setValue((Double)leftValue.getValue() - (Double) rightValue.getValue());
            }
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tInt);
            if(op.getText().equals("+")){
                returnVal.setValue((Integer)leftValue.getValue() + (Integer)rightValue.getValue());
            }else{
                returnVal.setValue((Integer)leftValue.getValue() - (Integer)rightValue.getValue());
            }
        }else{
            io.output("ERROR: unmatched or uncast type on two side of <"
                    + op.getText()
                    + "> in line "
                    + op.getLine()
                    +":"
                    + op.getCharPositionInLine());
        }
        return returnVal;
    }

    @Override
    public ExprReturnVal visitCompareExpr(CmmParser.CompareExprContext ctx) {
        Token op = ctx.CompOp().getSymbol(); // 比较符
        ExprReturnVal leftValue = visit(ctx.expr(0)); // 左值
        ExprReturnVal rightValue = visit(ctx.expr(1)); // 右值
        // 运算时做类型检查
        if(leftValue.getType() != rightValue.getType()){
            io.output("ERROR: unmatched type on two side of <"
                    + op.getText()
                    + "> in line "
                    + op.getLine()
                    +":"
                    + op.getCharPositionInLine());
            return null;
        }
        ExprReturnVal returnVal = new ExprReturnVal();
        returnVal.setType(Type.tBool);
        if(op.getText().equals(">")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() > (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() > (Double) rightValue.getValue());
            }
        }else if(op.getText().equals("<")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() < (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() < (Double) rightValue.getValue());
            }
        }else if(op.getText().equals(">=")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() >= (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() >= (Double) rightValue.getValue());
            }
        }else if(op.getText().equals("<=")){
            if(leftValue.getType() == Type.tInt){
                returnVal.setValue((Integer)leftValue.getValue() <= (Integer)rightValue.getValue());
            }else {
                returnVal.setValue((Double)leftValue.getValue() <= (Double) rightValue.getValue());
            }
        }else if(op.getText().equals("==")){
            returnVal.setValue(leftValue.getValue() == rightValue.getValue());
        }else if(op.getText().equals("!=") || op.getText().equals("<>")){
            returnVal.setValue(leftValue.getValue() != rightValue.getValue());
        }

        return returnVal;
    }

    @Override
    public ExprReturnVal visitParenthesesExpr(CmmParser.ParenthesesExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public ExprReturnVal visitValueExpr(CmmParser.ValueExprContext ctx) {

        if(ctx.value().constant() != null){ // 直接是字面值的运算
            if(ctx.value().constant().IntConstant() != null){
                return new ExprReturnVal(Type.tInt,
                        Integer.valueOf(ctx.value().constant().IntConstant().getText()));
            }else{
                return new ExprReturnVal(Type.tReal,
                        Double.valueOf(ctx.value().constant().RealConstant().getText()));
            }
        }else if(ctx.value().Ident() != null){ // 表达式里包含变量
            Token varToken = ctx.value().Ident().getSymbol();
            String name = varToken.getText();
            Symbol varSymbol = currentScope.resolve(name);
            if(varSymbol != null ){
                return new ExprReturnVal(varSymbol.getType(), varSymbol.getValue());
            }else{
                io.output("ERROR: no such variable <"
                        + name
                        + "> in line "
                        + varToken.getLine()
                        + ":" + varToken.getCharPositionInLine());
                return null;
            }
        }else{ // 表达式里面包含数组
            Token varToken = ctx.value().array().Ident().getSymbol();
            String name = varToken.getText();
            int varIndex;
            if(ctx.value().array().IntConstant() != null){ // 索引为int常量
                varIndex = Integer.parseInt(ctx.value().array().IntConstant().getText());
            }else{ // 索引为表达式
                ExprComputeVisitor indexComputeVisitor = new ExprComputeVisitor(currentScope, io);
                ExprReturnVal indexValue = indexComputeVisitor.visit(ctx.value().array().expr());
                varIndex = (Integer) indexValue.getValue();
            }
            Symbol varSymbol = currentScope.resolve(name);
            if(varSymbol != null ){
                if(varSymbol.getType() == Type.tIntArray){ // int数组

                    int[] varArray = (int[]) varSymbol.getValue();

                    // 数组越界检查
                    if(varIndex < varArray.length){
                        return new ExprReturnVal(Type.tInt, varArray[varIndex]);
                    }else{
                        io.output("ERROR: index out of boundary of array <"
                                + name
                                + "> in line "
                                + varToken.getLine()
                                + ":" + varToken.getCharPositionInLine());
                        return null;
                    }

                }else{ // double数组

                    double[] varArray = (double[]) varSymbol.getValue();

                    // 数组越界检查
                    if(varIndex < varArray.length){
                        return new ExprReturnVal(Type.tReal, varArray[varIndex]);
                    }else{
                        io.output("ERROR: index out of boundary of array <"
                                + name
                                + "> in line "
                                + varToken.getLine()
                                + ":" + varToken.getCharPositionInLine());
                        return null;
                    }

                }
            }else{
                io.output("ERROR: no such variable <"
                        + name
                        + "> in line "
                        + varToken.getLine()
                        + ":" + varToken.getCharPositionInLine());
                return null;
            }
        }

    }

    @Override
    public ExprReturnVal visitSignExpr(CmmParser.SignExprContext ctx) {
        String sign = ctx.AddMin().getSymbol().getText();
        if(sign.equals("+")){
            return visit(ctx.expr());
        }else{
            ExprReturnVal value = visit(ctx.expr());
            if(value.getType() == Type.tInt){
                return new ExprReturnVal(value.getType(), -(Integer)value.getValue());
            }else{
                return new ExprReturnVal(value.getType(), -(Double)value.getValue());
            }

        }
    }
}
