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
 * This class contains response on /hero/final/report/shower/get/rear/winker/observation API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class GenericFinalReportGetObservationSwagger {
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

	private List<HeroFinalReportShowerGetRearWinkerObservation> object;

	/**
	 * @return the object
	 */
	public List<HeroFinalReportShowerGetRearWinkerObservation> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<HeroFinalReportShowerGetRearWinkerObservation> object) {
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
class HeroFinalReportShowerGetRearWinkerObservation {

	private int id; 
	private String observation; 
	private String testing_version; 
	private long start_date; 
	private String component_type; 
	private String testing_type; 
	private String is_editable; 
	private long end_date;
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
	 * @return the observation
	 */
	public String getObservation() {
		return observation;
	}
	/**
	 * @param observation the observation to set
	 */
	public void setObservation(String observation) {
		this.observation = observation;
	}
	/**
	 * @return the testing_version
	 */
	public String getTesting_version() {
		return testing_version;
	}
	/**
	 * @param testing_version the testing_version to set
	 */
	public void setTesting_version(String testing_version) {
		this.testing_version = testing_version;
	}
	/**
	 * @return the start_date
	 */
	public long getStart_date() {
		return start_date;
	}
	/**
	 * @param start_date the start_date to set
	 */
	public void setStart_date(long start_date) {
		this.start_date = start_date;
	}
	/**
	 * @return the component_type
	 */
	public String getComponent_type() {
		return component_type;
	}
	/**
	 * @param component_type the component_type to set
	 */
	public void setComponent_type(String component_type) {
		this.component_type = component_type;
	}
	/**
	 * @return the testing_type
	 */
	public String getTesting_type() {
		return testing_type;
	}
	/**
	 * @param testing_type the testing_type to set
	 */
	public void setTesting_type(String testing_type) {
		this.testing_type = testing_type;
	}
	/**
	 * @return the is_editable
	 */
	public String getIs_editable() {
		return is_editable;
	}
	/**
	 * @param is_editable the is_editable to set
	 */
	public void setIs_editable(String is_editable) {
		this.is_editable = is_editable;
	}
	/**
	 * @return the end_date
	 */
	public long getEnd_date() {
		return end_date;
	}
	/**
	 * @param end_date the end_date to set
	 */
	public void setEnd_date(long end_date) {
		this.end_date = end_date;
	} 

}
