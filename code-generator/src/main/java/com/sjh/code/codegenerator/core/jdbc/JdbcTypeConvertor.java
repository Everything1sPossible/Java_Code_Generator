package com.sjh.code.codegenerator.core.jdbc;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sjh
 * @Description: JDBCType转换器，转换成JavaType
 * @date 2018/12/22 1:37
 */
public class JdbcTypeConvertor {

    /** key:JDBC type; value:Class Type*/
    private static Map<Integer, Class<?>> jdbcJavaTypes = new HashMap<>();

    /** key:Class Type; value:Class Type Name*/
    private static Map<Class<?>, String> JavaTypes = new HashMap<>();

    static {
        jdbcJavaTypes.put(Types.BIGINT, Long.class);
        jdbcJavaTypes.put(Types.BINARY, byte[].class);
        jdbcJavaTypes.put(Types.BIT, Boolean.class);
        jdbcJavaTypes.put(Types.BLOB, byte[].class);
        jdbcJavaTypes.put(Types.CHAR, String.class);
        jdbcJavaTypes.put(Types.CLOB, String.class);
        jdbcJavaTypes.put(Types.DATE, Date.class);
        jdbcJavaTypes.put(Types.DECIMAL, BigDecimal.class);
        jdbcJavaTypes.put(Types.DOUBLE, Double.class);
        jdbcJavaTypes.put(Types.FLOAT, Double.class);
        jdbcJavaTypes.put(Types.INTEGER, Integer.class);
        jdbcJavaTypes.put(Types.JAVA_OBJECT, Object.class);
        jdbcJavaTypes.put(Types.LONGVARBINARY, byte[].class);
        jdbcJavaTypes.put(Types.LONGVARCHAR, String.class);
        jdbcJavaTypes.put(Types.NUMERIC, BigDecimal.class);
        jdbcJavaTypes.put(Types.OTHER, Object.class);
        jdbcJavaTypes.put(Types.REAL, Float.class);
        jdbcJavaTypes.put(Types.SMALLINT, Integer.class);
        jdbcJavaTypes.put(Types.TIME, Time.class);
        jdbcJavaTypes.put(Types.TIMESTAMP, Timestamp.class);
        jdbcJavaTypes.put(Types.TINYINT, Byte.class);
        jdbcJavaTypes.put(Types.VARBINARY, byte[].class);
        jdbcJavaTypes.put(Types.VARCHAR, String.class);

        JavaTypes.put(Long.class, "Long");
        JavaTypes.put(byte[].class, "byte[]");
        JavaTypes.put(Boolean.class, "Boolean");
        JavaTypes.put(String.class, "String");
        JavaTypes.put(Date.class, "Date");
        JavaTypes.put(BigDecimal.class, "BigDecimal");
        JavaTypes.put(Double.class, "Double");
        JavaTypes.put(Integer.class, "Integer");
        JavaTypes.put(Object.class, "Object");
        JavaTypes.put(Float.class, "Float");
        JavaTypes.put(Time.class, "Date");
        JavaTypes.put(Timestamp.class, "Date");
        JavaTypes.put(Byte.class, "Byte");
    }

    public static String jdbcTypeToJavaTypeName(Integer jdbcType) {
        Class<?> javaType = jdbcJavaTypes.get(jdbcType);
        return JavaTypes.get(javaType);
    }

    public static Map<Integer, Class<?>> getJdbcJavaTypes() {
        return jdbcJavaTypes;
    }

    public static Map<Class<?>, String> getJavaTypes() {
        return JavaTypes;
    }
}
