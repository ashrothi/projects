/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
/**
 * 
 * This class contains response on /audit/log/get/all API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class AuditLogGetSwagger {
	private String description;
	private List<AuditLogGet> object;
	private boolean valid;

/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the object
	 */
	public List<AuditLogGet> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<AuditLogGet> object) {
		this.object = object;
	}

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
/*
*TO get response parameter getter setter
*/
class AuditLogGet {

	private Integer id;
	private String application_key;
	private String ip_address;
	private String user_key;
	private String url_accessed;
	private String controller_name;
	private String user_id;
	private String input_parameters;
	private String log_type;
	private String timeaccessed;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the application_key
	 */
	public String getApplication_key() {
		return application_key;
	}
	/**
	 * @param application_key the application_key to set
	 */
	public void setApplication_key(String application_key) {
		this.application_key = application_key;
	}
	/**
	 * @return the ip_address
	 */
	public String getIp_address() {
		return ip_address;
	}
	/**
	 * @param ip_address the ip_address to set
	 */
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	/**
	 * @return the user_key
	 */
	public String getUser_key() {
		return user_key;
	}
	/**
	 * @param user_key the user_key to set
	 */
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}
	/**
	 * @return the url_accessed
	 */
	public String getUrl_accessed() {
		return url_accessed;
	}
	/**
	 * @param url_accessed the url_accessed to set
	 */
	public void setUrl_accessed(String url_accessed) {
		this.url_accessed = url_accessed;
	}
	/**
	 * @return the controller_name
	 */
	public String getController_name() {
		return controller_name;
	}
	/**
	 * @param controller_name the controller_name to set
	 */
	public void setController_name(String controller_name) {
		this.controller_name = controller_name;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the input_parameters
	 */
	public String getInput_parameters() {
		return input_parameters;
	}
	/**
	 * @param input_parameters the input_parameters to set
	 */
	public void setInput_parameters(String input_parameters) {
		this.input_parameters = input_parameters;
	}
	/**
	 * @return the log_type
	 */
	public String getLog_type() {
		return log_type;
	}
	/**
	 * @param log_type the log_type to set
	 */
	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}
	/**
	 * @return the timeaccessed
	 */
	public String getTimeaccessed() {
		return timeaccessed;
	}
	/**
	 * @param timeaccessed the timeaccessed to set
	 */
	public void setTimeaccessed(String timeaccessed) {
		this.timeaccessed = timeaccessed;
	}
}
