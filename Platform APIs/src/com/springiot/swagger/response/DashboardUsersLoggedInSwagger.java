/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /dashboard/users/logged/in API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DashboardUsersLoggedInSwagger {
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

	private List<DashboardUsers> object;

	/**
	 * @return the object
	 */
	public List<DashboardUsers> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardUsers> object) {
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
 * Set the response parameters of /dashboard/alert/get/count API.
 * 
 *
 */
class DashboardUsers {
	private Integer web_users;
	private Integer mobile_users;

	/**
	 * @return the web_users
	 */
	public Integer getWeb_users() {
		return web_users;
	}

	/**
	 * @param web_users
	 *            the web_users to set
	 */
	public void setWeb_users(Integer web_users) {
		this.web_users = web_users;
	}

	/**
	 * @return the mobile_users
	 */
	public Integer getMobile_users() {
		return mobile_users;
	}

	/**
	 * @param mobile_users
	 *            the mobile_users to set
	 */
	public void setMobile_users(Integer mobile_users) {
		this.mobile_users = mobile_users;
	}

}