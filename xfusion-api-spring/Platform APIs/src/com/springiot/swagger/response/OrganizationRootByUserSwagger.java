/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /organization/root/by/user API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class OrganizationRootByUserSwagger {
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

	private List<OrganizationRootByUser> object;

	/**
	 * @return the object
	 */
	public List<OrganizationRootByUser> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<OrganizationRootByUser> object) {
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

class OrganizationRootByUser {
	// Initializing the variables
	private String organization_city;
	private int organization_password_expire_time;
	private String organization_alias;
	private int organization_is_single_sign_on_enable;
	private String organization_name;

	private int organization_is_session_enable;
	private String organization_description;
	private int organization_is_password_expire;
	private int organization_id;
	private String organization_color;
	private String organization_country;
	private int organization_session_expire_time;

	/**
	 * @return the organization_city
	 */
	public String getOrganization_city() {
		return organization_city;
	}

	/**
	 * @param organization_city
	 *            the organization_city to set
	 */
	public void setOrganization_city(String organization_city) {
		this.organization_city = organization_city;
	}

	/**
	 * @return the organization_password_expire_time
	 */
	public int getOrganization_password_expire_time() {
		return organization_password_expire_time;
	}

	/**
	 * @param organization_password_expire_time
	 *            the organization_password_expire_time to set
	 */
	public void setOrganization_password_expire_time(int organization_password_expire_time) {
		this.organization_password_expire_time = organization_password_expire_time;
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
	 * @return the organization_is_single_sign_on_enable
	 */
	public int getOrganization_is_single_sign_on_enable() {
		return organization_is_single_sign_on_enable;
	}

	/**
	 * @param organization_is_single_sign_on_enable
	 *            the organization_is_single_sign_on_enable to set
	 */
	public void setOrganization_is_single_sign_on_enable(int organization_is_single_sign_on_enable) {
		this.organization_is_single_sign_on_enable = organization_is_single_sign_on_enable;
	}

	/**
	 * @return the organization_name
	 */
	public String getOrganization_name() {
		return organization_name;
	}

	/**
	 * @param organization_name
	 *            the organization_name to set
	 */
	public void setOrganization_name(String organization_name) {
		this.organization_name = organization_name;
	}

	/**
	 * @return the organization_is_session_enable
	 */
	public int getOrganization_is_session_enable() {
		return organization_is_session_enable;
	}

	/**
	 * @param organization_is_session_enable
	 *            the organization_is_session_enable to set
	 */
	public void setOrganization_is_session_enable(int organization_is_session_enable) {
		this.organization_is_session_enable = organization_is_session_enable;
	}

	/**
	 * @return the organization_description
	 */
	public String getOrganization_description() {
		return organization_description;
	}

	/**
	 * @param organization_description
	 *            the organization_description to set
	 */
	public void setOrganization_description(String organization_description) {
		this.organization_description = organization_description;
	}

	/**
	 * @return the organization_is_password_expire
	 */
	public int getOrganization_is_password_expire() {
		return organization_is_password_expire;
	}

	/**
	 * @param organization_is_password_expire
	 *            the organization_is_password_expire to set
	 */
	public void setOrganization_is_password_expire(int organization_is_password_expire) {
		this.organization_is_password_expire = organization_is_password_expire;
	}

	/**
	 * @return the organization_id
	 */
	public int getOrganization_id() {
		return organization_id;
	}

	/**
	 * @param organization_id
	 *            the organization_id to set
	 */
	public void setOrganization_id(int organization_id) {
		this.organization_id = organization_id;
	}

	/**
	 * @return the organization_color
	 */
	public String getOrganization_color() {
		return organization_color;
	}

	/**
	 * @param organization_color
	 *            the organization_color to set
	 */
	public void setOrganization_color(String organization_color) {
		this.organization_color = organization_color;
	}

	/**
	 * @return the organization_country
	 */
	public String getOrganization_country() {
		return organization_country;
	}

	/**
	 * @param organization_country
	 *            the organization_country to set
	 */
	public void setOrganization_country(String organization_country) {
		this.organization_country = organization_country;
	}

	/**
	 * @return the organization_session_expire_time
	 */
	public int getOrganization_session_expire_time() {
		return organization_session_expire_time;
	}

	/**
	 * @param organization_session_expire_time
	 *            the organization_session_expire_time to set
	 */
	public void setOrganization_session_expire_time(int organization_session_expire_time) {
		this.organization_session_expire_time = organization_session_expire_time;
	}

}
