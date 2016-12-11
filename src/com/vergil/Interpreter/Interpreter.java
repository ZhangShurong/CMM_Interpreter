package com.vergil.Interpreter;

import com.vergil.Utils.IOInterface;
import gen.CMMLexer;
import gen.CMMParser;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.List;

/**
 * Created by vergil on 2016/12/7.
 */
public class Interpreter {

    private String sourcecode;
    private boolean showtree = true;
    private boolean showlexres = true;
    private IOInterface consoleIo;
    public Interpreter(String sourcecode)
    {
        this.sourcecode = sourcecode;
    }
    public void interpret()
    {

    }
    public void showtree()
    {

    }
    public void run()
    {
        System.out.print("Start ");

        //1. lexical analysis
        CMMLexer lexer = new CMMLexer(new ANTLRInputStream(sourcecode));
        if(showlexres){
            System.out.println("Token  |  Line  |  Type");
            List<Token> tokenList = (List<Token>) lexer.getAllTokens();
            for(Token token : tokenList){
                System.out.println(token.getText() + "\t" + token.getLine() + "\t" + token.getType());
            }
            lexer.reset();
        }
        //2.  grammatical analysis
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CMMParser parser = new CMMParser(tokenStream);
        ParseTree parseTree = parser.program();
        if(showtree){
            Trees.inspect(parseTree, parser);
        }
        ParseTreeWalker walker = new ParseTreeWalker();

        DefPhaseListener defPhaseListener = new DefPhaseListener(consoleIo);
        walker.walk(defPhaseListener, parseTree);


        RefPhaseVisitor refPhaseVisitor = new RefPhaseVisitor(defPhaseListener.globals,
                defPhaseListener.scopes,
                consoleIo);
        refPhaseVisitor.visit(parseTree);
    }

}
