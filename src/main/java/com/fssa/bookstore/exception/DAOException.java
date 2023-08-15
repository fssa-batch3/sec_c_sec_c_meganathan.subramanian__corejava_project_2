package com.fssa.bookstore.exception;

public class DAOException extends Exception {
	
	/**
	 * Below the code for create the custom exception
	 * 
	 */
	private static final long serialVersionUID = -6562603679142597068L;
	public DAOException(String msg) {
		super(msg); 
	}
	public static final String ERROR_CONNECTION_DB = "Error connection the database";
}
