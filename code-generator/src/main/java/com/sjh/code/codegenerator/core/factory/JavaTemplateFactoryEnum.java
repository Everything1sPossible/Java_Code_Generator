package com.sjh.code.codegenerator.core.factory;

/**
 * @author sjh
 * @Description: 模板工厂
 * @date 2018/12/14 22:48
 */
public enum JavaTemplateFactoryEnum {
    /** 普通实体类文件枚举*/
    SIMPLE_ENTITY {
        @Override
        public JavaTemplateInterface buildJavaTemplateInterface() {
            return new SimpleEntityJavaTemplate();
        }
    },
    /** 普通Service接口类文件枚举*/
    SIMPLE_SERVICE_INTERFACE {
        @Override
        public JavaTemplateInterface buildJavaTemplateInterface() {
            return null;
        }
    },
    /** 普通Service接口实现类文件枚举*/
    SIMPLE_SERVICE_INTERFACE_IMPL {
        @Override
        public JavaTemplateInterface buildJavaTemplateInterface() {
            return null;
        }
    },
    /** 普通dao接口类文件枚举*/
    SIMPLE_DAO_INTERFACE {
        @Override
        public JavaTemplateInterface buildJavaTemplateInterface() {
            return new SimpleDaoInterfaceJavaTemplate();
        }
    },
    /** Mybatis XML文件枚举*/
    MYBATIS_SQL_XML {
        @Override
        public JavaTemplateInterface buildJavaTemplateInterface() {
            return new MybatisSqlXmlJavaTemplate();
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
