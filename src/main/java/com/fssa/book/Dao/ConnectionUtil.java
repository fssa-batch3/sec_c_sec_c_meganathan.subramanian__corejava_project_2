package com.fssa.book.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	private  static final String DB_URL = "jdbc:mysql://:3306/bookstore";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "root";
	
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
	}

} 
