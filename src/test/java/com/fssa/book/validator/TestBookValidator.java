package com.fssa.book.validator;

/**
 *  Writing the test case for validate the book object 
 *  
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.book.model.Book;
import com.fssa.book.model.BookValidateErrors;

class TestBookValidator { 

	@Test
	// Below the code test the object are null
	void testBookObjNull() {
		BookValidator bookvalidator = new BookValidator(); // Create a new object
		try {
			bookvalidator.validate(null);

		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NULL, ex.getMessage());
		}
	}

	@Test
	// Code for valid test for book object
	void validTestBookObject() {
		Book Validbook = new Book();
		BookValidator bookvalidator = new BookValidator(); // Create a new object for it
		Validbook.setBookId(1);
		Validbook.setAuthor("Jeff keller");
		Validbook.setBookDescription(
				"The key takeaway from the book is to remember that being motivated is easier than making excuses. To be truly motivated, you need to think positively and break free of negative attitude and mental window.");
		Validbook.setBookName("Attitude is everything");
		Validbook.setBookCategories("fiction books");
		Validbook.setBooklanguage("English");
		Validbook.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
		Validbook.setBookPrice(400);
		Validbook.setQuantity(2);
		Assertions.assertTrue(bookvalidator.validate(Validbook));
	}

	@Test
	// Below the code for test object book id
	void testInvalidTestBookIdObj() {
		try {
			Book book = new Book();
			book.setBookId(-1);
			book.setAuthor("Jeff keller");
			book.setBookDescription(
					"The key takeaway from the book is to remember that being motivated is easier than making excuses. To be truly motivated, you need to think positively and break free of negative attitude and mental window.");
			book.setBookName("Attitude is everything");
			book.setBookCategories("fiction books");
			book.setBooklanguage("English");
			book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
			book.setBookPrice(400);
			book.setQuantity(2);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOKID, ex.getMessage());
		}
	}

	// Below the code for test the object author name
	@Test
	void testInvalidBookAuthorObj() {
		try {
			Book book = new Book();
			book.setBookId(2);
			book.setAuthor(null);
			book.setBookDescription(
					"The key takeaway from the book is to remember that being motivated is easier than making excuses. To be truly motivated, you need to think positively and break free of negative attitude and mental window.");
			book.setBookName("Attitude is everything");
			book.setBookCategories("fiction books");
			book.setBooklanguage("English");
			book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
			book.setBookPrice(400);

		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_AUTHOR_NAME_NULL, ex.getMessage());
		}
	}

	@Test
	// Below the code for invalid book description
	void testInvalidBookDescObj() {
		try {
			Book book = new Book();
			book.setBookId(2);
			book.setAuthor("Jeff keller");
			book.setBookDescription(null);
			book.setBookName("Attitude is everything");
			book.setBookCategories("fiction books");
			book.setBooklanguage("English");
			book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
			book.setBookPrice(400);

		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_DESCRIPTION_NULL, ex.getMessage());
		}
	}

	// Below the code for test the book name
	@Test
	void testInvalidBookNameObj() {
		try {
			Book book = new Book();
			book.setBookId(1);
			book.setAuthor("Jeff keller");
			book.setBookDescription(
					"The key takeaway from the book is to remember that being motivated is easier than making excuses. To be truly motivated, you need to think positively and break free of negative attitude and mental window.");
			book.setBookName(null);
			book.setBookCategories("fiction books");
			book.setBooklanguage("English");
			book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
			book.setBookPrice(400);

		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NAME_NULL, ex.getMessage());
		}
	}

	// Below the code for test the book categories name
	@Test
	void testInvalidBookcatNameObj() {
		try {
			Book book = new Book();
			book.setBookId(2);
			book.setAuthor("Jeff keller");
			book.setBookDescription(
					"The key takeaway from the book is to remember that being motivated is easier than making excuses. To be truly motivated, you need to think positively and break free of negative attitude and mental window.");
			book.setBookName("Eat that Frog");
			book.setBookCategories(null);
			book.setBooklanguage("English");
			book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
			book.setBookPrice(400);

		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NAME_NULL, ex.getMessage());
		}
	}

	// Below the code for test the bookcat name obj
	@Test
	void testInvalidBookCatNameObj() {
		try {
			Book book = new Book();
			book.setBookId(2);
			book.setAuthor("Jeff keller");
			book.setBookDescription(
					"The key takeaway from the book is to remember that being motivated is easier than making excuses. To be truly motivated, you need to think positively and break free of negative attitude and mental window.");
			book.setBookName("Eat that Frog");
			book.setBookCategories("fiction books");
			book.setBooklanguage(null);
			book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
			book.setBookPrice(400);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME_NULL, ex.getMessage());

		}
	}

	// Below the code for test the bookimg url
	@Test
	void testInvalidBookImgUrlObj() {
		try {
			Book book = new Book();
			book.setBookId(2);
			book.setAuthor("Jeff keller");
			book.setBookDescription(
					"The key takeaway from the book is to remember that being motivated is easier than making excuses. To be truly motivated, you need to think positively and break free of negative attitude and mental window.");
			book.setBookName("Eat that Frog");
			book.setBookCategories("fiction books");
			book.setBooklanguage("Tamil");
			book.setBookImage(null);
			book.setBookPrice(400);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_IMAGE_URL, ex.getMessage());
		}
	}

	// Below the code for test the book price
	@Test
	void testInvalidBookPriceObj() {
		try {
			Book book = new Book();
			book.setBookId(2);
			book.setAuthor("Jeff keller");
			book.setBookDescription(
					"The key takeaway from the book is to remember that being motivated is easier than making excuses. To be truly motivated, you need to think positively and break free of negative attitude and mental window.");
			book.setBookName("Eat that Frog");
			book.setBookCategories("fiction books");
			book.setBooklanguage("Tamil");
			book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
			book.setBookPrice(0);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_PRICE, ex.getMessage());

		}
	}

	@Test
	// code for Valid book name
	void testValidBookName() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookName("Attitude is everything by jeff keller"));
	}

	// Code for Invalid book name
	@Test
	void testInvalidBookName() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookName("Attitude book is by something new@@@@@@@@@@@@@@@@@@@@@");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NAME, ex.getMessage());

		}

	}

	// Below the code for test the invaild book name
	@Test
	void testinvalidBookNameValidator() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookName("Harry Potter 123");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NAME, ex.getMessage());

		}

		try {

			bookValidator.validateBookName("The Jungle Book @#$");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NAME, ex.getMessage());
		}

		try {
			bookValidator.validateBookName("To Kill a\nMockingbird");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NAME, ex.getMessage());
		}

		try {
			bookValidator.validateBookName("A");

		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NAME, ex.getMessage());
		}
		try {
			bookValidator.validateBookName("123-ABC");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NAME, ex.getMessage());

		}
	}

	@Test
	// Code for the Null invalid bookName
	void testNullInvalidTestCase() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookName(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NAME_NULL, ex.getMessage());
		}
	}

	@Test
	// Code for Invalid Test case bookName empty string
	void testInvalidEmptyStringValidator() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookName("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NAME, ex.getMessage());
		}
	}

	// Code for invalid testCaser bookName
	@Test
	void testInvalidSpecialCharacterbookNameValidtor() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookName("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NAME, ex.getMessage());
		}
	}

	@Test
	// Code for Test valid BookPrice
	void testValidBookPrice() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookPrice(400));
	}

	// Code for Invalid testCase bookPrice
	@Test
	void testInvalidBookPrice() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookPrice(0);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_PRICE, ex.getMessage());
		}
	}

	@Test
	// Code for Invalid test the BookCategoires name
	void testInvalidBookCatNull() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookCategoriesName(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_CATEGORIES_NULL, ex.getMessage());
		}

	}

	@Test
	// Code for valid book categories name
	void testValidBookCatName() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookCategoriesName("fiction books"));
	}

	@Test
	// Code for Invalid Book categories name
	void testvalidBookCatName() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookCategoriesName("story books");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_CATEGOIRES_NAME, ex.getMessage());
		}

	}

	@Test
	// Code for test Valid the enum validator
	void testInvalidBookCatName() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateCategoryNameEnums("Law books"));
	}

	@Test
	// Code for test the invalid enum validator
	void testInvaidBookcatgEnums() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateCategoryNameEnums(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_CATEGORIES_NULL, ex.getMessage());

		}
	}

	@Test
	// Code for test the book Valid Image URL
	void testValidBookImgUrl() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookImageUrl("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg"));
	}

	@Test
	// code for Empty String invalid test case for book image URL
	void testInvaildEmptyStringBookImgUrl() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookImageUrl("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_IMAGE_URL, ex.getMessage());

		}

	}

	@Test
	// Code for Invalid Book image URL
	void testInvalidBookImgUrl() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookImageUrl("htps://media-amazon.com/images/I/611OWa8x+W.kk");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_IMAGE_URL, ex.getMessage());
		}
	}

	@Test
	// Code for the check the null book image URL
	void testBookImgUrlNull() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookImageUrl(null);

		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_IMAGE_URL, ex.getMessage());
		}
	}

	@Test
	// Code for Test the invalid book image URL
	void testInvalidIntBookImgUrl() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookCategoriesName("12323i2392038290323");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_CATEGOIRES_NAME, ex.getMessage());
		}
	}

	@Test
	// code for the valid book language name
	void testValidBooklangName() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookLanguages("Tamil Edition Books"));
	}

	@Test
	// code for invalid Test Case for book language name
	void testInvalidBookLangName() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookLanguages("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME, ex.getMessage());
		}
	}

	@Test
	// code for check the book language name null
	void testBookLangNameNull() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookLanguages(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME_NULL, ex.getMessage());
		}
	}

	@Test
	// code for invalid test case book language name
	void testSplCharBookLangName() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookLanguages("@@@@@@@@@@@@@12");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME, ex.getMessage());
		}
	}

	@Test
	// Code for Test the Valid Book Quantity
	void testValidBookQty() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookQuantity(12));
	}

	@Test
	// Code for Test the Invalid bookQuantity
	void testInvalidBookQuantity() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookQuantity(-1);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_QUANTITY, ex.getMessage());
		}
	}

	@Test
	// code for invalid testcase for book quantity
	void testInvalidBookQty() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookQuantity(21);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_QUANTITY, ex.getMessage());
		}
	}

	@Test
	// code for test the valid Book author name
	void testValidBookAuthorName() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateAuthorName("Jeff keller"));
	}

	@Test
	// Code for Invalid test case for author name
	void testInvaildAuthorNameNull() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateAuthorName(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_AUTHOR_NAME_NULL, ex.getMessage());
		}
	}

	@Test
	// Code for Invalid test case for author name
	void testSplCharInvalidAuthorName() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateAuthorName("@@@@@@@@@@@@@@@");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVAID_BOOK_AUTHOR_NAME, ex.getMessage());
		}
	}

	@Test
	// code for test the invalid author name empty String

	void testInvalidEmptyAuthorName() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateAuthorName("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVAID_BOOK_AUTHOR_NAME, ex.getMessage());
		}
	}

	@Test
	// Code for test the invalid author name
	void testInvalidIntAuthorName() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateAuthorName("123354253726");
		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(BookValidateErrors.INVAID_BOOK_AUTHOR_NAME, ex.getMessage());
		}
	}

	@Test
	// Code for test the valid Book Description
	void testValidBookDesc() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookDescription(
				"The key takeaway from the book is to remember that being motivated is easier than making excuses. To be truly motivated, you need to think positively and break free of negative attitude and mental window."));
	}

	@Test
	// Code for invalid test case for book description
	void testBookDescEmpty() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookDescription("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_DESCRIPTION, ex.getMessage());

		}
	}

	@Test
	// Code for invalid test case for book description
	void testBookDescNull() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookDescription(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_DESCRIPTION_NULL, ex.getMessage());
		}
	}
}
