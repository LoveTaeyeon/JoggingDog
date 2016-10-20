/**
 * 
 */
package edu.fjnu.webCrawlers;

import java.sql.SQLException;

import edu.fjnu.DAO.HighInfoDAO;
import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAO.MiddleInfoDAO;
import edu.fjnu.DAO.PrimaryInfoDAO;
import edu.fjnu.DAO.StudentDAO;
import edu.fjnu.DAOImpl.HighInfoDAOImpl;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.DAOImpl.MiddleInfoDAOImpl;
import edu.fjnu.DAOImpl.PrimaryInfoDAOImpl;
import edu.fjnu.DAOImpl.StudentDAOImpl;
import edu.fjnu.Entity.Infos.Highinfo;
import edu.fjnu.Entity.Infos.Info;
import edu.fjnu.Entity.Infos.Middleinfo;
import edu.fjnu.Entity.Infos.Primaryinfo;
import edu.fjnu.Entity.UsersInformation.Student;
import edu.fjnu.Entity.Usual.TestBodyFatTemp;

/**
 * @author Cerulean
 * 
 */
public class Crawlers {
	/**
	 * @param args
	 * @return 
	 * @throws SQLException 
	 */
	public static TestBodyFatTemp getTemp(String userID,String login_id,String password) throws SQLException {
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("input your username:");
//		String login_id = scanner.nextLine();
//		System.out.println("input your password:");
//		String password = scanner.nextLine();
		TestBodyFatTemp tbft = new TestBodyFatTemp();
		StudentDAO stu = new StudentDAOImpl();
		Student user = new Student();
		user = stu.queryById(userID);
		if(user.getUserType().equals("Primary")){
			PrimaryInfoDAO inf = new PrimaryInfoDAOImpl();
			Primaryinfo i = inf.queryById(userID);
			tbft.setAge(Integer.parseInt(i.getAge()));
			tbft.setHeight(Double.parseDouble(i.getHeight()) * 100);
			tbft.setWeight(Double.parseDouble(i.getWeight()));
		}else if(user.getUserType().equals("Middle")){
			MiddleInfoDAO inf = new MiddleInfoDAOImpl();
			Middleinfo i = inf.queryById(userID);
			tbft.setAge(Integer.parseInt(i.getAge()));
			tbft.setHeight(Double.parseDouble(i.getHeight()) * 100);
			tbft.setWeight(Double.parseDouble(i.getWeight()));
		}else if(user.getUserType().equals("High")){
			HighInfoDAO inf = new HighInfoDAOImpl();
			Highinfo i = inf.queryById(userID);
			tbft.setAge(Integer.parseInt(i.getAge()));
			tbft.setHeight(Double.parseDouble(i.getHeight()) * 100);
			tbft.setWeight(Double.parseDouble(i.getWeight()));
		}else{
			InfoDAO inf = new InfoDAOImpl();
			Info i = inf.queryById(userID);
			tbft.setAge(Integer.parseInt(i.getAge()));
			tbft.setHeight(Double.parseDouble(i.getHeight()) * 100);
			tbft.setWeight(Double.parseDouble(i.getWeight()));
		}
		int sex = 0;
		if(user.getStu_Sex().equals("M")){
			sex = 1;
		}
		tbft.setSex(sex);
		tbft.setName(user.getName());
		int flag = ClientCodoonSystem.Client(login_id, password);

		if (flag == 1) {
			System.out.println("登录成功");
			//初始化
			GetTodayData.todayCodoonData.setAvg_speed(0.0);
			GetTodayData.todayCodoonData.setDistance(0.0);
			GetTodayData.todayCodoonData.setDuration(0);
			GetTodayData.todayCodoonData.setUsePower(0.0);
			GetTodayData.getdata(ClientCodoonSystem.my_routes_htmlStr);
			while(GetTodayData.flag_time[2]==1) {
				boolean resultGetMoreBoolean = 
						GetMoreData.isGetMoreDataSuccess(GetTodayData.thisauto_id);
				if (resultGetMoreBoolean == true) {
					//获取成功
					System.out.println("MoreData:" + GetMoreData.More_DataStr);
					GetTodayData.getdata(GetMoreData.More_DataStr);
				}else {
				}
			}
			System.out.println("今天的运动情况：\n" + GetTodayData.todayCodoonData.toString());
			tbft.setDistance(Double.toString(GetTodayData.todayCodoonData.getDistance()));
			tbft.setSpeed(Double.toString(GetTodayData.todayCodoonData.getAvg_speed()));
			tbft.setPower(Double.toString(GetTodayData.todayCodoonData.getUsePower()));
			tbft.setTime(GetTodayData.todayCodoonData.getDuration().toString());
		} else {
			System.out.println("登录失败");
		}
//		ClientCodoonSystem.httpClient.getConnectionManager().shutdown();
		return tbft;
	}

}
