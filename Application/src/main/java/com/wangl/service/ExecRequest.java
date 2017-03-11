package com.wangl.service;

import com.wangl.domain.ESClient;
import com.wangl.domain.GetObject;
import com.wangl.domain.ScrollGet;
import com.wangl.web.QueryParams.SearchObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wangl on 2016/11/10.
 */
@Component
public class ExecRequest {


    @Autowired
    private ScrollGet scrollGet;

    /**
     * 执行 get API 请求
     * @param index
     * @param type
     * @param id
     * @return
     */
    public String ExecIndexGet(String index, String type, String id){

        GetObject getObject = new GetObject();

        ESClient esClient = new ESClient();

        String json =  getObject.getMacLogStr(esClient, index, type, id);


        if (json == null){
            return "No data: index : " + index + " ,type : " + type + " ,id :" + id ;
        }
        else {

            //拼装写入文件的字符串
            String indexTypeId = "{\"index\": {\"_type\": \""+ type + "\", \"_id\": \""+ id + "\"}}";

            StringBuilder stringBuilder = new StringBuilder(FileOperation.structeBulkStr( type,  id, json));

            String filePath ="./" + index + "_" + type + ".json";
            FileOperation.writeStringToFile(filePath, stringBuilder);

            return json;
        }
    }


    /**
     * 执行 search controller的业务逻辑
     * @param index
     * @param type
     * @param searchObject
     * @return
     */
    public Integer ExecSearchQeustion(String index, String type, SearchObject searchObject){

//        ScrollGet scrollGet = new ScrollGet();

        ESClient esClient = new ESClient();


        Integer num = scrollGet.scrollMacLogNum(esClient, index, type, searchObject);

        return num;


    }





}
