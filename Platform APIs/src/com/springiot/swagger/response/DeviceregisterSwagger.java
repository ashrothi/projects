/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /deviceregister API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class DeviceregisterSwagger {
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

	private List<Deviceregister> object;

	/**
	 * @return the object
	 */
	public List<Deviceregister> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<Deviceregister> object) {
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
 * Set the response parameters of /deviceregister API.
 * 
 *
 */
class Deviceregister {

	private String api_url;
	private Integer port;
	private Integer id;
	private Integer gateway_id;
	private String ip_address;
	private Integer device_id;
	private String status;

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
	 * @return the port
	 */
	public Integer getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(Integer port) {
		this.port = port;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the gateway_id
	 */
	public Integer getGateway_id() {
		return gateway_id;
	}

	/**
	 * @param gateway_id
	 *            the gateway_id to set
	 */
	public void setGateway_id(Integer gateway_id) {
		this.gateway_id = gateway_id;
	}

	/**
	 * @return the ip_address
	 */
	public String getIp_address() {
		return ip_address;
	}

	/**
	 * @param ip_address
	 *            the ip_address to set
	 */
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}

	/**
	 * @return the device_id
	 */
	public Integer getDevice_id() {
		return device_id;
	}

	/**
	 * @param device_id
	 *            the device_id to set
	 */
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

}