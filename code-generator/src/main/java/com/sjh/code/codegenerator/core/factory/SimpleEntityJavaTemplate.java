package com.sjh.code.codegenerator.core.factory;

import com.sjh.code.codegenerator.core.util.FilePathUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sjh
 * @Description: 普通实体类文件生成类
 * @date 2018/12/14 22:58
 */
public class SimpleEntityJavaTemplate extends AbstractFreemarkerTemplate {

    /** 默认Freemarker模板名称*/
    private static final String DEFAULT_FTL_NAME = "simpleEntity.ftl";

    public SimpleEntityJavaTemplate(String freemarkerTemplateName) {
        super(freemarkerTemplateName);
    }

    public SimpleEntityJavaTemplate() {
        super(DEFAULT_FTL_NAME);
    }

    @Override
    protected Map<String, Object> createParameterMap(FreemarkerContext freemarkerContext) {
        String entityFilePath = freemarkerContext.getEntityFilePath();
        String packageName = FilePathUtil.cutPathToPackage(entityFilePath);
        Map<String, Object> fieldsMap = freemarkerContext.getFieldsMap();
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("package", packageName);
        parameterMap.put("fields", fieldsMap);
        return parameterMap;
    }


    @Override
    protected String getDirPath(FreemarkerContext freemarkerContext) {
        return freemarkerContext.getEntityFilePath();
    }

    @Override
    protected String getJavaFileName(FreemarkerContext freemarkerContext) {
        return freemarkerContext.getFileName() + SUFFIX_JAVA;
    }
}
