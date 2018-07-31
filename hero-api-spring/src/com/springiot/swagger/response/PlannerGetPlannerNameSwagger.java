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
 * This class contains response on /planner/get/planner/name API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class PlannerGetPlannerNameSwagger {
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

	private List<PlannerGetPlannerName> object;

	/**
	 * @return the object
	 */
	public List<PlannerGetPlannerName> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<PlannerGetPlannerName> object) {
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
class PlannerGetPlannerName {
	
	private String month;
	
	private List<PlannerGetPlanner> planner;
	/**
	 * @return the planner_no
	 */

	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * @return the planner
	 */
	public List<PlannerGetPlanner> getPlanner() {
		return planner;
	}
	/**
	 * @param planner the planner to set
	 */
	public void setPlanner(List<PlannerGetPlanner> planner) {
		this.planner =  planner;
	}
	class PlannerGetPlanner{
	private String planner_no; 
	private String planner_version; 
	private String planner_name; 
	private String creation_date; 
	private String month;
	/**
	 * @return the planner_no
	 */
	public String getPlanner_no() {
		return planner_no;
	}
	/**
	 * @param planner_no the planner_no to set
	 */
	public void setPlanner_no(String planner_no) {
		this.planner_no = planner_no;
	}
	/**
	 * @return the planner_version
	 */
	public String getPlanner_version() {
		return planner_version;
	}
	/**
	 * @param planner_version the planner_version to set
	 */
	public void setPlanner_version(String planner_version) {
		this.planner_version = planner_version;
	}
	/**
	 * @return the planner_name
	 */
	public String getPlanner_name() {
		return planner_name;
	}
	/**
	 * @param planner_name the planner_name to set
	 */
	public void setPlanner_name(String planner_name) {
		this.planner_name = planner_name;
	}
	/**
	 * @return the creation_date
	 */
	public String getCreation_date() {
		return creation_date;
	}
	/**
	 * @param creation_date the creation_date to set
	 */
	public void setCreation_date(String creation_date) {
		this.creation_date = creation_date;
	}
	/**
	 * @return the month
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * @param month the month to set
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	}
}
