package edu.fjnu.DAO;

import java.sql.SQLException;
import java.util.List;

import edu.fjnu.Entity.Obsolete.Food;

public interface FoodDAO {

	  public abstract List<Food> queryBreakfastList() throws SQLException;
	  public abstract List<Food> queryLunchAndDinnerList() throws SQLException;
	
}
