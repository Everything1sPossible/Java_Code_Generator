package com.sjh.code.codegenerator.core;

/**
 * @author sjh
 * @Description: 模板工厂
 * @date 2018/12/14 22:48
 */
public enum JavaTemplateFactoryEnum {
    /** 普通实体类文件枚举*/
    SIMPLEENTITY {
        @Override
        public JavaTemplateInterface buildJavaTemplateInterface() {
            return new SimpleEntityJavaTemplate();
        }
    },
    /** 普通Service类文件枚举*/
    SIMPLESERVICE {
        @Override
        public JavaTemplateInterface buildJavaTemplateInterface() {
            return null;
        }
    },
    /** 普通dao类文件枚举*/
    SIMPLEDAO {
        @Override
        public JavaTemplateInterface buildJavaTemplateInterface() {
            return null;
        }
    };

    public static JavaTemplateInterface build(String type) {
        if (type == null) {
            throw new NullPointerException("type不允许为空！");
        }
        return JavaTemplateFactoryEnum.valueOf(type.toUpperCase()).buildJavaTemplateInterface();
    }

    public abstract JavaTemplateInterface buildJavaTemplateInterface();
}
