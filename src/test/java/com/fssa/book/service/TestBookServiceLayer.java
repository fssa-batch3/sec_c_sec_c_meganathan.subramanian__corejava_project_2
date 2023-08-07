package com.fssa.book.service;

/**
 * Below the code for test all the Service layer 
 * @author MeganathanSubramania 
 * 
 */
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

/**
 *  // Below the code for testing the all book service layer 
 * @author MeganathanSubramania
 */

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.book.Dao.BookDAO;
import com.fssa.book.exception.DAOException;
import com.fssa.book.model.Book;

// Main class for test
public class TestBookServiceLayer {

	Book getBook() {
		Book book = new Book();
		book.setBookId(1);
		book.setBookName("Attitude is eveything");
		book.setBookPrice(300);
		book.setBookCategories("Self help books");
		book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
		book.setBooklanguage("English");
		book.setQuantity(1);
		book.setAuthor("Someone");
		book.setBookDescription("Combining ancient wisdom with the practicalities of today?,Think Like a Monk provides essential guidance for traveling a balanced path to success. Jay Shetty has written a book especially for you. He takes abstract concepts like compassion and humility and makes them applicable to your life.");
		return book;

	}

	// Below the code for test the all the attribute to set the value

	@Test
	void testCreateBook() throws IllegalArgumentException, SQLException, DAOException {

		BookServiceLayer bookservicelayer = new BookServiceLayer();
		Book book = new Book();
		// Set the attributes of the book object for testing
		book.setBookId(1);
		book.setBookName("Attitude is eveything");
		book.setBookPrice(500);
		book.setBookCategories("Self help books");
		book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
		book.setBooklanguage("English");
		book.setQuantity(1);
		book.setAuthor("Someone");
		book.setBookDescription("Combining ancient wisdom with the practicalities of today?,Think Like a Monk provides essential guidance for traveling a balanced path to success. Jay Shetty has written a book especially for you. He takes abstract concepts like compassion and humility and makes them applicable to your life.");

		boolean success = bookservicelayer.addBook(book);
		Assertions.assertTrue(success); // Assert that the book creation is successful
		System.out.println("Query inserted Successfully");
	}

	// Below the code for read the book using Book ID

	@Test
	void testReadBookUsingId() throws DAOException, SQLException {

		Book book = getBook();
		BookServiceLayer bookServiceLayer = new BookServiceLayer();
		assertDoesNotThrow(() -> BookDAO.readBook(book.getBookId()));
		System.out.println(bookServiceLayer.readBook(book));
		System.out.println("Succesfully read the data from the MYSQL");

	}

	
	// Below the code for delete the book ID
//	 void testDeleteBookusingbookId() {
//		 
//		 Book book = new Book();
//		 book.setBookId(1);
//		 
//	 }

	// below the code for update the book price using book id 
	@Test
	void testUpdateBookPrice() throws DAOException, SQLException {

		Book book = getBook();
		int bookId = book.getBookId();
		int bookPrice1 =  book.getBookPrice();
		BookServiceLayer bookServiceLayer = new BookServiceLayer();
		assertDoesNotThrow(() -> bookServiceLayer.updateBookPrice(bookId,bookPrice1));
		
	}

}
