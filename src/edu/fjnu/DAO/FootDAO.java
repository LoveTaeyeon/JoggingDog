package edu.fjnu.DAO;

import java.sql.SQLException;

import edu.fjnu.Entity.Foot.Foot;

public interface FootDAO {
	public abstract Foot findLatsOne(String name) throws SQLException;
}
