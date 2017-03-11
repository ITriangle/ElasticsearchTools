package com.wangl.web.QueryParams;

/**
 * Created by wangl on 2016/11/13.
 */
public class ExpressionObject {
    private String operation;
    private String field;
    private String value;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ExpressionObject{" +
                "operation='" + operation + '\'' +
                ", field='" + field + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
