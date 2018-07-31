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
 * This class contains response on /uploadMultipleFile API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class UploadMultipleFileSwagger {
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

	private List<UploadMultipleFile> object;

	/**
	 * @return the object
	 */
	public List<UploadMultipleFile> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<UploadMultipleFile> object) {
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
class UploadMultipleFile {
private String file_name;
private String file_path;
/**
 * @return the file_name
 */
public String getFile_name() {
	return file_name;
}
/**
 * @param file_name the file_name to set
 */
public void setFile_name(String file_name) {
	this.file_name = file_name;
}
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
