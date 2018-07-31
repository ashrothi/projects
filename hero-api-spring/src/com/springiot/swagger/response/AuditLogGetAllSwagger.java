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
public class AuditLogGetAllSwagger {
	private String description;
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

	private List<AuditLogGetAll> object;

	/**
	 * @return the object
	 */
	public List<AuditLogGetAll> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<AuditLogGetAll> object) {
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
/*
*TO get response parameter getter setter
*/
class AuditLogGetAll {

	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	private String application_key;

	public String getApplication_key() {
		return application_key;
	}

	public void setApplication_key(String application_key) {
		this.application_key = application_key;
	}

	private String ip_address;

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	private String user_key;

	public String getUser_key() {
		return user_key;
	}

	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}

	private String url_accessed;

	public String getUrl_accessed() {
		return url_accessed;
	}

	public void setUrl_accessed(String url_accessed) {
		this.url_accessed = url_accessed;
	}

	private String controller_name;

	public String getController_name() {
		return controller_name;
	}

	public void setController_name(String controller_name) {
		this.controller_name = controller_name;
	}

	private String user_id;

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	private String input_parameters;

	public String getInput_parameters() {
		return input_parameters;
	}

	public void setInput_parameters(String input_parameters) {
		this.input_parameters = input_parameters;
	}

	private String log_type;

	public String getLog_type() {
		return log_type;
	}

	public void setLog_type(String log_type) {
		this.log_type = log_type;
	}

	private String timeaccessed;

	public String getTimeaccessed() {
		return timeaccessed;
	}

	public void setTimeaccessed(String timeaccessed) {
		this.timeaccessed = timeaccessed;
	}
}
