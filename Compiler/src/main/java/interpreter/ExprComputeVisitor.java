package interpreter;


import gen.CMMBaseVisitor;
import gen.CMMParser;
import io.IOInterface;
import org.antlr.v4.runtime.Token;

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
            if(left.getType() == Type.tInt)
                leftvalue = (Integer)left.getValue();
            else
                leftvalue = (Double) left.getValue();
        }
        if(right.getType() == Type.tBool)
        {
            rightvalue = btod(right);
        }
        else{
            if(right.getType() == Type.tInt)
                rightvalue = (Integer)right.getValue();
            else {
                rightvalue = (Double) right.getValue();
            }
        }


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
            io.stderr("ERROR: unmatched or uncast type on two side of <"
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
            io.stderr("ERROR: unmatched or uncast type on two side of <"
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
            io.stderr("ERROR");
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
            io.stderr("ERROR");
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
                    Double.valueOf(ctx.constant().DOUBLECONSTANT().getText()));
        }
        else if(ctx.constant().FALSE() != null) {
            return new ExprReturnVal(Type.tInt,0);
        }
        else if(ctx.constant().TRUE() != null) {
            return new ExprReturnVal(Type.tInt,1);
        }
        else{
            io.stderr("ERROR");
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
                    io.stderr("ERROR");
                    return null;
                }

            }else{ // double数组

                double[] varArray = (double[]) varSymbol.getValue();

                // 数组越界检查
                if(varIndex < varArray.length){
                    return new ExprReturnVal(Type.tDouble, varArray[varIndex]);
                }else{
                    io.stderr("ERROR");
                    return null;
                }

            }
        }else{
            io.stderr("ERROR");
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
            io.stderr("Bool error");
        }
        if(returnVal == null)
        {
            io.stderr("Error");
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
            io.stderr("Bool error");
        }
        if(returnVal == null)
        {
            io.stderr("Error");
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
}
