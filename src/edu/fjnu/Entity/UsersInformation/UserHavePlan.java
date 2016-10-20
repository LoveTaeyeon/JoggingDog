package edu.fjnu.Entity.UsersInformation;

import java.sql.SQLException;

import edu.fjnu.DAO.UserHavePlanDAO;
import edu.fjnu.DAOImpl.UserHavePlanDAOImpl;


public class UserHavePlan {

	private String user_ID;
	private int have_Plan;
	
	public UserHavePlan(){}
	public UserHavePlan(String user_ID,int have_Plan){
		this.user_ID = user_ID;
		this.have_Plan = have_Plan;
	}
	public String getUser_ID() {
		return user_ID;
	}
	public void setUser_ID(String user_ID) {
		this.user_ID = user_ID;
	}
	public int getHave_Plan() {
		return have_Plan;
	}
	public void setHave_Plan(int have_Plan) {
		this.have_Plan = have_Plan;
	}
	public String toString() {
		return "UserHavePlan [user_ID=" + user_ID + ", have_Plan=" + have_Plan
				+ "]";
	}
	public static void main(String[] args) {
		UserHavePlanDAO stu = new UserHavePlanDAOImpl();
		UserHavePlan uu = new UserHavePlan("123",1);
		try {
			stu.add(uu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		try {
//			stu.setHave("123");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			uu =stu.queryById("123012013022");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(uu.toString());
	}
	
}
