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
        freemarkerContext.setEntityFilePath("D:/code-generator/main/java/com/sjh/code/codegenerator/demo");
        freemarkerContext.setFieldsCommend(fieldsJson);
        JavaTemplateFactoryEnum.SIMPLEENTITY.buildJavaTemplateInterface()
                .createJavaFile(freemarkerContext);
    }
}
