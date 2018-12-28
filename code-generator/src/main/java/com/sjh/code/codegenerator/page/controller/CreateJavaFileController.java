package com.sjh.code.codegenerator.page.controller;

import com.sjh.code.codegenerator.core.factory.FreemarkerContext;
import com.sjh.code.codegenerator.core.jdbc.JdbcContext;
import com.sjh.code.codegenerator.page.service.CreateJavaFileService;
import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author sjh
 * @Description: 创建Java文件控制类
 * @date 2018/12/13 23:53
 */
@RestController
@Api(value = "java", description = "创建Java文件接口")
@RequestMapping("java")
@RequiredArgsConstructor
public class CreateJavaFileController {

    private final CreateJavaFileService createJavaFileService;

    @PostMapping("simple")
    @ApiOperation(value = "普通创建Java文件")
    public String simpleCreateJavaFile(@ApiParam(name = "fileName", value = "基础类名称", required = true) @RequestParam String fileName,
                                       @ApiParam(name = "fieldsCommend", value = "实体类字段内容，json格式（key：字段名称，value：字段类型）", required = true) @RequestBody String fieldsCommend,
                                       @ApiParam(name = "entityFilePath", value = "实体类路径", required = true) @RequestParam String entityFilePath,
                                       @ApiParam(name = "daoFilePath", value = "dao类路径", required = true) @RequestParam String daoFilePath,
                                       @ApiParam(name = "mybatisXmlPath", value = "MyBatis XML文件路径", required = true) @RequestParam String mybatisXmlPath,
                                       @ApiParam(name = "isCreateDaoFile", value = "是否生成Dao接口文件") @RequestParam boolean isCreateDaoFile,
                                       @ApiParam(name = "isCreateMybatisXmlFile", value = "是否生成Mybatis XML文件") @RequestParam boolean isCreateMybatisXmlFile) {
        FreemarkerContext context = new FreemarkerContext();
        context.setFileName(fileName);
        context.setFieldsCommend(fieldsCommend);
        context.setEntityFilePath(entityFilePath);
        context.setDaoFilePath(daoFilePath);
        context.setMybatisXmlPath(mybatisXmlPath);
        context.setCreateDaoFile(isCreateDaoFile);
        context.setCreateMybatisXmlFile(isCreateMybatisXmlFile);
        boolean result = createJavaFileService.simpleCreateJavaFile(context);
        return result == true ? "OK!" : "FAIL!";
    }

    @PostMapping("jdbc")
    @ApiOperation(value = "读数据库创建Java文件")
    public String simpleCreateJavaFile(@ApiParam(name = "drive", value = "驱动串", required = true) @RequestParam String drive,
                                       @ApiParam(name = "url", value = "连接串", required = true) @RequestParam String url,
                                       @ApiParam(name = "username", value = "用户名", required = true) @RequestParam String username,
                                       @ApiParam(name = "password", value = "密码", required = true) @RequestParam String password,
                                       @ApiParam(name = "catalog", value = "检索数据库", required = true) @RequestParam String catalog,
                                       @ApiParam(name = "entityFilePath", value = "实体类路径", required = true) @RequestParam String entityFilePath,
                                       @ApiParam(name = "daoFilePath", value = "dao类路径", required = true) @RequestParam String daoFilePath,
                                       @ApiParam(name = "mybatisXmlPath", value = "MyBatis XML文件路径", required = true) @RequestParam String mybatisXmlPath,
                                       @ApiParam(name = "isCreateDaoFile", value = "是否生成Dao接口文件") @RequestParam boolean isCreateDaoFile,
                                       @ApiParam(name = "isCreateMybatisXmlFile", value = "是否生成Mybatis XML文件") @RequestParam boolean isCreateMybatisXmlFile) {
        JdbcContext context = new JdbcContext(drive, url, username, password);
        context.setCatalog(catalog);
        context.setEntityFilePath(entityFilePath);
        context.setDaoFilePath(daoFilePath);
        context.setMybatisXmlPath(mybatisXmlPath);
        context.setCreateDaoFile(isCreateDaoFile);
        context.setCreateMybatisXmlFile(isCreateMybatisXmlFile);
        boolean result = createJavaFileService.jdbcCreateJavaFile(context);
        return result == true ? "OK!" : "FAIL!";
    }
}
