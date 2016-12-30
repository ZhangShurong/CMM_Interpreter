package interpreter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by vergil on 2016/12/7.
 */



//嵌套结构的符号表
public class SymbolTab {
    private SymbolTab enclosingSymbolTab;
    private Map<String, Symbol> symbolsMap = new LinkedHashMap<String, Symbol>();
    public SymbolTab(SymbolTab enclosingSymbolTab)
    {
        this.enclosingSymbolTab = enclosingSymbolTab;
    }
    public SymbolTab getEnclosingSymbolTab()
    {
        return enclosingSymbolTab;
    }
    //定义一个符号
    public void define(Symbol sym)
    {
        symbolsMap.put(sym.name, sym);
        sym.symbolTab = this;
    }
    //在当前作用域内是否重复
    public boolean redundant(String name)
    {
        return symbolsMap.get(name) != null;
    }
    //向上递归查找一个符号
    public Symbol resolve(String name)
    {
        Symbol s = symbolsMap.get(name);
        if ( s!=null ) return s;
        if ( enclosingSymbolTab != null ) return enclosingSymbolTab.resolve(name);
        return null;
    }

}
