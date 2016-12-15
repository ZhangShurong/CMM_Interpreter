package interpreter;

import java.util.DoubleSummaryStatistics;

/**
 * Created by vergil on 2016/12/7.
 */
public class Symbol {

    String name;      // All symbols at least have a name
    Type type;
    Scope scope;      // All symbols know what scope contains them.
    Object value;


    public Symbol(String name) {
        this.name = name;
    }
    public Symbol(String name, Type type) {
        this(name);
        this.type = type;
    }
    public Symbol(String name, Type type, Object value){
        this(name, type);
        this.value = value;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() { return this.value; }
    public void setValue(Object value) {
        this.value = value;
    }

    public Type getType(){
        return type;
    }
    public void setType(Type _type){
        type = _type;
    }

    public Object getValue(Type _type)
    {
        if(type == _type)
            return this.value;
        switch (_type)
        {
            case tBool:
                if(type == Type.tDouble)
                    return (Double)this.value != 0.0?1:0;
                else if(type == Type.tInt)
                    return (Integer)this.value != 0?1:0;
                break;
            case tDouble:
                if(type == Type.tBool)
                    return (Integer)this.value == 1?1.0:0.0;
                else if(type == Type.tInt){
                    Integer i = (Integer) this.value;
                    return i.doubleValue();
                }
                break;
            case tInt:
                if(type == Type.tBool)
                {
                    return this.value;
                }
                else if(type == Type.tDouble)
                {
                    Double d = (Double)this.value;
                    return d.intValue();
                }
                break;
            default:
                return null;

        }
        return null;
    }

}
