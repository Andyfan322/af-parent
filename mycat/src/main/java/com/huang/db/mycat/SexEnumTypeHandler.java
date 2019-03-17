package com.huang.db.mycat;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author andyFan
 * @since 2019年03月10日
 */
public class SexEnumTypeHandler extends BaseTypeHandler<SexEnum> {

    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, SexEnum sexEnum, JdbcType jdbcType) throws SQLException {
        preparedStatement.setInt(i, sexEnum.getCode());

    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, String s) throws SQLException {
        int code = resultSet.getInt(s);
        return SexEnum.getInstance(code);
    }

    @Override
    public SexEnum getNullableResult(ResultSet resultSet, int i) throws SQLException {
        int code = resultSet.getInt(i);
        return SexEnum.getInstance(code);
    }

    @Override
    public SexEnum getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        int code = callableStatement.getInt(i);
        return SexEnum.getInstance(code);

    }
}
