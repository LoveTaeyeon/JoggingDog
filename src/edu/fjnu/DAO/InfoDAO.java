package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.Infos.Info;

public interface InfoDAO {
	
  public abstract void add(Info info) throws SQLException;
  public abstract void set(Info info) throws SQLException;
  public abstract Info queryById(String id) throws SQLException;
  public abstract List<Info> queryAll() throws SQLException;
  public abstract long CountInfos() throws SQLException;
	
}
