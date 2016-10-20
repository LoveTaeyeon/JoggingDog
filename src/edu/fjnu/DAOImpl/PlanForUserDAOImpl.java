package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.PlanForUserDAO;
import edu.fjnu.Entity.UsersInformation.PlanForUser;
import edu.fjnu.utils.QueryRunnerWrapper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class PlanForUserDAOImpl implements PlanForUserDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public void addAll(List<PlanForUser> p) throws SQLException {
        for (int i = 0; i < p.size(); i++) {
            PlanForUser us = new PlanForUser();
            us = p.get(i);
            String sql = "insert into planforuser(pfu_user_id,pfu_name,pfu_level,pfu_groupnum,pfu_exercisepart,pfu_hardlevel,pfu_forwhat) values(?,?,?,?,?,?,?)";
            qr.update(sql, us.getPfu_user_id(), us.getPfu_name(), us.getPfu_level(), us.getPfu_groupnum(), us.getPfu_exercisepart(), us.getPfu_hardlevel(), us.getPfu_forwhat());
        }
    }

    public void delete(String userID) throws SQLException {
        String sql = "delete from planforuser where pfu_user_id = ?";
        qr.update(sql, userID);
    }

    public List<PlanForUser> queryByUserID(String userID) throws SQLException {
        String sql = "select * from planforuser where pfu_user_id = ?";
        return qr.query(sql, new BeanListHandler<PlanForUser>(PlanForUser.class), userID);
    }

}
