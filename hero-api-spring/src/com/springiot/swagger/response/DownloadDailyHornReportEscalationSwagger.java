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
 * This class contains response on /download/daily/horn/report/Escalation API
 * response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class DownloadDailyHornReportEscalationSwagger {
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

	private List<DownloadDailyHornReportEscalation> object;

	/**
	 * @return the object
	 */
	public List<DownloadDailyHornReportEscalation> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DownloadDailyHornReportEscalation> object) {
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
class DownloadDailyHornReportEscalation {
	private String file;
	private String orignalPath;

	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file
	 *            the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @return the orignalPath
	 */
	public String getOrignalPath() {
		return orignalPath;
	}

	/**
	 * @param orignalPath
	 *            the orignalPath to set
	 */
	public void setOrignalPath(String orignalPath) {
		this.orignalPath = orignalPath;
	}

}
