/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

public class RolesGetAllByUserApplicationIdSwagger {
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

	private List<UsersGetAllByApplicationKey> object;

	/**
	 * @return the object
	 */
	public List<UsersGetAllByApplicationKey> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<UsersGetAllByApplicationKey> object) {
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

class RolesGetAllByUserApplicationId {
	private String users_name;
	private String users_user_key;

	/**
	 * @return the users_name
	 */
	public String getUsers_name() {
		return users_name;
	}

	/**
	 * @param users_name
	 *            the users_name to set
	 */
	public void setUsers_name(String users_name) {
		this.users_name = users_name;
	}

	/**
	 * @return the users_user_key
	 */
	public String getUsers_user_key() {
		return users_user_key;
	}

	/**
	 * @param users_user_key
	 *            the users_user_key to set
	 */
	public void setUsers_user_key(String users_user_key) {
		this.users_user_key = users_user_key;
	}

}