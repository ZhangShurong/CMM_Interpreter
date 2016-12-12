package com.vergil.Interpreter;

/**
 * Created by vergil on 2016/12/7.
 */
public class GlobalScope extends BaseScope {

    public GlobalScope(Scope enclosingScope) {
        super(enclosingScope);
    }

    @Override
    public String getScopeName() {
        return "globals";
    }
}
