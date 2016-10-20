package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.Infos.Primaryinfo;

public interface PrimaryInfoDAO {

	public abstract void add(Primaryinfo info) throws SQLException;

	public abstract void set(Primaryinfo info) throws SQLException;

	public abstract Primaryinfo queryById(String id) throws SQLException;

	public abstract List<Primaryinfo> queryAll() throws SQLException;

	public abstract long CountInfos() throws SQLException;

}
