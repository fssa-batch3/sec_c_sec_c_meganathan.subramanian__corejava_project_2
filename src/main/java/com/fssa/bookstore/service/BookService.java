package com.fssa.bookstore.service;

import java.sql.SQLException;
import java.util.Set;
import com.fssa.bookstore.dao.BookDao;
import com.fssa.bookstore.enums.Categories;
import com.fssa.bookstore.exception.DAOException;
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
		} catch (DAOException | SQLException ex) {
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

	public Book readBook(Book book) throws ServiceException {
		BookDao bookDao = new BookDao();
		try {
			bookDao.readBook(book.getBookId());
		} catch (DAOException ex) {
			throw new ServiceException("book id not found" + ex.getMessage());

		}
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

	public boolean updateBookQty(int bookID, int bookQty) throws ServiceException {
		BookValidator bookValidator = new BookValidator();
		BookDao bookDao = new BookDao();
		try {
			bookValidator.validateBookQuantity(4);
			bookDao.udpatebookQty(bookID, bookQty);
			return true;
		} catch (SQLException | DAOException e) {
			throw new ServiceException("updation fails" + e.getMessage());
		}
	}

	public Set<Book> getAllBooksByCateName(String catogyName) throws ServiceException {

		BookDao bookDao = new BookDao();
		Set<Book> books;
		try {
			books = bookDao.getAllBookByCateName(catogyName);
		} catch (DAOException | SQLException e) {
			throw new ServiceException("Category name are not found" + e.getMessage());
		}

		return books;

	}
}
