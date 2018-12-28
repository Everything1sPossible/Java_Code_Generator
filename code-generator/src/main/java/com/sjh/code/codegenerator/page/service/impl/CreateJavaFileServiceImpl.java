package com.sjh.code.codegenerator.page.service.impl;

import com.sjh.code.codegenerator.core.factory.FreemarkerContext;
import com.sjh.code.codegenerator.core.factory.JavaTemplateFactoryEnum;
import com.sjh.code.codegenerator.core.jdbc.*;
import com.sjh.code.codegenerator.page.service.CreateJavaFileService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sjh
 * @Description: 创建Java文件Service接口实现类
 * @date 2018/12/28 23:34
 */
@Service
public class CreateJavaFileServiceImpl implements CreateJavaFileService {
    @Override
    public boolean simpleCreateJavaFile(FreemarkerContext context) {
        try {
            JavaTemplateFactoryEnum.SIMPLE_ENTITY.buildJavaTemplateInterface()
                    .createJavaFile(context);

            if (context.isCreateDaoFile()) {
                JavaTemplateFactoryEnum.SIMPLE_DAO_INTERFACE.buildJavaTemplateInterface()
                        .createJavaFile(context);
            }

            if (context.isCreateMybatisXmlFile()) {
                JavaTemplateFactoryEnum.MYBATIS_SQL_XML.buildJavaTemplateInterface()
                        .createJavaFile(context);
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean jdbcCreateJavaFile(JdbcContext context) {
        JdbcWrapper jdbcWrapper = new JdbcWrapperImpl();
        List<JdbcTable> jdbcTables = jdbcWrapper.getTables(context);
        jdbcTables.forEach(jdbcTable -> {
            JavaTemplateFactoryEnum.SIMPLE_ENTITY.buildJavaTemplateInterface()
                    .createJavaFile(new JdbcTableAdapter(jdbcTable, context));

            if (context.isCreateDaoFile()) {
                JavaTemplateFactoryEnum.SIMPLE_DAO_INTERFACE.buildJavaTemplateInterface()
                        .createJavaFile(new JdbcTableAdapter(jdbcTable, context));
            }

            if (context.isCreateMybatisXmlFile()) {
                JavaTemplateFactoryEnum.MYBATIS_SQL_XML.buildJavaTemplateInterface()
                        .createJavaFile(new JdbcTableAdapter(jdbcTable, context));
            }

        });
        return true;
    }
}
