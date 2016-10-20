package edu.fjnu.Entity.Foot;

public class Foot {
	private String userID;
	private int Foot_Number;
	public Foot() {	}
	public int getFoot_Number() {
		return Foot_Number;
	}
	public void setFoot_Number(int foot_Number) {
		Foot_Number = foot_Number;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
}
