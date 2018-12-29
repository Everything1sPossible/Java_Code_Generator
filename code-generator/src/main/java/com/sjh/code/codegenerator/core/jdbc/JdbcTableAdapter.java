package com.sjh.code.codegenerator.core.jdbc;

import com.sjh.code.codegenerator.core.factory.FreemarkerContext;
import com.sjh.code.codegenerator.core.util.StringUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sjh
 * @Description: JdbcTable适配器
 * @date 2018/12/23 10:30
 */
public class JdbcTableAdapter extends FreemarkerContext{

    private final JdbcTable jdbcTable;
    private final JdbcContext jdbcContext;

    public JdbcTableAdapter(JdbcTable jdbcTable, JdbcContext jdbcContext) {
        this.jdbcTable = jdbcTable;
        this.jdbcContext = jdbcContext;
    }

    @Override
    public String getFileName() {
        return StringUtil.firstToUpper(jdbcTable.getTableName());
    }

    @Override
    public String getEntityFilePath() {
        return jdbcContext.getEntityFilePath();
    }

    @Override
    public String getServiceFilePath() {
        return jdbcContext.getServiceFilePath();
    }

    @Override
    public String getDaoFilePath() {
        return jdbcContext.getDaoFilePath();
    }

    @Override
    public String getMybatisXmlPath() {
        return jdbcContext.getMybatisXmlPath();
    }

    @Override
    public Map<String, Object> getFieldsMap() {
        Map<String, Object> fieldsMap = new HashMap<>();
        List<JdbcColumn> jdbcColumns = jdbcTable.getJdbcColumns();
        jdbcColumns.forEach(jdbcColumn -> {
            String key = jdbcColumn.getColumnName();
            if (getToCamel()) {
                key = StringUtil.underlineToCamel(key);
            }
            fieldsMap.put(key, jdbcColumn.getClassType());
        });
        return fieldsMap;
    }
}
