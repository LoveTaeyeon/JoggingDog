package edu.fjnu.Entity.Temp;

public class TempMiddleGrade {

	private int BMI;
	private int pullUp;
	private int skipRope;
	private int benchTest;
	private int sitAndReach;
	
	public TempMiddleGrade(){}
	
	public TempMiddleGrade(int bMI, int pullUp, int skipRope, int benchTest,
			int sitAndReach) {
		super();
		BMI = bMI;
		this.pullUp = pullUp;
		this.skipRope = skipRope;
		this.benchTest = benchTest;
		this.sitAndReach = sitAndReach;
	}

	public int getBMI() {
		return BMI;
	}
	public void setBMI(int bMI) {
		BMI = bMI;
	}
	public int getPullUp() {
		return pullUp;
	}
	public void setPullUp(int pullUp) {
		this.pullUp = pullUp;
	}
	public int getSkipRope() {
		return skipRope;
	}
	public void setSkipRope(int skipRope) {
		this.skipRope = skipRope;
	}
	public int getBenchTest() {
		return benchTest;
	}
	public void setBenchTest(int benchTest) {
		this.benchTest = benchTest;
	}
	public int getSitAndReach() {
		return sitAndReach;
	}
	public void setSitAndReach(int sitAndReach) {
		this.sitAndReach = sitAndReach;
	}

	@Override
	public String toString() {
		return "TempMiddleGrade [BMI=" + BMI + ", pullUp=" + pullUp
				+ ", skipRope=" + skipRope + ", benchTest=" + benchTest
				+ ", sitAndReach=" + sitAndReach + "]";
	}
	
}
