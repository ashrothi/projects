/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /webhook/get/payload/destination/schema API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class WebhookGetPayloadDestinationSchemaSwagger {
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

	private List<WebhookGetPayloadDestinationSchema> object;

	/**
	 * @return the object
	 */
	public List<WebhookGetPayloadDestinationSchema> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<WebhookGetPayloadDestinationSchema> object) {
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
 * Set the response parameters of /webhook/get/payload/destination/schema API.
 * 
 *
 */
class WebhookGetPayloadDestinationSchema {
	// Initializing the variables
	private Integer id;
	private String name;
	private Integer destination_id;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the destination_id
	 */
	public Integer getDestination_id() {
		return destination_id;
	}

	/**
	 * @param destination_id
	 *            the destination_id to set
	 */
	public void setDestination_id(Integer destination_id) {
		this.destination_id = destination_id;
	}

}
