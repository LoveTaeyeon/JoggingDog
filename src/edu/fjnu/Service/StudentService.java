package edu.fjnu.Service;

import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.exception.ApplicationException;

import java.sql.SQLException;

/**
 * Created by ven_hxz on 16/4/4.
 */
public class StudentService {
    private static StudentDAO studentDAO = new StudentDAOImpl();

    /**
     * 根据学生姓名查询学生信息
     *
     * @param studentName 学生姓名
     * @return 学生信息
     */
    public Student getStudentByName(String studentName) throws ApplicationException {
        try {
            return studentDAO.queryStudentByName(studentName);
        } catch (SQLException e) {
            throw new ApplicationException("未找到所查询学生");
        }
    }

    /**
     * 根据学生ID查询学生信息
     *
     * @param userID 学生ID
     * @return 学生信息
     */
    public Student getStudentByID(String userID) throws ApplicationException {
        try {
            return studentDAO.queryById(userID);
        } catch (SQLException e) {
            throw new ApplicationException("未找到所查询学生");
        }
    }
}
