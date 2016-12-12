package com.vergil.Interpreter;

/**
 * Created by vergil on 2016/12/11.
 */
public class LocalScope extends BaseScope {

    public LocalScope(Scope enclosingScope) {
        super(enclosingScope);
    }

    @Override
    public String getScopeName() {
        return "locals";
    }
}
