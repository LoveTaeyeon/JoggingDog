package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.Usual.Action;

public interface ActionDAO {
	public abstract List<Action> queryAll()throws SQLException;
}
