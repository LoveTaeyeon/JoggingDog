package edu.fjnu.Service.Translater;

import edu.fjnu.Service.UserGradeUtils.GetBMIGrade;
import edu.fjnu.Service.UserGradeUtils.GetJumpGrade;
import edu.fjnu.Service.UserGradeUtils.GetLongRunGrade;
import edu.fjnu.Service.UserGradeUtils.GetPullUpGrade;
import edu.fjnu.Service.UserGradeUtils.GetShortRunGrade;

public class Translater {

	public String translateJump(String userID){
		//把立定跳远成绩等级翻译成可以使用的大等级
		int level = 0;
		level = GetJumpGrade.getLevel(userID);
		if(level <=3){
			return "优秀";
		}else if(level > 3 && level <= 5){
			return "良好";
		}else if(level > 5 && level <= 15){
			return "及格";
		}else{
			return "不及格";
		}	
	}
	
	public String translateLongrun(String userID){
		//把长跑成绩等级翻译成可以使用的大等级
		int level;
		level = GetLongRunGrade.getLevel(userID);
		if(level <=3){
			return "优秀";
		}else if(level > 3 && level <= 5){
			return "良好";
		}else if(level > 5 && level <= 15){
			return "及格";
		}else{
			return "不及格";
		}		
	}
	
	public String translatePullup(String userID){
		//把引体向上（仰卧起坐）成绩等级翻译成可以使用的大等级
		int level;
		level = GetPullUpGrade.getLevel(userID);
		if(level <=3){
			return "优秀";
		}else if(level > 3 && level <= 5){
			return "良好";
		}else if(level > 5 && level <= 10){
			return "及格";
		}else{
			return "不及格";
		}		
	}
	
	public String translateShortrun(String userID){
		//把短跑成绩等级翻译成可以使用的大等级
		int level;
		level = GetShortRunGrade.getLevel(userID);
		if(level <=3){
			return "优秀";
		}else if(level > 3 && level <= 5){
			return "良好";
		}else if(level > 5 && level <= 15){
			return "及格";
		}else{
			return "不及格";
		}		
	}
	
	public String translateBMI(String userID){
		//把短跑成绩等级翻译成可以使用的大等级
		int level;
		level = GetBMIGrade.getLevel(userID);
		if(level == 1){
			return "正常";
		}else if(level == 2){
			return "偏瘦";
		}else if(level == 3){
			return "超重";
		}else{
			return "肥胖";
		}		
	}
	
	public static void main(String[] args) {
		
	}
	
}
