/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /device/get/properties API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetPropertiesSwagger {
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

	private List<DeviceGetProperties> object;

	/**
	 * @return the object
	 */
	public List<DeviceGetProperties> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceGetProperties> object) {
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
 * Set the response parameters of /device/get/tags/by/model API.
 * 
 *
 */
class DeviceGetProperties {
	// Initializing the variables
	private Integer id;
	private String alias;
	private String data_type_name;
	private String name;
	private String data_type;

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
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias
	 *            the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the data_type_name
	 */
	public String getData_type_name() {
		return data_type_name;
	}

	/**
	 * @param data_type_name
	 *            the data_type_name to set
	 */
	public void setData_type_name(String data_type_name) {
		this.data_type_name = data_type_name;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the data_type
	 */
	public String getData_type() {
		return data_type;
	}

	/**
	 * @param data_type
	 *            the data_type to set
	 */
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

}