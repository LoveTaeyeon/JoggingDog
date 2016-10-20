package edu.fjnu.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.fjnu.DAO.FoodDAO;
import edu.fjnu.DAOImpl.FoodDAOImpl;
import edu.fjnu.Entity.Obsolete.Food;
import edu.fjnu.Entity.Obsolete.FoodForUser;

public class GetBugetFood {

	public static List<Food> getFood(int cal){
		
//		Date date=new Date();
//		DateFormat format=new SimpleDateFormat("HH:mm:ss");
//		Date breakfastTime = null;
//		Date lunchTime = null;
//		Date dinnerTime = null;
//		try {
//			breakfastTime = format.parse("09:00:00");	//定义早餐时间限制
//			lunchTime = format.parse("14:00:00");		//定义午餐时间限制
//			dinnerTime = format.parse("20:00:00");		//定义晚餐时间限制
//		} catch (ParseException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		List<Food> foodPlan = new ArrayList<Food>();
		List<Food> stuBreakfast = new ArrayList<Food>();
		List<Food> stuLunch = new ArrayList<Food>();
		List<Food> stuDinner = new ArrayList<Food>();
		List<Food> breakfast = new ArrayList<Food>();
		List<Food> lunchAndDinner = new ArrayList<Food>();
		FoodDAO foodList = new FoodDAOImpl();
		try {
			breakfast = foodList.queryBreakfastList();
			lunchAndDinner = foodList.queryLunchAndDinnerList();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Food> breakfastStapleFood = new ArrayList<Food>();
		List<Food> breakfastDrink = new ArrayList<Food>();
		List<Food> breakfastGarden = new ArrayList<Food>();
		//封装早餐
		for(int i =0;i<breakfast.size();i++){
			if(breakfast.get(i).getMeal_type().equals("主食")){
				breakfastStapleFood.add(breakfast.get(i));	//把主食封装进主食池
			}else if(breakfast.get(i).getMeal_type().equals("饮品")){
				breakfastDrink.add(breakfast.get(i));		//把饮品封装进饮品池
			}else{
				breakfastGarden.add(breakfast.get(i));		//把果蔬封装进果蔬池
			}
		}
		//封装午餐和晚餐
		List<Food> AllStapleFood = new ArrayList<Food>();
		List<Food> AllDrink = new ArrayList<Food>();
		List<Food> AllGarden = new ArrayList<Food>();
		for(int i =0;i<lunchAndDinner.size();i++){
			if(lunchAndDinner.get(i).getMeal_type().equals("主食")){
				AllStapleFood.add(lunchAndDinner.get(i));	//把主食封装进主食池
			}else if(lunchAndDinner.get(i).getMeal_type().equals("饮品")){
				AllDrink.add(lunchAndDinner.get(i));		//把饮品封装进饮品池
			}else{
				AllGarden.add(lunchAndDinner.get(i));		//把果蔬封装进果蔬池
			}
		}
		Random random = new Random();
		double breakfastCal;
		double lunchCal;
		double dinnerCal;
		//给每餐分配合理的卡路里
		breakfastCal = cal * 0.25;
		lunchCal = cal * 0.4;
		dinnerCal = cal * 0.35;
		//生成一份早餐
		while(true){
			//给早餐添加主食(固定的)
			int num = 1;	//蔬果类杠杆
			double breakfastStapleFoodCal;
			double breakfastDrinkCal = 0;
			double breakfastGardenCal = 0;
			if(breakfastStapleFood.size() <= 1){
				breakfastStapleFoodCal = breakfastStapleFood.get(0).getCal();
				stuBreakfast.addAll(breakfastStapleFood);
			}
			else{
				int i = random.nextInt(breakfastStapleFood.size());
				breakfastStapleFoodCal = breakfastStapleFood.get(i).getCal();
				stuBreakfast.add(breakfastStapleFood.get(i));
			}//给早餐添加主食结束
			//给早餐添加饮品
			if(breakfastDrink.size() <= 1){
				breakfastStapleFoodCal = breakfastStapleFood.get(0).getCal();
				stuBreakfast.addAll(breakfastDrink);
			}
			else{
				stuBreakfast.add(breakfastDrink.get(random.nextInt(breakfastDrink.size())));
			}//给早餐添加饮品结束
			//给早餐添加果蔬类
			if(breakfastGarden.size() <= 2){		//如果比两中更少
				stuBreakfast.addAll(breakfastGarden);	//全部的果蔬类都添加
			}else{
				int temp = random.nextInt(breakfastGarden.size());
				while(true){
					int temp2 = random.nextInt(breakfastGarden.size());
					if(temp != temp2){
						if(breakfastGarden.get(temp).getCal() < breakfastGarden.get(temp2).getCal()){
							breakfastGardenCal = breakfastGarden.get(temp2).getCal();
							breakfastGardenCal = breakfastGardenCal + num * breakfastGarden.get(temp).getCal();
							int tempNumber = breakfastGarden.get(temp).getEat_num();
							int tempCal = breakfastGarden.get(temp).getCal();
							breakfastGarden.get(temp).setCal(num * tempCal);
							breakfastGarden.get(temp).setEat_num(num * tempNumber);
							stuBreakfast.add(breakfastGarden.get(temp));
							stuBreakfast.add(breakfastGarden.get(temp2));
							break;
						}else{
							breakfastGardenCal = breakfastGarden.get(temp).getCal();
							breakfastGardenCal = breakfastGardenCal + num * breakfastGarden.get(temp2).getCal();
							int tempNumber = breakfastGarden.get(temp2).getEat_num();
							int tempCal = breakfastGarden.get(temp2).getCal();
							breakfastGarden.get(temp2).setCal(num * tempCal);
							breakfastGarden.get(temp2).setEat_num(num * tempNumber);
							stuBreakfast.add(breakfastGarden.get(temp));
							stuBreakfast.add(breakfastGarden.get(temp2));
							break;
						}
					}
				}
			}//早餐添加果蔬类结束
			num++;
			if(Math.abs(breakfastCal - (breakfastStapleFoodCal + breakfastDrinkCal + breakfastGardenCal)) < 30){
				System.out.println("早餐方案生成完成！");
				break;
			}else{
				stuBreakfast.clear();
			}
		}//生成早餐结束
		//生成一份午餐
		while(true){
			//给午餐添加主食(固定的)
			int num = 1;	//蔬果类杠杆
			double lunchStapleFoodCal = 0;
			double lunchGardenCal = 0;
			//给午餐添加主食
			if(AllStapleFood.size() <= 2){		//如果比两中更少
				stuLunch.addAll(AllStapleFood);	//全部的果蔬类都添加
			}else{
				int temp = random.nextInt(AllStapleFood.size());
				while(true){
					int temp2 = random.nextInt(AllStapleFood.size());
					if(temp != temp2){
						if(AllStapleFood.get(temp).getCal() < AllStapleFood.get(temp2).getCal()){
							lunchStapleFoodCal = AllStapleFood.get(temp2).getCal();
							lunchStapleFoodCal = lunchStapleFoodCal + num * AllStapleFood.get(temp).getCal();
							int tempNumber = AllStapleFood.get(temp).getEat_num();
							int tempCal = AllStapleFood.get(temp).getCal();
							AllStapleFood.get(temp).setCal(num * tempCal);
							AllStapleFood.get(temp).setEat_num(num * tempNumber);
							stuLunch.add(AllStapleFood.get(temp));
							stuLunch.add(AllStapleFood.get(temp2));
							break;
						}else{
							lunchStapleFoodCal = AllStapleFood.get(temp).getCal();
							lunchStapleFoodCal = lunchStapleFoodCal + num * AllStapleFood.get(temp2).getCal();
							int tempNumber = AllStapleFood.get(temp2).getEat_num();
							int tempCal = AllStapleFood.get(temp2).getCal();
							AllStapleFood.get(temp2).setCal(num * tempCal);
							AllStapleFood.get(temp2).setEat_num(num * tempNumber);
							stuLunch.add(AllStapleFood.get(temp));
							stuLunch.add(AllStapleFood.get(temp2));
							break;
						}
					}
				}
			}//午餐添加主食结束
			//给午餐添加蔬果类
			if(AllGarden.size() <= 2){		//如果比两中更少
				stuLunch.addAll(AllGarden);	//全部的果蔬类都添加
			}else{
				int temp = random.nextInt(AllGarden.size());
				while(true){
					int temp2 = random.nextInt(AllGarden.size());
					if(temp != temp2){
						if(AllGarden.get(temp).getCal() < AllGarden.get(temp2).getCal()){
							lunchGardenCal = AllGarden.get(temp2).getCal();
							lunchGardenCal = lunchGardenCal + num * AllGarden.get(temp).getCal();
							int tempNumber = AllGarden.get(temp).getEat_num();
							int tempCal = AllGarden.get(temp).getCal();
							AllGarden.get(temp).setCal(num * tempCal);
							AllGarden.get(temp).setEat_num(num * tempNumber);
							stuLunch.add(AllGarden.get(temp));
							stuLunch.add(AllGarden.get(temp2));
							break;
						}else{
							lunchGardenCal = AllGarden.get(temp).getCal();
							lunchGardenCal = lunchGardenCal + num * AllGarden.get(temp2).getCal();
							int tempNumber = AllGarden.get(temp2).getEat_num();
							int tempCal = AllGarden.get(temp2).getCal();
							AllGarden.get(temp2).setCal(num * tempCal);
							AllGarden.get(temp2).setEat_num(num * tempNumber);
							stuLunch.add(AllGarden.get(temp));
							stuLunch.add(AllGarden.get(temp2));
							break;
						}
					}
				}
			}//午餐添加蔬果类结束
			num++;
			if(Math.abs(lunchCal - (lunchStapleFoodCal + lunchGardenCal)) < 40){
				System.out.println("午餐方案生成完成！");
				break;
			}else{
				stuLunch.clear();
			}
		}//生成午餐结束
		//生成一份晚餐
		while(true){
			//给晚餐添加主食(固定的)
			int num = 1;	//蔬果类杠杆
			double dinnerStapleFoodCal = 0;
			double dinnerGardenCal = 0;
			//给晚餐添加主食
			if(AllStapleFood.size() <= 2){		//如果比两中更少
				stuDinner.addAll(AllStapleFood);	
			}else{
				int temp = random.nextInt(AllStapleFood.size());
				while(true){
					int temp2 = random.nextInt(AllStapleFood.size());
					if(temp != temp2){
						if(AllStapleFood.get(temp).getCal() < AllStapleFood.get(temp2).getCal()){
							dinnerStapleFoodCal = AllStapleFood.get(temp2).getCal();
							dinnerStapleFoodCal = dinnerStapleFoodCal + num * AllStapleFood.get(temp).getCal();
							int tempNumber = AllStapleFood.get(temp).getEat_num();
							int tempCal = AllStapleFood.get(temp).getCal();
							AllStapleFood.get(temp).setCal(num * tempCal);
							AllStapleFood.get(temp).setEat_num(num * tempNumber);
							stuDinner.add(AllStapleFood.get(temp));
							stuDinner.add(AllStapleFood.get(temp2));
							break;
						}else{
							dinnerStapleFoodCal = AllStapleFood.get(temp).getCal();
							dinnerStapleFoodCal = dinnerStapleFoodCal + num * AllStapleFood.get(temp2).getCal();
							int tempNumber = AllStapleFood.get(temp2).getEat_num();
							int tempCal = AllStapleFood.get(temp2).getCal();
							AllStapleFood.get(temp2).setCal(num * tempCal);
							AllStapleFood.get(temp2).setEat_num(num * tempNumber);
							stuDinner.add(AllStapleFood.get(temp));
							stuDinner.add(AllStapleFood.get(temp2));
							break;
						}
					}
				}
			}//晚餐添加主食结束
			//给晚餐添加蔬果类
			if(AllGarden.size() <= 2){		//如果比两中更少
				stuDinner.addAll(AllGarden);	//全部的果蔬类都添加
			}else{
				int temp = random.nextInt(AllGarden.size());
				while(true){
					int temp2 = random.nextInt(AllGarden.size());
					if(temp != temp2){
						if(AllGarden.get(temp).getCal() < AllGarden.get(temp2).getCal()){
							dinnerGardenCal = AllGarden.get(temp2).getCal();
							dinnerGardenCal = dinnerGardenCal + num * AllGarden.get(temp).getCal();
							int tempNumber = AllGarden.get(temp).getEat_num();
							int tempCal = AllGarden.get(temp).getCal();
							AllGarden.get(temp).setCal(num * tempCal);
							AllGarden.get(temp).setEat_num(num * tempNumber);
							stuDinner.add(AllGarden.get(temp));
							stuDinner.add(AllGarden.get(temp2));
							break;
						}else{
							dinnerGardenCal = AllGarden.get(temp).getCal();
							dinnerGardenCal = dinnerGardenCal + num * AllGarden.get(temp2).getCal();
							int tempNumber = AllGarden.get(temp2).getEat_num();
							int tempCal = AllGarden.get(temp2).getCal();
							AllGarden.get(temp2).setCal(num * tempCal);
							AllGarden.get(temp2).setEat_num(num * tempNumber);
							stuDinner.add(AllGarden.get(temp));
							stuDinner.add(AllGarden.get(temp2));
							break;
						}
					}
				}
			}//晚餐添加蔬果类结束
			num++;
			if(Math.abs(dinnerCal - (dinnerStapleFoodCal + dinnerGardenCal)) < 50){
				System.out.println("晚餐方案生成完成！");
				break;
			}else{
				stuDinner.clear();
			}
		}//生成晚餐结束
		foodPlan.addAll(stuBreakfast);			//加入早餐
		foodPlan.addAll(stuLunch);				//加入午餐
		foodPlan.addAll(stuDinner);				//加入晚餐
		return foodPlan;
	}
	
	public static void main(String[] args) {
		
		//List<Food> ff = GetBugetFood.getFood(2250);
		List<FoodForUser> list = GetFloatFood.getNewPlan(120, "123012013022");
		//List<FoodForUser> list = new ArrayList<FoodForUser>();
		for(int i = 0;i < list.size();i++){
			System.out.println(list.get(i).toString());
		}
//		FoodForUserDAO stu = new FoodForUserDAOImpl();
//		try {
//			stu.delete("123012013022");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for(int i =0;i<ff.size();i++){
//			FoodForUser f = new FoodForUser();
//			f.setUser_id("123012013022");
//			f.setFood_name(ff.get(i).getFood_name());
//			f.setCal(ff.get(i).getCal());
//			f.setEat_num(ff.get(i).getEat_num());
//			f.setType(ff.get(i).getType());
//			f.setMeal_type(ff.get(i).getMeal_type());
//			list.add(f);
//		}
//		try {
//			stu.addAll(list);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
