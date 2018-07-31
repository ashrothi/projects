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
 * This class contains response on /daily/report/get/side/stand API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class DailyReportGetSideStandSwagger {
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

	private List<DailyReportGetSideStand> object;

	/**
	 * @return the object
	 */
	public List<DailyReportGetSideStand> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DailyReportGetSideStand> object) {
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
class DailyReportGetSideStand {

	private int id; 
	private int device_id; 
	private String device_no;  
	private String slot; 
	private long report_date; 
	private int cycles; 
	private String power_supply_voltage; 
	private String current; 
	private String operating_angle_condition_up_to_down_off; 
	private String operating_angle_condition_up_to_down_off_on; 
	private String operating_angle_condition_up_to_down_on; 
	private String operating_angle_condition_down_to_up_off; 
	private String operating_angle_condition_down_to_up_remain_off; 
	private String voltage_drop_16v; 
	private String status; 
	private String test_pause_reason;
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
	 * @return the power_supply_voltage
	 */
	public String getPower_supply_voltage() {
		return power_supply_voltage;
	}
	/**
	 * @param power_supply_voltage the power_supply_voltage to set
	 */
	public void setPower_supply_voltage(String power_supply_voltage) {
		this.power_supply_voltage = power_supply_voltage;
	}
	/**
	 * @return the current
	 */
	public String getCurrent() {
		return current;
	}
	/**
	 * @param current the current to set
	 */
	public void setCurrent(String current) {
		this.current = current;
	}
	/**
	 * @return the operating_angle_condition_up_to_down_off
	 */
	public String getOperating_angle_condition_up_to_down_off() {
		return operating_angle_condition_up_to_down_off;
	}
	/**
	 * @param operating_angle_condition_up_to_down_off the operating_angle_condition_up_to_down_off to set
	 */
	public void setOperating_angle_condition_up_to_down_off(String operating_angle_condition_up_to_down_off) {
		this.operating_angle_condition_up_to_down_off = operating_angle_condition_up_to_down_off;
	}
	/**
	 * @return the operating_angle_condition_up_to_down_off_on
	 */
	public String getOperating_angle_condition_up_to_down_off_on() {
		return operating_angle_condition_up_to_down_off_on;
	}
	/**
	 * @param operating_angle_condition_up_to_down_off_on the operating_angle_condition_up_to_down_off_on to set
	 */
	public void setOperating_angle_condition_up_to_down_off_on(String operating_angle_condition_up_to_down_off_on) {
		this.operating_angle_condition_up_to_down_off_on = operating_angle_condition_up_to_down_off_on;
	}
	/**
	 * @return the operating_angle_condition_up_to_down_on
	 */
	public String getOperating_angle_condition_up_to_down_on() {
		return operating_angle_condition_up_to_down_on;
	}
	/**
	 * @param operating_angle_condition_up_to_down_on the operating_angle_condition_up_to_down_on to set
	 */
	public void setOperating_angle_condition_up_to_down_on(String operating_angle_condition_up_to_down_on) {
		this.operating_angle_condition_up_to_down_on = operating_angle_condition_up_to_down_on;
	}
	/**
	 * @return the operating_angle_condition_down_to_up_off
	 */
	public String getOperating_angle_condition_down_to_up_off() {
		return operating_angle_condition_down_to_up_off;
	}
	/**
	 * @param operating_angle_condition_down_to_up_off the operating_angle_condition_down_to_up_off to set
	 */
	public void setOperating_angle_condition_down_to_up_off(String operating_angle_condition_down_to_up_off) {
		this.operating_angle_condition_down_to_up_off = operating_angle_condition_down_to_up_off;
	}
	/**
	 * @return the operating_angle_condition_down_to_up_remain_off
	 */
	public String getOperating_angle_condition_down_to_up_remain_off() {
		return operating_angle_condition_down_to_up_remain_off;
	}
	/**
	 * @param operating_angle_condition_down_to_up_remain_off the operating_angle_condition_down_to_up_remain_off to set
	 */
	public void setOperating_angle_condition_down_to_up_remain_off(String operating_angle_condition_down_to_up_remain_off) {
		this.operating_angle_condition_down_to_up_remain_off = operating_angle_condition_down_to_up_remain_off;
	}
	/**
	 * @return the voltage_drop_16v
	 */
	public String getVoltage_drop_16v() {
		return voltage_drop_16v;
	}
	/**
	 * @param voltage_drop_16v the voltage_drop_16v to set
	 */
	public void setVoltage_drop_16v(String voltage_drop_16v) {
		this.voltage_drop_16v = voltage_drop_16v;
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
	/**
	 * @return the test_pause_reason
	 */
	public String getTest_pause_reason() {
		return test_pause_reason;
	}
	/**
	 * @param test_pause_reason the test_pause_reason to set
	 */
	public void setTest_pause_reason(String test_pause_reason) {
		this.test_pause_reason = test_pause_reason;
	}

}
