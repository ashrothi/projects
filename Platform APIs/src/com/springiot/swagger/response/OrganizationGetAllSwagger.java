/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /organization/get/all API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class OrganizationGetAllSwagger {
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

	private List<OrganizationGetAll> object;

	/**
	 * @return the object
	 */
	public List<OrganizationGetAll> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<OrganizationGetAll> object) {
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

class OrganizationGetAll {
	// Initializing the variables
	private String country_alias;
	private String organization_organization_city;
	private String city_alias;
	private String organization_organization_id;
	private String organization_organization_path;
	private String organization_organization_description;
	private String city_name;
	private String state_name;
	private String state_alias;
	private String country_name;
	private String state_id;
	private String colours_id;
	private String organization_organization_alias;
	private String colours_name;
	private String colours_alias;
	private String country_id;
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
	 * @return the organization_organization_city
	 */
	public String getOrganization_organization_city() {
		return organization_organization_city;
	}

	/**
	 * @param organization_organization_city
	 *            the organization_organization_city to set
	 */
	public void setOrganization_organization_city(String organization_organization_city) {
		this.organization_organization_city = organization_organization_city;
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
	 * @return the organization_organization_id
	 */
	public String getOrganization_organization_id() {
		return organization_organization_id;
	}

	/**
	 * @param organization_organization_id
	 *            the organization_organization_id to set
	 */
	public void setOrganization_organization_id(String organization_organization_id) {
		this.organization_organization_id = organization_organization_id;
	}

	/**
	 * @return the organization_organization_path
	 */
	public String getOrganization_organization_path() {
		return organization_organization_path;
	}

	/**
	 * @param organization_organization_path
	 *            the organization_organization_path to set
	 */
	public void setOrganization_organization_path(String organization_organization_path) {
		this.organization_organization_path = organization_organization_path;
	}

	/**
	 * @return the organization_organization_description
	 */
	public String getOrganization_organization_description() {
		return organization_organization_description;
	}

	/**
	 * @param organization_organization_description
	 *            the organization_organization_description to set
	 */
	public void setOrganization_organization_description(String organization_organization_description) {
		this.organization_organization_description = organization_organization_description;
	}

	/**
	 * @return the city_name
	 */
	public String getCity_name() {
		return city_name;
	}

	/**
	 * @param city_name
	 *            the city_name to set
	 */
	public void setCity_name(String city_name) {
		this.city_name = city_name;
	}

	/**
	 * @return the state_name
	 */
	public String getState_name() {
		return state_name;
	}

	/**
	 * @param state_name
	 *            the state_name to set
	 */
	public void setState_name(String state_name) {
		this.state_name = state_name;
	}

	/**
	 * @return the state_alias
	 */
	public String getState_alias() {
		return state_alias;
	}

	/**
	 * @param state_alias
	 *            the state_alias to set
	 */
	public void setState_alias(String state_alias) {
		this.state_alias = state_alias;
	}

	/**
	 * @return the country_name
	 */
	public String getCountry_name() {
		return country_name;
	}

	/**
	 * @param country_name
	 *            the country_name to set
	 */
	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	/**
	 * @return the state_id
	 */
	public String getState_id() {
		return state_id;
	}

	/**
	 * @param state_id
	 *            the state_id to set
	 */
	public void setState_id(String state_id) {
		this.state_id = state_id;
	}

	/**
	 * @return the colours_id
	 */
	public String getColours_id() {
		return colours_id;
	}

	/**
	 * @param colours_id
	 *            the colours_id to set
	 */
	public void setColours_id(String colours_id) {
		this.colours_id = colours_id;
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
	 * @return the country_id
	 */
	public String getCountry_id() {
		return country_id;
	}

	/**
	 * @param country_id
	 *            the country_id to set
	 */
	public void setCountry_id(String country_id) {
		this.country_id = country_id;
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
