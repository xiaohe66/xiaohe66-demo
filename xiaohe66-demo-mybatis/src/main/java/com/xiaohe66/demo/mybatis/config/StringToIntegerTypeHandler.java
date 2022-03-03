package com.xiaohe66.demo.mybatis.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author xiaohe
 * @since 2022.03.03 18:19
 */
@Slf4j
@MappedJdbcTypes(JdbcType.VARCHAR)
public class StringToIntegerTypeHandler implements TypeHandler<Integer> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Integer parameter, JdbcType jdbcType) throws SQLException {
        log.info("setParameter, i : {}, parameter : {}, jdbcType : {}", i, parameter, jdbcType);
    }

    @Override
    public Integer getResult(ResultSet rs, String columnName) throws SQLException {
        return getResult(rs, rs.findColumn(columnName));
    }

    @Override
    public Integer getResult(ResultSet rs, int columnIndex) throws SQLException {
        String string = rs.getString(columnIndex);
        return toInteger(string);
    }

    @Override
    public Integer getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String string = cs.getString(columnIndex);
        return toInteger(string);
    }

    private Integer toInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            log.error("转换失败 : {} , errMsg : {}", string, e.getMessage());
            return null;
        }
    }


}
