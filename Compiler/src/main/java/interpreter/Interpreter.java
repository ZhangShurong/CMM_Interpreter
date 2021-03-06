package interpreter;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import gen.CMMLexer;
import gen.CMMParser;
import io.IOInterface;
import javafx.scene.paint.Stop;
import org.antlr.v4.gui.Trees;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.Hashtable;
import java.util.List;
import java.util.Set;

/**
 * Created by vergil on 2016/12/7.
 */
public class Interpreter {
    private String sourcecode;

    private IOInterface ioInterface;
    private IOInterface debugIO;

    private CMMLexer lexer;
    private boolean showtree = false;
    private boolean showtokens = false;


    public Interpreter(String sourcecode,IOInterface ioInterface, IOInterface debugIO, boolean showtokens, boolean showtree)
    {
        this(sourcecode, ioInterface, debugIO);
        this.showtokens = showtokens;
        this.showtree = showtree;
    }
    public Interpreter(String sourcecode,IOInterface ioInterface, IOInterface debugIO)
    {
        this.sourcecode = sourcecode;
        this.ioInterface = ioInterface;
        this.debugIO = debugIO;
    }

    public void setShowtree(boolean showtree)
    {
        this.showtree = showtree;
    }

    public void setShowtoken(boolean showtokens)
    {
        this.showtokens = showtokens;
    }

    public void run()
    {
        Error.init_keyword_hashMap();
        //lexer = new CMMLexer(new ANTLRInputStream(processStringCat(sourcecode)));
        lexer = new CMMLexer(new ANTLRInputStream(sourcecode));
        if(showtokens){
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
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        CMMParser parser = new CMMParser(tokenStream);

    parser.removeErrorListeners();
    parser.addErrorListener(new CMMErrorListener(ioInterface));//注册监听器
    parser.setErrorHandler(new CMMErrorStrategy(ioInterface));
    parser.addParseListener(new DefPhase(ioInterface));

    ParseTree parseTree = parser.program();
    RefPhase refPhase = new RefPhase(ioInterface);

    refPhase.visit(parseTree);


    if (showtree) {
        Trees.inspect(parseTree, parser);
    }

    }

}
