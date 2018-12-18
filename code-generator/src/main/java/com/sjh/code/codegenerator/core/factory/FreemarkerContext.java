package com.sjh.code.codegenerator.core.factory;


import com.sjh.code.codegenerator.core.util.JsonUtil;

import java.util.Map;

/**
 * @author sjh
 * @Description: 上下文实体类
 * @date 2018/12/14 22:04
 */
public class FreemarkerContext {

    /** 文件名称*/
    private String fileName;

    /** 实体类字段内容，json格式（key：字段名称，value：字段类型）*/
    private String fieldsCommend;

    /** 实体类路径，格式为：D:/IdeaProjects/code-generator/src/main/java/com/sjh/code/codegenerator/demo*/
    private String entityFilePath;

    /** service类路径，格式同上*/
    private String serviceFilePath;

    /** dao类路径，格式同上*/
    private String daoFilePath;

    /** MyBatis XML文件路径*/
    private String mybatisXmlPath;

    /** 字段Map，key：字段名称，value：字段类型*/
    private Map<String, Object> fieldsMap;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFieldsCommend(String fieldsCommend) {
        if (!JsonUtil.isJsonValid(fieldsCommend)) {
            throw new RuntimeException("请检查您的字段是否为json格式！");
        }
        this.fieldsCommend = fieldsCommend;
        /** 将字段内容转化为map，后续使用直接调用getFieldsMap（）方法*/
        Map<String, Object> fieldsMap = JsonUtil.jsonToMap(fieldsCommend);
        setFieldsMap(fieldsMap);
    }

    public void setEntityFilePath(String entityFilePath) {
        this.entityFilePath = entityFilePath;
    }

    public void setServiceFilePath(String serviceFilePath) {
        this.serviceFilePath = serviceFilePath;
    }

    public void setDaoFilePath(String daoFilePath) {
        this.daoFilePath = daoFilePath;
    }

    public void setMybatisXmlPath(String mybatisXmlPath) {
        this.mybatisXmlPath = mybatisXmlPath;
    }

    public String getFileName() {
        return fileName;
    }

    public String getEntityFilePath() {
        return entityFilePath;
    }

    public String getServiceFilePath() {
        return serviceFilePath;
    }

    public String getDaoFilePath() {
        return daoFilePath;
    }

    public String getMybatisXmlPath() {
        return mybatisXmlPath;
    }

    public Map<String, Object> getFieldsMap() {
        return fieldsMap;
    }

    public void setFieldsMap(Map<String, Object> fieldsMap) {
        this.fieldsMap = fieldsMap;
    }
}
