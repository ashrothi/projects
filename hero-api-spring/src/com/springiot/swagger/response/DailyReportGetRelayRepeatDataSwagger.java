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
 * This class contains response on /daily/report/get/relay/repeat/data API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class DailyReportGetRelayRepeatDataSwagger {
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

	private List<DailyReportGetRelayRepeatData> object;

	/**
	 * @return the object
	 */
	public List<DailyReportGetRelayRepeatData> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DailyReportGetRelayRepeatData> object) {
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
class DailyReportGetRelayRepeatData {
	private String id;
	private String device_id;
	private String device_no;
	private String slot;
	private String vendor_name;
	private String vendor_code; 
	private String part_name; 
	private String part_code; 
	private long date_of_test;
	private String model; 
	private String inspection_lot_no; 
	private long lot_creation_date; 
	private String lot_quantity;
	private String min_voltage; 
	private String min_current; 
	private String min_coil_voltage; 
	private String min_on_voltage; 
	private String min_coil_current; 
	private String min_contact_drop_volt; 
	private String min_recovery_voltage; 
	private String max_voltage; 
	private String max_current; 
	private String max_coil_voltage; 
	private String max_on_voltage; 
	private String max_coil_current; 
	private String max_contact_drop_volt; 
	private String max_recovery_voltage;
	private String avg_voltage; 
	private String avg_current; 
	private String avg_coil_voltage; 
	private String avg_on_voltage; 
	private String avg_coil_current; 
	private String avg_contact_drop_volt; 
	private String avg_recovery_voltage;
	private String report_date; 
	private String voltage_specification; 
	private String current_in_rush_specification; 
	private String current_steady_specification; 
	private String coil_voltage_in_rush_specification; 
	private String coil_voltage_steady_specification;
	private String on_voltage_specification; 
	private String coil_current_specification; 
	private String contact_drop_volt_specification; 
	private String recovery_voltage_specification;
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
	 * @return the date_of_test
	 */
	public long getDate_of_test() {
		return date_of_test;
	}
	/**
	 * @param date_of_test the date_of_test to set
	 */
	public void setDate_of_test(long date_of_test) {
		this.date_of_test = date_of_test;
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
	public String getInspection_lot_no() {
		return inspection_lot_no;
	}
	/**
	 * @param inspection_lot_no the inspection_lot_no to set
	 */
	public void setInspection_lot_no(String inspection_lot_no) {
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
	 * @return the lot_quantity
	 */
	public String getLot_quantity() {
		return lot_quantity;
	}
	/**
	 * @param lot_quantity the lot_quantity to set
	 */
	public void setLot_quantity(String lot_quantity) {
		this.lot_quantity = lot_quantity;
	}
	/**
	 * @return the min_voltage
	 */
	public String getMin_voltage() {
		return min_voltage;
	}
	/**
	 * @param min_voltage the min_voltage to set
	 */
	public void setMin_voltage(String min_voltage) {
		this.min_voltage = min_voltage;
	}
	/**
	 * @return the min_current
	 */
	public String getMin_current() {
		return min_current;
	}
	/**
	 * @param min_current the min_current to set
	 */
	public void setMin_current(String min_current) {
		this.min_current = min_current;
	}
	/**
	 * @return the min_coil_voltage
	 */
	public String getMin_coil_voltage() {
		return min_coil_voltage;
	}
	/**
	 * @param min_coil_voltage the min_coil_voltage to set
	 */
	public void setMin_coil_voltage(String min_coil_voltage) {
		this.min_coil_voltage = min_coil_voltage;
	}
	/**
	 * @return the min_on_voltage
	 */
	public String getMin_on_voltage() {
		return min_on_voltage;
	}
	/**
	 * @param min_on_voltage the min_on_voltage to set
	 */
	public void setMin_on_voltage(String min_on_voltage) {
		this.min_on_voltage = min_on_voltage;
	}
	/**
	 * @return the min_coil_current
	 */
	public String getMin_coil_current() {
		return min_coil_current;
	}
	/**
	 * @param min_coil_current the min_coil_current to set
	 */
	public void setMin_coil_current(String min_coil_current) {
		this.min_coil_current = min_coil_current;
	}
	/**
	 * @return the min_contact_drop_volt
	 */
	public String getMin_contact_drop_volt() {
		return min_contact_drop_volt;
	}
	/**
	 * @param min_contact_drop_volt the min_contact_drop_volt to set
	 */
	public void setMin_contact_drop_volt(String min_contact_drop_volt) {
		this.min_contact_drop_volt = min_contact_drop_volt;
	}
	/**
	 * @return the min_recovery_voltage
	 */
	public String getMin_recovery_voltage() {
		return min_recovery_voltage;
	}
	/**
	 * @param min_recovery_voltage the min_recovery_voltage to set
	 */
	public void setMin_recovery_voltage(String min_recovery_voltage) {
		this.min_recovery_voltage = min_recovery_voltage;
	}
	/**
	 * @return the max_voltage
	 */
	public String getMax_voltage() {
		return max_voltage;
	}
	/**
	 * @param max_voltage the max_voltage to set
	 */
	public void setMax_voltage(String max_voltage) {
		this.max_voltage = max_voltage;
	}
	/**
	 * @return the max_current
	 */
	public String getMax_current() {
		return max_current;
	}
	/**
	 * @param max_current the max_current to set
	 */
	public void setMax_current(String max_current) {
		this.max_current = max_current;
	}
	/**
	 * @return the max_coil_voltage
	 */
	public String getMax_coil_voltage() {
		return max_coil_voltage;
	}
	/**
	 * @param max_coil_voltage the max_coil_voltage to set
	 */
	public void setMax_coil_voltage(String max_coil_voltage) {
		this.max_coil_voltage = max_coil_voltage;
	}
	/**
	 * @return the max_on_voltage
	 */
	public String getMax_on_voltage() {
		return max_on_voltage;
	}
	/**
	 * @param max_on_voltage the max_on_voltage to set
	 */
	public void setMax_on_voltage(String max_on_voltage) {
		this.max_on_voltage = max_on_voltage;
	}
	/**
	 * @return the max_coil_current
	 */
	public String getMax_coil_current() {
		return max_coil_current;
	}
	/**
	 * @param max_coil_current the max_coil_current to set
	 */
	public void setMax_coil_current(String max_coil_current) {
		this.max_coil_current = max_coil_current;
	}
	/**
	 * @return the max_contact_drop_volt
	 */
	public String getMax_contact_drop_volt() {
		return max_contact_drop_volt;
	}
	/**
	 * @param max_contact_drop_volt the max_contact_drop_volt to set
	 */
	public void setMax_contact_drop_volt(String max_contact_drop_volt) {
		this.max_contact_drop_volt = max_contact_drop_volt;
	}
	/**
	 * @return the max_recovery_voltage
	 */
	public String getMax_recovery_voltage() {
		return max_recovery_voltage;
	}
	/**
	 * @param max_recovery_voltage the max_recovery_voltage to set
	 */
	public void setMax_recovery_voltage(String max_recovery_voltage) {
		this.max_recovery_voltage = max_recovery_voltage;
	}
	/**
	 * @return the avg_voltage
	 */
	public String getAvg_voltage() {
		return avg_voltage;
	}
	/**
	 * @param avg_voltage the avg_voltage to set
	 */
	public void setAvg_voltage(String avg_voltage) {
		this.avg_voltage = avg_voltage;
	}
	/**
	 * @return the avg_current
	 */
	public String getAvg_current() {
		return avg_current;
	}
	/**
	 * @param avg_current the avg_current to set
	 */
	public void setAvg_current(String avg_current) {
		this.avg_current = avg_current;
	}
	/**
	 * @return the avg_coil_voltage
	 */
	public String getAvg_coil_voltage() {
		return avg_coil_voltage;
	}
	/**
	 * @param avg_coil_voltage the avg_coil_voltage to set
	 */
	public void setAvg_coil_voltage(String avg_coil_voltage) {
		this.avg_coil_voltage = avg_coil_voltage;
	}
	/**
	 * @return the avg_on_voltage
	 */
	public String getAvg_on_voltage() {
		return avg_on_voltage;
	}
	/**
	 * @param avg_on_voltage the avg_on_voltage to set
	 */
	public void setAvg_on_voltage(String avg_on_voltage) {
		this.avg_on_voltage = avg_on_voltage;
	}
	/**
	 * @return the avg_coil_current
	 */
	public String getAvg_coil_current() {
		return avg_coil_current;
	}
	/**
	 * @param avg_coil_current the avg_coil_current to set
	 */
	public void setAvg_coil_current(String avg_coil_current) {
		this.avg_coil_current = avg_coil_current;
	}
	/**
	 * @return the avg_contact_drop_volt
	 */
	public String getAvg_contact_drop_volt() {
		return avg_contact_drop_volt;
	}
	/**
	 * @param avg_contact_drop_volt the avg_contact_drop_volt to set
	 */
	public void setAvg_contact_drop_volt(String avg_contact_drop_volt) {
		this.avg_contact_drop_volt = avg_contact_drop_volt;
	}
	/**
	 * @return the avg_recovery_voltage
	 */
	public String getAvg_recovery_voltage() {
		return avg_recovery_voltage;
	}
	/**
	 * @param avg_recovery_voltage the avg_recovery_voltage to set
	 */
	public void setAvg_recovery_voltage(String avg_recovery_voltage) {
		this.avg_recovery_voltage = avg_recovery_voltage;
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
	 * @return the voltage_specification
	 */
	public String getVoltage_specification() {
		return voltage_specification;
	}
	/**
	 * @param voltage_specification the voltage_specification to set
	 */
	public void setVoltage_specification(String voltage_specification) {
		this.voltage_specification = voltage_specification;
	}
	/**
	 * @return the current_in_rush_specification
	 */
	public String getCurrent_in_rush_specification() {
		return current_in_rush_specification;
	}
	/**
	 * @param current_in_rush_specification the current_in_rush_specification to set
	 */
	public void setCurrent_in_rush_specification(String current_in_rush_specification) {
		this.current_in_rush_specification = current_in_rush_specification;
	}
	/**
	 * @return the current_steady_specification
	 */
	public String getCurrent_steady_specification() {
		return current_steady_specification;
	}
	/**
	 * @param current_steady_specification the current_steady_specification to set
	 */
	public void setCurrent_steady_specification(String current_steady_specification) {
		this.current_steady_specification = current_steady_specification;
	}
	/**
	 * @return the coil_voltage_in_rush_specification
	 */
	public String getCoil_voltage_in_rush_specification() {
		return coil_voltage_in_rush_specification;
	}
	/**
	 * @param coil_voltage_in_rush_specification the coil_voltage_in_rush_specification to set
	 */
	public void setCoil_voltage_in_rush_specification(String coil_voltage_in_rush_specification) {
		this.coil_voltage_in_rush_specification = coil_voltage_in_rush_specification;
	}
	/**
	 * @return the coil_voltage_steady_specification
	 */
	public String getCoil_voltage_steady_specification() {
		return coil_voltage_steady_specification;
	}
	/**
	 * @param coil_voltage_steady_specification the coil_voltage_steady_specification to set
	 */
	public void setCoil_voltage_steady_specification(String coil_voltage_steady_specification) {
		this.coil_voltage_steady_specification = coil_voltage_steady_specification;
	}
	/**
	 * @return the on_voltage_specification
	 */
	public String getOn_voltage_specification() {
		return on_voltage_specification;
	}
	/**
	 * @param on_voltage_specification the on_voltage_specification to set
	 */
	public void setOn_voltage_specification(String on_voltage_specification) {
		this.on_voltage_specification = on_voltage_specification;
	}
	/**
	 * @return the coil_current_specification
	 */
	public String getCoil_current_specification() {
		return coil_current_specification;
	}
	/**
	 * @param coil_current_specification the coil_current_specification to set
	 */
	public void setCoil_current_specification(String coil_current_specification) {
		this.coil_current_specification = coil_current_specification;
	}
	/**
	 * @return the contact_drop_volt_specification
	 */
	public String getContact_drop_volt_specification() {
		return contact_drop_volt_specification;
	}
	/**
	 * @param contact_drop_volt_specification the contact_drop_volt_specification to set
	 */
	public void setContact_drop_volt_specification(String contact_drop_volt_specification) {
		this.contact_drop_volt_specification = contact_drop_volt_specification;
	}
	/**
	 * @return the recovery_voltage_specification
	 */
	public String getRecovery_voltage_specification() {
		return recovery_voltage_specification;
	}
	/**
	 * @param recovery_voltage_specification the recovery_voltage_specification to set
	 */
	public void setRecovery_voltage_specification(String recovery_voltage_specification) {
		this.recovery_voltage_specification = recovery_voltage_specification;
	}
	
	

}
