package interpreter;

import io.IOInterface;

/**
 * Created by vergil on 2016/12/15.
 */
public class Warning {
    public static void unmatched_type_warning(IOInterface io, String varname, int line, int offset)
    {
        io.stderr("warning: unmatched type in '"
                + varname
                + "'\n\tin line "
                + line
                +":"
                + offset
                +"\n");
    }
}
