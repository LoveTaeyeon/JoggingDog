package edu.fjnu.Entity.Obsolete;

public class UserCal {

	private String user_id;
	private int food_cal;
	
	public UserCal(){}
	
	public UserCal(String user_id,int food_cal){
		this.user_id = user_id;
		this.food_cal = food_cal;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getFood_cal() {
		return food_cal;
	}

	public void setFood_cal(int food_cal) {
		this.food_cal = food_cal;
	}
	
	public String toString() {
		return "UserCal [user_id=" + user_id + ", food_cal=" + food_cal + "]";
	}

	public static void main(String[] args) {
		
	}
	
}
