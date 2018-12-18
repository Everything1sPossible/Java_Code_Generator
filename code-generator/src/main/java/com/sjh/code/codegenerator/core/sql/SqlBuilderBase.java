package com.sjh.code.codegenerator.core.sql;

import com.sjh.code.codegenerator.core.factory.FreemarkerContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author sjh
 * @Description: SqlBuilder抽象类
 * @date 2018/12/18 23:01
 */
public abstract class SqlBuilderBase implements SqlBuilder{

    private final FreemarkerContext freemarkerContext;
    private final List<String> fieldList;

    public SqlBuilderBase(FreemarkerContext freemarkerContext) {
        this.freemarkerContext = freemarkerContext;
        fieldList = new ArrayList<>();
        initFieldList();
    }

    @Override
    public String buildSelectSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("SELECT ");
        this.fieldList.forEach( s -> {
            sb.append(s).append(",");
        });
        /** 删除最后多余的","*/
        sb.deleteCharAt(sb.length() - 1);
        sb.append(" FROM ").append(this.freemarkerContext.getFileName());
        return sb.toString();
    }

    @Override
    public String buildInsertSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("INSERT INTO ").append(this.freemarkerContext.getFileName()).append(" VALUES");
        sb.append("(");
        this.fieldList.forEach( s -> {
            sb.append("#{"+ s +"},");
        });
        /** 删除最后多余的","*/
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }

    @Override
    public String buildUpdateSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("UPDATE ").append(this.freemarkerContext.getFileName()).append(" SET ");
        this.fieldList.forEach( s ->
            sb.append(s + "=#{"+ s +"},")
        );
        return sb.toString().substring(0, sb.length() - 1);
    }

    @Override
    public String buildDeleteSql() {
        StringBuilder sb = new StringBuilder();
        sb.append("DELETE FROM ").append(this.freemarkerContext.getFileName());
        return sb.toString();
    }

    private void initFieldList() {
        Map<String, Object> fieldsMap = this.freemarkerContext.getFieldsMap();
        fieldsMap.forEach((k, v) -> {
            fieldList.add(k);
        });
    }
}
