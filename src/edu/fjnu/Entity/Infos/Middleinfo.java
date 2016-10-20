package edu.fjnu.Entity.Infos;

public class Middleinfo {

	private String INFO_ID;
	private String INFO_SEX;
	private String age;
	private String height;
	private String weight;
	private String BMI;
	private String BFR;
	private String pullUp;
	private String skipRope;
	private String benchTest;
	private String sitAndReach;
	
	public Middleinfo(){}

	public Middleinfo(String iNFO_ID, String iNFO_SEX, String age,
			String height, String weight, String bMI, String bFR,
			String pullUp, String skipRope, String benchTest, String sitAndReach) {
		super();
		this.INFO_ID = iNFO_ID;
		this.INFO_SEX = iNFO_SEX;
		this.age = age;
		this.height = height;
		this.weight = weight;
		this.BMI = bMI;
		this.BFR = bFR;
		this.pullUp = pullUp;
		this.skipRope = skipRope;
		this.benchTest = benchTest;
		this.sitAndReach = sitAndReach;
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

	public String getPullUp() {
		return pullUp;
	}

	public void setPullUp(String pullUp) {
		this.pullUp = pullUp;
	}

	public String getSkipRope() {
		return skipRope;
	}

	public void setSkipRope(String skipRope) {
		this.skipRope = skipRope;
	}

	public String getBenchTest() {
		return benchTest;
	}

	public void setBenchTest(String benchTest) {
		this.benchTest = benchTest;
	}

	public String getSitAndReach() {
		return sitAndReach;
	}

	public void setSitAndReach(String sitAndReach) {
		this.sitAndReach = sitAndReach;
	}

	@Override
	public String toString() {
		return "Middleinfo [INFO_ID=" + INFO_ID + ", INFO_SEX=" + INFO_SEX
				+ ", age=" + age + ", height=" + height + ", weight=" + weight
				+ ", BMI=" + BMI + ", BFR=" + BFR + ", pullUp=" + pullUp
				+ ", skipRope=" + skipRope + ", benchTest=" + benchTest
				+ ", sitAndReach=" + sitAndReach + "]";
	}

}
