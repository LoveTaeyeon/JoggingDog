package edu.fjnu.Entity.UsersInformation;

import java.sql.SQLException;

import edu.fjnu.DAOImpl.stu_CodoonDAOImpl;


public class stu_Codoon {		//实体类，对应数据库中的stu_Codoon

	private String codoon_id;
	private String c_username;
	private String c_password;
	
	public stu_Codoon(){
		
	}
	
	public stu_Codoon(String codoon_id,String c_username,String c_password){
		this.codoon_id = codoon_id;
		this.c_username = c_username;
		this.c_password = c_password;
	}

	public String getCodoon_id() {
		return codoon_id;
	}

	public void setCodoon_id(String codoon_id) {
		this.codoon_id = codoon_id;
	}

	public String getC_username() {
		return c_username;
	}

	public void setC_username(String c_username) {
		this.c_username = c_username;
	}

	public String getC_password() {
		return c_password;
	}

	public void setC_password(String c_password) {
		this.c_password = c_password;
	}
	
	public String toString() {
		return "stu_Codoon [codoon_id=" + codoon_id + ", c_username="
				+ c_username + ", c_password=" + c_password + "]";
	}

	public static void main(String[] args) {
		
		stu_CodoonDAOImpl stu = new stu_CodoonDAOImpl();
		stu_Codoon ss = new stu_Codoon();
//		try {
//			stu.add(ss);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		try {
			ss = stu.queryById("101");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(ss.toString());
//		try {
//			stu.set(ss);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
}
