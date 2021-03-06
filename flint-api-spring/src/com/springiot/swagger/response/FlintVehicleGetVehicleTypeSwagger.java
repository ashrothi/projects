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
 * This class contains response on /flint/vehicle/get/vehicle/type API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class FlintVehicleGetVehicleTypeSwagger {
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

	private List<FlintVehicleGetVehicleType> object;

	/**
	 * @return the object
	 */
	public List<FlintVehicleGetVehicleType> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<FlintVehicleGetVehicleType> object) {
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
class FlintVehicleGetVehicleType {
	private String id;
	private String name;
	private String alias;
	private String icon;
	private String map_icon;
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
	 * @return the icon
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * @param icon the icon to set
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * @return the map_icon
	 */
	public String getMap_icon() {
		return map_icon;
	}
	/**
	 * @param map_icon the map_icon to set
	 */
	public void setMap_icon(String map_icon) {
		this.map_icon = map_icon;
	}

}
