package edu.fjnu.DAOImpl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import edu.fjnu.DAO.FootDAO;
import edu.fjnu.Entity.Foot.Foot;
import edu.fjnu.utils.QueryRunnerWrapper;
import edu.fjnu.webCrawlers.main;

public class FootDAOImpl implements FootDAO {

	private QueryRunner qr = new QueryRunnerWrapper();
	 
	@Override
	public Foot findLatsOne(String name) throws SQLException {
		String sql = "select * from UserFootNumber where userID=?";
		return qr.query(sql, new BeanHandler<Foot>(Foot.class), name);
	}
}
