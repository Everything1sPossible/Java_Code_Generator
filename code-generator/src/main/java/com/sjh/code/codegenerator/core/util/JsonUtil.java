package com.sjh.code.codegenerator.core.util;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sjh
 * @Description: json工具类
 * @date 2018/12/15 15:02
 */
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * @Description: 将json字符串转为Map
     * @author sjh
     */
    public static Map<String, Object> jsonToMap(String json) {
        Map<String, Object> map = null;
        try {
            map = mapper.readValue(json, Map.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * @Description: 判断字符串是否为json格式
     * @author sjh
     */
    public static boolean isJsonValid(String target) {
        try {
            mapper.readTree(target);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
