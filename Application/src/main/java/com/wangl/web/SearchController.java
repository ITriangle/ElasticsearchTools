package com.wangl.web;

import com.google.gson.Gson;
import com.wangl.service.ExecRequest;
import com.wangl.web.QueryParams.SearchObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangl on 2016/11/15.
 */
@RestController
@RequestMapping(value = "/")
public class SearchController {

    @Autowired
    private ExecRequest execRequest;

    /**
     http://localhost:8080/mac_2020_01_01_01/type/_search
     {
     "query": {
     "must": {
     "range": {
     "field": "signal",
     "gt": "-90",
     "gte": "2",
     "lt": "0",
     "lte": "4"
     },
     "expression1": {
     "operation": "term",
     "field": "id",
     "value": "3815027"
     },
     "expression2": {
     "operation": "term",
     "field": "area_code",
     "value": "120105"
     }
     },
     "must_not": {},
     "should": {}
     }
     }
     *
     * @param index
     * @param type
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "/{index}/{type}/_search")
    public Object searchIndexType(@PathVariable String index, @PathVariable String type, @RequestBody String jsonParam) {

        Gson gson = new Gson();

        SearchObject searchObject = gson.fromJson(jsonParam, SearchObject.class);

        return execRequest.ExecSearchQeustion(index, type, searchObject);
    }


    /**
     * 不指名type,搜索index下所有的type
     * @param index
     * @param jsonParam
     * @return
     */
    @RequestMapping(value = "/{index}/_search")
    public Object searchIndexType(@PathVariable String index, @RequestBody String jsonParam) {

        Gson gson = new Gson();

        SearchObject searchObject = gson.fromJson(jsonParam, SearchObject.class);


        return execRequest.ExecSearchQeustion(index, null, searchObject);
    }

    /**
     * 没有参数
     * @param index
     * @param type
     * @return
     */
    @RequestMapping(value = "/{index}/{type}/_search/null")
    public Object searchIndexTypeNoParam(@PathVariable String index, @PathVariable String type){

        return execRequest.ExecSearchQeustion(index, type, null);
    }

    /**
     * 没有类型,也没有参数
     * @param index
     * @return
     */
    @RequestMapping(value = "/{index}/_search/null")
    public Object searchIndexTypeNoParam(@PathVariable String index){

        return execRequest.ExecSearchQeustion(index, null, null);
    }
}
