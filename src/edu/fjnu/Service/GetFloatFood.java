package edu.fjnu.Service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import edu.fjnu.DAO.FoodForUserDAO;
import edu.fjnu.DAOImpl.FoodForUserDAOImpl;
import edu.fjnu.Entity.Obsolete.FoodForUser;

public class GetFloatFood {

	public static List<FoodForUser> getNewPlan(int cal,String user_id){
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("HH:mm:ss");
		Date breakfastTime = null;
		Date lunchTime = null;
		//Date dinnerTime = null;
		try {
			breakfastTime = format.parse("09:00:00");	//定义早餐时间限制
			lunchTime = format.parse("14:00:00");		//定义午餐时间限制
			//dinnerTime = format.parse("20:00:00");		//定义晚餐时间限制
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FoodForUserDAO stu = new FoodForUserDAOImpl();
		List<FoodForUser> stuList = new ArrayList<FoodForUser>();
		try {
			stuList = stu.queryByUserID(user_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(date.getTime() < breakfastTime.getTime()){
			//如果在早餐之前锻炼，则锻炼消耗的卡路里平均分配在三餐中
			double breakfastCal,lunchCal,dinnerCal;
			//为三餐进行热量值得分配
			breakfastCal = cal * 0.25;
			lunchCal = cal * 0.4;
			dinnerCal = cal * 0.35;
			List<FoodForUser> userBreakfast = new ArrayList<FoodForUser>();
			List<FoodForUser> userLunch = new ArrayList<FoodForUser>();
			List<FoodForUser> userDinner = new ArrayList<FoodForUser>();
			for(int i = 0;i < stuList.size();i++){
				if(i<4){
					userBreakfast.add(stuList.get(i));
				}else if(i>=4 && i<8){
					userLunch.add(stuList.get(i));
				}else{
					userDinner.add(stuList.get(i));
				}
			}
			while(true){
				if(breakfastCal >= 300){
					System.out.println("早餐加主食！");
					for(int i = 0;i<userBreakfast.size();i++){
						if(userBreakfast.get(i).getMeal_type().equals("主食")){
							userBreakfast.get(i).setEat_num(2);
							int tempCal = userBreakfast.get(i).getCal();
							userBreakfast.get(i).setCal(2*tempCal);
						}
					}
					break;
				}else{
					//早餐加蔬果类
					double temp = 0;
					int tempOne = 0,tempTwo = 0;
					FoodForUser gardenOne = new FoodForUser();
					FoodForUser gardenTwo = new FoodForUser();
					for(int i = 0;i < userBreakfast.size();i++){
						if(userBreakfast.get(i).getMeal_type().equals("果蔬")){
							gardenOne = userBreakfast.get(i);
							tempOne = i;
							gardenTwo = userBreakfast.get(i+1);
							tempTwo = i+1;
							break;
						}
					}
					while(true){
						double calOne,calTwo;
						calOne = gardenOne.getCal() * temp;
						calTwo = gardenTwo.getCal() * temp;
						if(Math.abs(calOne + calTwo - breakfastCal) < 10){
							int tempOneCal = gardenOne.getCal();
							int tempOneNum = gardenOne.getEat_num();
							userBreakfast.get(tempOne).setCal((int)(tempOneCal * (1 + temp)));
							userBreakfast.get(tempOne).setEat_num((int)(tempOneNum * (1 + temp)));
							int tempTwoCal = gardenTwo.getCal();
							int tempTwoNum = gardenTwo.getEat_num();
							userBreakfast.get(tempTwo).setCal((int)(tempTwoCal * (1 + temp)));
							userBreakfast.get(tempTwo).setEat_num((int)(tempTwoNum * (1 + temp)));
							break;
						}
						temp = temp + 0.1;
					}
					break;
				}
			}//添加早餐结束
			while(true){
				//添加午餐
				int tempOne = 0,tempTwo = 0;
				FoodForUser StapleFoodOne = new FoodForUser();
				FoodForUser StapleFoodTwo = new FoodForUser();
				for(int i = 0;i < userLunch.size();i++){
					if(userLunch.get(i).getMeal_type().equals("主食")){
						StapleFoodOne = userLunch.get(i);
						tempOne = i;
						StapleFoodTwo = userLunch.get(i+1);
						tempTwo = i+1;
						break;
					}
				}
				while(true){
					double temp = 0;		//午餐杠杆
					double calOne,calTwo;
					calOne = StapleFoodOne.getCal() * temp;
					calTwo = StapleFoodTwo.getCal() * temp;
					if(Math.abs(calOne + calTwo - lunchCal) < 10){
						int tempOneCal = StapleFoodOne.getCal();
						int tempOneNum = StapleFoodOne.getEat_num();
						userLunch.get(tempOne).setCal((int)(tempOneCal * (1 + temp)));
						userLunch.get(tempOne).setEat_num((int)(tempOneNum * (1 + temp)));
						int tempTwoCal = StapleFoodTwo.getCal();
						int tempTwoNum = StapleFoodTwo.getEat_num();
						userLunch.get(tempTwo).setCal((int)(tempTwoCal * (1 + temp)));
						userLunch.get(tempTwo).setEat_num((int)(tempTwoNum * (1 + temp)));
						break;
					}
					temp = temp + 0.02;
				}
				break;
			}//添加午餐结束
			while(true){
				//添加晚餐
				double temp = 0;		//晚餐杠杆
				int tempOne=0,tempTwo=0;
				FoodForUser StapleFoodOne = new FoodForUser();
				FoodForUser StapleFoodTwo = new FoodForUser();
				for(int i = 0;i < userDinner.size();i++){
					if(userDinner.get(i).getMeal_type().equals("主食")){
						StapleFoodOne = userDinner.get(i);
						tempOne = i;
						StapleFoodTwo = userDinner.get(i+1);
						tempTwo = i +1;
						break;
					}
				}
				while(true){
					double calOne,calTwo;
					calOne = StapleFoodOne.getCal() * temp;
					calTwo = StapleFoodTwo.getCal() * temp;
					if(Math.abs(calOne + calTwo - dinnerCal) < 10){
						int tempOneCal = StapleFoodOne.getCal();
						int tempOneNum = StapleFoodOne.getEat_num();
						userDinner.get(tempOne).setCal((int)(tempOneCal * (1 + temp)));
						userDinner.get(tempOne).setEat_num((int)(tempOneNum * (1 + temp)));
						int tempTwoCal = StapleFoodTwo.getCal();
						int tempTwoNum = StapleFoodTwo.getEat_num();
						userDinner.get(tempTwo).setCal((int)(tempTwoCal * (1 + temp)));
						userDinner.get(tempTwo).setEat_num((int)(tempTwoNum * (1 + temp)));
						break;
					}
					temp = temp + 0.01;
				}
				break;
			}//添加晚餐结束
			List<FoodForUser> userFoodList = new ArrayList<FoodForUser>();
			userFoodList.addAll(userBreakfast);
			userFoodList.addAll(userLunch);
			userFoodList.addAll(userDinner);
			return userFoodList;
		}else if(date.getTime() > breakfastTime.getTime() && date.getTime() < lunchTime.getTime()){
			//如果子啊午餐之前锻炼并查看套餐信息，则能量分配在午餐和晚餐中
			double lunchCal,dinnerCal;
			//为2餐进行热量值得分配
			lunchCal = cal * 0.53;		//占的比例
			dinnerCal = cal * 0.47;
			List<FoodForUser> userBreakfast = new ArrayList<FoodForUser>();
			List<FoodForUser> userLunch = new ArrayList<FoodForUser>();
			List<FoodForUser> userDinner = new ArrayList<FoodForUser>();
			for(int i = 0;i < stuList.size();i++){
				if(i>=4 && i<8){
					userLunch.add(stuList.get(i));
				}else if(i>=8){
					userDinner.add(stuList.get(i));
				}else{
					userBreakfast.add(stuList.get(i));
				}
			}
			while(true){
				//添加午餐
				int tempOne = 0,tempTwo = 0;
				FoodForUser StapleFoodOne = new FoodForUser();
				FoodForUser StapleFoodTwo = new FoodForUser();
				for(int i = 0;i < userLunch.size();i++){
					if(userLunch.get(i).getMeal_type().equals("主食")){
						StapleFoodOne = userLunch.get(i);
						tempOne = i;
						StapleFoodTwo = userLunch.get(i+1);
						tempTwo = i + 1;
						break;
					}
				}
				while(true){
					double temp = 0;		//午餐杠杆
					double calOne,calTwo;
					calOne = StapleFoodOne.getCal() * temp;
					calTwo = StapleFoodTwo.getCal() * temp;
					if(Math.abs(calOne + calTwo - lunchCal) < 10){
						int tempOneCal = StapleFoodOne.getCal();
						int tempOneNum = StapleFoodOne.getEat_num();
						userLunch.get(tempOne).setCal((int)(tempOneCal * (1 + temp)));
						userLunch.get(tempOne).setEat_num((int)(tempOneNum * (1 + temp)));
						int tempTwoCal = StapleFoodTwo.getCal();
						int tempTwoNum = StapleFoodTwo.getEat_num();
						userLunch.get(tempTwo).setCal((int)(tempTwoCal * (1 + temp)));
						userLunch.get(tempTwo).setEat_num((int)(tempTwoNum * (1 + temp)));
						break;
					}
					temp = temp + 0.02;
				}
				break;
			}//添加午餐结束
			while(true){
				//添加晚餐
				double temp = 0;		//晚餐杠杆
				int tempOne = 0,tempTwo = 0;
				FoodForUser StapleFoodOne = new FoodForUser();
				FoodForUser StapleFoodTwo = new FoodForUser();
				for(int i = 0;i < userDinner.size();i++){
					if(userDinner.get(i).getMeal_type().equals("主食")){
						StapleFoodOne = userDinner.get(i);
						tempOne = i;
						StapleFoodTwo = userDinner.get(i+1);
						tempTwo = i + 1;
						break;
					}
				}
				while(true){
					double calOne,calTwo;
					calOne = StapleFoodOne.getCal() * temp;
					calTwo = StapleFoodTwo.getCal() * temp;
					if(Math.abs(calOne + calTwo - dinnerCal) < 10){
						int tempOneCal = StapleFoodOne.getCal();
						int tempOneNum = StapleFoodOne.getEat_num();
						userDinner.get(tempOne).setCal((int)(tempOneCal * (1 + temp)));
						userDinner.get(tempOne).setEat_num((int)(tempOneNum * (1 + temp)));
						int tempTwoCal = StapleFoodTwo.getCal();
						int tempTwoNum = StapleFoodTwo.getEat_num();
						userDinner.get(tempTwo).setCal((int)(tempTwoCal * (1 + temp)));
						userDinner.get(tempTwo).setEat_num((int)(tempTwoNum * (1 + temp)));
						break;
					}
					temp = temp + 0.01;
				}
				break;
			}//添加晚餐结束
			List<FoodForUser> userFoodList = new ArrayList<FoodForUser>();
			userFoodList.addAll(userBreakfast);
			userFoodList.addAll(userLunch);
			userFoodList.addAll(userDinner);
			return userFoodList;
		}else{
			//if(date.getTime() > lunchTime.getTime() && date.getTime() < dinnerTime.getTime()){
			//如果在晚餐之前锻炼并查看套餐信息，则能量分配在晚餐中
			double dinnerCal;
			dinnerCal = cal;
			List<FoodForUser> userBreakfast = new ArrayList<FoodForUser>();
			List<FoodForUser> userLunch = new ArrayList<FoodForUser>();
			List<FoodForUser> userDinner = new ArrayList<FoodForUser>();
			for(int i = 0;i < stuList.size();i++){
				if(i<4){
					userBreakfast.add(stuList.get(i));
				}else if(i>=4 && i<8){
					userLunch.add(stuList.get(i));
				}else{
					userDinner.add(stuList.get(i));
				}
			}
			while(true){
				//添加晚餐
				double temp = 0;		//晚餐杠杆
				int tempOne = 0,tempTwo = 0,i = 0;
				FoodForUser StapleFoodOne = new FoodForUser();
				FoodForUser StapleFoodTwo = new FoodForUser();
				while(i < userDinner.size()){
					//System.out.println(userDinner.get(i).toString());
					if(userDinner.get(i).getMeal_type().equals("主食")){
						StapleFoodOne = userDinner.get(i);
						tempOne = i;
						StapleFoodTwo = userDinner.get(i+1);
						tempTwo = i+1;
						break;
					}
					i++;
				}
				while(true){
					double calOne,calTwo;
					calOne = StapleFoodOne.getCal() * temp;
					calTwo = StapleFoodTwo.getCal() * temp;
					if(Math.abs(calOne + calTwo - dinnerCal) < 10){
						int tempOneCal = StapleFoodOne.getCal();
						int tempOneNum = StapleFoodOne.getEat_num();
						userDinner.get(tempOne).setCal((int)(tempOneCal * (1 + temp)));
						userDinner.get(tempOne).setEat_num((int)(tempOneNum * (1 + temp)));
						int tempTwoCal = StapleFoodTwo.getCal();
						int tempTwoNum = StapleFoodTwo.getEat_num();
						userDinner.get(tempTwo).setCal((int)(tempTwoCal * (1 + temp)));
						userDinner.get(tempTwo).setEat_num((int)(tempTwoNum * (1 + temp)));
						break;
					}
					temp = temp + 0.01;
				}
				break;
			}//添加晚餐结束
			List<FoodForUser> userFoodList = new ArrayList<FoodForUser>();
			userFoodList.addAll(userBreakfast);
			userFoodList.addAll(userLunch);
			userFoodList.addAll(userDinner);
			return userFoodList;
		}
	}
	
}
