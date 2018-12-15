package com.sjh.code.codegenerator.core;


/**
 * @author sjh
 * @Description: 上下文实体类
 * @date 2018/12/14 22:04
 */
public class FreemarkerEntity {

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

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void setFieldsCommend(String fieldsCommend) {
        this.fieldsCommend = fieldsCommend;
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

    public String getFieldsCommend() {
        return fieldsCommend;
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
}
