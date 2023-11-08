package com.fssa.bookstore.testservice;

/**
 * Below the code for test all the book Service layer 
 * @author MeganathanSubramania 
 * 
  */
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bookstore.enums.BookBinding;
import com.fssa.bookstore.enums.BookReturnable;
import com.fssa.bookstore.enums.Categories;
import com.fssa.bookstore.exception.ServiceException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.Book;
import com.fssa.bookstore.service.BookService;

// Main class for test
class TestBookService {

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
			book.setBookName("Catch book in joesph keller Stone.");
			book.setBookPrice(700.00);
			book.setBookCategories(Categories.FICTION_BOOKS);
			book.setBookImageUrl("https://m.media-amazon.com/images/I/51eW-wH1K-L.jpg");
			book.setBooklanguage("tamil");
			book.setQuantity(1);
			book.setAuthor("Cal new port");
			book.setBookDescription(
					"Jeffrey Keller, President Of Attitude Is Everything, Incorporated, Works With Organizations That Want To Develop Acheivers Ans With Sales Mangeres Who Want Theru People To Be More Positive Jeff Is A Speaker,Seminar Leader And Writer In The Area Of Motivation And Human Potential.He Delivers His Uplifting Persentation To Businesses,Associations And Educational Instituation Jeff Is Also An Attorney And Praticed Law For More Than Ten Years Before Pursing A Full Time Carrer As A Speaker And Writer. In June 1999,Jeff's Book,Attitude Is Everything ,Was Released By INTI Pulblishing & Resourcev Books. This Exciting New Book.");
			book.setAuthorImgUrl("https://iili.io/J9qBtse.jpg");
			book.setIsbn("978-0979041037");
			book.setBookWeight(800);
			book.setBookwidth(7.0);
			book.setBookHeight(6.0);
			book.setBookDepth(2.0);
			book.setBookBinding(BookBinding.PAPERBACK);
			book.setAboutAuthor(
					"Jeffrey Keller, President Of Attitude Is Everything, Incorporated, Works With Organizations That Want To Develop Acheivers Ans With Sales Mangeres Who Want Theru People To Be More Positive Jeff Is A Speaker,Seminar Leader And Writer In The Area Of Motivation And Human Potential.He Delivers His Uplifting Persentation To Businesses,Associations And Educational Instituation Jeff Is Also An Attorney And Praticed Law For More Than Ten Years Before Pursing A Full Time Carrer As A Speaker And Writer. In June 1999,Jeff's Book,Attitude Is.");
			book.setReturnable(BookReturnable.YES);
			book.setPublisherImprint("Savitha Printer");
			book.setPublisherDate(LocalDate.of(2023, 9, 1));
			book.setNoOfPages(400);
			boolean success;
			success = bookservicelayer.addBook(book);
			Assertions.assertTrue(success);
			Logger.info("Query inserted Successfully");
		} catch (ServiceException ex) {
			Assertions.assertEquals("Object are empty or Attribute error" + ex.getMessage(), ex.getMessage());
		}
		// Assert that the book creation is successful

	}

	// Below the code for read the book using Book ID
	@Test
	void testReadBookUsingId() throws ServiceException {

		Book book = new Book();
		book.setBookId(1);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.readBook(book.getBookId()));
		Logger.info("Succesfully read the data from the MYSQL");

	}

	// Below the code for delete the book using book ID
	@Test
	void testDeleteBookusingbookId() {

		Book book = new Book();
		book.setBookId(10);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.deleteBookUsingId(book.getBookId()));

	}

	// below the code for update the book price using book id
	@Test
	void testUpdateBookPrice() {

		Book book = new Book();
		book.setBookId(10);
		book.setBookPrice(600);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.updateBookPrice(book.getBookId(), book.getBookPrice()));

	}

	// Below the code for test update the book quantity
	@Test
	void testUpdateBookQty() {
		Book book = new Book();
		book.setBookId(3);
		book.setQuantity(3);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.updateBookQty(book.getBookId(), book.getQuantity()));
	}

	// Below the code for test the read the book using title name or category name
	@Test
	void testReadBookTitle() {
		Book book = new Book();
		book.setBookCategories(Categories.FICTION_BOOKS);
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.getAllBooksByCatgy(book.getBookCategories().toString()));

	}

	// Below the code for test the tamil book using lang

	@Test
	void testReadTamilBook() {
		Book book = new Book();
		book.setBooklanguage("tamil");
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.getAllTamilBooks(book.getBooklanguage()));
	}
	@Test
	void testUpdateBookStock() {
		Book book = new Book();
		BookService bookService = new BookService();
		assertDoesNotThrow(() -> bookService.updateStock(2, 3));
	}

	@Test
	void ReadAllBook() throws ServiceException {
		BookService bookService = new BookService();
		List<Book> bookList = bookService.getAllBook();
		for (Book ele : bookList) {
		}
	}

	// Below the code for check the book update
	@Test
	void testUpdateBook() throws ServiceException, SQLException {

		BookService bookService = new BookService();
		Book book = new Book();

		book.setBookId(10);
		book.setBookName("Attitude is everything by Jeff Keller.");
		book.setAuthor("jeff keller");
		book.setBookCategories(Categories.SELFHELP_BOOKS);
		book.setBookImageUrl("https://m.media-amazon.com/images/I/71Rcjb+1yLL.jpg");
		book.setBooklanguage("tamil");
		book.setBookPrice(800.00);
		book.setQuantity(2);
		book.setAuthor("Brain Tracy");
		book.setBookDescription(
				"Attitude is an all-encompassing term that defines your outlook and approach to life.It includes your inner thoughts and outward experssions. In the end, attitude determines everything you say and so and what you say and do determine your success. Attitude is an all-encompassing term that defines your outlook and approach to life.It includes your inner thoughts and outward experssions. In the end, attitude determines everything you say and so. ");
		book.setAuthorImgUrl("https://iili.io/J9qBtse.jpg");
		book.setIsbn("978-0979041037"); 
		book.setBookWeight(800);
		book.setBookwidth(7.0);
		book.setBookHeight(6.0);
		book.setBookDepth(2.0);
		book.setBookBinding(BookBinding.PAPERBACK);
		book.setAboutAuthor(
				"Jeffrey Keller, President Of Attitude Is Everything, Incorporated, Works With Organizations That Want To Develop Acheivers Ans With Sales Mangeres Who Want Theru People To Be More Positive Jeff Is A Speaker,Seminar Leader And Writer In The Area Of Motivation And Human Potential.He Delivers His Uplifting Persentation To Businesses,Associations And Educational Instituation Jeff Is Also An Attorney And Praticed Law For More Than Ten Years Before Pursing A Full Time Carrer As A Speaker And Writer. In June 1999,Jeff's Book,Attitude Is.");
		book.setReturnable(BookReturnable.YES);
		book.setPublisherImprint("Savitha Printer");
		book.setPublisherDate(LocalDate.of(2020, 10, 2)); // Year / Month / Date

		assertDoesNotThrow(() -> bookService.updateBook(book.getBookId(), book));
	}

}
