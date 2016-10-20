package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.Entity.Infos.Info;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class InfoDAOImpl implements InfoDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public void add(Info inf) throws SQLException {
        String sql = "insert into CollegeAndGraduateInfo(INFO_ID,INFO_SEX,age,height,weight,BMI,BFR,shortRun,jump,longRun,pullUp) values(?,?,?,?,?,?,?,?,?,?,?)";
        qr.update(sql, inf.getInfo_ID(), inf.getInfo_Sex(), inf.getAge(), inf.getHeight(), inf.getWeight(), inf.getBmi(), inf.getBfr(), inf.getShortRun(), inf.getJump(), inf.getLongRun(), inf.getPullUp());
    }

    //未完成
    public void set(Info inf) throws SQLException {
        String sql = "update CollegeAndGraduateInfo set height = ?,weight = ?,jump = ?,age = ?,longRun = ?,shortRun = ?,pullUp = ?,BFR = ?,BMI = ? where info_ID = ?";
        qr.update(sql, inf.getHeight(), inf.getWeight(), inf.getJump(), inf.getAge(), inf.getLongRun(), inf.getShortRun(), inf.getPullUp(), inf.getBfr(), inf.getBmi(), inf.getInfo_ID());
    }

    public Info queryById(String id) throws SQLException {
        String sql = "select * from CollegeAndGraduateInfo where info_ID = ?";
        return qr.query(sql, new BeanHandler<Info>(Info.class), id);
    }

    public List<Info> queryAll() throws SQLException {
        String sql = "select * from CollegeAndGraduateInfo";
        return qr.query(sql, new BeanListHandler<Info>(Info.class));
    }

    public long CountInfos() throws SQLException {
        String sql = "select count(info_ID) from CollegeAndGraduateInfo";
        return qr.query(sql, new ScalarHandler<Long>());
    }

}
