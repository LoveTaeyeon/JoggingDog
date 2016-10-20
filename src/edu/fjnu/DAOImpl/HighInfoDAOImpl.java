package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.HighInfoDAO;
import edu.fjnu.Entity.Infos.Highinfo;
import edu.fjnu.utils.QueryRunnerWrapper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class HighInfoDAOImpl implements HighInfoDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public void add(Highinfo inf) throws SQLException {
        String sql = "insert into Highinfo(INFO_ID,INFO_SEX,age,height,weight,BMI,BFR,"
                + "benchTest,longRun,throwBall,sitAndReach) values(?,?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql, inf.getINFO_ID(), inf.getINFO_SEX(), inf.getAge(), inf.getHeight(), inf.getWeight(),
                inf.getBMI(), inf.getBFR(), inf.getBenchTest(), inf.getLongRun(), inf.getThrowBall(), inf.getSitAndReach());
    }

    //未完成
    public void set(Highinfo inf) throws SQLException {
        String sql = "update Highinfo set age = ?,height = ?,weight = ?,BMI = ?,BFR = ?,benchTest = ?,longRun = ?,throwBall = ?,sitAndReach = ?where INFO_ID = ?";
        qr.update(sql, inf.getAge(), inf.getHeight(), inf.getWeight(),
                inf.getBMI(), inf.getBFR(), inf.getBenchTest(), inf.getLongRun(), inf.getThrowBall(), inf.getSitAndReach(), inf.getINFO_ID());
    }

    public Highinfo queryById(String id) throws SQLException {
        String sql = "select * from Highinfo where INFO_ID = ?";
        return qr.query(sql, new BeanHandler<Highinfo>(Highinfo.class), id);
    }

    public List<Highinfo> queryAll() throws SQLException {
        String sql = "select * from Highinfo";
        return qr.query(sql, new BeanListHandler<Highinfo>(Highinfo.class));
    }

    public long CountInfos() throws SQLException {
        String sql = "select count(info_ID) from Highinfo";
        return qr.query(sql, new ScalarHandler<Long>());
    }

}
