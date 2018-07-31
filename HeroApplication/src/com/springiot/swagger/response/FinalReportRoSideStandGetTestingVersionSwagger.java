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
 * This class contains response on
 * /final/report/ro/side/stand/get/testing/version API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FinalReportRoSideStandGetTestingVersionSwagger {
	private String description;

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	private List<FinalReportRoSideStandGetTestingVersion> object;

	/**
	 * @return the object
	 */
	public List<FinalReportRoSideStandGetTestingVersion> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FinalReportRoSideStandGetTestingVersion> object) {
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
 * TO get response parameter getter setter
 */
class FinalReportRoSideStandGetTestingVersion {

	private int id;
	private String test_version;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the test_version
	 */
	public String getTest_version() {
		return test_version;
	}

	/**
	 * @param test_version
	 *            the test_version to set
	 */
	public void setTest_version(String test_version) {
		this.test_version = test_version;
	}
}
