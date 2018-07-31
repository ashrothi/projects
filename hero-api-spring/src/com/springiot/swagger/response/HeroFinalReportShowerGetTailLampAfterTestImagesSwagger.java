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
 * This class contains response on /hero/final/report/shower/get/tail/lamp/after/test/images API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroFinalReportShowerGetTailLampAfterTestImagesSwagger {
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

	private List<HeroFinalReportShowerGetTailLampAfterTestImages> object;

	/**
	 * @return the object
	 */
	public List<HeroFinalReportShowerGetTailLampAfterTestImages> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroFinalReportShowerGetTailLampAfterTestImages> object) {
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
class HeroFinalReportShowerGetTailLampAfterTestImages {
	private int id;
	private String image_name;
	private String image_path;
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
	/**
	 * @return the image_name
	 */
	public String getImage_name() {
		return image_name;
	}
	/**
	 * @param image_name the image_name to set
	 */
	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}
	/**
	 * @return the image_path
	 */
	public String getImage_path() {
		return image_path;
	}
	/**
	 * @param image_path the image_path to set
	 */
	public void setImage_path(String image_path) {
		this.image_path = image_path;
	}


}
