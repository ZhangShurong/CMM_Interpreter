package interpreter;

import io.IOInterface;
import org.antlr.v4.runtime.*;

/**
 * Created by vergil on 2016/12/30.
 */
public class CMMErrorStrategy extends DefaultErrorStrategy {
    /** Instead of recovering from exception e, rethrow it wrapped
     * in a generic RuntimeException so it is not caught by the
     * rule function catches. Exception e is the "cause" of the
     * RuntimeException.
     */
    IOInterface io;
    public CMMErrorStrategy(IOInterface io)
    {this.io = io;}

    @Override
    public void recover(Parser recognizer, RecognitionException e) {
        if(recognizer != null) {
            io.stderr(recognizer.toString());
            io.stderr("InputMismatchException caught: please check the source code!! at line " + recognizer.getCurrentToken().getLine());
        }
        else
            io.stderr("InputMismatchException caught: please check the source code!!");
        throw new RuntimeException(e);
    }

/** Make sure we don't attempt to recover inline; if the parser
 * successfully recovers, it won't throw an exception.
 */
    @Override
    public Token recoverInline(Parser recognizer)
            throws RecognitionException
    {
        io.stderr("Fatal Error: InputMismatchException caught: please check the source code!!");
        if(recognizer != null)
            io.stderr(recognizer.toString());
        throw new RuntimeException(new InputMismatchException(recognizer));
    }
    /** Make sure we don't attempt to recover from problems in subrules. */
    @Override
    public void sync(Parser recognizer) { }
}
