/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /rule/engine/device/type/get/model/services
 * API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class RuleEngineDeviceGetModelServicesSwagger {
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

	private List<RuleEngineDeviceGetModelServices> object;

	/**
	 * @return the object
	 */
	public List<RuleEngineDeviceGetModelServices> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<RuleEngineDeviceGetModelServices> object) {
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
 * Set the response parameters of /rule/engine/device/type/get/model/services
 * API.
 * 
 *
 */
class RuleEngineDeviceGetModelServices {
	// Initializing the variables
	private Integer service_service_id;
	private String service_service_alias;
	private String service_service_name;
	private String service_service_category;

	/**
	 * @return the service_service_id
	 */
	public Integer getService_service_id() {
		return service_service_id;
	}

	/**
	 * @param service_service_id
	 *            the service_service_id to set
	 */
	public void setService_service_id(Integer service_service_id) {
		this.service_service_id = service_service_id;
	}

	/**
	 * @return the service_service_alias
	 */
	public String getService_service_alias() {
		return service_service_alias;
	}

	/**
	 * @param service_service_alias
	 *            the service_service_alias to set
	 */
	public void setService_service_alias(String service_service_alias) {
		this.service_service_alias = service_service_alias;
	}

	/**
	 * @return the service_service_name
	 */
	public String getService_service_name() {
		return service_service_name;
	}

	/**
	 * @param service_service_name
	 *            the service_service_name to set
	 */
	public void setService_service_name(String service_service_name) {
		this.service_service_name = service_service_name;
	}

	/**
	 * @return the service_service_category
	 */
	public String getService_service_category() {
		return service_service_category;
	}

	/**
	 * @param service_service_category
	 *            the service_service_category to set
	 */
	public void setService_service_category(String service_service_category) {
		this.service_service_category = service_service_category;
	}

}