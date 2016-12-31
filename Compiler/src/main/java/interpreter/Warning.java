package interpreter;

import io.IOInterface;
import org.antlr.v4.runtime.Token;

/**
 * Created by vergil on 2016/12/15.
 */
public class Warning {
    public static void unmatched_type_warning(IOInterface io,Token token)
    {
        io.stderr("warning: unmatched type in '"
                + token.getText()
                + "'\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
    }
    public static void force_zore_warning(IOInterface io, Token token)
    {
        io.stderr("warning: var in '"
                + token.getText()
                + "'\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +" will be set to ZERO!\n");
    }
}
