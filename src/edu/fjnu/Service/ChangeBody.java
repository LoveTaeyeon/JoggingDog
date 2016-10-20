package edu.fjnu.Service;

public class ChangeBody {
	
	public ChangeBody(){
		
	}

	public boolean judgeIllness(String number){
		//判断选择疾病时是否出错，是否没有选择
		int i = Integer.parseInt(number);
		if(i>=1 && i<=4){
			System.out.println("用户选择无误，可以正确获取到用户选择！");
			return true;
		}else{
			System.out.println("用户未选择或无法获取用户选择！");
			return false;
		}
	}
	
	public String translateIllness(String number){
		//翻译从前段收到的疾病编号信息，翻译成不同的疾病信息，写入不同的疾病
		int i = Integer.parseInt(number);
		if(i == 1){
			return "无";
		}else if(i == 2){
			return "肺炎";
		}else if(i == 3){
			return "阑尾炎";
		}else{
			return "肌肉拉伤";
		}
	}
	
	public void setNewBody(String ID,double height,double weight,String longRunTime,
			String shortRunTime,int pullUp,int pulmonary,String illness){
		//更新数据库中的学生身体信息
		//DAOImpl层代码
		System.out.println("体测成绩更新完成！");
	}	
	
	public static void main(String[] args) {
		ChangeBody test = new ChangeBody();
		test.translateIllness("4165465");
	}
	
}
