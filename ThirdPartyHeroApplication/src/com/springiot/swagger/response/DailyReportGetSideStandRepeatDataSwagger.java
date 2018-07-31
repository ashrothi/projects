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
 * This class contains response on /daily/report/get/side/stand/repeat/data API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class DailyReportGetSideStandRepeatDataSwagger {
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

	private List<DailyReportGetSideStandRepeatData> object;

	/**
	 * @return the object
	 */
	public List<DailyReportGetSideStandRepeatData> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DailyReportGetSideStandRepeatData> object) {
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
class DailyReportGetSideStandRepeatData {
	private int id; 
	private int device_id; 
	private String device_no; 
	private String slot; 
	private String vendor_name; 
	private String vendor_code; 
	private String part_name; 
	private String part_code; 
	private String model; 
	private int inspection_lot_no; 
	private long lot_creation_date; 
	private String min_value_power_supply; 
	private String min_value_current; 
	private String min_value_condition_up_to_down_off_on;  
	private String min_value_condition_down_to_up_off; 
	private String min_value_drop_16v; 
	private String max_value_power_supply; 
	private String max_value_current; 
	private String max_value_condition_up_to_down_off_on; 
	private String max_value_condition_down_to_up_off; 
	private String max_value_drop_16v; 
	private String avg_value_power_supply; 
	private String avg_value_current; 
	private String avg_value_condition_up_to_down_off_on; 
	private String avg_value_condition_down_to_up_off; 
	private String avg_value_drop_16v; 
	private long report_date; 
	private String degree_0_to_15;
	private String degree_16_to_35;
	private String degree_greater_than_35;
	private String degree_greater_than_equal_to_10;
	private String degree_upto_5; 
	private String volts_drop_16_specification;
	private String power_supply_specification;
	private String current_specification;
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
	 * @return the inspection_lot_no
	 */
	public int getInspection_lot_no() {
		return inspection_lot_no;
	}
	/**
	 * @param inspection_lot_no the inspection_lot_no to set
	 */
	public void setInspection_lot_no(int inspection_lot_no) {
		this.inspection_lot_no = inspection_lot_no;
	}
	/**
	 * @return the lot_creation_date
	 */
	public long getLot_creation_date() {
		return lot_creation_date;
	}
	/**
	 * @param lot_creation_date the lot_creation_date to set
	 */
	public void setLot_creation_date(long lot_creation_date) {
		this.lot_creation_date = lot_creation_date;
	}
	/**
	 * @return the min_value_power_supply
	 */
	public String getMin_value_power_supply() {
		return min_value_power_supply;
	}
	/**
	 * @param min_value_power_supply the min_value_power_supply to set
	 */
	public void setMin_value_power_supply(String min_value_power_supply) {
		this.min_value_power_supply = min_value_power_supply;
	}
	/**
	 * @return the min_value_current
	 */
	public String getMin_value_current() {
		return min_value_current;
	}
	/**
	 * @param min_value_current the min_value_current to set
	 */
	public void setMin_value_current(String min_value_current) {
		this.min_value_current = min_value_current;
	}
	/**
	 * @return the min_value_condition_up_to_down_off_on
	 */
	public String getMin_value_condition_up_to_down_off_on() {
		return min_value_condition_up_to_down_off_on;
	}
	/**
	 * @param min_value_condition_up_to_down_off_on the min_value_condition_up_to_down_off_on to set
	 */
	public void setMin_value_condition_up_to_down_off_on(String min_value_condition_up_to_down_off_on) {
		this.min_value_condition_up_to_down_off_on = min_value_condition_up_to_down_off_on;
	}
	/**
	 * @return the min_value_condition_down_to_up_off
	 */
	public String getMin_value_condition_down_to_up_off() {
		return min_value_condition_down_to_up_off;
	}
	/**
	 * @param min_value_condition_down_to_up_off the min_value_condition_down_to_up_off to set
	 */
	public void setMin_value_condition_down_to_up_off(String min_value_condition_down_to_up_off) {
		this.min_value_condition_down_to_up_off = min_value_condition_down_to_up_off;
	}
	/**
	 * @return the min_value_drop_16v
	 */
	public String getMin_value_drop_16v() {
		return min_value_drop_16v;
	}
	/**
	 * @param min_value_drop_16v the min_value_drop_16v to set
	 */
	public void setMin_value_drop_16v(String min_value_drop_16v) {
		this.min_value_drop_16v = min_value_drop_16v;
	}
	/**
	 * @return the max_value_power_supply
	 */
	public String getMax_value_power_supply() {
		return max_value_power_supply;
	}
	/**
	 * @param max_value_power_supply the max_value_power_supply to set
	 */
	public void setMax_value_power_supply(String max_value_power_supply) {
		this.max_value_power_supply = max_value_power_supply;
	}
	/**
	 * @return the max_value_current
	 */
	public String getMax_value_current() {
		return max_value_current;
	}
	/**
	 * @param max_value_current the max_value_current to set
	 */
	public void setMax_value_current(String max_value_current) {
		this.max_value_current = max_value_current;
	}
	/**
	 * @return the max_value_condition_up_to_down_off_on
	 */
	public String getMax_value_condition_up_to_down_off_on() {
		return max_value_condition_up_to_down_off_on;
	}
	/**
	 * @param max_value_condition_up_to_down_off_on the max_value_condition_up_to_down_off_on to set
	 */
	public void setMax_value_condition_up_to_down_off_on(String max_value_condition_up_to_down_off_on) {
		this.max_value_condition_up_to_down_off_on = max_value_condition_up_to_down_off_on;
	}
	/**
	 * @return the max_value_condition_down_to_up_off
	 */
	public String getMax_value_condition_down_to_up_off() {
		return max_value_condition_down_to_up_off;
	}
	/**
	 * @param max_value_condition_down_to_up_off the max_value_condition_down_to_up_off to set
	 */
	public void setMax_value_condition_down_to_up_off(String max_value_condition_down_to_up_off) {
		this.max_value_condition_down_to_up_off = max_value_condition_down_to_up_off;
	}
	/**
	 * @return the max_value_drop_16v
	 */
	public String getMax_value_drop_16v() {
		return max_value_drop_16v;
	}
	/**
	 * @param max_value_drop_16v the max_value_drop_16v to set
	 */
	public void setMax_value_drop_16v(String max_value_drop_16v) {
		this.max_value_drop_16v = max_value_drop_16v;
	}
	/**
	 * @return the avg_value_power_supply
	 */
	public String getAvg_value_power_supply() {
		return avg_value_power_supply;
	}
	/**
	 * @param avg_value_power_supply the avg_value_power_supply to set
	 */
	public void setAvg_value_power_supply(String avg_value_power_supply) {
		this.avg_value_power_supply = avg_value_power_supply;
	}
	/**
	 * @return the avg_value_current
	 */
	public String getAvg_value_current() {
		return avg_value_current;
	}
	/**
	 * @param avg_value_current the avg_value_current to set
	 */
	public void setAvg_value_current(String avg_value_current) {
		this.avg_value_current = avg_value_current;
	}
	/**
	 * @return the avg_value_condition_up_to_down_off_on
	 */
	public String getAvg_value_condition_up_to_down_off_on() {
		return avg_value_condition_up_to_down_off_on;
	}
	/**
	 * @param avg_value_condition_up_to_down_off_on the avg_value_condition_up_to_down_off_on to set
	 */
	public void setAvg_value_condition_up_to_down_off_on(String avg_value_condition_up_to_down_off_on) {
		this.avg_value_condition_up_to_down_off_on = avg_value_condition_up_to_down_off_on;
	}
	/**
	 * @return the avg_value_condition_down_to_up_off
	 */
	public String getAvg_value_condition_down_to_up_off() {
		return avg_value_condition_down_to_up_off;
	}
	/**
	 * @param avg_value_condition_down_to_up_off the avg_value_condition_down_to_up_off to set
	 */
	public void setAvg_value_condition_down_to_up_off(String avg_value_condition_down_to_up_off) {
		this.avg_value_condition_down_to_up_off = avg_value_condition_down_to_up_off;
	}
	/**
	 * @return the avg_value_drop_16v
	 */
	public String getAvg_value_drop_16v() {
		return avg_value_drop_16v;
	}
	/**
	 * @param avg_value_drop_16v the avg_value_drop_16v to set
	 */
	public void setAvg_value_drop_16v(String avg_value_drop_16v) {
		this.avg_value_drop_16v = avg_value_drop_16v;
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
	 * @return the degree_0_to_15
	 */
	public String getDegree_0_to_15() {
		return degree_0_to_15;
	}
	/**
	 * @param degree_0_to_15 the degree_0_to_15 to set
	 */
	public void setDegree_0_to_15(String degree_0_to_15) {
		this.degree_0_to_15 = degree_0_to_15;
	}
	/**
	 * @return the degree_16_to_35
	 */
	public String getDegree_16_to_35() {
		return degree_16_to_35;
	}
	/**
	 * @param degree_16_to_35 the degree_16_to_35 to set
	 */
	public void setDegree_16_to_35(String degree_16_to_35) {
		this.degree_16_to_35 = degree_16_to_35;
	}
	/**
	 * @return the degree_greater_than_35
	 */
	public String getDegree_greater_than_35() {
		return degree_greater_than_35;
	}
	/**
	 * @param degree_greater_than_35 the degree_greater_than_35 to set
	 */
	public void setDegree_greater_than_35(String degree_greater_than_35) {
		this.degree_greater_than_35 = degree_greater_than_35;
	}
	/**
	 * @return the degree_greater_than_equal_to_10
	 */
	public String getDegree_greater_than_equal_to_10() {
		return degree_greater_than_equal_to_10;
	}
	/**
	 * @param degree_greater_than_equal_to_10 the degree_greater_than_equal_to_10 to set
	 */
	public void setDegree_greater_than_equal_to_10(String degree_greater_than_equal_to_10) {
		this.degree_greater_than_equal_to_10 = degree_greater_than_equal_to_10;
	}
	/**
	 * @return the degree_upto_5
	 */
	public String getDegree_upto_5() {
		return degree_upto_5;
	}
	/**
	 * @param degree_upto_5 the degree_upto_5 to set
	 */
	public void setDegree_upto_5(String degree_upto_5) {
		this.degree_upto_5 = degree_upto_5;
	}
	/**
	 * @return the volts_drop_16_specification
	 */
	public String getVolts_drop_16_specification() {
		return volts_drop_16_specification;
	}
	/**
	 * @param volts_drop_16_specification the volts_drop_16_specification to set
	 */
	public void setVolts_drop_16_specification(String volts_drop_16_specification) {
		this.volts_drop_16_specification = volts_drop_16_specification;
	}
	/**
	 * @return the power_supply_specification
	 */
	public String getPower_supply_specification() {
		return power_supply_specification;
	}
	/**
	 * @param power_supply_specification the power_supply_specification to set
	 */
	public void setPower_supply_specification(String power_supply_specification) {
		this.power_supply_specification = power_supply_specification;
	}
	/**
	 * @return the current_specification
	 */
	public String getCurrent_specification() {
		return current_specification;
	}
	/**
	 * @param current_specification the current_specification to set
	 */
	public void setCurrent_specification(String current_specification) {
		this.current_specification = current_specification;
	}

}
