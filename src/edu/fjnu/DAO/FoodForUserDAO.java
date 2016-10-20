package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.Obsolete.FoodForUser;

public interface FoodForUserDAO {

	public abstract void addAll(List<FoodForUser> p) throws SQLException;
	public abstract void delete(String UserID) throws SQLException;
	public abstract List<FoodForUser> queryByUserID(String userID) throws SQLException;
	
}
