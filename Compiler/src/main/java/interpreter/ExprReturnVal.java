package interpreter;

/**
 * Created by vergil on 2016/12/7.
 */

public class ExprReturnVal {
    private Type type;
    private Object value;

    public ExprReturnVal() {
    }

    public ExprReturnVal(Type type, Object value) {
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
}
