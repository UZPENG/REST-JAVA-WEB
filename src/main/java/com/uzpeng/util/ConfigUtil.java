package com.uzpeng.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author serverliu on 2018/3/9.
 */
public class ConfigUtil {

    /**
     *
     * @param name 指定配置文件的文件名
     * @return 配置文件的对应的JSON对象
     * @throws JSONException json文件格式错误
     * @throws IOException 读写文件错误
     */
    public static JSONObject readJsonConf(String name) throws JSONException,IOException{
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream moduleApiListInputStream = classLoader.getResourceAsStream(name);

        String charset = "utf-8";
        BufferedReader reader = new BufferedReader(new InputStreamReader(moduleApiListInputStream, charset));

        StringBuilder responseJsonBuilder = new StringBuilder();
        while (reader.ready()) {
            responseJsonBuilder.append(reader.readLine());
        }

       return new JSONObject(responseJsonBuilder.toString());
    }

}
