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
 * This class contains response on /users/get/all API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class UsersGetAllSwagger {
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

	private List<UsersGetAll> object;

	/**
	 * @return the object
	 */
	public List<UsersGetAll> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<UsersGetAll> object) {
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
class UsersGetAll {
	private Integer id;
	public Integer getId() {return id;}
	public void setId(Integer id) {this.id = id;}
	private String name;
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	private String access_key;
	public String getAccess_key() {return access_key;}
	public void setAccess_key(String access_key) {this.access_key = access_key;}
	private Integer application_id;
	public Integer getApplication_id() {return application_id;}
	public void setApplication_id(Integer application_id) {this.application_id = application_id;}

}
