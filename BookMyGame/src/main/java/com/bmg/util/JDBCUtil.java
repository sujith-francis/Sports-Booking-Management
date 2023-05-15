package com.bmg.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;

public class JDBCUtil {
	private JDBCUtil() {

	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException, IOException {
		// String
		// loc="D:\\Projects\\BookMyGame\\src\\main\\java\\com\\bmg\\dbproperty\\db.properties";
		String loc = "D:\\Projects\\BookMyGame\\src\\main\\java\\com\\bmg\\dbproperty\\db1.properties";
		/*
		 * HikariConfig hikariConfig= new HikariConfig(loc); HikariDataSource
		 * hikariDataSource = new HikariDataSource(hikariConfig); Connection connection
		 * = hikariDataSource.getConnection();
		 */

		FileInputStream fis = new FileInputStream(loc);
		Properties properties = new Properties();
		properties.load(fis);
		String url =	properties.getProperty("url");
		String user = properties.getProperty("user");
		String password = properties.getProperty("password");
		Connection connection = DriverManager.getConnection(url, user, password);

		return connection;
	}
}
