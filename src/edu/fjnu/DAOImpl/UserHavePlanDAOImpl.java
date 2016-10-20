package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.UserHavePlanDAO;
import edu.fjnu.Entity.UsersInformation.UserHavePlan;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserHavePlanDAOImpl implements UserHavePlanDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public void add(UserHavePlan h) throws SQLException {
        String sql = "insert into userhaveplan(user_ID,have_Plan) values(?,?)";
        qr.update(sql, h.getUser_ID(), h.getHave_Plan());
    }

    public void setNo(String user_ID) throws SQLException {
        int i = 0;
        String sql = "update userhaveplan set have_Plan = ? where user_ID = ?";
        qr.update(sql, i, user_ID);
    }

    public void setHave(String user_ID) throws SQLException {
        int i = 1;
        String sql = "update userhaveplan set have_Plan = ? where user_ID = ?";
        qr.update(sql, i, user_ID);
    }

    public UserHavePlan queryById(String id) throws SQLException {
        String sql = "select * from userhaveplan where user_ID = ?";
        return qr.query(sql, new BeanHandler<UserHavePlan>(UserHavePlan.class), id);
    }

}
