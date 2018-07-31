/**
 * This package is used to create command template which further includes getter and setter functions of tables in database.
 */
package com.springiot.response;

/*
 *  Calling of Parameters of table from dB, specifically for the alerts.
 */
public class ComandTemplate {

	// Initializing variables and variables are actually the table names from
	// the database.
	private Object service_servicecommand_id;
	private Object service_servicecommand_name;
	private Object service_serviceparameter_name;
	private Object service_serviceparameter_value;
	private Object service_servicedatatypes_name;
	private Object service_commandparameter_is_required;
	private Object service_commandtemplate_format;

	/**
	 * @return the service_servicecommand_id
	 */
	public Object getService_servicecommand_id() {
		return service_servicecommand_id;
	}

	/**
	 * @param service_servicecommand_id
	 *            the service_servicecommand_id to set
	 */
	public void setService_servicecommand_id(Object service_servicecommand_id) {
		this.service_servicecommand_id = service_servicecommand_id;
	}

	/**
	 * @return the service_servicecommand_name
	 */
	public Object getService_servicecommand_name() {
		return service_servicecommand_name;
	}

	/**
	 * @param service_servicecommand_name
	 *            the service_servicecommand_name to set
	 */
	public void setService_servicecommand_name(Object service_servicecommand_name) {
		this.service_servicecommand_name = service_servicecommand_name;
	}

	/**
	 * @return the service_serviceparameter_name
	 */
	public Object getService_serviceparameter_name() {
		return service_serviceparameter_name;
	}

	/**
	 * @param service_serviceparameter_name
	 *            the service_serviceparameter_name to set
	 */
	public void setService_serviceparameter_name(Object service_serviceparameter_name) {
		this.service_serviceparameter_name = service_serviceparameter_name;
	}

	/**
	 * @return the service_serviceparameter_value
	 */
	public Object getService_serviceparameter_value() {
		return service_serviceparameter_value;
	}

	/**
	 * @param service_serviceparameter_value
	 *            the service_serviceparameter_value to set
	 */
	public void setService_serviceparameter_value(Object service_serviceparameter_value) {
		this.service_serviceparameter_value = service_serviceparameter_value;
	}

	/**
	 * @return the service_servicedatatypes_name
	 */
	public Object getService_servicedatatypes_name() {
		return service_servicedatatypes_name;
	}

	/**
	 * @param service_servicedatatypes_name
	 *            the service_servicedatatypes_name to set
	 */
	public void setService_servicedatatypes_name(Object service_servicedatatypes_name) {
		this.service_servicedatatypes_name = service_servicedatatypes_name;
	}

	/**
	 * @return the service_commandparameter_is_required
	 */
	public Object getService_commandparameter_is_required() {
		return service_commandparameter_is_required;
	}

	/**
	 * @param service_commandparameter_is_required
	 *            the service_commandparameter_is_required to set
	 */
	public void setService_commandparameter_is_required(Object service_commandparameter_is_required) {
		this.service_commandparameter_is_required = service_commandparameter_is_required;
	}

	/**
	 * @return the service_commandtemplate_format
	 */
	public Object getService_commandtemplate_format() {
		return service_commandtemplate_format;
	}

	/**
	 * @param service_commandtemplate_format
	 *            the service_commandtemplate_format to set
	 */
	public void setService_commandtemplate_format(Object service_commandtemplate_format) {
		this.service_commandtemplate_format = service_commandtemplate_format;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ComandTemplate [service_servicecommand_id=" + service_servicecommand_id
				+ ", service_servicecommand_name=" + service_servicecommand_name + ", service_serviceparameter_name="
				+ service_serviceparameter_name + ", service_serviceparameter_value=" + service_serviceparameter_value
				+ ", service_servicedatatypes_name=" + service_servicedatatypes_name
				+ ", service_commandparameter_is_required=" + service_commandparameter_is_required
				+ ", service_commandtemplate_format=" + service_commandtemplate_format + "]";
	}
}
