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
 * This class contains response on /hero/daily/report/get/lock/header API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroDailyReportGetLockHeaderSwagger {
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

	private List<HeroDailyReportGetLockHeader> object;

	/**
	 * @return the object
	 */
	public List<HeroDailyReportGetLockHeader> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroDailyReportGetLockHeader> object) {
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
class HeroDailyReportGetLockHeader {
	private int id; 
	private String device_id; 
	private String device_name; 
	private String slot; 
	private String vendor_name; 
	private String vendor_code; 
	private String part_name; 
	private String part_code; 
	private String testing_date; 
	private String model; 
	private String gr_number; 
	private String inspection_lot_number; 
	private String lot_creation_date; 
	private int lot_quantity; 
	private String report_date; 
	private String min_length; 
	private String min_angle; 
	private String min_force; 
	private String min_torque; 
	private String min_lockbar; 
	private String min_conti1; 
	private String min_conti2; 
	private String max_length; 
	private String max_angle; 
	private String max_force; 
	private String max_torque; 
	private String max_lockbar; 
	private String max_conti1; 
	private String max_conti2; 
	private String avg_length; 
	private String avg_angle; 
	private String avg_force; 
	private String avg_torque; 
	private String avg_lockbar; 
	private String avg_conti1; 
	private String avg_conti2; 
	private int cycle;
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
	 * @return the device_name
	 */
	public String getDevice_name() {
		return device_name;
	}
	/**
	 * @param device_name the device_name to set
	 */
	public void setDevice_name(String device_name) {
		this.device_name = device_name;
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
	 * @return the vendor_name
	 */
	public String getVendor_name() {
		return vendor_name;
	}
	/**
	 * @param vendor_name the vendor_name to set
	 */
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}
	/**
	 * @return the vendor_code
	 */
	public String getVendor_code() {
		return vendor_code;
	}
	/**
	 * @param vendor_code the vendor_code to set
	 */
	public void setVendor_code(String vendor_code) {
		this.vendor_code = vendor_code;
	}
	/**
	 * @return the part_name
	 */
	public String getPart_name() {
		return part_name;
	}
	/**
	 * @param part_name the part_name to set
	 */
	public void setPart_name(String part_name) {
		this.part_name = part_name;
	}
	/**
	 * @return the part_code
	 */
	public String getPart_code() {
		return part_code;
	}
	/**
	 * @param part_code the part_code to set
	 */
	public void setPart_code(String part_code) {
		this.part_code = part_code;
	}
	/**
	 * @return the testing_date
	 */
	public String getTesting_date() {
		return testing_date;
	}
	/**
	 * @param testing_date the testing_date to set
	 */
	public void setTesting_date(String testing_date) {
		this.testing_date = testing_date;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the gr_number
	 */
	public String getGr_number() {
		return gr_number;
	}
	/**
	 * @param gr_number the gr_number to set
	 */
	public void setGr_number(String gr_number) {
		this.gr_number = gr_number;
	}
	/**
	 * @return the inspection_lot_number
	 */
	public String getInspection_lot_number() {
		return inspection_lot_number;
	}
	/**
	 * @param inspection_lot_number the inspection_lot_number to set
	 */
	public void setInspection_lot_number(String inspection_lot_number) {
		this.inspection_lot_number = inspection_lot_number;
	}
	/**
	 * @return the lot_creation_date
	 */
	public String getLot_creation_date() {
		return lot_creation_date;
	}
	/**
	 * @param lot_creation_date the lot_creation_date to set
	 */
	public void setLot_creation_date(String lot_creation_date) {
		this.lot_creation_date = lot_creation_date;
	}
	/**
	 * @return the lot_quantity
	 */
	public int getLot_quantity() {
		return lot_quantity;
	}
	/**
	 * @param lot_quantity the lot_quantity to set
	 */
	public void setLot_quantity(int lot_quantity) {
		this.lot_quantity = lot_quantity;
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
	 * @return the min_length
	 */
	public String getMin_length() {
		return min_length;
	}
	/**
	 * @param min_length the min_length to set
	 */
	public void setMin_length(String min_length) {
		this.min_length = min_length;
	}
	/**
	 * @return the min_angle
	 */
	public String getMin_angle() {
		return min_angle;
	}
	/**
	 * @param min_angle the min_angle to set
	 */
	public void setMin_angle(String min_angle) {
		this.min_angle = min_angle;
	}
	/**
	 * @return the min_force
	 */
	public String getMin_force() {
		return min_force;
	}
	/**
	 * @param min_force the min_force to set
	 */
	public void setMin_force(String min_force) {
		this.min_force = min_force;
	}
	/**
	 * @return the min_torque
	 */
	public String getMin_torque() {
		return min_torque;
	}
	/**
	 * @param min_torque the min_torque to set
	 */
	public void setMin_torque(String min_torque) {
		this.min_torque = min_torque;
	}
	/**
	 * @return the min_lockbar
	 */
	public String getMin_lockbar() {
		return min_lockbar;
	}
	/**
	 * @param min_lockbar the min_lockbar to set
	 */
	public void setMin_lockbar(String min_lockbar) {
		this.min_lockbar = min_lockbar;
	}
	/**
	 * @return the min_conti1
	 */
	public String getMin_conti1() {
		return min_conti1;
	}
	/**
	 * @param min_conti1 the min_conti1 to set
	 */
	public void setMin_conti1(String min_conti1) {
		this.min_conti1 = min_conti1;
	}
	/**
	 * @return the min_conti2
	 */
	public String getMin_conti2() {
		return min_conti2;
	}
	/**
	 * @param min_conti2 the min_conti2 to set
	 */
	public void setMin_conti2(String min_conti2) {
		this.min_conti2 = min_conti2;
	}
	/**
	 * @return the max_length
	 */
	public String getMax_length() {
		return max_length;
	}
	/**
	 * @param max_length the max_length to set
	 */
	public void setMax_length(String max_length) {
		this.max_length = max_length;
	}
	/**
	 * @return the max_angle
	 */
	public String getMax_angle() {
		return max_angle;
	}
	/**
	 * @param max_angle the max_angle to set
	 */
	public void setMax_angle(String max_angle) {
		this.max_angle = max_angle;
	}
	/**
	 * @return the max_force
	 */
	public String getMax_force() {
		return max_force;
	}
	/**
	 * @param max_force the max_force to set
	 */
	public void setMax_force(String max_force) {
		this.max_force = max_force;
	}
	/**
	 * @return the max_torque
	 */
	public String getMax_torque() {
		return max_torque;
	}
	/**
	 * @param max_torque the max_torque to set
	 */
	public void setMax_torque(String max_torque) {
		this.max_torque = max_torque;
	}
	/**
	 * @return the max_lockbar
	 */
	public String getMax_lockbar() {
		return max_lockbar;
	}
	/**
	 * @param max_lockbar the max_lockbar to set
	 */
	public void setMax_lockbar(String max_lockbar) {
		this.max_lockbar = max_lockbar;
	}
	/**
	 * @return the max_conti1
	 */
	public String getMax_conti1() {
		return max_conti1;
	}
	/**
	 * @param max_conti1 the max_conti1 to set
	 */
	public void setMax_conti1(String max_conti1) {
		this.max_conti1 = max_conti1;
	}
	/**
	 * @return the max_conti2
	 */
	public String getMax_conti2() {
		return max_conti2;
	}
	/**
	 * @param max_conti2 the max_conti2 to set
	 */
	public void setMax_conti2(String max_conti2) {
		this.max_conti2 = max_conti2;
	}
	/**
	 * @return the avg_length
	 */
	public String getAvg_length() {
		return avg_length;
	}
	/**
	 * @param avg_length the avg_length to set
	 */
	public void setAvg_length(String avg_length) {
		this.avg_length = avg_length;
	}
	/**
	 * @return the avg_angle
	 */
	public String getAvg_angle() {
		return avg_angle;
	}
	/**
	 * @param avg_angle the avg_angle to set
	 */
	public void setAvg_angle(String avg_angle) {
		this.avg_angle = avg_angle;
	}
	/**
	 * @return the avg_force
	 */
	public String getAvg_force() {
		return avg_force;
	}
	/**
	 * @param avg_force the avg_force to set
	 */
	public void setAvg_force(String avg_force) {
		this.avg_force = avg_force;
	}
	/**
	 * @return the avg_torque
	 */
	public String getAvg_torque() {
		return avg_torque;
	}
	/**
	 * @param avg_torque the avg_torque to set
	 */
	public void setAvg_torque(String avg_torque) {
		this.avg_torque = avg_torque;
	}
	/**
	 * @return the avg_lockbar
	 */
	public String getAvg_lockbar() {
		return avg_lockbar;
	}
	/**
	 * @param avg_lockbar the avg_lockbar to set
	 */
	public void setAvg_lockbar(String avg_lockbar) {
		this.avg_lockbar = avg_lockbar;
	}
	/**
	 * @return the avg_conti1
	 */
	public String getAvg_conti1() {
		return avg_conti1;
	}
	/**
	 * @param avg_conti1 the avg_conti1 to set
	 */
	public void setAvg_conti1(String avg_conti1) {
		this.avg_conti1 = avg_conti1;
	}
	/**
	 * @return the avg_conti2
	 */
	public String getAvg_conti2() {
		return avg_conti2;
	}
	/**
	 * @param avg_conti2 the avg_conti2 to set
	 */
	public void setAvg_conti2(String avg_conti2) {
		this.avg_conti2 = avg_conti2;
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

}
