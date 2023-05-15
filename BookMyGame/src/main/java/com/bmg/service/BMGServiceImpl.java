package com.bmg.service;

import java.time.LocalDate;
import java.util.ArrayList;

import com.bmg.beans.Admin;
import com.bmg.beans.Booking;
import com.bmg.beans.User;
import com.bmg.beans.Facility;
import com.bmg.beans.Hosting;
import com.bmg.beans.Inbox;
import com.bmg.dao.IBMGDao;
import com.bmg.factory.BMGDaoFactory;

public class BMGServiceImpl implements IBMGService {
	IBMGDao bgmDao = BMGDaoFactory.getBMGDao();

	@Override
	public String registerUser(User user) {
		return bgmDao.registerUser(user);
	}

	@Override
	public String registerAdmin(Admin admin) {
		return bgmDao.registerAdmin(admin);
	}

	@Override
	public ArrayList<Facility> checkfeed() {
		return bgmDao.checkfeed();
	}

	@Override
	public boolean verifyLogin(String mail, String password, String userType) {
		return bgmDao.verifyLogin(mail, password, userType);
	}

	@Override
	public ArrayList<Facility> getAllFacilities(String ownerMail) {
		return bgmDao.getAllFacilities(ownerMail);
	}

	@Override
	public String deleteFacitlity(String facilityName) {
		return bgmDao.deleteFacility(facilityName);
	}

	@Override
	public String registerFacility(Facility facility) {
		return bgmDao.registerFacility(facility);
	}

	@Override
	public Facility getFacility(String facilityName) {
		return bgmDao.getFacility(facilityName);
	}

	@Override
	public String updateFaciltiy(Facility facility, String facilityName) {
		return bgmDao.updateFaciltiy(facility, facilityName);
	}

	@Override
	public String bookFacility(Booking booking) {
		return bgmDao.bookFacility(booking);
	}

	@Override
	public ArrayList<Booking> getMyBookings(String userMail) {
		return bgmDao.getMyBookings(userMail);
	}

	@Override
	public String cancelFacility(String facilityName, LocalDate bookDate) {
		return bgmDao.cancelFacility(facilityName, bookDate);
	}

	@Override
	public ArrayList<Booking> getBookings(String ownerMail) {
		return bgmDao.getBookings(ownerMail);
	}

	@Override
	public String adminCancelFacility(String facilityName, LocalDate bookDate) {
		return bgmDao.adminCancelFacility(facilityName, bookDate);
	}

	@Override
	public String updateInbox(String usermail, String reason) {
		return bgmDao.updateInbox(usermail, reason);
	}

	@Override
	public ArrayList<Inbox> getMessages(String usermail) {
		return bgmDao.getMessages(usermail);
	}

	@Override
	public ArrayList<Booking> getHostings(String userMail) {
		return bgmDao.getHostings(userMail);
	}

	@Override
	public ArrayList<Booking> getAllHostings(String userMail) {
		return bgmDao.getAllHostings(userMail);
	}

	@Override
	public String sendJoinRequest(Hosting hosting) {
		return bgmDao.sendJoinRequest(hosting);
	}

	@Override
	public ArrayList<Hosting> getHostingRequests(String hostMail) {
		return bgmDao.getHostingRequests(hostMail);
	}

	@Override
	public String acceptJoinRequest(Hosting hosting) {
		return bgmDao.acceptJoinRequest(hosting);
	}

	@Override
	public Admin getAdminInfo(String mail) {
		return bgmDao.getAdminInfo(mail);
	}

	@Override
	public User getUserInfo(String mail) {
		return bgmDao.getUserInfo(mail);
	}

}
