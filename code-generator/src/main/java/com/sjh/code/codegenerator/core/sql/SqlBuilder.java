package com.sjh.code.codegenerator.core.sql;

import com.sjh.code.codegenerator.core.factory.FreemarkerContext;
import com.sjh.code.codegenerator.core.factory.JavaTemplateInterface;

/**
 * @author sjh
 * @Description: 创建SQL接口
 * @date 2018/12/17 17:30
 */
public interface SqlBuilder extends JavaTemplateInterface {
    String buildSelectSql(FreemarkerContext freemarkerContext);
    String buildInsertSql(FreemarkerContext freemarkerContext);
    String buildUpdateSql(FreemarkerContext freemarkerContext);
    String buildDeleteSql(FreemarkerContext freemarkerContext);
}
