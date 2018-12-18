package com.sjh.code.codegenerator.test;

import com.sjh.code.codegenerator.core.util.JsonUtil;

import java.io.IOException;
import java.util.Map;

/**
 * @author sjh
 * @Description: TODO
 * @date 2018/12/15 21:51
 */
public class Test2 {
    public static void main(String[] args) {
//        String json = "{\"name\" : \"张三\", \"sex\" : \"男\"}";
//        Map map = JsonUtil.jsonToMap(json);
//        System.out.println(map.get("name"));
//        System.out.println(map.get("sex"));

        String name = "nAme";
        System.out.println(name.substring(0, 1).toUpperCase() + name.substring(1));
    }
}
