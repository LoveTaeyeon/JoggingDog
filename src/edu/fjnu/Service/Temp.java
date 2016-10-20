package edu.fjnu.Service;

public class Temp {

	private String massage;
	private int num;
	
	public Temp(){
		
	}
	
	public Temp(String massage,int num){
		this.massage = massage;
		this.num = num;
	}

	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
	
}
