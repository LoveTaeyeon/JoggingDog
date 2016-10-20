package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.FoodForUserDAO;
import edu.fjnu.Entity.Obsolete.FoodForUser;
import edu.fjnu.utils.QueryRunnerWrapper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FoodForUserDAOImpl implements FoodForUserDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public void addAll(List<FoodForUser> p) throws SQLException {
        for (int i = 0; i < p.size(); i++) {
            FoodForUser us = new FoodForUser();
            us = p.get(i);
            String sql = "insert into FoodForUser(user_id,food_name,cal,eat_num,type,meal_type) values(?,?,?,?,?,?)";
            qr.update(sql, us.getUser_id(), us.getFood_name(), us.getCal(), us.getEat_num(), us.getType(), us.getMeal_type());
        }
    }

    public void delete(String userID) throws SQLException {
        String sql = "delete from FoodForUser where user_id = ?";
        qr.update(sql, userID);
    }

    public List<FoodForUser> queryByUserID(String userID) throws SQLException {
        String sql = "select * from FoodForUser where user_id = ?";
        return qr.query(sql, new BeanListHandler<FoodForUser>(FoodForUser.class), userID);
    }

}
