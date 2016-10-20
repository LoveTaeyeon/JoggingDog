package edu.fjnu.Entity.Temp;

public class AndroidLoginTemp {

	private boolean boolValue;	//是否登录成功
	private boolean haveChange;	//是否修改信息
	private boolean haveGodoon; //是否绑定咕咚
	private String userType;	//用户类型
	public boolean isBoolValue() {
		return boolValue;
	}
	public void setBoolValue(boolean boolValue) {
		this.boolValue = boolValue;
	}
	public boolean isHaveChange() {
		return haveChange;
	}
	public void setHaveChange(boolean haveChange) {
		this.haveChange = haveChange;
	}
	public boolean isHaveGodoon() {
		return haveGodoon;
	}
	public void setHaveGodoon(boolean haveGodoon) {
		this.haveGodoon = haveGodoon;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public AndroidLoginTemp(boolean boolValue, boolean haveChange,
			boolean haveGodoon, String userType) {
		super();
		this.boolValue = boolValue;
		this.haveChange = haveChange;
		this.haveGodoon = haveGodoon;
		this.userType = userType;
	}
	public AndroidLoginTemp() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "AndroidLoginTemp [boolValue=" + boolValue + ", haveChange="
				+ haveChange + ", haveGodoon=" + haveGodoon + ", userType="
				+ userType + "]";
	}

}
