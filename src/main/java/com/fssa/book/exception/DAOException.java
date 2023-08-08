package com.fssa.book.exception;

public class DAOException extends Exception {
	
	public DAOException(String msg) {
		super(msg);
	}
	public static final String ERROR_CONNECTION_DB = "Error connection the database";
}
