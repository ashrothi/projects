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
 * This class contains response on /flint/create/customer API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintCreateCustomerSwagger {
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

	private List<FlintCreateCustomer> object;

	/**
	 * @return the object
	 */
	public List<FlintCreateCustomer> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintCreateCustomer> object) {
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
class FlintCreateCustomer {

	private String msg;
	private String customer_user_id;
	private String customer_user_key;
	private String customer_id;
	private String code;
	private String isPasswordValid;
	private String user_id;
	private String isUserCreated;
	private String isEmailValid;
	private String isUsernameValid;
	private String userKey;
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
	/**
	 * @return the customer_user_id
	 */
	public String getCustomer_user_id() {
		return customer_user_id;
	}
	/**
	 * @param customer_user_id the customer_user_id to set
	 */
	public void setCustomer_user_id(String customer_user_id) {
		this.customer_user_id = customer_user_id;
	}
	/**
	 * @return the customer_user_key
	 */
	public String getCustomer_user_key() {
		return customer_user_key;
	}
	/**
	 * @param customer_user_key the customer_user_key to set
	 */
	public void setCustomer_user_key(String customer_user_key) {
		this.customer_user_key = customer_user_key;
	}
	/**
	 * @return the customer_id
	 */
	public String getCustomer_id() {
		return customer_id;
	}
	/**
	 * @param customer_id the customer_id to set
	 */
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the isPasswordValid
	 */
	public String getIsPasswordValid() {
		return isPasswordValid;
	}
	/**
	 * @param isPasswordValid the isPasswordValid to set
	 */
	public void setIsPasswordValid(String isPasswordValid) {
		this.isPasswordValid = isPasswordValid;
	}
	/**
	 * @return the user_id
	 */
	public String getUser_id() {
		return user_id;
	}
	/**
	 * @param user_id the user_id to set
	 */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/**
	 * @return the isUserCreated
	 */
	public String getIsUserCreated() {
		return isUserCreated;
	}
	/**
	 * @param isUserCreated the isUserCreated to set
	 */
	public void setIsUserCreated(String isUserCreated) {
		this.isUserCreated = isUserCreated;
	}
	/**
	 * @return the isEmailValid
	 */
	public String getIsEmailValid() {
		return isEmailValid;
	}
	/**
	 * @param isEmailValid the isEmailValid to set
	 */
	public void setIsEmailValid(String isEmailValid) {
		this.isEmailValid = isEmailValid;
	}
	/**
	 * @return the isUsernameValid
	 */
	public String getIsUsernameValid() {
		return isUsernameValid;
	}
	/**
	 * @param isUsernameValid the isUsernameValid to set
	 */
	public void setIsUsernameValid(String isUsernameValid) {
		this.isUsernameValid = isUsernameValid;
	}
	/**
	 * @return the userKey
	 */
	public String getUserKey() {
		return userKey;
	}
	/**
	 * @param userKey the userKey to set
	 */
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	
}
