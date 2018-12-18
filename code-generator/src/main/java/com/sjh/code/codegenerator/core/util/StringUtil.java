package com.sjh.code.codegenerator.core.util;

/**
 * @author sjh
 * @Description: String字符串工具类
 * @date 2018/12/18 21:14
 */
public class StringUtil {

    /**
     * @Description: 将字符串首字母大写
     * @author sjh
     */
    public static String firstToUpper(String target) {
        target = target.substring(0, 1).toUpperCase() + target.substring(1);
        return target;
    }
    /**
     * @Description: 将字符串首字母小写
     * @author sjh
     */
    public static String firstToLower(String target) {
        target = target.substring(0, 1).toLowerCase() + target.substring(1);
        return target;
    }
}
