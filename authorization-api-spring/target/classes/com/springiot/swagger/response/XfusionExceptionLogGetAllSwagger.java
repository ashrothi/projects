/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /xfusion/exception/log/get/all API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class XfusionExceptionLogGetAllSwagger {
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

	private List<XfusionExceptionLogGetAll> object;

	/**
	 * @return the object
	 */
	public List<XfusionExceptionLogGetAll> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<XfusionExceptionLogGetAll> object) {
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
 * Set the response parameters of /xfusion/exception/log/get/all API.
 * 
 * @author tanvigarg
 *
 */
class XfusionExceptionLogGetAll {
	
}
