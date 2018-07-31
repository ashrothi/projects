
/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /oauth/validate/token API response
 * 
 * 
 * @author tanvigarg
 *
 */

public class ValidateTokenSwagger {
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

	private List<ValidateToken> object;

	/**
	 * @return the object
	 */
	public List<ValidateToken> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<ValidateToken> object) {
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

class ValidateToken {
	private Integer no_of_users;

	/**
	 * @return the no_of_users
	 */
	public Integer getNo_of_users() {
		return no_of_users;
	}

	/**
	 * @param no_of_users
	 *            the no_of_users to set
	 */
	public void setNo_of_users(Integer no_of_users) {
		this.no_of_users = no_of_users;
	}

}