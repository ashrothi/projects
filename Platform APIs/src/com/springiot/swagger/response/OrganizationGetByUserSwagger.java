/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /organization/get/by/user API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class OrganizationGetByUserSwagger {
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

	private List<OrganizationGetByUser> object;

	/**
	 * @return the object
	 */
	public List<OrganizationGetByUser> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<OrganizationGetByUser> object) {
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
 * Set the response parameters of /organization/get/by/user API.
 * 
 *
 */
class OrganizationGetByUser {
	// Initializing the variables
	private int organization_id;

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

}