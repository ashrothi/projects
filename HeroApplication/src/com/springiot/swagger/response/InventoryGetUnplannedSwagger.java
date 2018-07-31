/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
import java.util.Date;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
/**
 * 
 * This class contains response on /inventory/get/unplanned API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class InventoryGetUnplannedSwagger {
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

	private List<InventoryGetUnplanned> object;

	/**
	 * @return the object
	 */
	public List<InventoryGetUnplanned> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<InventoryGetUnplanned> object) {
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
class InventoryGetUnplanned {
	private int id; 
	private String planner_name; 
	private String planner_number; 
	private String planner_version; 
	private String component_name; 
	private String component_type; 
	private int vendor_id; 
	private String part_number; 
	private String hmcl_location; 
	private int is_added_to_planner;
	private int no_of_sample_ro; 
	private String description; 
	private int repeated_operation;
	private int vibration;
	private int shower;
	private int dust;
	private int thermal_cycle;
	private int thermal_shock;
	private int humidity;
	private int low_high_temp_operation;
	private int low_high_temp_storage;
	private long lot_no;
	private int no_of_sample_sw;
	private int no_of_sample_ds;
	private String plannner_name_number; 
	private int vendor_code; 
	private String vendor_name; 
	private String vendor_code_name; 
	private int component_type_id;
	private String testing_id; 
	private int location_id; 
	private Date creation_date;
	private int is_added_to_planner_ro; 
	private int is_added_to_planner_shower; 
	private int is_added_to_planner_dust;
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
	 * @return the vendor_id
	 */
	public int getVendor_id() {
		return vendor_id;
	}
	/**
	 * @param vendor_id the vendor_id to set
	 */
	public void setVendor_id(int vendor_id) {
		this.vendor_id = vendor_id;
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
	 * @return the is_added_to_planner
	 */
	public int getIs_added_to_planner() {
		return is_added_to_planner;
	}
	/**
	 * @param is_added_to_planner the is_added_to_planner to set
	 */
	public void setIs_added_to_planner(int is_added_to_planner) {
		this.is_added_to_planner = is_added_to_planner;
	}
	/**
	 * @return the no_of_sample_ro
	 */
	public int getNo_of_sample_ro() {
		return no_of_sample_ro;
	}
	/**
	 * @param no_of_sample_ro the no_of_sample_ro to set
	 */
	public void setNo_of_sample_ro(int no_of_sample_ro) {
		this.no_of_sample_ro = no_of_sample_ro;
	}
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
	 * @return the repeated_operation
	 */
	public int getRepeated_operation() {
		return repeated_operation;
	}
	/**
	 * @param repeated_operation the repeated_operation to set
	 */
	public void setRepeated_operation(int repeated_operation) {
		this.repeated_operation = repeated_operation;
	}
	/**
	 * @return the vibration
	 */
	public int getVibration() {
		return vibration;
	}
	/**
	 * @param vibration the vibration to set
	 */
	public void setVibration(int vibration) {
		this.vibration = vibration;
	}
	/**
	 * @return the shower
	 */
	public int getShower() {
		return shower;
	}
	/**
	 * @param shower the shower to set
	 */
	public void setShower(int shower) {
		this.shower = shower;
	}
	/**
	 * @return the dust
	 */
	public int getDust() {
		return dust;
	}
	/**
	 * @param dust the dust to set
	 */
	public void setDust(int dust) {
		this.dust = dust;
	}
	/**
	 * @return the thermal_cycle
	 */
	public int getThermal_cycle() {
		return thermal_cycle;
	}
	/**
	 * @param thermal_cycle the thermal_cycle to set
	 */
	public void setThermal_cycle(int thermal_cycle) {
		this.thermal_cycle = thermal_cycle;
	}
	/**
	 * @return the thermal_shock
	 */
	public int getThermal_shock() {
		return thermal_shock;
	}
	/**
	 * @param thermal_shock the thermal_shock to set
	 */
	public void setThermal_shock(int thermal_shock) {
		this.thermal_shock = thermal_shock;
	}
	/**
	 * @return the humidity
	 */
	public int getHumidity() {
		return humidity;
	}
	/**
	 * @param humidity the humidity to set
	 */
	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}
	/**
	 * @return the low_high_temp_operation
	 */
	public int getLow_high_temp_operation() {
		return low_high_temp_operation;
	}
	/**
	 * @param low_high_temp_operation the low_high_temp_operation to set
	 */
	public void setLow_high_temp_operation(int low_high_temp_operation) {
		this.low_high_temp_operation = low_high_temp_operation;
	}
	/**
	 * @return the low_high_temp_storage
	 */
	public int getLow_high_temp_storage() {
		return low_high_temp_storage;
	}
	/**
	 * @param low_high_temp_storage the low_high_temp_storage to set
	 */
	public void setLow_high_temp_storage(int low_high_temp_storage) {
		this.low_high_temp_storage = low_high_temp_storage;
	}
	/**
	 * @return the lot_no
	 */
	public long getLot_no() {
		return lot_no;
	}
	/**
	 * @param lot_no the lot_no to set
	 */
	public void setLot_no(long lot_no) {
		this.lot_no = lot_no;
	}
	/**
	 * @return the no_of_sample_sw
	 */
	public int getNo_of_sample_sw() {
		return no_of_sample_sw;
	}
	/**
	 * @param no_of_sample_sw the no_of_sample_sw to set
	 */
	public void setNo_of_sample_sw(int no_of_sample_sw) {
		this.no_of_sample_sw = no_of_sample_sw;
	}
	/**
	 * @return the no_of_sample_ds
	 */
	public int getNo_of_sample_ds() {
		return no_of_sample_ds;
	}
	/**
	 * @param no_of_sample_ds the no_of_sample_ds to set
	 */
	public void setNo_of_sample_ds(int no_of_sample_ds) {
		this.no_of_sample_ds = no_of_sample_ds;
	}
	/**
	 * @return the plannner_name_number
	 */
	public String getPlannner_name_number() {
		return plannner_name_number;
	}
	/**
	 * @param plannner_name_number the plannner_name_number to set
	 */
	public void setPlannner_name_number(String plannner_name_number) {
		this.plannner_name_number = plannner_name_number;
	}
	/**
	 * @return the vendor_code
	 */
	public int getVendor_code() {
		return vendor_code;
	}
	/**
	 * @param vendor_code the vendor_code to set
	 */
	public void setVendor_code(int vendor_code) {
		this.vendor_code = vendor_code;
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
	 * @return the vendor_code_name
	 */
	public String getVendor_code_name() {
		return vendor_code_name;
	}
	/**
	 * @param vendor_code_name the vendor_code_name to set
	 */
	public void setVendor_code_name(String vendor_code_name) {
		this.vendor_code_name = vendor_code_name;
	}
	/**
	 * @return the component_type_id
	 */
	public int getComponent_type_id() {
		return component_type_id;
	}
	/**
	 * @param component_type_id the component_type_id to set
	 */
	public void setComponent_type_id(int component_type_id) {
		this.component_type_id = component_type_id;
	}
	/**
	 * @return the testing_id
	 */
	public String getTesting_id() {
		return testing_id;
	}
	/**
	 * @param testing_id the testing_id to set
	 */
	public void setTesting_id(String testing_id) {
		this.testing_id = testing_id;
	}
	/**
	 * @return the location_id
	 */
	public int getLocation_id() {
		return location_id;
	}
	/**
	 * @param location_id the location_id to set
	 */
	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}
	/**
	 * @return the creation_date
	 */
	public Date getCreation_date() {
		return creation_date;
	}
	/**
	 * @param creation_date the creation_date to set
	 */
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	/**
	 * @return the is_added_to_planner_ro
	 */
	public int getIs_added_to_planner_ro() {
		return is_added_to_planner_ro;
	}
	/**
	 * @param is_added_to_planner_ro the is_added_to_planner_ro to set
	 */
	public void setIs_added_to_planner_ro(int is_added_to_planner_ro) {
		this.is_added_to_planner_ro = is_added_to_planner_ro;
	}
	/**
	 * @return the is_added_to_planner_shower
	 */
	public int getIs_added_to_planner_shower() {
		return is_added_to_planner_shower;
	}
	/**
	 * @param is_added_to_planner_shower the is_added_to_planner_shower to set
	 */
	public void setIs_added_to_planner_shower(int is_added_to_planner_shower) {
		this.is_added_to_planner_shower = is_added_to_planner_shower;
	}
	/**
	 * @return the is_added_to_planner_dust
	 */
	public int getIs_added_to_planner_dust() {
		return is_added_to_planner_dust;
	}
	/**
	 * @param is_added_to_planner_dust the is_added_to_planner_dust to set
	 */
	public void setIs_added_to_planner_dust(int is_added_to_planner_dust) {
		this.is_added_to_planner_dust = is_added_to_planner_dust;
	}
	
	

}
