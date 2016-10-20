package edu.fjnu.Service.Translater;

import edu.fjnu.Service.UserGradeUtils.MiddleUtils;

public class MiddleTranslate {

	public String translateBenchTest(String userID){
		//把立定跳远成绩等级翻译成可以使用的大等级
		int level = 0;
		level = MiddleUtils.getBenchTestGrade(userID);
		if(level == 1){
			return "优秀";
		}else if(level == 2){
			return "良好";
		}else if(level == 3){
			return "及格";
		}else{
			return "不及格";
		}	
	}
	
	public String translateSitAndReach(String userID){
		//把长跑成绩等级翻译成可以使用的大等级
		int level;
		level = MiddleUtils.getSitAndReachLevel(userID);
		if(level == 1){
			return "优秀";
		}else if(level == 2){
			return "良好";
		}else if(level == 3){
			return "及格";
		}else{
			return "不及格";
		}		
	}
	
	public String translateSkipRope(String userID){
		//把引体向上（仰卧起坐）成绩等级翻译成可以使用的大等级
		int level;
		level = MiddleUtils.getSkipRopeLevel(userID);
		if(level == 1){
			return "优秀";
		}else if(level == 2){
			return "良好";
		}else if(level == 3){
			return "及格";
		}else{
			return "不及格";
		}		
	}
	
	public String translatePullUp(String userID){
		//把短跑成绩等级翻译成可以使用的大等级
		int level;
		level = MiddleUtils.getPullUpLevel(userID);
		if(level == 1){
			return "优秀";
		}else if(level == 2){
			return "良好";
		}else if(level == 3){
			return "及格";
		}else{
			return "不及格";
		}		
	}
	
	public String translateBMI(String userID){
		//把短跑成绩等级翻译成可以使用的大等级
		int level;
		level = MiddleUtils.getBMILevel(userID);
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
	
}
