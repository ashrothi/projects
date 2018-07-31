/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
/**
 * 
 * This class contains response on /hero/daily/report/get/lock API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroDailyReportGetLockSwagger {
	private String description;
/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private List<HeroDailyReportGetLock> object;

	/**
	 * @return the object
	 */
	public List<HeroDailyReportGetLock> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroDailyReportGetLock> object) {
		this.object = object;
	}

	private boolean valid;

	/**
	 * To get if object is Valid
	 * 
	 * @return
	 */
	public boolean isValid() {
		return valid;
	}
/**
	 * To set Object Valid
	 * 
	 * @param valid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
/*
*TO get response parameter getter setter
*/
class HeroDailyReportGetLock {
	private int id; 
	private int device_id; 
	private String device_no; 
	private int cycles; 
	private String length; 
	private String angle; 
	private String force; 
	private String torque; 
	private String lockbar; 
	private String conti1; 
	private String conti2; 
	private long report_date; 
	private String slot; 
	private String status;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the device_id
	 */
	public int getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(int device_id) {
		this.device_id = device_id;
	}
	/**
	 * @return the device_no
	 */
	public String getDevice_no() {
		return device_no;
	}
	/**
	 * @param device_no the device_no to set
	 */
	public void setDevice_no(String device_no) {
		this.device_no = device_no;
	}
	/**
	 * @return the cycles
	 */
	public int getCycles() {
		return cycles;
	}
	/**
	 * @param cycles the cycles to set
	 */
	public void setCycles(int cycles) {
		this.cycles = cycles;
	}
	/**
	 * @return the length
	 */
	public String getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(String length) {
		this.length = length;
	}
	/**
	 * @return the angle
	 */
	public String getAngle() {
		return angle;
	}
	/**
	 * @param angle the angle to set
	 */
	public void setAngle(String angle) {
		this.angle = angle;
	}
	/**
	 * @return the force
	 */
	public String getForce() {
		return force;
	}
	/**
	 * @param force the force to set
	 */
	public void setForce(String force) {
		this.force = force;
	}
	/**
	 * @return the torque
	 */
	public String getTorque() {
		return torque;
	}
	/**
	 * @param torque the torque to set
	 */
	public void setTorque(String torque) {
		this.torque = torque;
	}
	/**
	 * @return the lockbar
	 */
	public String getLockbar() {
		return lockbar;
	}
	/**
	 * @param lockbar the lockbar to set
	 */
	public void setLockbar(String lockbar) {
		this.lockbar = lockbar;
	}
	/**
	 * @return the conti1
	 */
	public String getConti1() {
		return conti1;
	}
	/**
	 * @param conti1 the conti1 to set
	 */
	public void setConti1(String conti1) {
		this.conti1 = conti1;
	}
	/**
	 * @return the conti2
	 */
	public String getConti2() {
		return conti2;
	}
	/**
	 * @param conti2 the conti2 to set
	 */
	public void setConti2(String conti2) {
		this.conti2 = conti2;
	}
	/**
	 * @return the report_date
	 */
	public long getReport_date() {
		return report_date;
	}
	/**
	 * @param report_date the report_date to set
	 */
	public void setReport_date(long report_date) {
		this.report_date = report_date;
	}
	/**
	 * @return the slot
	 */
	public String getSlot() {
		return slot;
	}
	/**
	 * @param slot the slot to set
	 */
	public void setSlot(String slot) {
		this.slot = slot;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	} 

}
