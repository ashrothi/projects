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
 * This class contains response on /uploadFile API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class UploadFileSwagger {
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

	private List<UploadFile> object;

	/**
	 * @return the object
	 */
	public List<UploadFile> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<UploadFile> object) {
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
class UploadFile {
private String file_path;

/**
 * @return the file_path
 */
public String getFile_path() {
	return file_path;
}

/**
 * @param file_path the file_path to set
 */
public void setFile_path(String file_path) {
	this.file_path = file_path;
}

}
