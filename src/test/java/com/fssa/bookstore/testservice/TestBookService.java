package com.fssa.bookstore.testservice;

/**
 * Below the code for test all the book Service layer 
 * @author MeganathanSubramania 
 * 
  */
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.bookstore.dao.BookDao;
import com.fssa.bookstore.enums.Categories;
import com.fssa.bookstore.exception.ServiceException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.Book;
import com.fssa.bookstore.service.BookService;

// Main class for test
class TestBookService {

	Book getBook() {
		Book book = new Book();
		book.setBookName("Attitude is Everything");
		book.setBookPrice(400);
		book.setbookCategories(Categories.SELFHELP_BOOKS);
		book.setBookImageUrl("https://www.example.com");
		book.setBooklanguage("English");
		book.setQuantity(1);
		book.setAuthor("Someone");
		book.setBookDescription(
				"Combining ancient wisdom with the practicalities of today?,Think Like a Monk provides essential guidance for traveling a balanced path to success. Jay Shetty has written a book especially for you. He takes abstract concepts like compassion and humility and makes them applicable to your life.");
		return book;

	}

	/**
	 * Below the code for test the all the attribute to set the value
	 * 
	 * @throws ServiceException
	 */
	@Test
	void testCreateBook() {

		BookService bookservicelayer = new BookService();
		Book book = new Book();
		// Set the attributes of the book object for testing

		try {
			book.setBookName("My life My rules.");
			book.setBookPrice(500);
			book.setbookCategories(Categories.SELFHELP_BOOKS);
			book.setBookImageUrl("https://www.example.com");
			book.setBooklanguage("Tamil");
			book.setQuantity(1);
			book.setAuthor("Brain Tracy");
			book.setBookDescription(
					"Combining ancient wisdom with the practicalities of today?,Think Like a Monk provides essential guidance for traveling a balanced path to success. Jay Shetty has written a book especially for you. He takes abstract concepts like compassion and humility and makes them applicable to your life.");
			boolean success;
			success = bookservicelayer.addBook(book);
			Assertions.assertTrue(success);
			Logger.info("Query inserted Successfully");
		} catch (ServiceException ex) {
			Assertions.assertEquals("Object are empty or Attribute error" + ex.getMessage(),ex.getMessage());
		}
		// Assert that the book creation is successful

		
	}

	// Below the code for read the book using Book ID
	@Test
	void testReadBookUsingId() {

		Book book = new Book();
		book.setBookId(3);
		BookDao bookDao = new BookDao();
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookDao.readBook(book.getBookId()));
		try {
			Logger.info(bookService.readBook(book));
		} catch (ServiceException e) {
			Logger.info("error while reading the book from db" + e.getMessage());
			e.printStackTrace();
		}
		Logger.info("Succesfully read the data from the MYSQL");

	}

	// Below the code for delete the book using book ID
	@Test
	void testDeleteBookusingbookId() {

		Book book = new Book();
		book.setBookId(3);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.deleteBookUsingId(book.getBookId()));

	}

	// below the code for update the book price using book id
	@Test
	void testUpdateBookPrice() {

		Book book = new Book();
		book.setBookId(2);
		book.setBookPrice(600);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.updateBookPrice(book.getBookId(), book.getBookPrice()));

	}

	// Below the code for test update the book quantity
	@Test
	void testUpdateBookQty() {
		Book book = new Book();
		book.setBookId(2);
		book.setQuantity(1);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.updateBookQty(book.getBookId(), book.getQuantity()));
	}
	
	
	// Below the code for test the read the book using title name
	@Test
	void testReadBookTitle() {
		Book book = new Book();
		book.setbookCategories(Categories.SELFHELP_BOOKS);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.getAllBooksByCateName(book.getbookCategories().toString()));
		
	}
}
