package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.FoodDAO;
import edu.fjnu.Entity.Obsolete.Food;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class FoodDAOImpl implements FoodDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public List<Food> queryBreakfastList() throws SQLException {
        String sql = "SELECT * FROM food WHERE food_num != ?";
        return qr.query(sql, new BeanListHandler<Food>(Food.class), "2");
    }

    public List<Food> queryLunchAndDinnerList() throws SQLException {
        String sql = "SELECT * FROM food WHERE food_num != ?";
        return qr.query(sql, new BeanListHandler<Food>(Food.class), "1");
    }

}
