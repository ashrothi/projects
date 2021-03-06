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
 * This class contains response of /binatone/model/add/file API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class BinatoneModelAddFileSwagger {
	// Initialize the variable
	private String description;

	/*
	 * Getter method of description
	 */
	public String getDescription() {
		return description;
	}

	/*
	 * Setter method of description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	// Initialize the variable
	private List<BinatoneModelAddFile> object;

	/*
	 * Getter method of List<Object>
	 */
	public List<BinatoneModelAddFile> getObject() {
		return object;
	}

	/*
	 * Setter method of List<Object>
	 */
	public void setObject(List<BinatoneModelAddFile> object) {
		this.object = object;
	}

	// Initialize the variable
	private boolean valid;

	/*
	 * Getter method of boolean value isValid
	 */
	public boolean isValid() {
		return valid;
	}

	/*
	 * Setter method to set boolean value isValid
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}
/**
 * Set the response parameters of /binatone/model/add/file API.
 * 
 * @author tanvigarg
 *
 */
class BinatoneModelAddFile {

}