package com.fssa.book.service;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.book.exception.DAOException;
import com.fssa.book.model.Book;


public class TestBookServiceLayer {

	// Below the code for test the
	@Test
	void testCreateBook() throws IllegalArgumentException, SQLException, DAOException {
		BookServiceLayer bookservicelayer = new BookServiceLayer();

		Book book = new Book();
		// Set the attributes of the book object for testing

		book.setBookName("Attitude is everything by jeff keller");
		book.setBookPrice(100.00);
		book.setBookCategories("Self help books");
		book.setBookImage("https://m.media-amazon.com/images/I/611OWa8x+WL.jpg");
		book.setBooklanguage("Tamil");
		book.setQuantity(2);
		book.setAuthor("Jay Shetty");
		book.setBookDescription("What is the purpose of Think Like a Monk?\r\n"
				+ "Combining ancient wisdom with the practicalities of today, Think Like a Monk provides essential guidance for traveling a balanced path to success. Jay Shetty has written a book especially for you. He takes abstract concepts like compassion and humility and makes them applicable to your life.");
		boolean success = bookservicelayer.addBook(book);
		Assertions.assertTrue(success); // Assert that the book creation is successful


	}

}
