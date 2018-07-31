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
 * This class contains response on /daily/report/get/relay API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class DailyReportGetRelaySwagger {
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

	private List<DailyReportGetRelay> object;

	/**
	 * @return the object
	 */
	public List<DailyReportGetRelay> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DailyReportGetRelay> object) {
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
class DailyReportGetRelay {
	private String id;
	private String device_id;
	private String device_no;
	private long report_date;
	private String slot;
	private int cycle; 
	private String voltage_in_rush; 
	private String voltage_steady; 
	private String current_in_rush;
	private String current_steady; 
	private String coil_voltage_in_rush; 
	private String coil_voltage_steady; 
	private String on_voltage_in_rush;
	private String on_voltage_steady; 
	private String coil_current_in_rush; 
	private String coil_current_steady; 
	private String contact_drop_volt_in_rush; 
	private String contact_drop_volt_steady; 
	private String recovery_voltage_in_rush; 
	private String recovery_voltage_in_steady; 
	private String status;
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
	 * @return the cycle
	 */
	public int getCycle() {
		return cycle;
	}
	/**
	 * @param cycle the cycle to set
	 */
	public void setCycle(int cycle) {
		this.cycle = cycle;
	}
	/**
	 * @return the voltage_in_rush
	 */
	public String getVoltage_in_rush() {
		return voltage_in_rush;
	}
	/**
	 * @param voltage_in_rush the voltage_in_rush to set
	 */
	public void setVoltage_in_rush(String voltage_in_rush) {
		this.voltage_in_rush = voltage_in_rush;
	}
	/**
	 * @return the voltage_steady
	 */
	public String getVoltage_steady() {
		return voltage_steady;
	}
	/**
	 * @param voltage_steady the voltage_steady to set
	 */
	public void setVoltage_steady(String voltage_steady) {
		this.voltage_steady = voltage_steady;
	}
	/**
	 * @return the current_in_rush
	 */
	public String getCurrent_in_rush() {
		return current_in_rush;
	}
	/**
	 * @param current_in_rush the current_in_rush to set
	 */
	public void setCurrent_in_rush(String current_in_rush) {
		this.current_in_rush = current_in_rush;
	}
	/**
	 * @return the current_steady
	 */
	public String getCurrent_steady() {
		return current_steady;
	}
	/**
	 * @param current_steady the current_steady to set
	 */
	public void setCurrent_steady(String current_steady) {
		this.current_steady = current_steady;
	}
	/**
	 * @return the coil_voltage_in_rush
	 */
	public String getCoil_voltage_in_rush() {
		return coil_voltage_in_rush;
	}
	/**
	 * @param coil_voltage_in_rush the coil_voltage_in_rush to set
	 */
	public void setCoil_voltage_in_rush(String coil_voltage_in_rush) {
		this.coil_voltage_in_rush = coil_voltage_in_rush;
	}
	/**
	 * @return the coil_voltage_steady
	 */
	public String getCoil_voltage_steady() {
		return coil_voltage_steady;
	}
	/**
	 * @param coil_voltage_steady the coil_voltage_steady to set
	 */
	public void setCoil_voltage_steady(String coil_voltage_steady) {
		this.coil_voltage_steady = coil_voltage_steady;
	}
	/**
	 * @return the on_voltage_in_rush
	 */
	public String getOn_voltage_in_rush() {
		return on_voltage_in_rush;
	}
	/**
	 * @param on_voltage_in_rush the on_voltage_in_rush to set
	 */
	public void setOn_voltage_in_rush(String on_voltage_in_rush) {
		this.on_voltage_in_rush = on_voltage_in_rush;
	}
	/**
	 * @return the on_voltage_steady
	 */
	public String getOn_voltage_steady() {
		return on_voltage_steady;
	}
	/**
	 * @param on_voltage_steady the on_voltage_steady to set
	 */
	public void setOn_voltage_steady(String on_voltage_steady) {
		this.on_voltage_steady = on_voltage_steady;
	}
	/**
	 * @return the coil_current_in_rush
	 */
	public String getCoil_current_in_rush() {
		return coil_current_in_rush;
	}
	/**
	 * @param coil_current_in_rush the coil_current_in_rush to set
	 */
	public void setCoil_current_in_rush(String coil_current_in_rush) {
		this.coil_current_in_rush = coil_current_in_rush;
	}
	/**
	 * @return the coil_current_steady
	 */
	public String getCoil_current_steady() {
		return coil_current_steady;
	}
	/**
	 * @param coil_current_steady the coil_current_steady to set
	 */
	public void setCoil_current_steady(String coil_current_steady) {
		this.coil_current_steady = coil_current_steady;
	}
	/**
	 * @return the contact_drop_volt_in_rush
	 */
	public String getContact_drop_volt_in_rush() {
		return contact_drop_volt_in_rush;
	}
	/**
	 * @param contact_drop_volt_in_rush the contact_drop_volt_in_rush to set
	 */
	public void setContact_drop_volt_in_rush(String contact_drop_volt_in_rush) {
		this.contact_drop_volt_in_rush = contact_drop_volt_in_rush;
	}
	/**
	 * @return the contact_drop_volt_steady
	 */
	public String getContact_drop_volt_steady() {
		return contact_drop_volt_steady;
	}
	/**
	 * @param contact_drop_volt_steady the contact_drop_volt_steady to set
	 */
	public void setContact_drop_volt_steady(String contact_drop_volt_steady) {
		this.contact_drop_volt_steady = contact_drop_volt_steady;
	}
	/**
	 * @return the recovery_voltage_in_rush
	 */
	public String getRecovery_voltage_in_rush() {
		return recovery_voltage_in_rush;
	}
	/**
	 * @param recovery_voltage_in_rush the recovery_voltage_in_rush to set
	 */
	public void setRecovery_voltage_in_rush(String recovery_voltage_in_rush) {
		this.recovery_voltage_in_rush = recovery_voltage_in_rush;
	}
	/**
	 * @return the recovery_voltage_in_steady
	 */
	public String getRecovery_voltage_in_steady() {
		return recovery_voltage_in_steady;
	}
	/**
	 * @param recovery_voltage_in_steady the recovery_voltage_in_steady to set
	 */
	public void setRecovery_voltage_in_steady(String recovery_voltage_in_steady) {
		this.recovery_voltage_in_steady = recovery_voltage_in_steady;
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
