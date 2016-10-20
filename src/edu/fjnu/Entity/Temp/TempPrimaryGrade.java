package edu.fjnu.Entity.Temp;

public class TempPrimaryGrade {

	private int BMI;
	private int FVC;
	private int shortRun;
	private int skipRope;
	private int sitAndReach;
	public int getBMI() {
		return BMI;
	}
	public void setBMI(int bMI) {
		BMI = bMI;
	}
	public int getFVC() {
		return FVC;
	}
	public void setFVC(int fVC) {
		FVC = fVC;
	}
	public int getShortRun() {
		return shortRun;
	}
	public void setShortRun(int shortRun) {
		this.shortRun = shortRun;
	}
	public int getSkipRope() {
		return skipRope;
	}
	public void setSkipRope(int skipRope) {
		this.skipRope = skipRope;
	}
	public int getSitAndReach() {
		return sitAndReach;
	}
	public void setSitAndReach(int sitAndReach) {
		this.sitAndReach = sitAndReach;
	}
	public TempPrimaryGrade(int bMI, int fVC, int shortRun, int skipRope,
			int sitAndReach) {
		super();
		BMI = bMI;
		FVC = fVC;
		this.shortRun = shortRun;
		this.skipRope = skipRope;
		this.sitAndReach = sitAndReach;
	}
	@Override
	public String toString() {
		return "TempPrimaryGrade [BMI=" + BMI + ", FVC=" + FVC + ", shortRun="
				+ shortRun + ", skipRope=" + skipRope + ", sitAndReach="
				+ sitAndReach + "]";
	}
	
	public TempPrimaryGrade(){}
	
}
