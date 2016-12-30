package interpreter;

import io.IOInterface;
import org.antlr.v4.runtime.Token;

/**
 * Created by vergil on 2016/12/15.
 */
public class Error {

    public static void conflict_declar_error(IOInterface io, Token token) {
        io.stderr("error:conflicting declaration variable in '"
                + token.getText()
                + "'\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
    }
    public static void undeclared_var_error(IOInterface io, Token token) {
        io.stderr("error:'"
                        + token.getText()
                +"'undeclared in '"
                + "'\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
    }
    public static void invalid_type_error(IOInterface io, Token token) {
        io.stderr("error:invalid types for array '"
                + token.getText()
                +"'in '"
                + "'\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
    }
    public static void unmatched_type_error(IOInterface io, Token token){
        io.stderr("error: unmatched type in '"
                + token.getText()
                + "'\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
    }
    public static void unsupport_array_type_error(IOInterface io, Token token) {
        io.stderr("error: unsupported array type in '"
                + token.getText()
                + "'"
                +"\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
    }
    public static void fatal_error(IOInterface io, Token token) {
        io.stderr("error: fatal error in '"
                + token.getText()
                + "'"
                +"\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
    }
    public  static  void out_of_boundary_error(IOInterface io, Token token) {
        io.stderr("error: index out of boundary of array '"
                + token.getText()
                + "'"
                +"\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
    }
    public static void divide_by_zero_error(IOInterface io, Token token)  {
        io.stderr("error: divide by zore '"
                + token.getText()
                + "'"
                +"\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
    }
    public static void uninitialized_error(IOInterface io, Token token) {
        io.stderr("error: uninitialized variable '"
                + token.getText()
                + "'"
                +"\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
    }
    public static void variableoverflow_error(IOInterface io, Token token){
        io.stderr("error: variable overflow '"
                + token.getText()
                + "'"
                +"\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
    }
    public static void fatal_unknown_error(IOInterface io, Token token)
    {
        io.stderr("fatal error: unknown error '"
                + token.getText()
                + "'"
                +"\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
        throw new RuntimeException("fatal error: unknown error");
    }
    public static void fatal_null_error(IOInterface io, Token token)
    {
        io.stderr("fatal error: null error '"
                + token.getText()
                + "'"
                +"\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
        throw new RuntimeException("fatal error: null value error");
    }

}
