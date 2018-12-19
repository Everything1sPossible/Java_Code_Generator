package com.sjh.code.codegenerator.test;

import com.sjh.code.codegenerator.core.factory.FreemarkerContext;
import com.sjh.code.codegenerator.core.factory.JavaTemplateFactoryEnum;

/**
 * @author sjh
 * @Description: TODO
 * @date 2018/12/15 21:55
 */
public class SimpleEntityTest {
    public static void main(String[] args) {
        String fieldsJson = "{\"name\" : \"String\", \"sex\" : \"String\", \"age\" : \"Integer\"}";
        FreemarkerContext freemarkerContext = new FreemarkerContext();
        freemarkerContext.setFileName("testEntity");
        freemarkerContext.setEntityFilePath("D:/GitHub/Code_Generator/code-generator/src/main/java/com/sjh/code/codegenerator/simple/entity");
        freemarkerContext.setDaoFilePath("D:/GitHub/Code_Generator/code-generator/src/main/java/com/sjh/code/codegenerator/simple/dao");
        freemarkerContext.setMybatisXmlPath("D:/GitHub/Code_Generator/code-generator/src/main/java/com/sjh/code/codegenerator/simple/dao");
        freemarkerContext.setFieldsCommend(fieldsJson);
        JavaTemplateFactoryEnum.SIMPLE_ENTITY.buildJavaTemplateInterface()
                .createJavaFile(freemarkerContext);

        JavaTemplateFactoryEnum.SIMPLE_DAO_INTERFACE.buildJavaTemplateInterface()
                .createJavaFile(freemarkerContext);

        JavaTemplateFactoryEnum.MYBATIS_SQL_XML.buildJavaTemplateInterface()
                .createJavaFile(freemarkerContext);
    }
}
