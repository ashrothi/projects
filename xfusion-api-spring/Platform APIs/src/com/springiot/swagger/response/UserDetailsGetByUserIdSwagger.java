/**
	*This Package contain all the classes of responses of API for swagger
	*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response of /user/details/get/by/user/id API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class UserDetailsGetByUserIdSwagger {

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

	private List<UserDetailsGetByUserId> object;

	/**
	 * @return the object
	 */
	public List<UserDetailsGetByUserId> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<UserDetailsGetByUserId> object) {
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
 * Set the response parameters of /user/details/get/by/user/id API.
 * 
 *
 */
class UserDetailsGetByUserId {
	// Initializing the variables
	private String country;
	private String city;
	private String user_key;
	private String last_name;
	private String temp_contact_number;
	private String last_activity_date;
	private String thumbail_image_path;
	private String is_deleted;
	private String is_anonymous;
	private String name;
	private Integer id;
	private String state;
	private String first_name;
	private String preferred_contact_number;
	private String temp_address;

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the user_key
	 */
	public String getUser_key() {
		return user_key;
	}

	/**
	 * @param user_key
	 *            the user_key to set
	 */
	public void setUser_key(String user_key) {
		this.user_key = user_key;
	}

	/**
	 * @return the last_name
	 */
	public String getLast_name() {
		return last_name;
	}

	/**
	 * @param last_name
	 *            the last_name to set
	 */
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	/**
	 * @return the temp_contact_number
	 */
	public String getTemp_contact_number() {
		return temp_contact_number;
	}

	/**
	 * @param temp_contact_number
	 *            the temp_contact_number to set
	 */
	public void setTemp_contact_number(String temp_contact_number) {
		this.temp_contact_number = temp_contact_number;
	}

	/**
	 * @return the last_activity_date
	 */
	public String getLast_activity_date() {
		return last_activity_date;
	}

	/**
	 * @param last_activity_date
	 *            the last_activity_date to set
	 */
	public void setLast_activity_date(String last_activity_date) {
		this.last_activity_date = last_activity_date;
	}

	/**
	 * @return the thumbail_image_path
	 */
	public String getThumbail_image_path() {
		return thumbail_image_path;
	}

	/**
	 * @param thumbail_image_path
	 *            the thumbail_image_path to set
	 */
	public void setThumbail_image_path(String thumbail_image_path) {
		this.thumbail_image_path = thumbail_image_path;
	}

	/**
	 * @return the is_deleted
	 */
	public String getIs_deleted() {
		return is_deleted;
	}

	/**
	 * @param is_deleted
	 *            the is_deleted to set
	 */
	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}

	/**
	 * @return the is_anonymous
	 */
	public String getIs_anonymous() {
		return is_anonymous;
	}

	/**
	 * @param is_anonymous
	 *            the is_anonymous to set
	 */
	public void setIs_anonymous(String is_anonymous) {
		this.is_anonymous = is_anonymous;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the first_name
	 */
	public String getFirst_name() {
		return first_name;
	}

	/**
	 * @param first_name
	 *            the first_name to set
	 */
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	/**
	 * @return the preferred_contact_number
	 */
	public String getPreferred_contact_number() {
		return preferred_contact_number;
	}

	/**
	 * @param preferred_contact_number
	 *            the preferred_contact_number to set
	 */
	public void setPreferred_contact_number(String preferred_contact_number) {
		this.preferred_contact_number = preferred_contact_number;
	}

	/**
	 * @return the temp_address
	 */
	public String getTemp_address() {
		return temp_address;
	}

	/**
	 * @param temp_address
	 *            the temp_address to set
	 */
	public void setTemp_address(String temp_address) {
		this.temp_address = temp_address;
	}

}
