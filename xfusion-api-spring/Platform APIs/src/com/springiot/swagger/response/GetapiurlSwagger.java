/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /get/apiurl API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class GetapiurlSwagger {
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

	private List<Getapiurl> object;

	/**
	 * @return the object
	 */
	public List<Getapiurl> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<Getapiurl> object) {
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
 * Set the response parameters of /get/apiurl API.
 * 
 *
 */
class Getapiurl {
	// Initializing the variables
	private String is_added;
	private String url;

	/**
	 * @return the is_added
	 */
	public String getIs_added() {
		return is_added;
	}

	/**
	 * @param is_added
	 *            the is_added to set
	 */
	public void setIs_added(String is_added) {
		this.is_added = is_added;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

}
