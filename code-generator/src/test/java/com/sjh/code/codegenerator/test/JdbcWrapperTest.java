package com.sjh.code.codegenerator.test;

import com.sjh.code.codegenerator.core.jdbc.JdbcContext;
import com.sjh.code.codegenerator.core.jdbc.JdbcTable;
import com.sjh.code.codegenerator.core.jdbc.JdbcWrapperImpl;

import java.util.List;

/**
 * @author sjh
 * @Description: TODO
 * @date 2018/12/22 2:17
 */
public class JdbcWrapperTest {
    public static void main(String[] args) {
        JdbcContext jdbcContext = new JdbcContext("com.mysql.cj.jdbc.Driver",
                /** 6.x+连接串需加上时区*/
                "jdbc:mysql://127.0.0.1:3306/mytest?characterEncoding=UTF-8&serverTimezone=Asia/Shanghai",
                "",
                "");
        jdbcContext.setCatalog("mytest");
        JdbcWrapperImpl wrapper = new JdbcWrapperImpl();
        List<JdbcTable> jdbcTables = wrapper.getTables(jdbcContext);
        System.out.println(jdbcTables);
    }
}
