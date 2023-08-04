package com.fssa.book.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.book.enums.Bookcategories;
import com.fssa.book.model.Book;
import com.fssa.book.model.BookValidateErrors;

public class BookValidator {

	public static boolean validate(Book book) throws IllegalArgumentException {

		if (book == null) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_NULL);
		}

		validateBookName(book.getBookName());
		validateBookId(book.getBookId());
		validateBookPrice(book.getBookPrice());
		validateBookCategoriesName(book.getBookCategories());
		validateBookLanguages(book.getBooklanguage());
		validateBookQuantity(book.getQuantity());
		validateAuthorName(book.getAuthor());
		validateBookImageUrl(book.getBookImage());
		validateBookDescription(book.getBookDescription());

		return true;
	}

	// Below the code for validate
	public static boolean validateBookName(String bookName) throws IllegalArgumentException {
		if (bookName == null) {

			throw new IllegalArgumentException(BookValidateErrors.INVAILD_BOOK_NAME_NULL);
		}

		// Below the code for Regex pattern
		String regx = "^[A-Za-z ]+$";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(bookName);
		boolean isMatch = matcher.matches();
		if (bookName.trim().equals("")) {

			throw new IllegalArgumentException(BookValidateErrors.INVAILD_BOOK_NAME);
		}

		return true;
	}

	// Below the code for validate the BookId
	public static boolean validateBookId(int bookId) throws IllegalArgumentException {
		if (bookId < 0) {
			throw new IllegalArgumentException(BookValidateErrors.INVAILD_BOOKID);
		}
		return true;
	}

	// Below the code for validate the bookPrice
	public static boolean validateBookPrice(double Price) throws IllegalArgumentException {
		if (Price <= 0.0 || Price > 1300.00) {
			throw new IllegalArgumentException(BookValidateErrors.INVAILD_BOOK_PRICE);
		}
		return true;
	}

	// Code for Validate the bookCatergories

	public static boolean validateBookCategoriesName(String bookCategoriesName) throws IllegalArgumentException {

		if (bookCategoriesName == null || bookCategoriesName.trim().equals("")) {
			throw new IllegalArgumentException(BookValidateErrors.INVAID_BOOK_CATEGORIES_NULL);
		}

		// Code for Regex pattern
		String regex = "^[A-Za-z ]+$";
		Pattern pattern = Pattern.compile(regex); // Compile the pattern
		Matcher matcher = pattern.matcher(bookCategoriesName); // using matcher object of check the whether match or not
		boolean isMatch = matcher.matches(); // And return the boolean value

		if (bookCategoriesName.toLowerCase().length() > 20 || !isMatch) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_CATEGOIRES_NAME);
		}

		else {
			validateCategoryName(bookCategoriesName);
			return true;
		}

	}

	// below the code for validate the category name

	public static boolean validateCategoryName(String mainCategory) throws IllegalArgumentException {

		if (mainCategory == null) {
			throw new IllegalArgumentException(BookValidateErrors.INVAID_BOOK_CATEGORIES_NULL);
		}

		for (Bookcategories category : Bookcategories.values()) {

			if (category.getValue().equals(mainCategory)) {
				return true;
			}
		}

		throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_CATEGOIRES_NAME);
	}

	// code for the book image URL

	public static boolean validateBookImageUrl(String bookImageUrl) throws IllegalArgumentException {

		if (bookImageUrl == null || bookImageUrl.trim().equals("")) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_IMAGE_URL);
		}

		// Code for Regex pattern
		String regex = "(?i)\\b((https?|ftp)://)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?\\.(jpg|jpeg|gif|png|bmp)\\b";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(bookImageUrl);
		boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_IMAGE_URL);
		} else {
			return true;
		}

	}

	// code for validate the book language

	public static boolean validateBookLanguages(String bookLanguage) throws IllegalArgumentException {

		if (bookLanguage == null) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME_NULL);
		}

		// Code for Regex pattern
		String regex = "^[A-Za-z ]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(bookLanguage);
		boolean isMatch = matcher.matches(); // this is the new way to check the value

		if (bookLanguage.trim().equals("") || bookLanguage.trim().length() > 20 || !isMatch) {

			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME);
		}

		else {
			return true;
		}
	}

	// Below the code for validate the Book quantity

	public static boolean validateBookQuantity(int bookQuantity) throws IllegalArgumentException {
		if (bookQuantity < 0 || bookQuantity > 20) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_QUANTITY);
		}
		return true;
	}

	// Below the code for Validate the author name

	public static boolean validateAuthorName(String AuthorName) throws IllegalArgumentException {

		if (AuthorName == null) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_AUTHOR_NAME_NULL);
		}

		// Code for Regex pattern
		String regex = "^[A-Za-z ]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(AuthorName);
		boolean isMatch = matcher.matches(); // this is the new way to check the value

		if (AuthorName.trim().equals("") || AuthorName.trim().length() > 20 || !isMatch) {
			throw new IllegalArgumentException(BookValidateErrors.INVAID_BOOK_AUTHOR_NAME);
		}

		else {
			return true;
		}

	}

	// Below the code for validate the book Description
	public static boolean validateBookDescription(String bookDescription) throws IllegalArgumentException {
		if (bookDescription == null) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_DESCRIPTION_NULL);

		}

		// Code for Regex pattern
		String regex = "^[A-Za-z0-9,@ ?.?\s]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(bookDescription);
		boolean isMatch = matcher.matches(); // this is the new way to check the value

		if (bookDescription.trim().equals("") || bookDescription.trim().length() > 400 || !isMatch) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_DESCRIPTION);
		} else {
			return true;
		}

	}

}