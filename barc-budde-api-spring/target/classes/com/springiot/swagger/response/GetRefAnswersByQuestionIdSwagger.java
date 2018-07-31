/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API /get/ref/answers/by/question/id.
 * 
 * @author Mandeep Singh
 * @creation_date 10-04-2018
 */
public class GetRefAnswersByQuestionIdSwagger {
	private String description;
	private List<GetRefAnswersByQuestionId> object;
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
	public List<GetRefAnswersByQuestionId> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<GetRefAnswersByQuestionId> object) {
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
class GetRefAnswersByQuestionId{
	// Initializing the variables.
	private Integer id;
	private Integer answer_code;
	private String answer_text;
	private String group1;
	private String group2;
	private Integer answer_group_id;
	private Integer ref_question_code;
	private Integer ref_answer_code;
	private String sort_order;
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
	 * @return the answer_code
	 */
	public Integer getAnswer_code() {
		return answer_code;
	}
	/**
	 * @param answer_code the answer_code to set
	 */
	public void setAnswer_code(Integer answer_code) {
		this.answer_code = answer_code;
	}
	/**
	 * @return the answer_text
	 */
	public String getAnswer_text() {
		return answer_text;
	}
	/**
	 * @param answer_text the answer_text to set
	 */
	public void setAnswer_text(String answer_text) {
		this.answer_text = answer_text;
	}
	/**
	 * @return the group1
	 */
	public String getGroup1() {
		return group1;
	}
	/**
	 * @param group1 the group1 to set
	 */
	public void setGroup1(String group1) {
		this.group1 = group1;
	}
	/**
	 * @return the group2
	 */
	public String getGroup2() {
		return group2;
	}
	/**
	 * @param group2 the group2 to set
	 */
	public void setGroup2(String group2) {
		this.group2 = group2;
	}
	/**
	 * @return the answer_group_id
	 */
	public Integer getAnswer_group_id() {
		return answer_group_id;
	}
	/**
	 * @param answer_group_id the answer_group_id to set
	 */
	public void setAnswer_group_id(Integer answer_group_id) {
		this.answer_group_id = answer_group_id;
	}
	/**
	 * @return the ref_question_code
	 */
	public Integer getRef_question_code() {
		return ref_question_code;
	}
	/**
	 * @param ref_question_code the ref_question_code to set
	 */
	public void setRef_question_code(Integer ref_question_code) {
		this.ref_question_code = ref_question_code;
	}
	/**
	 * @return the ref_answer_code
	 */
	public Integer getRef_answer_code() {
		return ref_answer_code;
	}
	/**
	 * @param ref_answer_code the ref_answer_code to set
	 */
	public void setRef_answer_code(Integer ref_answer_code) {
		this.ref_answer_code = ref_answer_code;
	}
	/**
	 * @return the sort_order
	 */
	public String getSort_order() {
		return sort_order;
	}
	/**
	 * @param sort_order the sort_order to set
	 */
	public void setSort_order(String sort_order) {
		this.sort_order = sort_order;
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