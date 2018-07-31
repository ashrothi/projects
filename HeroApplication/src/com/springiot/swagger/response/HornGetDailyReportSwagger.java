/**
h*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
/**
 * 
 * This class contains response on /horn/get/daily/report API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HornGetDailyReportSwagger {
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

	private List<HornGetDailyReport> object;

	/**
	 * @return the object
	 */
	public List<HornGetDailyReport> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HornGetDailyReport> object) {
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
class HornGetDailyReport {
	private String id;
	private String device_id;
	private String device_no;
	private String cycles;
	private String power_supply_voltage;
	private String current;
	private String frequency;
	private String noise_level;
	private String operation_voltage_range;
	private String report_date;
	private String slot;
	private String staus;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the device_id
	 */
	public String getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(String device_id) {
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
	public String getCycles() {
		return cycles;
	}
	/**
	 * @param cycles the cycles to set
	 */
	public void setCycles(String cycles) {
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
	 * @return the frequency
	 */
	public String getFrequency() {
		return frequency;
	}
	/**
	 * @param frequency the frequency to set
	 */
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	/**
	 * @return the noise_level
	 */
	public String getNoise_level() {
		return noise_level;
	}
	/**
	 * @param noise_level the noise_level to set
	 */
	public void setNoise_level(String noise_level) {
		this.noise_level = noise_level;
	}
	/**
	 * @return the operation_voltage_range
	 */
	public String getOperation_voltage_range() {
		return operation_voltage_range;
	}
	/**
	 * @param operation_voltage_range the operation_voltage_range to set
	 */
	public void setOperation_voltage_range(String operation_voltage_range) {
		this.operation_voltage_range = operation_voltage_range;
	}
	/**
	 * @return the report_date
	 */
	public String getReport_date() {
		return report_date;
	}
	/**
	 * @param report_date the report_date to set
	 */
	public void setReport_date(String report_date) {
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
	 * @return the staus
	 */
	public String getStaus() {
		return staus;
	}
	/**
	 * @param staus the staus to set
	 */
	public void setStaus(String staus) {
		this.staus = staus;
	}
	

}
