package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.HealthEatDAO;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.Entity.Usual.HealthEat;
import edu.fjnu.exception.HealthEatException;
import edu.fjnu.utils.QueryRunnerWrapper;
import edu.fjnu.utils.StrKit;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;

/**
 * Created by ven_hxz on 16/4/3.
 * 饮食推荐模块查询
 */
public class HealthEatDAOImpl extends HealthEatDAO {
    private QueryRunner qr = new QueryRunnerWrapper();

    private static final String QUERY_STUDENT_HEALTH_EAT_INFO_SQL = "SELECT * FROM healtheat " +
            "WHERE agepart=? AND healthtype = ?";

    private static final String QUERY_HEALTH_TYPE_SQL = "SELECT COUNT(*) FROM healtheat " +
            "WHERE healthtype = ?";

    private static final String QUERY_STUDENT_AGE_PART_SQL = "SELECT user_type FROM student WHERE name = ?";

    /**
     * 根据学生查询该学生的饮食推荐信息
     *
     * @param student 要查询的学生
     * @return 该学生的饮食推荐信息
     * @throws Exception
     */
    @Override
    public HealthEat findHealthEatInfoByUser(Student student, String healthType) throws HealthEatException {
        String userType = student.getUserType();
        HealthEat healthEat;
        Number number;

        try {
            number = (Number) qr.query(QUERY_HEALTH_TYPE_SQL, new ScalarHandler(), healthType);
        } catch (SQLException e) {
            throw new HealthEatException("查询健康推荐方案失败");
        }

        if (StrKit.isBlank(userType)) throw new HealthEatException("指定学生类型不存在");
        if (number.intValue() <= 0) throw new HealthEatException("所查找的健康推荐方案不存在");

        try {
            healthEat = qr.query(QUERY_STUDENT_HEALTH_EAT_INFO_SQL, new BeanHandler<>(HealthEat.class),
                    userType, healthType);
        } catch (SQLException e) {
            throw new HealthEatException("学生类型与所查找的健康推荐方案无法匹配");
        }
        return healthEat;
    }

    /**
     * 查询指定学生的当前所处学习阶段
     *
     * @param student 学生
     * @return 学生的age part
     */
    public String getStudentType(Student student) {
        if (StrKit.isBlank(student.getName())) return null;

        try {
            return (String) qr.query(QUERY_STUDENT_AGE_PART_SQL, new ScalarHandler(),
                    student.getName());
        } catch (SQLException e) {
            return null;
        }
    }
}
