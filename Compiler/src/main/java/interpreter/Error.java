package interpreter;

import com.sun.corba.se.impl.oa.toa.TOA;
import io.IOInterface;
import org.antlr.v4.runtime.Token;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.Hashtable;
import java.util.Set;

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
    public static void fatal_unsupported_arithmetic_error(IOInterface io, Token token)
    {
        io.stderr("fatal error : unsupported arithmetic for'"
                + token.getText()
                + "'"
                +"\n\tin line "
                + token.getLine()
                +":"
                + token.getCharPositionInLine()
                +"\n");
        throw new RuntimeException("fatal error: fatal_unsupported_arithmetic_error");
    }
    public static void _is_fatal_returnval_null_error(IOInterface io, Token token, ReturnValue returnValue)
    {
        if(returnValue != null)
        {
            if(returnValue.getValue() != null && returnValue.getType() != null)
            {
                return;
            }
        }
        io.stderr("Fatal error: Return value is null in line" + token.getLine());
        throw new RuntimeException("Return value is null in line" + token.getLine());
    }
    private static Hashtable<String, String> key_words_hashMap;
    public static void _is_conflict_with_keyword_error(IOInterface io, String varName, Token token)
    {
        if(key_words_hashMap == null)
        {
            throw new RuntimeException("Fatal error: Hash map is null.");
        }
        Set<String> keys = key_words_hashMap.keySet();
        for(String key: keys){
            if(varName.equals(key_words_hashMap.get(key)))
            {
                io.stderr("Fatal Error: Conflict with key word: in line \n\t"
                        +token.getLine() + " : " + token.getCharPositionInLine());
                throw  new RuntimeException("Fatal Error: Conflict with key word!");
            }
        }
    }
    public static void init_keyword_hashMap()
    {
        if(key_words_hashMap != null)
            return;
        key_words_hashMap = new Hashtable<>();
        key_words_hashMap.put("READ","read");
        key_words_hashMap.put("WRITE","write");
        key_words_hashMap.put("IF","if");
        key_words_hashMap.put("ELSE","else");
        key_words_hashMap.put("WHILE","while");
        key_words_hashMap.put("BREAK","break");
        key_words_hashMap.put("INT","int");
        key_words_hashMap.put("DOUBLE","double");
        key_words_hashMap.put("STRING","string");
        key_words_hashMap.put("BOOlEAN","bool");
    }
}
