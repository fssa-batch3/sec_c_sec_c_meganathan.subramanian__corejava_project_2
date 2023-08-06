package com.fssa.book.model;

/**
 * Create Exception errors in the different package and access it.
 */
public interface BookValidateErrors {

	// Below the code for custom write the errors
	
	public static final String INVALID_BOOK_NULL = "Book can't be a null";
	
	public static final String INVALID_BOOK_NAME = "Book name can't be null and it limit below 50 letters above 10";

	public static final String INVALID_BOOK_NAME_NULL = "Book name can't be null";
	
	public static final String INVALID_BOOKID  = "Book ID can't be null or less than zero";
	
	public static final String INVALID_BOOK_PRICE = "Book name can't be 0 or out of limit";
	
	public static final String INVALID_BOOK_CATEGORIES_NULL  = "Book categories can't be null";
	
	public static final String INVALID_BOOK_CATEGOIRES_NAME  = "book categories name out of limit or Invalid";
	
	public static final String INVALID_BOOK_IMAGE_URL = "Book image are Invalid or null";
	
	public static final String INVALID_BOOK_LANGUAGE_NAME_NULL = "Book language name cannot be null";
	
	public static final String INVALID_BOOK_LANGUAGE_NAME = "Invalid book language name";
	
	public static final String INVALID_BOOK_QUANTITY = "book quantity are out of limit or invalid";
	
	public static final String INVALID_BOOK_AUTHOR_NAME_NULL = "Book author name can't be null";
	
	public static final String INVAID_BOOK_AUTHOR_NAME = "Author name can't be empty or out of limit";
	
	public static final String INVALID_BOOK_DESCRIPTION_NULL = "Book description can't be null";
	
	public static final String INVALID_BOOK_DESCRIPTION = "book description can't be empty or out of limit";
	 
}
