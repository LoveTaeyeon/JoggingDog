package edu.fjnu.Entity.Plan;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import edu.fjnu.Service.Translater.Translater;
import edu.fjnu.getPlan.GetPlanForPeople;

public class HealthPlan {

	private String name;
	private String level;
	private String exercisePart;
	private String hardLevel;
	private String groupNum;
	private String forWhat;
	
	//构造函数
	
	public HealthPlan(String name,String level,
			String exercisePart,String hardLevel,String groupNum,String forWhat){
		this.name = name;
		this.level = level;
		this.exercisePart = exercisePart;
		this.hardLevel = hardLevel;
		this.groupNum = groupNum;
		this.forWhat = forWhat;
	}
	
	public HealthPlan(){
		
	}
	// Get And Set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getExercisePart() {
		return exercisePart;
	}
	public void setExercisePart(String exercisePart) {
		this.exercisePart = exercisePart;
	}
	public String getHardLevel() {
		return hardLevel;
	}
	public void setHardLevel(String hardLevel) {
		this.hardLevel = hardLevel;
	}
	public String getGroupNum() {
		return groupNum;
	}
	public void setGroupNum(String groupNum) {
		this.groupNum = groupNum;
	}
	public String getForWhat() {
		return forWhat;
	}
	public void setForWhat(String forWhat) {
		this.forWhat = forWhat;
	}
	
	public String toString() {
		return "HealthPlan [name=" + name + ", level=" + level
				+ ", exercisePart=" + exercisePart + ", hardLevel=" + hardLevel
				+ ", groupNum=" + groupNum + ", forWhat=" + forWhat + "]";
	}

	public static void main(String[] args) throws SQLException {
		
//		HealthPlanDAO hea = new HealthPlanDAOImpl();
//		HealthPlan h = new HealthPlan();
		List<HealthPlan> h = new ArrayList<HealthPlan>();
//		h = hea.queryByForwhatAndLevel("引体向上", "良好");
//		h.clear();
//		HealthPlan hhhh = new HealthPlan("1","1","1","1","1","1");
//		h.add(hhhh);
		Translater tt = new Translater();
		h = GetPlanForPeople.getPlan("101","1000米长跑",tt.translateLongrun("101"));
		for(int i = 0;i < h.size();i++){
			System.out.println(h.get(i).toString());
		}	
	}
	
}
