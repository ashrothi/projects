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
 * This class contains response on /passwordupdate API response
 * 
 * 
 * @author tanvigarg
 *
 */
public class PasswordUpdateSwagger {
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

	private List<Passwordupdate> object;

	/**
	 * @return the object
	 */
	public List<Passwordupdate> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<Passwordupdate> object) {
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
class Passwordupdate {
	public Object getIs_valid() {return is_valid;}
	public void setIs_valid(Object is_valid) {this.is_valid = is_valid;}
	private Object is_valid;
	public Object getCode() {return code;}
	public void setCode(Object code) {this.code = code;}
	private Object code;
	private String msg;
	public String getMsg() {return msg;}
	public void setMsg(String msg) {this.msg = msg;}

}