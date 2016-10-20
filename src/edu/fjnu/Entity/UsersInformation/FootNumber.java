package edu.fjnu.Entity.UsersInformation;

import java.sql.SQLException;

import edu.fjnu.DAO.UserFootNumberDAO;
import edu.fjnu.DAOImpl.UserFootNumberDAOImpl;

	
public class FootNumber {

	private String userID;
	private int Foot_Number;
	
	@Override
	public String toString() {
		return "FootNumber [userID=" + userID + ", Foot_Number=" + Foot_Number
				+ "]";
	}

	public FootNumber(){}
	
	public FootNumber(String userID, int foot_Number) {
		super();
		this.userID = userID;
		Foot_Number = foot_Number;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getFoot_Number() {
		return Foot_Number;
	}
	public void setFoot_Number(int foot_Number) {
		Foot_Number = foot_Number;
	}
	
	public static void main(String[] args) throws SQLException {
		UserFootNumberDAO stu = new UserFootNumberDAOImpl();
		FootNumber foot = new FootNumber("dasdsa",456);	
		stu.set(foot);
	}
	
}
