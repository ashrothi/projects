/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /users/list API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class UsersListSwagger {
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

	private List<UsersList> object;

	/**
	 * @return the object
	 */
	public List<UsersList> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<UsersList> object) {
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
 * Set the response parameters of /users/list API.
 * 
 *
 */

class UsersList {
	// Initializing the variables
	private String role_name;
	private String organization_alias;
	private String users_id;
	private Integer organization_ids;
	private String userKey;

	/**
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}

	/**
	 * @param role_name
	 *            the role_name to set
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}

	/**
	 * @return the organization_alias
	 */
	public String getOrganization_alias() {
		return organization_alias;
	}

	/**
	 * @param organization_alias
	 *            the organization_alias to set
	 */
	public void setOrganization_alias(String organization_alias) {
		this.organization_alias = organization_alias;
	}

	/**
	 * @return the users_id
	 */
	public String getUsers_id() {
		return users_id;
	}

	/**
	 * @param users_id
	 *            the users_id to set
	 */
	public void setUsers_id(String users_id) {
		this.users_id = users_id;
	}

	/**
	 * @return the organization_ids
	 */
	public Integer getOrganization_ids() {
		return organization_ids;
	}

	/**
	 * @param organization_ids
	 *            the organization_ids to set
	 */
	public void setOrganization_ids(Integer organization_ids) {
		this.organization_ids = organization_ids;
	}

	/**
	 * @return the userKey
	 */
	public String getUserKey() {
		return userKey;
	}

	/**
	 * @param userKey
	 *            the userKey to set
	 */
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}

}