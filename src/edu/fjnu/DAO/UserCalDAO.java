package edu.fjnu.DAO;

import java.sql.SQLException;

import edu.fjnu.Entity.Obsolete.UserCal;

public interface UserCalDAO {

      public abstract void add(UserCal u) throws SQLException;
	  public abstract void set(UserCal u) throws SQLException;
	  public abstract UserCal queryById(String id) throws SQLException;
	
}
