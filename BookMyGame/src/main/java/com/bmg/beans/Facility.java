package com.bmg.beans;

public class Facility {
	private String fname;
	private String fowner;
	private String fphone;
	private String fsport;
	private String floc;
	private String fmail;
	private String fomail;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getFowner() {
		return fowner;
	}
	public void setFowner(String fowner) {
		this.fowner = fowner;
	}
	public String getFphone() {
		return fphone;
	}
	public void setFphone(String fphone) {
		this.fphone = fphone;
	}
	public String getFsport() {
		return fsport;
	}
	@Override
	public String toString() {
		return "Facility [fname=" + fname + ", fowner=" + fowner + ", fphone=" + fphone + ", fsport=" + fsport
				+ ", floc=" + floc + ", fmail=" + fmail + ", fomail=" + fomail + "]";
	}
	public void setFsport(String fsport) {
		this.fsport = fsport;
	}
	public String getFloc() {
		return floc;
	}
	public void setFloc(String floc) {
		this.floc = floc;
	}
	public String getFmail() {
		return fmail;
	}
	public void setFmail(String fmail) {
		this.fmail = fmail;
	}
	public String getFomail() {
		return fomail;
	}
	public void setFomail(String fomail) {
		this.fomail = fomail;
	}

}
