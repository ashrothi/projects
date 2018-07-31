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
 * This class contains response on /component/get/setting/history API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class ComponentGetSettingHistorySwagger {
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

	private List<ComponentGetSettingHistory> object;

	/**
	 * @return the object
	 */
	public List<ComponentGetSettingHistory> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<ComponentGetSettingHistory> object) {
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
class ComponentGetSettingHistory {
	private int id; 
	private int no_of_cycles_to_log; 
	private int total_testing_hours; 
	private int running_hours_per_day; 
	private int total_available_days; 
	private long last_modified_date; 
	private int is_updated; 
	private int component_type_id; 
	private int testing_id; 
	private int update_reason_id; 
	private String component_name; 
	private String component_type; 
	private String description; 
	private String testing_type;
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
	 * @return the no_of_cycles_to_log
	 */
	public int getNo_of_cycles_to_log() {
		return no_of_cycles_to_log;
	}
	/**
	 * @param no_of_cycles_to_log the no_of_cycles_to_log to set
	 */
	public void setNo_of_cycles_to_log(int no_of_cycles_to_log) {
		this.no_of_cycles_to_log = no_of_cycles_to_log;
	}
	/**
	 * @return the total_testing_hours
	 */
	public int getTotal_testing_hours() {
		return total_testing_hours;
	}
	/**
	 * @param total_testing_hours the total_testing_hours to set
	 */
	public void setTotal_testing_hours(int total_testing_hours) {
		this.total_testing_hours = total_testing_hours;
	}
	/**
	 * @return the running_hours_per_day
	 */
	public int getRunning_hours_per_day() {
		return running_hours_per_day;
	}
	/**
	 * @param running_hours_per_day the running_hours_per_day to set
	 */
	public void setRunning_hours_per_day(int running_hours_per_day) {
		this.running_hours_per_day = running_hours_per_day;
	}
	/**
	 * @return the total_available_days
	 */
	public int getTotal_available_days() {
		return total_available_days;
	}
	/**
	 * @param total_available_days the total_available_days to set
	 */
	public void setTotal_available_days(int total_available_days) {
		this.total_available_days = total_available_days;
	}
	/**
	 * @return the last_modified_date
	 */
	public long getLast_modified_date() {
		return last_modified_date;
	}
	/**
	 * @param last_modified_date the last_modified_date to set
	 */
	public void setLast_modified_date(long last_modified_date) {
		this.last_modified_date = last_modified_date;
	}
	/**
	 * @return the is_updated
	 */
	public int getIs_updated() {
		return is_updated;
	}
	/**
	 * @param is_updated the is_updated to set
	 */
	public void setIs_updated(int is_updated) {
		this.is_updated = is_updated;
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
	public int getTesting_id() {
		return testing_id;
	}
	/**
	 * @param testing_id the testing_id to set
	 */
	public void setTesting_id(int testing_id) {
		this.testing_id = testing_id;
	}
	/**
	 * @return the update_reason_id
	 */
	public int getUpdate_reason_id() {
		return update_reason_id;
	}
	/**
	 * @param update_reason_id the update_reason_id to set
	 */
	public void setUpdate_reason_id(int update_reason_id) {
		this.update_reason_id = update_reason_id;
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
	 * @return the testing_type
	 */
	public String getTesting_type() {
		return testing_type;
	}
	/**
	 * @param testing_type the testing_type to set
	 */
	public void setTesting_type(String testing_type) {
		this.testing_type = testing_type;
	} 
	
	

}
