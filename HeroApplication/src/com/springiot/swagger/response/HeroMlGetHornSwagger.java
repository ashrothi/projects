/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response on hero/ml/get/status/history and status API response.
 * 
 * @author Mandeep Singh
 */
public class HeroMlGetHornSwagger {
	private String description;
	private List<HeroMlGetHorn> object;
	private boolean valid;
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
	/**
	 * @return the object
	 */
	public List<HeroMlGetHorn> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<HeroMlGetHorn> object) {
		this.object = object;
	}
	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}
	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

class HeroMlGetHorn{
	private int id;
	private int device_id;
	private String part_name;
	private String slot;
	private String power_supply;
	private String current;
	private String frequency;
	private String noise_level;
	private String operation_voltage_range;
	private long predicted_on_cycle;
	private long predicted_for_cycle;
	private long last_modified;
	private String min_power_supply_voltage;
	private String max_power_supply_voltage;
	private String min_current;
	private String max_current;
	private String min_frequency;
	private String max_frequency;
	private String min_noise_level;
	private String max_noise_level;
	private String min_operating_voltage_range;
	private String max_operating_voltage_range;
	private String device_part_code;
	private String device_vendor_code;
	private String vendor_name;
	private String location_name;
	private String component_name;

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
	 * @return the power_supply
	 */
	public String getPower_supply() {
		return power_supply;
	}
	/**
	 * @param power_supply the power_supply to set
	 */
	public void setPower_supply(String power_supply) {
		this.power_supply = power_supply;
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
	 * @return the predicted_on_cycle
	 */
	public long getPredicted_on_cycle() {
		return predicted_on_cycle;
	}
	/**
	 * @param predicted_on_cycle the predicted_on_cycle to set
	 */
	public void setPredicted_on_cycle(long predicted_on_cycle) {
		this.predicted_on_cycle = predicted_on_cycle;
	}
	/**
	 * @return the predicted_for_cycle
	 */
	public long getPredicted_for_cycle() {
		return predicted_for_cycle;
	}
	/**
	 * @param predicted_for_cycle the predicted_for_cycle to set
	 */
	public void setPredicted_for_cycle(long predicted_for_cycle) {
		this.predicted_for_cycle = predicted_for_cycle;
	}
	/**
	 * @return the last_modified
	 */
	public long getLast_modified() {
		return last_modified;
	}
	/**
	 * @param last_modified the last_modified to set
	 */
	public void setLast_modified(long last_modified) {
		this.last_modified = last_modified;
	}
	/**
	 * @return the min_power_supply_voltage
	 */
	public String getMin_power_supply_voltage() {
		return min_power_supply_voltage;
	}
	/**
	 * @param min_power_supply_voltage the min_power_supply_voltage to set
	 */
	public void setMin_power_supply_voltage(String min_power_supply_voltage) {
		this.min_power_supply_voltage = min_power_supply_voltage;
	}
	/**
	 * @return the max_power_supply_voltage
	 */
	public String getMax_power_supply_voltage() {
		return max_power_supply_voltage;
	}
	/**
	 * @param max_power_supply_voltage the max_power_supply_voltage to set
	 */
	public void setMax_power_supply_voltage(String max_power_supply_voltage) {
		this.max_power_supply_voltage = max_power_supply_voltage;
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
	 * @return the min_frequency
	 */
	public String getMin_frequency() {
		return min_frequency;
	}
	/**
	 * @param min_frequency the min_frequency to set
	 */
	public void setMin_frequency(String min_frequency) {
		this.min_frequency = min_frequency;
	}
	/**
	 * @return the max_frequency
	 */
	public String getMax_frequency() {
		return max_frequency;
	}
	/**
	 * @param max_frequency the max_frequency to set
	 */
	public void setMax_frequency(String max_frequency) {
		this.max_frequency = max_frequency;
	}
	/**
	 * @return the min_noise_level
	 */
	public String getMin_noise_level() {
		return min_noise_level;
	}
	/**
	 * @param min_noise_level the min_noise_level to set
	 */
	public void setMin_noise_level(String min_noise_level) {
		this.min_noise_level = min_noise_level;
	}
	/**
	 * @return the max_noise_level
	 */
	public String getMax_noise_level() {
		return max_noise_level;
	}
	/**
	 * @param max_noise_level the max_noise_level to set
	 */
	public void setMax_noise_level(String max_noise_level) {
		this.max_noise_level = max_noise_level;
	}
	/**
	 * @return the min_operating_voltage_range
	 */
	public String getMin_operating_voltage_range() {
		return min_operating_voltage_range;
	}
	/**
	 * @param min_operating_voltage_range the min_operating_voltage_range to set
	 */
	public void setMin_operating_voltage_range(String min_operating_voltage_range) {
		this.min_operating_voltage_range = min_operating_voltage_range;
	}
	/**
	 * @return the max_operating_voltage_range
	 */
	public String getMax_operating_voltage_range() {
		return max_operating_voltage_range;
	}
	/**
	 * @param max_operating_voltage_range the max_operating_voltage_range to set
	 */
	public void setMax_operating_voltage_range(String max_operating_voltage_range) {
		this.max_operating_voltage_range = max_operating_voltage_range;
	}
	/**
	 * @return the device_part_code
	 */
	public String getDevice_part_code() {
		return device_part_code;
	}
	/**
	 * @param device_part_code the device_part_code to set
	 */
	public void setDevice_part_code(String device_part_code) {
		this.device_part_code = device_part_code;
	}
	/**
	 * @return the device_vendor_code
	 */
	public String getDevice_vendor_code() {
		return device_vendor_code;
	}
	/**
	 * @param device_vendor_code the device_vendor_code to set
	 */
	public void setDevice_vendor_code(String device_vendor_code) {
		this.device_vendor_code = device_vendor_code;
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
	 * @return the location_name
	 */
	public String getLocation_name() {
		return location_name;
	}
	/**
	 * @param location_name the location_name to set
	 */
	public void setLocation_name(String location_name) {
		this.location_name = location_name;
	}
	/**
	 * @return the component_name
	 */
	public String getComponent_name() {
		return component_name;
	}
	/**
	 * @param component_name the component_name to set
	 */
	public void setComponent_name(String component_name) {
		this.component_name = component_name;
	}
}
