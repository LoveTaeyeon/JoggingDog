package edu.fjnu.Service.UserGradeUtils;

import java.sql.SQLException;

import edu.fjnu.DAO.PrimaryInfoDAO;
import edu.fjnu.DAOImpl.PrimaryInfoDAOImpl;
import edu.fjnu.Entity.Infos.Primaryinfo;

public class PrimaryUtils {

	//小学生分数判断的工具类
	
	public static int getBMILevel(String userID){
		
		PrimaryInfoDAO user = new PrimaryInfoDAOImpl();
		Primaryinfo info = new Primaryinfo();
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		double BMI = Double.parseDouble(info.getBMI());
		if(BMI >= 17.9 && BMI <= 23.9){
			return 100;			//属于正常状态
		}else if(BMI < 17.9){
			return 80;			//体重指数偏低，偏瘦状态
		}else if(BMI >23.9 && BMI <= 27.9){
			return 70;			//体重指数偏高，超重状态
		}else{
			return 50;			//体重指数过高，肥胖状态
		}
	}
	
	public static int getFVCLevel(String userID){
		int grade = PrimaryUtils.getFVCGrade(userID);
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
	
	public static int getFVCGrade(String userID){
		
		PrimaryInfoDAO user = new PrimaryInfoDAOImpl();
		Primaryinfo info = new Primaryinfo();
		
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double fvc = Double.parseDouble(info.getFVC());
		String sex = info.getINFO_SEX();
		double age = Double.parseDouble(info.getAge());
		if(sex.equals("M")){	//性别男
			//判断性别，不同性别的标准不同
			if(age <= 6){
				//小学一年级的男生
				//根据国家体测标准定义分数
				if(fvc >= 1700){
					return 100;
				}else if(fvc < 1700 && fvc >= 1600){
					return 95;
				}else if(fvc < 1600 && fvc >= 1500){
					return 90;
				}else if(fvc < 1500 && fvc >= 1400){
					return 85;
				}else if(fvc < 1400 && fvc >= 1300){
					return 80;
				}else if(fvc < 1300 && fvc >= 1240){
					return 78;
				}else if(fvc < 1240 && fvc >= 1180){
					return 76;
				}else if(fvc < 1180 && fvc >= 1120){
					return 74;
				}else if(fvc < 1120 && fvc >= 1060){
					return 72;
				}else if(fvc < 1060 && fvc >= 1000){
					return 70;
				}else if(fvc < 1000 && fvc >= 940){
					return 68;
				}else if(fvc < 940 && fvc >= 880){
					return 66;
				}else if(fvc < 880 && fvc >= 820){
					return 64;
				}else if(fvc < 820 && fvc >= 760){
					return 62;
				}else if(fvc < 760 && fvc >= 700){
					return 60;
				}else if(fvc < 700 && fvc >= 660){
					return 50;
				}else if(fvc < 660 && fvc >= 620){
					return 40;
				}else if(fvc < 620 && fvc >= 580){
					return 30;
				}else if(fvc < 580 && fvc >= 540){
					return 20;
				}else if(fvc < 540 && fvc >= 500){
					return 10;
				}else{
					return 0;
				}
			}else if(age <=7 && age >6){
				//小学二年级的男生
				//根据国家体测标准定义分数
				if(fvc >= 2000){
					return 100;
				}else if(fvc < 2000 && fvc >= 1900){
					return 95;
				}else if(fvc < 1900 && fvc >= 1800){
					return 90;
				}else if(fvc < 1800 && fvc >= 1650){
					return 85;
				}else if(fvc < 1650 && fvc >= 1500){
					return 80;
				}else if(fvc < 1500 && fvc >= 1430){
					return 78;
				}else if(fvc < 1430 && fvc >= 1360){
					return 76;
				}else if(fvc < 1360 && fvc >= 1290){
					return 74;
				}else if(fvc < 1290 && fvc >= 1220){
					return 72;
				}else if(fvc < 1220 && fvc >= 1150){
					return 70;
				}else if(fvc < 1150 && fvc >= 1080){
					return 68;
				}else if(fvc < 1080 && fvc >= 1010){
					return 66;
				}else if(fvc < 1010 && fvc >= 940){
					return 64;
				}else if(fvc < 940 && fvc >= 870){
					return 62;
				}else if(fvc < 870 && fvc >= 800){
					return 60;
				}else if(fvc < 800 && fvc >= 750){
					return 50;
				}else if(fvc < 750 && fvc >= 700){
					return 40;
				}else if(fvc < 700 && fvc >= 650){
					return 30;
				}else if(fvc < 650 && fvc >= 600){
					return 20;
				}else if(fvc < 600 && fvc >= 550){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 8 && age > 7){
				//小学三年级的男生
				//根据国家体测标准定义分数
				if(fvc >= 2300){
					return 100;
				}else if(fvc < 2300 && fvc >= 2200){
					return 95;
				}else if(fvc < 2200 && fvc >= 2100){
					return 90;
				}else if(fvc < 2100 && fvc >= 1900){
					return 85;
				}else if(fvc < 1900 && fvc >= 1700){
					return 80;
				}else if(fvc < 1700 && fvc >= 1620){
					return 78;
				}else if(fvc < 1620 && fvc >= 1540){
					return 76;
				}else if(fvc < 1540 && fvc >= 1460){
					return 74;
				}else if(fvc < 1460 && fvc >= 1380){
					return 72;
				}else if(fvc < 1380 && fvc >= 1300){
					return 70;
				}else if(fvc < 1300 && fvc >= 1220){
					return 68;
				}else if(fvc < 1220 && fvc >= 1140){
					return 66;
				}else if(fvc < 1140 && fvc >= 1060){
					return 64;
				}else if(fvc < 1060 && fvc >= 980){
					return 62;
				}else if(fvc < 980 && fvc >= 900){
					return 60;
				}else if(fvc < 900 && fvc >= 840){
					return 50;
				}else if(fvc < 840 && fvc >= 780){
					return 40;
				}else if(fvc < 780 && fvc >= 720){
					return 30;
				}else if(fvc < 720 && fvc >= 660){
					return 20;
				}else if(fvc < 660 && fvc >= 600){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 9 && age > 8){
				//小学四年级的男生
				//根据国家体测标准定义分数
				if(fvc >= 2600){
					return 100;
				}else if(fvc < 2600 && fvc >= 2500){
					return 95;
				}else if(fvc < 2500 && fvc >= 2400){
					return 90;
				}else if(fvc < 2400 && fvc >= 2150){
					return 85;
				}else if(fvc < 2150 && fvc >= 1900){
					return 80;
				}else if(fvc < 1900 && fvc >= 1820){
					return 78;
				}else if(fvc < 1820 && fvc >= 1740){
					return 76;
				}else if(fvc < 1740 && fvc >= 1660){
					return 74;
				}else if(fvc < 1660 && fvc >= 1580){
					return 72;
				}else if(fvc < 1580 && fvc >= 1500){
					return 70;
				}else if(fvc < 1500 && fvc >= 1420){
					return 68;
				}else if(fvc < 1420 && fvc >= 1340){
					return 66;
				}else if(fvc < 1340 && fvc >= 1260){
					return 64;
				}else if(fvc < 1260 && fvc >= 1180){
					return 62;
				}else if(fvc < 1180 && fvc >= 1100){
					return 60;
				}else if(fvc < 1100 && fvc >= 1030){
					return 50;
				}else if(fvc < 1030 && fvc >= 960){
					return 40;
				}else if(fvc < 960 && fvc >= 890){
					return 30;
				}else if(fvc < 890 && fvc >= 820){
					return 20;
				}else if(fvc < 820 && fvc >= 750){
					return 10;
				}else{
					return 0;
				}
			}else  if(age <= 10 && age > 9){
				//小学五年级的男生
				//根据国家体测标准定义分数
				if(fvc >= 2900){
					return 100;
				}else if(fvc < 2900 && fvc >= 2800){
					return 95;
				}else if(fvc < 2800 && fvc >= 2700){
					return 90;
				}else if(fvc < 2700 && fvc >= 2450){
					return 85;
				}else if(fvc < 2450 && fvc >= 2200){
					return 80;
				}else if(fvc < 2200 && fvc >= 2110){
					return 78;
				}else if(fvc < 2110 && fvc >= 2020){
					return 76;
				}else if(fvc < 2020 && fvc >= 1930){
					return 74;
				}else if(fvc < 1930 && fvc >= 1840){
					return 72;
				}else if(fvc < 1840 && fvc >= 1750){
					return 70;
				}else if(fvc < 1750 && fvc >= 1660){
					return 68;
				}else if(fvc < 1660 && fvc >= 1570){
					return 66;
				}else if(fvc < 1570 && fvc >= 1480){
					return 64;
				}else if(fvc < 1480 && fvc >= 1390){
					return 62;
				}else if(fvc < 1390 && fvc >= 1300){
					return 60;
				}else if(fvc < 1300 && fvc >= 1220){
					return 50;
				}else if(fvc < 1220 && fvc >= 1140){
					return 40;
				}else if(fvc < 1140 && fvc >= 1060){
					return 30;
				}else if(fvc < 1060 && fvc >= 980){
					return 20;
				}else if(fvc < 980 && fvc >= 900){
					return 10;
				}else{
					return 0;
				}
			}else{
				//小学六年级的男生
				//根据国家体测标准定义分数
				if(fvc >= 3200){
					return 100;
				}else if(fvc < 3200 && fvc >= 3100){
					return 95;
				}else if(fvc < 3100 && fvc >= 3000){
					return 90;
				}else if(fvc < 3000 && fvc >= 2700){
					return 85;
				}else if(fvc < 2750 && fvc >= 2450){
					return 80;
				}else if(fvc < 2500 && fvc >= 2200){
					return 78;
				}else if(fvc < 2400 && fvc >= 2110){
					return 76;
				}else if(fvc < 2300 && fvc >= 2020){
					return 74;
				}else if(fvc < 2200 && fvc >= 1930){
					return 72;
				}else if(fvc < 2100 && fvc >= 1840){
					return 70;
				}else if(fvc < 2000 && fvc >= 1750){
					return 68;
				}else if(fvc < 1900 && fvc >= 1660){
					return 66;
				}else if(fvc < 1800 && fvc >= 1570){
					return 64;
				}else if(fvc < 1700 && fvc >= 1480){
					return 62;
				}else if(fvc < 1600 && fvc >= 1390){
					return 60;
				}else if(fvc < 1500 && fvc >= 1300){
					return 50;
				}else if(fvc < 1410 && fvc >= 1220){
					return 40;
				}else if(fvc < 1320 && fvc >= 1140){
					return 30;
				}else if(fvc < 1230 && fvc >= 1060){
					return 20;
				}else if(fvc < 1140 && fvc >= 980){
					return 10;
				}else{
					return 0;
				}
			}
			
		}else{
			//女生
			if(age <= 6){
				//小学一年级的女生
				//根据国家体测标准定义分数
				if(fvc >= 1400){
					return 100;
				}else if(fvc < 1400 && fvc >= 1300){
					return 95;
				}else if(fvc < 1300 && fvc >= 1200){
					return 90;
				}else if(fvc < 1200 && fvc >= 1100){
					return 85;
				}else if(fvc < 1100 && fvc >= 1000){
					return 80;
				}else if(fvc < 1000 && fvc >= 960){
					return 78;
				}else if(fvc < 960 && fvc >= 920){
					return 76;
				}else if(fvc < 920 && fvc >= 880){
					return 74;
				}else if(fvc < 880 && fvc >= 840){
					return 72;
				}else if(fvc < 840 && fvc >= 800){
					return 70;
				}else if(fvc < 800 && fvc >= 760){
					return 68;
				}else if(fvc < 760 && fvc >= 720){
					return 66;
				}else if(fvc < 720 && fvc >= 680){
					return 64;
				}else if(fvc < 680 && fvc >= 640){
					return 62;
				}else if(fvc < 640 && fvc >= 600){
					return 60;
				}else if(fvc < 600 && fvc >= 580){
					return 50;
				}else if(fvc < 580 && fvc >= 560){
					return 40;
				}else if(fvc < 560 && fvc >= 540){
					return 30;
				}else if(fvc < 540 && fvc >= 520){
					return 20;
				}else if(fvc < 520 && fvc >= 500){
					return 10;
				}else{
					return 0;
				}
			}else if(age <=7 && age >6){
				//小学二年级的女生
				//根据国家体测标准定义分数
				if(fvc >= 1600){
					return 100;
				}else if(fvc < 1600 && fvc >= 1500){
					return 95;
				}else if(fvc < 1500 && fvc >= 1400){
					return 90;
				}else if(fvc < 1400 && fvc >= 1300){
					return 85;
				}else if(fvc < 1300 && fvc >= 1200){
					return 80;
				}else if(fvc < 1200 && fvc >= 1150){
					return 78;
				}else if(fvc < 1150 && fvc >= 1100){
					return 76;
				}else if(fvc < 1100 && fvc >= 1050){
					return 74;
				}else if(fvc < 1050 && fvc >= 1000){
					return 72;
				}else if(fvc < 1000 && fvc >= 950){
					return 70;
				}else if(fvc < 950 && fvc >= 900){
					return 68;
				}else if(fvc < 900 && fvc >= 850){
					return 66;
				}else if(fvc < 850 && fvc >= 800){
					return 64;
				}else if(fvc < 800 && fvc >= 750){
					return 62;
				}else if(fvc < 750 && fvc >= 700){
					return 60;
				}else if(fvc < 700 && fvc >= 680){
					return 50;
				}else if(fvc < 680 && fvc >= 660){
					return 40;
				}else if(fvc < 660 && fvc >= 640){
					return 30;
				}else if(fvc < 640 && fvc >= 620){
					return 20;
				}else if(fvc < 620 && fvc >= 600){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 8 && age > 7){
				//小学三年级的女生
				//根据国家体测标准定义分数
				if(fvc >= 1800){
					return 100;
				}else if(fvc < 1800 && fvc >= 1700){
					return 95;
				}else if(fvc < 1700 && fvc >= 1600){
					return 90;
				}else if(fvc < 1600 && fvc >= 1500){
					return 85;
				}else if(fvc < 1500 && fvc >= 1400){
					return 80;
				}else if(fvc < 1400 && fvc >= 1340){
					return 78;
				}else if(fvc < 1340 && fvc >= 1280){
					return 76;
				}else if(fvc < 1280 && fvc >= 1220){
					return 74;
				}else if(fvc < 1220 && fvc >= 1160){
					return 72;
				}else if(fvc < 1160 && fvc >= 1100){
					return 70;
				}else if(fvc < 1100 && fvc >= 1040){
					return 68;
				}else if(fvc < 1040 && fvc >= 980){
					return 66;
				}else if(fvc < 980 && fvc >= 920){
					return 64;
				}else if(fvc < 920 && fvc >= 860){
					return 62;
				}else if(fvc < 860 && fvc >= 800){
					return 60;
				}else if(fvc < 800 && fvc >= 780){
					return 50;
				}else if(fvc < 780 && fvc >= 760){
					return 40;
				}else if(fvc < 760 && fvc >= 740){
					return 30;
				}else if(fvc < 740 && fvc >= 720){
					return 20;
				}else if(fvc < 720 && fvc >= 700){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 9 && age > 8){
				//小学四年级的女生
				//根据国家体测标准定义分数
				if(fvc >= 2000){
					return 100;
				}else if(fvc < 2000 && fvc >= 1900){
					return 95;
				}else if(fvc < 1900 && fvc >= 1800){
					return 90;
				}else if(fvc < 1800 && fvc >= 1700){
					return 85;
				}else if(fvc < 1700 && fvc >= 1600){
					return 80;
				}else if(fvc < 1600 && fvc >= 1530){
					return 78;
				}else if(fvc < 1530 && fvc >= 1460){
					return 76;
				}else if(fvc < 1460 && fvc >= 1390){
					return 74;
				}else if(fvc < 1390 && fvc >= 1320){
					return 72;
				}else if(fvc < 1320 && fvc >= 1250){
					return 70;
				}else if(fvc < 1250 && fvc >= 1180){
					return 68;
				}else if(fvc < 1180 && fvc >= 1110){
					return 66;
				}else if(fvc < 1110 && fvc >= 1040){
					return 64;
				}else if(fvc < 1040 && fvc >= 970){
					return 62;
				}else if(fvc < 970 && fvc >= 900){
					return 60;
				}else if(fvc < 900 && fvc >= 880){
					return 50;
				}else if(fvc < 880 && fvc >= 860){
					return 40;
				}else if(fvc < 860 && fvc >= 840){
					return 30;
				}else if(fvc < 840 && fvc >= 820){
					return 20;
				}else if(fvc < 820 && fvc >= 800){
					return 10;
				}else{
					return 0;
				}
			}else  if(age <= 10 && age > 9){
				//小学五年级的女生
				//根据国家体测标准定义分数
				if(fvc >= 2250){
					return 100;
				}else if(fvc < 2250 && fvc >= 2150){
					return 95;
				}else if(fvc < 2150 && fvc >= 2050){
					return 90;
				}else if(fvc < 2050 && fvc >= 1950){
					return 85;
				}else if(fvc < 1950 && fvc >= 1850){
					return 80;
				}else if(fvc < 1850 && fvc >= 1770){
					return 78;
				}else if(fvc < 1770 && fvc >= 1690){
					return 76;
				}else if(fvc < 1690 && fvc >= 1610){
					return 74;
				}else if(fvc < 1610 && fvc >= 1530){
					return 72;
				}else if(fvc < 1530 && fvc >= 1450){
					return 70;
				}else if(fvc < 1450 && fvc >= 1370){
					return 68;
				}else if(fvc < 1370 && fvc >= 1290){
					return 66;
				}else if(fvc < 1290 && fvc >= 1210){
					return 64;
				}else if(fvc < 1210 && fvc >= 1130){
					return 62;
				}else if(fvc < 1130 && fvc >= 1050){
					return 60;
				}else if(fvc < 1050 && fvc >= 1020){
					return 50;
				}else if(fvc < 1020 && fvc >= 990){
					return 40;
				}else if(fvc < 990 && fvc >= 960){
					return 30;
				}else if(fvc < 960 && fvc >= 930){
					return 20;
				}else if(fvc < 930 && fvc >= 900){
					return 10;
				}else{
					return 0;
				}
			}else{
				//小学六年级的女生
				//根据国家体测标准定义分数
				if(fvc >= 2500){
					return 100;
				}else if(fvc < 2500 && fvc >= 2400){
					return 95;
				}else if(fvc < 2400 && fvc >= 2300){
					return 90;
				}else if(fvc < 2300 && fvc >= 2200){
					return 85;
				}else if(fvc < 2200 && fvc >= 2100){
					return 80;
				}else if(fvc < 2100 && fvc >= 2010){
					return 78;
				}else if(fvc < 2010 && fvc >= 1920){
					return 76;
				}else if(fvc < 1920 && fvc >= 1830){
					return 74;
				}else if(fvc < 1830 && fvc >= 1740){
					return 72;
				}else if(fvc < 1740 && fvc >= 1650){
					return 70;
				}else if(fvc < 1650 && fvc >= 1560){
					return 68;
				}else if(fvc < 1560 && fvc >= 1470){
					return 66;
				}else if(fvc < 1470 && fvc >= 1380){
					return 64;
				}else if(fvc < 1380 && fvc >= 1290){
					return 62;
				}else if(fvc < 1290 && fvc >= 1200){
					return 60;
				}else if(fvc < 1200 && fvc >= 1170){
					return 50;
				}else if(fvc < 1170 && fvc >= 1140){
					return 40;
				}else if(fvc < 1140 && fvc >= 1110){
					return 30;
				}else if(fvc < 1110 && fvc >= 1080){
					return 20;
				}else if(fvc < 1080 && fvc >= 1050){
					return 10;
				}else{
					return 0;
				}
			}
		}	
	}
	
	public static int getShortRunLevel(String userID){
		
		int grade = PrimaryUtils.getShortRunGrade(userID);
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
	
	public static int getShortRunGrade(String userID){
		
		PrimaryInfoDAO user = new PrimaryInfoDAOImpl();
		Primaryinfo info = new Primaryinfo();
		
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		double time = Double.parseDouble(info.getShortRun());
		double age = Double.parseDouble(info.getAge());
		String sex = info.getINFO_SEX();
		
		if(sex.equals("M")){
			//男生
			if(age <= 6){
				//小学一年级男生
				//根据国家体测标准定义分数
				if(time <= 10.2){
					return 100;
				}else if(time > 10.2 && time <= 10.3){
					return 95;
				}else if(time > 10.3 && time <= 10.4){
					return 90;
				}else if(time > 10.4 && time <= 10.5){
					return 85;
				}else if(time > 10.5 && time <= 10.6){
					return 80;
				}else if(time > 10.6 && time <= 10.8){
					return 78;
				}else if(time > 10.8 && time <= 11){
					return 76;
				}else if(time > 11 && time <= 11.2){
					return 74;
				}else if(time > 11.2 && time <= 11.4){
					return 72;
				}else if(time > 11.4 && time <= 11.6){
					return 70;
				}else if(time > 11.6 && time <= 11.8){
					return 68;
				}else if(time > 11.8 && time <= 12){
					return 66;
				}else if(time > 12 && time <= 12.2){
					return 64;
				}else if(time > 12.2 && time <= 12.4){
					return 62;
				}else if(time > 12.4 && time <= 12.6){
					return 60;
				}else if(time > 12.6 && time <= 12.8){
					return 50;
				}else if(time > 12.8 && time <= 13){
					return 40;
				}else if(time > 13 && time <= 13.2){
					return 30;
				}else if(time > 13.2 && time <= 13.4){
					return 20;
				}else if(time > 13.4 && time <= 13.6){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 7 && age > 6){
				//小学二年级男生
				//根据国家体测标准定义分数
				if(time <= 9.6){
					return 100;
				}else if(time > 9.6 && time <= 9.7){
					return 95;
				}else if(time > 9.7 && time <= 9.8){
					return 90;
				}else if(time > 9.8 && time <= 9.9){
					return 85;
				}else if(time > 9.9 && time <= 10){
					return 80;
				}else if(time > 10 && time <= 10.2){
					return 78;
				}else if(time > 10.2 && time <= 10.4){
					return 76;
				}else if(time > 10.4 && time <= 10.6){
					return 74;
				}else if(time > 10.6 && time <= 10.8){
					return 72;
				}else if(time > 10.8 && time <= 11){
					return 70;
				}else if(time > 11 && time <= 11.2){
					return 68;
				}else if(time > 11.2 && time <= 11.4){
					return 66;
				}else if(time > 11.4 && time <= 11.6){
					return 64;
				}else if(time > 11.6 && time <= 11.8){
					return 62;
				}else if(time > 11.8 && time <= 12){
					return 60;
				}else if(time > 12 && time <= 12.2){
					return 50;
				}else if(time > 12.2 && time <= 12.4){
					return 40;
				}else if(time > 12.4 && time <= 12.6){
					return 30;
				}else if(time > 12.6 && time <= 12.8){
					return 20;
				}else if(time > 12.8 && time <= 13){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 8 && age > 7){
				//小学三年级男生
				//根据国家体测标准定义分数
				if(time <= 9.1){
					return 100;
				}else if(time > 9.1 && time <= 9.2){
					return 95;
				}else if(time > 9.2 && time <= 9.3){
					return 90;
				}else if(time > 9.3 && time <= 9.4){
					return 85;
				}else if(time > 9.4 && time <= 9.5){
					return 80;
				}else if(time > 9.5 && time <= 9.7){
					return 78;
				}else if(time > 9.7 && time <= 9.9){
					return 76;
				}else if(time > 9.9 && time <= 10.1){
					return 74;
				}else if(time > 10.1 && time <= 10.3){
					return 72;
				}else if(time > 10.3 && time <= 10.5){
					return 70;
				}else if(time > 10.5 && time <= 10.7){
					return 68;
				}else if(time > 10.7 && time <= 10.9){
					return 66;
				}else if(time > 10.9 && time <= 11.1){
					return 64;
				}else if(time > 11.1 && time <= 11.3){
					return 62;
				}else if(time > 11.3 && time <= 11.5){
					return 60;
				}else if(time > 11.5 && time <= 11.7){
					return 50;
				}else if(time > 11.7 && time <= 11.9){
					return 40;
				}else if(time > 11.9 && time <= 12.1){
					return 30;
				}else if(time > 12.1 && time <= 12.3){
					return 20;
				}else if(time > 12.3 && time <= 12.5){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 9 && age > 8){
				//小学四年级男生
				//根据国家体测标准定义分数
				if(time <= 8.7){
					return 100;
				}else if(time > 8.7 && time <= 8.8){
					return 95;
				}else if(time > 8.8 && time <= 8.9){
					return 90;
				}else if(time > 8.9 && time <= 9){
					return 85;
				}else if(time > 9 && time <= 9.1){
					return 80;
				}else if(time > 9.1 && time <= 9.3){
					return 78;
				}else if(time > 9.3 && time <= 9.5){
					return 76;
				}else if(time > 9.5 && time <= 9.7){
					return 74;
				}else if(time > 9.7 && time <= 9.9){
					return 72;
				}else if(time > 9.9 && time <= 10.1){
					return 70;
				}else if(time > 10.1 && time <= 10.3){
					return 68;
				}else if(time > 10.3 && time <= 10.5){
					return 66;
				}else if(time > 10.5 && time <= 10.7){
					return 64;
				}else if(time > 10.7 && time <= 10.9){
					return 62;
				}else if(time > 10.9 && time <= 11.1){
					return 60;
				}else if(time > 11.1 && time <= 11.3){
					return 50;
				}else if(time > 11.3 && time <= 11.5){
					return 40;
				}else if(time > 11.5 && time <= 11.7){
					return 30;
				}else if(time > 11.7 && time <= 11.9){
					return 20;
				}else if(time > 11.9 && time <= 12.1){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 10 && age > 9){
				//小学五年级男生
				//根据国家体测标准定义分数
				if(time <= 8.4){
					return 100;
				}else if(time > 8.4 && time <= 8.5){
					return 95;
				}else if(time > 8.5 && time <= 8.6){
					return 90;
				}else if(time > 8.6 && time <= 8.7){
					return 85;
				}else if(time > 8.7 && time <= 8.8){
					return 80;
				}else if(time > 8.8 && time <= 9){
					return 78;
				}else if(time > 9 && time <= 9.2){
					return 76;
				}else if(time > 9.2 && time <= 9.4){
					return 74;
				}else if(time > 9.4 && time <= 9.6){
					return 72;
				}else if(time > 9.6 && time <= 9.8){
					return 70;
				}else if(time > 9.8 && time <= 10){
					return 68;
				}else if(time > 10 && time <= 10.2){
					return 66;
				}else if(time > 10.2 && time <= 10.4){
					return 64;
				}else if(time > 10.4 && time <= 10.6){
					return 62;
				}else if(time > 10.6 && time <= 10.8){
					return 60;
				}else if(time > 10.8 && time <= 11){
					return 50;
				}else if(time > 11 && time <= 11.2){
					return 40;
				}else if(time > 11.2 && time <= 11.4){
					return 30;
				}else if(time > 11.4 && time <= 11.6){
					return 20;
				}else if(time > 11.6 && time <= 11.8){
					return 10;
				}else{
					return 0;
				}
			}else{
				//小学六年级男生
				//根据国家体测标准定义分数
				if(time <= 8.2){
					return 100;
				}else if(time > 8.2 && time <= 8.3){
					return 95;
				}else if(time > 8.3 && time <= 8.4){
					return 90;
				}else if(time > 8.4 && time <= 8.5){
					return 85;
				}else if(time > 8.5 && time <= 8.6){
					return 80;
				}else if(time > 8.6 && time <= 8.8){
					return 78;
				}else if(time > 8.8 && time <= 9){
					return 76;
				}else if(time > 9 && time <= 9.2){
					return 74;
				}else if(time > 9.2 && time <= 9.4){
					return 72;
				}else if(time > 9.4 && time <= 9.6){
					return 70;
				}else if(time > 9.6 && time <= 9.8){
					return 68;
				}else if(time > 9.8 && time <= 10){
					return 66;
				}else if(time > 10 && time <= 10.2){
					return 64;
				}else if(time > 10.2 && time <= 10.4){
					return 62;
				}else if(time > 10.4 && time <= 10.6){
					return 60;
				}else if(time > 10.6 && time <= 10.8){
					return 50;
				}else if(time > 10.8 && time <= 11){
					return 40;
				}else if(time > 11 && time <= 11.2){
					return 30;
				}else if(time > 11.2 && time <= 11.4){
					return 20;
				}else if(time > 11.4 && time <= 11.6){
					return 10;
				}else{
					return 0;
				}
			}
			
		}else{
			//女生
			if(age <= 6){
				//小学一年级女生
				//根据国家体测标准定义分数
				if(time <= 11){
					return 100;
				}else if(time > 11 && time <= 11.1){
					return 95;
				}else if(time > 11.1 && time <= 11.2){
					return 90;
				}else if(time > 11.2 && time <= 11.5){
					return 85;
				}else if(time > 11.5 && time <= 11.8){
					return 80;
				}else if(time > 11.8 && time <= 12){
					return 78;
				}else if(time > 12 && time <= 12.2){
					return 76;
				}else if(time > 12.2 && time <= 12.4){
					return 74;
				}else if(time > 12.4 && time <= 12.6){
					return 72;
				}else if(time > 12.6 && time <= 12.8){
					return 70;
				}else if(time > 12.8 && time <= 13){
					return 68;
				}else if(time > 13 && time <= 13.2){
					return 66;
				}else if(time > 13.2 && time <= 13.4){
					return 64;
				}else if(time > 13.4 && time <= 13.6){
					return 62;
				}else if(time > 13.6 && time <= 13.8){
					return 60;
				}else if(time > 13.8 && time <= 14){
					return 50;
				}else if(time > 14 && time <= 14.2){
					return 40;
				}else if(time > 14.2 && time <= 14.4){
					return 30;
				}else if(time > 14.4 && time <= 14.6){
					return 20;
				}else if(time > 14.6 && time <= 14.8){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 7 && age > 6){
				//小学二年级女生
				//根据国家体测标准定义分数
				if(time <= 10){
					return 100;
				}else if(time > 10 && time <= 10.1){
					return 95;
				}else if(time > 10.1 && time <= 10.2){
					return 90;
				}else if(time > 10.2 && time <= 10.5){
					return 85;
				}else if(time > 10.5 && time <= 10.8){
					return 80;
				}else if(time > 10.8 && time <= 11){
					return 78;
				}else if(time > 11 && time <= 11.2){
					return 76;
				}else if(time > 11.2 && time <= 11.4){
					return 74;
				}else if(time > 11.4 && time <= 11.6){
					return 72;
				}else if(time > 11.6 && time <= 11.8){
					return 70;
				}else if(time > 11.8 && time <= 12){
					return 68;
				}else if(time > 12 && time <= 12.2){
					return 66;
				}else if(time > 12.2 && time <= 12.4){
					return 64;
				}else if(time > 12.4 && time <= 12.6){
					return 62;
				}else if(time > 12.6 && time <= 12.8){
					return 60;
				}else if(time > 12.8 && time <= 13){
					return 50;
				}else if(time > 13 && time <= 13.2){
					return 40;
				}else if(time > 13.2 && time <= 13.4){
					return 30;
				}else if(time > 13.4 && time <= 13.6){
					return 20;
				}else if(time > 13.6 && time <= 13.8){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 8 && age > 7){
				//小学三年级女生
				//根据国家体测标准定义分数
				if(time <= 9.2){
					return 100;
				}else if(time > 9.2 && time <= 9.3){
					return 95;
				}else if(time > 9.3 && time <= 9.4){
					return 90;
				}else if(time > 9.4 && time <= 9.7){
					return 85;
				}else if(time > 9.7 && time <= 10){
					return 80;
				}else if(time > 10 && time <= 10.2){
					return 78;
				}else if(time > 10.2 && time <= 10.4){
					return 76;
				}else if(time > 10.4 && time <= 10.6){
					return 74;
				}else if(time > 10.6 && time <= 10.8){
					return 72;
				}else if(time > 10.8 && time <= 11){
					return 70;
				}else if(time > 11 && time <= 11.2){
					return 68;
				}else if(time > 11.2 && time <= 11.4){
					return 66;
				}else if(time > 11.4 && time <= 11.6){
					return 64;
				}else if(time > 11.6 && time <= 11.8){
					return 62;
				}else if(time > 11.8 && time <= 12){
					return 60;
				}else if(time > 12 && time <= 12.2){
					return 50;
				}else if(time > 12.2 && time <= 12.4){
					return 40;
				}else if(time > 12.4 && time <= 12.6){
					return 30;
				}else if(time > 12.6 && time <= 12.8){
					return 20;
				}else if(time > 12.8 && time <= 13){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 9 && age > 8){
				//小学四年级女生
				//根据国家体测标准定义分数
				if(time <= 8.7){
					return 100;
				}else if(time > 8.7 && time <= 8.8){
					return 95;
				}else if(time > 8.8 && time <= 8.9){
					return 90;
				}else if(time > 8.9 && time <= 9.2){
					return 85;
				}else if(time > 9.2 && time <= 9.5){
					return 80;
				}else if(time > 9.5 && time <= 9.7){
					return 78;
				}else if(time > 9.7 && time <= 9.9){
					return 76;
				}else if(time > 9.9 && time <= 10.1){
					return 74;
				}else if(time > 10.1 && time <= 10.3){
					return 72;
				}else if(time > 10.3 && time <= 10.5){
					return 70;
				}else if(time > 10.5 && time <= 10.7){
					return 68;
				}else if(time > 10.7 && time <= 10.9){
					return 66;
				}else if(time > 10.9 && time <= 11.1){
					return 64;
				}else if(time > 11.1 && time <= 11.3){
					return 62;
				}else if(time > 11.3 && time <= 11.5){
					return 60;
				}else if(time > 11.5 && time <= 11.7){
					return 50;
				}else if(time > 11.7 && time <= 11.9){
					return 40;
				}else if(time > 11.9 && time <= 12.1){
					return 30;
				}else if(time > 12.1 && time <= 12.3){
					return 20;
				}else if(time > 12.3 && time <= 12.5){
					return 10;
				}else{
					return 0;
				}
			}else if(age <= 10 && age > 9){
				//小学五年级女生
				//根据国家体测标准定义分数
				if(time <= 8.3){
					return 100;
				}else if(time > 8.3 && time <= 8.4){
					return 95;
				}else if(time > 8.4 && time <= 8.5){
					return 90;
				}else if(time > 8.5 && time <= 8.8){
					return 85;
				}else if(time > 8.8 && time <= 9.1){
					return 80;
				}else if(time > 9.1 && time <= 9.3){
					return 78;
				}else if(time > 9.3 && time <= 9.5){
					return 76;
				}else if(time > 9.5 && time <= 9.7){
					return 74;
				}else if(time > 9.7 && time <= 9.9){
					return 72;
				}else if(time > 9.9 && time <= 10.1){
					return 70;
				}else if(time > 10.1 && time <= 10.3){
					return 68;
				}else if(time > 10.3 && time <= 10.5){
					return 66;
				}else if(time > 10.5 && time <= 10.7){
					return 64;
				}else if(time > 10.7 && time <= 10.9){
					return 62;
				}else if(time > 10.9 && time <= 11.1){
					return 60;
				}else if(time > 11.1 && time <= 11.3){
					return 50;
				}else if(time > 11.3 && time <= 11.5){
					return 40;
				}else if(time > 11.5 && time <= 11.7){
					return 30;
				}else if(time > 11.7 && time <= 11.9){
					return 20;
				}else if(time > 11.9 && time <= 12.1){
					return 10;
				}else{
					return 0;
				}
			}else{
				//小学六年级女生
				//根据国家体测标准定义分数
				if(time <= 8.2){
					return 100;
				}else if(time > 8.2 && time <= 8.3){
					return 95;
				}else if(time > 8.3 && time <= 8.4){
					return 90;
				}else if(time > 8.4 && time <= 8.7){
					return 85;
				}else if(time > 8.7 && time <= 9){
					return 80;
				}else if(time > 9 && time <= 9.2){
					return 78;
				}else if(time > 9.2 && time <= 9.4){
					return 76;
				}else if(time > 9.4 && time <= 9.6){
					return 74;
				}else if(time > 9.6 && time <= 9.8){
					return 72;
				}else if(time > 9.8 && time <= 10){
					return 70;
				}else if(time > 10 && time <= 10.2){
					return 68;
				}else if(time > 10.2 && time <= 10.4){
					return 66;
				}else if(time > 10.4 && time <= 10.6){
					return 64;
				}else if(time > 10.6 && time <= 10.8){
					return 62;
				}else if(time > 10.8 && time <= 11){
					return 60;
				}else if(time > 11 && time <= 11.2){
					return 50;
				}else if(time > 11.2 && time <= 11.4){
					return 40;
				}else if(time > 11.4 && time <= 11.6){
					return 30;
				}else if(time > 11.6 && time <= 11.8){
					return 20;
				}else if(time > 11.8 && time <= 12){
					return 10;
				}else{
					return 0;
				}
			}
		}
	}
	
	
	public static int getSitAndReachLevel(String userID){
		
		int grade = PrimaryUtils.getSitAndReachGrade(userID);
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
		
		PrimaryInfoDAO user = new PrimaryInfoDAOImpl();
		Primaryinfo info = new Primaryinfo();
		
		try {
			info = user.queryById(userID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sex = info.getINFO_SEX();
		double cm = Double.parseDouble(info.getSitAndReach());
		double age = Double.parseDouble(info.getAge());
		
		if(sex.equals("M")){
			//男生
			if(age <= 6){
				//一年级男生
				if(cm >= 16.1){
					return 100;
				}else if(cm < 16.1 && cm >= 14.6){
					return 95;
				}else if(cm < 14.6 && cm >= 13){
					return 90;
				}else if(cm < 13 && cm >= 12){
					return 85;
				}else if(cm < 12 && cm >= 11){
					return 80;
				}else if(cm < 11 && cm >= 9.9){
					return 78;
				}else if(cm < 9.9 && cm >= 8.8){
					return 76;
				}else if(cm < 8.8 && cm >= 7.7){
					return 74;
				}else if(cm < 7.7 && cm >= 6.6){
					return 72;
				}else if(cm < 6.6 && cm >= 5.5){
					return 70;
				}else if(cm < 5.5 && cm >= 4.4){
					return 68;
				}else if(cm < 4.4 && cm >= 3.3){
					return 66;
				}else if(cm < 3.3 && cm >= 2.2){
					return 64;
				}else if(cm < 2.2 && cm >= 1.1){
					return 62;
				}else if(cm < 1.1 && cm >= 0){
					return 60;
				}else if(cm < 0 && cm >= -0.8){
					return 50;
				}else if(cm < -0.8 && cm >= -1.6){
					return 40;
				}else if(cm < -1.6 && cm >= -2.4){
					return 30;
				}else if(cm < -2.4 && cm >= -3.2){
					return 20;
				}else if(cm < -3.2 && cm >= -4){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 6 && age <= 7){
				//二年级男生
				if(cm >= 16.2){
					return 100;
				}else if(cm < 16.2 && cm >= 14.7){
					return 95;
				}else if(cm < 14.7 && cm >= 13.2){
					return 90;
				}else if(cm < 13.2 && cm >= 11.9){
					return 85;
				}else if(cm < 11.9 && cm >= 10.6){
					return 80;
				}else if(cm < 10.6 && cm >= 9.5){
					return 78;
				}else if(cm < 9.5 && cm >= 8.4){
					return 76;
				}else if(cm < 8.4 && cm >= 7.3){
					return 74;
				}else if(cm < 7.3 && cm >= 6.2){
					return 72;
				}else if(cm < 6.2 && cm >= 5.1){
					return 70;
				}else if(cm < 5.1 && cm >= 4){
					return 68;
				}else if(cm < 4 && cm >= 2.9){
					return 66;
				}else if(cm < 2.9 && cm >= 1.8){
					return 64;
				}else if(cm < 1.8 && cm >= 0.7){
					return 62;
				}else if(cm < 0.7 && cm >= -0.4){
					return 60;
				}else if(cm < -0.4 && cm >= -1.2){
					return 50;
				}else if(cm < -1.2 && cm >= -2){
					return 40;
				}else if(cm < -2 && cm >= -2.8){
					return 30;
				}else if(cm < -2.8 && cm >= -3.6){
					return 20;
				}else if(cm < -3.6 && cm >= -4.4){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 7 && age <= 8){
				//三年级男生
				if(cm >= 16.3){
					return 100;
				}else if(cm < 16.3 && cm >= 14.9){
					return 95;
				}else if(cm < 14.9 && cm >= 13.4){
					return 90;
				}else if(cm < 13.4 && cm >= 11.8){
					return 85;
				}else if(cm < 11.8 && cm >= 10.2){
					return 80;
				}else if(cm < 10.2 && cm >= 9.1){
					return 78;
				}else if(cm < 9.1 && cm >= 8){
					return 76;
				}else if(cm < 8 && cm >= 6.9){
					return 74;
				}else if(cm < 6.9 && cm >= 5.8){
					return 72;
				}else if(cm < 5.8 && cm >= 4.7){
					return 70;
				}else if(cm < 4.7 && cm >= 3.6){
					return 68;
				}else if(cm < 3.6 && cm >= 2.5){
					return 66;
				}else if(cm < 2.5 && cm >= 1.4){
					return 64;
				}else if(cm < 1.4 && cm >= 0.3){
					return 62;
				}else if(cm < 0.3 && cm >= -0.8){
					return 60;
				}else if(cm < -0.8 && cm >= -1.6){
					return 50;
				}else if(cm < -1.6 && cm >= -2.4){
					return 40;
				}else if(cm < -2.4 && cm >= -3.2){
					return 30;
				}else if(cm < -3.2 && cm >= -4){
					return 20;
				}else if(cm < -4 && cm >= -4.8){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 8 && age <= 9){
				//四年级男生
				if(cm >= 16.4){
					return 100;
				}else if(cm < 16.4 && cm >= 15){
					return 95;
				}else if(cm < 15 && cm >= 13.6){
					return 90;
				}else if(cm < 13.6 && cm >= 11.7){
					return 85;
				}else if(cm < 11.7 && cm >= 9.8){
					return 80;
				}else if(cm < 9.8 && cm >= 8.6){
					return 78;
				}else if(cm < 8.6 && cm >= 7.4){
					return 76;
				}else if(cm < 7.4 && cm >= 6.2){
					return 74;
				}else if(cm < 6.2 && cm >= 5){
					return 72;
				}else if(cm < 5 && cm >= 3.8){
					return 70;
				}else if(cm < 3.8 && cm >= 2.6){
					return 68;
				}else if(cm < 2.6 && cm >= 1.4){
					return 66;
				}else if(cm < 1.4 && cm >= 0.2){
					return 64;
				}else if(cm < 0.2 && cm >= -1){
					return 62;
				}else if(cm < -1 && cm >= -2.2){
					return 60;
				}else if(cm < -2.2 && cm >= -3.2){
					return 50;
				}else if(cm < -3.2 && cm >= -4.2){
					return 40;
				}else if(cm < -4.2 && cm >= -5.2){
					return 30;
				}else if(cm < -5.2 && cm >= -6.2){
					return 20;
				}else if(cm < -6.2 && cm >= -7.2){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 9 && age <= 10){
				//五年级男生
				if(cm >= 16.5){
					return 100;
				}else if(cm < 16.5 && cm >= 15.2){
					return 95;
				}else if(cm < 15.2 && cm >= 13.8){
					return 90;
				}else if(cm < 13.8 && cm >= 11.6){
					return 85;
				}else if(cm < 11.6 && cm >= 9.4){
					return 80;
				}else if(cm < 9.4 && cm >= 8.2){
					return 78;
				}else if(cm < 8.2 && cm >= 7){
					return 76;
				}else if(cm < 7 && cm >= 5.8){
					return 74;
				}else if(cm < 5.8 && cm >= 4.6){
					return 72;
				}else if(cm < 4.6 && cm >= 3.4){
					return 70;
				}else if(cm < 3.4 && cm >= 2.2){
					return 68;
				}else if(cm < 2.2 && cm >= 1){
					return 66;
				}else if(cm < 1 && cm >= -0.2){
					return 64;
				}else if(cm < -0.2 && cm >= -1.4){
					return 62;
				}else if(cm < -1.4 && cm >= -2.6){
					return 60;
				}else if(cm < -2.6 && cm >= -3.6){
					return 50;
				}else if(cm < -3.6 && cm >= -4.6){
					return 40;
				}else if(cm < -4.6 && cm >= -5.6){
					return 30;
				}else if(cm < -5.6 && cm >= -6.6){
					return 20;
				}else if(cm < -6.6 && cm >= -7.6){
					return 10;
				}else{
					return 0;
				}
			}else{
				//六年级男生
				if(cm >= 16.6){
					return 100;
				}else if(cm < 16.6 && cm >= 15.3){
					return 95;
				}else if(cm < 15.3 && cm >= 14){
					return 90;
				}else if(cm < 14 && cm >= 11.5){
					return 85;
				}else if(cm < 11.5 && cm >= 9){
					return 80;
				}else if(cm < 9 && cm >= 7.7){
					return 78;
				}else if(cm < 7.7 && cm >= 6.4){
					return 76;
				}else if(cm < 6.4 && cm >= 5.1){
					return 74;
				}else if(cm < 5.1 && cm >= 3.8){
					return 72;
				}else if(cm < 3.8 && cm >= 2.5){
					return 70;
				}else if(cm < 2.5 && cm >= 1.2){
					return 68;
				}else if(cm < 1.2 && cm >= -0.1){
					return 66;
				}else if(cm < -0.1 && cm >= -1.4){
					return 64;
				}else if(cm < -1.4 && cm >= -2.7){
					return 62;
				}else if(cm < -2.7 && cm >= -4){
					return 60;
				}else if(cm < -4 && cm >= -5){
					return 50;
				}else if(cm < -5 && cm >= -6){
					return 40;
				}else if(cm < -6 && cm >= -7){
					return 30;
				}else if(cm < -7 && cm >= -8){
					return 20;
				}else if(cm < -8 && cm >= -9){
					return 10;
				}else{
					return 0;
				}
			}
		}else{
			//女生
			if(age <= 6){
				//一年级女生
				if(cm >= 18.6){
					return 100;
				}else if(cm < 18.6 && cm >= 17.3){
					return 95;
				}else if(cm < 17.3 && cm >= 16){
					return 90;
				}else if(cm < 16 && cm >= 14.7){
					return 85;
				}else if(cm < 14.7 && cm >= 13.4){
					return 80;
				}else if(cm < 13.4 && cm >= 12.3){
					return 78;
				}else if(cm < 12.3 && cm >= 11.2){
					return 76;
				}else if(cm < 11.2 && cm >= 10.1){
					return 74;
				}else if(cm < 10.1 && cm >= 9){
					return 72;
				}else if(cm < 9 && cm >= 7.9){
					return 70;
				}else if(cm < 7.9 && cm >= 6.8){
					return 68;
				}else if(cm < 6.8 && cm >= 5.7){
					return 66;
				}else if(cm < 5.7 && cm >= 4.6){
					return 64;
				}else if(cm < 4.6 && cm >= 3.5){
					return 62;
				}else if(cm < 3.5 && cm >= 2.4){
					return 60;
				}else if(cm < 2.4 && cm >= 1.6){
					return 50;
				}else if(cm < 1.6 && cm >= 0.8){
					return 40;
				}else if(cm < 0.8 && cm >= 0){
					return 30;
				}else if(cm < 0 && cm >= -0.8){
					return 20;
				}else if(cm < -0.8 && cm >= -1.6){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 6 && age <= 7){
				//二年级女生
				if(cm >= 18.9){
					return 100;
				}else if(cm < 18.9 && cm >= 17.6){
					return 95;
				}else if(cm < 17.6 && cm >= 16.3){
					return 90;
				}else if(cm < 16.3 && cm >= 14.8){
					return 85;
				}else if(cm < 14.8 && cm >= 13.3){
					return 80;
				}else if(cm < 13.3 && cm >= 12.2){
					return 78;
				}else if(cm < 12.2 && cm >= 11.1){
					return 76;
				}else if(cm < 11.1 && cm >= 10){
					return 74;
				}else if(cm < 10 && cm >= 8.9){
					return 72;
				}else if(cm < 8.9 && cm >= 7.8){
					return 70;
				}else if(cm < 7.8 && cm >= 6.7){
					return 68;
				}else if(cm < 6.7 && cm >= 5.6){
					return 66;
				}else if(cm < 5.6 && cm >= 4.5){
					return 64;
				}else if(cm < 4.5 && cm >= 3.4){
					return 62;
				}else if(cm < 3.4 && cm >= 2.3){
					return 60;
				}else if(cm < 2.3 && cm >= 1.5){
					return 50;
				}else if(cm < 1.5 && cm >= 0.7){
					return 40;
				}else if(cm < 0.7 && cm >= -0.1){
					return 30;
				}else if(cm < -0.1 && cm >= -0.9){
					return 20;
				}else if(cm < -0.9 && cm >= -1.7){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 7 && age <= 8){
				//三年级女生
				if(cm >= 19.2){
					return 100;
				}else if(cm < 19.2 && cm >= 17.9){
					return 95;
				}else if(cm < 17.9 && cm >= 16.6){
					return 90;
				}else if(cm < 16.6 && cm >= 14.9){
					return 85;
				}else if(cm < 14.9 && cm >= 13.2){
					return 80;
				}else if(cm < 13.2 && cm >= 12.1){
					return 78;
				}else if(cm < 12.1 && cm >= 11){
					return 76;
				}else if(cm < 11 && cm >= 9.9){
					return 74;
				}else if(cm < 9.9 && cm >= 8.8){
					return 72;
				}else if(cm < 8.8 && cm >= 7.7){
					return 70;
				}else if(cm < 7.7 && cm >= 6.6){
					return 68;
				}else if(cm < 6.6 && cm >= 5.5){
					return 66;
				}else if(cm < 5.5 && cm >= 4.4){
					return 64;
				}else if(cm < 4.4 && cm >= 3.3){
					return 62;
				}else if(cm < 3.3 && cm >= 2.2){
					return 60;
				}else if(cm < 2.2 && cm >= 1.4){
					return 50;
				}else if(cm < 1.4 && cm >= 0.6){
					return 40;
				}else if(cm < 0.6 && cm >= -0.2){
					return 30;
				}else if(cm < -0.2 && cm >= -1){
					return 20;
				}else if(cm < -1 && cm >= -1.8){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 8 && age <= 9){
				//四年级女生
				if(cm >= 19.5){
					return 100;
				}else if(cm < 19.5 && cm >= 18.1){
					return 95;
				}else if(cm < 18.1 && cm >= 16.9){
					return 90;
				}else if(cm < 16.9 && cm >= 15){
					return 85;
				}else if(cm < 15 && cm >= 13.1){
					return 80;
				}else if(cm < 13.1 && cm >= 12){
					return 78;
				}else if(cm < 12 && cm >= 10.9){
					return 76;
				}else if(cm < 10.9 && cm >= 9.8){
					return 74;
				}else if(cm < 9.8 && cm >= 8.7){
					return 72;
				}else if(cm < 8.7 && cm >= 7.6){
					return 70;
				}else if(cm < 7.6 && cm >= 6.5){
					return 68;
				}else if(cm < 6.5 && cm >= 5.4){
					return 66;
				}else if(cm < 5.4 && cm >= 4.3){
					return 64;
				}else if(cm < 4.3 && cm >= 3.2){
					return 62;
				}else if(cm < 3.2 && cm >= 2.1){
					return 60;
				}else if(cm < 2.1 && cm >= 1.3){
					return 50;
				}else if(cm < 1.3 && cm >= 0.5){
					return 40;
				}else if(cm < 0.5 && cm >= -0.3){
					return 30;
				}else if(cm < -0.3 && cm >= -1.1){
					return 20;
				}else if(cm < -1.1 && cm >= -1.9){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 9 && age <= 10){
				//五年级女生
				if(cm >= 19.8){
					return 100;
				}else if(cm < 19.8 && cm >= 18.5){
					return 95;
				}else if(cm < 18.5 && cm >= 17.2){
					return 90;
				}else if(cm < 17.2 && cm >= 15.1){
					return 85;
				}else if(cm < 15.1 && cm >= 13){
					return 80;
				}else if(cm < 13 && cm >= 11.9){
					return 78;
				}else if(cm < 11.9 && cm >= 10.8){
					return 76;
				}else if(cm < 10.8 && cm >= 9.7){
					return 74;
				}else if(cm < 9.7 && cm >= 8.6){
					return 72;
				}else if(cm < 8.6 && cm >= 7.5){
					return 70;
				}else if(cm < 7.5 && cm >= 6.4){
					return 68;
				}else if(cm < 6.4 && cm >= 5.3){
					return 66;
				}else if(cm < 5.3 && cm >= 4.2){
					return 64;
				}else if(cm < 4.2 && cm >= 3.1){
					return 62;
				}else if(cm < 3.1 && cm >= 2){
					return 60;
				}else if(cm < 2 && cm >= 1.2){
					return 50;
				}else if(cm < 1.2 && cm >= 0.4){
					return 40;
				}else if(cm < 0.4 && cm >= -0.4){
					return 30;
				}else if(cm < -0.4 && cm >= -1.2){
					return 20;
				}else if(cm < -1.2 && cm >= -2){
					return 10;
				}else{
					return 0;
				}
			}else{
				//六年级女生
				if(cm >= 19.9){
					return 100;
				}else if(cm < 19.9 && cm >= 18.7){
					return 95;
				}else if(cm < 18.7 && cm >= 17.5){
					return 90;
				}else if(cm < 17.5 && cm >= 15.2){
					return 85;
				}else if(cm < 15.2 && cm >= 12.9){
					return 80;
				}else if(cm < 12.9 && cm >= 11.8){
					return 78;
				}else if(cm < 11.8 && cm >= 10.7){
					return 76;
				}else if(cm < 10.7 && cm >= 9.6){
					return 74;
				}else if(cm < 9.6 && cm >= 8.5){
					return 72;
				}else if(cm < 8.5 && cm >= 7.4){
					return 70;
				}else if(cm < 7.4 && cm >= 6.3){
					return 68;
				}else if(cm < 6.3 && cm >= 5.2){
					return 66;
				}else if(cm < 5.2 && cm >= 4.1){
					return 64;
				}else if(cm < 4.1 && cm >= 3){
					return 62;
				}else if(cm < 3 && cm >= 1.9){
					return 60;
				}else if(cm < 1.9 && cm >= 1.1){
					return 50;
				}else if(cm < 1.1 && cm >= 0.3){
					return 40;
				}else if(cm < 0.3 && cm >= -0.5){
					return 30;
				}else if(cm < -0.5 && cm >= -1.3){
					return 20;
				}else if(cm < -1.3 && cm >= -2.1){
					return 10;
				}else{
					return 0;
				}
			}
		}
	}
	
	public static int getSkipRopeLevel(String userID){
		
		int grade = PrimaryUtils.getSkipRopeGrade(userID);
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
	
	public static int getSkipRopeGrade(String userID){
		
		PrimaryInfoDAO user = new PrimaryInfoDAOImpl();
		Primaryinfo info = new Primaryinfo();
		
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
			if(age <= 6){
				//一年级男生
				if(number >= 109){
					return 100;
				}else if(number < 109 && number >= 104){
					return 95;
				}else if(number < 104 && number >= 99){
					return 90;
				}else if(number < 99 && number >= 93){
					return 85;
				}else if(number < 93 && number >= 87){
					return 80;
				}else if(number < 87 && number >= 80){
					return 78;
				}else if(number < 80 && number >= 73){
					return 76;
				}else if(number < 73 && number >= 66){
					return 74;
				}else if(number < 66 && number >= 59){
					return 72;
				}else if(number < 59 && number >= 52){
					return 70;
				}else if(number < 52 && number >= 45){
					return 68;
				}else if(number < 45 && number >= 38){
					return 66;
				}else if(number < 38 && number >= 31){
					return 64;
				}else if(number < 31 && number >= 24){
					return 62;
				}else if(number < 24 && number >= 17){
					return 60;
				}else if(number < 17 && number >= 14){
					return 50;
				}else if(number < 14 && number >= 11){
					return 40;
				}else if(number < 11 && number >= 8){
					return 30;
				}else if(number < 8 && number >= 5){
					return 20;
				}else if(number < 5 && number >= 2){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 6 && age <= 7){
				//二年级男生
				if(number >= 117){
					return 100;
				}else if(number < 117 && number >= 112){
					return 95;
				}else if(number < 112 && number >= 107){
					return 90;
				}else if(number < 107 && number >= 101){
					return 85;
				}else if(number < 101 && number >= 95){
					return 80;
				}else if(number < 95 && number >= 88){
					return 78;
				}else if(number < 88 && number >= 81){
					return 76;
				}else if(number < 81 && number >= 74){
					return 74;
				}else if(number < 74 && number >= 67){
					return 72;
				}else if(number < 67 && number >= 60){
					return 70;
				}else if(number < 60 && number >= 53){
					return 68;
				}else if(number < 53 && number >= 46){
					return 66;
				}else if(number < 46 && number >= 39){
					return 64;
				}else if(number < 39 && number >= 32){
					return 62;
				}else if(number < 32 && number >= 25){
					return 60;
				}else if(number < 25 && number >= 22){
					return 50;
				}else if(number < 22 && number >= 19){
					return 40;
				}else if(number < 19 && number >= 16){
					return 30;
				}else if(number < 16 && number >= 13){
					return 20;
				}else if(number < 13 && number >= 10){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 7 && age <= 8){
				//三年级男生
				if(number >= 126){
					return 100;
				}else if(number < 126 && number >= 121){
					return 95;
				}else if(number < 121 && number >= 116){
					return 90;
				}else if(number < 116 && number >= 110){
					return 85;
				}else if(number < 110 && number >= 104){
					return 80;
				}else if(number < 104 && number >= 97){
					return 78;
				}else if(number < 97 && number >= 90){
					return 76;
				}else if(number < 90 && number >= 83){
					return 74;
				}else if(number < 83 && number >= 76){
					return 72;
				}else if(number < 76  && number >= 69){
					return 70;
				}else if(number < 69 && number >= 62){
					return 68;
				}else if(number < 62 && number >= 55){
					return 66;
				}else if(number < 55 && number >= 48){
					return 64;
				}else if(number < 48 && number >= 41){
					return 62;
				}else if(number < 41 && number >= 34){
					return 60;
				}else if(number < 34 && number >= 31){
					return 50;
				}else if(number < 31 && number >= 104){
					return 40;
				}else if(number < 28 && number >= 28){
					return 30;
				}else if(number < 25 && number >= 25){
					return 20;
				}else if(number < 22 && number >= 19){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 8 && age <= 9){
				//四年级男生
				if(number >= 137){
					return 100;
				}else if(number < 137 && number >= 132){
					return 95;
				}else if(number < 132 && number >= 127){
					return 90;
				}else if(number < 127 && number >= 121){
					return 85;
				}else if(number < 121 && number >= 115){
					return 80;
				}else if(number < 115 && number >= 108){
					return 78;
				}else if(number < 108 && number >= 101){
					return 76;
				}else if(number < 101 && number >= 94){
					return 74;
				}else if(number < 94 && number >= 87){
					return 72;
				}else if(number < 87 && number >= 80){
					return 70;
				}else if(number < 80 && number >= 73){
					return 68;
				}else if(number < 73 && number >= 66){
					return 66;
				}else if(number < 66 && number >= 59){
					return 64;
				}else if(number < 59 && number >= 52){
					return 62;
				}else if(number < 52 && number >= 45){
					return 60;
				}else if(number < 45 && number >= 42){
					return 50;
				}else if(number < 42 && number >= 39){
					return 40;
				}else if(number < 39 && number >= 36){
					return 30;
				}else if(number < 36 && number >= 33){
					return 20;
				}else if(number < 33 && number >= 30){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 9 && age <= 10){
				//五年级男生
				if(number >= 148){
					return 100;
				}else if(number < 148 && number >= 143){
					return 95;
				}else if(number < 143 && number >= 138){
					return 90;
				}else if(number < 138 && number >= 132){
					return 85;
				}else if(number < 132 && number >= 126){
					return 80;
				}else if(number < 126 && number >= 119){
					return 78;
				}else if(number < 119 && number >= 112){
					return 76;
				}else if(number < 112 && number >= 105){
					return 74;
				}else if(number < 105 && number >= 98){
					return 72;
				}else if(number < 98 && number >= 91){
					return 70;
				}else if(number < 91 && number >= 84){
					return 68;
				}else if(number < 84 && number >= 77){
					return 66;
				}else if(number < 77 && number >= 70){
					return 64;
				}else if(number < 70 && number >= 63){
					return 62;
				}else if(number < 63 && number >= 56){
					return 60;
				}else if(number < 56 && number >= 53){
					return 50;
				}else if(number < 53 && number >= 50){
					return 40;
				}else if(number < 50 && number >= 47){
					return 30;
				}else if(number < 47 && number >= 44){
					return 20;
				}else if(number < 44 && number >= 41){
					return 10;
				}else{
					return 0;
				}
			}else{
				//六年级男生
				if(number >= 157){
					return 100;
				}else if(number < 157 && number >= 152){
					return 95;
				}else if(number < 152 && number >= 147){
					return 90;
				}else if(number < 147 && number >= 141){
					return 85;
				}else if(number < 141 && number >= 135){
					return 80;
				}else if(number < 135 && number >= 128){
					return 78;
				}else if(number < 128 && number >= 121){
					return 76;
				}else if(number < 121 && number >= 114){
					return 74;
				}else if(number < 114 && number >= 107){
					return 72;
				}else if(number < 107 && number >= 100){
					return 70;
				}else if(number < 100 && number >= 93){
					return 68;
				}else if(number < 93 && number >= 86){
					return 66;
				}else if(number < 86 && number >= 79){
					return 64;
				}else if(number < 79 && number >= 72){
					return 62;
				}else if(number < 72 && number >= 65){
					return 60;
				}else if(number < 65 && number >= 62){
					return 50;
				}else if(number < 62 && number >= 59){
					return 40;
				}else if(number < 59 && number >= 56){
					return 30;
				}else if(number < 56 && number >= 53){
					return 20;
				}else if(number < 53 && number >= 50){
					return 10;
				}else{
					return 0;
				}
			}
		}else{
			//女生
			if(age <= 6){
				//一年级女生
				if(number >= 117){
					return 100;
				}else if(number < 117 && number >= 110){
					return 95;
				}else if(number < 110 && number >= 103){
					return 90;
				}else if(number < 103 && number >= 95){
					return 85;
				}else if(number < 95 && number >= 87){
					return 80;
				}else if(number < 87 && number >= 80){
					return 78;
				}else if(number < 80 && number >= 73){
					return 76;
				}else if(number < 73 && number >= 66){
					return 74;
				}else if(number < 66 && number >= 59){
					return 72;
				}else if(number < 59 && number >= 52){
					return 70;
				}else if(number < 52 && number >= 45){
					return 68;
				}else if(number < 45 && number >= 38){
					return 66;
				}else if(number < 38 && number >= 31){
					return 64;
				}else if(number < 31 && number >= 24){
					return 62;
				}else if(number < 24 && number >= 17){
					return 60;
				}else if(number < 17 && number >= 14){
					return 50;
				}else if(number < 14 && number >= 11){
					return 40;
				}else if(number < 11 && number >= 8){
					return 30;
				}else if(number < 8 && number >= 5){
					return 20;
				}else if(number < 5 && number >= 2){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 6 && age <= 7){
				//二年级女生
				if(number >= 127){
					return 100;
				}else if(number < 127 && number >= 120){
					return 95;
				}else if(number < 120 && number >= 113){
					return 90;
				}else if(number < 113 && number >= 105){
					return 85;
				}else if(number < 105 && number >= 97){
					return 80;
				}else if(number < 97 && number >= 90){
					return 78;
				}else if(number < 90 && number >= 83){
					return 76;
				}else if(number < 83 && number >= 76){
					return 74;
				}else if(number < 76 && number >= 69){
					return 72;
				}else if(number < 69 && number >= 62){
					return 70;
				}else if(number < 62 && number >= 55){
					return 68;
				}else if(number < 55 && number >= 48){
					return 66;
				}else if(number < 48 && number >= 41){
					return 64;
				}else if(number < 41 && number >= 34){
					return 62;
				}else if(number < 34 && number >= 27){
					return 60;
				}else if(number < 27 && number >= 24){
					return 50;
				}else if(number < 24 && number >= 21){
					return 40;
				}else if(number < 21 && number >= 18){
					return 30;
				}else if(number < 18 && number >= 15){
					return 20;
				}else if(number < 15 && number >= 12){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 7 && age <= 8){
				//三年级女生
				if(number >= 139){
					return 100;
				}else if(number < 139 && number >= 132){
					return 95;
				}else if(number < 132 && number >= 125){
					return 90;
				}else if(number < 125 && number >= 117){
					return 85;
				}else if(number < 117 && number >= 109){
					return 80;
				}else if(number < 109 && number >= 102){
					return 78;
				}else if(number < 102 && number >= 95){
					return 76;
				}else if(number < 95 && number >= 88){
					return 74;
				}else if(number < 88 && number >= 81){
					return 72;
				}else if(number < 81  && number >= 74){
					return 70;
				}else if(number < 74 && number >= 67){
					return 68;
				}else if(number < 67 && number >= 60){
					return 66;
				}else if(number < 60 && number >= 53){
					return 64;
				}else if(number < 53 && number >= 46){
					return 62;
				}else if(number < 46 && number >= 39){
					return 60;
				}else if(number < 39 && number >= 36){
					return 50;
				}else if(number < 36 && number >= 33){
					return 40;
				}else if(number < 33 && number >= 30){
					return 30;
				}else if(number < 30 && number >= 27){
					return 20;
				}else if(number < 27 && number >= 24){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 8 && age <= 9){
				//四年级女生
				if(number >= 149){
					return 100;
				}else if(number < 149 && number >= 142){
					return 95;
				}else if(number < 142 && number >= 135){
					return 90;
				}else if(number < 135 && number >= 127){
					return 85;
				}else if(number < 127 && number >= 119){
					return 80;
				}else if(number < 119 && number >= 112){
					return 78;
				}else if(number < 112 && number >= 105){
					return 76;
				}else if(number < 105 && number >= 98){
					return 74;
				}else if(number < 98 && number >= 91){
					return 72;
				}else if(number < 91 && number >= 84){
					return 70;
				}else if(number < 84 && number >= 77){
					return 68;
				}else if(number < 77 && number >= 70){
					return 66;
				}else if(number < 70 && number >= 63){
					return 64;
				}else if(number < 63 && number >= 56){
					return 62;
				}else if(number < 56 && number >= 49){
					return 60;
				}else if(number < 49 && number >= 46){
					return 50;
				}else if(number < 46 && number >= 43){
					return 40;
				}else if(number < 43 && number >= 40){
					return 30;
				}else if(number < 40 && number >= 37){
					return 20;
				}else if(number < 37 && number >= 34){
					return 10;
				}else{
					return 0;
				}
			}else if(age > 9 && age <= 10){
				//五年级女生
				if(number >= 158){
					return 100;
				}else if(number < 158 && number >= 151){
					return 95;
				}else if(number < 151 && number >= 144){
					return 90;
				}else if(number < 144 && number >= 136){
					return 85;
				}else if(number < 136 && number >= 128){
					return 80;
				}else if(number < 128 && number >= 121){
					return 78;
				}else if(number < 121 && number >= 114){
					return 76;
				}else if(number < 114 && number >= 107){
					return 74;
				}else if(number < 107 && number >= 100){
					return 72;
				}else if(number < 100 && number >= 93){
					return 70;
				}else if(number < 93 && number >= 86){
					return 68;
				}else if(number < 86 && number >= 79){
					return 66;
				}else if(number < 79 && number >= 72){
					return 64;
				}else if(number < 72 && number >= 65){
					return 62;
				}else if(number < 65 && number >= 58){
					return 60;
				}else if(number < 58 && number >= 55){
					return 50;
				}else if(number < 55 && number >= 52){
					return 40;
				}else if(number < 52 && number >= 49){
					return 30;
				}else if(number < 49 && number >= 46){
					return 20;
				}else if(number < 46 && number >= 43){
					return 10;
				}else{
					return 0;
				}
			}else{
				//六年级女生
				if(number >= 166){
					return 100;
				}else if(number < 166 && number >= 159){
					return 95;
				}else if(number < 159 && number >= 152){
					return 90;
				}else if(number < 152 && number >= 144){
					return 85;
				}else if(number < 144 && number >= 136){
					return 80;
				}else if(number < 136 && number >= 129){
					return 78;
				}else if(number < 129 && number >= 122){
					return 76;
				}else if(number < 122 && number >= 115){
					return 74;
				}else if(number < 115 && number >= 108){
					return 72;
				}else if(number < 108 && number >= 101){
					return 70;
				}else if(number < 101 && number >= 94){
					return 68;
				}else if(number < 94 && number >= 87){
					return 66;
				}else if(number < 87 && number >= 80){
					return 64;
				}else if(number < 80 && number >= 73){
					return 62;
				}else if(number < 73 && number >= 66){
					return 60;
				}else if(number < 66 && number >= 63){
					return 50;
				}else if(number < 63 && number >= 30){
					return 40;
				}else if(number < 60 && number >= 57){
					return 30;
				}else if(number < 57 && number >= 54){
					return 20;
				}else if(number < 54 && number >= 51){
					return 10;
				}else{
					return 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		int i = PrimaryUtils.getSkipRopeGrade("无常_");
		System.out.println(i);
	}
	
}
