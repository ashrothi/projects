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
 * This class contains response on /flint/status/get/all/for/android API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintStatusGetAllForAndroidSwagger {
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

	private List<FlintStatusGetAllForAndroid> object;

	/**
	 * @return the object
	 */
	public List<FlintStatusGetAllForAndroid> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintStatusGetAllForAndroid> object) {
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
class FlintStatusGetAllForAndroid {
	private String id;
	private String name;
	private String alias;
	private String colour_code;
	private String sequence_number;
	private String data_type;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * @return the colour_code
	 */
	public String getColour_code() {
		return colour_code;
	}
	/**
	 * @param colour_code the colour_code to set
	 */
	public void setColour_code(String colour_code) {
		this.colour_code = colour_code;
	}
	/**
	 * @return the sequence_number
	 */
	public String getSequence_number() {
		return sequence_number;
	}
	/**
	 * @param sequence_number the sequence_number to set
	 */
	public void setSequence_number(String sequence_number) {
		this.sequence_number = sequence_number;
	}
	/**
	 * @return the data_type
	 */
	public String getData_type() {
		return data_type;
	}
	/**
	 * @param data_type the data_type to set
	 */
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}

}
