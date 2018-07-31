/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /user/session/check API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class UserSessionCheckSwaggerResponse {
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

	private List<UserSessionCheckSwagger> object;

	/**
	 * @return the object
	 */
	public List<UserSessionCheckSwagger> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<UserSessionCheckSwagger> object) {
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
 * Set the response parameters of /user/session/check API.
 * 
 *
 */
class UserSessionCheckSwagger {
	// Initializing the variables
	private int case_status;
	private int is_session_manage;
	private int is_single_sign_on_manage;
	private int is_password_expire_manage;
	private int is_valid;
	private int allow_login;

	/**
	 * @return the case_status
	 */
	public int getCase_status() {
		return case_status;
	}

	/**
	 * @param case_status
	 *            the case_status to set
	 */
	public void setCase_status(int case_status) {
		this.case_status = case_status;
	}

	/**
	 * @return the is_session_manage
	 */
	public int getIs_session_manage() {
		return is_session_manage;
	}

	/**
	 * @param is_session_manage
	 *            the is_session_manage to set
	 */
	public void setIs_session_manage(int is_session_manage) {
		this.is_session_manage = is_session_manage;
	}

	/**
	 * @return the is_single_sign_on_manage
	 */
	public int getIs_single_sign_on_manage() {
		return is_single_sign_on_manage;
	}

	/**
	 * @param is_single_sign_on_manage
	 *            the is_single_sign_on_manage to set
	 */
	public void setIs_single_sign_on_manage(int is_single_sign_on_manage) {
		this.is_single_sign_on_manage = is_single_sign_on_manage;
	}

	/**
	 * @return the is_password_expire_manage
	 */
	public int getIs_password_expire_manage() {
		return is_password_expire_manage;
	}

	/**
	 * @param is_password_expire_manage
	 *            the is_password_expire_manage to set
	 */
	public void setIs_password_expire_manage(int is_password_expire_manage) {
		this.is_password_expire_manage = is_password_expire_manage;
	}

	/**
	 * @return the is_valid
	 */
	public int getIs_valid() {
		return is_valid;
	}

	/**
	 * @param is_valid
	 *            the is_valid to set
	 */
	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}

	/**
	 * @return the allow_login
	 */
	public int getAllow_login() {
		return allow_login;
	}

	/**
	 * @param allow_login
	 *            the allow_login to set
	 */
	public void setAllow_login(int allow_login) {
		this.allow_login = allow_login;
	}

}
