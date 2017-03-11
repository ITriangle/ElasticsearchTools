package com.wangl;

import com.wangl.conf.ESToolProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by seentech on 2017/2/23.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringContextTest {

    @Autowired
    public ESToolProperties applicationConf;

    @Test
    public void test1(){

        System.out.println("ApplicationConf : " + applicationConf.getDataDir());
    }
}
