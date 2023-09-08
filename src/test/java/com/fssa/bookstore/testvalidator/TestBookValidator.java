package com.fssa.bookstore.testvalidator;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.time.LocalDate;

/**
 *  Writing the test case for validate the book object 
 *  
 */
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bookstore.enums.BookBinding;
import com.fssa.bookstore.enums.BookReturnable;
import com.fssa.bookstore.enums.Categories;
import com.fssa.bookstore.exception.InvalidInputException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.Book;
import com.fssa.bookstore.validator.BookValidator;
import com.fssa.bookstore.validatorerrors.BookValidateErrors;
 
class TestBookValidator { 
 
	 
	@Test 
	// Below the code for check the book id in db
	void testBookIdValidDb() {
		BookValidator bookValidator = new BookValidator();// create a obj
		Assertions.assertTrue(bookValidator.CheckBookIdExist(1)); 
	}
	
	@Test
	// Below the code for check the book id is exists or not
	void testInvalidBookIdDb() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.CheckBookIdExist(100);
		}
		catch(IllegalArgumentException e) {
			Assertions.assertEquals("Given book id does not exists in the database",e.getMessage());
		}
	}
	
	 
	@Test
	// Below the code for check the id are valid are not
	void testValidBookId() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookId(1));
	}
	
	
	@Test
	// Below the code for test the invalid book id
	void testInvalidBookId() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookId(-12);
		}
		catch(IllegalArgumentException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOKID, e.getMessage() );
		}

	}
	@Test
	// Below the code test the object are null
	void testBookObjNull() {
		BookValidator bookvalidator = new BookValidator(); // Create a new object
		try {
			bookvalidator.validate(null);

		} catch (IllegalArgumentException | InvalidInputException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_NULL, ex.getMessage());
		}
	}

	@Test
	// Code for valid test for book object
	void validTestBookObject() throws IllegalArgumentException, InvalidInputException {
		Book Validbook = new Book();
		BookValidator bookvalidator = new BookValidator(); // Create a new object for it
		Validbook.setBookId(1);
		Validbook.setAuthor("Jeff keller");
		Validbook.setBookDescription(
				"The key takeaway from the book is to remember that being motivated is easier than making excuses. To be truly motivated, you need to think positively and break free of negative attitude and mental window.");
		Validbook.setBookName("Attitude is everything");
		Validbook.setBookCategories(Categories.FICTION_BOOKS);
		Validbook.setBooklanguage("English");
		Validbook.setBookImageUrl("https://m.media-amazon.com/images/I/71Rcjb+1yLL.jpg");
		Validbook.setBookPrice(400);
		Validbook.setQuantity(2);
		Validbook.setAuthorImgUrl("https://iili.io/J9qBtse.jpg");
		Validbook.setIsbn("978-0979041037");
		Validbook.setBookWeight(800);
		Validbook.setBookwidth(7.0);
		Validbook.setBookHeight(6.0);
		Validbook.setBookDepth(2.0);
		Validbook.setBookBinding(BookBinding.PAPERBACK);
		Validbook.setAboutAuthor("Jeffrey Keller, President Of Attitude Is Everything, Incorporated, Works With Organizations That Want To Develop Acheivers Ans With Sales Mangeres Who Want Theru People To Be More Positive Jeff Is A Speaker,Seminar Leader And Writer In The Area Of Motivation And Human Potential.He Delivers His Uplifting Persentation To Businesses,Associations And Educational Instituation Jeff Is Also An Attorney And Praticed Law For More Than Ten Years Before Pursing A Full Time Carrer As A Speaker And Writer. In June 1999,Jeff's Book,Attitude Is.");
		Validbook.setReturnable(BookReturnable.YES);
		Validbook.setPublisherImprint("Savitha Printer");
		Validbook.setPublisherDate(LocalDate.of(2020, 9, 1));
		Validbook.setNoOfPages(600);
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
			book.setBookCategories(Categories.FICTION_BOOKS);
			book.setBooklanguage("English");
			book.setBookImageUrl("https://www.example.com");
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
			book.setBookCategories(Categories.FICTION_BOOKS);
			book.setBooklanguage("English");
			book.setBookImageUrl("https://www.example.com");
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
			book.setBookCategories(Categories.FICTION_BOOKS);
			book.setBooklanguage("English");
			book.setBookImageUrl("https://www.example.com");
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
			book.setBookCategories(Categories.FICTION_BOOKS);
			book.setBooklanguage("English");
			book.setBookImageUrl("https://www.example.com");
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
			book.setBookImageUrl("https://www.example.com");
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
			book.setBookCategories(Categories.FICTION_BOOKS);
			book.setBooklanguage(null);
			book.setBookImageUrl("https://www.example.com");
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
			book.setBookCategories(Categories.FICTION_BOOKS);
			book.setBooklanguage("Tamil");
			book.setBookImageUrl(null);
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
			book.setBookCategories(Categories.FICTION_BOOKS);
			book.setBooklanguage("Tamil");
			book.setBookImageUrl("https://www.example.com");
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

	// Below the code for test the Invaild book name
	@Test 
	void testInvalidBookNameValidator() {
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
	// Below the code for check the invalid price 
	void testInvalidPrice() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookPrice(2000);
		}
		catch(IllegalArgumentException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_PRICE, e.getMessage());
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
		Assertions.assertTrue(bookValidator.validateBookCategoriesName(Categories.FICTION_BOOKS));
	}


	@Test
	// Code for test Valid the enum validator
	void testvalidBookCatName() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookCategoriesName(Categories.LAW_BOOKS));
	}

	@Test
	// Code for test the invalid enum validator
	void testInvaidBookcatgEnums() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookCategoriesName(null);
		} 
		catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_CATEGORIES_NULL, ex.getMessage());
		} 
	}

	@Test 
	// Code for test the book Valid Image URL
	void testValidBookImgUrl() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookImageUrl("https://m.media-amazon.com/images/I/71Rcjb+1yLL.jpg"));
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
			bookValidator.validateBookImageUrl("media-amazon.com/images/I/611OWa8x+W.kk");
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
	// code for the valid book language name
	void testValidBooklangName() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookLanguages("Tamil"));
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
		Assertions.assertTrue(bookValidator.validateBookQuantity(4));
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
	void testInvaildAuthorName() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateAuthorName("12983298Jeffy"); 
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_AUTHOR_NAME, ex.getMessage());
		}
	}


	@Test
	// Code for Invalid test case for author name
	void testSplCharInvalidAuthorName() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateAuthorName("@@@@@@@@@@@@@@@");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_AUTHOR_NAME, ex.getMessage());
		}
	}

	@Test
	// code for test the invalid author name empty String

	void testInvalidEmptyAuthorName() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateAuthorName("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_AUTHOR_NAME, ex.getMessage());
		}
	}

	@Test
	// Code for test the invalid author name
	void testInvalidIntAuthorName() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateAuthorName("123354253726");
		} catch (IllegalArgumentException ex) {

			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_AUTHOR_NAME, ex.getMessage());
		}
	}

	@Test
	// Code for test the valid Book Description
	void testValidBookDesc() {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertTrue(bookValidator.validateBookDescription(
				"Jeffrey Keller, President Of Attitude Is Everything, Incorporated, Works With Organizations That Want To Develop Acheivers Ans With Sales Mangeres Who Want Theru People To Be More Positive Jeff Is A Speaker,Seminar Leader And Writer In The Area Of Motivation And Human Potential.He Delivers His Uplifting Persentation To Businesses,Associations And Educational Instituation Jeff Is Also An Attorney And Praticed Law For More Than Ten Years Before Pursing A Full Time Carrer As A Speaker And Writer. In June 1999,Jeff's Book,Attitude Is Everything ,Was Released By INTI Pulblishing & Resourcev Books. This Exciting New Book"));
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
	
	@Test
	// code for valid test case for author image
	void testValidAuthorImgUrl() {
		BookValidator bookValidator = new BookValidator();
		try {
			Assertions.assertTrue(bookValidator.validateAuthorImgUrl("https://iili.io/J9qBtse.jpg"));
		} catch (IllegalArgumentException | InvalidInputException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_AUTHOR_IMG_URL, e.getMessage());
		}
	}
	
	@Test
	// Below the code for test the invalid author image url
	void testInvalidAuthorImgUrlNull() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateAuthorImgUrl(null);
		}
		catch(IllegalArgumentException | InvalidInputException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_AUTHOR_IMG_URL_NULL,e.getMessage());
		}
	}
	
	void testInvalidAuthorImgUrl() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateAuthorImgUrl("https/9jsfhjdkfhkjdf.com");
		}
		catch(IllegalArgumentException | InvalidInputException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_AUTHOR_IMG_URL,e.getMessage());
		}
	}
	
	
	
	@Test
	// Below the code for test the valid no of pages
	void testValidBookPages() {
		BookValidator bookValidator = new BookValidator();
		try {
			Assertions.assertTrue(bookValidator.validateNoOfPages(180));
		}
		catch(IllegalArgumentException | InvalidInputException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_NO_OF_PAGES, e.getMessage());
		}
	}
	
	@Test
	// below the code for test the invalid pages
	void testInvalidBookPageNull() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateNoOfPages(3000);
		}
		catch(IllegalArgumentException | InvalidInputException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_NO_OF_PAGES, e.getMessage());
		}
	}
	
	
	@Test
	// Below the code for test the valid book height
	void testValidBookHeight() {
		BookValidator bookValidator = new BookValidator();
		try {
			Assertions.assertTrue(bookValidator.validateBookHeight(6.0));
		}
		catch(IllegalArgumentException | InvalidInputException e) {
			Assertions.assertEquals(BookValidateErrors.INVAILD_BOOK_HEIGHT, e.getMessage());
		}
	}
	

	@Test
	//Below the code for test the book depth /// 0.1 to 3.0
	void testValidBookDepth() throws IllegalArgumentException, InvalidInputException {
		BookValidator bookValidator = new BookValidator();
		Assertions.assertDoesNotThrow(() -> bookValidator.validateBookDepth(3.0));
		
	}
	
	@Test
	// Below the code for valid the book weight
	void testValidBookWeight() {
		BookValidator bookValidator  =  new  BookValidator(); 
		assertDoesNotThrow(()->bookValidator.validateBookWeight(900)); // 28 to 910 
	}
	
	@Test 
	// Below the code for test the invalid book weight
	void testInvalidBookWeight() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookWeight(20);
		}
		catch(IllegalArgumentException | InvalidInputException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_WEIGHT, e.getMessage());
		}
	}
	
	@Test
	// Below the code for validtest case book binding
	void testValidBookBinding() {
		BookValidator bookValidator = new BookValidator();
		assertDoesNotThrow(()-> bookValidator.validateBookBinding(BookBinding.PAPERBACK));
	}
	
	@Test
	// below the code test the valid book return
	void testValidBookReturn() {
		BookValidator bookValidator = new BookValidator();
		assertDoesNotThrow(()-> bookValidator.validatebookReturn(BookReturnable.YES));
	}
	
	@Test 
	// below the code for valid test case publish name
	void testValidPublisherImprintName() {
		BookValidator bookValidator = new BookValidator();
		assertDoesNotThrow(()-> bookValidator.validatePublisherImprintName("Savitha printers")); // 4 to 20 length
	}
	
	@Test
	// Below the code for validate the isbn number 
	void testValidBookIsbn() {
		BookValidator bookValidator = new BookValidator();
		assertDoesNotThrow(()-> bookValidator.validateBookIsbn("978-0979041037"));
	}
	
	@Test
	// Below the code for validate the about author
	void testAboutAuthor() {
		BookValidator bookValidator = new BookValidator();
		assertDoesNotThrow(()-> bookValidator.validateAboutAuthor("Jeffrey Keller, President Of Attitude Is Everything, Incorporated, Works With Organizations That Want To Develop Acheivers Ans With Sales Mangeres Who Want Theru People To Be More Positive Jeff Is A Speaker,Seminar Leader And Writer In The Area Of Motivation And Human Potential.He Delivers His Uplifting Persentation To Businesses,Associations And Educational Instituation Jeff Is Also An Attorney And Praticed Law For More Than Ten Years Before Pursing A Full Time Carrer As A Speaker And Writer. In June 1999,Jeff's Book,Attitude Is."));
	}
	
	@Test
	//Below the code for test the invalib about author
	void testAboutAuthorNull() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateAboutAuthor(null);
		}
		catch(IllegalArgumentException | InvalidInputException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_ABOUT_AUTHOR_NULL, e.getMessage());
		}
	}
	
	@Test
	// Below the code for the inavalid isbn number
	void testInvalidBookIsbn() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookIsbn("123523732");
		}
		catch(IllegalArgumentException | InvalidInputException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_ISBN,e.getMessage());
		}
	}
	
	
	@Test
	// Below the code for the inavalid isbn number
	void testInvalidBookIsbnNull() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validateBookIsbn(null);
		}
		catch(IllegalArgumentException | InvalidInputException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_BOOK_ISBN_NULL,e.getMessage());
		}
	}
	 
	@Test
	// Below the code for test the publisher date
	void testPublisherDate() {
		BookValidator bookValidator = new BookValidator();
		assertDoesNotThrow(()-> bookValidator.validatePublisherDate(LocalDate.of(2010, 9, 2))); // September 2, 202
	}
	
	
	@Test
	// Below the code for the inavalid isbn number
	void testInvalidPublisherDateNull() {
		BookValidator bookValidator = new BookValidator();
		try {
			bookValidator.validatePublisherDate(null);
		}
		catch(IllegalArgumentException | InvalidInputException e) {
			Assertions.assertEquals(BookValidateErrors.INVALID_PUBLISHER_DATE_NULL,e.getMessage());
		}
	}
}

