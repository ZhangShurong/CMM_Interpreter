package interpreter;


import gen.CMMBaseVisitor;
import gen.CMMParser;
import io.IOInterface;
import org.antlr.v4.runtime.Token;

/**
 * Created by vergil on 2016/12/7.
 */
public class ExprCalculator extends CMMBaseVisitor<ReturnValue> {
    Scope currentScope;
    private IOInterface io;

    private double btod(ReturnValue boolExpr)
    {
        if(boolExpr.getValue().equals("false"))
            return 0.0;
        else
            return 1.0;
    }
    private int comp(ReturnValue left, ReturnValue right)
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
    public ExprCalculator(Scope currentScope, IOInterface io) {
        this.currentScope = currentScope;
        this.io = io;
    }

    @Override
    public ReturnValue visitMultiplication(CMMParser.MultiplicationContext ctx) {
        Token op = ctx.MULT().getSymbol();
        ReturnValue leftValue = visit(ctx.mulDiv());
        ReturnValue rightValue = visit(ctx.unaryMinus());

        ReturnValue returnVal = new ReturnValue();

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

    public ReturnValue visitDivision(CMMParser.DivisionContext ctx)
    {
        Token op = ctx.DIV().getSymbol();
        ReturnValue leftValue = visit(ctx.mulDiv());
        ReturnValue rightValue = visit(ctx.unaryMinus());
        if((Integer)rightValue.getValue(Type.tInt) == 0)
        {
            Error.divide_by_zero_error(io,op.getText(),op.getLine(),op.getCharPositionInLine());
            return null;
        }
        ReturnValue returnVal = new ReturnValue();

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
            Error.unmatched_type_error(io,op.getText(),op.getLine(),op.getCharPositionInLine());
        }
        return returnVal;
    }

    public ReturnValue visitTounaryMinus(CMMParser.TounaryMinusContext ctx)
    {
        return visit(ctx.unaryMinus());
    }

    public ReturnValue visitChangeSign(CMMParser.ChangeSignContext ctx) {
        ReturnValue rightvalue = visit(ctx.unaryMinus());
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
    public ReturnValue visitToAtom(CMMParser.ToAtomContext ctx)
    {
        return visit(ctx.atom());
    }

    public ReturnValue visitIdentifier(CMMParser.IdentifierContext ctx)
    {
        Token indent = ctx.IDENT().getSymbol();
        String varname = indent.getText();
        if(varname.equals("true"))
        {
            return new ReturnValue(Type.tBool, 1);
        }
        if(varname.equals("false"))
        {
            return new ReturnValue(Type.tBool, 0);
        }
        Symbol varSymbol = currentScope.resolve(varname);
        if(varSymbol != null ){
            if(varSymbol.getValue() == null)
            {
                Error.uninitialized_error(io,indent.getText(),indent.getLine(),indent.getCharPositionInLine());
                return null;
            }
            return new ReturnValue(varSymbol.getType(), varSymbol.getValue());
        }else{
            Error.undeclared_var_error(io,indent.getText(), indent.getLine(),indent.getCharPositionInLine());
            return null;
        }
    }

    public ReturnValue visitToConstant(CMMParser.ToConstantContext ctx)
    {

            if(ctx.constant().INTCONSTANT() != null){
                try {
                    return new ReturnValue(Type.tInt,
                            Integer.valueOf(ctx.constant().INTCONSTANT().getText()));
                }catch (NumberFormatException e) {
                    Token token = ctx.constant().INTCONSTANT().getSymbol();
                    Error.variableoverflow_error(io, ctx.getText(),token.getLine(),token.getCharPositionInLine());
                }
            }
            else if(ctx.constant().DOUBLECONSTANT() != null) {
                Token token = ctx.constant().DOUBLECONSTANT().getSymbol();
                try {
                    return new ReturnValue(Type.tDouble,
                            Double.valueOf(ctx.constant().DOUBLECONSTANT().getText()));
                }catch (NumberFormatException e)
                {
                    Error.variableoverflow_error(io, ctx.getText(),token.getLine(),token.getCharPositionInLine());
                }
            }
            else if(ctx.constant().FALSE() != null) {
                return new ReturnValue(Type.tInt,0);
            }
            else if(ctx.constant().TRUE() != null) {
                return new ReturnValue(Type.tInt,1);
            }
            else if(ctx.constant().STRINGCONSTANT() != null)
            {
                String str = ctx.constant().STRINGCONSTANT().toString();
                return new ReturnValue(Type.tString, str.substring(1,str.length()-1));
            }
            else{
                io.stderr("ERROR");
                return new ReturnValue(Type.tInt,0);
            }
        return null;
    }
    public ReturnValue visitToArray(CMMParser.ToArrayContext ctx)
    {
        Token token = ctx.array().IDENT().getSymbol();
        String varname = token.getText();
        int varIndex;

        //like a[3]
        if(ctx.array().INTCONSTANT() != null){
            varIndex = Integer.parseInt(ctx.array().INTCONSTANT().getText());
        }else{//like a[3+b]
            ExprCalculator indexComputeVisitor = new ExprCalculator(currentScope, io);
            ReturnValue indexValue = indexComputeVisitor.visit(ctx.array().expr());
            varIndex = (Integer) indexValue.getValue();
        }

        Symbol varSymbol = currentScope.resolve(varname);
        if(varSymbol != null ){
            if(varSymbol.getType() == Type.tIntArray){ // int数组
                int[] varArray = (int[]) varSymbol.getValue();
                if(varIndex < varArray.length){
                    return new ReturnValue(Type.tInt, varArray[varIndex]);
                }else{
                    io.stderr("ERROR");
                    return null;
                }

            }else{ // double数组

                double[] varArray = (double[]) varSymbol.getValue();

                // 数组越界检查
                if(varIndex < varArray.length){
                    return new ReturnValue(Type.tDouble, varArray[varIndex]);
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
    public ReturnValue visitToExpr(CMMParser.ToExprContext ctx)
    {
        ExprCalculator indexComputeVisitor = new ExprCalculator(currentScope, io);
        ReturnValue returnvalue = indexComputeVisitor.visit(ctx.expr());
        return returnvalue;
    }

    public ReturnValue visitPlus(CMMParser.PlusContext ctx) {
        ReturnValue left = visit(ctx.addMin());
        ReturnValue right = visit(ctx.mulDiv());
        ReturnValue returnVal = null;
        if(left.getType() == Type.tString || right.getType() == Type.tString)
        {
            returnVal = new ReturnValue();
            returnVal.setType(Type.tString);
            returnVal.setValue(left.getValue().toString()+ right.getValue().toString());
        }
        else
        {
            if(left.getType() != Type.tBool && right.getType() != Type.tBool) {
                returnVal = new ReturnValue();
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
        }

        if(returnVal == null)
        {
            io.stderr("Error");
        }
        return  returnVal;
    }

    public ReturnValue visitMinus(CMMParser.MinusContext ctx)
    {
        ReturnValue left = visit(ctx.addMin());
        ReturnValue right = visit(ctx.mulDiv());
        ReturnValue returnVal = null;
        if(left.getType() != Type.tBool && right.getType() != Type.tBool) {
            returnVal = new ReturnValue();
            if (left.getType() == Type.tDouble || right.getType() == Type.tDouble) {
                returnVal.setType(Type.tDouble);
                returnVal.setValue((Double) left.getValue(Type.tDouble) - (Double) right.getValue(Type.tDouble));
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
    public ReturnValue visitEExpr(CMMParser.EExprContext ctx) {
        ReturnValue left = visit(ctx.expr());
        ReturnValue right  = visit(ctx.addMin());
        ReturnValue returnVal = new ReturnValue();
        returnVal.setType(Type.tBool);
        int res = comp(left,right);
        if(res == 0)
            returnVal.setValue(1);
        else
            returnVal.setValue(0);
        return returnVal;
    }
    //小于等于
    public ReturnValue visitSEExpr(CMMParser.SEExprContext ctx)
    {
        ReturnValue left = visit(ctx.expr());
        ReturnValue right  = visit(ctx.addMin());
        ReturnValue returnVal = new ReturnValue();
        returnVal.setType(Type.tBool);
        int res = comp(left,right);
        if(res == 0 || res == -1)
            returnVal.setValue(1);
        else
            returnVal.setValue(0);
        return returnVal;
    }
    //小于
    public ReturnValue visitSTExpr(CMMParser.STExprContext ctx) {
        ReturnValue left = visit(ctx.expr());
        ReturnValue right  = visit(ctx.addMin());
        ReturnValue returnVal = new ReturnValue();
        returnVal.setType(Type.tBool);
        int res = comp(left,right);
        if(res == -1 )
            returnVal.setValue(1);
        else
            returnVal.setValue(0);
        return returnVal;
    }
    //大于
    public ReturnValue visitGTExpr(CMMParser.GTExprContext ctx) {
        ReturnValue left = visit(ctx.expr());
        ReturnValue right  = visit(ctx.addMin());
        ReturnValue returnVal = new ReturnValue();
        returnVal.setType(Type.tBool);
        int res = comp(left,right);
        if(res == 1)
            returnVal.setValue(1);
        else
            returnVal.setValue(0);
        return returnVal;
    }
    //大于等于
    public ReturnValue visitGEExpr(CMMParser.GEExprContext ctx) {
        ReturnValue left = visit(ctx.expr());
        ReturnValue right  = visit(ctx.addMin());
        ReturnValue returnVal = new ReturnValue();
        returnVal.setType(Type.tBool);
        int res = comp(left,right);
        if(res == 0 || res == 1)
            returnVal.setValue(1);
        else
            returnVal.setValue(0);
        return returnVal;
    }

    //不等于
    public ReturnValue visitNEExpr(CMMParser.NEExprContext ctx) {
        ReturnValue left = visit(ctx.expr());
        ReturnValue right  = visit(ctx.addMin());
        ReturnValue returnVal = new ReturnValue();
        returnVal.setType(Type.tBool);
        int res = comp(left,right);
        if(res == 0 )
            returnVal.setValue(0);
        else
            returnVal.setValue(1);
        return returnVal; }
}
