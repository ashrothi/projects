/**
 * This package class to get latitude and longitude in formatted way for reports.
 */
package com.springiot.constant;

/**
 * this class will return lat long in latitude + "," + longitude format when it
 * passing to a method.
 * 
 * @author Ankita shrothi
 *
 */
public class LatLng {
	/**
	 * Initiating the variables
	 */
	public double latitude;
	public double longitude;

	/**
	 * getter Method
	 * 
	 * @param latitude
	 * @param longitude
	 */
	public LatLng(double latitude, double longitude) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * Parsing Lat and Lng in double
	 * 
	 * @param latlng
	 */
	public LatLng(String[] latlng) {
		super();

		this.latitude = Double.parseDouble(latlng[0].replaceAll("\\[", "").replaceAll("\\(", ""));
		this.longitude = Double.parseDouble(latlng[1]);
	}

	/**
	 * Returning Lat Lng
	 */
	@Override
	public String toString() {
		return latitude + "," + longitude;
	}
}
