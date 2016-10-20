package edu.fjnu.DAO;

import java.sql.SQLException;
import edu.fjnu.Entity.UsersInformation.FootNumber;

public interface UserFootNumberDAO {

	public abstract FootNumber queryFootNumber(String userID) throws SQLException;
	public abstract void add(FootNumber info) throws SQLException;
	public abstract void set(FootNumber info) throws SQLException;
	
}
