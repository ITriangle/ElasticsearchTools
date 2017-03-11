package com.wangl;

import com.google.gson.Gson;
import com.wangl.web.QueryParams.ExpressionObject;
import com.wangl.web.QueryParams.RangeObject;
import com.wangl.web.QueryParams.SearchObject;
import org.junit.Test;

import java.util.Map;

/**
 * Created by seentech on 2017/2/13.
 */
public class TestClass {

    @Test
    public void test1(){
        String jsonData = "{\"query\": {\"must\": {\"range\": {\"field\": \"signal\",\"gt\": \"-90\",\"gte\": \"2\",\"lt\": \"0\",\"lte\": \"4\"},\"expression1\": {\"operation\": \"term\",\"field\": \"id\",\"value\": \"3815027\"},\"expression2\": {\"operation\": \"term\",\"field\": \"area_code\",\"value\": \"120105\"}}}}";

        String jsonData1 = "{\"query\": {\"must\": {\"range\": {\"field\": \"signal\",\"gt\": \"-90\",\"gte\": \"2\",\"lt\": \"0\",\"lte\": \"4\"},\"expression1\": {\"operation\": \"term\",\"field\": \"id\",\"value\": \"3815027\"},\"expression2\": {\"operation\": \"term\",\"field\": \"area_code\",\"value\": \"120105\"}},\"must_not\": {},\"should\": {}}}";

        Gson gson = new Gson();

        SearchObject searchObject = gson.fromJson(jsonData1, SearchObject.class);

        System.out.println(searchObject.toString());

        Map<String, Object> must = searchObject.getQuery().getMust();

        for (String key: must.keySet()) {
            System.out.println("key: " + key);
            System.out.println(must.get(key).toString());

            if (key.equals("range")){
                RangeObject rangeObject = gson.fromJson(must.get(key).toString(), RangeObject.class);
                System.out.println(rangeObject.toString());

            }else{
                ExpressionObject expressionObject = gson.fromJson(must.get(key).toString(), ExpressionObject.class);
                System.out.println(expressionObject.toString());
            }
        }
    }
}
