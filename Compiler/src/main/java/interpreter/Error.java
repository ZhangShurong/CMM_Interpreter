package interpreter;

import io.IOInterface;

/**
 * Created by vergil on 2016/12/15.
 */
public class Error {

    public static void conflict_declar_error(IOInterface io, String varname, int line, int offset) {
        io.stderr("error:conflicting declaration variable in '"
                + varname
                + "'\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public static void undeclared_var_error(IOInterface io, String varname, int line, int offset) {
        io.stderr("error:'"
                        + varname
                +"'undeclared in '"
                + "'\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public static void invalid_type_error(IOInterface io, String varname, int line, int offset) {
        io.stderr("error:invalid types for array '"
                + varname
                +"'in '"
                + "'\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public static void unmatched_type_error(IOInterface io, String varname, int line, int offset){
        io.stderr("error: unmatched type in '"
                + varname
                + "'\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public static void unsupport_array_type_error(IOInterface io, String varname, int line, int offset) {
        io.stderr("error: unsupported array type in '"
                + varname
                + "'"
                +"\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public static void fatal_error(IOInterface io, String varname, int line, int offset) {
        io.stderr("error: fatal error in '"
                + varname
                + "'"
                +"\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public  static  void out_of_boundary_error(IOInterface io, String varname, int line, int offset) {
        io.stderr("error: index out of boundary of array '"
                + varname
                + "'"
                +"\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public static void divide_by_zero_error(IOInterface io, String varname, int line, int offset)  {
        io.stderr("error: divide by zore '"
                + varname
                + "'"
                +"\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public static void uninitialized_error(IOInterface io, String varname, int line, int offset) {
        io.stderr("error: uninitialized variable '"
                + varname
                + "'"
                +"\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public static void variableoverflow_error(IOInterface io, String varname, int line, int offset){
        io.stderr("error: variable overflow '"
                + varname
                + "'"
                +"\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
}
