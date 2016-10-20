package edu.fjnu.Service.UserGradeUtils;

import java.sql.SQLException;

import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.Entity.Infos.Info;

public class BMILevelToGrade {

	public static int getGrade(String ID){
		InfoDAO inf = new InfoDAOImpl();
		Info student = new Info();
		try {
			student = inf.queryById(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double BMI = Double.parseDouble(student.getBmi());	//得到数据库中的BMI指数，并把它转化为double类型
		if(BMI >= 17.9 && BMI <= 23.9){
			return 90;			//属于正常状态
		}else if(BMI < 17.9){
			return 70;			//体重指数偏低，偏瘦状态
		}else if(BMI >23.9 && BMI <= 27.9){
			return 70;			//体重指数偏高，超重状态
		}else{
			return 50;			//体重指数过高，肥胖状态
		}
	}
	
}
