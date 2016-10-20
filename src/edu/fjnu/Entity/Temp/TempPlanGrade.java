package edu.fjnu.Entity.Temp;

public class TempPlanGrade {

		private int longRunGrade;
		private int shortRunGarde;
		private int pullUpGrade;
		private int jumpGrade;
		private int BMIGrade;
		public TempPlanGrade() {
			// TODO Auto-generated constructor stub
		}
		public TempPlanGrade(int longRunGrade,int shortRunGarde,int pullUpGrade,int jumpGrade,int BMIGrade) {
			// TODO Auto-generated constructor stub
			this.longRunGrade = longRunGrade;
			this.shortRunGarde = shortRunGarde;
			this.pullUpGrade = pullUpGrade;
			this.jumpGrade = jumpGrade;
			this.BMIGrade = BMIGrade;
		}
		public String toString() {
			return "TempPlanGrade [longRunGrade=" + longRunGrade
					+ ", shortRunGarde=" + shortRunGarde
					+ ", pullUpGrade=" + pullUpGrade + ", jumpGrade="
					+ jumpGrade + ", BMIGrade=" + BMIGrade + "]";
		}
		public int getLongRunGrade() {
			return longRunGrade;
		}
		public void setLongRunGrade(int longRunGrade) {
			this.longRunGrade = longRunGrade;
		}
		public int getShortRunGarde() {
			return shortRunGarde;
		}
		public void setShortRunGarde(int shortRunGarde) {
			this.shortRunGarde = shortRunGarde;
		}
		public int getPullUpGrade() {
			return pullUpGrade;
		}
		public void setPullUpGrade(int pullUpGrade) {
			this.pullUpGrade = pullUpGrade;
		}
		public int getJumpGrade() {
			return jumpGrade;
		}
		public void setJumpGrade(int jumpGrade) {
			this.jumpGrade = jumpGrade;
		}
		public int getBMIGrade() {
			return BMIGrade;
		}
		public void setBMIGrade(int bMIGrade) {
			BMIGrade = bMIGrade;
		}
		
	
}
