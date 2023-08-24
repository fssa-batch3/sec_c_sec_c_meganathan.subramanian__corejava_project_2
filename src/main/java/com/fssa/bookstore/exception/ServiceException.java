package com.fssa.bookstore.exception;


public class ServiceException extends Exception {

	/**
	 *  below the code for create the custom exception 
	 *  @author MeganathanSubramania
	 */
	private static final long serialVersionUID = 5295183565981400140L;

	public ServiceException(String msg) {
		super(msg);
	}
}
