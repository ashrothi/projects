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
 * This class contains response on /machine/update/part/cycle API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class MachineUpdatePartCycleSwagger {
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

	private List<MachineUpdatePartCycle> object;

	/**
	 * @return the object
	 */
	public List<MachineUpdatePartCycle> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<MachineUpdatePartCycle> object) {
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
class MachineUpdatePartCycle {
private int success_flag;

/**
 * @return the success_flag
 */
public int getSuccess_flag() {
	return success_flag;
}

/**
 * @param success_flag the success_flag to set
 */
public void setSuccess_flag(int success_flag) {
	this.success_flag = success_flag;
}

}
