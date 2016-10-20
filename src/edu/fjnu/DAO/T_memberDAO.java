package edu.fjnu.DAO;

import java.sql.SQLException;

import edu.fjnu.Entity.UsersInformation.T_member;

public interface T_memberDAO {

	public abstract T_member queryById(String id) throws SQLException;
	
}
