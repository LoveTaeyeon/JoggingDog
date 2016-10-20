package edu.fjnu.Entity.Temp;

public class TempHighGrade {

	private int BMI;
	private int benchTest;
	private int longRun;
	private int throwBall;
	private int sitAndReach;
	
	public TempHighGrade(){}
	
	public int getBMI() {
		return BMI;
	}
	public void setBMI(int bMI) {
		BMI = bMI;
	}
	public int getBenchTest() {
		return benchTest;
	}
	public void setBenchTest(int benchTest) {
		this.benchTest = benchTest;
	}
	public int getLongRun() {
		return longRun;
	}
	public void setLongRun(int longRun) {
		this.longRun = longRun;
	}
	public int getThrowBall() {
		return throwBall;
	}
	public void setThrowBall(int throwBall) {
		this.throwBall = throwBall;
	}
	public int getSitAndReach() {
		return sitAndReach;
	}
	public void setSitAndReach(int sitAndReach) {
		this.sitAndReach = sitAndReach;
	}
	public TempHighGrade(int bMI, int benchTest, int longRun, int throwBall,
			int sitAndReach) {
		super();
		BMI = bMI;
		this.benchTest = benchTest;
		this.longRun = longRun;
		this.throwBall = throwBall;
		this.sitAndReach = sitAndReach;
	}
	@Override
	public String toString() {
		return "TempHighGrade [BMI=" + BMI + ", benchTest=" + benchTest
				+ ", longRun=" + longRun + ", throwBall=" + throwBall
				+ ", sitAndReach=" + sitAndReach + "]";
	}
	
}
