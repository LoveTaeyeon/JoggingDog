package edu.fjnu.Service;

import java.sql.SQLException;

import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAO.T_memberDAO;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.DAOImpl.T_memberDAOImpl;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.Entity.UsersInformation.T_member;

public class LoginAndRegister {
	
	public LoginAndRegister(){
		//构造函数
	}
	
	public boolean isExist(String ID) throws SQLException{ 				
		StudentDAO stu = new StudentDAOImpl();
		T_memberDAO t = new T_memberDAOImpl();
		T_member user = new T_member();
		user = t.queryById(ID);
		Student s = stu.queryById(ID);
		if(s != null || user != null){
			System.out.println("存在该用户！");
			return true;
		}else{
			System.out.println("可以注册新用户！");
			return false;
		}
	}
	
	public boolean judgePassword(String ID,String password) throws SQLException{
		//验证密码是否正确
		StudentDAO stu = new StudentDAOImpl();
		Student s = stu.queryById(ID);
		if(s == null){
			System.out.println("用户不存在");
			return false;
		}if(s.getPassword().equals(password)){
			System.out.println("用户名密码匹配");
			return true;
		}
		return false;
	}
	
	public boolean isSamePassword(String p1,String p2){
		//检查注册时用户两次输入密码的一致情况
		if(p1.equals(p2)){
			System.out.println("两次密码输入一致！");
			return true;
		}else{
			System.out.println("您两次输入的密码不一致！");
			return false;
		}
	}
	
	public boolean isFull(String name,String p1,String p2,String number,String sex){
		
		//检验注册时是否完成输入
		if(name == null){
			System.out.println("您未完成输入！");
			return false;
		}else if(p1 == null){
			System.out.println("您未完成输入！");
			return false;
		}else if(p2 == null){
			System.out.println("您未完成输入！");
			return false;
		}else if(number == null){
			System.out.println("您未完成输入！");
			return false;
		}else if(sex == null){
			System.out.println("您未完成输入！");
			return false;
		}else{
			System.out.println("恭喜您完成了输入！");
			return true;
		}
	}
	
	public void setStudent(String ID,String name,String password,String sex) throws SQLException{
		//创建新用户
		StudentDAO stu = new StudentDAOImpl();
		Student s = new Student();
		s.setName(name);
		s.setPassword(password);
		s.setStu_ID(ID);
		s.setStu_Sex(sex);
		stu.add(s);
		System.out.println("创建新用户成功！");
	}
	
	public static void main(String[] args) {
		//测试
	}
}
