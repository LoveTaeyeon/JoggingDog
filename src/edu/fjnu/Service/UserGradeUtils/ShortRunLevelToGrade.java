package edu.fjnu.Service.UserGradeUtils;

import java.sql.SQLException;

import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.Entity.Infos.Info;

public class ShortRunLevelToGrade {

	public static int getGrade(String ID){
		InfoDAO inf = new InfoDAOImpl();
		Info i = new Info();
		try {
			i = inf.queryById(ID);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		double finalGrade = Double.parseDouble(i.getShortRun());	//得到数据库中该学生1000m时间，并转化为double型
//		System.out.println(finalGrade);
		if(finalGrade <= 6.7){
			return 100;		//成绩为6.7秒时 为100分						//满分
		}else if(finalGrade > 6.7 && finalGrade <= 6.8){
			return 95;		//成绩为6.7~6.8秒时 为95~100分
		}else if(finalGrade > 6.8 && finalGrade <= 6.9){
			return 90;		//成绩为6.8~6.9秒时 为90~95分				 //优秀
		}else if(finalGrade > 6.9 && finalGrade <= 7.0){
			return 85;		//成绩为6.9~7.0秒时 为85~90分
		}else if(finalGrade > 7.0 && finalGrade <= 7.1){
			return 80;		//成绩为7.0~7.1秒时 为80~85分				//良好
		}else if(finalGrade > 7.1 && finalGrade <= 7.3){
			return 78;		//成绩为7.1~7.3秒时 为78~80分
		}else if(finalGrade > 7.3 && finalGrade <= 7.5){
			return 76;		//成绩为7.3~7.5秒时 为76~78分
		}else if(finalGrade > 7.5 && finalGrade <= 7.7){
			return 74;		//成绩为7.5~7.7秒时 为74~76分
		}else if(finalGrade > 7.7 && finalGrade <= 7.9){
			return 72;		//成绩为7.7~7.9秒时 为72~74分
		}else if(finalGrade > 7.9 && finalGrade <= 8.1){
			return 70;		//成绩为7.9~8.1秒时 为70~72分
		}else if(finalGrade > 8.1 && finalGrade <= 8.3){
			return 68;		//成绩为8.1~8.3秒时 为68~70分
		}else if(finalGrade > 8.3 && finalGrade <= 8.5){
			return 66;		//成绩为8.3~8.5秒时 为66~68分
		}else if(finalGrade > 8.5 && finalGrade <= 8.7){
			return 64;		//成绩为8.5~8.7秒时 为64~66分
		}else if(finalGrade > 8.7 && finalGrade <= 8.9){
			return 62;		//成绩为8.7~8.9秒时 为62~64分
		}else if(finalGrade > 8.9 && finalGrade <= 9.1){
			return 60;		//成绩为8.9~9.1秒时 为60~62分				//及格
		}else if(finalGrade > 9.1 && finalGrade <= 9.3){
			return 50;		//成绩为9.1~9.3秒时 为50~60分
		}else if(finalGrade > 9.3 && finalGrade <= 9.5){
			return 40;		//成绩为9.3~9.5秒时 为40~50分
		}else if(finalGrade > 9.5 && finalGrade <= 9.7){
			return 30;		//成绩为9.5~9.7秒时 为30~40分
		}else if(finalGrade > 9.7 && finalGrade <= 9.9){
			return 20;		//成绩为9.7~9.9秒时 为20~30分
		}else if(finalGrade > 9.9 && finalGrade <= 10.1){
			return 10;		//成绩为9.9~10.1秒时 为10~20分
		}else{
			return 0;		//成绩比10.1秒还长,为0~10分					//不及格
		}
	}
	
}
