package edu.fjnu.getPlan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.fjnu.DAO.MiddleUserPartDAO;
import edu.fjnu.DAOImpl.MiddleUserPartDAOImpl;
import edu.fjnu.Entity.Plan.HealthPlan;
import edu.fjnu.Service.Translater.MiddleTranslate;

public class MiddleGetPlan {

	public static List<HealthPlan> getPlan(String userID, String forWhat,
			String level) { 
		// 算法，向用户推荐方案的算法
		List<HealthPlan> list = new ArrayList<HealthPlan>();
		MiddleUserPartDAO hea = new MiddleUserPartDAOImpl();
		MiddleTranslate translater = new MiddleTranslate();
		try {
			// 先得到用户的等级和部位适合的动作
			list = hea.queryByForwhatAndLevel(forWhat, level);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 加入核心肌群，因为核心肌群什么部位都是用的到的
		// List<HealthPlan> coreMuscleGroup = new ArrayList<HealthPlan>();
		// try {
		// coreMuscleGroup = hea.queryByForwhatAndLevel("核心肌群",level);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// list.addAll(coreMuscleGroup);
		// 利用随机数
		if (list.size() <= 3) { // 如果拿到的动作太小，按照正常来说，满足我们的需求，可以把这个取到的集合直接返回
			return list;
		} else { // 拿到的数据量大，则用我们的算法进行筛选和返回
			// 根据运动强度来进行选择，随机选择，强中弱都要有
			List<HealthPlan> powerHigh = new ArrayList<HealthPlan>();
			List<HealthPlan> powerMiddle = new ArrayList<HealthPlan>();
			List<HealthPlan> powerLow = new ArrayList<HealthPlan>();
			// List<HealthPlan> suitForEveryOne = new ArrayList<HealthPlan>();
			// //针对核心肌群
			// List<HealthPlan> suitForThisPlay = new ArrayList<HealthPlan>();
			// //针对单一运动
			// try { //取出核心肌群和该运动里面适合各个等级的，准备加入推荐方案中，增加容错率
			// suitForEveryOne = hea.queryByForwhatAndLevel("核心肌群",level);
			// //suitForThisPlay = hea.queryByForwhatAndLevel(forWhat,
			// "适合各个等级");
			// } catch (SQLException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			for (int i = 0; i < list.size(); i++) { // 把原来的list进行再分类，分为低中高三种强度，把他们分类放到不同的池内
				if (list.get(i).getHardLevel().equals("高")) {
					powerHigh.add(list.get(i)); // 封装进高强度运动池中
				} else if (list.get(i).getHardLevel().equals("中")) {
					powerMiddle.add(list.get(i)); // 封装进中等强度运动池中
				} else {
					powerLow.add(list.get(i)); // 封装进低强度运动池中
				}
			}
			Random radom = new Random(); // 通过随机数，随机挑选一种运动，避免用户疲劳
			list.clear(); // 把原先的集合清空，再做重新封装

			/*
			 * 根据体脂率决定运动强度等级的分配 正常状态下，各种强度应该均匀分配 偏瘦状态下，少量剧烈运动，中低强度运动偏多
			 * 超重状态下，应该中等强度运动居多 肥胖状态下，不宜进行剧烈运动，应以低强度运动居多
			 */

			if (translater.translateBMI(userID).equals("正常")) {
				list.add(powerLow.get(radom.nextInt(powerLow.size()))); // 给最终数据封装进一个低强度的运动
				list.add(powerMiddle.get(radom.nextInt(powerMiddle.size())));// 封装进一个中等强度的运动
				list.add(powerHigh.get(radom.nextInt(powerHigh.size()))); // 封装进一个高强度的运动
				// list.add(suitForThisPlay.get(radom.nextInt(suitForThisPlay.size())));//封装进一个适合于各个等级的锻炼该项目运动
				return list;
			} else if (translater.translateBMI(userID).equals("偏瘦")) {
				int temp = radom.nextInt(powerMiddle.size());
				list.add(powerMiddle.get(temp));// 封装进一个中等强度的运动
				while (true) {
					// 随机到一个不同的运动
					if (powerMiddle.size() <= 1) {
						System.out.println("中等强度运动不足两个！");
						break;
					}
					int i = radom.nextInt(powerMiddle.size());
					if (i != temp) {
						list.add(powerMiddle.get(i));// 再封装进一个中等强度的运动
						break;
					}
				}
				int t = radom.nextInt(powerLow.size());
				list.add(powerLow.get(t));// 封装进一个低强度的运动
				while (true) {
					// 随机到一个不同的运动
					if (powerLow.size() <= 1) {
						System.out.println("低强度运动不足两个！");
						break;
					}
					int i = radom.nextInt(powerLow.size());
					if (i != t) {
						list.add(powerLow.get(i));// 再封装进一个低强度的运动
						break;
					}
				}
				// list.add(powerLow.get(radom.nextInt(powerLow.size())));
				// //给最终数据封装进一个低强度的运动
				list.add(powerHigh.get(radom.nextInt(powerHigh.size()))); // 封装进一个高强度的运动
				return list;
			} else if (translater.translateBMI(userID).equals("超重")) {
				list.add(powerLow.get(radom.nextInt(powerLow.size()))); // 给最终数据封装进一个低强度的运动
				int temp = radom.nextInt(powerMiddle.size());
				list.add(powerMiddle.get(temp));// 封装进一个中等强度的运动
				while (true) {
					// 随机到一个不同的运动
					if (powerMiddle.size() <= 1) {
						System.out.println("中等强度运动不足两个！");
						break;
					}
					int i = radom.nextInt(powerMiddle.size());
					if (i != temp) {
						list.add(powerMiddle.get(i));// 再封装进一个中等强度的运动
						break;
					}
				}
				list.add(powerHigh.get(radom.nextInt(powerHigh.size()))); // 封装进一个高强度的运动
				return list;
			} else {
				// 为肥胖状态，不适合做剧烈运动
				int temp = radom.nextInt(powerLow.size());
				list.add(powerLow.get(temp));// 封装进一个低强度的运动
				while (true) {
					// 随机到一个不同的运动
					if (powerLow.size() <= 1) {
						System.out.println("低强度运动不足两个！");
						break;
					}
					int i = radom.nextInt(powerLow.size());
					if (i != temp) {
						list.add(powerLow.get(i));// 再封装进一个低强度的运动
						break;
					}
				}
				list.add(powerMiddle.get(radom.nextInt(powerMiddle.size())));// 封装进一个中等强度的运动
				// list.add(suitForThisPlay.get(radom.nextInt(suitForThisPlay.size())));//封装进一个适合于各个等级的锻炼该项目运动
				return list;
			}

		}
	}

	public static void main(String[] args) {
		List<HealthPlan> planList = MiddleGetPlan.getPlan("无常_", "台阶测试", "良好");
		for(int i = 0;i < planList.size();i++){
			System.out.println(planList.get(i));
		}
	}
	
}
