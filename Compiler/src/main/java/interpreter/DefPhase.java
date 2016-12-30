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

public class DefPhase extends CMMBaseListener {
    private IOInterface io;
    public DefPhase(IOInterface io){
        this.io = io;
    }
    SymbolTab symbolTab;

    public void saveScope(ParserRuleContext ctx, SymbolTab symbolTab){
        RefPhase.scopes.put(ctx, symbolTab);
    }

    @Override
    public void enterProgram(CMMParser.ProgramContext ctx) {
        super.enterProgram(ctx);
        symbolTab = new SymbolTab(null);
        saveScope(ctx, symbolTab);
    }

    @Override
    public void exitProgram(CMMParser.ProgramContext ctx) {
        super.exitProgram(ctx);
    }

    @Override
    public void enterStmtBlock(CMMParser.StmtBlockContext ctx) {
        super.enterStmtBlock(ctx);
        symbolTab = new SymbolTab(symbolTab);
        saveScope(ctx, symbolTab);
    }

    @Override
    public void exitStmtBlock(CMMParser.StmtBlockContext ctx) {
        super.exitStmtBlock(ctx);
        symbolTab = symbolTab.getEnclosingSymbolTab();
    }


    public static Type gettypebystr(String typeStr) {
        Type type;
        if(typeStr.equals("int")){
            type = Type.tInt;
        }
        else if(typeStr.equals("double"))
        {
            type = Type.tDouble;
        } else if (typeStr.equals("bool")) {
            type = Type.tBool;
        }
        else if(typeStr.equals("string"))
        {
            type = Type.tString;
        }
        else{
            type = null;
        }
        return type;
    }


    @Override
    public void visitErrorNode(ErrorNode node) {
        super.visitErrorNode(node);
        io.stderr("error: " + node.getText()
                +"\n\tin line " + node.getSymbol().getLine()
                +":" +node.getSymbol().getCharPositionInLine());
    }

}
