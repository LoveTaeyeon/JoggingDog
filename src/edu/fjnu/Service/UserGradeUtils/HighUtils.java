package edu.fjnu.Service.UserGradeUtils;

import java.sql.SQLException;

import edu.fjnu.DAO.HighInfoDAO;
import edu.fjnu.DAOImpl.HighInfoDAOImpl;
import edu.fjnu.Entity.Infos.Highinfo;

public class HighUtils {
	
	public static int getBMILevel(String userID) {

		HighInfoDAO user = new HighInfoDAOImpl();
		Highinfo info = new Highinfo();
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double BMI = Double.parseDouble(info.getBMI());
		if (BMI >= 17.9 && BMI <= 23.9) {
			return 100; // 属于正常状态
		} else if (BMI < 17.9) {
			return 80; // 体重指数偏低，偏瘦状态
		} else if (BMI > 23.9 && BMI <= 27.9) {
			return 70; // 体重指数偏高，超重状态
		} else {
			return 50; // 体重指数过高，肥胖状态
		}
	}
	
	
	public static int getBenchTestLevel(String userID){
		
		int grade = HighUtils.getBenchTestGrade(userID);
		if(grade >= 90){
			//大于90分，属于优秀
			return 1;
		}else if(grade < 90 && grade >= 75){
			//80-90良好
			return 2;
		}else if(grade < 80 && grade >= 60){
			//60-80及格
			return 3;
		}else{
			//不及格
			return 4;
		}
		
	}
	
	public static int getBenchTestGrade(String userID){
		
		HighInfoDAO user = new HighInfoDAOImpl();
		Highinfo info = new Highinfo();
		
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sex = info.getINFO_SEX();
		double age = Double.parseDouble(info.getAge());
		double number = Double.parseDouble(info.getBenchTest());
		
		if(sex.equals("M")){
			//男生
			if(age <= 12){
				//高中一年级男生
				if(number >= 67){
					return 100;
				}else if(number == 66){
					return 98;
				}else if(number == 65){
					return 96;
				}else if(number == 64){
					return 94;
				}else if(number == 63){
					return 92;
				}else if(number == 62){
					return 90;
				}else if(number == 61){
					return 87;
				}else if(number < 61 && number >= 59){
					return 84;
				}else if(number == 58){
					return 81;
				}else if(number < 58 && number >= 55){
					return 78;
				}else if(number < 55 && number >= 53){
					return 75;
				}else if(number == 52){
					return 72;
				}else if(number == 51){
					return 69;
				}else if(number == 50){
					return 66;
				}else if(number < 50 && number >= 48){
					return 63;
				}else if(number < 48 && number >= 46){
					return 60;
				}else if(number == 45){
					return 50;
				}else if(number == 44){
					return 40;
				}else if(number == 43){
					return 30;
				}else if(number == 42){
					return 20;
				}else if(number < 42 && number >= 40){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 12 && age <=13){
				//高二男生
				if(number >= 68){
					return 100;
				}else if(number == 67){
					return 98;
				}else if(number == 66){
					return 96;
				}else if(number == 65){
					return 94;
				}else if(number == 64){
					return 92;
				}else if(number < 64 && number >= 62){
					return 90;
				}else if(number == 61){
					return 87;
				}else if(number < 61 && number >= 59){
					return 84;
				}else if(number < 59 && number >= 57){
					return 81;
				}else if(number < 57 && number >= 54){
					return 78;
				}else if(number < 54 && number >= 52){
					return 75;
				}else if(number == 51){
					return 72;
				}else if(number == 50){
					return 69;
				}else if(number == 49){
					return 66;
				}else if(number < 49 && number >= 47){
					return 63;
				}else if(number == 46){
					return 60;
				}else if(number == 45){
					return 50;
				}else if(number == 44){
					return 40;
				}else if(number == 43){
					return 30;
				}else if(number == 42){
					return 20;
				}else if(number < 42 && number >= 40){
					return 10;
				}else{
					return 0;
				}
			}else{
				//高三男生
				if(number >= 68){
					return 100;
				}else if(number == 67){
					return 98;
				}else if(number == 66){
					return 96;
				}else if(number == 65){
					return 94;
				}else if(number == 64){
					return 92;
				}else if(number < 64 && number >= 62){
					return 90;
				}else if(number == 61){
					return 87;
				}else if(number < 61 && number >= 59){
					return 84;
				}else if(number == 58){
					return 81;
				}else if(number < 58 && number >= 55){
					return 78;
				}else if(number < 55 && number >= 53){
					return 75;
				}else if(number == 52){
					return 72;
				}else if(number == 51){
					return 69;
				}else if(number == 50){
					return 66;
				}else if(number < 50 && number >= 48){
					return 63;
				}else if(number < 48 && number >= 46){
					return 60;
				}else if(number == 45){
					return 50;
				}else if(number == 44){
					return 40;
				}else if(number == 43){
					return 30;
				}else if(number == 42){
					return 20;
				}else if(number < 42 && number >= 40){
					return 10;
				}else{
					return 0;
				}
			}
		}else{
			//女生
			if(age <= 12){
				//高中一年级女生
				if(number >= 66){
					return 100;
				}else if(number == 65){
					return 98;
				}else if(number == 64){
					return 96;
				}else if(number == 63){
					return 94;
				}else if(number == 62){
					return 92;
				}else if(number < 62 && number >= 60){
					return 90;
				}else if(number == 59){
					return 87;
				}else if(number < 59 && number >= 57){
					return 84;
				}else if(number < 57 && number >= 55){
					return 81;
				}else if(number < 55 && number >= 52){
					return 78;
				}else if(number < 52 && number >= 49){
					return 75;
				}else if(number == 48){
					return 72;
				}else if(number == 47){
					return 69;
				}else if(number == 46){
					return 66;
				}else if(number < 46 && number >= 44){
					return 63;
				}else if(number < 44 && number >= 42){
					return 60;
				}else if(number == 41){
					return 50;
				}else if(number == 40){
					return 40;
				}else if(number < 40 && number >= 38){
					return 30;
				}else if(number == 37){
					return 20;
				}else if(number < 37 && number >= 35){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 12 && age <=13){
				//高二女生
				if(number >= 66){
					return 100;
				}else if(number == 65){
					return 98;
				}else if(number == 64){
					return 96;
				}else if(number == 63){
					return 94;
				}else if(number == 62){
					return 92;
				}else if(number < 62 && number >= 60){
					return 90;
				}else if(number == 59){
					return 87;
				}else if(number < 59 && number >= 57){
					return 84;
				}else if(number < 57 && number >= 54){
					return 81;
				}else if(number < 54 && number >= 52){
					return 78;
				}else if(number < 52 && number >= 49){
					return 75;
				}else if(number == 48){
					return 72;
				}else if(number == 47){
					return 69;
				}else if(number < 47 && number >= 45){
					return 66;
				}else if(number == 44){
					return 63;
				}else if(number < 44 && number >= 42){
					return 60;
				}else if(number == 41){
					return 50;
				}else if(number == 40){
					return 40;
				}else if(number == 39){
					return 30;
				}else if(number < 39 && number >= 37){
					return 20;
				}else if(number == 36){
					return 10;
				}else{
					return 0;
				}
			}else{
				//高三女生
				if(number >= 66){
					return 100;
				}else if(number == 65){
					return 98;
				}else if(number == 64){
					return 96;
				}else if(number == 63){
					return 94;
				}else if(number == 62){
					return 92;
				}else if(number < 62 && number >= 60){
					return 90;
				}else if(number == 59){
					return 87;
				}else if(number < 59 && number >= 57){
					return 84;
				}else if(number < 57 && number >= 54){
					return 81;
				}else if(number < 54 && number >= 52){
					return 78;
				}else if(number < 52 && number >= 49){
					return 75;
				}else if(number == 48){
					return 72;
				}else if(number == 47){
					return 69;
				}else if(number < 47 && number >= 45){
					return 66;
				}else if(number == 44){
					return 63;
				}else if(number < 44 && number >= 42){
					return 60;
				}else if(number == 41){
					return 50;
				}else if(number == 40){
					return 40;
				}else if(number == 39){
					return 30;
				}else if(number == 38){
					return 20;
				}else if(number == 37){
					return 10;
				}else{
					return 0;
				}
			}
		}
	}
	
	public static int getLongRunLevel(String userID){
		
		int grade = HighUtils.getLongRunGrade(userID);
		if(grade >= 90){
			//大于90分，属于优秀
			return 1;
		}else if(grade < 90 && grade >= 75){
			//80-90良好
			return 2;
		}else if(grade < 80 && grade >= 60){
			//60-80及格
			return 3;
		}else{
			//不及格
			return 4;
		}
	}
	
	public static int getLongRunGrade(String userID){
		
		HighInfoDAO user = new HighInfoDAOImpl();
		Highinfo info = new Highinfo();
		
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sex = info.getINFO_SEX();
		double age = Double.parseDouble(info.getAge());
		double number = Double.parseDouble(info.getLongRun());
		
		if(sex.equals("M")){
			//男生	
			if(age <= 15){
				//高一男生
				if(number <= 3.28){
					return 100;
				}else if(number > 3.28 && number <= 3.31){
					return 98;
				}else if(number > 3.31 && number <= 3.34){
					return 96;
				}else if(number > 3.34 && number <= 3.37){
					return 94;
				}else if(number > 3.37 && number <= 3.40){
					return 92;
				}else if(number > 3.40 && number <= 3.43){
					return 90;
				}else if(number > 3.43 && number <= 3.47){
					return 87;
				}else if(number > 3.47 && number <= 3.51){
					return 84;
				}else if(number > 3.51 && number <= 3.56){
					return 81;
				}else if(number > 3.56 && number <= 4.01){
					return 78;
				}else if(number > 4.01 && number <= 4.06){
					return 75;
				}else if(number > 4.06 && number <= 4.11){
					return 72;
				}else if(number > 4.11 && number <= 4.16){
					return 69;
				}else if(number > 4.16 && number <= 4.21){
					return 66;
				}else if(number > 4.21 && number <= 4.26){
					return 63;
				}else if(number > 4.26 && number <= 4.31){
					return 60;
				}else if(number > 4.31 && number <= 4.40){
					return 50;
				}else if(number > 4.40 && number <= 4.50){
					return 40;
				}else if(number > 4.50 && number <= 5){
					return 30;
				}else if(number > 5 && number <= 5.10){
					return 20;
				}else if(number > 5.10 && number <= 5.20){
					return 10;
				}else{
					return 0;
				}
				
			}else if(age > 15 && age <=16 ){
				//高二男生
				if(number <= 3.28){
					return 100;
				}else if(number > 3.28 && number <= 3.31){
					return 98;
				}else if(number > 3.31 && number <= 3.33){
					return 96;
				}else if(number > 3.33 && number <= 3.35){
					return 94;
				}else if(number > 3.35 && number <= 3.38){
					return 92;
				}else if(number > 3.38 && number <= 3.41){
					return 90;
				}else if(number > 3.41 && number <= 3.45){
					return 87;
				}else if(number > 3.45 && number <= 3.49){
					return 84;
				}else if(number > 3.49 && number <= 4.03){
					return 81;
				}else if(number > 4.03 && number <= 4.08){
					return 78;
				}else if(number > 4.08 && number <= 4.13){
					return 75;
				}else if(number > 4.13 && number <= 4.18){
					return 72;
				}else if(number > 4.18 && number <= 4.23){
					return 69;
				}else if(number > 4.23 && number <= 4.28){
					return 66;
				}else if(number > 4.28 && number <= 4.33){
					return 63;
				}else if(number > 4.33 && number <= 4.38){
					return 60;
				}else if(number > 4.38 && number <= 4.45){
					return 50;
				}else if(number > 4.45 && number <= 4.51){
					return 40;
				}else if(number > 4.51 && number <= 4.58){
					return 30;
				}else if(number > 4.58 && number <= 5.05){
					return 20;
				}else if(number > 5.05 && number <= 5.12){
					return 10;
				}else{
					return 0;
				}
			}else{
				//高三男生
				if(number <= 3.27){
					return 100;
				}else if(number > 3.27 && number <= 3.28){
					return 98;
				}else if(number > 3.28 && number <= 3.31){
					return 96;
				}else if(number > 3.31 && number <= 3.33){
					return 94;
				}else if(number > 3.33 && number <= 3.35){
					return 92;
				}else if(number > 3.35 && number <= 3.39){
					return 90;
				}else if(number > 3.39 && number <= 3.42){
					return 87;
				}else if(number > 3.42 && number <= 3.45){
					return 84;
				}else if(number > 3.45 && number <= 3.49){
					return 81;
				}else if(number > 3.49 && number <= 3.53){
					return 78;
				}else if(number > 3.53 && number <= 3.58){
					return 75;
				}else if(number > 3.58 && number <= 4.05){
					return 72;
				}else if(number > 4.05 && number <= 4.12){
					return 69;
				}else if(number > 4.12 && number <= 4.19){
					return 66;
				}else if(number > 4.19 && number <= 4.26){
					return 63;
				}else if(number > 4.26 && number <= 4.33){
					return 60;
				}else if(number > 4.33 && number <= 4.40){
					return 50;
				}else if(number > 4.40 && number <= 4.47){
					return 40;
				}else if(number > 4.47 && number <= 4.54){
					return 30;
				}else if(number > 4.54 && number <= 5.01){
					return 20;
				}else if(number > 5.01 && number <= 5.08){
					return 10;
				}else{
					return 0;
				}
			}
			
		}else{
			//女生
			if(age <= 15){
				//高一女生
				//800m
				if(number <= 3.24){
					return 100;
				}else if(number > 3.24 && number <= 3.27){
					return 98;
				}else if(number > 3.27 && number <= 3.29){
					return 96;
				}else if(number > 3.29 && number <= 3.32){
					return 94;
				}else if(number > 3.32 && number <= 3.35){
					return 92;
				}else if(number > 3.35 && number <= 3.38){
					return 90;
				}else if(number > 3.38 && number <= 3.42){
					return 87;
				}else if(number > 3.42 && number <= 3.46){
					return 84;
				}else if(number > 3.46 && number <= 3.50){
					return 81;
				}else if(number > 3.50 && number <= 3.54){
					return 78;
				}else if(number > 3.54 && number <= 3.58){
					return 75;
				}else if(number > 3.58 && number <= 4.03){
					return 72;
				}else if(number > 4.03 && number <= 4.08){
					return 69;
				}else if(number > 4.08 && number <= 4.13){
					return 66;
				}else if(number > 4.13 && number <= 4.18){
					return 63;
				}else if(number > 4.18 && number <= 4.23){
					return 60;
				}else if(number > 4.23 && number <= 4.30){
					return 50;
				}else if(number > 4.30 && number <= 4.37){
					return 40;
				}else if(number > 4.37 && number <= 4.44){
					return 30;
				}else if(number > 4.44 && number <= 4.51){
					return 20;
				}else if(number > 4.51 && number <= 5){
					return 10;
				}else{
					return 0;
				}
				
			}else if(age > 15 && age <=16 ){
				//高二女生
				if(number <= 3.24){
					return 100;
				}else if(number > 3.24 && number <= 3.27){
					return 98;
				}else if(number > 3.27 && number <= 3.29){
					return 96;
				}else if(number > 3.29 && number <= 3.32){
					return 94;
				}else if(number > 3.32 && number <= 3.35){
					return 92;
				}else if(number > 3.35 && number <= 3.38){
					return 90;
				}else if(number > 3.38 && number <= 3.42){
					return 87;
				}else if(number > 3.42 && number <= 3.46){
					return 84;
				}else if(number > 3.46 && number <= 3.50){
					return 81;
				}else if(number > 3.50 && number <= 3.54){
					return 78;
				}else if(number > 3.54 && number <= 3.58){
					return 75;
				}else if(number > 3.58 && number <= 4.03){
					return 72;
				}else if(number > 4.03 && number <= 4.08){
					return 69;
				}else if(number > 4.08 && number <= 4.13){
					return 66;
				}else if(number > 4.13 && number <= 4.18){
					return 63;
				}else if(number > 4.18 && number <= 4.23){
					return 60;
				}else if(number > 4.23 && number <= 4.30){
					return 50;
				}else if(number > 4.30 && number <= 4.37){
					return 40;
				}else if(number > 4.37 && number <= 4.44){
					return 30;
				}else if(number > 4.44 && number <= 4.51){
					return 20;
				}else if(number > 4.51 && number <= 5){
					return 10;
				}else{
					return 0;
				}
			}else{
				//高三女生
				if(number <= 3.24){
					return 100;
				}else if(number > 3.24 && number <= 3.27){
					return 98;
				}else if(number > 3.27 && number <= 3.29){
					return 96;
				}else if(number > 3.29 && number <= 3.32){
					return 94;
				}else if(number > 3.32 && number <= 3.35){
					return 92;
				}else if(number > 3.35 && number <= 3.38){
					return 90;
				}else if(number > 3.38 && number <= 3.42){
					return 87;
				}else if(number > 3.42 && number <= 3.46){
					return 84;
				}else if(number > 3.46 && number <= 3.50){
					return 81;
				}else if(number > 3.50 && number <= 3.54){
					return 78;
				}else if(number > 3.54 && number <= 3.58){
					return 75;
				}else if(number > 3.58 && number <= 4.03){
					return 72;
				}else if(number > 4.03 && number <= 4.08){
					return 69;
				}else if(number > 4.08 && number <= 4.13){
					return 66;
				}else if(number > 4.13 && number <= 4.18){
					return 63;
				}else if(number > 4.18 && number <= 4.23){
					return 60;
				}else if(number > 4.23 && number <= 4.30){
					return 50;
				}else if(number > 4.30 && number <= 4.37){
					return 40;
				}else if(number > 4.37 && number <= 4.44){
					return 30;
				}else if(number > 4.44 && number <= 4.51){
					return 20;
				}else if(number > 4.51 && number <= 5){
					return 10;
				}else{
					return 0;
				}
			}
		}	
	}
	
	public static int getThrowBallLevel(String userID){
		int grade = HighUtils.getThrowBallGrade(userID);
		if(grade >= 90){
			//大于90分，属于优秀
			return 1;
		}else if(grade < 90 && grade >= 75){
			//80-90良好
			return 2;
		}else if(grade < 80 && grade >= 60){
			//60-80及格
			return 3;
		}else{
			//不及格
			return 4;
		}
	}
	
	public static int getThrowBallGrade(String userID){
		
		HighInfoDAO user = new HighInfoDAOImpl();
		Highinfo info = new Highinfo();
		
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sex = info.getINFO_SEX();
		double age = Double.parseDouble(info.getAge());
		double number = Double.parseDouble(info.getThrowBall());
		
		if(sex.equals("M")){
			//男生
			if(age <= 15){
				//高一男生
				if(number >= 13.6){
					return 100;
				}else if(number < 13.6 && number >= 13.2){
					return 98;
				}else if(number < 13.2 && number >= 12.6){
					return 96;
				}else if(number < 12.6 && number >= 12){
					return 94;
				}else if(number < 12 && number >= 11.2){
					return 92;
				}else if(number < 11.2 && number >= 10.4){
					return 90;
				}else if(number < 10.4 && number >= 10.2){
					return 87;
				}else if(number < 10.2 && number >= 9.8){
					return 84;
				}else if(number < 9.8 && number >= 9.4){
					return 84;
				}else if(number < 9.4 && number >= 8.9){
					return 78;
				}else if(number < 8.9 && number >= 8.5){
					return 75;
				}else if(number < 8.5 && number >= 8.2){
					return 72;
				}else if(number < 8.2 && number >= 7.7){
					return 69;
				}else if(number < 7.7 && number >= 7.2){
					return 66;
				}else if(number < 7.2 && number >= 6.6){
					return 63;
				}else if(number < 6.6 && number >= 6){
					return 60;
				}else if(number < 6 && number >= 5.8){
					return 50;
				}else if(number < 5.8 && number >= 5.5){
					return 40;
				}else if(number < 5.5 && number >= 5.2){
					return 30;
				}else if(number < 5.2 && number >= 4.8){
					return 20;
				}else if(number < 4.8 && number >= 4.4){
					return 10;
				}else{
					return 0;
				}	
			}else if(age > 15 && age <= 16){
				//高二男生
				if(number >= 13.8){
					return 100;
				}else if(number < 13.8 && number >= 13.4){
					return 98;
				}else if(number < 13.4 && number >= 12.8){
					return 96;
				}else if(number < 12.8 && number >= 12.2){
					return 94;
				}else if(number < 12.2 && number >= 11.4){
					return 92;
				}else if(number < 11.4 && number >= 10.6){
					return 90;
				}else if(number < 10.6 && number >= 10.4){
					return 87;
				}else if(number < 10.4 && number >= 10){
					return 84;
				}else if(number < 10 && number >= 9.7){
					return 84;
				}else if(number < 9.7 && number >= 9.2){
					return 78;
				}else if(number < 9.2 && number >= 8.7){
					return 75;
				}else if(number < 8.7 && number >= 8.5){
					return 72;
				}else if(number < 8.5 && number >= 8.1){
					return 69;
				}else if(number < 8.1 && number >= 7.7){
					return 66;
				}else if(number < 7.7 && number >= 7.2){
					return 63;
				}else if(number < 7.2 && number >= 6.8){
					return 60;
				}else if(number < 6.8 && number >= 6.6){
					return 50;
				}else if(number < 6.6 && number >= 6.3){
					return 40;
				}else if(number < 6.3 && number >= 6.1){
					return 30;
				}else if(number < 6.1 && number >= 5.7){
					return 20;
				}else if(number < 5.7 && number >= 5.4){
					return 10;
				}else{
					return 0;
				}
			}else{
				//高三男生
				if(number >= 14.2){
					return 100;
				}else if(number < 14.2 && number >= 13.8){
					return 98;
				}else if(number < 13.8 && number >= 13.2){
					return 96;
				}else if(number < 13.2 && number >= 12.6){
					return 94;
				}else if(number < 12.6 && number >= 11.8){
					return 92;
				}else if(number < 11.8 && number >= 11){
					return 90;
				}else if(number < 11 && number >= 10.8){
					return 87;
				}else if(number < 10.8 && number >= 10.4){
					return 84;
				}else if(number < 10.4 && number >= 10.1){
					return 84;
				}else if(number < 10.1 && number >= 9.6){
					return 78;
				}else if(number < 9.6 && number >= 9.1){
					return 75;
				}else if(number < 9.1 && number >= 8.9){
					return 72;
				}else if(number < 8.9 && number >= 8.4){
					return 69;
				}else if(number < 8.4 && number >= 8){
					return 66;
				}else if(number < 8 && number >= 7.5){
					return 63;
				}else if(number < 7.5 && number >= 6.9){
					return 60;
				}else if(number < 6.9 && number >= 6.7){
					return 50;
				}else if(number < 6.7 && number >= 6.4){
					return 40;
				}else if(number < 6.4 && number >= 6.1){
					return 30;
				}else if(number < 6.1 && number >= 5.7){
					return 20;
				}else if(number < 5.7 && number >= 5.4){
					return 10;
				}else{
					return 0;
				}
			}	
		}else{
			//女生
			if(age <= 15){
				//高一女生
				if(number >= 8){
					return 100;
				}else if(number < 8 && number >= 7.9){
					return 98;
				}else if(number < 7.9 && number >= 7.8){
					return 96;
				}else if(number < 7.8 && number >= 7.7){
					return 94;
				}else if(number < 7.7 && number >= 7.6){
					return 92;
				}else if(number < 7.6 && number >= 7.4){
					return 90;
				}else if(number < 7.4 && number >= 7.3){
					return 87;
				}else if(number < 7.3 && number >= 7.2){
					return 84;
				}else if(number < 7.2 && number >= 7.1){
					return 84;
				}else if(number < 7.1 && number >= 7){
					return 78;
				}else if(number < 7 && number >= 6.8){
					return 75;
				}else if(number < 6.8 && number >= 6.7){
					return 72;
				}else if(number < 6.7 && number >= 6.6){
					return 69;
				}else if(number < 6.6 && number >= 6.4){
					return 66;
				}else if(number < 6.4 && number >= 6.2){
					return 63;
				}else if(number < 6.2 && number >= 6){
					return 60;
				}else if(number < 6 && number >= 5.8){
					return 50;
				}else if(number < 5.8 && number >= 5.4){
					return 40;
				}else if(number < 5.4 && number >= 5){
					return 30;
				}else if(number < 5 && number >= 4.5){
					return 20;
				}else if(number < 4.5 && number >= 4){
					return 10;
				}else{
					return 0;
				}	
			}else if(age > 15 && age <= 16){
				//高二女生
				if(number >= 8.1){
					return 100;
				}else if(number < 8.1 && number >= 8){
					return 98;
				}else if(number < 8 && number >= 7.9){
					return 96;
				}else if(number < 7.9 && number >= 7.8){
					return 94;
				}else if(number < 7.8 && number >= 7.7){
					return 92;
				}else if(number < 7.7 && number >= 7.5){
					return 90;
				}else if(number < 7.5 && number >= 7.4){
					return 87;
				}else if(number < 7.4 && number >= 7.3){
					return 84;
				}else if(number < 7.3 && number >= 7.2){
					return 84;
				}else if(number < 7.2 && number >= 7.1){
					return 78;
				}else if(number < 7.1 && number >= 6.9){
					return 75;
				}else if(number < 6.9 && number >= 6.8){
					return 72;
				}else if(number < 6.8 && number >= 6.7){
					return 69;
				}else if(number < 6.7 && number >= 6.5){
					return 66;
				}else if(number < 6.5 && number >= 6.3){
					return 63;
				}else if(number < 6.3 && number >= 6.1){
					return 60;
				}else if(number < 6.1 && number >= 5.9){
					return 50;
				}else if(number < 5.9 && number >= 5.6){
					return 40;
				}else if(number < 5.6 && number >= 5.4){
					return 30;
				}else if(number < 5.4 && number >= 5){
					return 20;
				}else if(number < 5 && number >= 4.6){
					return 10;
				}else{
					return 0;
				}
			}else{
				//高三女生
				if(number >= 8.2){
					return 100;
				}else if(number < 8.2 && number >= 8.1){
					return 98;
				}else if(number < 8.1 && number >= 8){
					return 96;
				}else if(number < 8 && number >= 7.9){
					return 94;
				}else if(number < 7.9 && number >= 7.8){
					return 92;
				}else if(number < 7.8 && number >= 7.6){
					return 90;
				}else if(number < 7.6 && number >= 7.5){
					return 87;
				}else if(number < 7.5 && number >= 7.4){
					return 84;
				}else if(number < 7.4 && number >= 7.3){
					return 84;
				}else if(number < 7.3 && number >= 7.2){
					return 78;
				}else if(number < 7.2 && number >= 7){
					return 75;
				}else if(number < 7 && number >= 6.9){
					return 72;
				}else if(number < 6.9 && number >= 6.8){
					return 69;
				}else if(number < 6.8 && number >= 6.6){
					return 66;
				}else if(number < 6.6 && number >= 6.4){
					return 63;
				}else if(number < 6.4 && number >= 6.2){
					return 60;
				}else if(number < 6.2 && number >= 6){
					return 50;
				}else if(number < 6 && number >= 5.7){
					return 40;
				}else if(number < 5.7 && number >= 5.5){
					return 30;
				}else if(number < 5.5 && number >= 5.1){
					return 20;
				}else if(number < 5.1 && number >= 4.7){
					return 10;
				}else{
					return 0;
				}
			}
		}
	}
	
	public static int getSitAndReachLevel(String userID){
		
		int grade = HighUtils.getSitAndReachGrade(userID);
		if(grade >= 90){
			//大于90分，属于优秀
			return 1;
		}else if(grade < 90 && grade >= 75){
			//80-90良好
			return 2;
		}else if(grade < 80 && grade >= 60){
			//60-80及格
			return 3;
		}else{
			//不及格
			return 4;
		}
		
	}
	
	public static int getSitAndReachGrade(String userID){
		
		HighInfoDAO user = new HighInfoDAOImpl();
		Highinfo info = new Highinfo();
		
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sex = info.getINFO_SEX();
		double age = Double.parseDouble(info.getAge());
		double number = Double.parseDouble(info.getSitAndReach());
		
		if(sex.equals("M")){
			//男生
			if(age <= 15){
				//高一男生
				if(number >= 20.8){
					return 100;
				}else if(number < 20.8 && number >= 20.4){
					return 98;
				}else if(number < 20.4 && number >= 19.9){
					return 96;
				}else if(number < 19.9 && number >= 19.4){
					return 94;
				}else if(number < 19.4 && number >= 18.7){
					return 92;
				}else if(number < 18.7 && number >= 18){
					return 90;
				}else if(number < 18 && number >= 17.1){
					return 87;
				}else if(number < 17.1 && number >= 15.8){
					return 84;
				}else if(number < 15.8 && number >= 14.4){
					return 81;
				}else if(number < 14.4 && number >= 12.6){
					return 78;
				}else if(number < 12.6 && number >= 10.8){
					return 75;
				}else if(number < 10.8 && number >= 9.7){
					return 72;
				}else if(number < 9.7 && number >= 8){
					return 69;
				}else if(number < 8 && number >= 6.3){
					return 66;
				}else if(number < 6.3 && number >= 4){
					return 63;
				}else if(number < 4 && number >= 1.7){
					return 60;
				}else if(number < 1.7 && number >= 1){
					return 50;
				}else if(number < 1 && number >= -0.1){
					return 40;
				}else if(number < -0.1 && number >= -1.1){
					return 30;
				}else if(number < -1.1 && number >= -2.5){
					return 20;
				}else if(number < -2.5 && number >= -3.8){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 15 && age <= 16){
				//高二男生
				if(number >= 21.5){
					return 100;
				}else if(number < 21.5 && number >= 21.1){
					return 98;
				}else if(number < 21.1 && number >= 20.6){
					return 96;
				}else if(number < 20.6 && number >= 20.1){
					return 94;
				}else if(number < 20.1 && number >= 19.5){
					return 92;
				}else if(number < 19.5 && number >= 18.8){
					return 90;
				}else if(number < 18.8 && number >= 17.9){
					return 87;
				}else if(number < 17.9 && number >= 16.6){
					return 84;
				}else if(number < 16.6 && number >= 15.3){
					return 81;
				}else if(number < 15.3 && number >= 13.5){
					return 78;
				}else if(number < 13.5 && number >= 11.8){
					return 75;
				}else if(number < 11.8 && number >= 10.6){
					return 72;
				}else if(number < 10.6 && number >= 8.8){
					return 69;
				}else if(number < 8.8 && number >= 7){
					return 66;
				}else if(number < 7 && number >= 4.6){
					return 63;
				}else if(number < 4.6 && number >= 2.2){
					return 60;
				}else if(number < 2.2 && number >= 1.5){
					return 50;
				}else if(number < 1.5 && number >= 0.4){
					return 40;
				}else if(number < 0.4 && number >= -0.7){
					return 30;
				}else if(number < -0.7 && number >= -2.1){
					return 20;
				}else if(number < -2.1 && number >= -3.5){
					return 10;
				}else{
					return 0;
				}
			}else{
				//高三男生
				if(number >= 22.5){
					return 100;
				}else if(number < 22.5 && number >= 20.4){
					return 98;
				}else if(number < 22.1 && number >= 19.9){
					return 96;
				}else if(number < 21.6 && number >= 19.4){
					return 94;
				}else if(number < 21 && number >= 18.7){
					return 92;
				}else if(number < 20.2 && number >= 18){
					return 90;
				}else if(number < 19.5 && number >= 17.1){
					return 87;
				}else if(number < 18.6 && number >= 15.8){
					return 84;
				}else if(number < 17.2 && number >= 14.4){
					return 81;
				}else if(number < 15.8 && number >= 12.6){
					return 78;
				}else if(number < 13.9 && number >= 10.8){
					return 75;
				}else if(number < 12.1 && number >= 9.7){
					return 72;
				}else if(number < 10.9 && number >= 8){
					return 69;
				}else if(number < 9.2 && number >= 6.3){
					return 66;
				}else if(number < 7.4 && number >= 4){
					return 63;
				}else if(number < 5 && number >= 1.7){
					return 60;
				}else if(number < 2.7 && number >= 1){
					return 50;
				}else if(number < 2.1 && number >= -0.1){
					return 40;
				}else if(number < 1.2 && number >= -1.1){
					return 30;
				}else if(number < 0.3 && number >= -2.5){
					return 20;
				}else if(number < -1 && number >= -2.2){
					return 10;
				}else{
					return 0;
				}
			}
			
		}else{
			//女生
			if(age <= 15){
				//高一女生
				if(number >= 20.3){
					return 100;
				}else if(number < 20.3 && number >= 20){
					return 98;
				}else if(number < 20 && number >= 19.5){
					return 96;
				}else if(number < 19.5 && number >= 19.1){
					return 94;
				}else if(number < 19.1 && number >= 18.4){
					return 92;
				}else if(number < 18.4 && number >= 17.8){
					return 90;
				}else if(number < 17.8 && number >= 17){
					return 87;
				}else if(number < 17 && number >= 15.7){
					return 84;
				}else if(number < 15.7 && number >= 14.4){
					return 81;
				}else if(number < 14.4 && number >= 12.7){
					return 78;
				}else if(number < 12.7 && number >= 11){
					return 75;
				}else if(number < 11 && number >= 10){
					return 72;
				}else if(number < 10 && number >= 8.3){
					return 69;
				}else if(number < 8.3 && number >= 6.7){
					return 66;
				}else if(number < 6.7 && number >= 4.5){
					return 63;
				}else if(number < 4.5 && number >= 2.3){
					return 60;
				}else if(number < 2.3 && number >= 1.9){
					return 50;
				}else if(number < 1.9 && number >= 1.2){
					return 40;
				}else if(number < 1.2 && number >= 0.5){
					return 30;
				}else if(number < 0.5 && number >= -0.4){
					return 20;
				}else if(number < -0.4 && number >= -1.4){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 15 && age <= 16){
				//高二女生
				if(number >= 20.7){
					return 100;
				}else if(number < 20.7 && number >= 20.4){
					return 98;
				}else if(number < 20.4 && number >= 19.9){
					return 96;
				}else if(number < 19.9 && number >= 19.4){
					return 94;
				}else if(number < 19.4 && number >= 18.7){
					return 92;
				}else if(number < 18.7 && number >= 18){
					return 90;
				}else if(number < 18 && number >= 17.2){
					return 87;
				}else if(number < 17.2 && number >= 16){
					return 84;
				}else if(number < 16 && number >= 14.8){
					return 81;
				}else if(number < 14.8 && number >= 13.2){
					return 78;
				}else if(number < 13.2 && number >= 11.6){
					return 75;
				}else if(number < 11.6 && number >= 10.5){
					return 72;
				}else if(number < 10.5 && number >= 8.8){
					return 69;
				}else if(number < 8.8 && number >= 7.2){
					return 66;
				}else if(number < 7.2 && number >= 4.9){
					return 63;
				}else if(number < 4.9 && number >= 2.7){
					return 60;
				}else if(number < 2.7 && number >= 2.2){
					return 50;
				}else if(number < 2.2 && number >= 1.3){
					return 40;
				}else if(number < 1.3 && number >= 0.5){
					return 30;
				}else if(number < 0.5 && number >= -0.6){
					return 20;
				}else if(number < -0.6 && number >= -1.7){
					return 10;
				}else{
					return 0;
				}
			}else{
				//高三女生
				if(number >= 21){
					return 100;
				}else if(number < 21 && number >= 20.7){
					return 98;
				}else if(number < 20.7 && number >= 20.1){
					return 96;
				}else if(number < 20.1 && number >= 19.6){
					return 94;
				}else if(number < 19.6 && number >= 18.9){
					return 92;
				}else if(number < 18.9 && number >= 18.2){
					return 90;
				}else if(number < 18.2 && number >= 17.4){
					return 87;
				}else if(number < 17.4 && number >= 16.2){
					return 84;
				}else if(number < 16.2 && number >= 14.9){
					return 81;
				}else if(number < 14.9 && number >= 13.3){
					return 78;
				}else if(number < 13.3 && number >= 11.7){
					return 75;
				}else if(number < 11.7 && number >= 10.6){
					return 72;
				}else if(number < 10.6 && number >= 8.9){
					return 69;
				}else if(number < 8.9 && number >= 7.2){
					return 66;
				}else if(number < 7.2 && number >= 5){
					return 63;
				}else if(number < 5 && number >= 2.7){
					return 60;
				}else if(number < 2.7 && number >= 2.2){
					return 50;
				}else if(number < 2.2 && number >= 1.5){
					return 40;
				}else if(number < 1.5 && number >= 0.8){
					return 30;
				}else if(number < 0.8 && number >= -0.2){
					return 20;
				}else if(number < -0.2 && number >= -1.2){
					return 10;
				}else{
					return 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(HighUtils.getSitAndReachLevel("无常_"));
	}
	
}
