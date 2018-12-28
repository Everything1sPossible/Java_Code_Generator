package com.sjh.code.codegenerator.page.service;

import com.sjh.code.codegenerator.core.factory.FreemarkerContext;
import com.sjh.code.codegenerator.core.jdbc.JdbcContext;

/**
 * @author sjh
 * @Description: 创建Java文件Service接口
 * @date 2018/12/28 23:32
 */
public interface CreateJavaFileService {

    /**
     * @Description: 普通创建Java文件
     */
    boolean simpleCreateJavaFile(FreemarkerContext context);

    /**
     * @Description: 读数据库创建Java文件
     */
    boolean jdbcCreateJavaFile(JdbcContext context);
}
