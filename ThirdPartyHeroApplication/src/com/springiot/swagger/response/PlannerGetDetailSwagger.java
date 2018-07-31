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
 * This class contains response on /planner/get/detail API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class PlannerGetDetailSwagger {
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

	private List<PlannerGetDetail> object;

	/**
	 * @return the object
	 */
	public List<PlannerGetDetail> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<PlannerGetDetail> object) {
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
class PlannerGetDetail {
	private String S_No;
	private String id;
	private String planner_version;
	private String planner_name;
	private String planner_number;
	private String part_code;
	private String part_name;
	private String vehicle_model;
	private String vendor;
	private String vendor_code;
	private String model;
	private String plant;
	private String part_manufacturing_location;
	private String no_of_samples;
	private String repeated_operation;
	private String repeated_operation_duration;
	private String ro_sample;
	private String shower;
	private String shower_duration;
	private String shower_sample;
	private String dust;
	private String dust_duration;
	private String dust_sample;
	private String creation_date;
	private String revised_date;
	private String ro_testing_status;
	private String shower_testing_status;
	private String dust_testing_status;
	/**
	 * @return the s_No
	 */
	public String getS_No() {
		return S_No;
	}
	/**
	 * @param s_No the s_No to set
	 */
	public void setS_No(String s_No) {
		S_No = s_No;
	}
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
	 * @return the planner_version
	 */
	public String getPlanner_version() {
		return planner_version;
	}
	/**
	 * @param planner_version the planner_version to set
	 */
	public void setPlanner_version(String planner_version) {
		this.planner_version = planner_version;
	}
	/**
	 * @return the planner_name
	 */
	public String getPlanner_name() {
		return planner_name;
	}
	/**
	 * @param planner_name the planner_name to set
	 */
	public void setPlanner_name(String planner_name) {
		this.planner_name = planner_name;
	}
	/**
	 * @return the planner_number
	 */
	public String getPlanner_number() {
		return planner_number;
	}
	/**
	 * @param planner_number the planner_number to set
	 */
	public void setPlanner_number(String planner_number) {
		this.planner_number = planner_number;
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
	 * @return the vehicle_model
	 */
	public String getVehicle_model() {
		return vehicle_model;
	}
	/**
	 * @param vehicle_model the vehicle_model to set
	 */
	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}
	/**
	 * @return the vendor
	 */
	public String getVendor() {
		return vendor;
	}
	/**
	 * @param vendor the vendor to set
	 */
	public void setVendor(String vendor) {
		this.vendor = vendor;
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
	 * @return the plant
	 */
	public String getPlant() {
		return plant;
	}
	/**
	 * @param plant the plant to set
	 */
	public void setPlant(String plant) {
		this.plant = plant;
	}
	/**
	 * @return the part_manufacturing_location
	 */
	public String getPart_manufacturing_location() {
		return part_manufacturing_location;
	}
	/**
	 * @param part_manufacturing_location the part_manufacturing_location to set
	 */
	public void setPart_manufacturing_location(String part_manufacturing_location) {
		this.part_manufacturing_location = part_manufacturing_location;
	}
	/**
	 * @return the no_of_samples
	 */
	public String getNo_of_samples() {
		return no_of_samples;
	}
	/**
	 * @param no_of_samples the no_of_samples to set
	 */
	public void setNo_of_samples(String no_of_samples) {
		this.no_of_samples = no_of_samples;
	}
	/**
	 * @return the repeated_operation
	 */
	public String getRepeated_operation() {
		return repeated_operation;
	}
	/**
	 * @param repeated_operation the repeated_operation to set
	 */
	public void setRepeated_operation(String repeated_operation) {
		this.repeated_operation = repeated_operation;
	}
	/**
	 * @return the repeated_operation_duration
	 */
	public String getRepeated_operation_duration() {
		return repeated_operation_duration;
	}
	/**
	 * @param repeated_operation_duration the repeated_operation_duration to set
	 */
	public void setRepeated_operation_duration(String repeated_operation_duration) {
		this.repeated_operation_duration = repeated_operation_duration;
	}
	/**
	 * @return the ro_sample
	 */
	public String getRo_sample() {
		return ro_sample;
	}
	/**
	 * @param ro_sample the ro_sample to set
	 */
	public void setRo_sample(String ro_sample) {
		this.ro_sample = ro_sample;
	}
	/**
	 * @return the shower
	 */
	public String getShower() {
		return shower;
	}
	/**
	 * @param shower the shower to set
	 */
	public void setShower(String shower) {
		this.shower = shower;
	}
	/**
	 * @return the shower_duration
	 */
	public String getShower_duration() {
		return shower_duration;
	}
	/**
	 * @param shower_duration the shower_duration to set
	 */
	public void setShower_duration(String shower_duration) {
		this.shower_duration = shower_duration;
	}
	/**
	 * @return the shower_sample
	 */
	public String getShower_sample() {
		return shower_sample;
	}
	/**
	 * @param shower_sample the shower_sample to set
	 */
	public void setShower_sample(String shower_sample) {
		this.shower_sample = shower_sample;
	}
	/**
	 * @return the dust
	 */
	public String getDust() {
		return dust;
	}
	/**
	 * @param dust the dust to set
	 */
	public void setDust(String dust) {
		this.dust = dust;
	}
	/**
	 * @return the dust_duration
	 */
	public String getDust_duration() {
		return dust_duration;
	}
	/**
	 * @param dust_duration the dust_duration to set
	 */
	public void setDust_duration(String dust_duration) {
		this.dust_duration = dust_duration;
	}
	/**
	 * @return the dust_sample
	 */
	public String getDust_sample() {
		return dust_sample;
	}
	/**
	 * @param dust_sample the dust_sample to set
	 */
	public void setDust_sample(String dust_sample) {
		this.dust_sample = dust_sample;
	}
	/**
	 * @return the creation_date
	 */
	public String getCreation_date() {
		return creation_date;
	}
	/**
	 * @param creation_date the creation_date to set
	 */
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	/**
	 * @return the revised_date
	 */
	public String getRevised_date() {
		return revised_date;
	}
	/**
	 * @param revised_date the revised_date to set
	 */
	public void setRevised_date(String revised_date) {
		this.revised_date = revised_date;
	}
	/**
	 * @return the ro_testing_status
	 */
	public String getRo_testing_status() {
		return ro_testing_status;
	}
	/**
	 * @param ro_testing_status the ro_testing_status to set
	 */
	public void setRo_testing_status(String ro_testing_status) {
		this.ro_testing_status = ro_testing_status;
	}
	/**
	 * @return the shower_testing_status
	 */
	public String getShower_testing_status() {
		return shower_testing_status;
	}
	/**
	 * @param shower_testing_status the shower_testing_status to set
	 */
	public void setShower_testing_status(String shower_testing_status) {
		this.shower_testing_status = shower_testing_status;
	}
	/**
	 * @return the dust_testing_status
	 */
	public String getDust_testing_status() {
		return dust_testing_status;
	}
	/**
	 * @param dust_testing_status the dust_testing_status to set
	 */
	public void setDust_testing_status(String dust_testing_status) {
		this.dust_testing_status = dust_testing_status;
	}
	

}
