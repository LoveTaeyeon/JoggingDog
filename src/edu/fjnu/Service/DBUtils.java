package edu.fjnu.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * 数据库操作工具类
 * 导入mysql数据驱动包
 * 使用C3P0导入两个jar包及配置c3p0-config.xml
 */
public class DBUtils {
	
	private static DataSource ds = new ComboPooledDataSource("dbInfo");
	//定义一个获取数据库连接的方法
     public static Connection getConnection(){
    	 Connection conn = null;
    	 try {
    		//使用C3P0数据库连接池获取数据库链接
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return conn;
     }
     
 	 // 关闭数据库连接
     public static void close(ResultSet rs,Statement stat,Connection conn){
			try {
			if(rs!=null)
				rs.close();
			if(stat!=null)
				stat.close();
			if(conn!=null)
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
     }
}
