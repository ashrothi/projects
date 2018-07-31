/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API /active/answer/group/get/all.
 * 
 * @author Mandeep Singh
 * @creation_date 11-04-2018
 */
public class ActiveAnswerGroupGetAllSwagger {
	private String description;
	private List<ActiveAnswerGroupGetAll> object;
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
	public List<ActiveAnswerGroupGetAll> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<ActiveAnswerGroupGetAll> object) {
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
class ActiveAnswerGroupGetAll {
	// Initializing the variables.
	private Integer id;
	private String answer_group;
	private Integer is_deleted;
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
	 * @return the answer_group
	 */
	public String getAnswer_group() {
		return answer_group;
	}
	/**
	 * @param answer_group the answer_group to set
	 */
	public void setAnswer_group(String answer_group) {
		this.answer_group = answer_group;
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
}