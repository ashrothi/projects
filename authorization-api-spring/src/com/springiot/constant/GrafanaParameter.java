/**
 * This is also a domain class used to retrieve the Grafana calling API URL from config 
 */
package com.springiot.constant;

/**
 * This class is used to call the Grafana APIs
 * 
 * @author tanvi
 *
 */
public class GrafanaParameter {

	private String grafanaAPI;

	/**
	 * @return the grafanaAPI
	 */
	public String getGrafanaAPI() {
		return grafanaAPI;
	}

	/**
	 * @param grafanaAPI
	 *            the grafanaAPI to set
	 */
	public void setGrafanaAPI(String grafanaAPI) {
		this.grafanaAPI = grafanaAPI;
	}
}
