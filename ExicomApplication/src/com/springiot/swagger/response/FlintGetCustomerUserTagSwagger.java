/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
/**
 * 
 * This class contains response on /flint/get/customer/user/tag API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintGetCustomerUserTagSwagger {
	private String description;
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

	private List<FlintGetCustomerUserTag> object;

	/**
	 * @return the object
	 */
	public List<FlintGetCustomerUserTag> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintGetCustomerUserTag> object) {
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
/*
*TO get response parameter getter setter
*/
class FlintGetCustomerUserTag {
	private String id;
	private String user_tag_name;
	private String sequence_number;
	private String is_deleted;
	private String is_active;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the user_tag_name
	 */
	public String getUser_tag_name() {
		return user_tag_name;
	}
	/**
	 * @param user_tag_name the user_tag_name to set
	 */
	public void setUser_tag_name(String user_tag_name) {
		this.user_tag_name = user_tag_name;
	}
	/**
	 * @return the sequence_number
	 */
	public String getSequence_number() {
		return sequence_number;
	}
	/**
	 * @param sequence_number the sequence_number to set
	 */
	public void setSequence_number(String sequence_number) {
		this.sequence_number = sequence_number;
	}
	/**
	 * @return the is_deleted
	 */
	public String getIs_deleted() {
		return is_deleted;
	}
	/**
	 * @param is_deleted the is_deleted to set
	 */
	public void setIs_deleted(String is_deleted) {
		this.is_deleted = is_deleted;
	}
	/**
	 * @return the is_active
	 */
	public String getIs_active() {
		return is_active;
	}
	/**
	 * @param is_active the is_active to set
	 */
	public void setIs_active(String is_active) {
		this.is_active = is_active;
	}

}
