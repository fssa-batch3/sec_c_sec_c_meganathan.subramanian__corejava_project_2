package com.fssa.bookstore.exception;

public class InvalidInputException extends Exception {

	/**
	 * below the code for create the custom exception
	 */
	private static final long serialVersionUID = -3621690694454231622L;
	
	public InvalidInputException(String msg) {
		super(msg);
	}
	
	public static final String INVALID_INPUT = "Given inputs are null or empty or invalid";

}
