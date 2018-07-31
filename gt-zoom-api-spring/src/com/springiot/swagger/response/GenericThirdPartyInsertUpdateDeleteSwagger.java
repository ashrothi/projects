/**
 * This Package contain all the classes of responses of API for swagger
 */
package com.springiot.swagger.response;

import java.util.List;

/**
 * This class contains response for API for inserting new user into the Third party database.
 * 
 * @author Mandeep Singh
 * @creation_date 05-04-2018
 */
public class GenericThirdPartyInsertUpdateDeleteSwagger {
	private String description;
	private List<GenericThirdPartyInsertUpdateDelete> object;
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
	public List<GenericThirdPartyInsertUpdateDelete> getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(List<GenericThirdPartyInsertUpdateDelete> object) {
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
class GenericThirdPartyInsertUpdateDelete{
	// Initializing the variables.
	private String msg;

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
