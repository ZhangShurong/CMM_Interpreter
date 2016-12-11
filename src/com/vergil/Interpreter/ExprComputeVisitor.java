package com.vergil.Interpreter;

import com.vergil.Utils.IOInterface;
import gen.CMMBaseVisitor;
import gen.CMMParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.misc.DoubleKeyMap;

/**
 * Created by vergil on 2016/12/7.
 */
public class ExprComputeVisitor extends CMMBaseVisitor<ExprReturnVal> {
    Scope currentScope;
    private IOInterface io;

    private double btod(ExprReturnVal boolExpr)
    {
        if(boolExpr.getValue().equals("false"))
            return 0.0;
        else
            return 1.0;
    }
    private int comp(ExprReturnVal left, ExprReturnVal right)
    {
        double leftvalue = 0.0;
        double rightvalue = 0.0;
        if(left.getType() == Type.tBool)
        {
            leftvalue = btod(left);
        }
        else
        {
            leftvalue = (Double)left.getValue();
        }
        if(right.getType() == Type.tBool)
        {
            rightvalue = btod(right);
        }
        else
            rightvalue = (Double)right.getValue();

        if(leftvalue == rightvalue)
            return 0;
        else if(leftvalue > rightvalue)
            return 1;
        else
            return -1;
    }
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

        assert (op.getText().equals("*"));

        if(leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tDouble);

            returnVal.setValue((Double)leftValue.getValue() * (Integer) rightValue.getValue());
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tDouble){

            returnVal.setType(Type.tDouble);
            returnVal.setValue((Integer)leftValue.getValue() * (Double) rightValue.getValue());
        }else if(leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tDouble){
            returnVal.setType(Type.tDouble);
            returnVal.setValue((Double)leftValue.getValue() * (Double) rightValue.getValue());
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tInt);
            returnVal.setValue((Integer)leftValue.getValue() * (Integer) rightValue.getValue());
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

    public ExprReturnVal visitDivision(CMMParser.DivisionContext ctx)
    {
        Token op = ctx.DIV().getSymbol();
        ExprReturnVal leftValue = visit(ctx.mulDiv());
        ExprReturnVal rightValue = visit(ctx.unaryMinus());
        ExprReturnVal returnVal = new ExprReturnVal();

        if(leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tDouble);
            returnVal.setValue((Double)leftValue.getValue() / (Integer) rightValue.getValue());
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tDouble){
            returnVal.setType(Type.tDouble);
            returnVal.setValue((Integer)leftValue.getValue() / (Double) rightValue.getValue());
        }else if(leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tDouble){
            returnVal.setType(Type.tDouble);
            returnVal.setValue((Double)leftValue.getValue() / (Double) rightValue.getValue());
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tInt);
            returnVal.setValue((Integer)leftValue.getValue() / (Integer) rightValue.getValue());
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

    public ExprReturnVal visitTounaryMinus(CMMParser.TounaryMinusContext ctx)
    {
        return visit(ctx.unaryMinus());
    }

    public ExprReturnVal visitChangeSign(CMMParser.ChangeSignContext ctx) {
        ExprReturnVal rightvalue = visit(ctx.unaryMinus());
        if(rightvalue.getType() == Type.tDouble)
            rightvalue.setValue(-(Double)rightvalue.getValue());
        else if(rightvalue.getType() == Type.tInt) {
            rightvalue.setValue(-(Integer) rightvalue.getValue());
        }
        else{
            io.output("ERROR");
        }
        return rightvalue;
    }
    public ExprReturnVal visitToAtom(CMMParser.ToAtomContext ctx)
    {
        return visit(ctx.atom());
    }

    public ExprReturnVal visitIdentifier(CMMParser.IdentifierContext ctx)
    {
        Token indent = ctx.IDENT().getSymbol();
        String varname = indent.getText();
        Symbol varSymbol = currentScope.resolve(varname);
        if(varSymbol != null ){
            return new ExprReturnVal(varSymbol.getType(), varSymbol.getValue());
        }else{
            io.output("ERROR");
            return null;
        }
    }

    public ExprReturnVal visitToConstant(CMMParser.ToConstantContext ctx)
    {
        if(ctx.constant().INTCONSTANT() != null){
            return new ExprReturnVal(Type.tInt,
                    Integer.valueOf(ctx.constant().INTCONSTANT().getText()));
        }
        else if(ctx.constant().DOUBLECONSTANT() != null) {
            return new ExprReturnVal(Type.tDouble,
                    Double.valueOf(ctx.constant().INTCONSTANT().getText()));
        }
        else if(ctx.constant().FALSE() != null) {
            return new ExprReturnVal(Type.tInt,0);
        }
        else if(ctx.constant().TRUE() != null) {
            return new ExprReturnVal(Type.tInt,1);
        }
        else{
            io.output("ERROR");
            return new ExprReturnVal(Type.tInt,0);
        }
    }
    public ExprReturnVal visitToArray(CMMParser.ToArrayContext ctx)
    {
        Token token = ctx.array().IDENT().getSymbol();
        String varname = token.getText();
        int varIndex;

        //like a[3]
        if(ctx.array().INTCONSTANT() != null){
            varIndex = Integer.parseInt(ctx.array().INTCONSTANT().getText());
        }else{//like a[3+b]
            ExprComputeVisitor indexComputeVisitor = new ExprComputeVisitor(currentScope, io);
            ExprReturnVal indexValue = indexComputeVisitor.visit(ctx.array().expr());
            varIndex = (Integer) indexValue.getValue();
        }

        Symbol varSymbol = currentScope.resolve(varname);
        if(varSymbol != null ){
            if(varSymbol.getType() == Type.tIntArray){ // int数组
                int[] varArray = (int[]) varSymbol.getValue();
                if(varIndex < varArray.length){
                    return new ExprReturnVal(Type.tInt, varArray[varIndex]);
                }else{
                    io.output("ERROR");
                    return null;
                }

            }else{ // double数组

                double[] varArray = (double[]) varSymbol.getValue();

                // 数组越界检查
                if(varIndex < varArray.length){
                    return new ExprReturnVal(Type.tDouble, varArray[varIndex]);
                }else{
                    io.output("ERROR");
                    return null;
                }

            }
        }else{
            io.output("ERROR");
            return null;
        }
    }
    public ExprReturnVal visitToExpr(CMMParser.ToExprContext ctx)
    {
        ExprComputeVisitor indexComputeVisitor = new ExprComputeVisitor(currentScope, io);
        ExprReturnVal returnvalue = indexComputeVisitor.visit(ctx.expr());
        return returnvalue;
    }

    public ExprReturnVal visitPlus(CMMParser.PlusContext ctx) {
        Token op = ctx.PLUS().getSymbol();
        ExprReturnVal left = visit(ctx.addMin());
        ExprReturnVal right = visit(ctx.mulDiv());
        ExprReturnVal returnVal = null;
        if(left.getType() != Type.tBool && right.getType() != Type.tBool) {
            returnVal = new ExprReturnVal();
            if (left.getType() == Type.tDouble || right.getType() == Type.tDouble) {
                returnVal.setType(Type.tDouble);
                returnVal.setValue((Double) left.getValue() + (Double) right.getValue());
            }
            else {
                returnVal.setType(Type.tInt);
                returnVal.setValue((Integer) left.getValue() + (Integer) right.getValue());
            }
        }
        else {
            io.output("Bool error");
        }
        if(returnVal == null)
        {
            io.output("Error");
        }
        return  returnVal;
    }

    public ExprReturnVal visitMinus(CMMParser.MinusContext ctx)
    {
        Token op = ctx.MINUS().getSymbol();
        ExprReturnVal left = visit(ctx.addMin());
        ExprReturnVal right = visit(ctx.mulDiv());
        ExprReturnVal returnVal = null;
        if(left.getType() != Type.tBool && right.getType() != Type.tBool) {
            returnVal = new ExprReturnVal();
            if (left.getType() == Type.tDouble || right.getType() == Type.tDouble) {
                returnVal.setType(Type.tDouble);
                returnVal.setValue((Double) left.getValue() - (Double) right.getValue());
            }
            else {
                returnVal.setType(Type.tInt);
                returnVal.setValue((Integer) left.getValue() - (Integer) right.getValue());
            }
        }
        else {
            io.output("Bool error");
        }
        if(returnVal == null)
        {
            io.output("Error");
        }
        return  returnVal;
    }

    //相等
    public  ExprReturnVal visitEExpr(CMMParser.EExprContext ctx) {
        ExprReturnVal left = visit(ctx.expr());
        ExprReturnVal right  = visit(ctx.addMin());
        ExprReturnVal returnVal = new ExprReturnVal();
        returnVal.setValue(Type.tBool);
        int res = comp(left,right);
        if(res == 0)
            returnVal.setValue(1);
        else
            returnVal.setValue(0);
        return returnVal;
    }
    //小于等于
    public ExprReturnVal visitSEExpr(CMMParser.SEExprContext ctx)
    {
        ExprReturnVal left = visit(ctx.expr());
        ExprReturnVal right  = visit(ctx.addMin());
        ExprReturnVal returnVal = new ExprReturnVal();
        returnVal.setValue(Type.tBool);
        int res = comp(left,right);
        if(res == 0 || res == -1)
            returnVal.setValue(1);
        else
            returnVal.setValue(0);
        return returnVal;
    }
    //小于
    public ExprReturnVal visitSTExpr(CMMParser.STExprContext ctx) {
        ExprReturnVal left = visit(ctx.expr());
        ExprReturnVal right  = visit(ctx.addMin());
        ExprReturnVal returnVal = new ExprReturnVal();
        returnVal.setValue(Type.tBool);
        int res = comp(left,right);
        if(res == -1 )
            returnVal.setValue(1);
        else
            returnVal.setValue(0);
        return returnVal;
    }
    //大于
    public ExprReturnVal visitGTExpr(CMMParser.GTExprContext ctx) {
        ExprReturnVal left = visit(ctx.expr());
        ExprReturnVal right  = visit(ctx.addMin());
        ExprReturnVal returnVal = new ExprReturnVal();
        returnVal.setValue(Type.tBool);
        int res = comp(left,right);
        if(res == 1)
            returnVal.setValue(1);
        else
            returnVal.setValue(0);
        return returnVal;
    }
    //大于等于
    public ExprReturnVal visitGEExpr(CMMParser.GEExprContext ctx) {
        ExprReturnVal left = visit(ctx.expr());
        ExprReturnVal right  = visit(ctx.addMin());
        ExprReturnVal returnVal = new ExprReturnVal();
        returnVal.setValue(Type.tBool);
        int res = comp(left,right);
        if(res == 1 || res == 1)
            returnVal.setValue(1);
        else
            returnVal.setValue(0);
        return returnVal;
    }

    //不等于
    public ExprReturnVal visitNEExpr(CMMParser.NEExprContext ctx) {
        ExprReturnVal left = visit(ctx.expr());
        ExprReturnVal right  = visit(ctx.addMin());
        ExprReturnVal returnVal = new ExprReturnVal();
        returnVal.setValue(Type.tBool);
        int res = comp(left,right);
        if(res == 0 )
            returnVal.setValue(0);
        else
            returnVal.setValue(1);
        return returnVal; }


    /**

    /*
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
    */
}
