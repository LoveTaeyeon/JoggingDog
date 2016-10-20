/**
 * 
 */
package edu.fjnu.webCrawlers;

/**
 * @author Cerulean
 *
 */
public class CodoonData {
	private  double distance;
	private  int duration;
	private  double avg_speed;
	private  double usePower;
	/**
	 * @return the distance
	 */
	public double getDistance() {
		return distance;
	}
	/**
	 * @param d the distance to set
	 */
	public void setDistance(double d) {
		this.distance = d;
	}
	/**
	 * @return the duration
	 */
	public Integer getDuration() {
		return duration;
	}
	/**
	 * @param string the duration to set
	 */
	public void setDuration(Integer string) {
		this.duration = string;
	}
	/**
	 * @return the avg_speed
	 */
	public double getAvg_speed() {
		return avg_speed;
	}
	/**
	 * @param d the avg_speed to set
	 */
	public void setAvg_speed(double d) {
		this.avg_speed = d;
	}
	/**
	 * @return the usePower
	 */
	public double getUsePower() {
		return usePower;
	}
	/**
	 * @param d the usePower to set
	 */
	public void setUsePower(double d) {
		this.usePower = d;
	}
	
	public String toString() {
		return "CodoonData [distance=" + distance + ", duration=" + duration
				+ ", avg_speed=" + avg_speed + ", usePower=" + usePower + "]";
	}
	
	
}
