package com.sjh.code.codegenerator.core.factory;

import com.sjh.code.codegenerator.core.util.FilePathUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sjh
 * @Description: 普通DAO接口类文件生成类
 * @date 2018/12/14 22:58
 */
public class SimpleDaoInterfaceJavaTemplate extends AbstractFreemarkerTemplate {

    /** 默认Freemarker模板名称*/
    private static final String DEFAULT_FTL_NAME = "simpleDaoInterface.ftl";

    public SimpleDaoInterfaceJavaTemplate() {
        super(DEFAULT_FTL_NAME);
    }

    @Override
    protected Map<String, Object> createParameterMap(FreemarkerContext freemarkerContext) {
        String daoFilePath = freemarkerContext.getDaoFilePath();
        String packageName = FilePathUtil.cutPathToPackage(daoFilePath);
        String entityFileName = freemarkerContext.getFileName();
        String entityFilePath = freemarkerContext.getEntityFilePath();
        String entityPackageName = FilePathUtil.cutPathToPackage(entityFilePath);
        Map<String, Object> parameterMap = new HashMap<>();
        parameterMap.put("package", packageName);
        parameterMap.put("entityFileName", entityFileName);
        parameterMap.put("entityPackageName", entityPackageName);
        return parameterMap;
    }


    @Override
    protected String getDirPath(FreemarkerContext freemarkerContext) {
        return freemarkerContext.getDaoFilePath();
    }

    @Override
    protected String getJavaFileName(FreemarkerContext freemarkerContext) {
        return freemarkerContext.getFileName() + DEFAULT_DAO_SUFFIX_NAME + SUFFIX_JAVA;
    }
}
