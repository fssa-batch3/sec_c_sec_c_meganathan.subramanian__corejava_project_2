package com.fssa.bookstore.service;

import java.sql.SQLException;
import java.util.List;

import com.fssa.bookstore.dao.BookDao;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.exception.InvalidInputException;
import com.fssa.bookstore.exception.ServiceException;
import com.fssa.bookstore.model.Book;
import com.fssa.bookstore.validator.BookValidator;

public class BookService {

	// Below the code create the instance For DAO layer.
	public boolean addBook(Book book) throws ServiceException {
		BookValidator bookValidator = new BookValidator();
		BookDao bookDao = new BookDao();
		try {
			bookValidator.validate(book);
			bookDao.createBook(book);
			return true;
			
		} catch (DAOException | SQLException | InvalidInputException ex) {
			throw new ServiceException("Object are empty or Attribute error" + ex.getMessage());
		}

	}

	/**
	 * Below the code for read the book for mysql
	 *
	 * @param book
	 * @return book
	 * @throws DAOException
	 * @throws SQLException
	 */

	public Book readBook(int bookId) throws ServiceException, DAOException {

		BookValidator validator = new BookValidator();
		validator.validateBookId(bookId);
		BookDao bookDao = new BookDao();
		Book book = bookDao.readBook(bookId);

		return book;
	}

	/**
	 * @param bookId
	 * @param bookPrice
	 * @return true or false
	 * @throws DAOException
	 * @throws SQLException
	 */
	public boolean updateBookPrice(int bookId, double bookPrice) throws ServiceException {
		BookValidator bookValidator = new BookValidator();
		BookDao bookDao = new BookDao();

		try {
			bookValidator.validateBookPrice(bookPrice);
			bookValidator.CheckBookIdExist(bookId);
			bookDao.updateBookPrice(bookId, bookPrice);
			return true;
		} catch (DAOException | SQLException e) {
			throw new ServiceException("Updation fails" + e.getMessage());
		}
	}

	/**
	 * Delete the book using book id
	 *
	 * @param bookId
	 * @return true or false  
	 * @throws DAOException
	 * @throws SQLException
	 */
	public boolean deleteBookUsingId(int bookId) throws ServiceException {

		BookValidator bookValidator = new BookValidator();
		bookValidator.CheckBookIdExist(bookId);

		BookDao bookDao = new BookDao();

		try {
			bookDao.deleteBook(bookId);
			return true;
		} catch (DAOException | SQLException ex) {
			throw new ServiceException("Error while delete the book" + ex.getMessage());

		}
	}

	/**
	 * update the quantity using the book id
	 * 
	 * @param bookID
	 * @param bookQty
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public boolean updateBookQty(int bookId, int bookQty) throws ServiceException {
		BookValidator bookValidator = new BookValidator();
		BookDao bookDao = new BookDao();
		try {
			bookValidator.validateBookQuantity(4);
			bookValidator.CheckBookIdExist(bookId);
			bookDao.udpatebookQty(bookId, bookQty);
			return true;
		} catch (SQLException | DAOException e) {
			throw new ServiceException("updation fails" + e.getMessage());
		}
	}

	/**
	 * Below the code for filter the book using the category
	 * 
	 * @param catogyName - This will return the parameter as String
	 * @return
	 * @throws ServiceException -- if exception occurs this will throw
	 */

	public List<Book> getAllBooksByCateName(String catogyName) throws ServiceException {

		BookDao bookDao = new BookDao();
		List<Book> books;
		try {
			books = bookDao.getAllBookByCateName(catogyName);
		} catch (DAOException e) {
			throw new ServiceException("Category name are not found" + e.getMessage());
		}

		return books;

	}
	
	
	/**
	 * Below the code for get the all tamil books
	 * from the database
	 * @param langName
	 * @return
	 * @throws ServiceException
	 */
	
	public List<Book> getAllTamilBooks(String langName)throws ServiceException{
		
		BookDao bookDao = new BookDao();
		List<Book> books;
		try {
			books = bookDao.getTamilBookCategy(langName);
		}
		catch(DAOException e){
			throw new ServiceException("lang name is not found" + e.getMessage());
		}
		return books;
	}

	/**
	 * below the code for get all books
	 * 
	 * @return
	 * @throws ServiceException
	 */

	public List<Book> getAllBook() throws ServiceException {
		BookDao bookDao = new BookDao();
		List<Book> books;
		try {
			books = bookDao.getAllBooks();
		} catch (DAOException | SQLException e) {
			throw new ServiceException("Error while getting all the book" + e.getMessage());
		}
		return books;
	}

	/**
	 * Below the code for update the book
	 * 
	 * @param bookId
	 * @param book
	 * @throws ServiceException
	 * @throws SQLException
	 */

	public boolean updateBook(int bookId, Book book) throws ServiceException, SQLException {

		BookValidator bookValidator = new BookValidator(); // Create a new instance obj

		bookValidator.validateBookId(bookId);
		bookValidator.CheckBookIdExist(bookId);
		bookValidator.validateAuthorName(book.getAuthor());
		bookValidator.validateBookCategoriesName(book.getBookCategories());
		bookValidator.validateBookDescription(book.getBookDescription());
		bookValidator.validateBookImageUrl(book.getBookImageUrl());
		bookValidator.validateBookLanguages(book.getBooklanguage());
		bookValidator.validateBookName(book.getBookName());
		bookValidator.validateBookPrice(book.getBookPrice());
		bookValidator.validateBookQuantity(book.getQuantity());
		

		BookDao bookDAO = new BookDao(); // Create the new instance for the dao obj.
		try {
			bookDAO.updateBook(bookId, book);
			return true;
		} catch (DAOException | SQLException e) {
			e.printStackTrace();
			throw new ServiceException("Error while update the books");
		}
	}
}
