package com.wangl.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by wangl on 2016/11/23.
 */
@Component
@PropertySource("classpath:elasticsearchTools.properties")
public class ESToolProperties {

    @Value("${data.dir}")
    private String dataDir;

    @Value("${elasticsearch.ip}")
    private String esip;

    @Value("${elasticsearch.port}")
    private int esprot;

    @Value("${file.recordNum}")
    private int fileRecordNum;

    public int getFileRecordNum() {
        return fileRecordNum;
    }

    public String getDataDir() {
        return dataDir;
    }

    public String getEsip() {
        return esip;
    }

    public int getEsprot() {
        return esprot;
    }

    @Override
    public String toString() {
        return "ESToolProperties{" +
                "dataDir='" + dataDir + '\'' +
                ", esip='" + esip + '\'' +
                ", esprot=" + esprot +
                ", fileRecordNum=" + fileRecordNum +
                '}';
    }
}
