package edu.fjnu.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by vengeance on 16/3/26.
 * 数据库处理小工具
 * > 获取连接池对象
 * > 获取连接对象
 * > 开启事务
 * > 提交事务
 * > 回滚事务
 * > 关闭连接
 */
public class JdbcUtil {
    //连接池对象,默认无参为default-config,否则要给出配置文件中的name-config
    private static ComboPooledDataSource dataSource = new ComboPooledDataSource("dbInfo");
    private static ThreadLocal<Connection> tl = new ThreadLocal<>();//多线程同步

    /**
     * 通过c3p0创建连接池对象
     *
     * @return 连接池对象
     */
    public static DataSource getDataSource() {
        return dataSource;
    }

    /**
     * 通过连接池得到连接对象
     * 如果当前线程已开启事务，有连接对象，使用线程的连接对象
     * 否则从连接池中拿一个连接对象
     *
     * @return 连接对象
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Connection transactionCon = tl.get();//得到当前线程的连接对象

        if (transactionCon != null)//已开启事务，使用事务专用连接对象
            return transactionCon;
        return dataSource.getConnection();//从连接池拿一个连接对象
    }

    /**
     * 得到Connection连接对象，开启事务
     * 并提供该连接对象给DAO的事务使用
     *
     * @throws SQLException
     */
    public static void beginTransaction() throws SQLException {
        Connection transactionCon = tl.get();
        if (transactionCon != null)
            throw new SQLException("已经开启事务，不要重复开启！");

        transactionCon = getConnection();
        tl.set(transactionCon);//保存当前线程的连接对象到多线程同步Map集合
        transactionCon.setAutoCommit(false);//开启事务
    }

    /**
     * 提交事务
     *
     * @throws SQLException
     */
    public static void commitTransaction() throws SQLException {
        Connection transactionCon = tl.get();
        if (transactionCon == null)
            throw new SQLException("尚未开启事务，无法提交！");
        /*
        提交事务
         */
        transactionCon.commit();
        transactionCon.close();
        tl.remove();//从ThreadLocal集合中移除该连接对象
    }

    /**
     * 关闭事务
     *
     * @throws SQLException
     */
    public static void rollbackTransaction() throws SQLException {
        Connection transactionCon = tl.get();
        if (transactionCon == null)
            throw new SQLException("尚未开启事务，无法回滚！");

        /*
        回滚事务
         */
        transactionCon.rollback();
        transactionCon.close();
        tl.remove();//从ThreadLocal集合中移除该连接对象
    }

    /**
     * 关闭非事务的连接
     *
     * @param connection 指定关闭的连接对象
     * @throws SQLException
     */
    public static void closeConnection(Connection connection) throws SQLException {
        Connection transactionCon = tl.get();

        if (transactionCon == null)//事务尚未开启，该连接对象不是事务连接，可以关闭
            connection.close();
        if (transactionCon != connection)
            connection.close();//该对象不是这个事务的连接对象，可以关闭
    }

}
