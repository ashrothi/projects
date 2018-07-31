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
 * This class contains response on /inventory/component/get/list API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class InventoryComponentGetListSwagger {
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

	private List<InventoryComponentGetList> object;

	/**
	 * @return the object
	 */
	public List<InventoryComponentGetList> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<InventoryComponentGetList> object) {
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
class InventoryComponentGetList {
	private String id; 
	private String component_type; 
	private String component_name; 
	private String vehicle_model; 
	private String vendor_name; 
	private String vendor_code;
	private String part_number;
	private String hmcl_location; 
	private String vendor_test_location; 
	private String upload_date; 
	private String is_added_to_planner; 
	private String is_added_to_planner_ro; 
	private String is_added_to_planner_shower; 
	private String is_added_to_planner_dust; 
	private String count;
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
	 * @return the component_type
	 */
	public String getComponent_type() {
		return component_type;
	}
	/**
	 * @param component_type the component_type to set
	 */
	public void setComponent_type(String component_type) {
		this.component_type = component_type;
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
	 * @return the part_number
	 */
	public String getPart_number() {
		return part_number;
	}
	/**
	 * @param part_number the part_number to set
	 */
	public void setPart_number(String part_number) {
		this.part_number = part_number;
	}
	/**
	 * @return the hmcl_location
	 */
	public String getHmcl_location() {
		return hmcl_location;
	}
	/**
	 * @param hmcl_location the hmcl_location to set
	 */
	public void setHmcl_location(String hmcl_location) {
		this.hmcl_location = hmcl_location;
	}
	/**
	 * @return the vendor_test_location
	 */
	public String getVendor_test_location() {
		return vendor_test_location;
	}
	/**
	 * @param vendor_test_location the vendor_test_location to set
	 */
	public void setVendor_test_location(String vendor_test_location) {
		this.vendor_test_location = vendor_test_location;
	}
	/**
	 * @return the upload_date
	 */
	public String getUpload_date() {
		return upload_date;
	}
	/**
	 * @param upload_date the upload_date to set
	 */
	public void setUpload_date(String upload_date) {
		this.upload_date = upload_date;
	}
	/**
	 * @return the is_added_to_planner
	 */
	public String getIs_added_to_planner() {
		return is_added_to_planner;
	}
	/**
	 * @param is_added_to_planner the is_added_to_planner to set
	 */
	public void setIs_added_to_planner(String is_added_to_planner) {
		this.is_added_to_planner = is_added_to_planner;
	}
	/**
	 * @return the is_added_to_planner_ro
	 */
	public String getIs_added_to_planner_ro() {
		return is_added_to_planner_ro;
	}
	/**
	 * @param is_added_to_planner_ro the is_added_to_planner_ro to set
	 */
	public void setIs_added_to_planner_ro(String is_added_to_planner_ro) {
		this.is_added_to_planner_ro = is_added_to_planner_ro;
	}
	/**
	 * @return the is_added_to_planner_shower
	 */
	public String getIs_added_to_planner_shower() {
		return is_added_to_planner_shower;
	}
	/**
	 * @param is_added_to_planner_shower the is_added_to_planner_shower to set
	 */
	public void setIs_added_to_planner_shower(String is_added_to_planner_shower) {
		this.is_added_to_planner_shower = is_added_to_planner_shower;
	}
	/**
	 * @return the is_added_to_planner_dust
	 */
	public String getIs_added_to_planner_dust() {
		return is_added_to_planner_dust;
	}
	/**
	 * @param is_added_to_planner_dust the is_added_to_planner_dust to set
	 */
	public void setIs_added_to_planner_dust(String is_added_to_planner_dust) {
		this.is_added_to_planner_dust = is_added_to_planner_dust;
	}
	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	} 
	

}
