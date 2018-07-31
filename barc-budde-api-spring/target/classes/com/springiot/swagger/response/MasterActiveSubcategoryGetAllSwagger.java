/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API /master/active/subcategory/get/all.
 * 
 * @author Mandeep Singh
 * @creation_date 11-04-2018
 */
public class MasterActiveSubcategoryGetAllSwagger {
	private String description;
	private List<MasterActiveSubcategoryGetAll> object;
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
	public List<MasterActiveSubcategoryGetAll> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<MasterActiveSubcategoryGetAll> object) {
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
class MasterActiveSubcategoryGetAll {
	// Initializing the variables.
	private Integer level_id;
	private String level;
	private Integer master_level_is_deleted;
	private Integer category_id;
	private String category;
	private Integer category_sort_order;
	private Integer master_subcategory_id;
	private String subcategory;
	private Integer subcategory_sort_order;
	private Integer master_subcategory_is_deleted;
	private Integer master_category_is_deleted;
	/**
	 * @return the level_id
	 */
	public Integer getLevel_id() {
		return level_id;
	}
	/**
	 * @param level_id the level_id to set
	 */
	public void setLevel_id(Integer level_id) {
		this.level_id = level_id;
	}
	/**
	 * @return the level
	 */
	public String getLevel() {
		return level;
	}
	/**
	 * @param level the level to set
	 */
	public void setLevel(String level) {
		this.level = level;
	}
	/**
	 * @return the master_level_is_deleted
	 */
	public Integer getMaster_level_is_deleted() {
		return master_level_is_deleted;
	}
	/**
	 * @param master_level_is_deleted the master_level_is_deleted to set
	 */
	public void setMaster_level_is_deleted(Integer master_level_is_deleted) {
		this.master_level_is_deleted = master_level_is_deleted;
	}
	/**
	 * @return the category_id
	 */
	public Integer getCategory_id() {
		return category_id;
	}
	/**
	 * @param category_id the category_id to set
	 */
	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}
	/**
	 * @return the category_sort_order
	 */
	public Integer getCategory_sort_order() {
		return category_sort_order;
	}
	/**
	 * @param category_sort_order the category_sort_order to set
	 */
	public void setCategory_sort_order(Integer category_sort_order) {
		this.category_sort_order = category_sort_order;
	}
	/**
	 * @return the master_subcategory_id
	 */
	public Integer getMaster_subcategory_id() {
		return master_subcategory_id;
	}
	/**
	 * @param master_subcategory_id the master_subcategory_id to set
	 */
	public void setMaster_subcategory_id(Integer master_subcategory_id) {
		this.master_subcategory_id = master_subcategory_id;
	}
	/**
	 * @return the subcategory
	 */
	public String getSubcategory() {
		return subcategory;
	}
	/**
	 * @param subcategory the subcategory to set
	 */
	public void setSubcategory(String subcategory) {
		this.subcategory = subcategory;
	}
	/**
	 * @return the subcategory_sort_order
	 */
	public Integer getSubcategory_sort_order() {
		return subcategory_sort_order;
	}
	/**
	 * @param subcategory_sort_order the subcategory_sort_order to set
	 */
	public void setSubcategory_sort_order(Integer subcategory_sort_order) {
		this.subcategory_sort_order = subcategory_sort_order;
	}
	/**
	 * @return the master_subcategory_is_deleted
	 */
	public Integer getMaster_subcategory_is_deleted() {
		return master_subcategory_is_deleted;
	}
	/**
	 * @param master_subcategory_is_deleted the master_subcategory_is_deleted to set
	 */
	public void setMaster_subcategory_is_deleted(Integer master_subcategory_is_deleted) {
		this.master_subcategory_is_deleted = master_subcategory_is_deleted;
	}
	/**
	 * @return the master_category_is_deleted
	 */
	public Integer getMaster_category_is_deleted() {
		return master_category_is_deleted;
	}
	/**
	 * @param master_category_is_deleted the master_category_is_deleted to set
	 */
	public void setMaster_category_is_deleted(Integer master_category_is_deleted) {
		this.master_category_is_deleted = master_category_is_deleted;
	}
}
