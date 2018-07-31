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
 * This class contains response on /flint/live/tracking/get/all API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintLiveTrackingGetAllSwagger {
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

	private List<FlintLiveTrackingGetAll> object;

	/**
	 * @return the object
	 */
	public List<FlintLiveTrackingGetAll> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintLiveTrackingGetAll> object) {
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
class FlintLiveTrackingGetAll {
	private List<String> lat_long;
	private String device_id;
	private String check_timestamp;
	/**
	 * @return the lat_long
	 */
	public List<String> getLat_long() {
		return lat_long;
	}
	/**
	 * @param lat_long the lat_long to set
	 */
	public void setLat_long(List<String> lat_long) {
		this.lat_long = lat_long;
	}
	/**
	 * @return the device_id
	 */
	public String getDevice_id() {
		return device_id;
	}
	/**
	 * @param device_id the device_id to set
	 */
	public void setDevice_id(String device_id) {
		this.device_id = device_id;
	}
	/**
	 * @return the check_timestamp
	 */
	public String getCheck_timestamp() {
		return check_timestamp;
	}
	/**
	 * @param check_timestamp the check_timestamp to set
	 */
	public void setCheck_timestamp(String check_timestamp) {
		this.check_timestamp = check_timestamp;
	}

}
