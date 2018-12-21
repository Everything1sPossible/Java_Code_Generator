package com.sjh.code.codegenerator.core.jdbc;

import java.sql.Connection;
import java.util.List;

/**
 * @author sjh
 * @Description: JDBC包装接口
 * @date 2018/12/21 13:43
 */
public interface JdbcWrapper {

    /** 获取连接*/
    Connection getConnection(JdbcContext jdbcContext);

    /**
     * 获取所有表
     * jdbcContext:
     * catalog:目录名称; 必须匹配目录名称，因为它存储在数据库中; “”检索那些没有目录; null表示不应使用目录名称来缩小搜索范围
     * schemaPattern:模式名称模式; 必须匹配模式名称，因为它存储在数据库中; “”检索没有架构的那些; null表示不应使用模式名称来缩小搜索范围
     * tableNamePattern:表名匹配规则，“%”表示所有,不能为空
     * */
    List<JdbcTable> getTables(JdbcContext jdbcContext);

    /** 释放连接*/
    void releaseConnection();

}
