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
 * This class contains response on /application/user/remove API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class ApplicationUserRemoveSwagger {
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

	private List<ApplicationUserRemove> object;

	/**
	 * @return the object
	 */
	public List<ApplicationUserRemove> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<ApplicationUserRemove> object) {
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
class ApplicationUserRemove {
	public Object getCode() {
		return code;
	}

	public void setCode(Object code) {
		this.code = code;
	}

	private Object code;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
