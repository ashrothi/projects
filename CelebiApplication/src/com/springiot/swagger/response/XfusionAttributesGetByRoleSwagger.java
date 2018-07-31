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
 * This class contains response on /xfusion/attributes/get/by/role API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class XfusionAttributesGetByRoleSwagger {
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

	private List<XfusionAttributesGetByRole> object;

	/**
	 * @return the object
	 */
	public List<XfusionAttributesGetByRole> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<XfusionAttributesGetByRole> object) {
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
class XfusionAttributesGetByRole {
	private int id;
	private int role_id;
	private int attribute_id;
	private String is_required;
	private String datatype_name;
	private String datatype_is_regex;
	private int role_attribute_is_required;
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
	public int getAttribute_id() {
		return attribute_id;
	}
	/**
	 * @param attribute_id the attribute_id to set
	 */
	public void setAttribute_id(int attribute_id) {
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
	 * @return the datatype_name
	 */
	public String getDatatype_name() {
		return datatype_name;
	}
	/**
	 * @param datatype_name the datatype_name to set
	 */
	public void setDatatype_name(String datatype_name) {
		this.datatype_name = datatype_name;
	}
	/**
	 * @return the datatype_is_regex
	 */
	public String getDatatype_is_regex() {
		return datatype_is_regex;
	}
	/**
	 * @param datatype_is_regex the datatype_is_regex to set
	 */
	public void setDatatype_is_regex(String datatype_is_regex) {
		this.datatype_is_regex = datatype_is_regex;
	}
	/**
	 * @return the role_attribute_is_required
	 */
	public int getRole_attribute_is_required() {
		return role_attribute_is_required;
	}
	/**
	 * @param role_attribute_is_required the role_attribute_is_required to set
	 */
	public void setRole_attribute_is_required(int role_attribute_is_required) {
		this.role_attribute_is_required = role_attribute_is_required;
	}

}
