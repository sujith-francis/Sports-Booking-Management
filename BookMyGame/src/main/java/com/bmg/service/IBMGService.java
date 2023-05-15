package com.bmg.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.bmg.beans.Admin;
import com.bmg.beans.Booking;
import com.bmg.beans.User;
import com.bmg.beans.Facility;
import com.bmg.beans.Hosting;
import com.bmg.beans.Inbox;

public interface IBMGService {
	String registerUser(User user);
	String registerAdmin(Admin admin);
	String registerFacility(Facility facility);
	String updateFaciltiy(Facility facility,String facilityName);
	String deleteFacitlity(String facilityName);
	String bookFacility(Booking booking);
	String cancelFacility(String facilityName,LocalDate bookDate);
	String adminCancelFacility(String facilityName,LocalDate bookDate);
	String updateInbox(String usermail,String reason);
	String sendJoinRequest(Hosting hosting);
	String acceptJoinRequest(Hosting hosting);
	User getUserInfo(String mail);
	Admin getAdminInfo(String mail);
	Facility getFacility(String facilityName);
	ArrayList<Facility> checkfeed();
	ArrayList<Facility> getAllFacilities(String ownerMail);
	ArrayList<Booking> getMyBookings(String userMail);
	ArrayList<Booking> getBookings(String ownerMail);
	ArrayList<Booking> getHostings(String userMail);
	ArrayList<Booking> getAllHostings(String userMail);
	ArrayList<Inbox> getMessages(String usermail);
	ArrayList<Hosting> getHostingRequests(String hostMail);
	boolean verifyLogin(String mail,String  password,String userType);

}
