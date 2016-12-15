package interpreter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vergil on 2016/12/7.
 */
public class Scope {

    private Scope enclosingScope;
    private Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();
    private String scopename;
    public Scope(Scope enclosingScope)
    {
        this.enclosingScope =enclosingScope;
    }
    public void setScopeName(String scopename)
    {
        this.scopename  = scopename;
    }
    public String getScopeName()
    {
        return scopename;
    }

    public Scope getEnclosingScope()
    {
        return enclosingScope;
    }

    public void define(Symbol sym)
    {
        symbols.put(sym.name, sym);
        sym.scope = this;
    }

    public boolean redundant(String name)
    {
        return symbols.get(name) != null;
    }

    public Symbol resolve(String name)
    {
        Symbol s = symbols.get(name);
        if ( s!=null ) return s;
        if ( enclosingScope != null ) return enclosingScope.resolve(name);
        return null;
    }
    public String toString() { return getScopeName()+":"+symbols.values().toString(); }

}
