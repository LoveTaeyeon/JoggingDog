package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.Plan.HealthPlan;

public interface HealthPlanDAO {
	
  public abstract List<HealthPlan> queryByForwhatAndLevel(String forWhat,String level) throws SQLException;
	
}
