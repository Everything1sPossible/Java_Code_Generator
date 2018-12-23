package com.sjh.code.codegenerator.core.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author sjh
 * @Description: JDBC包装实现类
 * @date 2018/12/21 18:15
 */
public class JdbcWrapperImpl implements JdbcWrapper {

    private final ThreadLocal<Connection> connectionThreadLocal = new ThreadLocal<>();
    private static final String TABLE_TYPE = "TABLE";

    @Override
    public Connection getConnection(JdbcContext jdbcContext) {
        Connection connection = connectionThreadLocal.get();
        if (connection == null) {
            try {
                /** 加载驱动*/
                Class.forName(jdbcContext.getDrive());
                /** 创建连接*/
                connection = DriverManager.getConnection(jdbcContext.getUrl(),
                        jdbcContext.getUsername(),
                        jdbcContext.getPassword());
                connectionThreadLocal.set(connection);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

    @Override
    public List<JdbcTable> getTables(JdbcContext jdbcContext) {
        List<JdbcTable> jdbcTables = new ArrayList<>();
        Connection connection = getConnection(jdbcContext);
        try {
            DatabaseMetaData databaseMetaData = connection.getMetaData();
            ResultSet resultSet = databaseMetaData.getTables(jdbcContext.getCatalog(),
                    jdbcContext.getSchemaPattern(),
                    /** 表名模式; 必须匹配存储在数据库中的表名;"%":匹配所有*/
                    jdbcContext.getTableNamePattern(),
                    /** 类型, 此处直接默认获取“表”类型*/
                    new String[]{TABLE_TYPE});
            /** 获取所有表*/
            while (resultSet.next()) {
                JdbcTable jdbcTable = new JdbcTable();
                jdbcTable.setTableName(resultSet.getString("TABLE_NAME"));
                jdbcTables.add(jdbcTable);
            }
            List<JdbcColumn> jdbcColumns = new ArrayList<>();
            jdbcTables.forEach(jdbcTable -> {
                try {
                    /** 获取指定表的所有字段*/
                    ResultSet columnsResultSet = databaseMetaData.getColumns(jdbcContext.getCatalog(),
                            jdbcContext.getSchemaPattern(),
                            jdbcTable.getTableName(),
                            /** 获取所有字段*/
                            "%");
                    while (columnsResultSet.next()) {
                        JdbcColumn jdbcColumn = new JdbcColumn();
                        /** 字段名称*/
                        String columnName = columnsResultSet.getString("COLUMN_NAME");
                        jdbcColumn.setColumnName(columnName);
                        /** 字段在数据库中的类型*/
                        String columnType = columnsResultSet.getString("TYPE_NAME");
                        jdbcColumn.setJdbcTypeName(columnType);
                        /** 字段SQLType，int型*/
                        String columnSqlType = columnsResultSet.getString("DATA_TYPE");
                        jdbcColumn.setClassType(JdbcTypeConvertor.jdbcTypeToJavaTypeName(Integer.valueOf(columnSqlType)));
                        jdbcColumns.add(jdbcColumn);
                    }
                    jdbcTable.setJdbcColumns(jdbcColumns);
                    columnsResultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            });
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            releaseConnection();
        }
        return jdbcTables;
    }

    @Override
    public void releaseConnection() {
        try {
            //获取当前线程绑定连接
            Connection connection = connectionThreadLocal.get();
            if(connection != null) {
                //1.解除连接于空间线程的绑定关系
                connectionThreadLocal.set(null);
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
