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
 * This class contains response on /component/setting/update/default/value API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class ComponentSettingUpdateDefaultValueSwagger {
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

	private List<ComponentSettingUpdateDefaultValue> object;

	/**
	 * @return the object
	 */
	public List<ComponentSettingUpdateDefaultValue> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<ComponentSettingUpdateDefaultValue> object) {
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
class ComponentSettingUpdateDefaultValue {

	private int testing_id;

	/**
	 * @return the testing_id
	 */
	public int getTesting_id() {
		return testing_id;
	}

	/**
	 * @param testing_id the testing_id to set
	 */
	public void setTesting_id(int testing_id) {
		this.testing_id = testing_id;
	}
	
	
}
