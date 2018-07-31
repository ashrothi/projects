/**
 * This Package contain all the classes of responses of API for swagger.
 */
package com.springiot.swagger.response;
/**
 * To Import Classes to access their functionality
 */
import java.util.List;

/**
 * 
 * This class contains response on /hero/final/report/delete/images API response.
 * 
 * @author Mandeep Singh
 */
public class GenericFinalReportDeleteImagesSwagger {
	private String description;
	private List<GenericHeroFinalReportDeleteImages> object;
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
	public List<GenericHeroFinalReportDeleteImages> getObject() {
		return object;
	}
	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<GenericHeroFinalReportDeleteImages> object) {
		this.object = object;
	}

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

/**
 * TO get response parameter getter setter
 */
class GenericHeroFinalReportDeleteImages {
	private int id;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

}
