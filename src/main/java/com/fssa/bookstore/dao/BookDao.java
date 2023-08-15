package com.fssa.bookstore.dao;

/**
 * Below the code for write the all query like create,read,delete,update
 * @author Meganathan Subramanian
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.Book;

public class BookDao {

	// Below the code for constant 
	public static final String GET_BOOKID = "SELECT * FROM books WHERE Id = ?";

	/**
	 * Below the code for Creating the new book in database
	 *
	 * @param book
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public boolean createBook(Book book) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String insertQuery = "INSERT INTO books (Id , Name , Price, Categories, Image, language , quantity, author , Description) VALUES (?,?,?,?,?,?,?,?,?)";
			try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {

				pstmt.setInt(1, book.getBookId()); 
				pstmt.setString(2, book.getBookName());
				pstmt.setDouble(3, book.getBookPrice());
				pstmt.setString(4, book.getbookCategories());
				pstmt.setString(5, book.getBookImage());
				pstmt.setString(6, book.getBooklanguage());
				pstmt.setInt(7, book.getQuantity());
				pstmt.setString(8, book.getAuthor());
				pstmt.setString(9, book.getBookDescription());

				pstmt.executeUpdate();
				return true;

			} catch (SQLException e) {
				throw new DAOException("Error while adding book : " + e.getMessage());
			}

		}

	}

	/**
	 * Below the code for read the book
	 *
	 * @param bookId
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public Book readBook(int bookId) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String selectQuery = GET_BOOKID;
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setInt(1, bookId);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						Book book = new Book();
						book.setBookId(rs.getInt("Id"));
						book.setBookName(rs.getString("Name"));
						book.setAuthor(rs.getString("author"));
						book.setbookCategories(rs.getString("Categories"));
						book.setBookDescription(rs.getString("Description"));
						book.setBookImage(rs.getString("Image"));
						book.setBookPrice(rs.getInt("Price"));
						book.setBooklanguage(rs.getString("Language"));
						book.setQuantity(rs.getInt("quantity"));
						return book;

					} else {
						return null; // book object are not or not found
					}
				}
			}

		} catch (SQLException ex) {
			throw new DAOException("Error while reading the book" + ex.getMessage());
		}
	}

	/**
	 * @param BookId
	 * @throws DAOException
	 * @throws SQLException
	 */

	public void deleteBook(int bookId) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String existQuery = GET_BOOKID;
			try (PreparedStatement psmt = connection.prepareStatement(existQuery)) {
				psmt.setInt(1, bookId);
				try (ResultSet rs = psmt.executeQuery()) {
					if (!rs.next()) {
						Logger.info("Id doesn't exists in database");
					} else {
						Logger.info("Id Got sucessfully.");
					}
				}
			}
		} catch (SQLException ex) {
			throw new DAOException("Error while getting the id  " + ex.getMessage());
		}

		// Below the code for delete the book using book id
		try (Connection connection = connectionUtil.getConnection()) {
			String deleteQuery = "DELETE FROM books WHERE Id = ?";
			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {
				psmt.setInt(1, bookId);
				int rowAffected = psmt.executeUpdate(); 
				if (rowAffected > 0) {
					Logger.info("Successfully delete the row " + bookId);
				} else {
					Logger.info("Error while deleting the book");
				}
			}
		} 
	}

	/**
	 * Below the code for update the book price using book id
	 *
	 * @param bookId
	 * @param bookPrice
	 * @throws DAOException
	 * @throws SQLException
	 */
	public void updateBookPrice(int bookId, int bookPrice) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String existQuery = GET_BOOKID;
			try (PreparedStatement psmt = connection.prepareStatement(existQuery)) {
				psmt.setInt(1, bookId);
				try (ResultSet rs = psmt.executeQuery()) {
					if (!rs.next()) {
						throw new DAOException("given bookid doesn't exist");
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while checking bookid exist" + e.getMessage());
		}

		try (Connection connection = connectionUtil.getConnection()) {
			String updateQuery = "UPDATE books set Price = ? WHERE Id = ?";
			try (PreparedStatement psmt = connection.prepareStatement(updateQuery)) {
				psmt.setInt(1, bookPrice);
				psmt.setInt(2, bookId);
				int rowsAffected = psmt.executeUpdate();
				if (rowsAffected > 0) {
					Logger.info("Successfully updated bookprice");
				} else {
					Logger.info("bookprice updation fails");
				}
			}
		} catch (SQLException e) {
			throw new DAOException(e.getMessage());
		}
	}

	/**
	 * // Below the code for update the book qty
	 *
	 * @param bookId
	 * @param bookQty
	 * @throws DAOException
	 * @throws SQLException
	 */

	public void udpatebookQty(int bookId, int bookQty) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String existsQuery = GET_BOOKID;
			try (PreparedStatement psmt = connection.prepareStatement(existsQuery)) {
				psmt.setInt(1, bookId);
				try (ResultSet rs = psmt.executeQuery()) {
					if (!rs.next()) {
						throw new DAOException("id doesn't exists");
					}
				}

			}
		} catch (SQLException ex) {
			throw new SQLException("Error while checking the book id");
		}

		// This second try for update the book price qty
		try (Connection connection = connectionUtil.getConnection()) {
			String updateQuery = "UPDATE books set quantity = ? WHERE Id = ?";
			try (PreparedStatement psmt = connection.prepareStatement(updateQuery)) {
				psmt.setInt(1, bookQty);
				psmt.setInt(2, bookId);
				int rowsAffected = psmt.executeUpdate();
				if (rowsAffected > 0) { 
					Logger.info("Successfully updated bookqty");
				} else {
					Logger.info("bookqty updation fails");
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while changing the book qty " + e.getMessage());
		}

	}
}
