package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.HealthPlanDAO;
import edu.fjnu.Entity.Plan.HealthPlan;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class HealthPlanDAOImpl implements HealthPlanDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public List<HealthPlan> queryByForwhatAndLevel(String forWhat, String level) throws SQLException {
        String sql = "select * from CollegeUserPart where forWhat = ? and level = ?";
        return qr.query(sql, new BeanListHandler<HealthPlan>(HealthPlan.class), forWhat, level);
    }

}
