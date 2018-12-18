package com.sjh.code.codegenerator.core.factory;

import com.sjh.code.codegenerator.core.util.FilePathUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Map;

/**
 * @author sjh
 * @Description: Java文件生成接口抽象类
 * @date 2018/12/14 22:40
 */
public abstract class AbstractFreemarkerTemplate implements JavaTemplateInterface{
    
    /** 默认模板目录*/
    private static final String DEFAULT_TEMPLATE_DIRECTORY = "src/main/resources/templates/freemarker";
    /** 默认编码*/
    protected static final String ENCODING = "UTF-8";
    /** Java文件后缀*/
    protected static final String SUFFIX_JAVA = ".java";
    /** XML文件后缀*/
    protected static final String SUFFIX_XML = ".xml";
    /** DAO接口名称后缀*/
    protected static final String DEFAULT_DAO_SUFFIX_NAME = "Mapper";

    /** Freemarker模板名称*/
    private String freemarkerTemplateName;

    public AbstractFreemarkerTemplate(String freemarkerTemplateName) {
        this.freemarkerTemplateName = freemarkerTemplateName;
    }

    @Override
    public void createJavaFile(FreemarkerContext freemarkerContext) {
        System.out.println("==============开始创建Java文件================");
        Map<String, Object> parameterMap = createParameterMap(freemarkerContext);
        //Java文件名称
        String javaFileName = getJavaFileName(freemarkerContext);
        parameterMap.put("fileName", FilePathUtil.cutJavaSuffix(javaFileName));
        //文件夹路径
        String dirPath = getDirPath(freemarkerContext);
        File dirFile = new File(dirPath);
        if (!dirFile.exists()) {
            dirFile.mkdirs();
        }
        File nFile = new File(dirPath + File.separator + javaFileName);
        if (nFile.exists()) {
            throw new RuntimeException("File \'"+javaFileName+"\' already exists");
        }
        Writer writer = null;
        try {
            writer = new FileWriter(nFile);
            Template template = getConfiguration(DEFAULT_TEMPLATE_DIRECTORY).getTemplate(this.freemarkerTemplateName, ENCODING);
            template.process(parameterMap, writer);
            writer.close();
            System.out.println("==============创建Java文件结束================");
        } catch (TemplateException | IOException e) {
            throw new RuntimeException(e);
        } 
    }

    /**
     * @Description: 自定义各子模板的参数map
     * @author sjh
     * @date 2018/12/14 22:45
     */
    protected abstract Map<String, Object> createParameterMap(FreemarkerContext freemarkerContext);
    
    /**  
     * @Description: 获取生成后的Java文件夹路径
     * @author sjh
     * @date 2018/12/15 0:09
     */
    protected abstract String getDirPath(FreemarkerContext freemarkerContext);

    /**
     * @Description: 获取生成后的Java文件名称,要带上后缀.java
     * @author sjh
     * @date 2018/12/15 0:26
     */
    protected abstract String getJavaFileName(FreemarkerContext freemarkerContext);

    private Configuration getConfiguration(String templateDirectory) {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
        try {
            configuration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
            configuration.setDirectoryForTemplateLoading(new File(templateDirectory));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return configuration;
    }
}
