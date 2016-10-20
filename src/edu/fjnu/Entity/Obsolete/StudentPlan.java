package edu.fjnu.Entity.Obsolete;

import java.sql.SQLException;

import edu.fjnu.DAO.StudentPlanDAO;
import edu.fjnu.DAOImpl.StudentPlanDAOImpl;

public class StudentPlan {		//实体类。对应着数据库中的StudentPlan

	private String sp_stu_ID;
	private int sp_plan_ID;
	private int isFinish;
	
	//构造函数
	
	public StudentPlan(){
		
	}
	
	public StudentPlan(String sp_stu_ID,int sp_plan_ID,int isFinish){
		this.sp_stu_ID = sp_stu_ID;
		this.sp_plan_ID = sp_plan_ID;
		this.isFinish = isFinish;
	}
	
	//get 和  set 方法
	
	public String getSp_stu_ID() {
		return sp_stu_ID;
	}

	public void setSp_stu_ID(String sp_stu_ID) {
		this.sp_stu_ID = sp_stu_ID;
	}

	public int getSp_plan_ID() {
		return sp_plan_ID;
	}

	public void setSp_plan_ID(int sp_plan_ID) {
		this.sp_plan_ID = sp_plan_ID;
	}

	public int isFinish() {
		return isFinish;
	}

	public void setFinish(int isFinish) {
		this.isFinish = isFinish;
	}
	
	//toString
	
	public String toString() {
		return "StudentPlan [sp_stu_ID=" + sp_stu_ID + ", sp_plan_ID="
				+ sp_plan_ID + ", isFinish=" + isFinish + "]";
	}
	
	//测试main函数
	
	public static void main(String[] args) throws SQLException {
		
		StudentPlan s = new StudentPlan("101",12,1);
		StudentPlanDAO stu = new StudentPlanDAOImpl();
		stu.add(s);		
	}
	
}
