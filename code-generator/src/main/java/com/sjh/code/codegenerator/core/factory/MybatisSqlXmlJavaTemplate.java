package com.sjh.code.codegenerator.core.factory;

import com.sjh.code.codegenerator.core.sql.MybatisXmlSqlBuilder;
import com.sjh.code.codegenerator.core.sql.SqlBuilder;
import com.sjh.code.codegenerator.core.util.FilePathUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sjh
 * @Description: Mybatis XML文件生成类，与DAO接口类相对应
 * @date 2018/12/14 22:58
 */
public class MybatisSqlXmlJavaTemplate extends AbstractFreemarkerTemplate {

    /** 默认Freemarker模板名称*/
    private static final String DEFAULT_FTL_NAME = "mybatisSqlXml.ftl";

    public MybatisSqlXmlJavaTemplate() {
        super(DEFAULT_FTL_NAME);
    }

    @Override
    protected Map<String, Object> createParameterMap(FreemarkerContext freemarkerContext) {
        Map<String, Object> parameterMap = new HashMap<>();
        SqlBuilder builder = new MybatisXmlSqlBuilder(freemarkerContext);
        String selectSql = builder.buildSelectSql();
        String updateSql = builder.buildUpdateSql();
        String insertSql = builder.buildInsertSql();
        String deleteSql = builder.buildDeleteSql();
        String entityFileName = freemarkerContext.getFileName();
        String selectId = "select" + entityFileName;
        String updateId = "update" + entityFileName;
        String deleteId = "delete" + entityFileName;
        String insertId = "insert" + entityFileName;
        parameterMap.put("selectSql", selectSql);
        parameterMap.put("updateSql", updateSql);
        parameterMap.put("insertSql", insertSql);
        parameterMap.put("deleteSql", deleteSql);
        parameterMap.put("selectId", selectId);
        parameterMap.put("updateId", updateId);
        parameterMap.put("deleteId", deleteId);
        parameterMap.put("insertId", insertId);
        String daoFilePath = freemarkerContext.getDaoFilePath();
        String daoPackageName = FilePathUtil.cutPathToPackage(daoFilePath);
        String namespace = daoPackageName + "." + entityFileName + DEFAULT_DAO_SUFFIX_NAME;
        parameterMap.put("namespace", namespace);
        return parameterMap;
    }


    @Override
    protected String getDirPath(FreemarkerContext freemarkerContext) {
        return freemarkerContext.getMybatisXmlPath();
    }

    @Override
    protected String getJavaFileName(FreemarkerContext freemarkerContext) {
        return freemarkerContext.getFileName() + DEFAULT_DAO_SUFFIX_NAME+ SUFFIX_XML;
    }
}
