package com.fssa.bookstore.testservice;

/**
 * Below the code for test all the book Service layer 

 * @author MeganathanSubramania 
 * 
  */
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bookstore.dao.BookDao;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.Book;
import com.fssa.bookstore.service.BookService;





// Main class for test
class TestBookService {

	Book getBook() {
		Book book = new Book();
		book.setBookName("Attitude is Everything");
		book.setBookPrice(400);
		book.setbookCategories("Self help books");
		book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
		book.setBooklanguage("English");
		book.setQuantity(1);
		book.setAuthor("Someone");
		book.setBookDescription(
				"Combining ancient wisdom with the practicalities of today?,Think Like a Monk provides essential guidance for traveling a balanced path to success. Jay Shetty has written a book especially for you. He takes abstract concepts like compassion and humility and makes them applicable to your life.");
		return book;

	}

	/**
	 * Below the code for test the all the attribute to set the value
	 */
	@Test
	void testCreateBook() throws SQLException, DAOException {

		BookService bookservicelayer = new BookService();
		Book book = new Book();
		// Set the attributes of the book object for testing
		book.setBookName("The Elon musk book");
		book.setBookPrice(400);
		book.setbookCategories("fiction books");
		book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
		book.setBooklanguage("Tamil");
		book.setQuantity(1);
		book.setAuthor("Brain Tracy");
		book.setBookDescription(
				"Combining ancient wisdom with the practicalities of today?,Think Like a Monk provides essential guidance for traveling a balanced path to success. Jay Shetty has written a book especially for you. He takes abstract concepts like compassion and humility and makes them applicable to your life.");

		boolean success = bookservicelayer.addBook(book);
		Assertions.assertTrue(success); // Assert that the book creation is successful

		Logger.info("Query inserted Successfully");
	}

	// Below the code for read the book using Book ID

	@Test
	void testReadBookUsingId() throws DAOException, SQLException {

		Book book = getBook();
		BookDao bookDao = new BookDao();
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookDao.readBook(book.getBookId()));
		Logger.info(bookService.readBook(book));
		Logger.info("Succesfully read the data from the MYSQL");

	}

	// Below the code for delete the book using book ID
	@Test
	void testDeleteBookusingbookId() {

		Book book = new Book(); 
		book.setBookId(2);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.deleteBookUsingId(book.getBookId()));

	}

	// below the code for update the book price using book id
	@Test
	void testUpdateBookPrice() throws DAOException, SQLException {

		Book book = new Book();
		book.setBookId(5);
		book.setBookPrice(500);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.updateBookPrice(book.getBookId(), book.getBookPrice()));

	}

	// Below the code for test update the book quantity
	@Test
	void testUpdateBookQty() {
		Book book = new Book();
		book.setBookId(5);
		book.setQuantity(1);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.updateBookQty(book.getBookId(), book.getQuantity()));
	}
}
