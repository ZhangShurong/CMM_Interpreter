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

    public Scope(Scope enclosingScope)
    {
        this.enclosingScope =enclosingScope;
    }

    String getScopeName()
    {
        return null;
    }

    /** Where to look next for symbols */
    Scope getEnclosingScope()
    {
        return null;
    }

    /** Define a symbol in the current scope */
    void define(Symbol sym)
    {

    }

    /** Determine redundant definition in same scope */
    boolean redundant(String name)
    {
        return false;
    }

    /** Look up name in this scope or in enclosing scope if not here */
    Symbol resolve(String name)
    {
        return null;
    }

}
