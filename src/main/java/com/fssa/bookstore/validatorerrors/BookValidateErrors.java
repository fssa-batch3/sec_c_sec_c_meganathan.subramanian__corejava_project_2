package com.fssa.bookstore.validatorerrors;

/**
 * Create Exception errors in the different package and access it This
 * BookValidatorError main purpose is once we have created the final keyword
 * with the String we can access it mutliple class and multiple times This way
 * is one of the best practice Also.
 * 
 * @author MeganathanSubramania
 */
public class BookValidateErrors {

	private BookValidateErrors() {
		// restrict instantiation
	}

	// Below the code for custom write the errors

	public static final String INVALID_BOOK_NULL = "Given Book obj can't be a null";

	public static final String INVALID_BOOK_NAME = "Given Book name can't be null and it limit below 50 letters above 10";

	public static final String INVALID_BOOK_NAME_NULL = "Given Book name can't be null";

	public static final String INVALID_BOOKID = "Given Book ID can't be zero or negative";

	public static final String INVALID_BOOK_PRICE = "Given Book Price must 300 to 1000";

	public static final String INVALID_BOOK_CATEGORIES_NULL = "Given Book categories can't be null";

	public static final String INVALID_BOOK_CATEGOIRES_NAME = "Given book categories name out of limit or Invalid";

	public static final String INVALID_BOOK_IMAGE_URL = "Given Book image are Invalid or null";

	public static final String INVALID_BOOK_LANGUAGE_NAME_NULL = "Given Book language name cannot be null";

	public static final String INVALID_BOOK_LANGUAGE_NAME = "Given Invalid book language name";

	public static final String INVALID_BOOK_QUANTITY = "Givenb ook quantity are out of limit or invalid";

	public static final String INVALID_BOOK_AUTHOR_NAME_NULL = "Given Book author name can't be null";

	public static final String INVALID_BOOK_AUTHOR_NAME = "Given Author name can't be empty or out of limit";

	public static final String INVALID_BOOK_DESCRIPTION_NULL = "Given Book description can't be null";

	public static final String INVALID_BOOK_DESCRIPTION = "Given book description can't be empty or out of limit";

	public static final String INVALID_BOOK_ABOUT_AUTHOR_NULL = "Given About the author can't be empty isn't null";

	public static final String INVALID_BOOK_ABOUT_AUTHOR = "Given you must give the details of about author above 600 letters";

	public static final String INVALID_AUTHOR_IMG_URL_NULL = "Given Author img url can't be null or empty";

	public static final String INVALID_AUTHOR_IMG_URL = "Given Author img url is invalid";

	public static final String INVALID_BOOK_BINDING_NULL = "Given Book binding is  null or empty or invalid";

	public static final String INVAILD_BOOK_HEIGHT = "Given book height can't be null or empty you must give range 5 to 10 inches";

	public static final String INVALID_NO_OF_PAGES = "Given book pages can't be null or empty must give range 1 to 1200 ";

	public static final String INVALID_BOOK_WEIGHT = "Given book weight can't be null empty you must give in grams range  28 to 910 ";

	public static final String INVALID_PUBLSHER_IMPRINT_NULL = "Given Publilser is empty or null";

	public static final String INVALID_PUBLSHER_IMPRINT = "Given Publilser is empty or invalid it must be above 4 to 20 characters";

	public static final String BOOK_INVALID_DEPTH = "Given book depth can'be null or empty";

	public static final String INVALID_BOOK_RETURN = "Given book return can't be null or empty";

	public static final String INVALID_BOOK_WIDTH = "Given book width can't be null or empty";

	public static final String INVALID_BOOK_ISBN_NULL = "Given Book Isbn are empty or invalid must give the 13 number";

	public static final String INVALID_BOOK_ISBN = "Given Book Isbn are empty or invalid must give the 13 number";

	public static final String INVALID_PUBLISHER_DATE_NULL = "Given Publisher date is null or empty";

	public static final String INVALID_PUBLISHER_DATE = "Given Publisher date is invalid or can'be be before and after date";

}
