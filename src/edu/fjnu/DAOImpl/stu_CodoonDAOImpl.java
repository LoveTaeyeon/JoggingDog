package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.stu_CodoonDAO;
import edu.fjnu.Entity.UsersInformation.stu_Codoon;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class stu_CodoonDAOImpl implements stu_CodoonDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public void add(stu_Codoon stu) throws SQLException {
        String sql = "insert into stu_codoon(CODOON_ID,c_username,c_password) values(?,?,?)";
        qr.update(sql, stu.getCodoon_id(), stu.getC_username(), stu.getC_password());
    }

    public void set(stu_Codoon stu) throws SQLException {
        String sql = "update stu_codoon set c_username = ?,c_password = ? where CODOON_ID = ?";
        qr.update(sql, stu.getC_username(), stu.getC_password(), stu.getCodoon_id());
    }

    public stu_Codoon queryById(String id) throws SQLException {
        String sql = "select * from stu_codoon where codoon_id= ?";
        return qr.query(sql, new BeanHandler<stu_Codoon>(stu_Codoon.class), id);
    }

}
