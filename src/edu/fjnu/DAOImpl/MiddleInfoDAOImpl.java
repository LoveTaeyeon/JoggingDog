package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.MiddleInfoDAO;
import edu.fjnu.Entity.Infos.Middleinfo;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class MiddleInfoDAOImpl implements MiddleInfoDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public void add(Middleinfo inf) throws SQLException {
        String sql = "insert into Middleinfo(INFO_ID,INFO_SEX,age,height,weight,BMI,BFR,"
                + "pullUp,skipRope,benchTest,sitAndReach) values(?,?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql, inf.getINFO_ID(), inf.getINFO_SEX(), inf.getAge(), inf.getHeight(), inf.getWeight(),
                inf.getBMI(), inf.getBFR(), inf.getPullUp(), inf.getSkipRope(), inf.getBenchTest(), inf.getSitAndReach());
    }

    //未完成
    public void set(Middleinfo inf) throws SQLException {
        String sql = "update Middleinfo set age = ?,height = ?,weight = ?,BMI = ?,BFR = ?,pullUp = ?,skipRope = ?,benchTest = ?,sitAndReach = ?where INFO_ID = ?";
        qr.update(sql, inf.getAge(), inf.getHeight(), inf.getWeight(),
                inf.getBMI(), inf.getBFR(), inf.getPullUp(), inf.getSkipRope(), inf.getBenchTest(), inf.getSitAndReach(), inf.getINFO_ID());
    }

    public Middleinfo queryById(String id) throws SQLException {
        String sql = "select * from Middleinfo where info_ID = ?";
        return qr.query(sql, new BeanHandler<Middleinfo>(Middleinfo.class), id);
    }

    public List<Middleinfo> queryAll() throws SQLException {
        String sql = "select * from Middleinfo";
        return qr.query(sql, new BeanListHandler<Middleinfo>(Middleinfo.class));
    }

    public long CountInfos() throws SQLException {
        String sql = "select count(info_ID) from Middleinfo";
        return qr.query(sql, new ScalarHandler<Long>());
    }

}
