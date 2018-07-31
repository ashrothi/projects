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
 * This class contains response on /hero/notification/get/notificationcodes API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class HeroNotificationGetNotificationcodesSwagger {
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

	private List<HeroNotificationGetNotificationcodes> object;

	/**
	 * @return the object
	 */
	public List<HeroNotificationGetNotificationcodes> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroNotificationGetNotificationcodes> object) {
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
class HeroNotificationGetNotificationcodes {
	private int id; 
	private int code; 
	private String alias; 
	private String description; 
	private int is_hidden; 
	private String css_icon_class; 
	private String file_path;
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
	 * @return the code
	 */
	public int getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(int code) {
		this.code = code;
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
	 * @return the is_hidden
	 */
	public int getIs_hidden() {
		return is_hidden;
	}
	/**
	 * @param is_hidden the is_hidden to set
	 */
	public void setIs_hidden(int is_hidden) {
		this.is_hidden = is_hidden;
	}
	/**
	 * @return the css_icon_class
	 */
	public String getCss_icon_class() {
		return css_icon_class;
	}
	/**
	 * @param css_icon_class the css_icon_class to set
	 */
	public void setCss_icon_class(String css_icon_class) {
		this.css_icon_class = css_icon_class;
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
