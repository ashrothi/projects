/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /dashboard/main/get/command/count API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DashboardMainGetCommandCountSwagger {
	private String description;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private List<DashboardMainGetCommandCount> object;

	/**
	 * @return the object
	 */
	public List<DashboardMainGetCommandCount> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardMainGetCommandCount> object) {
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

/**
 * Set the response parameters of /dashboard/main/get/command/count API.
 * 
 *
 */
class DashboardMainGetCommandCount {
	// Initializing the variables
	private Integer command_total_count;
	private Integer command_active_count;
	private Integer command_response_count;
	private Float command_active_count_percentage;
	private Float command_response_countd_percentage;
	/**
	 * @return the command_total_count
	 */
	public Integer getCommand_total_count() {
		return command_total_count;
	}
	/**
	 * @param command_total_count the command_total_count to set
	 */
	public void setCommand_total_count(Integer command_total_count) {
		this.command_total_count = command_total_count;
	}
	/**
	 * @return the command_active_count
	 */
	public Integer getCommand_active_count() {
		return command_active_count;
	}
	/**
	 * @param command_active_count the command_active_count to set
	 */
	public void setCommand_active_count(Integer command_active_count) {
		this.command_active_count = command_active_count;
	}
	/**
	 * @return the command_response_count
	 */
	public Integer getCommand_response_count() {
		return command_response_count;
	}
	/**
	 * @param command_response_count the command_response_count to set
	 */
	public void setCommand_response_count(Integer command_response_count) {
		this.command_response_count = command_response_count;
	}
	/**
	 * @return the command_active_count_percentage
	 */
	public Float getCommand_active_count_percentage() {
		return command_active_count_percentage;
	}
	/**
	 * @param command_active_count_percentage the command_active_count_percentage to set
	 */
	public void setCommand_active_count_percentage(Float command_active_count_percentage) {
		this.command_active_count_percentage = command_active_count_percentage;
	}
	/**
	 * @return the command_response_countd_percentage
	 */
	public Float getCommand_response_countd_percentage() {
		return command_response_countd_percentage;
	}
	/**
	 * @param command_response_countd_percentage the command_response_countd_percentage to set
	 */
	public void setCommand_response_countd_percentage(Float command_response_countd_percentage) {
		this.command_response_countd_percentage = command_response_countd_percentage;
	}
	
}