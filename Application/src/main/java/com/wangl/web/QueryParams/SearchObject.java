package com.wangl.web.QueryParams;

/**
 * Created by wangl on 2016/11/13.
 */
public class SearchObject {
    private QueryObject query;

    public QueryObject getQuery() {
        return query;
    }

    public void setQuery(QueryObject query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "SearchObject{" +
                "query=" + query +
                '}';
    }
}
