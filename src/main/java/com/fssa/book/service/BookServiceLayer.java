package com.fssa.book.service;

import java.sql.SQLException;

import com.fssa.book.dao.BookDAO;
import com.fssa.book.exception.DAOException;
import com.fssa.book.model.Book;
import com.fssa.book.validator.BookValidator;

public class BookServiceLayer {

    // Below the code create the instance For DAO layer.

    public boolean addBook(Book book) throws IllegalArgumentException, DAOException, SQLException {
    	BookValidator bookValidator = new BookValidator();

        try {
            bookValidator.validate(book);
            BookDAO.createBook(book);
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

        try {
            BookDAO.readBook(book.getBookId());
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
        try {
            bookValidator.validateBookPrice(bookPrice);
            BookDAO.updateBookPrice(bookId, bookPrice);
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
        try {
            BookDAO.deleteBook(bookId); 
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
        try {
            bookValidator.validateBookQuantity(4); 
            BookDAO.udpatebookQty(bookID, bookQty); 
            return true;
        } catch (SQLException | DAOException e) {
            throw new DAOException("updation fails" + e.getMessage());
        }
    }
}
