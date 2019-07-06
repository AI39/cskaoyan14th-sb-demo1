package com.cskaoyan14th.typeHandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminTypeHandler implements TypeHandler<int[]> {
    /**
     * property转换为colume中的值
     * @param preparedStatement
     * @param i
     * @param
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, int[] roleIds, JdbcType jdbcType) throws SQLException {
        StringBuffer sb = new StringBuffer();
        for (int anInt : roleIds) {
            sb.append(anInt).append(",");
        }
        String substring = sb.substring(0, sb.length() - 1);
        String subSalt = "[" + substring + "]";
        preparedStatement.setString(i,subSalt);
    }

    /**
     * 以下三个方法都是将 String转换为typehandler<>泛型中的类型
     * @param resultSet
     * @param
     * @return
     * @throws SQLException
     */
    //s代表的是列名
    @Override
    public int[] getResult(ResultSet resultSet, String roleIds) throws SQLException {
        String string = resultSet.getString(roleIds);
        return transStringToIntArray(string);
    }

    @Override
    public int[] getResult(ResultSet resultSet, int i) throws SQLException {
        String string = resultSet.getString(i);
        return transStringToIntArray(string);
    }

    @Override
    public int[] getResult(CallableStatement callableStatement, int i) throws SQLException {
        String string = callableStatement.getString(i);
        return transStringToIntArray(string);
    }
    //自定义方法将String的值转换为int数组
    private int[] transStringToIntArray(String s){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(s);
        String substring = stringBuffer.substring(1, s.length() - 1);
        String[] split = substring.split(",");
        int[] ints = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }
        return ints;
    }
}
