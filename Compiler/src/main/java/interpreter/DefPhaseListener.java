package interpreter;

import gen.CMMBaseListener;
import gen.CMMParser;
import io.IOInterface;
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
    private IOInterface debugIO;

    public DefPhaseListener(IOInterface io,IOInterface debugIO){
        this.io = io;
        this.debugIO = debugIO;
    }

    ParseTreeProperty<Scope> scopes = new ParseTreeProperty<Scope>();
    Scope globals;
    Scope currentScope;

    public void saveScope(ParserRuleContext ctx, Scope scope){
        scopes.put(ctx, scope);
    }

    @Override
    public void enterProgram(CMMParser.ProgramContext ctx) {
        super.enterProgram(ctx);
        globals = new Scope(null);
        currentScope = globals;
    }

    @Override
    public void exitProgram(CMMParser.ProgramContext ctx) {
        super.exitProgram(ctx);
    }

    @Override
    public void enterStmtBlock(CMMParser.StmtBlockContext ctx) {
        super.enterStmtBlock(ctx);
        currentScope = new Scope(currentScope);
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
        String typeStr = ctx.getParent().getChild(0).getText();
        // 数组
        for(CMMParser.ArrayContext arrayContext: ctx.array()){
            String name = arrayContext.IDENT().getSymbol().getText();
            int size = Integer.parseInt(arrayContext.INTCONSTANT().getText());

            if(currentScope.redundant(name)){
                io.stderr("error: conflicting declaration '"
                        + name
                        + "'"
                        +"\n\tin line "
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

        for(TerminalNode node : ctx.getTokens(CMMParser.IDENT)){
            if(currentScope.redundant(node.getSymbol().getText())){
                io.stderr("error: conflicting declaration '"
                        + node.getSymbol().getText()
                        + "'"+
                        "\n\tin line "
                        + node.getSymbol().getLine()
                        + ":"
                        + node.getSymbol().getCharPositionInLine());
                return;
            }else{
                currentScope.define(new Symbol(node.getSymbol().getText(),
                        typeStr.equals("int")? Type.tInt : Type.tDouble));
            }
        }

        // 声明时赋值
        for(CMMParser.DelassignContext decl_assignContext : ctx.delassign()){
            Token token = decl_assignContext.IDENT().getSymbol();
            ExprComputeVisitor exprComputeVisitor = new ExprComputeVisitor(currentScope, io);
            ExprReturnVal value = exprComputeVisitor.visit(decl_assignContext.expr());
            if(value.getType() != (typeStr.equals("int")? Type.tInt : Type.tDouble)){
                io.stderr("error: unmatched type in '"
                        + token.getText()
                        + "'"
                        +"\n\tin line "
                        + token.getLine()
                        +":"
                        + token.getCharPositionInLine());
                return;
            }

            if(currentScope.redundant(token.getText())){
                io.stderr("error: conflicting declaration '"
                        + token.getText()
                        + "'"
                        +"\n\tin line "
                        + token.getLine()
                        + ":"
                        + token.getCharPositionInLine());
                return;
            }else{
                currentScope.define(new Symbol(token.getText(),
                        typeStr.equals("int")? Type.tInt : Type.tDouble,
                        value.getValue()));
            }
        }

    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
        io.stderr("error: " + node.getText()
                +"\n\tin line " + node.getSymbol().getLine()
                +":" +node.getSymbol().getCharPositionInLine());
    }

}
