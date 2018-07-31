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
 * This class contains response on /roles/get/all/user/application API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class RolesGetAllUserApplicationSwagger {
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

	private List<RolesGetAllUserApplication> object;

	/**
	 * @return the object
	 */
	public List<RolesGetAllUserApplication> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<RolesGetAllUserApplication> object) {
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
class RolesGetAllUserApplication {
	private String roles_id; 
	private String roles_name; 
	private String roles_access_key; 
	private String applications_id;
	private String attributes_ids;
	private String attributes_names;
	private String attributes_alias;
	private String attributes_data_types;
	private String attributes_reg_ex;
	private String datatypes_names;
	private String datatypes_is_regex;
	private String role_attribute_is_required;
	/**
	 * @return the roles_id
	 */
	public String getRoles_id() {
		return roles_id;
	}
	/**
	 * @param roles_id the roles_id to set
	 */
	public void setRoles_id(String roles_id) {
		this.roles_id = roles_id;
	}
	/**
	 * @return the roles_name
	 */
	public String getRoles_name() {
		return roles_name;
	}
	/**
	 * @param roles_name the roles_name to set
	 */
	public void setRoles_name(String roles_name) {
		this.roles_name = roles_name;
	}
	/**
	 * @return the roles_access_key
	 */
	public String getRoles_access_key() {
		return roles_access_key;
	}
	/**
	 * @param roles_access_key the roles_access_key to set
	 */
	public void setRoles_access_key(String roles_access_key) {
		this.roles_access_key = roles_access_key;
	}
	/**
	 * @return the applications_id
	 */
	public String getApplications_id() {
		return applications_id;
	}
	/**
	 * @param applications_id the applications_id to set
	 */
	public void setApplications_id(String applications_id) {
		this.applications_id = applications_id;
	}
	/**
	 * @return the attributes_ids
	 */
	public String getAttributes_ids() {
		return attributes_ids;
	}
	/**
	 * @param attributes_ids the attributes_ids to set
	 */
	public void setAttributes_ids(String attributes_ids) {
		this.attributes_ids = attributes_ids;
	}
	/**
	 * @return the attributes_names
	 */
	public String getAttributes_names() {
		return attributes_names;
	}
	/**
	 * @param attributes_names the attributes_names to set
	 */
	public void setAttributes_names(String attributes_names) {
		this.attributes_names = attributes_names;
	}
	/**
	 * @return the attributes_alias
	 */
	public String getAttributes_alias() {
		return attributes_alias;
	}
	/**
	 * @param attributes_alias the attributes_alias to set
	 */
	public void setAttributes_alias(String attributes_alias) {
		this.attributes_alias = attributes_alias;
	}
	/**
	 * @return the attributes_data_types
	 */
	public String getAttributes_data_types() {
		return attributes_data_types;
	}
	/**
	 * @param attributes_data_types the attributes_data_types to set
	 */
	public void setAttributes_data_types(String attributes_data_types) {
		this.attributes_data_types = attributes_data_types;
	}
	/**
	 * @return the attributes_reg_ex
	 */
	public String getAttributes_reg_ex() {
		return attributes_reg_ex;
	}
	/**
	 * @param attributes_reg_ex the attributes_reg_ex to set
	 */
	public void setAttributes_reg_ex(String attributes_reg_ex) {
		this.attributes_reg_ex = attributes_reg_ex;
	}
	/**
	 * @return the datatypes_names
	 */
	public String getDatatypes_names() {
		return datatypes_names;
	}
	/**
	 * @param datatypes_names the datatypes_names to set
	 */
	public void setDatatypes_names(String datatypes_names) {
		this.datatypes_names = datatypes_names;
	}
	/**
	 * @return the datatypes_is_regex
	 */
	public String getDatatypes_is_regex() {
		return datatypes_is_regex;
	}
	/**
	 * @param datatypes_is_regex the datatypes_is_regex to set
	 */
	public void setDatatypes_is_regex(String datatypes_is_regex) {
		this.datatypes_is_regex = datatypes_is_regex;
	}
	/**
	 * @return the role_attribute_is_required
	 */
	public String getRole_attribute_is_required() {
		return role_attribute_is_required;
	}
	/**
	 * @param role_attribute_is_required the role_attribute_is_required to set
	 */
	public void setRole_attribute_is_required(String role_attribute_is_required) {
		this.role_attribute_is_required = role_attribute_is_required;
	}

}
