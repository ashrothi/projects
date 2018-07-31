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
 * This class contains response on /upload/inventory API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class UploadInventorySwagger {
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

	private List<UploadInventory> object;

	/**
	 * @return the object
	 */
	public List<UploadInventory> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<UploadInventory> object) {
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
 * TO get response parameter getter setter
 */
class UploadInventory {
	private String temp_planned_count;

	/**
	 * @return the temp_planned_count
	 */
	public String getTemp_planned_count() {
		return temp_planned_count;
	}

	/**
	 * @param temp_planned_count
	 *            the temp_planned_count to set
	 */
	public void setTemp_planned_count(String temp_planned_count) {
		this.temp_planned_count = temp_planned_count;
	}

}
