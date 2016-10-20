package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.MiddleUserPartDAO;
import edu.fjnu.Entity.Plan.HealthPlan;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class MiddleUserPartDAOImpl implements MiddleUserPartDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public List<HealthPlan> queryByForwhatAndLevel(String forWhat, String level)
            throws SQLException {
        String sql = "select * from MiddleUserPart where forWhat = ? and level = ?";
        return qr.query(sql, new BeanListHandler<HealthPlan>(HealthPlan.class), forWhat, level);
    }

}
