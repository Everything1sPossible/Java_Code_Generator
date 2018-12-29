package com.sjh.code.codegenerator.core.factory;


import com.sjh.code.codegenerator.core.util.JsonUtil;
import com.sjh.code.codegenerator.core.util.StringUtil;

import java.util.Map;

/**
 * @author sjh
 * @Description: 上下文实体类
 * @date 2018/12/14 22:04
 */
public class FreemarkerContext {

    /**
     * 基础类名称，用于实体类，其它层的类名称自定义
     * 后续自动生成的SQL表名默认就是这个名称。
     * */
    private String fileName;

    /** 实体类字段内容，json格式（key：字段名称，value：字段类型）*/
    private String fieldsCommend;

    /**
     * 实体类路径
     * 格式为：D:/IdeaProjects/code-generator/src/main/java/com/sjh/code/codegenerator/demo
     * 或者：D:\IdeaProjects\code-generator\...
     * */
    private String entityFilePath;

    /** service类路径，格式同上*/
    private String serviceFilePath;

    /** dao类路径，格式同上*/
    private String daoFilePath;

    /** MyBatis XML文件路径*/
    private String mybatisXmlPath;

    /** 字段Map，key：字段名称，value：字段类型*/
    private Map<String, Object> fieldsMap;

    /** 是否生成Dao接口文件，默认true*/
    private Boolean isCreateDaoFile = true;

    /** 是否生成Mybatis XML文件，默认true*/
    private Boolean isCreateMybatisXmlFile = true;

    /** 是否转换成驼峰字符串,用于读取数据库表字段时转化*/
    private Boolean isToCamel = true;

    public void setFileName(String fileName) {
        /** 将类名称首字母大写*/
        this.fileName = StringUtil.firstToUpper(fileName);
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
        this.entityFilePath = replace(entityFilePath);
    }

    public void setServiceFilePath(String serviceFilePath) {
        this.serviceFilePath = replace(serviceFilePath);
    }

    public void setDaoFilePath(String daoFilePath) {
        this.daoFilePath = replace(daoFilePath);
    }

    public void setMybatisXmlPath(String mybatisXmlPath) {
        this.mybatisXmlPath = replace(mybatisXmlPath);
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
        checkFieldsMap(fieldsMap);
        this.fieldsMap = fieldsMap;
    }

    public void setCreateDaoFile(boolean createDaoFile) {
        isCreateDaoFile = createDaoFile;
    }

    public void setCreateMybatisXmlFile(boolean createMybatisXmlFile) {
        isCreateMybatisXmlFile = createMybatisXmlFile;
    }

    public Boolean isCreateDaoFile() {
        return isCreateDaoFile;
    }

    public Boolean isCreateMybatisXmlFile() {
        return isCreateMybatisXmlFile;
    }

    public void setCreateDaoFile(Boolean createDaoFile) {
        isCreateDaoFile = createDaoFile;
    }

    public void setCreateMybatisXmlFile(Boolean createMybatisXmlFile) {
        isCreateMybatisXmlFile = createMybatisXmlFile;
    }

    public Boolean getToCamel() {
        return isToCamel;
    }

    public void setToCamel(Boolean toCamel) {
        isToCamel = toCamel;
    }

    /** 将URL中的“\”替换成“/”*/
    private String replace(String prefix) {
        return prefix.replace("\\", "/");
    }

    /** 检查Map Value是否是正确的Java类型*/
    private void checkFieldsMap(Map<String, Object> fieldsMap) {
        fieldsMap.forEach((k, v) -> {
            Class<?> clazz = JavaTypeConvertor.getJavaTypes().get(String.valueOf(v));
            if (clazz == null) {
                throw new RuntimeException("请检查[" + k + "]的类型(value值)！");
            }
        });
    }
}
