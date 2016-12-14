package interpreter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vergil on 2016/12/7.
 */
public class Scope {
    /*

    Scope enclosingScope; // null if global (outermost) scope
    Map<String, Symbol> symbols = new LinkedHashMap<String, Symbol>();

    public BaseScope(Scope enclosingScope) { this.enclosingScope = enclosingScope;  }

    public Symbol resolve(String name) {
        Symbol s = symbols.get(name);
        if ( s!=null ) return s;
        // if not here, check any enclosing scope
        if ( enclosingScope != null ) return enclosingScope.resolve(name);
        return null; // not found
    }

    public void define(Symbol sym) {
        symbols.put(sym.name, sym);
        sym.scope = this; // track the scope in each symbol
    }

    public boolean redundant(String name){
        return symbols.get(name) != null;
    }

    public Scope getEnclosingScope() { return enclosingScope; }

    public String toString() { return getScopeName()+":"+symbols.values().toString(); }
     */

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

    /** Where to look next for symbols */
    public Scope getEnclosingScope()
    {
        return enclosingScope;
    }

    /** Define a symbol in the current scope */
    public void define(Symbol sym)
    {
        symbols.put(sym.name, sym);
        sym.scope = this; // track the scope in each symbol
    }

    /** Determine redundant definition in same scope */
    public boolean redundant(String name)
    {
        return symbols.get(name) != null;
    }

    /** Look up name in this scope or in enclosing scope if not here */
    public Symbol resolve(String name)
    {
        Symbol s = symbols.get(name);
        if ( s!=null ) return s;
        // if not here, check any enclosing scope
        if ( enclosingScope != null ) return enclosingScope.resolve(name);
        return null; // not found
    }
    public String toString() { return getScopeName()+":"+symbols.values().toString(); }

}
