package interpreter;

import gen.CMMLexer;
import gen.CMMParser;
import io.IOInterface;
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

    private IOInterface ioInterface;
    private IOInterface debugIO;

    private CMMLexer lexer;

    public Interpreter(String sourcecode,IOInterface ioInterface, IOInterface debugIO)
    {
        this.sourcecode = sourcecode;
        this.ioInterface = ioInterface;
        this.debugIO = debugIO;
    }
    public void showtree()
    {
        lexer = new CMMLexer(new ANTLRInputStream(sourcecode));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CMMParser parser = new CMMParser(tokenStream);
        ParseTree parseTree = parser.program();
        Trees.inspect(parseTree, parser);
    }
    public void stop()
    {
        Constant.stop = true;
    }
    public void showtoken()
    {
        lexer = new CMMLexer(new ANTLRInputStream(sourcecode));
        List<Token> tokenList = (List<Token>) lexer.getAllTokens();
        int i = -1;
        for(Token token : tokenList){
            if(i != token.getLine())
            {
                i = token.getLine();
                debugIO.stdout("line " + i + " : \n");
            }
            debugIO.stdout("\tText : " + token.getText() + "\tType : " + token.getType() + "\n");

        }
        lexer.reset();
    }

    public void run()
    {
        Constant.stop = false;
        //lexer = new CMMLexer(new ANTLRInputStream(processStringCat(sourcecode)));
        lexer = new CMMLexer(new ANTLRInputStream(sourcecode));
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CMMParser parser = new CMMParser(tokenStream);
        ParseTree parseTree = parser.program();
        ParseTreeWalker walker = new ParseTreeWalker();
        DefPhaseListener defPhaseListener = new DefPhaseListener(ioInterface, debugIO);
        walker.walk(defPhaseListener, parseTree);
        RefPhaseVisitor refPhaseVisitor = new RefPhaseVisitor(defPhaseListener.globals,
                defPhaseListener.scopes,
                ioInterface);
        refPhaseVisitor.visit(parseTree);
    }

}
