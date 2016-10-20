package edu.fjnu.Entity.UsersInformation;

/**
 * Created by ven_hxz on 16/4/3.
 * 学生信息bean
 */
public class Student {

    private String stu_ID;//学生ID
    private String name;//学生姓名
    private String stu_Sex;//学生性别
    private String password;//学生密码
    private String userType;//学生当前所处学习阶段

    public Student() {
    }

    public Student(String stu_ID, String name, String stu_Sex, String password,String userType) {
        this.stu_ID = stu_ID;
        this.name = name;
        this.stu_Sex = stu_Sex;
        this.password = password;
        this.userType = userType;
    }

    @Override
	public String toString() {
		return "Student [stu_ID=" + stu_ID + ", name=" + name + ", stu_Sex="
				+ stu_Sex + ", password=" + password + ", userType=" + userType
				+ "]";
	}

	public String getStu_ID() {
        return stu_ID;
    }

    public void setStu_ID(String stu_ID) {
        this.stu_ID = stu_ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStu_Sex() {
        return stu_Sex;
    }

    public void setStu_Sex(String stu_Sex) {
        this.stu_Sex = stu_Sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }


}
