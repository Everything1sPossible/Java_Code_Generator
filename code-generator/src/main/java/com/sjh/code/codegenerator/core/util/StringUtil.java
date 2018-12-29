package com.sjh.code.codegenerator.core.util;

/**
 * @author sjh
 * @Description: String字符串工具类
 * @date 2018/12/18 21:14
 */
public class StringUtil {

    private static final String UNDERLINE = "_";

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

    /**
     * @Description: 驼峰命名转换,下划线格式字符串转换为驼峰格式字符串
     * 首字母大写，“_”后首字母大写，截取掉所有“_”
     * 例：user_name --> UserName
     */
    public static String underlineToCamel(String param) {
        if (param == null || "".equals(param.trim())) {
            return "";
        } else if (!param.contains(UNDERLINE)) {
            return param;
        }
        int len = param.length();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            char c = param.charAt(i);
            if (c == '_') {
                if (++i < len) {
                    sb.append(Character.toUpperCase(param.charAt(i)));
                }
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

}
