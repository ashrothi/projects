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
 * This class contains response on /flint/customer/update API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintCustomerUpdateSwagger {
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

	private List<FlintCustomerUpdate> object;

	/**
	 * @return the object
	 */
	public List<FlintCustomerUpdate> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintCustomerUpdate> object) {
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
class FlintCustomerUpdate {
	private String msg;
	private String customer_first_name;
	private String customer_user_id;
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
	 * @return the customer_first_name
	 */
	public String getCustomer_first_name() {
		return customer_first_name;
	}
	/**
	 * @param customer_first_name the customer_first_name to set
	 */
	public void setCustomer_first_name(String customer_first_name) {
		this.customer_first_name = customer_first_name;
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

}
