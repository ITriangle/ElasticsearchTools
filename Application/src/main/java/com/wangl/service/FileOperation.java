package com.wangl.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by wangl on 2016/11/16.
 */
public class FileOperation {

    /**
     * 根据结果拼装 Bulk 导入语句
     * @param type
     * @param id
     * @param jsonData
     * @return
     */
    public static String structeBulkStr(String type, String id, String jsonData){

        //拼装写入文件的字符串
        String indexTypeId = "{\"index\": {\"_type\": \""+ type + "\", \"_id\": \""+ id + "\"}}\n";

        return indexTypeId + jsonData + "\n";
    }

    /**
     * 清空文件,并写入字符串到文件
     * @param filePath
     * @param stringBuilder
     */
    public static void writeStringToFile(String filePath, StringBuilder stringBuilder) {
        FileWriter fileWriter = null;
        BufferedWriter bw = null;

        try {
            fileWriter = new FileWriter(filePath);// 向文件中写入刚才读取文件中的内容

            bw = new BufferedWriter(fileWriter);
            bw.write(stringBuilder.toString());

            bw.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
