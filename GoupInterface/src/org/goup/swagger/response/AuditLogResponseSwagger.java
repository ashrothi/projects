package org.goup.swagger.response;

import java.util.List;

public class AuditLogResponseSwagger {
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private List<AuditLogResponse> object;

	public List<AuditLogResponse> getObject() {
		return object;
	}

	public void setObject(List<AuditLogResponse> object) {
		this.object = object;
	}

	private boolean valid;

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

class AuditLogResponse {

	private String log_id;
	private String notification_audit_log_id;
	private String log_description;
	private String token;
	private String end_node_name;
	private String end_node_ip;
	private String notification_type;
	private String api_url;
	private String body_parameter;
	private String header_parameter;
	private String api_type;
	private String db_url;
	private String db_driver;
	private String table_name;
	private String table_parameter;
	private String method_type;
	private String controller_name;
	private String method_name;
	private String host_ip;

	/**
	 * @return the log_id
	 */
	public String getLog_id() {
		return log_id;
	}

	/**
	 * @param log_id
	 *            the log_id to set
	 */
	public void setLog_id(String log_id) {
		this.log_id = log_id;
	}

	/**
	 * @return the notification_audit_log_id
	 */
	public String getNotification_audit_log_id() {
		return notification_audit_log_id;
	}

	/**
	 * @param notification_audit_log_id
	 *            the notification_audit_log_id to set
	 */
	public void setNotification_audit_log_id(String notification_audit_log_id) {
		this.notification_audit_log_id = notification_audit_log_id;
	}

	/**
	 * @return the log_description
	 */
	public String getLog_description() {
		return log_description;
	}

	/**
	 * @param log_description
	 *            the log_description to set
	 */
	public void setLog_description(String log_description) {
		this.log_description = log_description;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the end_node_name
	 */
	public String getEnd_node_name() {
		return end_node_name;
	}

	/**
	 * @param end_node_name
	 *            the end_node_name to set
	 */
	public void setEnd_node_name(String end_node_name) {
		this.end_node_name = end_node_name;
	}

	/**
	 * @return the end_node_ip
	 */
	public String getEnd_node_ip() {
		return end_node_ip;
	}

	/**
	 * @param end_node_ip
	 *            the end_node_ip to set
	 */
	public void setEnd_node_ip(String end_node_ip) {
		this.end_node_ip = end_node_ip;
	}

	/**
	 * @return the notification_type
	 */
	public String getNotification_type() {
		return notification_type;
	}

	/**
	 * @param notification_type
	 *            the notification_type to set
	 */
	public void setNotification_type(String notification_type) {
		this.notification_type = notification_type;
	}

	/**
	 * @return the api_url
	 */
	public String getApi_url() {
		return api_url;
	}

	/**
	 * @param api_url
	 *            the api_url to set
	 */
	public void setApi_url(String api_url) {
		this.api_url = api_url;
	}

	/**
	 * @return the body_parameter
	 */
	public String getBody_parameter() {
		return body_parameter;
	}

	/**
	 * @param body_parameter
	 *            the body_parameter to set
	 */
	public void setBody_parameter(String body_parameter) {
		this.body_parameter = body_parameter;
	}

	/**
	 * @return the header_parameter
	 */
	public String getHeader_parameter() {
		return header_parameter;
	}

	/**
	 * @param header_parameter
	 *            the header_parameter to set
	 */
	public void setHeader_parameter(String header_parameter) {
		this.header_parameter = header_parameter;
	}

	/**
	 * @return the api_type
	 */
	public String getApi_type() {
		return api_type;
	}

	/**
	 * @param api_type
	 *            the api_type to set
	 */
	public void setApi_type(String api_type) {
		this.api_type = api_type;
	}

	/**
	 * @return the db_url
	 */
	public String getDb_url() {
		return db_url;
	}

	/**
	 * @param db_url
	 *            the db_url to set
	 */
	public void setDb_url(String db_url) {
		this.db_url = db_url;
	}

	/**
	 * @return the db_driver
	 */
	public String getDb_driver() {
		return db_driver;
	}

	/**
	 * @param db_driver
	 *            the db_driver to set
	 */
	public void setDb_driver(String db_driver) {
		this.db_driver = db_driver;
	}

	/**
	 * @return the table_name
	 */
	public String getTable_name() {
		return table_name;
	}

	/**
	 * @param table_name
	 *            the table_name to set
	 */
	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	/**
	 * @return the table_parameter
	 */
	public String getTable_parameter() {
		return table_parameter;
	}

	/**
	 * @param table_parameter
	 *            the table_parameter to set
	 */
	public void setTable_parameter(String table_parameter) {
		this.table_parameter = table_parameter;
	}

	/**
	 * @return the method_type
	 */
	public String getMethod_type() {
		return method_type;
	}

	/**
	 * @param method_type
	 *            the method_type to set
	 */
	public void setMethod_type(String method_type) {
		this.method_type = method_type;
	}

	/**
	 * @return the controller_name
	 */
	public String getcontroller_name() {
		return controller_name;
	}

	/**
	 * @param controller_name
	 *            the controller_name to set
	 */
	public void setcontroller_name(String controller_name) {
		this.controller_name = controller_name;
	}

	/**
	 * @return the method_name
	 */
	public String getmethod_name() {
		return method_name;
	}

	/**
	 * @param method_name
	 *            the method_name to set
	 */
	public void setmethod_name(String method_name) {
		this.method_name = method_name;
	}

	/**
	 * @return the host_ip
	 */
	public String getHost_ip() {
		return host_ip;
	}

	/**
	 * @param host_ip
	 *            the host_ip to set
	 */
	public void setHost_ip(String host_ip) {
		this.host_ip = host_ip;
	}

}
