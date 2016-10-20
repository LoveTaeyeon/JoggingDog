package edu.fjnu.DAOImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import edu.fjnu.DAO.T_memberDAO;
import edu.fjnu.Entity.UsersInformation.T_member;
import edu.fjnu.utils.QueryRunnerWrapper;

public class T_memberDAOImpl implements T_memberDAO{

	private QueryRunner qr = new QueryRunnerWrapper();
	
	public T_member queryById(String id) throws SQLException {
        String sql = "select * from t_member where accountNo = ?";
        return qr.query(sql, new BeanHandler<T_member>(T_member.class), id);
    }

}
