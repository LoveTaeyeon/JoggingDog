package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.PrimaryInfoDAO;
import edu.fjnu.Entity.Infos.Primaryinfo;
import edu.fjnu.utils.QueryRunnerWrapper;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class PrimaryInfoDAOImpl implements PrimaryInfoDAO {

    private QueryRunner qr = new QueryRunnerWrapper();


    public void add(Primaryinfo inf) throws SQLException {
        String sql = "insert into Primaryinfo(INFO_ID,INFO_SEX,age,height,weight,BMI,BFR,"
                + "FVC,shortRun,skipRope,sitAndReach) values(?,?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql, inf.getINFO_ID(), inf.getINFO_SEX(), inf.getAge(), inf.getHeight(), inf.getWeight(),
                inf.getBMI(), inf.getBFR(), inf.getFVC(), inf.getShortRun(), inf.getSkipRope(), inf.getSitAndReach());
    }

    //未完成
    public void set(Primaryinfo inf) throws SQLException {
        String sql = "update Primaryinfo set age = ?,height = ?,weight = ?,BMI = ?,BFR = ?,FVC = ?,shortRun = ?,skipRope = ?,sitAndReach = ?where INFO_ID = ?";
        qr.update(sql, inf.getAge(), inf.getHeight(), inf.getWeight(),
                inf.getBMI(), inf.getBFR(), inf.getFVC(), inf.getShortRun(), inf.getSkipRope(), inf.getSitAndReach(), inf.getINFO_ID());
    }

    public Primaryinfo queryById(String id) throws SQLException {
        String sql = "select * from Primaryinfo where info_ID = ?";
        return qr.query(sql, new BeanHandler<Primaryinfo>(Primaryinfo.class), id);
    }

    public List<Primaryinfo> queryAll() throws SQLException {
        String sql = "select * from Primaryinfo";
        return qr.query(sql, new BeanListHandler<Primaryinfo>(Primaryinfo.class));
    }

    public long CountInfos() throws SQLException {
        String sql = "select count(info_ID) from Primaryinfo";
        return qr.query(sql, new ScalarHandler<Long>());
    }

}
