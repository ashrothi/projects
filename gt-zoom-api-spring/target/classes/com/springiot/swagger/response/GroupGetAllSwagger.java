/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API for getting groups from the Third party database.
 * 
 * @author Mandeep Singh
 * @creation_date 06-04-2018
 */
public class GroupGetAllSwagger {
	private String description;
	private List<GroupGetAll> object;
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
	public List<GroupGetAll> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<GroupGetAll> object) {
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
class GroupGetAll {
	// Initializing the variables.
	private String path;
	private String path_alias;
	private Integer level;
	private Integer vehicle_id;
	private String vehicle_name;
	private Integer group_id;
	private String group_name;
	private String group_color;
	private String vehicle_model;
	private Integer parent_group_id;
	private String parent_group_name;

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the path_alias
	 */
	public String getPath_alias() {
		return path_alias;
	}
	/**
	 * @param path_alias the path_alias to set
	 */
	public void setPath_alias(String path_alias) {
		this.path_alias = path_alias;
	}
	/**
	 * @return the level
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * @return the vehicle_id
	 */
	public Integer getVehicle_id() {
		return vehicle_id;
	}
	/**
	 * @param vehicle_id the vehicle_id to set
	 */
	public void setVehicle_id(Integer vehicle_id) {
		this.vehicle_id = vehicle_id;
	}
	/**
	 * @return the vehicle_name
	 */
	public String getVehicle_name() {
		return vehicle_name;
	}
	/**
	 * @param vehicle_name the vehicle_name to set
	 */
	public void setVehicle_name(String vehicle_name) {
		this.vehicle_name = vehicle_name;
	}
	/**
	 * @return the group_id
	 */
	public Integer getGroup_id() {
		return group_id;
	}
	/**
	 * @param group_id the group_id to set
	 */
	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}
	/**
	 * @return the group_name
	 */
	public String getGroup_name() {
		return group_name;
	}
	/**
	 * @param group_name the group_name to set
	 */
	public void setGroup_name(String group_name) {
		this.group_name = group_name;
	}
	/**
	 * @return the group_color
	 */
	public String getGroup_color() {
		return group_color;
	}
	/**
	 * @param group_color the group_color to set
	 */
	public void setGroup_color(String group_color) {
		this.group_color = group_color;
	}
	/**
	 * @return the vehicle_model
	 */
	public String getVehicle_model() {
		return vehicle_model;
	}
	/**
	 * @param vehicle_model the vehicle_model to set
	 */
	public void setVehicle_model(String vehicle_model) {
		this.vehicle_model = vehicle_model;
	}
	/**
	 * @return the parent_group_id
	 */
	public Integer getParent_group_id() {
		return parent_group_id;
	}
	/**
	 * @param parent_group_id the parent_group_id to set
	 */
	public void setParent_group_id(Integer parent_group_id) {
		this.parent_group_id = parent_group_id;
	}
	/**
	 * @return the parent_group_name
	 */
	public String getParent_group_name() {
		return parent_group_name;
	}
	/**
	 * @param parent_group_name the parent_group_name to set
	 */
	public void setParent_group_name(String parent_group_name) {
		this.parent_group_name = parent_group_name;
	}
}