package com.wangl.web.QueryParams;

import java.util.Map;

/**
 * Created by wangl on 2016/11/13.
 */
public class QueryObject {
    private Map<String, Object> must;

    private Map<String, Object> must_not;

    private Map<String, Object> should;

    public Map<String, Object> getMust() {
        return must;
    }

    public void setMust(Map<String, Object> must) {
        this.must = must;
    }

    public Map<String, Object> getMust_not() {
        return must_not;
    }

    public void setMust_not(Map<String, Object> must_not) {
        this.must_not = must_not;
    }

    public Map<String, Object> getShould() {
        return should;
    }

    public void setShould(Map<String, Object> should) {
        this.should = should;
    }

    @Override
    public String toString() {
        return "QueryObject{" +
                "must=" + must +
                ", must_not=" + must_not +
                ", should=" + should +
                '}';
    }
}
