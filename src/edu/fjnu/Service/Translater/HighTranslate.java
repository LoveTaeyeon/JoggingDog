package edu.fjnu.Service.Translater;

import edu.fjnu.Service.UserGradeUtils.HighUtils;

public class HighTranslate {

	public String translateBenchTest(String userID){
		//把立定跳远成绩等级翻译成可以使用的大等级
		int level = 0;
		level = HighUtils.getBenchTestGrade(userID);
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
		level = HighUtils.getSitAndReachLevel(userID);
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
	
	public String translateThrowBall(String userID){
		//把引体向上（仰卧起坐）成绩等级翻译成可以使用的大等级
		int level;
		level = HighUtils.getThrowBallLevel(userID);
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
	
	public String translateLongRun(String userID){
		//把短跑成绩等级翻译成可以使用的大等级
		int level;
		level = HighUtils.getLongRunLevel(userID);
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
		level = HighUtils.getBMILevel(userID);
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
