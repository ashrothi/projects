/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /xfusion/exception/log/get/all API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class XfusionExceptionLogGetAllSwagger {
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

	private List<XfusionExceptionLogGetAll> object;

	/**
	 * @return the object
	 */
	public List<XfusionExceptionLogGetAll> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<XfusionExceptionLogGetAll> object) {
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
 * Set the response parameters of /xfusion/exception/log/get/all API.
 * 
 * @author tanvigarg
 *
 */
class XfusionExceptionLogGetAll {
	private String log_exception_id;
	private String log_exception_controller_url;
	private String log_exception_input_parameter;
	private String log_exception_output;
	private String log_exception_exception;
	private String log_exception_user_id;
	private String log_exception_userKey;
	private String log_exception_application_id;
	private String log_exception_createdAT;
	private String users_name;

	/**
	 * @return the log_exception_id
	 */
	public String getLog_exception_id() {
		return log_exception_id;
	}

	/**
	 * @param log_exception_id
	 *            the log_exception_id to set
	 */
	public void setLog_exception_id(String log_exception_id) {
		this.log_exception_id = log_exception_id;
	}

	/**
	 * @return the log_exception_controller_url
	 */
	public String getLog_exception_controller_url() {
		return log_exception_controller_url;
	}

	/**
	 * @param log_exception_controller_url
	 *            the log_exception_controller_url to set
	 */
	public void setLog_exception_controller_url(String log_exception_controller_url) {
		this.log_exception_controller_url = log_exception_controller_url;
	}

	/**
	 * @return the log_exception_input_parameter
	 */
	public String getLog_exception_input_parameter() {
		return log_exception_input_parameter;
	}

	/**
	 * @param log_exception_input_parameter
	 *            the log_exception_input_parameter to set
	 */
	public void setLog_exception_input_parameter(String log_exception_input_parameter) {
		this.log_exception_input_parameter = log_exception_input_parameter;
	}

	/**
	 * @return the log_exception_output
	 */
	public String getLog_exception_output() {
		return log_exception_output;
	}

	/**
	 * @param log_exception_output
	 *            the log_exception_output to set
	 */
	public void setLog_exception_output(String log_exception_output) {
		this.log_exception_output = log_exception_output;
	}

	/**
	 * @return the log_exception_exception
	 */
	public String getLog_exception_exception() {
		return log_exception_exception;
	}

	/**
	 * @param log_exception_exception
	 *            the log_exception_exception to set
	 */
	public void setLog_exception_exception(String log_exception_exception) {
		this.log_exception_exception = log_exception_exception;
	}

	/**
	 * @return the log_exception_user_id
	 */
	public String getLog_exception_user_id() {
		return log_exception_user_id;
	}

	/**
	 * @param log_exception_user_id
	 *            the log_exception_user_id to set
	 */
	public void setLog_exception_user_id(String log_exception_user_id) {
		this.log_exception_user_id = log_exception_user_id;
	}

	/**
	 * @return the log_exception_userKey
	 */
	public String getLog_exception_userKey() {
		return log_exception_userKey;
	}

	/**
	 * @param log_exception_userKey
	 *            the log_exception_userKey to set
	 */
	public void setLog_exception_userKey(String log_exception_userKey) {
		this.log_exception_userKey = log_exception_userKey;
	}

	/**
	 * @return the log_exception_application_id
	 */
	public String getLog_exception_application_id() {
		return log_exception_application_id;
	}

	/**
	 * @param log_exception_application_id
	 *            the log_exception_application_id to set
	 */
	public void setLog_exception_application_id(String log_exception_application_id) {
		this.log_exception_application_id = log_exception_application_id;
	}

	/**
	 * @return the log_exception_createdAT
	 */
	public String getLog_exception_createdAT() {
		return log_exception_createdAT;
	}

	/**
	 * @param log_exception_createdAT
	 *            the log_exception_createdAT to set
	 */
	public void setLog_exception_createdAT(String log_exception_createdAT) {
		this.log_exception_createdAT = log_exception_createdAT;
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

}
