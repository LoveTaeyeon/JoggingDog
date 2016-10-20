package edu.fjnu.DAOImpl;

import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.utils.QueryRunnerWrapper;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;


public class StudentDAOImpl implements StudentDAO {

    private QueryRunner qr = new QueryRunnerWrapper();

    public void add(Student stu) throws SQLException {
        String sql = "insert into student(STU_ID,Name,STU_SEX,Password,userType) values(?,?,?,?,?)";
        qr.update(sql, stu.getStu_ID(), stu.getName(), stu.getStu_Sex(), stu.getPassword(),stu.getUserType());
    }

    public void set(Student stu) throws SQLException {
        String sql = "update student set password = ? where STU_ID = ?";
        qr.update(sql, stu.getPassword(), stu.getStu_ID());
    }

    public Student queryById(String id) throws SQLException {
        String sql = "select * from student where STU_ID = ?";
        return qr.query(sql, new BeanHandler<Student>(Student.class), id);
    }

    public void setType(String id, String type) {
        String sql = "update student set userType = ? where STU_ID = ?";
        try {
            qr.update(sql, type, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> queryAll() throws SQLException {
        String sql = "select * from student";
        return qr.query(sql, new BeanListHandler<Student>(Student.class));
    }

    public long CountStudents() throws SQLException {
        String sql = "select count(STU_ID) from student";
        return qr.query(sql, new ScalarHandler<Long>());
    }

    /**
     * 根据学生姓名查询该学生信息
     *
     * @param studentName 学生姓名
     * @return 学生bean
     * @throws SQLException
     */
    public Student queryStudentByName(String studentName) throws SQLException {
        return qr.query("select * from student where stu_id = ?",
                new BeanHandler<>(Student.class), studentName);
    }

}
