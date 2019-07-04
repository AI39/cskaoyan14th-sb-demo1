package com.cskaoyan14th.typeHandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GoodsTypeHandler extends BaseTypeHandler<String[]> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, String[] strings, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer("[");
        for (int j = 0; j < strings.length; j++) {
            sb.append("\"").append(strings[j]).append("\"");
            if(j != strings.length - 1) {
                sb.append(",");
            }
        }
        preparedStatement.setString(i, sb.append("]").toString());
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, String s) throws SQLException {
        String string = resultSet.getString(s);
        String[] strings = toStringArray(string);
        return strings;
    }

    private String[] toStringArray(String string) {
        if(string != null && string.length() != 0) {
            string = string.replace("[", "").replace("]", "");
            String[] split = string.split(",");
            for (int i = 0; i < split.length; i++) {
                split[i] = split[i].replace("\"", "");
            }
            return split;
        }
        return null;
    }

    @Override
    public String[] getNullableResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        String[] strings = toStringArray(string);
        return strings;
    }

    @Override
    public String[] getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        String[] strings = toStringArray(string);
        return strings;
    }
}
