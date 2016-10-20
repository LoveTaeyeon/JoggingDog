package edu.fjnu.exception;

public class FootException extends ApplicationException{
	private int status;
	private String msg;
	public FootException(int status,String msg){
		this.status = status;
		this.msg = msg;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatus() {
		return status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
