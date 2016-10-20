package edu.fjnu.Service.UserGradeUtils;

import java.sql.SQLException;

import edu.fjnu.DAO.MiddleInfoDAO;
import edu.fjnu.DAOImpl.MiddleInfoDAOImpl;
import edu.fjnu.Entity.Infos.Middleinfo;

public class MiddleUtils {

	public static int getBMILevel(String userID) {

		MiddleInfoDAO user = new MiddleInfoDAOImpl();
		Middleinfo info = new Middleinfo();
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

	public static int getPullUpLevel(String userID){
		
		int grade = MiddleUtils.getPullUpGrade(userID);
		if(grade >= 90){
			//大于90分，属于优秀
			return 1;
		}else if(grade < 90 && grade >= 80){
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
	
	public static int getPullUpGrade(String userID){
		
		
		MiddleInfoDAO user = new MiddleInfoDAOImpl();
		Middleinfo info = new Middleinfo();
		
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sex = info.getINFO_SEX();
		double age = Double.parseDouble(info.getAge());
		double number = Double.parseDouble(info.getPullUp());
		
		if(sex.equals("M")){
			//男生	
			if(age <= 12){
				//初一男生
				if(number >= 13){
					return 100;
				}else if(number == 12 ){
					return 95;
				}else if(number == 11 ){
					return 90;
				}else if(number == 10 ){
					return 85;
				}else if(number == 9 ){
					return 80;
				}else if(number == 8 ){
					return 76;
				}else if(number == 7 ){
					return 72;
				}else if(number == 6 ){
					return 68;
				}else if(number == 5 ){
					return 64;
				}else if(number == 4 ){
					return 60;
				}else if(number == 3 ){
					return 50;
				}else if(number == 2 ){
					return 40;
				}else if(number == 1 ){
					return 30;
				}else{
					return 20;
				}
				
			}else if(age > 12 && age <= 13){
				//初二男生
				if(number >= 14){
					return 100;
				}else if(number == 13){
					return 95;
				}else if(number == 12 ){
					return 90;
				}else if(number == 11 ){
					return 85;
				}else if(number == 10 ){
					return 80;
				}else if(number == 9 ){
					return 76;
				}else if(number == 8 ){
					return 72;
				}else if(number == 7 ){
					return 68;
				}else if(number == 6 ){
					return 64;
				}else if(number == 5 ){
					return 60;
				}else if(number == 4 ){
					return 50;
				}else if(number == 3 ){
					return 40;
				}else if(number == 2 ){
					return 30;
				}else if(number == 1 ){
					return 20;
				}else{
					return 10;
				}
				
			}else{
				//初三男生
				if(number >= 15){
					return 100;
				}else if(number == 14){
					return 95;
				}else if(number == 13){
					return 90;
				}else if(number == 12 ){
					return 85;
				}else if(number == 11 ){
					return 80;
				}else if(number == 10 ){
					return 76;
				}else if(number == 9 ){
					return 72;
				}else if(number == 8 ){
					return 68;
				}else if(number == 7 ){
					return 64;
				}else if(number == 6 ){
					return 60;
				}else if(number == 5 ){
					return 50;
				}else if(number == 4 ){
					return 40;
				}else if(number == 3 ){
					return 30;
				}else if(number == 2 ){
					return 20;
				}else if(number == 1 ){
					return 10;
				}else{
					return 0;
				}

			}
			
		}else{
			//女生
			if(age <= 12){
				//初一女生
				//女生没有引体向上没事仰卧起坐，男女的测试项目不同，各有打分机制
				if(number >= 50){
					return 100;
				}else if(number < 50 && number >= 48){
					return 95;
				}else if(number < 48 && number >= 46){
					return 90;
				}else if(number < 46 && number >= 43){
					return 85;
				}else if(number < 43 && number >= 40){
					return 80;
				}else if(number < 40 && number >= 38){
					return 78;
				}else if(number < 38 && number >= 36){
					return 76;
				}else if(number < 36 && number >= 34){
					return 74;
				}else if(number < 34 && number >= 32){
					return 72;
				}else if(number < 32 && number >= 30){
					return 70;
				}else if(number < 30 && number >= 28){
					return 68;
				}else if(number < 28 && number >= 26){
					return 66;
				}else if(number < 26 && number >= 24){
					return 64;
				}else if(number < 24 && number >= 22){
					return 62;
				}else if(number < 22 && number >= 20){
					return 60;
				}else if(number < 20 && number >= 18){
					return 50;
				}else if(number < 18 && number >= 16){
					return 40;
				}else if(number < 16 && number >= 14){
					return 30;
				}else if(number < 14 && number >= 12){
					return 20;
				}else if(number < 12 && number >= 10){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 12 && age <= 13){
				//初二女生
				//女生没有引体向上没事仰卧起坐，男女的测试项目不同，各有打分机制
				if(number >= 51){
					return 100;
				}else if(number < 51 && number >= 49){
					return 95;
				}else if(number < 49 && number >= 47){
					return 90;
				}else if(number < 47 && number >= 44){
					return 85;
				}else if(number < 44 && number >= 41){
					return 80;
				}else if(number < 41 && number >= 39){
					return 78;
				}else if(number < 39 && number >= 37){
					return 76;
				}else if(number < 37 && number >= 35){
					return 74;
				}else if(number < 35 && number >= 33){
					return 72;
				}else if(number < 33 && number >= 31){
					return 70;
				}else if(number < 31 && number >= 29){
					return 68;
				}else if(number < 29 && number >= 27){
					return 66;
				}else if(number < 27 && number >= 25){
					return 64;
				}else if(number < 25 && number >= 23){
					return 62;
				}else if(number < 23 && number >= 21){
					return 60;
				}else if(number < 21 && number >= 19){
					return 50;
				}else if(number < 19 && number >= 17){
					return 40;
				}else if(number < 17 && number >= 15){
					return 30;
				}else if(number < 15 && number >= 13){
					return 20;
				}else if(number < 13 && number >= 11){
					return 10;
				}else{
					return 0;
				}
			}else{
				//初三女生
				//女生没有引体向上没事仰卧起坐，男女的测试项目不同，各有打分机制
				if(number >= 52){
					return 100;
				}else if(number < 52 && number >= 50){
					return 95;
				}else if(number < 50 && number >= 48){
					return 90;
				}else if(number < 48 && number >= 45){
					return 85;
				}else if(number < 45 && number >= 42){
					return 80;
				}else if(number < 42 && number >= 40){
					return 78;
				}else if(number < 40 && number >= 38){
					return 76;
				}else if(number < 38 && number >= 36){
					return 74;
				}else if(number < 36 && number >= 34){
					return 72;
				}else if(number < 34 && number >= 32){
					return 70;
				}else if(number < 32 && number >= 30){
					return 68;
				}else if(number < 30 && number >= 28){
					return 66;
				}else if(number < 28 && number >= 26){
					return 64;
				}else if(number < 26 && number >= 24){
					return 62;
				}else if(number < 24 && number >= 22){
					return 60;
				}else if(number < 22 && number >= 20){
					return 50;
				}else if(number < 20 && number >= 18){
					return 40;
				}else if(number < 18 && number >= 16){
					return 30;
				}else if(number < 16 && number >= 14){
					return 20;
				}else if(number < 14 && number >= 12){
					return 10;
				}else{
					return 0;
				}
			}
		}	
	}
	
	public static int getSitAndReachLevel(String userID){
		
		int grade = MiddleUtils.getSitAndReachGrade(userID);
		if(grade >= 90){
			//大于90分，属于优秀
			return 1;
		}else if(grade < 90 && grade >= 80){
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
		
		
		MiddleInfoDAO user = new MiddleInfoDAOImpl();
		Middleinfo info = new Middleinfo();
		
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
			if(age <= 12){
				//初一男生
				if(number >= 17.6){
					return 100;
				}else if(number < 17.6 && number >= 15.9){
					return 95;
				}else if(number < 15.9 && number >= 14.2){
					return 90;
				}else if(number < 14.2 && number >= 12.3){
					return 85;
				}else if(number < 12.3 && number >= 10.4){
					return 80;
				}else if(number < 10.4 && number >= 9.1){
					return 78;
				}else if(number < 9.1 && number >= 7.8){
					return 76;
				}else if(number < 7.8 && number >= 6.5){
					return 74;
				}else if(number < 6.5 && number >= 5.2){
					return 72;
				}else if(number < 5.2 && number >= 3.9){
					return 70;
				}else if(number < 3.9 && number >= 2.6){
					return 68;
				}else if(number < 2.6 && number >= 1.3){
					return 66;
				}else if(number < 1.3 && number >= 0){
					return 64;
				}else if(number < 0 && number >= -1.3){
					return 62;
				}else if(number < -1.3 && number >= -2.6){
					return 60;
				}else if(number < -2.6 && number >= -3.8){
					return 50;
				}else if(number < -3.8 && number >= -5){
					return 40;
				}else if(number < -5 && number >= -6.2){
					return 30;
				}else if(number < -6.2 && number >= -7.4){
					return 20;
				}else if(number < -7.4 && number >= -8.6){
					return 10;
				}else{
					return 0;
				}
				
			}else if(age > 12 && age <= 13){
				//初二男生
				if(number >= 19.6){
					return 100;
				}else if(number < 19.6 && number >= 17.7){
					return 95;
				}else if(number < 17.7 && number >= 15.8){
					return 90;
				}else if(number < 15.8 && number >= 13.7){
					return 85;
				}else if(number < 13.7 && number >= 11.6){
					return 80;
				}else if(number < 11.6 && number >= 10.3){
					return 78;
				}else if(number < 10.3 && number >= 9){
					return 76;
				}else if(number < 9 && number >= 7.7){
					return 74;
				}else if(number < 7.7 && number >= 6.4){
					return 72;
				}else if(number < 6.4 && number >= 5.1){
					return 70;
				}else if(number < 5.1 && number >= 3.8){
					return 68;
				}else if(number < 3.8 && number >= 2.5){
					return 66;
				}else if(number < 2.5 && number >= 1.2){
					return 64;
				}else if(number < 1.2 && number >= -0.1){
					return 62;
				}else if(number < -0.1 && number >= -1.4){
					return 60;
				}else if(number < -1.4 && number >= -2.6){
					return 50;
				}else if(number < -2.6 && number >= -3.8){
					return 40;
				}else if(number < -3.8 && number >= -5){
					return 30;
				}else if(number < -5 && number >= -6.2){
					return 20;
				}else if(number < -6.2 && number >= -7.4){
					return 10;
				}else{
					return 0;
				}
			}else{
				//初三男生
				if(number >= 21.6){
					return 100;
				}else if(number < 21.6 && number >= 19.7){
					return 95;
				}else if(number < 19.7 && number >= 17.8){
					return 90;
				}else if(number < 17.8 && number >= 15.8){
					return 85;
				}else if(number < 15.8 && number >= 13.8){
					return 80;
				}else if(number < 13.8 && number >= 12.4){
					return 78;
				}else if(number < 12.4 && number >= 11){
					return 76;
				}else if(number < 11 && number >= 9.6){
					return 74;
				}else if(number < 9.6 && number >= 8.2){
					return 72;
				}else if(number < 8.2 && number >= 6.8){
					return 70;
				}else if(number < 6.8 && number >= 5.4){
					return 68;
				}else if(number < 5.4 && number >= 4){
					return 66;
				}else if(number < 4 && number >= 2.6){
					return 64;
				}else if(number < 2.6 && number >= 1.2){
					return 62;
				}else if(number < 1.2 && number >= -0.2){
					return 60;
				}else if(number < -0.2 && number >= -1.4){
					return 50;
				}else if(number < -1.4 && number >= -2.6){
					return 40;
				}else if(number < -2.6 && number >= -3.8){
					return 30;
				}else if(number < -3.8 && number >= -5){
					return 20;
				}else if(number < -5 && number >= -6.2){
					return 10;
				}else{
					return 0;
				}
			}
			
		}else{
			//女生
			if(age <= 12){
				//初一女生
				if(number >= 21.8){
					return 100;
				}else if(number < 21.8 && number >= 20.1){
					return 95;
				}else if(number < 20.1 && number >= 18.4){
					return 90;
				}else if(number < 18.4 && number >= 16.7){
					return 85;
				}else if(number < 16.7 && number >= 15){
					return 80;
				}else if(number < 15 && number >= 13.7){
					return 78;
				}else if(number < 13.7 && number >= 12.4){
					return 76;
				}else if(number < 12.4 && number >= 11.1){
					return 74;
				}else if(number < 11.1 && number >= 9.8){
					return 72;
				}else if(number < 9.8 && number >= 8.5){
					return 70;
				}else if(number < 8.5 && number >= 7.2){
					return 68;
				}else if(number < 7.2 && number >= 5.9){
					return 66;
				}else if(number < 5.9 && number >= 4.6){
					return 64;
				}else if(number < 4.6 && number >= 3.3){
					return 62;
				}else if(number < 3.3 && number >= 2){
					return 60;
				}else if(number < 2 && number >= 1.2){
					return 50;
				}else if(number < 1.2 && number >= 0.4){
					return 40;
				}else if(number < 0.4 && number >= -0.4){
					return 30;
				}else if(number < -0.4 && number >= -1.2){
					return 20;
				}else if(number < -1.2 && number >= -2){
					return 10;
				}else{
					return 0;
				}
				
			}else if(age > 12 && age <= 13){
				//初二女生
				if(number >= 22.7){
					return 100;
				}else if(number < 22.7 && number >= 21){
					return 95;
				}else if(number < 21 && number >= 19.3){
					return 90;
				}else if(number < 19.3 && number >= 17.6){
					return 85;
				}else if(number < 17.6 && number >= 15.9){
					return 80;
				}else if(number < 15.9 && number >= 14.6){
					return 78;
				}else if(number < 14.6 && number >= 13.3){
					return 76;
				}else if(number < 13.3 && number >= 12){
					return 74;
				}else if(number < 12 && number >= 10.7){
					return 72;
				}else if(number < 10.7 && number >= 9.4){
					return 70;
				}else if(number < 9.4 && number >= 8.1){
					return 68;
				}else if(number < 8.1 && number >= 6.8){
					return 66;
				}else if(number < 6.8 && number >= 5.5){
					return 64;
				}else if(number < 5.5 && number >= 4.2){
					return 62;
				}else if(number < 4.2 && number >= 2.9){
					return 60;
				}else if(number < 2.9 && number >= 2.1){
					return 50;
				}else if(number < 2.1 && number >= 1.3){
					return 40;
				}else if(number < 1.3 && number >= 0.5){
					return 30;
				}else if(number < 0.5 && number >= -0.3){
					return 20;
				}else if(number < -0.3 && number >= -1.1){
					return 10;
				}else{
					return 0;
				}
			}else{
				//初三女生
				if(number >= 23.5){
					return 100;
				}else if(number < 23.5 && number >= 21.8){
					return 95;
				}else if(number < 21.8 && number >= 20.1){
					return 90;
				}else if(number < 20.1 && number >= 18.4){
					return 85;
				}else if(number < 18.4 && number >= 16.7){
					return 80;
				}else if(number < 16.7 && number >= 15.4){
					return 78;
				}else if(number < 15.4 && number >= 14.1){
					return 76;
				}else if(number < 14.1 && number >= 12.8){
					return 74;
				}else if(number < 12.8 && number >= 11.5){
					return 72;
				}else if(number < 11.5 && number >= 10.2){
					return 70;
				}else if(number < 10.2 && number >= 8.9){
					return 68;
				}else if(number < 8.9 && number >= 7.6){
					return 66;
				}else if(number < 7.6 && number >= 6.3){
					return 64;
				}else if(number < 6.3 && number >= 5){
					return 62;
				}else if(number < 5 && number >= 3.7){
					return 60;
				}else if(number < 3.7 && number >= 2.9){
					return 50;
				}else if(number < 2.9 && number >= 2.1){
					return 40;
				}else if(number < 2.1 && number >= 1.3){
					return 30;
				}else if(number < 1.3 && number >= 0.5){
					return 20;
				}else if(number < 0.5 && number >= -0.3){
					return 10;
				}else{
					return 0;
				}
			}
		}
	}
	
	public static int getBenchTestLevel(String userID){
		
		int grade = MiddleUtils.getBenchTestGrade(userID);
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
		
		MiddleInfoDAO user = new MiddleInfoDAOImpl();
		Middleinfo info = new Middleinfo();
		
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sex = info.getINFO_SEX();
		double number = Double.parseDouble(info.getBenchTest());
		double age = Double.parseDouble(info.getAge());
		
		if(sex.equals("M")){
			//男生
			if(age <= 12){
				//初中一年级男生
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
				//初二男生
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
				//初三男生
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
				//初中一年级女生
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
				//初二女生
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
				//初三女生
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
	
	public static int getSkipRopeLevel(String userID){
		
		int grade = MiddleUtils.getSkipRopeGrade(userID);
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
	
	public static int getSkipRopeGrade(String userID){
		
		MiddleInfoDAO user = new MiddleInfoDAOImpl();
		Middleinfo info = new Middleinfo();
		
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sex = info.getINFO_SEX();
		double age = Double.parseDouble(info.getAge());
		double number = Double.parseDouble(info.getSkipRope());
		
		if(sex.equals("M")){
			//男生
			if(age <= 12){
				//初一男生
				if(number >= 170){
					return 100;
				}else if(number < 170 && number >= 165){
					return 98;
				}else if(number < 165 && number >= 158){
					return 96;
				}else if(number < 158 && number >= 150){
					return 94;
				}else if(number < 150 && number >= 140){
					return 92;
				}else if(number < 140 && number >= 130){
					return 90;
				}else if(number < 130 && number >= 126){
					return 87;
				}else if(number < 126 && number >= 121){
					return 84;
				}else if(number < 121 && number >= 115){
					return 81;
				}else if(number < 115 && number >= 108){
					return 78;
				}else if(number < 108 && number >= 100){
					return 75;
				}else if(number < 100 && number >= 94){
					return 72;
				}else if(number < 94 && number >= 86){
					return 69;
				}else if(number < 86 && number >= 78){
					return 66;
				}else if(number < 78 && number >= 66){
					return 63;
				}else if(number < 66 && number >= 55){
					return 60;
				}else if(number < 55 && number >= 51){
					return 50;
				}else if(number < 51 && number >= 44){
					return 40;
				}else if(number < 44 && number >= 38){
					return 30;
				}else if(number < 38 && number >= 29){
					return 20;
				}else if(number < 29 && number >= 20){
					return 10;
				}else{
					return 0;
				}
				
			}else if(age > 12 && age <= 13){
				//初二男生
				if(number >= 175){
					return 100;
				}else if(number < 175 && number >= 170){
					return 98;
				}else if(number < 170 && number >= 163){
					return 96;
				}else if(number < 163 && number >= 155){
					return 94;
				}else if(number < 155 && number >= 145){
					return 92;
				}else if(number < 145 && number >= 135){
					return 90;
				}else if(number < 135 && number >= 131){
					return 87;
				}else if(number < 131 && number >= 126){
					return 84;
				}else if(number < 126 && number >= 120){
					return 81;
				}else if(number < 120 && number >= 113){
					return 78;
				}else if(number < 113 && number >= 105){
					return 75;
				}else if(number < 105 && number >= 99){
					return 72;
				}else if(number < 99 && number >= 91){
					return 69;
				}else if(number < 91 && number >= 83){
					return 66;
				}else if(number < 83 && number >= 71){
					return 63;
				}else if(number < 71 && number >= 60){
					return 60;
				}else if(number < 60 && number >= 56){
					return 50;
				}else if(number < 56 && number >= 49){
					return 40;
				}else if(number < 49 && number >= 43){
					return 30;
				}else if(number < 43 && number >= 34){
					return 20;
				}else if(number < 34 && number >= 25){
					return 10;
				}else{
					return 0;
				}
			}else{
				//初三男生
				if(number >= 180){
					return 100;
				}else if(number < 180 && number >= 175){
					return 98;
				}else if(number < 175 && number >= 168){
					return 96;
				}else if(number < 168 && number >= 160){
					return 94;
				}else if(number < 160 && number >= 150){
					return 92;
				}else if(number < 150 && number >= 140){
					return 90;
				}else if(number < 140 && number >= 136){
					return 87;
				}else if(number < 136 && number >= 130){
					return 84;
				}else if(number < 130 && number >= 124){
					return 81;
				}else if(number < 124 && number >= 116){
					return 78;
				}else if(number < 116 && number >= 108){
					return 75;
				}else if(number < 108 && number >= 103){
					return 72;
				}else if(number < 103 && number >= 94){
					return 69;
				}else if(number < 94 && number >= 86){
					return 66;
				}else if(number < 86 && number >= 75){
					return 63;
				}else if(number < 75 && number >= 64){
					return 60;
				}else if(number < 64 && number >= 60){
					return 50;
				}else if(number < 60 && number >= 53){
					return 40;
				}else if(number < 53 && number >= 46){
					return 30;
				}else if(number < 46 && number >= 37){
					return 20;
				}else if(number < 37 && number >= 28){
					return 10;
				}else{
					return 0;
				}
			}
			
		}else{
			//女生
			if(age <= 12){
				//初一女生
				if(number >= 168){
					return 100;
				}else if(number < 168 && number >= 163){
					return 98;
				}else if(number < 163 && number >= 156){
					return 96;
				}else if(number < 156 && number >= 148){
					return 94;
				}else if(number < 148 && number >= 138){
					return 92;
				}else if(number < 138 && number >= 128){
					return 90;
				}else if(number < 128 && number >= 124){
					return 87;
				}else if(number < 124 && number >= 117){
					return 84;
				}else if(number < 117 && number >= 111){
					return 81;
				}else if(number < 111 && number >= 103){
					return 78;
				}else if(number < 103 && number >= 94){
					return 75;
				}else if(number < 94 && number >= 89){
					return 72;
				}else if(number < 89 && number >= 81){
					return 69;
				}else if(number < 81 && number >= 74){
					return 66;
				}else if(number < 74 && number >= 63){
					return 63;
				}else if(number < 63 && number >= 53){
					return 60;
				}else if(number < 53 && number >= 49){
					return 50;
				}else if(number < 49 && number >= 43){
					return 40;
				}else if(number < 43 && number >= 38){
					return 30;
				}else if(number < 38 && number >= 30){
					return 20;
				}else if(number < 30 && number >= 22){
					return 10;
				}else{
					return 0;
				}
				
			}else if(age > 12 && age <= 13){
				//初二女生
				if(number >= 170){
					return 100;
				}else if(number < 170 && number >= 165){
					return 98;
				}else if(number < 165 && number >= 158){
					return 96;
				}else if(number < 158 && number >= 150){
					return 94;
				}else if(number < 150 && number >= 140){
					return 92;
				}else if(number < 140 && number >= 130){
					return 90;
				}else if(number < 130 && number >= 126){
					return 87;
				}else if(number < 126 && number >= 120){
					return 84;
				}else if(number < 120 && number >= 115){
					return 81;
				}else if(number < 115 && number >= 107){
					return 78;
				}else if(number < 107 && number >= 99){
					return 75;
				}else if(number < 99 && number >= 94){
					return 72;
				}else if(number < 94 && number >= 85){
					return 69;
				}else if(number < 85 && number >= 77){
					return 66;
				}else if(number < 77 && number >= 66){
					return 63;
				}else if(number < 66 && number >= 55){
					return 60;
				}else if(number < 55 && number >= 51){
					return 50;
				}else if(number < 51 && number >= 45){
					return 40;
				}else if(number < 45 && number >= 39){
					return 30;
				}else if(number < 39 && number >= 31){
					return 20;
				}else if(number < 31 && number >= 23){
					return 10;
				}else{
					return 0;
				}
			}else{
				//初三女生
				if(number >= 172){
					return 100;
				}else if(number < 172 && number >= 167){
					return 98;
				}else if(number < 167 && number >= 160){
					return 96;
				}else if(number < 160 && number >= 153){
					return 94;
				}else if(number < 153 && number >= 143){
					return 92;
				}else if(number < 143 && number >= 133){
					return 90;
				}else if(number < 133 && number >= 129){
					return 87;
				}else if(number < 129 && number >= 123){
					return 84;
				}else if(number < 123 && number >= 117){
					return 81;
				}else if(number < 117 && number >= 109){
					return 78;
				}else if(number < 109 && number >= 101){
					return 75;
				}else if(number < 101 && number >= 96){
					return 72;
				}else if(number < 96 && number >= 88){
					return 69;
				}else if(number < 88 && number >= 80){
					return 66;
				}else if(number < 80 && number >= 69){
					return 63;
				}else if(number < 69 && number >= 58){
					return 60;
				}else if(number < 58 && number >= 54){
					return 50;
				}else if(number < 54 && number >= 48){
					return 40;
				}else if(number < 48 && number >= 42){
					return 30;
				}else if(number < 42 && number >= 33){
					return 20;
				}else if(number < 33 && number >= 25){
					return 10;
				}else{
					return 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(MiddleUtils.getSkipRopeGrade("无常_"));
	}

}
