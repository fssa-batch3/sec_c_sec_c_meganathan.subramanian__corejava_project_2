package com.fssa.bookstore.validatorerrors;

public class OrderValidatorsErrors {

	private OrderValidatorsErrors() {
		
	}
	
	public static final String ORDER_OBJ_NULL = "order obj is null";
	
	public static final String INVALID_USER_ID = "user id is invalid";

	public static final String INVALID_BOOK_NAME = "Given Book name can't be null and it limit below 50 letters above 10";

	public static final String INVALID_BOOK_NAME_NULL = "Given Book name can't be null";
	
	public static final String INVALID_PRODUCT_ID = "Product id is invalid";
	
	public static final String INVAILD_ORDER_ID  = "order id is invalid";
	
	public static final String INVALID_QTY  = "qty is invalid";
	
	public static final String INVALID_USER_EMAIL_NULL = "user email cannot be null";
	
	public static final String INVALID_USER_EMAIL = "user email cannot be empty or invalid";
	
	public static final String INVALID_USER_CITY_NULL = "User City cannot be null";
	
	public static final String INVALID_USER_CITY = "User city are invalid are empty";
	
	public static final String INVALID_USER_PINCODE = "User pincode must be 6 digits cannot be empty or invalid";
	
	public static final String INVALID_USER_STATE_NULL = "user state cannot be null";
	
	public static final String INVALID_USER_STATE = "User State must give the space And cannot be empty or invalid";
	
	public static final String INVALID_USER_ADDRESS_NULL = "User address is null";
	
	public static final String INVALID_USER_ADDRESS = "user address is invalid or out of range";
	
	public static final String INVALID_USER_PHONE_NUMBER = "phone number are empty invalid or out of limit";
	
	public static final String INVALID_PUBLISHER_DATE_NULL = "Given Publisher date is null or empty";

	public static final String INVALID_PUBLISHER_DATE = "Given Publisher date is invalid or can'be be before and after date";
			
}
