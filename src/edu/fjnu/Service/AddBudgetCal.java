package edu.fjnu.Service;

import java.sql.SQLException;

import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.Entity.Infos.Info;

public class AddBudgetCal {

	public static int addCal(String id,int classTime,double interior,double read,double diver){
		
		InfoDAO inf = new InfoDAOImpl(); 
		Info stu = new Info();
		try {
			stu = inf.queryById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int dayTime = 24;			//一天有24小时
		double surplusTime;			//剩余的时间
		double minHourCal;			//每小时最小消耗热量
		surplusTime = dayTime - classTime - interior - read - diver;
		if(stu.getInfo_Sex().equals("M")){
			//男生
			double weight = Double.parseDouble(stu.getWeight());
			minHourCal = (15.2 * weight + 680) / 24;
		}else{
			//女生
			double weight = Double.parseDouble(stu.getWeight());
			minHourCal = (14.6 * weight + 450) / 24;
		}
		double totalCal;
		double classHour;
		classHour = (45 / 60) * classTime;		//把课程的节数转换为上的小时数
		totalCal = surplusTime * minHourCal;
		totalCal = totalCal + classHour * 95;	//加入上课需要消耗的热量
		totalCal = totalCal + interior * 120;	//加入做内务的消耗的热量
		totalCal = totalCal + read * 95;		//加入阅读、写字、电视电影消耗的热量
		totalCal = totalCal + diver * 170;		//加入驾驶、中速步行、擦地等中等体力劳动消耗的热量
		return (int)totalCal;
	}
	
	public static void main(String[] args) {
		
		System.out.println(AddBudgetCal.addCal("123012013022", 4, 1, 2, 1));
		
	}
	
}
