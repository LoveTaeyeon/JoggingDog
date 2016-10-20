package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.Infos.Middleinfo;

public interface MiddleInfoDAO {

	public abstract void add(Middleinfo info) throws SQLException;

	public abstract void set(Middleinfo info) throws SQLException;

	public abstract Middleinfo queryById(String id) throws SQLException;

	public abstract List<Middleinfo> queryAll() throws SQLException;

	public abstract long CountInfos() throws SQLException;
	
}
