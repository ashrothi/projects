/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /inventory/monthly/device/get/many/count API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class InventoryMonthlyDeviceGetManyCountSwagger {
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

	private List<InventoryMonthlyDeviceGetManyCount> object;

	/**
	 * @return the object
	 */
	public List<InventoryMonthlyDeviceGetManyCount> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<InventoryMonthlyDeviceGetManyCount> object) {
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
 * Set the response parameters of /inventory/monthly/device/get/many/count API.
 * 
 *
 */
class InventoryMonthlyDeviceGetManyCount {
	// Initializing the variables
	private Integer count;

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

}