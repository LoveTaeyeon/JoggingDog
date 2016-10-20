package edu.fjnu.Entity.Temp;

public class TempMassage {

	private String message;
	private boolean boolValue;


	public TempMassage(String message, boolean boolValue) {
		super();
		this.message = message;
		this.boolValue = boolValue;
	}


	@Override
	public String toString() {
		return "TempMassage [message=" + message + ", boolValue=" + boolValue
				+ "]";
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public boolean isBoolValue() {
		return boolValue;
	}


	public void setBoolValue(boolean boolValue) {
		this.boolValue = boolValue;
	}


	public TempMassage(){}
	
}
