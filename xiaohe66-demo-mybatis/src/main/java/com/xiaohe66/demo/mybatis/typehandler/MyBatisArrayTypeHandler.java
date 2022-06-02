package com.xiaohe66.demo.mybatis.typehandler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

/**
 * 数据库的返回字段是数组时，可以使用该类型转换器转换为 List<String>
 *
 * @author xiaohe
 * @since 2022.06.01 11:52
 */
public class MyBatisArrayTypeHandler implements TypeHandler<List<String>> {

    @Override
    public void setParameter(PreparedStatement preparedStatement, int i, List<String> strings, JdbcType jdbcType) throws SQLException {
        // TODO : impl
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> getResult(ResultSet resultSet, String s) throws SQLException {

        String[] array = (String[]) resultSet.getArray(s).getArray();
        return Arrays.asList(array);
    }

    @Override
    public List<String> getResult(ResultSet resultSet, int i) throws SQLException {
        String[] array = (String[]) resultSet.getArray(i).getArray();
        return Arrays.asList(array);
    }

    @Override
    public List<String> getResult(CallableStatement callableStatement, int i) throws SQLException {
        String[] array = (String[]) callableStatement.getArray(i).getArray();
        return Arrays.asList(array);
    }
}
