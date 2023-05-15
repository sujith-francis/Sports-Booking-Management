package com.bmg.beans;

import java.io.Serializable;

public class Inbox implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userMail;
	private String message;
	@Override
	public String toString() {
		return "Inbox [userMail=" + userMail + ", reason=" + message + "]";
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}
