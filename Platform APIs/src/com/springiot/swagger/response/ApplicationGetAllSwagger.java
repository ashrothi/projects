/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /application/get/all API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class ApplicationGetAllSwagger {
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

	private List<ApplicationGetAll> object;

	/**
	 * @return the object
	 */
	public List<ApplicationGetAll> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<ApplicationGetAll> object) {
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
 * Set the response parameters of /application/get/all API.
 * 
 *
 */
class ApplicationGetAll {
	// Initializing the variables
	private String applications_logo_file_path;
	private Integer applications_id;
	private String applications_alias;
	private String applications_description;
	private String applications_view_url;
	private String applications_api_url;
	private String applications_name;
	private String application_key;
	private String applications_file_path;
	private String applications_service_url;
	private String applications_url;

	/**
	 * @return the applications_logo_file_path
	 */
	public String getApplications_logo_file_path() {
		return applications_logo_file_path;
	}

	/**
	 * @param applications_logo_file_path
	 *            the applications_logo_file_path to set
	 */
	public void setApplications_logo_file_path(String applications_logo_file_path) {
		this.applications_logo_file_path = applications_logo_file_path;
	}

	/**
	 * @return the applications_id
	 */
	public Integer getApplications_id() {
		return applications_id;
	}

	/**
	 * @param applications_id
	 *            the applications_id to set
	 */
	public void setApplications_id(Integer applications_id) {
		this.applications_id = applications_id;
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
	 * @return the applications_description
	 */
	public String getApplications_description() {
		return applications_description;
	}

	/**
	 * @param applications_description
	 *            the applications_description to set
	 */
	public void setApplications_description(String applications_description) {
		this.applications_description = applications_description;
	}

	/**
	 * @return the applications_view_url
	 */
	public String getApplications_view_url() {
		return applications_view_url;
	}

	/**
	 * @param applications_view_url
	 *            the applications_view_url to set
	 */
	public void setApplications_view_url(String applications_view_url) {
		this.applications_view_url = applications_view_url;
	}

	/**
	 * @return the applications_api_url
	 */
	public String getApplications_api_url() {
		return applications_api_url;
	}

	/**
	 * @param applications_api_url
	 *            the applications_api_url to set
	 */
	public void setApplications_api_url(String applications_api_url) {
		this.applications_api_url = applications_api_url;
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
	 * @return the applications_file_path
	 */
	public String getApplications_file_path() {
		return applications_file_path;
	}

	/**
	 * @param applications_file_path
	 *            the applications_file_path to set
	 */
	public void setApplications_file_path(String applications_file_path) {
		this.applications_file_path = applications_file_path;
	}

	/**
	 * @return the applications_service_url
	 */
	public String getApplications_service_url() {
		return applications_service_url;
	}

	/**
	 * @param applications_service_url
	 *            the applications_service_url to set
	 */
	public void setApplications_service_url(String applications_service_url) {
		this.applications_service_url = applications_service_url;
	}

	/**
	 * @return the applications_url
	 */
	public String getApplications_url() {
		return applications_url;
	}

	/**
	 * @param applications_url
	 *            the applications_url to set
	 */
	public void setApplications_url(String applications_url) {
		this.applications_url = applications_url;
	}

}
