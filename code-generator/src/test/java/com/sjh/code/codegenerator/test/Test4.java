package com.sjh.code.codegenerator.test;

import com.sjh.code.codegenerator.core.factory.AbstractFreemarkerTemplate;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;


/**
 * @author sjh
 * @Description: TODO
 * @date 2018/12/19 2:39
 */
public class Test4 {
    public static void main(String[] args) throws IOException {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        configuration.setClassForTemplateLoading(AbstractFreemarkerTemplate.class, "/ftls");
        Template template = configuration.getTemplate("simpleEntity.ftl");
        System.out.println(template);
    }
}
