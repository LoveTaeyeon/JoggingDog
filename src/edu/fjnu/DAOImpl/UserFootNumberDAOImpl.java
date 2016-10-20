package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.UserFootNumberDAO;
import edu.fjnu.Entity.UsersInformation.FootNumber;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserFootNumberDAOImpl implements UserFootNumberDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public void add(FootNumber inf) throws SQLException {
        String sql = "insert into UserFootNumber(userID,Foot_Number) values(?,?)";
        qr.update(sql, inf.getUserID(), inf.getFoot_Number());
    }

    //未完成
    public void set(FootNumber inf) throws SQLException {
        String sql = "update UserFootNumber set Foot_Number = ? where userID = ?";
        qr.update(sql, inf.getFoot_Number(), inf.getUserID());
    }

    public FootNumber queryFootNumber(String id) throws SQLException {
        String sql = "select * from UserFootNumber where userID = ?";
        return qr.query(sql, new BeanHandler<FootNumber>(FootNumber.class), id);
    }

}
