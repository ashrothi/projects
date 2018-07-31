/**
 * This package contains the model class and class to implement the process of sending email to users.
 */
package com.springiot.email;

public class EmailStatus {
	/**
	 * Variable declaration required for email sending process.
	 */
	private String username;
	private String password;
	private String socketPort;
	private String socketClass;
	private String authEmail;
	private String emailHost;
	private String emailPort;

	private String to;
	private String bcc;
	private String cc;
	private String attachment;
	private String subject;
	private String msgFromStatus;

	private String signUpSubject;
	private String msgSignUpTime;

	/**
	 * @return the signUpSubject
	 */
	public String getSignUpSubject() {
		return signUpSubject;
	}

	/**
	 * @param signUpSubject the signUpSubject to set
	 */
	public void setSignUpSubject(String signUpSubject) {
		this.signUpSubject = signUpSubject;
	}

	/**
	 * @return the msgSignUpTime
	 */
	public String getMsgSignUpTime() {
		return msgSignUpTime;
	}

	/**
	 * @param msgSignUpTime the msgSignUpTime to set
	 */
	public void setMsgSignUpTime(String msgSignUpTime) {
		this.msgSignUpTime = msgSignUpTime;
	}

	/*
	 * Get method for user name.
	 */
	public String getUsername() {
		return username;
	}

	/*
	 * Set method for user name.
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/*
	 * Get method for password.
	 */
	public String getPassword() {
		return password;
	}

	/*
	 * Set method for password.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * Get method for socketPort.
	 */
	public String getSocketPort() {
		return socketPort;
	}

	/*
	 * Set method for socketPort.
	 */
	public void setSocketPort(String socketPort) {
		this.socketPort = socketPort;
	}

	/*
	 * Get method for socketClass.
	 */
	public String getSocketClass() {
		return socketClass;
	}

	/*
	 * Set method for socketClass.
	 */
	public void setSocketClass(String socketClass) {
		this.socketClass = socketClass;
	}

	/*
	 * Get method for authEmail.
	 */
	public String getAuthEmail() {
		return authEmail;
	}

	/*
	 * Set method for authEmail.
	 */
	public void setAuthEmail(String authEmail) {
		this.authEmail = authEmail;
	}

	/*
	 * Get method for emailHost.
	 */
	public String getEmailHost() {
		return emailHost;
	}

	/*
	 * Set method for emailHost.
	 */
	public void setEmailHost(String emailHost) {
		this.emailHost = emailHost;
	}

	/*
	 * Get method for emailPort.
	 */
	public String getEmailPort() {
		return emailPort;
	}

	/*
	 * Set method for emailPort.
	 */
	public void setEmailPort(String emailPort) {
		this.emailPort = emailPort;
	}

	/*
	 * Get method for to.
	 */
	public String getTo() {
		return to;
	}

	/*
	 * Set method for to.
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/*
	 * Get method for bcc.
	 */
	public String getBcc() {
		return bcc;
	}

	/*
	 * Set method for bcc.
	 */
	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	/*
	 * Get method for cc.
	 */
	public String getCc() {
		return cc;
	}

	/*
	 * Set method for cc.
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}

	/*
	 * Get method for attachment.
	 */
	public String getAttachment() {
		return attachment;
	}

	/*
	 * Set method for attachment.
	 */
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	/*
	 * Get method for subject.
	 */
	public String getSubject() {
		return subject;
	}

	/*
	 * Set method for subject.
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/*
	 * Get method for msgFromStatus.
	 */
	public String getMsgFromStatus() {
		return msgFromStatus;
	}

	/*
	 * Set method for msgFromStatus.
	 */
	public void setMsgFromStatus(String msgFromStatus) {
		this.msgFromStatus = msgFromStatus;
	}

}
