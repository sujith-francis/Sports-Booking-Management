package com.bmg.beans;

import java.io.Serializable;
import java.time.LocalDate;

public class Booking implements Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String fname;
	private String userMail;
	private LocalDate bookDate;
	private String bookType;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public LocalDate getBookDate() {
		return bookDate;
	}
	public void setBookDate(LocalDate bookDate) {
		this.bookDate = bookDate;
	}
	public String getBookType() {
		return bookType;
	}
	public void setBookType(String bookType) {
		this.bookType = bookType;
	}
	@Override
	public String toString() {
		return "Booking [fname=" + fname + ", userMail=" + userMail + ", bookDate=" + bookDate + ", bookType="
				+ bookType + "]";
	}
	

}
