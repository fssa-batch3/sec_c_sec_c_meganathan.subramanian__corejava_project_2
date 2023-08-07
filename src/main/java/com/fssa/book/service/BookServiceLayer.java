package com.fssa.book.service;

import java.sql.SQLException;

import com.fssa.book.Dao.BookDAO;
import com.fssa.book.exception.DAOException;
import com.fssa.book.model.Book;
import com.fssa.book.validator.BookValidator;

public class BookServiceLayer {
 
	// Below the code create the instance For DAO layer.

	public boolean addBook(Book book) throws IllegalArgumentException, DAOException, SQLException {

		try {
			BookValidator.validate(book);
			BookDAO.createBook(book);
			return true;
		} catch (DAOException | SQLException ex) {
			throw new DAOException("Object are empty or bug" + ex.getMessage());
		}

	}

	// Below the code for read the book for mysql

	public Book readBook(Book book) throws DAOException, SQLException {

		try {
			BookDAO.readBook(book.getBookId());
		} 
		catch(DAOException | SQLException ex) {
			throw new DAOException("book id not found" + ex.getMessage());
			
		}
		return book;

	}

	/**
	 *
	 * @param bookId
	 * @param bookPrice
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public boolean updateBookPrice(int bookId , int bookPrice) throws  DAOException, SQLException{

		try {
			BookValidator.validateBookPrice(bookPrice);
			BookDAO.updateBookPrice(bookId, bookPrice);
			return true;
		} catch(DAOException | SQLException e) {
			throw new DAOException("Updation fails" + e.getMessage());
		}
	}


	public boolean  updateBookQty(int bookID, int bookQty) throws  DAOException, SQLException{
		try{
			BookValidator.validateBookQuantity(4);
			BookDAO.udpatebookQty(bookID,bookQty);
			return  true;
		}
		catch(DAOException | SQLException e){
			throw new DAOException("updation fails" + e.getMessage());
		}
	}



}
