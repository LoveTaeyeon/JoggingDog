package edu.fjnu.Entity.Obsolete;

public class FoodForUser {

	private String user_id;
	private String food_name;
	private int cal;
	private int eat_num;
	private String type;
	private String meal_type;
	
	public FoodForUser(){}
	
	public FoodForUser(String user_id,String food_name,int cal,int eat_num,String type,String meal_type){
		this.user_id = user_id;
		this.food_name = food_name;
		this.cal = cal;
		this.eat_num = eat_num;
		this.type = type;
		this.meal_type = meal_type;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
		return "FoodForUser [user_id=" + user_id + ", food_name=" + food_name
				+ ", cal=" + cal + ", eat_num=" + eat_num + ", type=" + type
				+ ", meal_type=" + meal_type + "]";
	}
	
	public static void main(String[] args) {
		
	}
	
}
