/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /rule/engine/device/get/severity API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class RuleEngineDeviceGetSeveritySwagger {
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

	private List<RuleEngineDeviceGetSeverity> object;

	/**
	 * @return the object
	 */
	public List<RuleEngineDeviceGetSeverity> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<RuleEngineDeviceGetSeverity> object) {
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
 * Set the response parameters of /rule/engine/device/get/severity API.
 * 
 *
 */
class RuleEngineDeviceGetSeverity {
	// Initializing the variables
	private Integer id;
	private Integer model_id;
	private String service_name;
	private String data_source_name;
	private String severity;
	private Integer priority;
	private Integer organization_id;
	private Integer service_id;
	private Integer data_source_id;
	private String color;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the model_id
	 */
	public Integer getModel_id() {
		return model_id;
	}

	/**
	 * @param model_id
	 *            the model_id to set
	 */
	public void setModel_id(Integer model_id) {
		this.model_id = model_id;
	}

	/**
	 * @return the service_name
	 */
	public String getService_name() {
		return service_name;
	}

	/**
	 * @param service_name
	 *            the service_name to set
	 */
	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	/**
	 * @return the data_source_name
	 */
	public String getData_source_name() {
		return data_source_name;
	}

	/**
	 * @param data_source_name
	 *            the data_source_name to set
	 */
	public void setData_source_name(String data_source_name) {
		this.data_source_name = data_source_name;
	}

	/**
	 * @return the severity
	 */
	public String getSeverity() {
		return severity;
	}

	/**
	 * @param severity
	 *            the severity to set
	 */
	public void setSeverity(String severity) {
		this.severity = severity;
	}

	/**
	 * @return the priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * @param priority
	 *            the priority to set
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * @return the organization_id
	 */
	public Integer getOrganization_id() {
		return organization_id;
	}

	/**
	 * @param organization_id
	 *            the organization_id to set
	 */
	public void setOrganization_id(Integer organization_id) {
		this.organization_id = organization_id;
	}

	/**
	 * @return the service_id
	 */
	public Integer getService_id() {
		return service_id;
	}

	/**
	 * @param service_id
	 *            the service_id to set
	 */
	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}

	/**
	 * @return the data_source_id
	 */
	public Integer getData_source_id() {
		return data_source_id;
	}

	/**
	 * @param data_source_id
	 *            the data_source_id to set
	 */
	public void setData_source_id(Integer data_source_id) {
		this.data_source_id = data_source_id;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color
	 *            the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

}