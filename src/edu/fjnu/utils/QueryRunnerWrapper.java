package edu.fjnu.utils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by vengeance on 16/3/26.
 * 包装增强QueryRunner
 * 覆盖父类中所有不带Connection的方法
 * 进一步完善事务处理
 */
public class QueryRunnerWrapper extends QueryRunner {
    @Override
    public int[] batch(String sql, Object[][] params) throws SQLException {
        /*
        得到Connection连接对象
        如果是事务就执行事务；如果不是，就正常执行
        如果是事务连接，就什么都不干；如果不是，就关闭连接(由closeConnection自己处理)
         */
        Connection con = JdbcUtil.getConnection();
        int[] result = super.batch(con, sql, params);
        JdbcUtil.closeConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh, Object... params) throws SQLException {
        Connection con = JdbcUtil.getConnection();
        T result = super.query(con, sql, rsh, params);
        JdbcUtil.closeConnection(con);
        return result;
    }

    @Override
    public <T> T query(String sql, ResultSetHandler<T> rsh) throws SQLException {
        Connection con = JdbcUtil.getConnection();
        T result = super.query(con, sql, rsh);
        JdbcUtil.closeConnection(con);
        return result;
    }

    @Override
    public int update(String sql) throws SQLException {
        Connection con = JdbcUtil.getConnection();
        int result = super.update(con, sql);
        JdbcUtil.closeConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object param) throws SQLException {
        Connection con = JdbcUtil.getConnection();
        int result = super.update(con, sql, param);
        JdbcUtil.closeConnection(con);
        return result;
    }

    @Override
    public int update(String sql, Object... params) throws SQLException {
        Connection con = JdbcUtil.getConnection();
        int result = super.update(con, sql, params);
        JdbcUtil.closeConnection(con);
        return result;
    }
}
