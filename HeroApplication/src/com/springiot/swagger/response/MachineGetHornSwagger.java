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
 * This class contains response on /machine/get/horn API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class MachineGetHornSwagger {
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

	private List<MachineGetHorn> object;

	/**
	 * @return the object
	 */
	public List<MachineGetHorn> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<MachineGetHorn> object) {
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
class MachineGetHorn {
	private String id;
	private String device_id;
	private String device_no;
	private String slot;
	private String vendor_name;
	private String vendor_code; 
	private String part_name; 
	private String part_code; 
	private String model; 
	private String inspection_lot_no; 
	private String lot_creation_date; 
	private String min_value_power_supply; 
	private String min_value_current; 
	private String min_value_frequency; 
	private String min_value_noise_level; 
	private String min_value_operating_voltage_range; 
	private String max_value_power_supply; 
	private String max_value_current; 
	private String max_value_frequency; 
	private String max_value_noise_level; 
	private String max_value_opearting_voltage_range; 
	private String avg_value_power_supply; 
	private String avg_value_current; 
	private String avg_value_frequency; 
	private String avg_value_noise_level; 
	private String avg_value_opearting_voltage_range; 
	private String report_date; 
	private String power_supply_specification; 
	private String current_specification; 
	private String frequency_specification; 
	private String noise_level_specification; 
	private String operation_voltage_range_specification;
	private String device_alias;
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
	 * @return the min_value_frequency
	 */
	public String getMin_value_frequency() {
		return min_value_frequency;
	}
	/**
	 * @param min_value_frequency the min_value_frequency to set
	 */
	public void setMin_value_frequency(String min_value_frequency) {
		this.min_value_frequency = min_value_frequency;
	}
	/**
	 * @return the min_value_noise_level
	 */
	public String getMin_value_noise_level() {
		return min_value_noise_level;
	}
	/**
	 * @param min_value_noise_level the min_value_noise_level to set
	 */
	public void setMin_value_noise_level(String min_value_noise_level) {
		this.min_value_noise_level = min_value_noise_level;
	}
	/**
	 * @return the min_value_operating_voltage_range
	 */
	public String getMin_value_operating_voltage_range() {
		return min_value_operating_voltage_range;
	}
	/**
	 * @param min_value_operating_voltage_range the min_value_operating_voltage_range to set
	 */
	public void setMin_value_operating_voltage_range(String min_value_operating_voltage_range) {
		this.min_value_operating_voltage_range = min_value_operating_voltage_range;
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
	 * @return the max_value_frequency
	 */
	public String getMax_value_frequency() {
		return max_value_frequency;
	}
	/**
	 * @param max_value_frequency the max_value_frequency to set
	 */
	public void setMax_value_frequency(String max_value_frequency) {
		this.max_value_frequency = max_value_frequency;
	}
	/**
	 * @return the max_value_noise_level
	 */
	public String getMax_value_noise_level() {
		return max_value_noise_level;
	}
	/**
	 * @param max_value_noise_level the max_value_noise_level to set
	 */
	public void setMax_value_noise_level(String max_value_noise_level) {
		this.max_value_noise_level = max_value_noise_level;
	}
	/**
	 * @return the max_value_opearting_voltage_range
	 */
	public String getMax_value_opearting_voltage_range() {
		return max_value_opearting_voltage_range;
	}
	/**
	 * @param max_value_opearting_voltage_range the max_value_opearting_voltage_range to set
	 */
	public void setMax_value_opearting_voltage_range(String max_value_opearting_voltage_range) {
		this.max_value_opearting_voltage_range = max_value_opearting_voltage_range;
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
	 * @return the avg_value_frequency
	 */
	public String getAvg_value_frequency() {
		return avg_value_frequency;
	}
	/**
	 * @param avg_value_frequency the avg_value_frequency to set
	 */
	public void setAvg_value_frequency(String avg_value_frequency) {
		this.avg_value_frequency = avg_value_frequency;
	}
	/**
	 * @return the avg_value_noise_level
	 */
	public String getAvg_value_noise_level() {
		return avg_value_noise_level;
	}
	/**
	 * @param avg_value_noise_level the avg_value_noise_level to set
	 */
	public void setAvg_value_noise_level(String avg_value_noise_level) {
		this.avg_value_noise_level = avg_value_noise_level;
	}
	/**
	 * @return the avg_value_opearting_voltage_range
	 */
	public String getAvg_value_opearting_voltage_range() {
		return avg_value_opearting_voltage_range;
	}
	/**
	 * @param avg_value_opearting_voltage_range the avg_value_opearting_voltage_range to set
	 */
	public void setAvg_value_opearting_voltage_range(String avg_value_opearting_voltage_range) {
		this.avg_value_opearting_voltage_range = avg_value_opearting_voltage_range;
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
	/**
	 * @return the frequency_specification
	 */
	public String getFrequency_specification() {
		return frequency_specification;
	}
	/**
	 * @param frequency_specification the frequency_specification to set
	 */
	public void setFrequency_specification(String frequency_specification) {
		this.frequency_specification = frequency_specification;
	}
	/**
	 * @return the noise_level_specification
	 */
	public String getNoise_level_specification() {
		return noise_level_specification;
	}
	/**
	 * @param noise_level_specification the noise_level_specification to set
	 */
	public void setNoise_level_specification(String noise_level_specification) {
		this.noise_level_specification = noise_level_specification;
	}
	/**
	 * @return the operation_voltage_range_specification
	 */
	public String getOperation_voltage_range_specification() {
		return operation_voltage_range_specification;
	}
	/**
	 * @param operation_voltage_range_specification the operation_voltage_range_specification to set
	 */
	public void setOperation_voltage_range_specification(String operation_voltage_range_specification) {
		this.operation_voltage_range_specification = operation_voltage_range_specification;
	}
	/**
	 * @return the device_alias
	 */
	public String getDevice_alias() {
		return device_alias;
	}
	/**
	 * @param device_alias the device_alias to set
	 */
	public void setDevice_alias(String device_alias) {
		this.device_alias = device_alias;
	} 
	
	
	 

}
