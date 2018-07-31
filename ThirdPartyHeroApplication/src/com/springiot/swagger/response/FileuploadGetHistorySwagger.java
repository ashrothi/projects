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
 * This class contains response on /fileupload/get/history API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FileuploadGetHistorySwagger {
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

	private List<FileuploadGetHistory> object;

	/**
	 * @return the object
	 */
	public List<FileuploadGetHistory> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FileuploadGetHistory> object) {
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
class FileuploadGetHistory {
	private int id;
	private String file_name;
	private String file_path; 
	private int is_processed;
	private String file_date; 
	private int is_faulty;
	private String description;
	private String userid;
	private String userkey;
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
	/**
	 * @return the is_processed
	 */
	public int getIs_processed() {
		return is_processed;
	}
	/**
	 * @param is_processed the is_processed to set
	 */
	public void setIs_processed(int is_processed) {
		this.is_processed = is_processed;
	}
	/**
	 * @return the file_date
	 */
	public String getFile_date() {
		return file_date;
	}
	/**
	 * @param file_date the file_date to set
	 */
	public void setFile_date(String file_date) {
		this.file_date = file_date;
	}
	/**
	 * @return the is_faulty
	 */
	public int getIs_faulty() {
		return is_faulty;
	}
	/**
	 * @param is_faulty the is_faulty to set
	 */
	public void setIs_faulty(int is_faulty) {
		this.is_faulty = is_faulty;
	}
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
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * @return the userkey
	 */
	public String getUserkey() {
		return userkey;
	}
	/**
	 * @param userkey the userkey to set
	 */
	public void setUserkey(String userkey) {
		this.userkey = userkey;
	}

}
