/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API for getting city by state id from the Third party database.
 * 
 * @author Mandeep Singh
 * @creation_date 06-04-2018
 */
public class CityGetByStateSwagger {
	private String description;
	private List<CityGetByState> object;
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
	public List<CityGetByState> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<CityGetByState> object) {
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
class CityGetByState{
	// Initializing the variables.
	private Integer id;
	private String name;
	private Integer country;
	private Integer state;
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
	/**
	 * @return the country
	 */
	public Integer getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(Integer country) {
		this.country = country;
	}
	/**
	 * @return the state
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(Integer state) {
		this.state = state;
	}
}