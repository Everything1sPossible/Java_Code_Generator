package com.sjh.code.codegenerator.core.jdbc;

import java.sql.SQLType;

/**
 * @author sjh
 * @Description: 表的字段抽象类
 * @date 2018/12/21 16:01
 */
public class JdbcColumn {

    /** 字段名*/
    private String columnName;

    /** 字段Class类型名称*/
    private String classType;

    /** 字段在数据库中的类型名称*/
    private String jdbcTypeName;

    public String getColumnName() {
        return columnName;
    }

    public String getClassType() {
        return classType;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public String getJdbcTypeName() {
        return jdbcTypeName;
    }

    public void setJdbcTypeName(String jdbcTypeName) {
        this.jdbcTypeName = jdbcTypeName;
    }

    @Override
    public String toString() {
        return "JdbcColumn{" +
                "columnName='" + columnName + '\'' +
                ", classType=" + classType +
                ", jdbcTypeName='" + jdbcTypeName + '\'' +
                '}';
    }
}
