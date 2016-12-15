package interpreter;

import io.IOInterface;

/**
 * Created by vergil on 2016/12/15.
 */
public class Error {

    public static void conflict_declar_error(IOInterface io, String varname, int line, int offset)
    {
        io.stderr("error:conflicting declaration variable in '"
                + varname
                + "'\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public static void undeclared_var_error(IOInterface io, String varname, int line, int offset)
    {
        io.stderr("error:'"
                        + varname
                +"'undeclared in '"
                + "'\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public static void invalid_type_error(IOInterface io, String varname, int line, int offset)
    {
        io.stderr("error:invalid types for array '"
                + varname
                +"'in '"
                + "'\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public static void unmatched_type_error(IOInterface io, String varname, int line, int offset)
    {
        io.stderr("error: unmatched type in '"
                + varname
                + "'\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
    public  static  void out_of_boundary_error(IOInterface io, String varname, int line, int offset)
    {
        io.stderr("error: index out of boundary of array '"
                + varname
                + "'"
                +"\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }

}
