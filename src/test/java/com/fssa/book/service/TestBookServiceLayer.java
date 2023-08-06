package com.fssa.book.service;

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

public class TestBookServiceLayer {

	Book getBook() {
		Book book = new Book();
		book.setBookId(1);
		book.setBookName("Attitude is eveything");
		book.setBookPrice(500.00);
		book.setBookCategories("Self help books");
		book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
		book.setBooklanguage("English");
		book.setQuantity(1);
		book.setAuthor("Someone");
		book.setBookDescription(
				"Combining ancient wisdom with the practicalities of today?,Think Like a Monk provides essential guidance for traveling a balanced path to success. Jay Shetty has written a book especially for you. He takes abstract concepts like compassion and humility and makes them applicable to your life.");
		return book;

	}

	// Below the code for test the all the attribute to set the value
	
	@Test
	void testCreateBook() throws IllegalArgumentException, SQLException, DAOException {

		BookServiceLayer bookservicelayer = new BookServiceLayer();

		Book book = new Book();
		// Set the attributes of the book object for testing
		book.setBookId(2);
		book.setBookName("Attitude is eveything");
		book.setBookPrice(500.00);
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
	void testReadBookUsingId() throws IllegalArgumentException, DAOException, SQLException {

		Book book = getBook();
		BookServiceLayer bookServiceLayer = new BookServiceLayer();
		assertDoesNotThrow(() -> BookDAO.readBook(book.getBookId()));
		System.out.println(bookServiceLayer.readBook(book));
		System.out.println("Succesfully read the data from the MYSQL");

	}
	

	
	// Below the code for delete the book ID
	
	@Test 
	void testDeleteBookUsingId() throws IllegalArgumentException, DAOException, SQLException {

		Book book = new Book();
		book.setBookId(5);
		//BookServiceLayer bookServiceLayer = new BookServiceLayer();
		assertDoesNotThrow(() -> BookDAO.deleteBook(book.getBookId()));
		//System.out.println(bookServiceLayer.deleteBook(book));
		System.out.println("Succesfully delete the data from the MYSQL");
	}
	
	
	// below the code for update the book price using book id
	@Test 
	void testUpdateBookPrice(int bookid, int bookPrice)  throws IllegalArgumentException, DAOException, SQLException{
		
		Book book = new Book();
		
	}
	
	
}
