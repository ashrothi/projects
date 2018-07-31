/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /device/get/metadata/status/by/type/count API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceGetMetadataStatusByTypeCountSwagger {
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

	private List<DeviceGetMetadataStatusByTypeCount> object;

	/**
	 * @return the object
	 */
	public List<DeviceGetMetadataStatusByTypeCount> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DeviceGetMetadataStatusByTypeCount> object) {
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
 * Set the response parameters of /device/get/metadata/status/by/type/count API.
 * 
 *
 */
class DeviceGetMetadataStatusByTypeCount {
	// Initializing the variables
	private Integer up_count;
	private Integer down_count;
	private Integer all_count;
	private Integer unknown_count;

	/**
	 * @return the up_count
	 */
	public Integer getUp_count() {
		return up_count;
	}

	/**
	 * @param up_count
	 *            the up_count to set
	 */
	public void setUp_count(Integer up_count) {
		this.up_count = up_count;
	}

	/**
	 * @return the down_count
	 */
	public Integer getDown_count() {
		return down_count;
	}

	/**
	 * @param down_count
	 *            the down_count to set
	 */
	public void setDown_count(Integer down_count) {
		this.down_count = down_count;
	}

	/**
	 * @return the all_count
	 */
	public Integer getAll_count() {
		return all_count;
	}

	/**
	 * @param all_count
	 *            the all_count to set
	 */
	public void setAll_count(Integer all_count) {
		this.all_count = all_count;
	}

	/**
	 * @return the unknown_count
	 */
	public Integer getUnknown_count() {
		return unknown_count;
	}

	/**
	 * @param unknown_count
	 *            the unknown_count to set
	 */
	public void setUnknown_count(Integer unknown_count) {
		this.unknown_count = unknown_count;
	}

}