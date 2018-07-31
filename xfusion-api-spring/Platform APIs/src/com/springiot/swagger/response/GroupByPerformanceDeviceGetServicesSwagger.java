/**
*This Package contain all the classes of responses of API for swagger
*/
package com.springiot.swagger.response;

import java.util.List;

/**
 * 
 * This class contains response on /group/by/performance/device/get/services API
 * response
 * 
 * 
 * @author tanvigarg
 *
 */
public class GroupByPerformanceDeviceGetServicesSwagger {
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

	private List<GroupByPerformanceDeviceGetServices> object;

	/**
	 * @return the object
	 */
	public List<GroupByPerformanceDeviceGetServices> getObject() {
		return object;
	}

	/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<GroupByPerformanceDeviceGetServices> object) {
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

/**
 * Set the response parameters of /group/by/performance/device/get/services API.
 * 
 *
 */
class GroupByPerformanceDeviceGetServices {
	// Initializing the variables
	private String charts_alias;
	private String service_servicedatasource_unit;
	private String service_servicedatasource_max_value;
	private Integer charts_id;
	private String service_servicedatasource_min_value;
	private String service_service_category;
	private String service_servicedatasource_name;
	private String service_service_name;
	private String service_servicedatasource_alias;
	private String service_servicedatasource_data_source_type;
	private Integer service_servicedatasource_priority;
	private String service_service_alias;
	private Integer colours_id;
	private String colours_name;
	private String colours_alias;
	private String colours_code;

	/**
	 * @return the charts_alias
	 */
	public String getCharts_alias() {
		return charts_alias;
	}

	/**
	 * @param charts_alias
	 *            the charts_alias to set
	 */
	public void setCharts_alias(String charts_alias) {
		this.charts_alias = charts_alias;
	}

	/**
	 * @return the service_servicedatasource_unit
	 */
	public String getService_servicedatasource_unit() {
		return service_servicedatasource_unit;
	}

	/**
	 * @param service_servicedatasource_unit
	 *            the service_servicedatasource_unit to set
	 */
	public void setService_servicedatasource_unit(String service_servicedatasource_unit) {
		this.service_servicedatasource_unit = service_servicedatasource_unit;
	}

	/**
	 * @return the service_servicedatasource_max_value
	 */
	public String getService_servicedatasource_max_value() {
		return service_servicedatasource_max_value;
	}

	/**
	 * @param service_servicedatasource_max_value
	 *            the service_servicedatasource_max_value to set
	 */
	public void setService_servicedatasource_max_value(String service_servicedatasource_max_value) {
		this.service_servicedatasource_max_value = service_servicedatasource_max_value;
	}

	/**
	 * @return the charts_id
	 */
	public Integer getCharts_id() {
		return charts_id;
	}

	/**
	 * @param charts_id
	 *            the charts_id to set
	 */
	public void setCharts_id(Integer charts_id) {
		this.charts_id = charts_id;
	}

	/**
	 * @return the service_servicedatasource_min_value
	 */
	public String getService_servicedatasource_min_value() {
		return service_servicedatasource_min_value;
	}

	/**
	 * @param service_servicedatasource_min_value
	 *            the service_servicedatasource_min_value to set
	 */
	public void setService_servicedatasource_min_value(String service_servicedatasource_min_value) {
		this.service_servicedatasource_min_value = service_servicedatasource_min_value;
	}

	/**
	 * @return the service_service_category
	 */
	public String getService_service_category() {
		return service_service_category;
	}

	/**
	 * @param service_service_category
	 *            the service_service_category to set
	 */
	public void setService_service_category(String service_service_category) {
		this.service_service_category = service_service_category;
	}

	/**
	 * @return the service_servicedatasource_name
	 */
	public String getService_servicedatasource_name() {
		return service_servicedatasource_name;
	}

	/**
	 * @param service_servicedatasource_name
	 *            the service_servicedatasource_name to set
	 */
	public void setService_servicedatasource_name(String service_servicedatasource_name) {
		this.service_servicedatasource_name = service_servicedatasource_name;
	}

	/**
	 * @return the service_service_name
	 */
	public String getService_service_name() {
		return service_service_name;
	}

	/**
	 * @param service_service_name
	 *            the service_service_name to set
	 */
	public void setService_service_name(String service_service_name) {
		this.service_service_name = service_service_name;
	}

	/**
	 * @return the service_servicedatasource_alias
	 */
	public String getService_servicedatasource_alias() {
		return service_servicedatasource_alias;
	}

	/**
	 * @param service_servicedatasource_alias
	 *            the service_servicedatasource_alias to set
	 */
	public void setService_servicedatasource_alias(String service_servicedatasource_alias) {
		this.service_servicedatasource_alias = service_servicedatasource_alias;
	}

	/**
	 * @return the service_servicedatasource_data_source_type
	 */
	public String getService_servicedatasource_data_source_type() {
		return service_servicedatasource_data_source_type;
	}

	/**
	 * @param service_servicedatasource_data_source_type
	 *            the service_servicedatasource_data_source_type to set
	 */
	public void setService_servicedatasource_data_source_type(String service_servicedatasource_data_source_type) {
		this.service_servicedatasource_data_source_type = service_servicedatasource_data_source_type;
	}

	/**
	 * @return the service_servicedatasource_priority
	 */
	public Integer getService_servicedatasource_priority() {
		return service_servicedatasource_priority;
	}

	/**
	 * @param service_servicedatasource_priority
	 *            the service_servicedatasource_priority to set
	 */
	public void setService_servicedatasource_priority(Integer service_servicedatasource_priority) {
		this.service_servicedatasource_priority = service_servicedatasource_priority;
	}

	/**
	 * @return the service_service_alias
	 */
	public String getService_service_alias() {
		return service_service_alias;
	}

	/**
	 * @param service_service_alias
	 *            the service_service_alias to set
	 */
	public void setService_service_alias(String service_service_alias) {
		this.service_service_alias = service_service_alias;
	}

	/**
	 * @return the colours_id
	 */
	public Integer getColours_id() {
		return colours_id;
	}

	/**
	 * @param colours_id
	 *            the colours_id to set
	 */
	public void setColours_id(Integer colours_id) {
		this.colours_id = colours_id;
	}

	/**
	 * @return the colours_name
	 */
	public String getColours_name() {
		return colours_name;
	}

	/**
	 * @param colours_name
	 *            the colours_name to set
	 */
	public void setColours_name(String colours_name) {
		this.colours_name = colours_name;
	}

	/**
	 * @return the colours_alias
	 */
	public String getColours_alias() {
		return colours_alias;
	}

	/**
	 * @param colours_alias
	 *            the colours_alias to set
	 */
	public void setColours_alias(String colours_alias) {
		this.colours_alias = colours_alias;
	}

	/**
	 * @return the colours_code
	 */
	public String getColours_code() {
		return colours_code;
	}

	/**
	 * @param colours_code
	 *            the colours_code to set
	 */
	public void setColours_code(String colours_code) {
		this.colours_code = colours_code;
	}

}