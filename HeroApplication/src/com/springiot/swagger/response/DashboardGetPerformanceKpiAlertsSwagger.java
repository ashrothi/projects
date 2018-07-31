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
 * This class contains response on /dashboard/get/performance/kpi/alerts API response
 * 
 * 
 * @author Ankita Shrothi
 *
 */
public class DashboardGetPerformanceKpiAlertsSwagger {
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

	private List<DashboardGetPerformanceKpiAlerts> object;

	/**
	 * @return the object
	 */
	public List<DashboardGetPerformanceKpiAlerts> getObject() {
		return object;
	}
/**
	 * To set object
	 * 
	 * @param object
	 */
	public void setObject(List<DashboardGetPerformanceKpiAlerts> object) {
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
class DashboardGetPerformanceKpiAlerts {
	private String week_start_date;
	private String count;
	private String id;
	private String week_no;
	private String week_end_date;
	/**
	 * @return the week_start_date
	 */
	public String getWeek_start_date() {
		return week_start_date;
	}
	/**
	 * @param week_start_date the week_start_date to set
	 */
	public void setWeek_start_date(String week_start_date) {
		this.week_start_date = week_start_date;
	}
	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}
	/**
	 * @param count the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}
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
	 * @return the week_no
	 */
	public String getWeek_no() {
		return week_no;
	}
	/**
	 * @param week_no the week_no to set
	 */
	public void setWeek_no(String week_no) {
		this.week_no = week_no;
	}
	/**
	 * @return the week_end_date
	 */
	public String getWeek_end_date() {
		return week_end_date;
	}
	/**
	 * @param week_end_date the week_end_date to set
	 */
	public void setWeek_end_date(String week_end_date) {
		this.week_end_date = week_end_date;
	}
	

}
