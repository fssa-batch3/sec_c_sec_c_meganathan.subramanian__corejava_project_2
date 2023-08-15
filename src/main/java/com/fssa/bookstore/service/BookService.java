package com.fssa.bookstore.service;

import java.sql.SQLException;

import com.fssa.bookstore.dao.BookDao;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.model.Book;
import com.fssa.bookstore.validator.BookValidator;

public class BookService {

    // Below the code create the instance For DAO layer.

    public boolean addBook(Book book) throws IllegalArgumentException, DAOException, SQLException {
    	BookValidator bookValidator = new BookValidator();
    	BookDao bookDao = new BookDao();

        try {
            bookValidator.validate(book);
            bookDao.createBook(book);
            return true;
        } catch (DAOException | SQLException ex) {
            throw new DAOException("Object are empty or bug" + ex.getMessage());
        }

    }

    /**
     * // Below the code for read the book for mysql
     *
     * @param book
     * @return
     * @throws DAOException
     * @throws SQLException
     */


    public Book readBook(Book book) throws DAOException, SQLException {
    	BookDao bookDao = new BookDao();
        try {
        	bookDao.readBook(book.getBookId());
        } catch (DAOException | SQLException ex) {
            throw new DAOException("book id not found" + ex.getMessage());

        }
        return book;

    }

    /**
     * @param bookId
     * @param bookPrice
     * @return
     * @throws DAOException
     * @throws SQLException
     */
    public boolean updateBookPrice(int bookId, int bookPrice) throws DAOException, SQLException {
    	BookValidator bookValidator = new BookValidator();
    	BookDao bookDao = new BookDao();
    	
        try {
            bookValidator.validateBookPrice(bookPrice);
            bookDao.updateBookPrice(bookId, bookPrice);
            return true;
        } catch (DAOException | SQLException e) {
            throw new DAOException("Updation fails" + e.getMessage());
        }
    }

    /**
     * Delete the book using book id
     *
     * @param bookId
     * @return
     * @throws DAOException
     * @throws SQLException
     */
    public boolean deleteBookUsingId(int bookId) throws DAOException, SQLException {
    	BookDao bookDao = new BookDao();
    	
        try {
        	bookDao.deleteBook(bookId); 
            return true;
        } catch (DAOException | SQLException ex) {
            throw new DAOException("Error while delete the book" + ex.getMessage());

        }
    } 

    /**
     * update the quantity using the book id
     * @param bookID
     * @param bookQty
     * @return
     * @throws DAOException
     * @throws SQLException
     */

    public boolean updateBookQty(int bookID, int bookQty) throws SQLException, DAOException {
    	BookValidator bookValidator = new BookValidator();
    	BookDao bookDao = new BookDao();
        try {
            bookValidator.validateBookQuantity(4); 
            bookDao.udpatebookQty(bookID, bookQty); 
            return true;
        } catch (SQLException | DAOException e) {
            throw new DAOException("updation fails" + e.getMessage());
        }
    }
}
