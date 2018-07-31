/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for APIs for getting metadata from the Third party database.
 * 
 * @author Mandeep Singh
 * @creation_date 05-04-2018
 */
public class GenericGetAllSwagger {
	private String description;
	private List<GenericGetAll> object;
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
	public List<GenericGetAll> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<GenericGetAll> object) {
		this.object = object;
	}
	/**
	 * @return the valid
	 */
	public boolean isValid() {
		return valid;
	}
	/**
	 * @param valid the valid to set
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}
}

/**
 * This class is used for setting data into the object.
 */
class GenericGetAll{
	// Initializing the variables.
	private Integer id;
	private String name;

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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
}