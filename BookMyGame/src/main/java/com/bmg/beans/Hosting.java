package com.bmg.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class Hosting  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fname;
	private LocalDate bdate;
	private String hostMail;
	private String userMail;
	private String status;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public LocalDate getBdate() {
		return bdate;
	}
	public void setBdate(LocalDate bdate) {
		this.bdate = bdate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getHostMail() {
		return hostMail;
	}
	@Override
	public String toString() {
		return "Hosting [fname=" + fname + ", bdate=" + bdate + ", hostMail=" + hostMail + ", userMail=" + userMail
				+ ", status=" + status + "]";
	}
	public void setHostMail(String hostMail) {
		this.hostMail = hostMail;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

}
