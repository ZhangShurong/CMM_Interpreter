package interpreter;


import gen.CMMBaseVisitor;
import gen.CMMParser;
import io.IOInterface;
import org.antlr.v4.runtime.FailedPredicateException;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.RuntimeMetaData;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.Stack;

import static interpreter.DefPhase.gettypebystr;

/**
 * Created by vergil on 2016/12/7.
 */
public class RefPhase extends CMMBaseVisitor<ReturnValue> {
    private IOInterface io;

    //储存符号表与节点信息
    public static ParseTreeProperty<SymbolTab> scopes = new ParseTreeProperty<SymbolTab>();;

    SymbolTab symbolTab;

    Stack whilestack;
    boolean meetBreak=false;

    public RefPhase(IOInterface io) {
        this.io = io;
        whilestack = new Stack();
    }

    private Integer isExprTrue(CMMParser.ExprContext ctx){
        ReturnValue value = visit(ctx);
        if(value == null)
        {
            Error.fatal_null_error(io,ctx.getStart());
        }
        if(value.getValue() == null)
        {
            Error.fatal_null_error(io,ctx.getStart());
        }
        if(value.getType() == Type.tBool){
            return (Integer) value.getValue();
        }else{
            if(value.getType() == Type.tDouble)
                return (Double)value.getValue() != 0?1:0;
            else if(value.getType() == Type.tInt)
                return (Integer)value.getValue() != 0?1:0;
            else {
                Error.fatal_unknown_error(io,ctx.getStart());
            }
        }
        return 0;
    }
    @Override
    public ReturnValue visitProgram(CMMParser.ProgramContext ctx) {
        symbolTab = scopes.get(ctx);
        super.visitProgram(ctx);
        return null;
    }


    @Override
    public ReturnValue visitStmtBlock(CMMParser.StmtBlockContext ctx) {
        symbolTab = scopes.get(ctx);
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
        symbolTab.clear();
        symbolTab = symbolTab.getEnclosingSymbolTab();
        return null;
    }

    public ReturnValue visitVarList(CMMParser.VarListContext ctx)
    {
        String typeStr = ctx.getParent().getChild(0).getText();

        // 数组
        for(CMMParser.ArrayContext arrayContext: ctx.array()){
            String name = arrayContext.IDENT().getSymbol().getText();
            int size;
            try {
                size = Integer.parseInt(arrayContext.INTCONSTANT().getText());
            }catch (Exception e)
            {
                Error.variableoverflow_error(io,arrayContext.INTCONSTANT().getSymbol());
                io.stderr("Fatal Error: index is too big");
                throw new RuntimeException("Fatal Error!");
            }
            if(symbolTab.redundant(name)){
                Error.conflict_declar_error(io, arrayContext.IDENT().getSymbol());
            }else{
                if(typeStr.equals("int")){
                    symbolTab.define(new Symbol(name, Type.tIntArray, new int[size]));
                }else if(typeStr.equals("double")){
                    symbolTab.define(new Symbol(name, Type.tDoubleArray, new double[size]));
                }
                else {
                    Token token = arrayContext.IDENT().getSymbol();
                    Error.unsupport_array_type_error(io,token);
                    io.stderr("Fatal Error: unsupport array type");
                    throw new RuntimeException("Fatal Error!");
                }
            }
        }

        for(TerminalNode node : ctx.getTokens(CMMParser.IDENT)){
            if(symbolTab.redundant(node.getSymbol().getText())){
                Error.conflict_declar_error(io, node.getSymbol());
            }else{
                Type type = gettypebystr(typeStr);
                if(type == null)
                {
                    Error.fatal_unknown_error(io,node.getSymbol());
                }
                symbolTab.define(new Symbol(node.getSymbol().getText(),
                        type));
            }
        }
        // 声明时赋值
        for(CMMParser.DelassignContext decl_assignContext : ctx.delassign()){
            Token token = decl_assignContext.IDENT().getSymbol();
            if(symbolTab.redundant(token.getText())){
                Error.conflict_declar_error(io, token);
            }else{
                Type type = gettypebystr(typeStr);
                if(type!=null)
                    symbolTab.define(new Symbol(token.getText(), type));
                else
                {
                    Error.fatal_unknown_error(io,token);
                }

            }

        }
        visitChildren(ctx);
        return null;
    }
    public ReturnValue visitDelassign(CMMParser.DelassignContext ctx)
    {
        super.visitDelassign(ctx);
        Token token = ctx.IDENT().getSymbol();
        String varName = token.getText();
        Symbol var = symbolTab.resolve(varName);
        if(var == null){
            Error.fatal_unknown_error(io,token);
        }else{
            ReturnValue value = visit(ctx.expr());
            if(value == null || value.getType() == null)
            {
                Error.fatal_unknown_error(io,ctx.EQUAL().getSymbol());
            }
            else {
                if(value.getValue() == null)
                {
                    Error.fatal_null_error(io,token);
                }
                var.setValue(value.getValue(var.getType()));
            }
        }
        return null;
    }

    //形如 a = 3; 或者 a[1] = 4;
    @Override
    public ReturnValue visitAssignStmt(CMMParser.AssignStmtContext ctx) {
        super.visitAssignStmt(ctx);
        if(ctx.value().IDENT() == null){//说明左边是数组
            Token token = ctx.value().array().IDENT().getSymbol();
            String varName = token.getText();
            Symbol leftValue = symbolTab.resolve(varName);
            if(leftValue == null){
                Error.undeclared_var_error(io, token);
                return null;
            }else{
                ReturnValue rightValue = visit(ctx.expr());
                if(rightValue == null)
                {
                    Error.fatal_null_error(io,ctx.EQUAL().getSymbol());
                }
                else if(rightValue.getType() == Type.tString)
                {
                    io.stderr("Fatla Error: Try to assign a array with string!");
                    throw new RuntimeException("Fatla Error: Try to assign a array with string!");
                }
                //计算数组index
                int varIndex;
                if(ctx.value().array().INTCONSTANT() != null){
                    try {
                        varIndex = Integer.parseInt(ctx.value().array().INTCONSTANT().getText());
                    }
                    catch (NumberFormatException e) {
                        Error.variableoverflow_error(io, ctx.value().array().INTCONSTANT().getSymbol());
                        Warning.force_zore_warning(io, ctx.value().array().INTCONSTANT().getSymbol());
                        varIndex = 0;
                    }
                }else{
                    ReturnValue indexValue = visit(ctx.value().array().expr());
                    if(indexValue == null) {
                        Error.fatal_null_error(io,ctx.EQUAL().getSymbol());
                    }
                    if(indexValue.getType() != Type.tInt){
                        Error.invalid_type_error(io,token);
                        io.stderr("Warning: The index will be set to zero!");
                        varIndex = 0;
                    }
                    else
                        varIndex = (Integer) indexValue.getValue();
                }

                //开始赋值
                if(leftValue.getType() == Type.tIntArray){
                    int[] varArray = (int[]) leftValue.getValue();
                    if(0 <= varIndex && varIndex < varArray.length){
                        if(rightValue.getValue(Type.tInt) != null)
                        {
                            if(!(rightValue.getValue() instanceof  Integer)){
                                Warning.unmatched_type_warning(io,token);
                            }
                            varArray[varIndex] = (Integer) rightValue.getValue(Type.tInt);
                        }
                        else{
                            Error.fatal_null_error(io,ctx.EQUAL().getSymbol());
                        }
                    }else{
                        Error.out_of_boundary_error(io, token);
                        return null;
                    }
                }else if(leftValue.getType() == Type.tDoubleArray){
                    double[] varArray = (double[]) leftValue.getValue();
                    if(0 <= varIndex && varIndex < varArray.length){
                        if(rightValue.getValue(Type.tDouble) != null)
                        {
                            if(!(rightValue.getValue() instanceof  Double)){
                                Warning.unmatched_type_warning(io,token);
                            }
                            varArray[varIndex] = (Double) rightValue.getValue(Type.tDouble);
                        }
                        else{
                            Error.fatal_null_error(io,ctx.EQUAL().getSymbol());
                        }
                    }else{
                        Error.out_of_boundary_error(io, token);
                        return null;
                    }
                }
                else {
                    Error.fatal_unknown_error(io,ctx.EQUAL().getSymbol());
                }
            }
        }else{
            Token token = ctx.value().IDENT().getSymbol();
            String varName = token.getText();
            Symbol leftValue = symbolTab.resolve(varName);
            if(leftValue == null){
                Error.undeclared_var_error(io,token);
                return null;
            }else{
                ReturnValue value = visit(ctx.expr());
                if(value == null)
                {
                    Error.fatal_null_error(io,ctx.EQUAL().getSymbol());
                }
                Token assign = ctx.EQUAL().getSymbol();
                if(value.getValue(value.getType()) == null)
                {
                    Error.fatal_unknown_error(io,assign);
                }
                else {
                    leftValue.setValue(value.getValue(leftValue.getType()));
                }
            }
        }
        return null;
    }

    @Override
    public ReturnValue visitReadStmt(CMMParser.ReadStmtContext ctx) {
        super.visitReadStmt(ctx);
        Token token;
        String input = "";
        if(ctx.IDENT() == null){
            token = ctx.array().IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = symbolTab.resolve(varName);
            if(var == null){
                Error.undeclared_var_error(io, token);
                return null;
            }
            int varIndex;
            try {
                varIndex = Integer.parseInt(ctx.array().INTCONSTANT().getText());
            }catch (NumberFormatException e)
            {
                Error.variableoverflow_error(io,ctx.array().INTCONSTANT().getSymbol());
                Warning.force_zore_warning(io,token);
                varIndex = 0;
            }

            if(var.getType() == Type.tIntArray){
                //TODO 当value为空时没有测试
                int[] varArray = (int[]) var.getValue();
                if(0 <= varIndex && varIndex < varArray.length){
                    input = io.stdin("请输入一个整数");
                    if(input == null)
                    {
                        io.stderr("You canceled the input, input was set to ZERO\n");
                        input = "0";
                    }
                    int in;
                    try {
                        in = Integer.parseInt(input);
                    }catch (NumberFormatException e)
                    {
                        Error.variableoverflow_error(io,token);
                        Warning.force_zore_warning(io,token);
                        in = 0;
                    }
                    varArray[varIndex] = in;
                }else{
                    Error.out_of_boundary_error(io,token);
                }
            }else if (var.getType() == Type.tDoubleArray){
                //TODO 当value为空时没有测试
                double[] varArray = (double[]) var.getValue();

                if(0 <= varIndex && varIndex < varArray.length){
                    input = io.stdin("请输入一个双精度数");
                    if(input == null)
                    {
                        io.stderr("You canceled the input, input was set to ZERO\n");
                        input = "0.0";
                    }
                    Double in;
                    try {
                        in = Double.parseDouble(input);
                    }catch (NumberFormatException e)
                    {
                        Error.variableoverflow_error(io,token);
                        Warning.force_zore_warning(io,token);
                        in = 0.0;
                    }
                    varArray[varIndex] = in;
                }else{
                    Error.out_of_boundary_error(io,token);
                }
            }
            else {
                Error.fatal_unknown_error(io,token);
            }
        }
        else {
            token = ctx.IDENT().getSymbol();
            String varName = token.getText();
            Symbol var = symbolTab.resolve(varName);
            if(var == null){
                Error.undeclared_var_error(io, token);
                return null;
            }
            if(var.getType() == Type.tInt){
                input = io.stdin("请输入一个整数");
                if(input == null)
                {
                    io.stderr("You canceled the input, input was set to ZERO\n");
                    input = "0";
                }
                int in;
                try {
                    in = Integer.parseInt(input);
                }catch (NumberFormatException e) {
                    Error.variableoverflow_error(io, token);
                    Warning.force_zore_warning(io, token);
                    in = 0;
                }
                var.setValue(in);
            }
            else if(var.getType() == Type.tDouble){
                input = io.stdin("请输入一个浮点数");
                if(input == null)
                {
                    io.stderr("You canceled the input, input was set to ZERO\n");
                    input = "0";
                }
                Double in;
                try {
                    in = Double.parseDouble(input);
                }catch (NumberFormatException e)
                {
                    Error.variableoverflow_error(io,token);
                    Warning.force_zore_warning(io,token);
                    in = 0.0;
                }
                var.setValue(in);
            }
            else if(var.getType() == Type.tString)
            {
                input = io.stdin("请输入：");
                if(input == null)
                {
                    io.stderr("You canceled the input, input was set to NULL\n");
                    input = "";
                }
                var.setValue("\"" + input + "\"");
            }
            else if (var.getType() == Type.tBool)
            {
                input = io.stdin("请输入一个0或1");
                if(input == null)
                {
                    io.stderr("You canceled the input, input was set to ZERO\n");
                    input = "0";
                }
                int in;
                try {
                    in = Integer.parseInt(input);
                }catch (NumberFormatException e) {
                    Error.variableoverflow_error(io, token);
                    Warning.force_zore_warning(io, token);
                    in = 0;
                }
                var.setValue(in);
            }
            else
            {
                Error.fatal_unknown_error(io,token);
            }

        }
        return null;
    }

    @Override
    public ReturnValue visitWriteStmt(CMMParser.WriteStmtContext ctx) {
        super.visitWriteStmt(ctx);

        ReturnValue returnValue = visit(ctx.expr());
        if(returnValue ==null){
            Error.fatal_null_error(io,ctx.LSBRACKET().getSymbol());
        }
        Object value = returnValue.getValue();
        if(value == null)
        {
            Error.fatal_null_error(io,ctx.LSBRACKET().getSymbol());
        }
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
            if(ctx.stmt() != null){
                visit(ctx.stmt());
            }else{
                visit(ctx.stmtBlock());
            }
            if(!(boolean)whilestack.peek())
                break;
        }
        whilestack.pop();

        return null;
    }

    public ReturnValue visitBreakStmt(CMMParser.BreakStmtContext ctx)
    {
        if(!whilestack.empty()){
            whilestack.pop();
        }
        meetBreak=true;
        whilestack.push(false);
        return super.visitBreakStmt(ctx);
    }


    /*------------------以下为算数计算部分-----------------------*/

    //Bool转Double
    private double btod(ReturnValue boolExpr)
    {
        if(boolExpr.getValue().equals("false"))
            return 0.0;
        else
            return 1.0;
    }

    //比较left与right的大小
    private int comp(ReturnValue left, ReturnValue right)
    {
        if(left == null || right ==null)
        {
            io.stderr("Fatal error: In function comp");
            throw new RuntimeException("Fatal error: In function comp");
        }
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


    @Override
    public ReturnValue visitMultiplication(CMMParser.MultiplicationContext ctx) {
        Token op = ctx.MULT().getSymbol();
        ReturnValue leftValue = visit(ctx.mulDiv());
        ReturnValue rightValue = visit(ctx.unaryMinus());
        if(leftValue == null
                || rightValue == null
                || leftValue.getValue() == null
                || rightValue.getValue() == null)
        {
            Error.fatal_null_error(io,op);
        }
        ReturnValue returnVal = new ReturnValue();

        assert (op.getText().equals("*"));
        if(leftValue.getType() == Type.tString || rightValue.getType() == Type.tString)
        {
            Error.fatal_unsupported_arithmetic_error(io,ctx.MULT().getSymbol());
        }
        else
        {
            if(leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tInt){
                returnVal.setType(Type.tDouble);
                returnVal.setValue((Double)leftValue.getValue(Type.tDouble) * (Double) rightValue.getValue(Type.tDouble));
            }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tDouble){
                returnVal.setType(Type.tDouble);
                returnVal.setValue((Double)leftValue.getValue(Type.tDouble) * (Double) rightValue.getValue(Type.tDouble));
            }else if(leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tDouble){
                returnVal.setType(Type.tDouble);
                returnVal.setValue((Double)leftValue.getValue(Type.tDouble) * (Double) rightValue.getValue(Type.tDouble));
            }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tInt){
                returnVal.setType(Type.tInt);
                returnVal.setValue((Integer)leftValue.getValue() * (Integer) rightValue.getValue());
            }else{
                Error.fatal_unsupported_arithmetic_error(io,op);
            }
        }
        Error._is_fatal_returnval_null_error(io,op,returnVal);
        return returnVal;
    }

    public ReturnValue visitDivision(CMMParser.DivisionContext ctx)
    {
        Token op = ctx.DIV().getSymbol();
        ReturnValue leftValue = visit(ctx.mulDiv());
        ReturnValue rightValue = visit(ctx.unaryMinus());
        if(leftValue == null
                || rightValue == null
                || leftValue.getValue() == null
                || rightValue.getValue() == null)
        {
            Error.fatal_null_error(io,op);
        }
        if(leftValue == null || rightValue == null)
        {
            Error.fatal_null_error(io,op);
        }
        if((Integer)rightValue.getValue(Type.tInt) == 0)
        {
            Error.divide_by_zero_error(io,op);
            io.stderr("Fatal Error!\n");
            throw new RuntimeException("Fatal Error!");
        }

        ReturnValue returnVal = new ReturnValue();

        if(leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tDouble);
            returnVal.setValue((Double)leftValue.getValue(Type.tDouble) / (Double) rightValue.getValue(Type.tDouble));
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tDouble){
            returnVal.setType(Type.tDouble);
            returnVal.setValue((Double)leftValue.getValue(Type.tDouble) / (Double) rightValue.getValue(Type.tDouble));
        }else if(leftValue.getType() == Type.tDouble && rightValue.getType() == Type.tDouble){
            returnVal.setType(Type.tDouble);
            returnVal.setValue((Double)leftValue.getValue() / (Double) rightValue.getValue());
        }else if(leftValue.getType() == Type.tInt && rightValue.getType() == Type.tInt){
            returnVal.setType(Type.tInt);
            returnVal.setValue((Integer)leftValue.getValue() / (Integer) rightValue.getValue());
        }else{
            Error.fatal_unsupported_arithmetic_error(io,op);
        }
        Error._is_fatal_returnval_null_error(io,op,returnVal);
        return returnVal;
    }

    public ReturnValue visitTounaryMinus(CMMParser.TounaryMinusContext ctx)
    {
        return visit(ctx.unaryMinus());
    }

    public ReturnValue visitChangeSign(CMMParser.ChangeSignContext ctx) {
        ReturnValue rightvalue = visit(ctx.unaryMinus());
        if(rightvalue == null
                || rightvalue.getValue() == null
                || rightvalue.getType() == null)
        {
            Error.fatal_null_error(io,ctx.unaryMinus().getStop());
        }
        if(rightvalue.getType() == Type.tDouble)
            rightvalue.setValue(-(Double)rightvalue.getValue());
        else if(rightvalue.getType() == Type.tInt) {
            rightvalue.setValue(-(Integer) rightvalue.getValue(Type.tInt));
        }
        else{
            Error.fatal_unsupported_arithmetic_error(io,ctx.getStart());
        }
        Error._is_fatal_returnval_null_error(io,ctx.getStart(),rightvalue);
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
        Symbol varSymbol = symbolTab.resolve(varname);
        if(varSymbol != null ){
            if(varSymbol.getValue() == null)
            {
                Error.fatal_null_error(io,indent);
            }

        }else{
            Error.fatal_null_error(io,indent);
        }
        ReturnValue returnValue = new ReturnValue(varSymbol.getType(), varSymbol.getValue());
        Error._is_fatal_returnval_null_error(io,indent,returnValue);
        return returnValue;
    }

    Token temptoken;
    public ReturnValue visitToConstant(CMMParser.ToConstantContext ctx)
    {

        if(ctx.constant().INTCONSTANT() != null){
            try {
                return new ReturnValue(Type.tInt,
                        Integer.valueOf(ctx.constant().INTCONSTANT().getText()));
            }catch (NumberFormatException e) {
                Token token = ctx.constant().INTCONSTANT().getSymbol();
                if((temptoken!=null)&&(temptoken.equals(token))){

                }else{
                    Error.variableoverflow_error(io, token);
                    Warning.force_zore_warning(io,token);
                }

                temptoken=token;
                return new ReturnValue(Type.tInt, Integer.valueOf(0));
            }
        }
        else if(ctx.constant().DOUBLECONSTANT() != null) {
            Token token = ctx.constant().DOUBLECONSTANT().getSymbol();
            try {
                return new ReturnValue(Type.tDouble,
                        Double.valueOf(ctx.constant().DOUBLECONSTANT().getText()));
            }catch (NumberFormatException e)
            {
                Error.variableoverflow_error(io, token);
                Warning.force_zore_warning(io,token);
                return new ReturnValue(Type.tDouble, 0);
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
            Error.fatal_null_error(io,ctx.getStart());
            return new ReturnValue(Type.tInt,0);
        }
    }
    public ReturnValue visitToArray(CMMParser.ToArrayContext ctx)
    {
        Token token = ctx.array().IDENT().getSymbol();
        String varname = token.getText();
        int varIndex = -1;

        //like a[3]
        if(ctx.array().INTCONSTANT() != null){
            try {
                varIndex = Integer.parseInt(ctx.array().INTCONSTANT().getText());
            }
            catch (NumberFormatException e)
            {
                Error.variableoverflow_error(io,token
                );
                io.stderr("Warning: index will be set to ZERO! in line :"
                        +token.getLine()
                        +":" + token.getCharPositionInLine());
                varIndex = 0;
            }
        }else{//like a[3+b]
            ReturnValue indexValue = visit(ctx.array().expr());
            if(indexValue != null)
            {
                if(indexValue.getType() != null && indexValue.getValue() !=null)
                    varIndex = (Integer) indexValue.getValue();
                else
                    Error.fatal_null_error(io,ctx.array().expr().getStart());
            }
            else
            {
                Error.fatal_null_error(io,ctx.array().expr().getStart());
            }

        }

        Symbol varSymbol = symbolTab.resolve(varname);
        if(varSymbol != null ){
            if(varSymbol.getType() == Type.tIntArray){ // int数组
                int[] varArray = (int[]) varSymbol.getValue();
                if(varIndex < varArray.length && varIndex >= 0){
                    return new ReturnValue(Type.tInt, varArray[varIndex]);
                }else{
                    io.stderr("FATAL ERROR");
                    throw  new RuntimeException("FATAL ERROR");
                }
            }else if(varSymbol.getType() == Type.tDoubleArray){ // double数组
                double[] varArray = (double[]) varSymbol.getValue();

                // 数组越界检查
                if(varIndex < varArray.length&& varIndex >= 0){
                    return new ReturnValue(Type.tDouble, varArray[varIndex]);
                }else{
                    io.stderr("FATAL ERROR");
                    throw  new RuntimeException("FATAL ERROR");
                }

            }
        }else{
            Error.unsupport_array_type_error(io,token);
            io.stderr("FATAL ERROR");
            throw new RuntimeException("FATAL ERROR");
        }
        Error._is_fatal_returnval_null_error(io,token,null);
        return null;
    }
    public ReturnValue visitToExpr(CMMParser.ToExprContext ctx)
    {
        ReturnValue returnvalue = visit(ctx.expr());
        Error._is_fatal_returnval_null_error(io,ctx.expr().getStart(),returnvalue);
        return returnvalue;
    }

    public ReturnValue visitPlus(CMMParser.PlusContext ctx) {
        ReturnValue left = visit(ctx.addMin());
        ReturnValue right = visit(ctx.mulDiv());
        if(left == null || right == null)
        {
            Error.fatal_null_error(io,ctx.getStart());
        }
        else
        {
            if(left.getValue() == null
                    ||right.getValue() == null
                    || left.getType() == null
                    || right.getType() == null)
            {
                Error.fatal_null_error(io,ctx.getStart());
            }
        }
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
                Error.fatal_unsupported_arithmetic_error(io,ctx.PLUS().getSymbol());
            }
        }
        Error._is_fatal_returnval_null_error(io,ctx.PLUS().getSymbol(),returnVal);
        return  returnVal;
    }

    public ReturnValue visitMinus(CMMParser.MinusContext ctx)
    {
        ReturnValue left = visit(ctx.addMin());
        ReturnValue right = visit(ctx.mulDiv());
        if(left == null || right == null)
        {
            Error.fatal_null_error(io,ctx.getStart());
        }
        else
        {
            if(left.getValue() == null
                    ||right.getValue() == null
                    || left.getType() == null
                    || right.getType() == null)
            {
                Error.fatal_null_error(io,ctx.getStart());
            }
        }
        ReturnValue returnVal = null;
        if(left.getType() == Type.tString || right.getType() == Type.tString)
        {
            Error.fatal_unsupported_arithmetic_error(io,ctx.MINUS().getSymbol());
        }
        else {
            if (left.getType() != Type.tBool && right.getType() != Type.tBool) {
                returnVal = new ReturnValue();
                if (left.getType() == Type.tDouble || right.getType() == Type.tDouble) {
                    returnVal.setType(Type.tDouble);
                    returnVal.setValue((Double) left.getValue(Type.tDouble) - (Double) right.getValue(Type.tDouble));
                } else {
                    returnVal.setType(Type.tInt);
                    returnVal.setValue((Integer) left.getValue() - (Integer) right.getValue());
                }
            } else {
                Error.fatal_unsupported_arithmetic_error(io,ctx.MINUS().getSymbol());
            }
        }
        Error._is_fatal_returnval_null_error(io,ctx.MINUS().getSymbol(),returnVal);
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
        Error._is_fatal_returnval_null_error(io,ctx.DEQUAL().getSymbol(),returnVal);
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
        Error._is_fatal_returnval_null_error(io,ctx.SEQUAL().getSymbol(),returnVal);
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
        Error._is_fatal_returnval_null_error(io,ctx.SMALLER().getSymbol(),returnVal);
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
        Error._is_fatal_returnval_null_error(io,ctx.GREATER().getSymbol(),returnVal);
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
        Error._is_fatal_returnval_null_error(io,ctx.GEQUAL().getSymbol(),returnVal);
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
        Error._is_fatal_returnval_null_error(io,ctx.NEQUAL().getSymbol(),returnVal);
        return returnVal; }


}
