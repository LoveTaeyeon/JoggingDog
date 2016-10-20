package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.HighUserPartDAO;
import edu.fjnu.Entity.Plan.HealthPlan;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class HighUserPartDAOImpl implements HighUserPartDAO {

    private QueryRunner qr = new QueryRunnerWrapper();


    public List<HealthPlan> queryByForwhatAndLevel(String forWhat, String level)
            throws SQLException {
        String sql = "select * from HighUserPart where forWhat = ? and level = ?";
        return qr.query(sql, new BeanListHandler<HealthPlan>(HealthPlan.class), forWhat, level);
    }


}
