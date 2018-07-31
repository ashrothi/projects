/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;

/**
 * This class contains response on /inventory/component/get/list API response
 * 
 * @author Mandeep Singh
 */
public class HeroMlGetHornSpecificationSwagger {
	private String description;
	private List<HeroMlGetHornSpecification> object;
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
	public List<HeroMlGetHornSpecification> getObject() {
		return object;
	}
	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroMlGetHornSpecification> object) {
		this.object = object;
	}

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
 * TO get response parameter getter setter.
 */
class HeroMlGetHornSpecification {
	private int device_id;
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
}
