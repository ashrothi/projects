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
 * This class contains response on /flint/get/role API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintGetRoleSwagger {
	private String description;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private List<FlintGetRole> object;

	/**
	 * @return the object
	 */
	public List<FlintGetRole> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintGetRole> object) {
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
 * TO get response parameter getter setter
 */
class FlintGetRole {
	private String id;
	private String name;
	private String application_role;
	private String platform_role;
	private String auth_role;
	private String alias;
	private String application_id;

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the application_role
	 */
	public String getApplication_role() {
		return application_role;
	}

	/**
	 * @param application_role
	 *            the application_role to set
	 */
	public void setApplication_role(String application_role) {
		this.application_role = application_role;
	}

	/**
	 * @return the platform_role
	 */
	public String getPlatform_role() {
		return platform_role;
	}

	/**
	 * @param platform_role
	 *            the platform_role to set
	 */
	public void setPlatform_role(String platform_role) {
		this.platform_role = platform_role;
	}

	/**
	 * @return the auth_role
	 */
	public String getAuth_role() {
		return auth_role;
	}

	/**
	 * @param auth_role
	 *            the auth_role to set
	 */
	public void setAuth_role(String auth_role) {
		this.auth_role = auth_role;
	}

	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}

	/**
	 * @param alias
	 *            the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}

	/**
	 * @return the application_id
	 */
	public String getApplication_id() {
		return application_id;
	}

	/**
	 * @param application_id
	 *            the application_id to set
	 */
	public void setApplication_id(String application_id) {
		this.application_id = application_id;
	}

}
