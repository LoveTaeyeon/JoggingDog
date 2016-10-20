package edu.fjnu.DAO;

import java.sql.SQLException;

import edu.fjnu.Entity.UsersInformation.UserHavePlan;

public interface UserHavePlanDAO {

	  public abstract void setHave(String h) throws SQLException;
	  public abstract void setNo(String h) throws SQLException;
	  public abstract void add(UserHavePlan h) throws SQLException;
	  public abstract UserHavePlan queryById(String id) throws SQLException;
	
}
