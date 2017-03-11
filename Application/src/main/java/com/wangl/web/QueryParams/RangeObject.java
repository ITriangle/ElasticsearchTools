package com.wangl.web.QueryParams;

/**
 * Created by wangl on 2016/11/13.
 */
public class RangeObject {
    private String field;
    private String gt;
    private String ge;
    private String lt;
    private String le;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getGt() {
        return gt;
    }

    public void setGt(String gt) {
        this.gt = gt;
    }

    public String getGe() {
        return ge;
    }

    public void setGe(String ge) {
        this.ge = ge;
    }

    public String getLt() {
        return lt;
    }

    public void setLt(String lt) {
        this.lt = lt;
    }

    public String getLe() {
        return le;
    }

    public void setLe(String le) {
        this.le = le;
    }

    @Override
    public String toString() {
        return "RangeObject{" +
                "field='" + field + '\'' +
                ", gt='" + gt + '\'' +
                ", ge=" + ge +
                ", lt='" + lt + '\'' +
                ", le=" + le +
                '}';
    }
}
