package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.UsersInformation.PlanForUser;
public interface PlanForUserDAO {

	public abstract void addAll(List<PlanForUser> p) throws SQLException;
	public abstract void delete(String UserID) throws SQLException;
	public abstract List<PlanForUser> queryByUserID(String userID) throws SQLException;
	
}
