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
 * This class contains response on /hero/final/report/ro/side/stand/get/vendor API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroFinalReportRoSideStandGetVendorSwagger {
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

	private List<HeroFinalReportRoSideStandGetVendor> object;

	/**
	 * @return the object
	 */
	public List<HeroFinalReportRoSideStandGetVendor> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroFinalReportRoSideStandGetVendor> object) {
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
class HeroFinalReportRoSideStandGetVendor {

	private String vendor_code;
	private String vendor_name;
	private String vendor_name_code;

	/**
	 * @return the vendor_code
	 */
	public String getVendor_code() {
		return vendor_code;
	}

	/**
	 * @param vendor_code
	 *            the vendor_code to set
	 */
	public void setVendor_code(String vendor_code) {
		this.vendor_code = vendor_code;
	}

	/**
	 * @return the vendor_name
	 */
	public String getVendor_name() {
		return vendor_name;
	}

	/**
	 * @param vendor_name
	 *            the vendor_name to set
	 */
	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

	/**
	 * @return the vendor_name_code
	 */
	public String getVendor_name_code() {
		return vendor_name_code;
	}

	/**
	 * @param vendor_name_code
	 *            the vendor_name_code to set
	 */
	public void setVendor_name_code(String vendor_name_code) {
		this.vendor_name_code = vendor_name_code;
	}

}
