package edu.fjnu.Service.UserGradeUtils;

import java.sql.SQLException;

import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.Entity.Infos.Info;

public class GraduateUtils {

	public static int getBMIGrade(String ID){
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
	
	public static int getBMILevel(String ID){
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
			return 1;			//属于正常状态
		}else if(BMI < 17.9){
			return 2;			//体重指数偏低，偏瘦状态
		}else if(BMI >23.9 && BMI <= 27.9){
			return 3;			//体重指数偏高，超重状态
		}else{
			return 4;			//体重指数过高，肥胖状态
		}
	}
	
	public static int getJumpLevel(String ID){
		InfoDAO inf = new InfoDAOImpl();
		Info f = new Info();
		try {
			f = inf.queryById(ID);				//得到该用户的信息
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int distance = Integer.parseInt(f.getJump());		//得到跳远的距离
		if(f.getInfo_Sex().equals("M")){					//男女分数评判机制不同，做不同处理		
			//M是男生
			if(distance >= 273){
				return 1;			//100分
			}else if(distance < 273 && distance >= 268){
				return 2;			//95-100分
			}else if(distance < 268 && distance >= 263){
				return 3;			//90-95分				//优秀
			}else if(distance < 263 && distance >= 256){
				return 4;			//85-90分
			}else if(distance < 256 && distance >= 248){
				return 5;			//80-85分				//良好
			}else if(distance < 248 && distance >= 244){
				return 6;			//78-80分
			}else if(distance < 244 && distance >= 240){
				return 7;			//76-78分
			}else if(distance < 240 && distance >= 236){
				return 8;			//74-76分
			}else if(distance < 236 && distance >= 232){
				return 9;			//72-74分
			}else if(distance < 232 && distance >= 228){
				return 10;			//70-72分
			}else if(distance < 228 && distance >= 224){
				return 11;			//68-70分
			}else if(distance < 224 && distance >= 220){
				return 12;			//66-68分
			}else if(distance < 220 && distance >= 216){
				return 13;			//64-66分
			}else if(distance < 216 && distance >= 212){
				return 14;			//62-64分
			}else if(distance < 212 && distance >= 208){
				return 15;			//60-62分				//及格
			}else if(distance < 208 && distance >= 203){
				return 16;			//50-60分
			}else if(distance < 203 && distance >= 198){
				return 17;			//40-50分
			}else if(distance < 198 && distance >= 193){
				return 18;			//30-40分
			}else if(distance < 193 && distance >= 198){
				return 19;			//20-30分
			}else if(distance < 188 && distance >= 193){
				return 20;			//10-20分
			}else{
				return 21;			//0-10分					//不及格
			}
		}else{
			//F是女生
			if(distance >= 207){
				return 1;			//100分
			}else if(distance < 207 && distance >= 201){
				return 2;			//95-100分
			}else if(distance < 201 && distance >= 195){
				return 3;			//90-95分				//优秀
			}else if(distance < 195 && distance >= 188){
				return 4;			//85-90分
			}else if(distance < 188 && distance >= 181){
				return 5;			//80-85分				//良好
			}else if(distance < 181 && distance >= 178){
				return 6;			//78-80分
			}else if(distance < 178 && distance >= 175){
				return 7;			//76-78分
			}else if(distance < 175 && distance >= 172){
				return 8;			//74-76分
			}else if(distance < 172 && distance >= 169){
				return 9;			//72-74分
			}else if(distance < 169 && distance >= 166){
				return 10;			//70-72分
			}else if(distance < 166 && distance >= 163){
				return 11;			//68-70分
			}else if(distance < 163 && distance >= 160){
				return 12;			//66-68分
			}else if(distance < 160 && distance >= 157){
				return 13;			//64-66分
			}else if(distance < 157 && distance >= 154){
				return 14;			//62-64分
			}else if(distance < 154 && distance >= 151){
				return 15;			//60-62分				//及格
			}else if(distance < 151 && distance >= 146){
				return 16;			//50-60分
			}else if(distance < 146 && distance >= 141){
				return 17;			//40-50分
			}else if(distance < 141 && distance >= 136){
				return 18;			//30-40分
			}else if(distance < 136 && distance >= 131){
				return 19;			//20-30分
			}else if(distance < 131 && distance >= 126){
				return 20;			//10-20分
			}else{
				return 21;			//0-10分					//不及格
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		
	}
	
}
