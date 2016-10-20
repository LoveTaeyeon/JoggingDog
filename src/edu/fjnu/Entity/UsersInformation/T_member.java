package edu.fjnu.Entity.UsersInformation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T_member {

	private int memberId;
	private String accountNo;
	private String address;
	private String area;
	private String name;
	private String password;
	private int state;
	private int TYPE;
	private int grade;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getTYPE() {
		return TYPE;
	}

	public void setTYPE(int tYPE) {
		TYPE = tYPE;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public T_member() {
		super();
		// TODO Auto-generated constructor stub
	}

	public T_member(int memberId, String accountNo, String address,
			String area, String name, String password, int state, int tYPE,
			int grade) {
		super();
		this.memberId = memberId;
		this.accountNo = accountNo;
		this.address = address;
		this.area = area;
		this.name = name;
		this.password = password;
		this.state = state;
		TYPE = tYPE;
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "T_member [memberId=" + memberId + ", accountNo=" + accountNo
				+ ", address=" + address + ", area=" + area + ", name=" + name
				+ ", password=" + password + ", state=" + state + ", TYPE="
				+ TYPE + ", grade=" + grade + "]";
	}

	public static void main(String[] args) {

		Pattern pattern = Pattern.compile("[0-9]{1,}");
		Matcher matcher = pattern.matcher((CharSequence)"11564_");
		boolean result=matcher.matches();
		System.out.println(result);
	}

}
