package org.thirdparty.request.model;

public class UpdateSubscriberDetails {
	private String title;
	private String firstName;
	private String lastName;
	private OnboardingAddress address;
	private OnBoardingCommunication communication;
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the address
	 */
	public OnboardingAddress getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(OnboardingAddress address) {
		this.address = address;
	}
	/**
	 * @return the communication
	 */
	public OnBoardingCommunication getCommunication() {
		return communication;
	}
	/**
	 * @param communication the communication to set
	 */
	public void setCommunication(OnBoardingCommunication communication) {
		this.communication = communication;
	}
	
}
