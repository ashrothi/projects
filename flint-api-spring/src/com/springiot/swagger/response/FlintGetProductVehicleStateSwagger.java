/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;
import java.util.Date;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;
import java.util.Map;
/**
 * 
 * This class contains response on /flint/get/product/vehicle/state API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintGetProductVehicleStateSwagger {
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

	private List<FlintGetProductVehicleState> object;

	/**
	 * @return the object
	 */
	public List<FlintGetProductVehicleState> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintGetProductVehicleState> object) {
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
class FlintGetProductVehicleState {
private List<Map<String, Object>> Vehicle;
private List<Map<String, Object>> State;
private List<Map<String, Object>> Product;
private Date current_date;
/**
 * @return the vehicle
 */
public List<Map<String, Object>> getVehicle() {
	return Vehicle;
}
/**
 * @param vehicle the vehicle to set
 */
public void setVehicle(List<Map<String, Object>> vehicle) {
	Vehicle = vehicle;
}
/**
 * @return the state
 */
public List<Map<String, Object>> getState() {
	return State;
}
/**
 * @param state the state to set
 */
public void setState(List<Map<String, Object>> state) {
	State = state;
}
/**
 * @return the product
 */
public List<Map<String, Object>> getProduct() {
	return Product;
}
/**
 * @param product the product to set
 */
public void setProduct(List<Map<String, Object>> product) {
	Product = product;
}
/**
 * @return the current_date
 */
public Date getCurrent_date() {
	return current_date;
}
/**
 * @param current_date the current_date to set
 */
public void setCurrent_date(Date current_date) {
	this.current_date = current_date;
}

}
