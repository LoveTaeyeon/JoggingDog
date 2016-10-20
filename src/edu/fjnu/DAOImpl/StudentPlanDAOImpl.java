package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.StudentPlanDAO;
import edu.fjnu.Entity.Obsolete.StudentPlan;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class StudentPlanDAOImpl implements StudentPlanDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public void add(StudentPlan stu) throws SQLException {
        String sql = "insert into studentPlan(SP_STU_ID,SP_PLAN_ID,isFinish) values(?,?,?)";
        qr.update(sql, stu.getSp_stu_ID(), stu.getSp_plan_ID(), stu.isFinish());
    }

    public void set(StudentPlan stu) throws SQLException {
        String sql = "update studentPlan set isFinish = ? where SP_STU_ID = ?";
        qr.update(sql, stu.isFinish(), stu.getSp_stu_ID());
    }

    public StudentPlan queryById(String id) throws SQLException {
        String sql = "select * from studentPlan where SP_STU_ID = ?";
        return qr.query(sql, new BeanHandler<StudentPlan>(StudentPlan.class), id);
    }

    public List<StudentPlan> queryAll() throws SQLException {
        String sql = "select * from studentPlan";
        return qr.query(sql, new BeanListHandler<StudentPlan>(StudentPlan.class));
    }

    public long CountStudentPlans() throws SQLException {
        String sql = "select count(SP_STU_ID) from studentPlan";
        return qr.query(sql, new ScalarHandler<Long>());
    }

}
