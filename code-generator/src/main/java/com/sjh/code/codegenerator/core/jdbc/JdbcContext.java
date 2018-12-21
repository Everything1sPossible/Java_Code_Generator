package com.sjh.code.codegenerator.core.jdbc;

import com.sjh.code.codegenerator.core.factory.FreemarkerContext;

/**
 * @author sjh
 * @Description: JDBC连接信息抽象类
 * @date 2018/12/21 13:45
 */
public class JdbcContext extends FreemarkerContext{

    private static final String DEFAULT_TABLE_NAME_PATTERN = "%";

    /** 驱动串*/
    private final String drive;

    /** 连接串*/
    private final String url;

    /** 用户名*/
    private final String username;

    /** 密码*/
    private final String password;

    /**
     * 必须匹配目录名称，因为它存储在数据库中;
     * “”检索那些没有目录的;
     * null表示不应使用目录名称来缩小搜索范围;
     * “%”:查询所有
     * */
    private String catalog;

    /**
     * 模式名称模式; 必须匹配模式名称，因为它存储在数据库中;
     * “”检索没有架构的那些;
     * null表示不应使用模式名称来缩小搜索范围
     * “%”:查询所有
     * */
    private String schemaPattern;

    /**
     * 表名匹配规则，“%”表示所有,不能为空
     * */
    private String tableNamePattern = DEFAULT_TABLE_NAME_PATTERN;


    public JdbcContext(String drive, String url, String username, String password) {
        this.drive = drive;
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public String getDrive() {
        return drive;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getCatalog() {
        return catalog;
    }

    public String getSchemaPattern() {
        return schemaPattern;
    }

    public String getTableNamePattern() {
        return tableNamePattern;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public void setSchemaPattern(String schemaPattern) {
        this.schemaPattern = schemaPattern;
    }

    public void setTableNamePattern(String tableNamePattern) {
        this.tableNamePattern = tableNamePattern;
    }
}
