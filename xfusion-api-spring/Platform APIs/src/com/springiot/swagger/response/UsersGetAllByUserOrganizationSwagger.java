/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /users/get/all/by/user/organization API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class UsersGetAllByUserOrganizationSwagger {
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

	private List<UsersGetAllByUserOrganization> object;

	/**
	 * @return the object
	 */
	public List<UsersGetAllByUserOrganization> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<UsersGetAllByUserOrganization> object) {
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
 * Set the response parameters of /users/get/all/by/user/organization API.
 * 
 *
 */
class UsersGetAllByUserOrganization {
	// Initializing the variables
	private String user_keys;
	private String user_ids;

	/**
	 * @return the user_keys
	 */
	public String getUser_keys() {
		return user_keys;
	}

	/**
	 * @param user_keys
	 *            the user_keys to set
	 */
	public void setUser_keys(String user_keys) {
		this.user_keys = user_keys;
	}

	/**
	 * @return the user_ids
	 */
	public String getUser_ids() {
		return user_ids;
	}

	/**
	 * @param user_ids
	 *            the user_ids to set
	 */
	public void setUser_ids(String user_ids) {
		this.user_ids = user_ids;
	}

}