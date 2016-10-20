package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.Obsolete.StudentPlan;

public interface StudentPlanDAO {

  public abstract void add(StudentPlan stu) throws SQLException;
//  public abstract void delete(String id) throws SQLException;
  public abstract void set(StudentPlan stu) throws SQLException;
  public abstract StudentPlan queryById(String id) throws SQLException;
  public abstract List<StudentPlan> queryAll() throws SQLException;
  public abstract long CountStudentPlans() throws SQLException;
	
}
