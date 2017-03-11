package com.wangl.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by wangl on 2016/11/23.
 */
@Component
public class ApplicationConf {

    public static String dataDir ;

    public static String esip;

    public static int esprot;

    public static int fileRecordNum;


    @Autowired
    public ApplicationConf(ESToolProperties esToolProperties) {
        dataDir = esToolProperties.getDataDir();
        esip = esToolProperties.getEsip();
        esprot = esToolProperties.getEsprot();
        fileRecordNum = esToolProperties.getFileRecordNum();
    }


}
