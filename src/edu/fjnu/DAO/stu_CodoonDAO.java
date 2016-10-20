package edu.fjnu.DAO;

import java.sql.SQLException;

import edu.fjnu.Entity.UsersInformation.stu_Codoon;

public interface stu_CodoonDAO {

	  public abstract void add(stu_Codoon stu) throws SQLException;
	  public abstract void set(stu_Codoon stu) throws SQLException;
	  public abstract stu_Codoon queryById(String id) throws SQLException;
	
}
