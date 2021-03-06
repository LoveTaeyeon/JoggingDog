package edu.fjnu.Service.UserGradeUtils;

import java.sql.SQLException;

import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.Entity.Infos.Info;

public class GetPullUpGrade {

	public static int getLevel(String ID){				
		//男生引体向上和女生仰卧起坐等级评定
		//下次使用时也要分清男女！！！否则无法准确表达信息！！
		InfoDAO ff = new InfoDAOImpl();
		Info f = new Info();
		try {
			f = ff.queryById(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int number = Integer.parseInt(f.getPullUp());
		if(f.getInfo_Sex().equals("M")){
			//男生的测试项目为引体向上
			if(number >= 19){
				return 1;			//100分
			}else if(number == 18){
				return 2;			//95分
			}else if(number == 17){
				return 3;			//90分
			}else if(number == 16){
				return 4;			//85分
			}else if(number == 15){
				return 5;			//80分
			}else if(number == 14){
				return 6;			//76分
			}else if(number == 13){
				return 7;			//72分
			}else if(number == 12){
				return 8;			//68分
			}else if(number == 11){
				return 9;			//64分
			}else if(number == 10){
				return 10;			//60分
			}else if(number == 9){
				return 11;			//50分
			}else if(number == 8){
				return 12;			//40分
			}else if(number == 7){
				return 13;			//30分
			}else if(number == 6){
				return 14;			//20分
			}else if(number == 5){
				return 15;			//10分
			}else{
				return 16;			//不得分
			}
		}else{
			//女生的测试项目时仰卧起坐
			if(number >= 56){
				return 1;			//100分
			}else if(number < 56 && number >= 54){
				return 2;			//95分到100分
			}else if(number < 54 && number >= 52){
				return 3;			//90分到95分
			}else if(number < 52 && number >= 49){
				return 4;			//85分到90分
			}else if(number < 49 && number >= 46){
				return 5;			//80分到85分
			}else if(number < 46 && number >= 44){
				return 6;			//78分到80分
			}else if(number < 44 && number >= 42){
				return 7;			//76分到78分
			}else if(number < 42 && number >= 40){
				return 8;			//74分到76分
			}else if(number < 40 && number >= 38){
				return 9;			//72分到74分
			}else if(number < 38 && number >= 36){
				return 10;			//70分到72分
			}else if(number < 36 && number >= 34){
				return 11;			//68分到70分
			}else if(number < 34 && number >= 32){
				return 12;			//66分到68分
			}else if(number < 32 && number >= 30){
				return 13;			//64分到66分
			}else if(number < 30 && number >= 28){
				return 14;			//62分到64分
			}else if(number < 28 && number >= 26){
				return 15;			//60分到62分
			}else if(number < 26 && number >= 24){
				return 16;			//50分到60分
			}else if(number < 24 && number >= 22){
				return 17;			//40分到50分
			}else if(number < 22 && number >= 20){
				return 18;			//30分到40分
			}else if(number < 20 && number >= 18){
				return 19;			//20分到30分
			}else if(number < 18 && number >= 16){
				return 20;			//10分到20分
			}else{
				return 21;			//0分到10分
			}
		}
	}
	
	public static void main(String[] args) {
//		
//		GetPullUpGrade g = new GetPullUpGrade();
//		System.out.println(g.getLevel("267"));
		
	}
	
}
