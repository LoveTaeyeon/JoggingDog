package edu.fjnu.Service;

import java.sql.SQLException;

import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAO.UserCalDAO;
import edu.fjnu.DAO.stu_CodoonDAO;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.DAOImpl.UserCalDAOImpl;
import edu.fjnu.DAOImpl.stu_CodoonDAOImpl;
import edu.fjnu.Entity.Infos.Info;
import edu.fjnu.Entity.Obsolete.UserCal;
import edu.fjnu.Entity.UsersInformation.stu_Codoon;
import edu.fjnu.Entity.Usual.TestBodyFatTemp;
import edu.fjnu.webCrawlers.Crawlers;

public class AddFloatCal {		//计算变化后的卡路里
	
	public static int addCal(String id){
		
		UserCalDAO user = new UserCalDAOImpl();
		UserCal stu = new UserCal();
		try {
			stu = user.queryById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(stu == null){
			System.out.println("该用户还没有选择方案！");
			return 0;
		}
		InfoDAO inf = new InfoDAOImpl(); 
		Info info = new Info();
		try {
			info = inf.queryById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(info == null){
			System.out.println("（浮动卡路里）未成功提取该用户信息！");
			return 0;
		}
		stu_CodoonDAO codoon = new stu_CodoonDAOImpl();
		stu_Codoon sc = new stu_Codoon();
		try {
			sc = codoon.queryById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sc == null){
			System.out.println("该用户并未绑定咕咚账号！");
			return stu.getFood_cal();
		}else{
			//绑定咕咚数据后进行浮动运算
			TestBodyFatTemp temp = new TestBodyFatTemp();
			try {
				//调用函数，完成封装
				temp = Crawlers.getTemp(id, sc.getC_username(), sc.getC_password());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			double minHourCal;
			if(info.getInfo_Sex().equals("M")){
				//男生
				double weight = Double.parseDouble(info.getWeight());
				minHourCal = (15.2 * weight + 680) / 24;
			}else{
				//女生
				double weight = Double.parseDouble(info.getWeight());
				minHourCal = (14.6 * weight + 450) / 24;
			}
			double totalCal = stu.getFood_cal();
			int runTime = Integer.parseInt(temp.getTime()) / 60;
			totalCal = Double.parseDouble(temp.getPower()) - (runTime * minHourCal);		//减去原本算去的基本热量
			//totalCal = totalCal + Double.parseDouble(temp.getPower());	//加上咕咚扒取的卡路里
			return (int)totalCal; 
		}
	}
	
	public static void main(String[] args) {
		
		System.out.println(AddFloatCal.addCal("123012013022"));
		
	}

}
