package com.fssa.book.service;

import java.sql.SQLException;

import com.fssa.book.Dao.BookDAO;
import com.fssa.book.exception.DAOException;
import com.fssa.book.model.Book;
import com.fssa.book.validator.BookValidator;

public class BookServiceLayer {
	
	// Below the code create the instance For DAO layer. 
	
	public boolean addBook(Book book)throws IllegalArgumentException,DAOException,SQLException {
			
			try {
			BookValidator.validate(book);
			BookDAO.createBook(book);
			return true;
			}
			catch(DAOException  | SQLException ex ) 
			{
				throw new DAOException("Object are empty or bug" + ex.getMessage());
			}
			
			
		}
			
		
		public static boolean updateBookPrice(int bookId , int bookPrice) throws DAOException,SQLException {
			
		if(BookValidator.validateBookPrice(300)){
			return BookDAO.updateBook(bookId, bookPrice);
		}
		else {
			return false;
			
		}
		
		
			
		}
		
}
