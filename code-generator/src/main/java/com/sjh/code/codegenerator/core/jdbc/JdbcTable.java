package com.sjh.code.codegenerator.core.jdbc;

import java.util.Collections;
import java.util.List;

/**
 * @author sjh
 * @Description: 表的抽象类
 * @date 2018/12/21 13:45
 */
public class JdbcTable {

    /** 表名*/
    private String tableName;

    /** 表的所有字段信息*/
    private List<JdbcColumn> jdbcColumns = Collections.emptyList();

    public String getTableName() {
        return tableName;
    }

    public List<JdbcColumn> getJdbcColumns() {
        return jdbcColumns;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public void setJdbcColumns(List<JdbcColumn> jdbcColumns) {
        this.jdbcColumns = jdbcColumns;
    }

    @Override
    public String toString() {
        return "JdbcTable{" +
                "tableName='" + tableName + '\'' +
                ", jdbcColumns=" + jdbcColumns +
                '}';
    }
}
