package com.wangl.domain;

import com.google.gson.Gson;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.jupiter.api.Test;

/**
 * Created by wangl on 2016/11/10.
 */
public class GetObject {

    /**
     * @param esClient
     * @param index
     * @param type
     * @param id
     * @return
     */
    public String getMacLogStr(ESClient esClient, String index, String type, String id) {
        TransportClient client = esClient.getClient();

        if (client == null) {
            System.out.println("Client is null");

            return null;
        }

        GetResponse responseGet = client.prepareGet(index, type, id).execute().actionGet();

        //获取结果

        return responseGet.getSourceAsString();
    }

    public MacLog getMacLogObj(ESClient esClient) {
        TransportClient client = esClient.getClient();

        if (client == null) {
            System.out.println("Client is null");

            return null;
        }

        GetResponse responseGet = client.prepareGet("mac_2020_01_01_01", "type", "3815027").execute().actionGet();

        //输出结果
        Gson gson = new Gson();
        MacLog macLog = gson.fromJson(responseGet.getSourceAsString(), MacLog.class);

        System.out.println(macLog);

        String json = gson.toJson(macLog);
        System.out.println(json);

        return macLog;
    }




    @Test
    public void test() {
        ESClient esClient = new ESClient();

        GetObject getObject = new GetObject();

        getObject.getMacLogStr(esClient, "mac_2020_01_01_01", "type", "3815027");

        getObject.getMacLogObj(esClient);

    }



}
