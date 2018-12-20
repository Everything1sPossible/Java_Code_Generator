package com.sjh.code.codegenerator.core.sql;

import com.sjh.code.codegenerator.core.factory.FreemarkerContext;
import com.sjh.code.codegenerator.core.factory.JavaTemplateInterface;

/**
 * @author sjh
 * @Description: 创建SQL接口
 * @date 2018/12/17 17:30
 */
public interface SqlBuilder {

    /** 创建普通查询SQL语句*/
    String buildSelectSql();

    /** 创建普通添加SQL语句*/
    String buildInsertSql();

    /** 创建普通更新SQL语句*/
    String buildUpdateSql();

    /** 创建普通删除SQL语句*/
    String buildDeleteSql();

}
