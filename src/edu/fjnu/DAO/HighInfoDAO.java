package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.Infos.Highinfo;

public interface HighInfoDAO {

	public abstract void add(Highinfo info) throws SQLException;

	public abstract void set(Highinfo info) throws SQLException;

	public abstract Highinfo queryById(String id) throws SQLException;

	public abstract List<Highinfo> queryAll() throws SQLException;

	public abstract long CountInfos() throws SQLException;
	
}
