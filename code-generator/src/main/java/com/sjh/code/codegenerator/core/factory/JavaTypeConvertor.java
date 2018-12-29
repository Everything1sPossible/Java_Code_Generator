package com.sjh.code.codegenerator.core.factory;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sjh
 * @Description: Java类型识别器
 * @date 2018/12/29 21:39
 */
public class JavaTypeConvertor {

    /** key:Class Type Name; value:Class Type*/
    private static Map<String, Class<?>> JavaTypes = new HashMap<>();

    static {
        JavaTypes.put("Long", Long.class);
        JavaTypes.put("byte[]", byte[].class);
        JavaTypes.put("Boolean", Boolean.class);
        JavaTypes.put("String", String.class);
        JavaTypes.put("Date", Date.class);
        JavaTypes.put("BigDecimal", BigDecimal.class);
        JavaTypes.put("Double", Double.class);
        JavaTypes.put("double", double.class);
        JavaTypes.put("Integer", Integer.class);
        JavaTypes.put("Object", Object.class);
        JavaTypes.put("Float", Float.class);
        JavaTypes.put("float", float.class);
        JavaTypes.put("Byte", Byte.class);
        JavaTypes.put("long", long.class);
        JavaTypes.put("int", int.class);
        JavaTypes.put("short", short.class);
        JavaTypes.put("Short", Short.class);
        JavaTypes.put("char", char.class);
        JavaTypes.put("boolean", boolean.class);
        JavaTypes.put("Map", Map.class);
        JavaTypes.put("HashMap", HashMap.class);
        JavaTypes.put("List", List.class);
        JavaTypes.put("ArrayList", ArrayList.class);
    }

    public static Map<String, Class<?>> getJavaTypes() {
        return JavaTypes;
    }

    public static void setJavaTypes(Map<String, Class<?>> javaTypes) {
        JavaTypes = javaTypes;
    }
}
