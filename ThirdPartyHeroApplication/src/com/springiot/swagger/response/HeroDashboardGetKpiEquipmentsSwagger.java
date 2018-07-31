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
 * This class contains response on /hero/dashboard/get/kpi/equipments API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroDashboardGetKpiEquipmentsSwagger {
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

	private List<HeroDashboardGetKpiEquipments> object;

	/**
	 * @return the object
	 */
	public List<HeroDashboardGetKpiEquipments> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroDashboardGetKpiEquipments> object) {
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
class HeroDashboardGetKpiEquipments {
	private String equipment;
	private String total_hours_month;
	private String total_testing_hours;
	private String completed_hours;
	private String test_name;
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
	 * @return the total_hours_month
	 */
	public String getTotal_hours_month() {
		return total_hours_month;
	}
	/**
	 * @param total_hours_month the total_hours_month to set
	 */
	public void setTotal_hours_month(String total_hours_month) {
		this.total_hours_month = total_hours_month;
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
	 * @return the completed_hours
	 */
	public String getCompleted_hours() {
		return completed_hours;
	}
	/**
	 * @param completed_hours the completed_hours to set
	 */
	public void setCompleted_hours(String completed_hours) {
		this.completed_hours = completed_hours;
	}
	/**
	 * @return the test_name
	 */
	public String getTest_name() {
		return test_name;
	}
	/**
	 * @param test_name the test_name to set
	 */
	public void setTest_name(String test_name) {
		this.test_name = test_name;
	}
	

}
