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
 * This class contains response on /planner/equipment/get/detail API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class PlannerEquipmentGetDetailSwagger {
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

	private List<PlannerEquipmentGetDetail> object;

	/**
	 * @return the object
	 */
	public List<PlannerEquipmentGetDetail> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<PlannerEquipmentGetDetail> object) {
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
class PlannerEquipmentGetDetail {

	private String equipment;
	private String running_hours_per_day;
	private String total_testing_day;
	private String total_testing_hours;
	private String equipment_engagement_plan;
	private String creation_date;
	private String is_submitted;
	/**
	 * @return the equipment
	 */
	public String getEquipment() {
		return equipment;
	}
	/**
	 * @param equipment the equipment to set
	 */
	public void setEquipment(String equipment) {
		this.equipment = equipment;
	}
	/**
	 * @return the running_hours_per_day
	 */
	public String getRunning_hours_per_day() {
		return running_hours_per_day;
	}
	/**
	 * @param running_hours_per_day the running_hours_per_day to set
	 */
	public void setRunning_hours_per_day(String running_hours_per_day) {
		this.running_hours_per_day = running_hours_per_day;
	}
	/**
	 * @return the total_testing_day
	 */
	public String getTotal_testing_day() {
		return total_testing_day;
	}
	/**
	 * @param total_testing_day the total_testing_day to set
	 */
	public void setTotal_testing_day(String total_testing_day) {
		this.total_testing_day = total_testing_day;
	}
	/**
	 * @return the total_testing_hours
	 */
	public String getTotal_testing_hours() {
		return total_testing_hours;
	}
	/**
	 * @param total_testing_hours the total_testing_hours to set
	 */
	public void setTotal_testing_hours(String total_testing_hours) {
		this.total_testing_hours = total_testing_hours;
	}
	/**
	 * @return the equipment_engagement_plan
	 */
	public String getEquipment_engagement_plan() {
		return equipment_engagement_plan;
	}
	/**
	 * @param equipment_engagement_plan the equipment_engagement_plan to set
	 */
	public void setEquipment_engagement_plan(String equipment_engagement_plan) {
		this.equipment_engagement_plan = equipment_engagement_plan;
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
	 * @return the is_submitted
	 */
	public String getIs_submitted() {
		return is_submitted;
	}
	/**
	 * @param is_submitted the is_submitted to set
	 */
	public void setIs_submitted(String is_submitted) {
		this.is_submitted = is_submitted;
	}
	
}
