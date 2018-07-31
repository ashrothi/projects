/**
 * This package contain the classes used to store parameters and required data for token management and user validation.
 */
package com.springiot.constant;

import org.springframework.stereotype.Component;

/**
 * @author Garima Joshi 
 * This class is used to link with the database tables (history and current).
 */
@Component
public class TableParameter {
	private String performance_performanceservice;
	private String performance_performancestatus;
	private String performance_servicestatus;
	private String performance_status;
	private String report_header_mapping;

	public String getReport_header_mapping() {
		return report_header_mapping;
	}

	public void setReport_header_mapping(String report_header_mapping) {
		this.report_header_mapping = report_header_mapping;
	}

	/*
	 * To get History data
	 */
	public String getPerformance_performanceservice() {
		return performance_performanceservice;
	}

	/*
	 * To set History data
	 */
	public void setPerformance_performanceservice(String performance_performanceservice) {
		this.performance_performanceservice = performance_performanceservice;
	}

	/*
	 * To get History data
	 */
	public String getPerformance_performancestatus() {
		return performance_performancestatus;
	}

	/*
	 * To set History data
	 */
	public void setPerformance_performancestatus(String performance_performancestatus) {
		this.performance_performancestatus = performance_performancestatus;
	}

	/*
	 * To get Current data
	 */
	public String getPerformance_servicestatus() {
		return performance_servicestatus;
	}

	/*
	 * To set Current data
	 */
	public void setPerformance_servicestatus(String performance_servicestatus) {
		this.performance_servicestatus = performance_servicestatus;
	}

	/*
	 * To get Current data
	 */
	public String getPerformance_status() {
		return performance_status;
	}

	/*
	 * To set Current data
	 */
	public void setPerformance_status(String performance_status) {
		this.performance_status = performance_status;
	}

	@Override
	public String toString() {
		return "TableParameter [performance_performanceservice=" + performance_performanceservice
				+ ", performance_performancestatus=" + performance_performancestatus + ", performance_servicestatus="
				+ performance_servicestatus + ", performance_status=" + performance_status + "]";
	}

}
