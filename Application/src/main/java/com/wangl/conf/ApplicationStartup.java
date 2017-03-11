package com.wangl.conf;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

import java.io.File;

/**
 * Created by wangl on 2016/11/23.
 */
public class ApplicationStartup implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ESToolProperties esToolProperties = contextRefreshedEvent.getApplicationContext().getBean(ESToolProperties.class);

        File dir = new File(esToolProperties.getDataDir());
        if (!dir.exists()){
            dir.mkdir();
        }
    }
}
