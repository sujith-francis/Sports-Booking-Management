package com.bmg.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.time.LocalDate;
import java.util.ArrayList;

import com.bmg.beans.Admin;
import com.bmg.beans.Booking;
import com.bmg.beans.User;
import com.bmg.beans.Facility;
import com.bmg.beans.Hosting;
import com.bmg.beans.Inbox;
import com.bmg.util.JDBCUtil;

public class BMGDaoImpl implements IBMGDao {
	Connection con = null;

	public String registerUser(User user) {

		String insertQuery = "INSERT INTO `userinfo` (`usermail`, `username`, `password`, `userphone`) VALUES (?,?,?,?)";
		PreparedStatement ptsmt = null;
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				ptsmt = con.prepareStatement(insertQuery);
				if (ptsmt != null) {
					ptsmt.setString(1, user.getEmail());
					ptsmt.setString(2, user.getName());
					ptsmt.setString(3, user.getPassword());
					ptsmt.setString(4, user.getpNumber());
					int rowsAffected = ptsmt.executeUpdate();
					if (rowsAffected == 1) {

						return "success";
					}
				}

			}
		} catch (SQLException | IOException se) {
			return "error";
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "error";
				}
			}
		}
		return "failed";
	}

	@Override
	public String registerAdmin(Admin admin) {
		String insertQuery = "INSERT INTO `admininfo` (`adminmail`, `adminname`, `password`, `adminphone`) VALUES (?,?,?,?)";
		PreparedStatement ptsmt = null;
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				ptsmt = con.prepareStatement(insertQuery);
				if (ptsmt != null) {
					ptsmt.setString(1, admin.getEmail());
					ptsmt.setString(2, admin.getName());
					ptsmt.setString(3, admin.getPassword());
					ptsmt.setString(4, admin.getpNumber());
					int rowsAffected = ptsmt.executeUpdate();
					if (rowsAffected == 1) {

						return "success";
					}
				}

			}
		} catch (SQLException | IOException se) {
			return "error";
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "error";
				}
			}
		}
		return "failed";
	}

	@Override
	public ArrayList<Facility> checkfeed() {
		String selectQuery = "select facilityname,facilitysport,facilityloc,facilitymail from facility";
		PreparedStatement ptsmt = null;
		ArrayList<Facility> facilities = null;
		ResultSet rs = null;
		Facility facility = null;
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				ptsmt = con.prepareStatement(selectQuery);
				if (ptsmt != null) {
					rs = ptsmt.executeQuery();
					facilities = new ArrayList<Facility>();

					while (rs.next()) {
						facility = new Facility();
						facility.setFname(rs.getString("facilityname"));
						facility.setFsport(rs.getString("facilitysport"));
						facility.setFloc(rs.getString("facilityloc"));
						facility.setFmail(rs.getString("facilitymail"));
						facilities.add(facility);
					}
					return facilities;
				}
			}
		} catch (SQLException | IOException se) {
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public boolean verifyLogin(String mail, String password, String userType) {
		
		PreparedStatement ptsmt = null;
		ResultSet rs = null;
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				con = JDBCUtil.getConnection();
				if (userType.equalsIgnoreCase("player")) {
					String selectQuery = "select usermail,password from userinfo where usermail=? and password=?";
					ptsmt = con.prepareStatement(selectQuery);
					if (ptsmt != null) {
						ptsmt.setString(1, mail);
						ptsmt.setString(2, password);
						rs = ptsmt.executeQuery();
						if (rs.next()) {
							return true;
						}
					}
				} else if (userType.equalsIgnoreCase("manager")) {
					String selectQuery = "select adminmail,password from admininfo where adminmail=? and password=?";
					ptsmt = con.prepareStatement(selectQuery);
					if (ptsmt != null) {
						ptsmt.setString(1, mail);
						ptsmt.setString(2, password);
						rs = ptsmt.executeQuery();
						if (rs.next()) {
							return true;
						}

					}

				}
			}
		} catch (SQLException | IOException se) {
			return false;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
			}
		}
		return false;
	}

	@Override
	public ArrayList<Facility> getAllFacilities(String ownerMail) {
		String selectQuery = "select * from facility where facilityownermailid=?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Facility> facilities = null;
		Facility facility = null;
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(selectQuery);
				if (pstmt != null) {
					pstmt.setString(1, ownerMail);
					rs = pstmt.executeQuery();
					facilities = new ArrayList<Facility>();
					while (rs.next()) {
						facility = new Facility();
						facility.setFname(rs.getString("facilityname"));
						facility.setFsport(rs.getString("facilitysport"));
						facility.setFloc(rs.getString("facilityloc"));
						facility.setFmail(rs.getString("facilitymail"));
						facility.setFphone(rs.getString("facilitypnumber"));
						facility.setFowner(rs.getString("facilityowner"));
						facilities.add(facility);

					}
					return facilities;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public String deleteFacility(String facilityName) {
		PreparedStatement pstmt = null;
		String deleteQuery = "delete from facility where facilityname=?";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(deleteQuery);
				if (pstmt != null) {
					pstmt.setString(1, facilityName);
					int rowsAffected = pstmt.executeUpdate();
					if (rowsAffected == 1) {
						return "success";
					}
				}

			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return "error";
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "error";
				}
			}
		}
		return "failed";
	}

	@Override
	public String registerFacility(Facility facility) {
		PreparedStatement pstmt = null;
		String insertQuery = "insert into facility (facilityname,facilityowner,facilitypnumber,facilitysport,facilityloc,facilitymail,facilityownermailid) values(?,?,?,?,?,?,?)";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(insertQuery);
				if (pstmt != null) {
					pstmt.setString(1, facility.getFname());
					pstmt.setString(2, facility.getFowner());
					pstmt.setString(3, facility.getFphone());
					pstmt.setString(4, facility.getFsport());
					pstmt.setString(5, facility.getFloc());
					pstmt.setString(6, facility.getFmail());
					pstmt.setString(7, facility.getFomail());

					int rowsAffected = pstmt.executeUpdate();
					if (rowsAffected == 1) {
						return "success";
					}

				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return "error";
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "error";
				}
			}
		}

		return "failed";
	}

	@Override
	public Facility getFacility(String facilityName) {
		Facility facility = null;
		String selectQuery = "select facilityname,facilityowner,facilitypnumber,facilitysport,facilityloc,facilitymail from facility where facilityname=?";
		PreparedStatement pstmt = null;
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(selectQuery);
				if (pstmt != null) {
					pstmt.setString(1, facilityName);
					ResultSet rs = pstmt.executeQuery();
					if (rs.next()) {
						facility = new Facility();
						facility.setFname(rs.getString(1));
						facility.setFowner(rs.getString(2));
						facility.setFphone(rs.getString(3));
						facility.setFsport(rs.getString(4));
						facility.setFloc(rs.getString(5));
						facility.setFmail(rs.getString(6));
						return facility;
					}
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return facility;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return facility;
	}

	@Override
	public String updateFaciltiy(Facility facility, String facilityName) {
		PreparedStatement pstmt = null;
		String updateQuery = "update facility set facilityname='" + facility.getFname() + "', facilityowner='"
				+ facility.getFowner() + "',facilitypnumber='" + facility.getFphone() + "',facilitysport='"
				+ facility.getFsport() + "',facilityloc='" + facility.getFloc() + "',facilitymail='"
				+ facility.getFmail() + "' where facilityownermailid=? and facilityname=?";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(updateQuery);
				if (pstmt != null) {
					pstmt.setString(1, facility.getFomail());
					pstmt.setString(2, facilityName);
					int rowsAffected = pstmt.executeUpdate();
					if (rowsAffected == 1) {
						return "success";
					}
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return "error";
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "error";
				}
			}
		}
		return "failed";
	}

	@Override
	public String bookFacility(Booking booking) {
		PreparedStatement pstmt = null;
		String insertQuery = "Insert into bookings (bookdate,facilityname,usermail,booktype) values(?,?,?,?)";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(insertQuery);
				if (pstmt != null) {
					pstmt.setObject(1, booking.getBookDate());
					pstmt.setString(2, booking.getFname());
					pstmt.setString(3, booking.getUserMail());
					pstmt.setString(4, booking.getBookType());
					int rowsAffected = pstmt.executeUpdate();
					if (rowsAffected == 1) {
						return "success";
					}

				}
			}
		} catch (SQLIntegrityConstraintViolationException sie) {
			return "integrityerror";
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return "error";
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "error";
				}
			}
		}

		return "failed";
	}

	@Override
	public ArrayList<Booking> getMyBookings(String userMail) {
		PreparedStatement pstmt = null;
		ArrayList<Booking> bookings = null;
		ResultSet rs = null;
		Booking booking = null;
		String selectQuery = "Select bookdate,facilityname,usermail,booktype from bookings where usermail=? ";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(selectQuery);
				if (pstmt != null) {
					pstmt.setString(1, userMail);
					rs = pstmt.executeQuery();
					bookings = new ArrayList<Booking>();

					while (rs.next()) {
						booking = new Booking();
						booking.setFname(rs.getString("facilityname"));
						booking.setBookDate(LocalDate.parse(rs.getString("bookdate")));
						booking.setBookType(rs.getString("booktype"));
						booking.setUserMail(userMail);
						bookings.add(booking);

					}
					return bookings;
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public String cancelFacility(String facilityName, LocalDate bookDate) {
		PreparedStatement pstmt = null;
		String deleteQuery = "delete from bookings where facilityname=? and bookdate = ? ";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(deleteQuery);
				if (pstmt != null) {
					pstmt.setString(1, facilityName);
					pstmt.setObject(2, bookDate);
					int rowsAffected = pstmt.executeUpdate();
					if (rowsAffected == 1) {
						return "success";
					}
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return "error";
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "error";
				}
			}
		}
		return "failed";
	}

	@Override
	public ArrayList<Booking> getBookings(String ownerMail) {

		PreparedStatement pstmt = null;
		ArrayList<Booking> bookings = new ArrayList<Booking>();
		ResultSet rs = null;
		Booking booking = null;
		String selectQuery = "Select bookdate,facilityname,usermail,booktype from bookings where facilityname in(select facilityname from facility where  facilityownermailid=?) ";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(selectQuery);
				if (pstmt != null) {
					pstmt.setString(1, ownerMail);
					rs = pstmt.executeQuery();

					while (rs.next()) {
						booking = new Booking();
						booking.setFname(rs.getString("facilityname"));
						booking.setBookDate(LocalDate.parse(rs.getString("bookdate")));
						booking.setBookType(rs.getString("booktype"));
						booking.setUserMail(rs.getString("usermail"));

						bookings.add(booking);

					}
					System.out.println(bookings);
					return bookings;
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public String adminCancelFacility(String facilityName, LocalDate bookDate) {
		PreparedStatement pstmt = null;
		String deleteQuery = "delete from bookings where facilityname=? and bookdate = ? ";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(deleteQuery);
				if (pstmt != null) {
					pstmt.setString(1, facilityName);
					pstmt.setObject(2, bookDate);
					int rowsAffected = pstmt.executeUpdate();
					if (rowsAffected == 1) {
						return "success";
					}
				}
			}

		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return "error";
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "error";
				}
			}
		}
		return "failed";
	}

	@Override
	public String updateInbox(String usermail, String reason) {
		PreparedStatement pstmt = null;
		String insertQuery = "insert into inbox(usermail,message) values(?,?) ";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(insertQuery);
				if (pstmt != null) {
					pstmt.setString(1, usermail);
					pstmt.setString(2, reason);
					int rowsAffected = pstmt.executeUpdate();
					if (rowsAffected == 1) {
						return "success";
					}
				}
			}

		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return "error";
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "error";
				}
			}
		}
		return "failed";
	}

	@Override
	public ArrayList<Inbox> getMessages(String usermail) {
		PreparedStatement pstmt = null;
		ArrayList<Inbox> messages = null;
		ResultSet rs = null;
		Inbox inbox = null;
		String selectQuery = "Select usermail,message from inbox where usermail=? ";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(selectQuery);
				if (pstmt != null) {
					pstmt.setString(1, usermail);
					rs = pstmt.executeQuery();
					messages = new ArrayList<Inbox>();
					while (rs.next()) {
						inbox = new Inbox();
						inbox.setUserMail(rs.getString("usermail"));
						inbox.setMessage(rs.getString("message"));
						messages.add(inbox);

					}
					return messages;
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public ArrayList<Booking> getHostings(String userMail) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Booking> hostings = null;
		Booking booking = null;
		String selectQuery = "select bookdate,facilityname from bookings where usermail=? and booktype=?";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(selectQuery);
				if (pstmt != null) {
					pstmt.setString(1, userMail);
					pstmt.setString(2, "host");
					rs = pstmt.executeQuery();
					hostings = new ArrayList<Booking>();
					while (rs.next()) {
						booking = new Booking();
						booking.setBookDate(LocalDate.parse(rs.getString("bookdate")));
						booking.setFname(rs.getString("facilityname"));
						booking.setUserMail(userMail);
						booking.setBookType("host");
						hostings.add(booking);
					}
					return hostings;
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public ArrayList<Booking> getAllHostings(String userMail) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Booking> hostings = null;
		Booking booking = null;
		String selectQuery = "select bookdate,facilityname,usermail from bookings where usermail!=? and booktype=?";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(selectQuery);
				if (pstmt != null) {
					pstmt.setString(1, userMail);
					pstmt.setString(2, "host");
					rs = pstmt.executeQuery();
					hostings = new ArrayList<Booking>();
					while (rs.next()) {
						booking = new Booking();
						booking.setBookDate(LocalDate.parse(rs.getString("bookdate")));
						booking.setFname(rs.getString("facilityname"));
						booking.setUserMail(rs.getString("userMail"));
						booking.setBookType("host");
						hostings.add(booking);
					}
					return hostings;
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public String sendJoinRequest(Hosting hosting) {
		PreparedStatement pstmt = null;
		String insertQuery = "insert into hostinginfo (bookdate,facilityname,usermail,hostmail,joinstatus) values(?,?,?,?,?)";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(insertQuery);
				if (pstmt != null) {
					pstmt.setObject(1, hosting.getBdate());
					pstmt.setString(2, hosting.getFname());
					pstmt.setString(3, hosting.getUserMail());
					pstmt.setString(4, hosting.getHostMail());
					pstmt.setString(5, hosting.getStatus());
					int rowsAffected = pstmt.executeUpdate();
					if (rowsAffected == 1) {
						return "success";
					}
				}
			}

		} catch (SQLIntegrityConstraintViolationException ie) {
			ie.printStackTrace();
			return "already";
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return "error";
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "error";
				}
			}
		}
		return "failed";
	}

	@Override
	public ArrayList<Hosting> getHostingRequests(String hostMail) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select bookdate,facilityname,usermail from hostinginfo where hostmail=? and joinstatus='pending'";
		ArrayList<Hosting> requests = null;
		Hosting hosting = null;
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(selectQuery);
				if (pstmt != null) {
					pstmt.setString(1, hostMail);
					rs = pstmt.executeQuery();
					requests = new ArrayList<Hosting>();
					while (rs.next()) {
						hosting = new Hosting();
						hosting.setBdate(LocalDate.parse(rs.getString("bookdate")));
						hosting.setFname(rs.getString("facilityname"));
						hosting.setUserMail(rs.getString("usermail"));
						requests.add(hosting);
					}
					return requests;
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public String acceptJoinRequest(Hosting hosting) {
		PreparedStatement pstmt = null;
		String updateQuery = "update hostinginfo set joinstatus='" + hosting.getStatus()
				+ "' where bookdate=? and facilityname=? and usermail = ?";
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(updateQuery);
				if (pstmt != null) {
					pstmt.setObject(1, hosting.getBdate());
					pstmt.setString(2, hosting.getFname());
					pstmt.setString(3, hosting.getUserMail());
					int rowsAffected = pstmt.executeUpdate();
					if (rowsAffected == 1) {
						if (hosting.getStatus().equalsIgnoreCase("accept")) {
							return "accepted";
						} else if (hosting.getStatus().equalsIgnoreCase("decline")) {
							return "declined";
						}
					}
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return "error";
				}
			}
		}
		return "failed";
	}

	@Override
	public Admin getAdminInfo(String mail) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select adminname,adminphone from admininfo where adminmail=?";
		Admin admin = null;
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(selectQuery);
				if (pstmt != null) {
					pstmt.setString(1, mail);
					rs = pstmt.executeQuery();
					admin = new Admin();
					while (rs.next()) {
						admin.setName(rs.getString("adminname"));
						admin.setpNumber(rs.getString("adminphone"));
					}
					return admin;
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public User getUserInfo(String mail) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectQuery = "select username,userphone from userinfo where usermail=?";
		User user = null;
		try {
			con = JDBCUtil.getConnection();
			if (con != null) {
				pstmt = con.prepareStatement(selectQuery);
				if (pstmt != null) {
					pstmt.setString(1, mail);
					rs = pstmt.executeQuery();
					user = new User();
					while (rs.next()) {
						user.setName(rs.getString("username"));
						user.setpNumber(rs.getString("userphone"));
					}
					return user;
				}
			}
		} catch (SQLException | IOException se) {
			se.printStackTrace();
			return null;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
					return null;
				}
			}
		}
		return null;
	}

}
