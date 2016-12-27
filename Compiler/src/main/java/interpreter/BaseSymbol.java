package interpreter;

/**
 * Created by vergil on 16-12-27.
 */
public class BaseSymbol {
    protected Type type;
    protected Object value;

    public BaseSymbol()
    {

    }
    public BaseSymbol(Type type, Object value) {
        this.type = type;
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getValue(Type _type)
    {
        if(type == _type)
        {
            if(_type != Type.tBool)
            {
                return this.value;
            }
            return (Integer)this.value == 0?0:1;
        }
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
