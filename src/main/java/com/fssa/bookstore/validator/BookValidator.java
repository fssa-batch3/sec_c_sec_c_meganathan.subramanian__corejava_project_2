package com.fssa.bookstore.validator;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;

/**
 * Below the code for validate the all attributes
 * @author MeganathanSubramania
 */

import java.util.regex.Pattern;

import com.fssa.bookstore.constants.BookValidatorConstants;
import com.fssa.bookstore.dao.BookDao;
import com.fssa.bookstore.enums.BookBinding;
import com.fssa.bookstore.enums.BookReturnable;
import com.fssa.bookstore.enums.Categories;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.exception.InvalidInputException;
import com.fssa.bookstore.model.Book;
import com.fssa.bookstore.validatorerrors.BookValidateErrors;

public class BookValidator {
   
	/**
	 * Below the code for validate the all attribute and get the value from it.
	 *
	 * @param book
	 * @return
	 * @throws IllegalArgumentException
	 * @throws InvalidInputException
	 */
	public boolean validate(Book book) throws IllegalArgumentException, InvalidInputException {

		if (book == null) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_NULL);
		}
 
		validateBookName(book.getBookName());
		validateBookPrice(book.getBookPrice());
		validateBookCategoriesName(book.getBookCategories());
		validateBookLanguages(book.getBooklanguage());
		validateBookQuantity(book.getQuantity());
		validateAuthorName(book.getAuthor());
		validateBookImageUrl(book.getBookImageUrl());
		validateBookDescription(book.getBookDescription());
		validateAuthorImgUrl(book.getAuthorImg());
		validateBookIsbn(book.getisbn());
		validateAboutAuthor(book.getAboutAuthor());
		validatebookReturn(book.getReturnable());
		validateBookWidth(book.getBookwidth());
		validateBookDepth(book.getBookDepth());
		validateBookHeight(book.getBookHeight());
		validateBookBinding(book.getBookBinding());
		validatePublisherImprintName(book.getPublisherImprint());
		validateBookWeight(book.getBookWeight());
		validatePublisherDate(book.getPublisherDate());
		validateNoOfPages(book.getNoOfPages());
		return true;
	}

	/**
	 * Below the code for check the book id.
	 * 
	 * @param bookId
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean validateBookId(int bookId) throws IllegalArgumentException {
		if (bookId <= 0) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOKID);
		}
		return true;
	}

	public boolean CheckBookIdExist(int bookId) throws IllegalArgumentException {

		BookDao bookDAO = new BookDao();
		try {
			bookDAO.CheckBookIdExist(bookId);
			return true;
		} catch (DAOException | SQLException e) {
			throw new IllegalArgumentException("Given book id does not exists in the database" + e.getMessage());
		}

	}

	/**
	 * Below the code for validate the book Name.
	 *
	 * @param bookName
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validateBookName(String bookName) throws IllegalArgumentException {
		if (bookName == null) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_NAME_NULL);
		}

		// Below the code for Regex pattern
		String regx = BookValidatorConstants.REGEX_NAMES;
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(bookName);
		boolean isMatch = matcher.matches();
		if ("".trim().equals(bookName) || bookName.trim().length() > BookValidatorConstants.FORTY
				|| bookName.trim().length() < BookValidatorConstants.THREE || !isMatch) {

			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_NAME);
		}

		return true;
	}

	/**
	 * Below the code for validate the book price
	 *
	 * @param Price
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validateBookPrice(double price) throws IllegalArgumentException {
		if (price <= BookValidatorConstants.THREE_FIFTY || price > BookValidatorConstants.THOUSAND_THREE_HUNDRED) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_PRICE);
		}
		return true;
	}

	/**
	 * Below the code for validate the all enums Remind it all constant
	 *
	 * @param category
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean validateBookCategoriesName(Categories category) throws IllegalArgumentException {

		if (category == null) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_CATEGORIES_NULL);
		} else {
			return true;
		}

	}

	/**
	 * Below the code for validate the book width And limit is 4 to 9 inches .
	 * 
	 * @param bookWidth
	 * @return
	 * @throws IllegalArgumentException
	 * @throws InvalidInputException
	 */

	public boolean validateBookWidth(double bookWidth) throws IllegalArgumentException, InvalidInputException {

		if (bookWidth < BookValidatorConstants.MIN_BOOK_WIDTH_INCHES
				|| bookWidth > BookValidatorConstants.MAX_BOOK_WIDTH_INCHES) {
			throw new InvalidInputException(BookValidateErrors.INVALID_BOOK_WIDTH);
		} else {
			return true;
		}
	}

	/**
	 * Below the code for validate the no of pages
	 * 
	 * @param noOfPages
	 * @return
	 * @throws IllegalArgumentException
	 * @throws InvalidInputException
	 */
	public boolean validateNoOfPages(int noOfPages) throws IllegalArgumentException, InvalidInputException {

		if (noOfPages < BookValidatorConstants.MIN_PAGES || noOfPages > BookValidatorConstants.MAX_PAGES) {
			throw new InvalidInputException(BookValidateErrors.INVALID_NO_OF_PAGES);
		} else {
			return true;
		}
	}

	/**
	 * Below the code for validate the book height it will limit on 5 to 10 inches
	 * 
	 * @param bookheight
	 * @return
	 * @throws IllegalArgumentException
	 * @throws InvalidInputException
	 */

	public boolean validateBookHeight(double bookheight) throws IllegalArgumentException, InvalidInputException {
		if (bookheight < BookValidatorConstants.MIN_BOOK_HEIGHT_INCHES
				|| bookheight > BookValidatorConstants.MAX_BOOK_HEIGHT_INCHES) {
			throw new InvalidInputException(BookValidateErrors.INVAILD_BOOK_HEIGHT);
		} else {
			return true;
		}
	}

	/**
	 * Below the code for validate the book depth And it will limit the 0.1 to 3.0
	 * inches
	 * 
	 * @param bookDepth
	 * @return 
	 * @throws IllegalArgumentException
	 * @throws InvalidInputException
	 */

	public boolean validateBookDepth(double bookDepth) throws IllegalArgumentException, InvalidInputException {
		if (bookDepth < BookValidatorConstants.MIN_BOOK_DEPTH_INCHES
				|| bookDepth > BookValidatorConstants.MAX_BOOK_DEPTH_INCHES) {
			throw new InvalidInputException(BookValidateErrors.BOOK_INVALID_DEPTH);

		} else {
			return true;
		}
	}

	/**
	 * Below the code for validate the book weight it limit in 28 to 910 grams
	 * 
	 * @param bookWeight
	 * @return
	 * @throws IllegalArgumentException
	 * @throws InvalidInputException
	 */
	public boolean validateBookWeight(double bookWeight) throws IllegalArgumentException, InvalidInputException {
		if (bookWeight < BookValidatorConstants.MIN_BOOK_WEIGHT_GRAMS
				|| bookWeight > BookValidatorConstants.MAX_BOOK_WEIGHT_GRAMS) {
			throw new InvalidInputException(BookValidateErrors.INVALID_BOOK_WEIGHT);
		} else {
			return true;
		}
	}

	/**
	 * Below the code for Validate the book binding And it's a enum
	 * 
	 * @param bookBinding
	 * @return
	 * @throws IllegalArgumentException
	 * @throws InvalidInputException
	 */

	public boolean validateBookBinding(BookBinding bookBinding) throws IllegalArgumentException, InvalidInputException {
		if (bookBinding == null) {
			throw new InvalidInputException(BookValidateErrors.INVALID_BOOK_BINDING_NULL);
		} else {
			return true;
		}
	}

	/**
	 * Below the code for validate the book returnable And it's a enum type
	 * 
	 * @param bookReturnable
	 * @return
	 * @throws IllegalArgumentException
	 * @throws InvalidInputException
	 */

	public boolean validatebookReturn(BookReturnable bookReturnable)
			throws IllegalArgumentException, InvalidInputException {
		if (bookReturnable == null) {
			throw new InvalidInputException(BookValidateErrors.INVALID_BOOK_RETURN);
		} else {
			return true;
		}
	}

	/**
	 * Below the code for validate the author img url And it url only allow the http
	 * 
	 * @param authorImgUrl
	 * @return
	 * @throws IllegalArgumentException
	 * @throws InvalidInputException
	 */

	public boolean validateAuthorImgUrl(String authorImgUrl) throws IllegalArgumentException, InvalidInputException {
		if (authorImgUrl == null) {
			throw new InvalidInputException(BookValidateErrors.INVALID_AUTHOR_IMG_URL_NULL);
		}

		// Code for Regex pattern
		String regex = "^(https?:\\/\\/)?\\S+\\.(png|jpe?g|gif)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(authorImgUrl);
		boolean isMatch = matcher.matches();

		if (!isMatch || authorImgUrl.trim().isEmpty()) {
			throw new InvalidInputException(BookValidateErrors.INVALID_AUTHOR_IMG_URL);
		} else {
			return true;
		}
	}

	public boolean validateAboutAuthor(String aboutAuthor) throws IllegalArgumentException, InvalidInputException {
		if (aboutAuthor == null) {
			throw new InvalidInputException(BookValidateErrors.INVALID_BOOK_ABOUT_AUTHOR_NULL);
		}

		// Code for Regex pattern
//		String regex = "^[A-Za-z0-9\\s.,;:'\"!?()/-]*$";
//		Pattern pattern = Pattern.compile(regex);
//		Matcher matcher = pattern.matcher(aboutAuthor);
//		boolean isMatch = matcher.matches(); // this is the new way to check the value 	

		if (aboutAuthor.trim().length() < BookValidatorConstants.MIN_ABOUT_AUTHOR
				|| aboutAuthor.trim().length() > BookValidatorConstants.MAX_ABOUT_AUTHOR) {
			throw new InvalidInputException(BookValidateErrors.INVALID_BOOK_ABOUT_AUTHOR);
		} else {
			return true;
		}
	}

	public boolean validatePublisherImprintName(String publisherName)
			throws IllegalArgumentException, InvalidInputException {
		if (publisherName == null) {
			throw new InvalidInputException(BookValidateErrors.INVALID_PUBLSHER_IMPRINT_NULL);
		}
		if (publisherName.trim().length() < BookValidatorConstants.MIN_IMPRINT_LENGTH
				|| publisherName.trim().length() > BookValidatorConstants.MAX_IMPRINT_LENGTH) {
			throw new InvalidInputException(BookValidateErrors.INVALID_PUBLSHER_IMPRINT);
		} else {
			return true;
		}

	}

	/**
	 * Below the code for validate the book isbn number
	 * 
	 * @param bookIsbn
	 * @return
	 * @throws IllegalArgumentException
	 * @throws InvalidInputException
	 */

	public boolean validateBookIsbn(String bookIsbn) throws IllegalArgumentException, InvalidInputException {
		if (bookIsbn == null) {
			throw new InvalidInputException(BookValidateErrors.INVALID_BOOK_ISBN_NULL);
		}

		String regex = "^(?=(?:[^0-9]*[0-9]){10}(?:(?:[^0-9]*[0-9]){3})?$)[\\d-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(bookIsbn);
		boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new InvalidInputException(BookValidateErrors.INVALID_BOOK_ISBN);
		} else {
			return true;
		}
	}

	public boolean validateBookLanguages(String bookLang) throws IllegalArgumentException {
		if (bookLang == null) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME_NULL);
		}

		// Code for Regex pattern
		String regex = BookValidatorConstants.REGEX_NAMES;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(bookLang);
		boolean isMatch = matcher.matches(); // this is the new way to check the value

		if (!isMatch || bookLang.trim().toLowerCase().length() < BookValidatorConstants.FOUR
				|| bookLang.trim().toLowerCase().length() > BookValidatorConstants.TEN) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME);
		}
		return true;
	}

	/**
	 * Below the code for validate the publisher date
	 * 
	 * @param publisherDate
	 * @return
	 * @throws IllegalArgumentException
	 * @throws InvalidInputException
	 */

	public boolean validatePublisherDate(LocalDate publisherDate)
			throws IllegalArgumentException, InvalidInputException {

		if (publisherDate == null) {
			throw new InvalidInputException(BookValidateErrors.INVALID_PUBLISHER_DATE_NULL);
		}

		LocalDate currentDate = LocalDate.now();
		int month = publisherDate.getMonthValue();
		int day = publisherDate.getDayOfMonth();

		if (publisherDate.isAfter(currentDate) || publisherDate.isBefore(currentDate.minusYears(30)) || month < 1
				|| month > 12 || day < 1 || day > 31) {
			throw new InvalidInputException(BookValidateErrors.INVALID_PUBLISHER_DATE);
		} else {
			return true;
		}
	}

	/**
	 * Below the code for validate the book image URL
	 *
	 * @param bookImageUrl
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean validateBookImageUrl(String bookImageUrl) throws IllegalArgumentException {

		if (bookImageUrl == null || bookImageUrl.trim().equals("")) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_IMAGE_URL);
		}

		// Code for Regex pattern
		String regex = "^(https?:\\/\\/)?\\S+\\.(png|jpe?g|gif)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(bookImageUrl);
		boolean isMatch = matcher.matches();

		if (!isMatch) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_IMAGE_URL);
		} else {
			return true;
		}

	}

	/**
	 * Below the code for validate the book Qty.
	 *
	 * @param bookQuantity
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean validateBookQuantity(int bookQuantity) throws IllegalArgumentException {
		if (bookQuantity <= BookValidatorConstants.ZERO || bookQuantity > BookValidatorConstants.TEN) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_QUANTITY);
		}
		return true;
	}

	/**
	 * Below the code for validate the book author name.
	 *
	 * @param authorName
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean validateAuthorName(String authorName) throws IllegalArgumentException {

		if (authorName == null) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_AUTHOR_NAME_NULL);
		}

		// Code for Regex pattern
		String regex = BookValidatorConstants.REGEX_NAMES;
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(authorName);
		boolean isMatch = matcher.matches(); // this is the new way to check the value

		if ("".trim().equals(authorName) || authorName.trim().length() > BookValidatorConstants.TWENTY
				|| authorName.trim().length() < BookValidatorConstants.THREE || !isMatch) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_AUTHOR_NAME);
		} else {
			return true;
		}

	}

	/**
	 * Below the code validate the book description
	 *
	 * @param bookDescription
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validateBookDescription(String bookDescription) throws IllegalArgumentException {
		if (bookDescription == null) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_DESCRIPTION_NULL);

		}

		// Code for Regex pattern
		String regex = "^[A-Za-z0-9\\s\\S]*$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(bookDescription);
		boolean isMatch = matcher.matches(); // this is the new way to check the value

		if ("".trim().equals(bookDescription)
				|| bookDescription.trim().length() > BookValidatorConstants.SIX_HUNDRED_FORTY
				|| bookDescription.trim().length() < 50 || !isMatch) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_DESCRIPTION);
		} else {
			return true;
		}
	}
}
