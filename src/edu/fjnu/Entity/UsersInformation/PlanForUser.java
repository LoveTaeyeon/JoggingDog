package edu.fjnu.Entity.UsersInformation;



public class PlanForUser {

	private String pfu_user_id;
	private String pfu_name;
	private String pfu_level;
	private String pfu_groupnum;
	private String pfu_exercisepart;
	private String pfu_hardlevel;
	private String pfu_forwhat;
	
	public PlanForUser(){}
	public PlanForUser(String pfu_user_id,String pfu_name,String pfu_level,String pfu_groupnum,String pfu_exercisepart,String pfu_hardlevel,String pfu_forwhat){
		this.pfu_user_id = pfu_user_id;
		this.pfu_name = pfu_name;
		this.pfu_level = pfu_level;
		this.pfu_groupnum = pfu_groupnum;
		this.pfu_exercisepart = pfu_exercisepart;
		this.pfu_hardlevel = pfu_hardlevel;
		this.pfu_forwhat = pfu_forwhat;
	}
	public String getPfu_user_id() {
		return pfu_user_id;
	}
	public void setPfu_user_id(String pfu_user_id) {
		this.pfu_user_id = pfu_user_id;
	}
	public String getPfu_name() {
		return pfu_name;
	}
	public void setPfu_name(String pfu_name) {
		this.pfu_name = pfu_name;
	}
	public String getPfu_level() {
		return pfu_level;
	}
	public void setPfu_level(String pfu_level) {
		this.pfu_level = pfu_level;
	}
	public String getPfu_groupnum() {
		return pfu_groupnum;
	}
	public void setPfu_groupnum(String pfu_groupnum) {
		this.pfu_groupnum = pfu_groupnum;
	}
	public String getPfu_exercisepart() {
		return pfu_exercisepart;
	}
	public void setPfu_exercisepart(String pfu_exercisepart) {
		this.pfu_exercisepart = pfu_exercisepart;
	}
	public String getPfu_hardlevel() {
		return pfu_hardlevel;
	}
	public void setPfu_hardlevel(String pfu_hardlevel) {
		this.pfu_hardlevel = pfu_hardlevel;
	}
	public String getPfu_forwhat() {
		return pfu_forwhat;
	}
	public void setPfu_forwhat(String pfu_forwhat) {
		this.pfu_forwhat = pfu_forwhat;
	}
	public String toString() {
		return "PlanForUser [pfu_user_id=" + pfu_user_id + ", pfu_name="
				+ pfu_name + ", pfu_level=" + pfu_level + ", pfu_groupnum="
				+ pfu_groupnum + ", pfu_exercisepart=" + pfu_exercisepart
				+ ", pfu_hardlevel=" + pfu_hardlevel + ", pfu_forwhat="
				+ pfu_forwhat + "]";
	}
	public static void main(String[] args) {
//		PlanForUserDAO pfu = new PlanForUserDAOImpl();
//		List<PlanForUser> planList = new ArrayList<PlanForUser>();
	}
}
