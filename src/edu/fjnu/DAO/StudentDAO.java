package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.UsersInformation.Student;

public interface StudentDAO {
	public abstract void add(Student stu) throws SQLException;
	public abstract void setType(String id,String type);
    // public abstract void add(Student stu) throws SQLException;
    //    public abstract void delete(String id) throws SQLException;
    public abstract void set(Student stu) throws SQLException;
    public abstract Student queryById(String id) throws SQLException;
    public abstract List<Student> queryAll() throws SQLException;
    public abstract long CountStudents() throws SQLException;
    public abstract Student queryStudentByName(String studentName) throws SQLException;
    
}
