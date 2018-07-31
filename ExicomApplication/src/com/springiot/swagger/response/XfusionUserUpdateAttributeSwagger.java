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
 * This class contains response on /xfusion/user/update/attribute API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class XfusionUserUpdateAttributeSwagger {
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

	private List<XfusionUserUpdateAttribute> object;

	/**
	 * @return the object
	 */
	public List<XfusionUserUpdateAttribute> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<XfusionUserUpdateAttribute> object) {
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
class XfusionUserUpdateAttribute {
	private String is_updated;
	private String msg;
	
	/**
	 * @return the is_updated
	 */
	public String getIs_updated() {
		return is_updated;
	}
	/**
	 * @param is_updated the is_updated to set
	 */
	public void setIs_updated(String is_updated) {
		this.is_updated = is_updated;
	}
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
