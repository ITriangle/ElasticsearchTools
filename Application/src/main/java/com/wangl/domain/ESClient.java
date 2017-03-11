package com.wangl.domain;

import com.wangl.conf.ApplicationConf;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.junit.jupiter.api.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by wangl on 2016/11/10.
 */
public class ESClient {

    private TransportClient client;

    public TransportClient getClient() {
        return client;
    }

    public void setClient(TransportClient client) {
        this.client = client;
    }


    /**
     *
     */
    public ESClient() {
        TransportClient client = null;

        try {
            client = TransportClient.builder().build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ApplicationConf.esip), ApplicationConf.esprot));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        this.client = client;
    }



    @Test
    public void test(){
        ESClient esClient = new ESClient();

        TransportClient client = esClient.getClient();

        if(client == null){
            System.out.println("Client is null");

            return ;
        }

        GetResponse responseGet = client.prepareGet("mac_2020_01_01_01", "type", "3815027").execute().actionGet();

        //输出结果
        System.out.println(responseGet.getSourceAsString());

    }
}
