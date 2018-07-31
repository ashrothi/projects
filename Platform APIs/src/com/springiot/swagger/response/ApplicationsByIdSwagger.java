/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /applications/by/id API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class ApplicationsByIdSwagger {
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

	private List<ApplicationsById> object;

	/**
	 * @return the object
	 */
	public List<ApplicationsById> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<ApplicationsById> object) {
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
 * Set the response parameters of /applications/by/id API.
 * 
 *
 */
class ApplicationsById {
	// Initializing the variables
	private String application_key;
	private String applications_alias;
	private String applications_id;
	private String applications_name;
	private String membership_email;
	private String roles_access_key;
	private String roles_alias;
	private String roles_id;
	private String roles_name;
	private String users_id;
	private String users_name;
	private String users_user_key;

	/**
	 * @return the application_key
	 */
	public String getApplication_key() {
		return application_key;
	}

	/**
	 * @param application_key
	 *            the application_key to set
	 */
	public void setApplication_key(String application_key) {
		this.application_key = application_key;
	}

	/**
	 * @return the applications_alias
	 */
	public String getApplications_alias() {
		return applications_alias;
	}

	/**
	 * @param applications_alias
	 *            the applications_alias to set
	 */
	public void setApplications_alias(String applications_alias) {
		this.applications_alias = applications_alias;
	}

	/**
	 * @return the applications_id
	 */
	public String getApplications_id() {
		return applications_id;
	}

	/**
	 * @param applications_id
	 *            the applications_id to set
	 */
	public void setApplications_id(String applications_id) {
		this.applications_id = applications_id;
	}

	/**
	 * @return the applications_name
	 */
	public String getApplications_name() {
		return applications_name;
	}

	/**
	 * @param applications_name
	 *            the applications_name to set
	 */
	public void setApplications_name(String applications_name) {
		this.applications_name = applications_name;
	}

	/**
	 * @return the membership_email
	 */
	public String getMembership_email() {
		return membership_email;
	}

	/**
	 * @param membership_email
	 *            the membership_email to set
	 */
	public void setMembership_email(String membership_email) {
		this.membership_email = membership_email;
	}

	/**
	 * @return the roles_access_key
	 */
	public String getRoles_access_key() {
		return roles_access_key;
	}

	/**
	 * @param roles_access_key
	 *            the roles_access_key to set
	 */
	public void setRoles_access_key(String roles_access_key) {
		this.roles_access_key = roles_access_key;
	}

	/**
	 * @return the roles_alias
	 */
	public String getRoles_alias() {
		return roles_alias;
	}

	/**
	 * @param roles_alias
	 *            the roles_alias to set
	 */
	public void setRoles_alias(String roles_alias) {
		this.roles_alias = roles_alias;
	}

	/**
	 * @return the roles_id
	 */
	public String getRoles_id() {
		return roles_id;
	}

	/**
	 * @param roles_id
	 *            the roles_id to set
	 */
	public void setRoles_id(String roles_id) {
		this.roles_id = roles_id;
	}

	/**
	 * @return the roles_name
	 */
	public String getRoles_name() {
		return roles_name;
	}

	/**
	 * @param roles_name
	 *            the roles_name to set
	 */
	public void setRoles_name(String roles_name) {
		this.roles_name = roles_name;
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