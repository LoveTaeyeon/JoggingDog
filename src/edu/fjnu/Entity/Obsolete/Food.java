package edu.fjnu.Entity.Obsolete;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.fjnu.DAO.FoodDAO;
import edu.fjnu.DAOImpl.FoodDAOImpl;

public class Food {

	private String food_num;
	private String food_name;
	private int cal;	//卡路里
	private int eat_num;
	private String type;
	private String meal_type;//(主食，配菜，饮品，果蔬)
	
	public Food(){
		
	}
	
	public Food(String food_num,String food_name,int cal,int eat_num,String type,String meal_type){
		this.food_num = food_num;
		this.food_name = food_name;
		this.cal = cal;
		this.eat_num = eat_num;
		this.type = type;
		this.meal_type = meal_type;
	}

	public String getFood_num() {
		return food_num;
	}

	public void setFood_num(String food_num) {
		this.food_num = food_num;
	}

	public String getFood_name() {
		return food_name;
	}

	public void setFood_name(String food_name) {
		this.food_name = food_name;
	}

	public int getCal() {
		return cal;
	}

	public void setCal(int cal) {
		this.cal = cal;
	}

	public int getEat_num() {
		return eat_num;
	}

	public void setEat_num(int eat_num) {
		this.eat_num = eat_num;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMeal_type() {
		return meal_type;
	}

	public void setMeal_type(String meal_type) {
		this.meal_type = meal_type;
	}
	
	public String toString() {
		return "Food [food_num=" + food_num + ", food_name=" + food_name
				+ ", cal=" + cal + ", eat_num=" + eat_num + ", type=" + type
				+ ", meal_type=" + meal_type + "]";
	}

	public static void main(String[] args) {
		FoodDAO food = new FoodDAOImpl();
		List<Food> ff = new ArrayList<Food>(); 
		try {
			ff = food.queryBreakfastList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0;i < ff.size();i ++){
			System.out.println(ff.get(i).toString());
		}
	}
}
