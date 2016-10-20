package edu.fjnu.DAOImpl;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.utils.QueryRunnerWrapper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import edu.fjnu.DAO.HealthPassageDAO;
import edu.fjnu.Entity.Usual.HealthPassage;

public class HealthPassageDAOImpl implements HealthPassageDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    private static final String INSERT_HEALTH_PASSAGE_SQL =
            "insert into healthpassage(number,title,author,imageStr,passage) values(?,?,?,?,?)";

    private static final String QUERY_HEALTH_PASSAGE_BY_ID_SQL =
            "select * from healthpassage where number = ?";

    private static final String COUNT_HEALTH_PASSAGE_SQL =
            "select count(number) from healthpassage";
    
    private static final String QUERY_HEALTH_PASSAGE_LIST =
            "select * from healthpassage limit 3";

    
    
    
    public void add(HealthPassage hp) throws SQLException {
        qr.update(INSERT_HEALTH_PASSAGE_SQL, hp.getNumber(), hp.getTitle(), hp.getAuthor(), hp.getImageStr(), hp.getPassage());
    }

    public HealthPassage queryById(String id) throws SQLException {
        return qr.query(QUERY_HEALTH_PASSAGE_BY_ID_SQL, new BeanHandler<>(HealthPassage.class), id);
    }

    public long CountHealthPassages() throws SQLException {
        return qr.query(COUNT_HEALTH_PASSAGE_SQL, new ScalarHandler<Long>());
    }

	
	public List<HealthPassage> querylist() throws SQLException {
		return qr.query(QUERY_HEALTH_PASSAGE_LIST, new BeanListHandler<>(HealthPassage.class));
	}

}
