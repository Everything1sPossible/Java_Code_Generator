package com.sjh.code.codegenerator.core.util;

import com.sjh.code.codegenerator.core.factory.AbstractFreemarkerTemplate;
import freemarker.template.Configuration;

/**
 * @author sjh
 * @Description: 创建Configure单例
 * @date 2018/12/19 3:13
 */
public class FreemarkerConfigureUtil {

    /** 默认模板目录*/
    private static final String DEFAULT_TEMPLATE_DIRECTORY = "/ftls";

    private static volatile Configuration configuration;

    public static Configuration getConfiguration() {
        if (configuration == null) {
            synchronized (FreemarkerConfigureUtil.class) {
                if (configuration == null) {
                    configuration = new Configuration(Configuration.VERSION_2_3_28);
                    configuration.setTagSyntax(Configuration.AUTO_DETECT_TAG_SYNTAX);
                    /** 此即表示当前类所在的目录开始找，找这个目录下的DEFAULT_TEMPLATE_DIRECTORY目录*/
                    configuration.setClassForTemplateLoading(AbstractFreemarkerTemplate.class, DEFAULT_TEMPLATE_DIRECTORY);
                }
            }
        }
        return configuration;
    }
}
