package com.vergil.Interpreter;

/**
 * Created by vergil on 2016/12/7.
 */
public interface Scope {

    String getScopeName();

    /** Where to look next for symbols */
    Scope getEnclosingScope();

    /** Define a symbol in the current scope */
    void define(Symbol sym);

    /** Determine redundant definition in same scope */
    boolean redundant(String name);

    /** Look up name in this scope or in enclosing scope if not here */
    Symbol resolve(String name);

}
