package com.fssa.bookstore.validatorerrors;

public interface UserValidatorsErrors {
	
	// Below the code for Custom write the User error
	
	public static final String INVALID_USEROBJ_NULL = "User obj cannot be null or empty";
	
	public static final String INVALID_USER_NAME_NULL  = "user name can't be null";
	
	public static final String INVALID_USER_NAME = "user name can't be empty or out of limit";
	
	public static final String INVALID_USER_PHONE_NUMBER = "phone number are empty invalid or out of limit";
	
	public static final String INVALID_USER_EMAIL_NULL = "user email cannot be null";
	
	public static final String INVALID_USER_EMAIL = "user email cannot be empty or invalid";

	public static final String INVALID_USER_PASSWORD_NULL = "user password cannot be null";
	
	public static final String INVALID_USER_PASSWORD = "user password are invalid";
	
	public static final String INVALID_USER_STATE_NULL = "user state cannot be null";
	
	public static final String INVALID_USER_STATE = "User State cannot be empty or invalid";
	
	public static final String INVALID_USER_CITY_NULL = "User City cannot be null";
	
	public static final String INVALID_USER_CITY = "User city are invalid are empty";
	
	public static final String INVALID_USER_PINCODE = "User pincode cannot be empty or invalid";
}
