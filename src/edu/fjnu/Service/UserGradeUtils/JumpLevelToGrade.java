package edu.fjnu.Service.UserGradeUtils;

import java.sql.SQLException;

import edu.fjnu.DAO.InfoDAO;
import edu.fjnu.DAOImpl.InfoDAOImpl;
import edu.fjnu.Entity.Infos.Info;

public class JumpLevelToGrade {

	public static int getGrade(String ID){
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
				return 100;			//100分
			}else if(distance < 273 && distance >= 268){
				return 95;			//95-100分
			}else if(distance < 268 && distance >= 263){
				return 90;			//90-95分				//优秀
			}else if(distance < 263 && distance >= 256){
				return 85;			//85-90分
			}else if(distance < 256 && distance >= 248){
				return 80;			//80-85分				//良好
			}else if(distance < 248 && distance >= 244){
				return 78;			//78-80分
			}else if(distance < 244 && distance >= 240){
				return 76;			//76-78分
			}else if(distance < 240 && distance >= 236){
				return 74;			//74-76分
			}else if(distance < 236 && distance >= 232){
				return 72;			//72-74分
			}else if(distance < 232 && distance >= 228){
				return 70;			//70-72分
			}else if(distance < 228 && distance >= 224){
				return 68;			//68-70分
			}else if(distance < 224 && distance >= 220){
				return 66;			//66-68分
			}else if(distance < 220 && distance >= 216){
				return 64;			//64-66分
			}else if(distance < 216 && distance >= 212){
				return 62;			//62-64分
			}else if(distance < 212 && distance >= 208){
				return 60;			//60-62分				//及格
			}else if(distance < 208 && distance >= 203){
				return 50;			//50-60分
			}else if(distance < 203 && distance >= 198){
				return 40;			//40-50分
			}else if(distance < 198 && distance >= 193){
				return 30;			//30-40分
			}else if(distance < 193 && distance >= 198){
				return 20;			//20-30分
			}else if(distance < 188 && distance >= 193){
				return 10;			//10-20分
			}else{
				return 0;			//0-10分					//不及格
			}
		}else{
			//F是女生
			if(distance >= 207){
				return 100;			//100分
			}else if(distance < 207 && distance >= 201){
				return 95;			//95-100分
			}else if(distance < 201 && distance >= 195){
				return 90;			//90-95分				//优秀
			}else if(distance < 195 && distance >= 188){
				return 85;			//85-90分
			}else if(distance < 188 && distance >= 181){
				return 80;			//80-85分				//良好
			}else if(distance < 181 && distance >= 178){
				return 78;			//78-80分
			}else if(distance < 178 && distance >= 175){
				return 76;			//76-78分
			}else if(distance < 175 && distance >= 172){
				return 74;			//74-76分
			}else if(distance < 172 && distance >= 169){
				return 72;			//72-74分
			}else if(distance < 169 && distance >= 166){
				return 70;			//70-72分
			}else if(distance < 166 && distance >= 163){
				return 68;			//68-70分
			}else if(distance < 163 && distance >= 160){
				return 66;			//66-68分
			}else if(distance < 160 && distance >= 157){
				return 64;			//64-66分
			}else if(distance < 157 && distance >= 154){
				return 62;			//62-64分
			}else if(distance < 154 && distance >= 151){
				return 60;			//60-62分				//及格
			}else if(distance < 151 && distance >= 146){
				return 50;			//50-60分
			}else if(distance < 146 && distance >= 141){
				return 40;			//40-50分
			}else if(distance < 141 && distance >= 136){
				return 30;			//30-40分
			}else if(distance < 136 && distance >= 131){
				return 20;			//20-30分
			}else if(distance < 131 && distance >= 126){
				return 10;			//10-20分
			}else{
				return 0;			//0-10分					//不及格
			}
		}
	}
	
}
