package edu.fjnu.Entity.Infos;


public class Primaryinfo {

	private String INFO_ID;			//	学号
	private String INFO_SEX;		//性别
	private String age;				//年龄
	private String height;			//身高
	private String weight;			//体重
	private String BMI;				//体重指数
	private String BFR;				//体脂率
	private String FVC;				//肺活量
	private String shortRun;		//50m短跑
	private String skipRope;		//跳绳
	private String sitAndReach;		//坐立体前屈
	
	public Primaryinfo(){
		
	}
	
	public Primaryinfo(String INFO_ID,String INFO_SEX,String age,String height,String weight,
			String BMI,String BFR,String FVC,String shortRun,String skipRope,String sitAndReach){
		this.age = age;
		this.BFR = BFR;
		this.BMI = BMI;
		this.FVC = FVC;
		this.height = height;
		this.INFO_ID = INFO_ID;
		this.INFO_SEX = INFO_SEX;
		this.shortRun = shortRun;
		this.sitAndReach = sitAndReach;
		this.skipRope = skipRope;
		this.weight = weight;
	}
	
	public String getINFO_ID() {
		return INFO_ID;
	}
	public void setINFO_ID(String iNFO_ID) {
		INFO_ID = iNFO_ID;
	}
	public String getINFO_SEX() {
		return INFO_SEX;
	}
	public void setINFO_SEX(String iNFO_SEX) {
		INFO_SEX = iNFO_SEX;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getBMI() {
		return BMI;
	}
	public void setBMI(String bMI) {
		BMI = bMI;
	}
	public String getBFR() {
		return BFR;
	}
	public void setBFR(String bFR) {
		BFR = bFR;
	}
	public String getFVC() {
		return FVC;
	}
	public void setFVC(String fVC) {
		FVC = fVC;
	}
	public String getShortRun() {
		return shortRun;
	}
	public void setShortRun(String shortRun) {
		this.shortRun = shortRun;
	}
	public String getSkipRope() {
		return skipRope;
	}
	public void setSkipRope(String skipRope) {
		this.skipRope = skipRope;
	}
	public String getSitAndReach() {
		return sitAndReach;
	}
	public void setSitAndReach(String sitAndReach) {
		this.sitAndReach = sitAndReach;
	}
	@Override
	public String toString() {
		return "Primaryinfo [INFO_ID=" + INFO_ID + ", INFO_SEX=" + INFO_SEX
				+ ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", BMI=" + BMI + ", BFR=" + BFR + ", FVC=" + FVC
				+ ", shortRun=" + shortRun + ", skipRope=" + skipRope
				+ ", sitAndReach=" + sitAndReach + "]";
	}
	
	public static void main(String[] args) {
		
	}
	
}
