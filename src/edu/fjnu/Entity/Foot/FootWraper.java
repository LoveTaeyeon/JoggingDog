package edu.fjnu.Entity.Foot;

public class FootWraper {
	private int footNum;
	private long distance;
	private int perStepDis;
	public FootWraper(){}
	
	public FootWraper(int footNum, long distance, int perStepDis) {
		super();
		this.footNum = footNum;
		this.distance = distance;
		this.perStepDis = perStepDis;
	}

	public void setDistance(long distance) {
		this.distance = distance;
	}
	public long getDistance() {
		return distance;
	}
	public void setFootNum(int footNum) {
		this.footNum = footNum;
	}
	public int getFootNum() {
		return footNum;
	}
	public void setPerStepDis(int perStepDis) {
		this.perStepDis = perStepDis;
	}
	public int getPerStepDis() {
		return perStepDis;
	}
}
