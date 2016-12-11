package com.vergil.Interpreter;

import com.vergil.Utils.IOInterface;
import gen.CMMBaseListener;
import gen.CMMParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * Created by vergil on 2016/12/7.
 */
public class DefPhaseListener extends CMMBaseListener {

    private IOInterface io;

    public DefPhaseListener(IOInterface io){
        this.io = io;
    }

    // 是一个IdentityHashMap<ParseTree,T>
    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    GlobalScope globals;
    Scope currentScope;

    public void saveScope(ParserRuleContext ctx, Scope scope){
        scopes.put(ctx, scope);
    }

    @Override
    public void enterProgram(CMMParser.ProgramContext ctx) {
        super.enterProgram(ctx);
        globals = new GlobalScope(null);
        currentScope = globals;
    }

    @Override
    public void exitProgram(CMMParser.ProgramContext ctx) {
        super.exitProgram(ctx);
    }

    @Override
    public void enterStmtBlock(CMMParser.StmtBlockContext ctx) {
        super.enterStmtBlock(ctx);
        currentScope = new LocalScope(currentScope);
        saveScope(ctx, currentScope);
    }

    @Override
    public void exitStmtBlock(CMMParser.StmtBlockContext ctx) {
        super.exitStmtBlock(ctx);
        currentScope = currentScope.getEnclosingScope();
    }

    @Override
    public void enterVarList(CMMParser.VarListContext ctx) {
        super.enterVarList(ctx);

        // 变量类型，变量列表里的变量类型都是相同的
        String typeStr = ctx.getParent().getChild(0).getText();

        // 数组声明
        for(CMMParser.ArrayContext arrayContext: ctx.array()){
            String name = arrayContext.IDENT().getSymbol().getText();
            int size = Integer.parseInt(arrayContext.INTCONSTANT().getText());
            if(Constant.DEBUG){
                io.output("DEBUG: <"
                        + typeStr + " "
                        + name + " size="
                        + size
                        + " >");
            }
            // 在当前作用域内定义，名称，类型，值
            if(currentScope.redundant(name)){
                io.output("ERROR: redundant definition of <"
                        + name
                        + "> in same scope in line "
                        + arrayContext.IDENT().getSymbol().getLine()
                        + ":"
                        + arrayContext.IDENT().getSymbol().getCharPositionInLine());
                return;
            }else{
                if(typeStr.equals("int")){
                    currentScope.define(new Symbol(name, Type.tIntArray, new int[size]));
                }else{
                    currentScope.define(new Symbol(name, Type.tDoubleArray, new double[size]));
                }
            }

        }

        // 普通变量声明
        for(TerminalNode node : ctx.getTokens(CMMParser.IDENT)){
            if(Constant.DEBUG){
                io.output("DEBUG: <"
                        + typeStr + " "
                        + node.getSymbol().getText()
                        + " >");
            }
            // 在当前作用域内定义，这里往符号表里只是添加了变量名和类型，没有值
            if(currentScope.redundant(node.getSymbol().getText())){
                io.output("ERROR: redundant definition of <"
                        + node.getSymbol().getText()
                        + "> in same scope in line "
                        + node.getSymbol().getLine()
                        + ":"
                        + node.getSymbol().getCharPositionInLine());
                return;
            }else{
                currentScope.define(new Symbol(node.getSymbol().getText(),
                        typeStr.equals("int")? Type.tInt : Type.tDouble));
            }
        }

        // 普通变量在声明时赋值
        for(CMMParser.Decl_assignContext decl_assignContext : ctx.decl_assign()){
            Token token = decl_assignContext.Ident().getSymbol();
            ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
            ExprReturnVal value = exprComputeVisitor.visit(decl_assignContext.expr());
            if(value.getType() != (typeStr.equals("int")? Type.tInt : Type.tReal)){
                io.output("ERROR: unmatched type on two side of <"
                        + token.getText()
                        + "> in line "
                        + token.getLine()
                        +":"
                        + token.getCharPositionInLine());
                return;
            }
            if(Constant.DEBUG){
                io.output("DEBUG: <"
                        + typeStr + " "
                        + token.getText() + " value="
                        + value.getValue()
                        + " >");
            }
            // 在当前作用域内定义，这里往符号表里只是添加了变量名和类型，没有值
            if(currentScope.redundant(token.getText())){
                io.output("ERROR: redundant definition of <"
                        + token.getText()
                        + "> in same scope in line "
                        + token.getLine()
                        + ":"
                        + token.getCharPositionInLine());
                return;
            }else{
                currentScope.define(new Symbol(token.getText(),
                        typeStr.equals("int")? Type.tInt : Type.tReal,
                        value.getValue()));
            }
        }

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
        io.output("ERROR: " + node.getText()
                +" in line " + node.getSymbol().getLine()
                +":" +node.getSymbol().getCharPositionInLine());
    }

}
