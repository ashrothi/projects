/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for APIs for getting users from the Third party database.
 * 
 * @author Mandeep Singh
 * @creation_date 05-04-2018
 */
public class UsersGetSwagger {
	private String description;
	private List<UsersGet> object;
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
	public List<UsersGet> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<UsersGet> object) {
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
class UsersGet{
	// Initializing the variables.
	private Integer id;
	private String job_title;
	private Integer currency;
	private String time_format;
	private Integer distance_unit;
	private Integer fuel_volume_unit;
	private Integer measurement_unit;
	private Integer city; 
	private Integer country;
	private Integer state;
	private String address;
	private String user_key;
	private String user_id;
	private String user_key_bin;
	private String user_name;
	private Integer owner_id;
	private Integer is_owner;
	private String user_image;
	private Integer role_id;
	private String role_name;
	private Integer fleet_size;
	private String gender;
	private Long phone_number;
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
	 * @return the job_title
	 */
	public String getJob_title() {
		return job_title;
	}
	/**
	 * @param job_title the job_title to set
	 */
	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}
	/**
	 * @return the currency
	 */
	public Integer getCurrency() {
		return currency;
	}
	/**
	 * @param currency the currency to set
	 */
	public void setCurrency(Integer currency) {
		this.currency = currency;
	}
	/**
	 * @return the time_format
	 */
	public String getTime_format() {
		return time_format;
	}
	/**
	 * @param time_format the time_format to set
	 */
	public void setTime_format(String time_format) {
		this.time_format = time_format;
	}
	/**
	 * @return the distance_unit
	 */
	public Integer getDistance_unit() {
		return distance_unit;
	}
	/**
	 * @param distance_unit the distance_unit to set
	 */
	public void setDistance_unit(Integer distance_unit) {
		this.distance_unit = distance_unit;
	}
	/**
	 * @return the fuel_volume_unit
	 */
	public Integer getFuel_volume_unit() {
		return fuel_volume_unit;
	}
	/**
	 * @param fuel_volume_unit the fuel_volume_unit to set
	 */
	public void setFuel_volume_unit(Integer fuel_volume_unit) {
		this.fuel_volume_unit = fuel_volume_unit;
	}
	/**
	 * @return the measurement_unit
	 */
	public Integer getMeasurement_unit() {
		return measurement_unit;
	}
	/**
	 * @param measurement_unit the measurement_unit to set
	 */
	public void setMeasurement_unit(Integer measurement_unit) {
		this.measurement_unit = measurement_unit;
	}
	/**
	 * @return the city
	 */
	public Integer getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(Integer city) {
		this.city = city;
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
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
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
	 * @return the user_key_bin
	 */
	public String getUser_key_bin() {
		return user_key_bin;
	}
	/**
	 * @param user_key_bin the user_key_bin to set
	 */
	public void setUser_key_bin(String user_key_bin) {
		this.user_key_bin = user_key_bin;
	}
	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}
	/**
	 * @param user_name the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	/**
	 * @return the owner_id
	 */
	public Integer getOwner_id() {
		return owner_id;
	}
	/**
	 * @param owner_id the owner_id to set
	 */
	public void setOwner_id(Integer owner_id) {
		this.owner_id = owner_id;
	}
	/**
	 * @return the is_owner
	 */
	public Integer getIs_owner() {
		return is_owner;
	}
	/**
	 * @param is_owner the is_owner to set
	 */
	public void setIs_owner(Integer is_owner) {
		this.is_owner = is_owner;
	}
	/**
	 * @return the user_image
	 */
	public String getUser_image() {
		return user_image;
	}
	/**
	 * @param user_image the user_image to set
	 */
	public void setUser_image(String user_image) {
		this.user_image = user_image;
	}
	/**
	 * @return the role_id
	 */
	public Integer getRole_id() {
		return role_id;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(Integer role_id) {
		this.role_id = role_id;
	}
	/**
	 * @return the role_name
	 */
	public String getRole_name() {
		return role_name;
	}
	/**
	 * @param role_name the role_name to set
	 */
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	/**
	 * @return the fleet_size
	 */
	public Integer getFleet_size() {
		return fleet_size;
	}
	/**
	 * @param fleet_size the fleet_size to set
	 */
	public void setFleet_size(Integer fleet_size) {
		this.fleet_size = fleet_size;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the phone_number
	 */
	public Long getPhone_number() {
		return phone_number;
	}
	/**
	 * @param phone_number the phone_number to set
	 */
	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}
}