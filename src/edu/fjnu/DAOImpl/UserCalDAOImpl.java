package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.UserCalDAO;
import edu.fjnu.Entity.Obsolete.UserCal;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserCalDAOImpl implements UserCalDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public void add(UserCal inf) throws SQLException {
        String sql = "insert into userCal(user_id,food_cal) values(?,?)";
        qr.update(sql, inf.getUser_id(), inf.getFood_cal());
    }

    public void set(UserCal inf) throws SQLException {
        String sql = "update userCal set food_cal where user_id = ?";
        qr.update(sql, inf.getFood_cal(), inf.getUser_id());
    }

    public UserCal queryById(String id) throws SQLException {
        String sql = "select * from userCal where user_id = ?";
        return qr.query(sql, new BeanHandler<UserCal>(UserCal.class), id);
    }
}
