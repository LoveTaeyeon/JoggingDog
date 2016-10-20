package edu.fjnu.Entity.Infos;

import java.sql.SQLException;


public class Info {			//实体类，对应数据库中的Info

	private String info_ID;
	private String info_Sex;
	private String age;
	private String height;
	private String weight;
	private String bmi;
	private String bfr;
	private String shortRun;
	private String jump;
	private String longRun;
	private String pullUp;
	
	//构造函数
	
	public Info(){
		
	}
	
	public Info(String ID,String sex,String height,String weight,String jump,String age,String longRun,String shortRun,String pullUp,String bfr,String bmi){
		this.info_ID = ID;
		this.info_Sex = sex;
		this.height = height;
		this.weight = weight;
		this.jump = jump;
		this.age = age;
		this.longRun = longRun;
		this.shortRun = shortRun;
		this.pullUp = pullUp;
		this.bfr = bfr;
		this.bmi = bmi;
	}
	
	//get 和 set 函数
	
	public String getInfo_ID() {
		return info_ID;
	}

	public void setInfo_ID(String info_ID) {
		this.info_ID = info_ID;
	}

	public String getInfo_Sex() {
		return info_Sex;
	}

	public void setInfo_Sex(String info_Sex) {
		this.info_Sex = info_Sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getHeight() {
		return height;
	}

	public void setHeight(String height) {
		this.height = height;
	}

	public String getWeight() {
		return weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	public String getBmi() {
		return bmi;
	}

	public void setBmi(String bmi) {
		this.bmi = bmi;
	}

	public String getBfr() {
		return bfr;
	}

	public void setBfr(String bfr) {
		this.bfr = bfr;
	}

	public String getShortRun() {
		return shortRun;
	}

	public void setShortRun(String shortRun) {
		this.shortRun = shortRun;
	}

	public String getJump() {
		return jump;
	}

	public void setJump(String jump) {
		this.jump = jump;
	}

	public String getLongRun() {
		return longRun;
	}

	public void setLongRun(String longRun) {
		this.longRun = longRun;
	}

	public String getPullUp() {
		return pullUp;
	}

	public void setPullUp(String pullUp) {
		this.pullUp = pullUp;
	}
	
	//toString
	
	public String toString() {
		return "Info [info_ID=" + info_ID + ", info_Sex=" + info_Sex + ", age="
				+ age + ", height=" + height + ", weight=" + weight + ", bmi="
				+ bmi + ", bfr=" + bfr + ", shortRun=" + shortRun + ", jump=" + jump + ", longRun="
				+ longRun + ", pullUp=" + pullUp + "]";
	}
	
	//测试main方法
	
	public static void main(String[] args) throws SQLException {
		 
//		//全部完成
//		Info i = new Info("331","200","200","200","200","200","200","200","200","200","200");
//		InfoDAO in = new InfoDAOImpl();
//		in.set(i);
//		
	}

}
