package edu.fjnu.Service.UserGradeUtils;

import java.sql.SQLException;

import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.Entity.Infos.Info;

public class LongRunLevelToGrade {

	public static int getGrade(String ID){				//男女都一样，因为男1000女800
		InfoDAO inf = new InfoDAOImpl();
		Info i = new Info();
		try {
			i = inf.queryById(ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		double temp = Double.parseDouble(i.getLongRun());		//得到数据库中该学生1000m时间，并转化为double型
//		BigDecimal b = new BigDecimal(temp);  
//		double lastTwo = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue() - (int)temp;  //获得小数点后两位的值
		double finalGrade = temp;			//转化后得到的最终时间
//		System.out.println(finalGrade);
		if(finalGrade <= 3.17){
			return 100;					//3.17时间以内 100分			//满分
		}else if(finalGrade > 3.17 && finalGrade <= 3.22){
			return 95;					//3.17~3.22内是95~100分
		}else if(finalGrade > 3.22 && finalGrade <= 3.27){
			return 90;					//3.22~3.27是90~95分			//优秀
		}else if(finalGrade > 3.27 && finalGrade <= 3.34){
			return 85;					//3.27~3.34是85~90分			
		}else if(finalGrade > 3.34 && finalGrade <= 3.42){
			return 80;					//3.34~3.42是80~85分			//良好			
		}else if(finalGrade > 3.42 && finalGrade <= 3.47){
			return 78;					//3.42~3.47是78~80分
		}else if(finalGrade > 3.47 && finalGrade <= 3.52){
			return 76;					//3.47~3.52是76~78分
		}else if(finalGrade > 3.52 && finalGrade <= 3.57){
			return 74;					//3.52~3.57是74~76分
		}else if(finalGrade > 3.57 && finalGrade <= 4.02){
			return 72;					//3.57~4.02是72~74分
		}else if(finalGrade > 4.02 && finalGrade <= 4.07){
			return 70;					//4.02~4.07是70~72分
		}else if(finalGrade > 4.07 && finalGrade <= 4.12){
			return 68;					//4.07~4.12是68~70分
		}else if(finalGrade > 4.12 && finalGrade <= 4.17){
			return 66;					//4.12~4.17是66~68分
		}else if(finalGrade > 4.17 && finalGrade <= 4.22){
			return 64;					//4.17~4.22是64~66分
		}else if(finalGrade > 4.22 && finalGrade <= 4.27){
			return 62;					//4.22~4.27是62~64分
		}else if(finalGrade > 4.27 && finalGrade <= 4.32){
			return 60;					//4.27~4.32是60~62分			//及格
		}else if(finalGrade > 4.32 && finalGrade <= 4.52){
			return 50;					//4.32~4.52是50~60分
		}else if(finalGrade > 4.52 && finalGrade <= 5.12){
			return 40;					//4.52~5.12是40~50分
		}else if(finalGrade > 5.12 && finalGrade <= 5.32){
			return 30;					//5.12~5.32是30~40分
		}else if(finalGrade > 5.32 && finalGrade <= 5.52){
			return 20;					//4.52~5.12是20~30分
		}else if(finalGrade > 5.52 && finalGrade <= 6.12){
			return 10;					//4.52~5.12是10~20分
		}else{
			return 0;					//0~10分						//不及格
		}
	}
	
}
