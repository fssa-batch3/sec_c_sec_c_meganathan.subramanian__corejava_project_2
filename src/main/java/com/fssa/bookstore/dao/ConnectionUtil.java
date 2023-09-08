package com.fssa.bookstore.dao;

import java.sql.Connection;
import java.sql.DriverManager;

import com.fssa.bookstore.logger.Logger;

/**
 * Below the code for connect the Database and fetch the value
 * 
 * @author MeganathanSubramania
 */

public class ConnectionUtil {

	public Connection getConnection() {

		Connection con = null;

		String url;
		String userName;
		String passWord;

		url = System.getenv("DATABASE_HOST");
		userName = System.getenv("DATABASE_USERNAME");
		passWord = System.getenv("DATABASE_PASSWORD");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, userName, passWord);
			System.out.println("Database connected Successfully");
		} catch (Exception e) {
			e.printStackTrace();
			throw new IllegalArgumentException("Unable to connect to the database");
		}
		return con;
	}
	
	public static void main(String[] args) {
		ConnectionUtil con = new ConnectionUtil();
		con.getConnection();
	}
	
	

}
