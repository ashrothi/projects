/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /organization/get/all/user API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class OrganizationGetAllUserSwagger {
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

	private List<OrganizationGetAllUser> object;

	/**
	 * @return the object
	 */
	public List<OrganizationGetAllUser> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<OrganizationGetAllUser> object) {
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

class OrganizationGetAllUser {
	// Initializing the variables
	private String country_alias;
	private String city_alias;
	private String TRIM;
	private String city_timezone;
	private String organization_organization_alias;
	private String colours_name;
	private String colours_alias;
	private String organization_organization_name;
	private String colours_code;

	/**
	 * @return the country_alias
	 */
	public String getCountry_alias() {
		return country_alias;
	}

	/**
	 * @param country_alias
	 *            the country_alias to set
	 */
	public void setCountry_alias(String country_alias) {
		this.country_alias = country_alias;
	}

	/**
	 * @return the city_alias
	 */
	public String getCity_alias() {
		return city_alias;
	}

	/**
	 * @param city_alias
	 *            the city_alias to set
	 */
	public void setCity_alias(String city_alias) {
		this.city_alias = city_alias;
	}

	/**
	 * @return the tRIM
	 */
	public String getTRIM() {
		return TRIM;
	}

	/**
	 * @param tRIM
	 *            the tRIM to set
	 */
	public void setTRIM(String tRIM) {
		TRIM = tRIM;
	}

	/**
	 * @return the city_timezone
	 */
	public String getCity_timezone() {
		return city_timezone;
	}

	/**
	 * @param city_timezone
	 *            the city_timezone to set
	 */
	public void setCity_timezone(String city_timezone) {
		this.city_timezone = city_timezone;
	}

	/**
	 * @return the organization_organization_alias
	 */
	public String getOrganization_organization_alias() {
		return organization_organization_alias;
	}

	/**
	 * @param organization_organization_alias
	 *            the organization_organization_alias to set
	 */
	public void setOrganization_organization_alias(String organization_organization_alias) {
		this.organization_organization_alias = organization_organization_alias;
	}

	/**
	 * @return the colours_name
	 */
	public String getColours_name() {
		return colours_name;
	}

	/**
	 * @param colours_name
	 *            the colours_name to set
	 */
	public void setColours_name(String colours_name) {
		this.colours_name = colours_name;
	}

	/**
	 * @return the colours_alias
	 */
	public String getColours_alias() {
		return colours_alias;
	}

	/**
	 * @param colours_alias
	 *            the colours_alias to set
	 */
	public void setColours_alias(String colours_alias) {
		this.colours_alias = colours_alias;
	}

	/**
	 * @return the organization_organization_name
	 */
	public String getOrganization_organization_name() {
		return organization_organization_name;
	}

	/**
	 * @param organization_organization_name
	 *            the organization_organization_name to set
	 */
	public void setOrganization_organization_name(String organization_organization_name) {
		this.organization_organization_name = organization_organization_name;
	}

	/**
	 * @return the colours_code
	 */
	public String getColours_code() {
		return colours_code;
	}

	/**
	 * @param colours_code
	 *            the colours_code to set
	 */
	public void setColours_code(String colours_code) {
		this.colours_code = colours_code;
	}

}
