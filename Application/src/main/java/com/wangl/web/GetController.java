package com.wangl.web;

import com.wangl.service.ExecRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by wangl on 2016/11/10.
 */
@RestController
@RequestMapping(value = "/")
public class GetController {


    /**
     * 通过以下链接获取值,并且生成对应的文件
     * http://localhost:8080/index/type/id/_get
     *
     * @param index
     * @param type
     * @param id
     * @return
     */
    @RequestMapping(value = "/{index}/{type}/{id}/_get")
    public String indexGet1(@PathVariable String index, @PathVariable String type, @PathVariable String id) {

        return new ExecRequest().ExecIndexGet(index, type, id);
    }


    /**
     * 通过以下链接获取值,并生成对应的文件
     * http://localhost:8080/mac_2020_01_01_01/type/_get?q=id:3815027
     *
     * @param index
     * @param type
     * @param questionPara
     * @return
     */
    @RequestMapping(value = "/{index}/{type}/_get")
    public String indexGet2(@PathVariable String index, @PathVariable String type, @RequestParam("q") String questionPara) {

        int num = questionPara.lastIndexOf(":");
        String id = questionPara.substring(num + 1);

        return new ExecRequest().ExecIndexGet(index, type, id);
    }



}
