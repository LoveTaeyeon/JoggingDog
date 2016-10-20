package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.Usual.HealthPassage;

public interface HealthPassageDAO {

  public abstract void add(HealthPassage stu) throws SQLException;
  public abstract HealthPassage queryById(String id) throws SQLException;
  public abstract long CountHealthPassages() throws SQLException;
  public abstract List<HealthPassage> querylist() throws SQLException;	
}
