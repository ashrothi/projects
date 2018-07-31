/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /users/get/all/by/application/key API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class UsersGetAllByApplicationKeySwagger {
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

/**
 * Set the response parameters of /users/get/all/by/application/key API.
 * 
 *
 */
class UsersGetAllByApplicationKey {

	private String user_key;
	private String user_id;
	private String role_alias;
	private String access_key;

	/**
	 * @return the user_key
	 */
	public String getUser_key() {
		return user_key;
	}

	/**
	 * @param user_key
	 *            the user_key to set
	 */
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}

	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}

	/**
	 * @param user_id
	 *            the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	/**
	 * @return the role_alias
	 */
	public String getRole_alias() {
		return role_alias;
	}

	/**
	 * @param role_alias
	 *            the role_alias to set
	 */
	public void setRole_alias(String role_alias) {
		this.role_alias = role_alias;
	}

	/**
	 * @return the access_key
	 */
	public String getAccess_key() {
		return access_key;
	}

	/**
	 * @param access_key
	 *            the access_key to set
	 */
	public void setAccess_key(String access_key) {
		this.access_key = access_key;
	}

}