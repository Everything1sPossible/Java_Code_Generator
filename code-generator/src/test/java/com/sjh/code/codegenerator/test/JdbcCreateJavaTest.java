package com.sjh.code.codegenerator.test;

import com.sjh.code.codegenerator.core.factory.JavaTemplateFactoryEnum;
import com.sjh.code.codegenerator.core.jdbc.*;

import java.util.List;

/**
 * @author sjh
 * @Description: TODO
 * @date 2018/12/23 10:36
 */
public class JdbcCreateJavaTest {
    public static void main(String[] args) {
        JdbcWrapper jdbcWrapper = new JdbcWrapperImpl();
        JdbcContext jdbcContext = new JdbcContext("com.mysql.cj.jdbc.Driver",
                /** 6.x+连接串需加上时区*/
                "jdbc:mysql://127.0.0.1:3306/mytest?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                "",
                "");
        jdbcContext.setCatalog("mytest");
        jdbcContext.setEntityFilePath("D:/GitHub/Code_Generator/code-generator/src/main/java/com/sjh/code/codegenerator/simple/entity");
        jdbcContext.setDaoFilePath("D:/GitHub/Code_Generator/code-generator/src/main/java/com/sjh/code/codegenerator/simple/dao");
        jdbcContext.setMybatisXmlPath("D:/GitHub/Code_Generator/code-generator/src/main/java/com/sjh/code/codegenerator/simple/dao");
        List<JdbcTable> jdbcTables = jdbcWrapper.getTables(jdbcContext);
        jdbcTables.forEach(jdbcTable -> {
            JavaTemplateFactoryEnum.SIMPLE_ENTITY.buildJavaTemplateInterface()
                    .createJavaFile(new JdbcTableAdapter(jdbcTable, jdbcContext));

            JavaTemplateFactoryEnum.SIMPLE_DAO_INTERFACE.buildJavaTemplateInterface()
                    .createJavaFile(new JdbcTableAdapter(jdbcTable, jdbcContext));

            JavaTemplateFactoryEnum.MYBATIS_SQL_XML.buildJavaTemplateInterface()
                    .createJavaFile(new JdbcTableAdapter(jdbcTable, jdbcContext));
        });
    }
}
