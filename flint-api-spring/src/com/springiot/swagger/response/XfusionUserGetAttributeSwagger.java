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
 * This class contains response on /xfusion/user/get/attribute API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class XfusionUserGetAttributeSwagger {
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

	private List<XfusionUserGetAttribute> object;

	/**
	 * @return the object
	 */
	public List<XfusionUserGetAttribute> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<XfusionUserGetAttribute> object) {
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
class XfusionUserGetAttribute {
	private int id;
	private int role_id;
	private String attribute_id;
	private String is_required;
	private String value;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the role_id
	 */
	public int getRole_id() {
		return role_id;
	}
	/**
	 * @param role_id the role_id to set
	 */
	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}
	/**
	 * @return the attribute_id
	 */
	public String getAttribute_id() {
		return attribute_id;
	}
	/**
	 * @param attribute_id the attribute_id to set
	 */
	public void setAttribute_id(String attribute_id) {
		this.attribute_id = attribute_id;
	}
	/**
	 * @return the is_required
	 */
	public String getIs_required() {
		return is_required;
	}
	/**
	 * @param is_required the is_required to set
	 */
	public void setIs_required(String is_required) {
		this.is_required = is_required;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
