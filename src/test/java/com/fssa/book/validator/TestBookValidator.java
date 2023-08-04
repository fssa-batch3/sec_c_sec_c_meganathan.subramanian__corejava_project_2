package com.fssa.book.validator;

import java.sql.SQLException;

/**
 *  Writing the test case for validate the book object 
 *  
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.book.Dao.BookDAO;
import com.fssa.book.exception.DAOException;
import com.fssa.book.model.Book;
import com.fssa.book.model.BookValidateErrors;
import com.fssa.book.service.BookServiceLayer;

class TestBookValidator {

	@Test
	// Code for Valid Test the bookId
	void testValidBookId() {
		Assertions.assertTrue(BookValidator.validateBookId(12));

	}

	// code for Invalid TestCase the bookId
	@Test
	void testInvalidBookId() {
		try {
			BookValidator.validateBookId(0);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVAILD_BOOKID, ex.getMessage());
		}
	}

	@Test
	// code for Valid book name
	void testValidBookNameValidator() {
		Assertions.assertTrue(BookValidator.validateBookName("Attitude is everything by jeff keller"));
	}

	// Code for Invalid book name
	@Test
	void testInvalidBookNameValidator() {
		try {
			BookValidator.validateBookName("Attitude book is by something new@@@@@@@@@@@@@@@@@@@@@");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVAILD_BOOK_NAME, ex.getMessage());

		}

	}
 
	@Test
	// Code for the Null invalid bookName
	void testNullInvalidTestCase() {
		try {
			BookValidator.validateBookName(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVAILD_BOOK_NAME_NULL, ex.getMessage());
		}
	}

	@Test
	// Code for Invalid Test case bookName empty string
	void testInvalidEmptyStringValidator() {
		try {
			BookValidator.validateBookName("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVAILD_BOOK_NAME, ex.getMessage());
		}
	}

	// Code for invalid testCaser bookName
	@Test
	void testInvalidSpecialCharacterbookNameValidtor() {
		try {
			BookValidator.validateBookName("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(BookValidateErrors.INVAILD_BOOK_NAME, ex.getMessage());
		}
	}

	@Test
	// Code for Test valid BookPrice
	void testValidBookPrice() {
		Assertions.assertTrue(BookValidator.validateBookPrice(300));
	}

	// Code for Invalid testCase bookPrice
	@Test
	void testInvalidBookPrice() {
		try {
			BookValidator.validateBookPrice(0);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVAILD_BOOK_PRICE, ex.getMessage());
		}
	}

	@Test
	// Code for valid book categories name
	void testValidBookCategoriesName() {
		Assertions.assertTrue(BookValidator.validateBookCategoriesName("fiction books"));
	}

	@Test
	// Code for InValid Book categories name
	void testvalid() {
		try {
			BookValidator.validateBookCategoriesName("@@@@@@@@@@@@@");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_CATEGOIRES_NAME, ex.getMessage());
		}

	}

	@Test
	// Code for Invalid test the BookCategoires name
	void testInvalidBookCategories() {
		try {
			BookValidator.validateBookCategoriesName(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVAID_BOOK_CATEGORIES_NULL, ex.getMessage());
		}

	}

	@Test
	// Code for test Valid the enum validator
	void testInvalidBookCategoriesName() {
		Assertions.assertTrue(BookValidator.validateCategoryName("Law books"));
	}

	@Test
	// Code for test the book Valid Image URL
	void testValidBookImageUrl() {
		Assertions
				.assertTrue(BookValidator.validateBookImageUrl("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg"));
	}

	@Test
	// code for Empty String invalid test case for book image URL
	void testInvaildEmptyStringBookImageUrl() {
		try {
			BookValidator.validateBookImageUrl("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_IMAGE_URL, ex.getMessage());

		}

	}

	@Test
	// Code for Invalid Book image URL
	void testInvalidBookImageUrl() {
		try {
			BookValidator.validateBookImageUrl("htps://media-amazon.com/images/I/611OWa8x+W.kk");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_IMAGE_URL, ex.getMessage());
		}
	}

	@Test
	// Code for the check the null book image URL
	void testNullBookImageUrl() {
		try {
			BookValidator.validateBookImageUrl(null);

		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_IMAGE_URL, ex.getMessage());
		}
	}

	@Test
	// Code for Test the invalid book image URL
	void testInvalidIntBookImageUrl() {
		try {
			BookValidator.validateBookCategoriesName("12323i2392038290323");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_CATEGOIRES_NAME, ex.getMessage());
		}
	}

	@Test
	// code for the valid book language name
	void testVaidBooklanguagesName() {
		Assertions.assertTrue(BookValidator.validateBookLanguages("Tamil Edition Books"));
	}

	@Test
	// code for invalid Test Case for book language name
	void testInvalidBookLangugageName() {
		try {
			BookValidator.validateBookLanguages("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME, ex.getMessage());
		}
	}

	@Test
	// code for check the book language name null
	void testBookLanguageNameNull() {
		try {
			BookValidator.validateBookLanguages(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME_NULL, ex.getMessage());
		}
	}

	@Test
	// code for invalid test case book language name
	void testSpecialCharBookLanguageName() {
		try {
			BookValidator.validateBookLanguages("@@@@@@@@@@@@@12");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME, ex.getMessage());
		}
	}

	@Test
	// Code for Test the Valid Book Quantity
	void testValidBookQuantity() {
		Assertions.assertTrue(BookValidator.validateBookQuantity(12));
	}

	@Test
	// Code for Test the Invalid bookQuantity
	void testInvalidBookQuantity() {
		try {
			BookValidator.validateBookQuantity(0);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_QUANTITY, ex.getMessage());
		}
	}

	@Test
	// code for test the valid Book author name
	void testValidBookAuthorName() {
		Assertions.assertTrue(BookValidator.validateAuthorName("Jeff keller"));
	}

	@Test
	// Code for Invalid test case for author name
	void testInvaildAuthorNameNull() {
		try {
			BookValidator.validateAuthorName(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_AUTHOR_NAME_NULL, ex.getMessage());
		}
	}

	@Test
	// Code for Invalid test case for author name
	void testSpecialCharInvalidAuthorName() {
		try {
			BookValidator.validateAuthorName("@@@@@@@@@@@@@@@");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVAID_BOOK_AUTHOR_NAME, ex.getMessage());
		}
	}

	@Test
	// code for test the invalid author name empty String

	void testInvalidEmptyAuthorName() {
		try {
			BookValidator.validateAuthorName("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVAID_BOOK_AUTHOR_NAME, ex.getMessage());
		}
	}

	@Test
	// Code for test the invalid author name
	void testInvalidIntAuthorName() {
		try {
			BookValidator.validateAuthorName("123354253726");
		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(BookValidateErrors.INVAID_BOOK_AUTHOR_NAME, ex.getMessage());
		}
	}

	@Test
	// Code for test the valid Book Description
	void testValidBookDescription() {
		Assertions.assertTrue(BookValidator.validateBookDescription(
				"The key takeaway from the book is to remember that being motivated is easier than making excuses. To be truly motivated, you need to think positively and break free of negative attitude and mental window."));
	}

	@Test
	// Code for invalid test case for book description
	void testBookDescriptionNull() {
		try {
			BookValidator.validateBookDescription(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_DESCRIPTION_NULL, ex.getMessage());
		}
	}
}
