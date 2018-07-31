/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API /master/active/category/get/by/level/id.
 * 
 * @author Mandeep Singh
 * @creation_date 11-04-2018
 */
public class MasterActiveCategoryGetByLevelIdSwagger {
	private String description;
	private List<MasterActiveCategoryGetByLevelId> object;
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
	public List<MasterActiveCategoryGetByLevelId> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<MasterActiveCategoryGetByLevelId> object) {
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
class MasterActiveCategoryGetByLevelId {
	// Initializing the variables.
	private Integer category_id;
	private String category;
	private Integer is_deleted;
	private Integer sort_order;
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
	 * @return the is_deleted
	 */
	public Integer getIs_deleted() {
		return is_deleted;
	}
	/**
	 * @param is_deleted the is_deleted to set
	 */
	public void setIs_deleted(Integer is_deleted) {
		this.is_deleted = is_deleted;
	}
	/**
	 * @return the sort_order
	 */
	public Integer getSort_order() {
		return sort_order;
	}
	/**
	 * @param sort_order the sort_order to set
	 */
	public void setSort_order(Integer sort_order) {
		this.sort_order = sort_order;
	}
}