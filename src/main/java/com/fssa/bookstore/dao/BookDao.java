package com.fssa.bookstore.dao;


/**
 * Below the code for write the all query like create,read,delete,update
 * @author MeganathanSubramanian
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.fssa.bookstore.enums.Categories;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.Book;

public class BookDao {

	// Below the code for constant
	public static final String GET_BOOKID = "SELECT * FROM books WHERE book_id = ?";

	/**
	 * Below the code for Creating the new book in database
	 *
	 * @param book
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public boolean createBook(Book book) throws DAOException, SQLException {

		// Below the code for check the already exists book name or title
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String existsQuery = "SELECT * FROM books WHERE title = ? ";
			try (PreparedStatement psmt = connection.prepareStatement(existsQuery)) {
				psmt.setString(1, book.getBookName());
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						throw new DAOException("This book is already there in your DB");
					}
				}

			}
		} catch (SQLException ex) {
			throw new DAOException("Error while checking the book title" + ex.getMessage());
		}

		// below the code for create the new book into the DB.

		try (Connection connection = connectionUtil.getConnection()) {
			String insertQuery = "INSERT INTO books (book_id , title , price, category, image_url, language , quantity , author , description) VALUES (?,?,?,?,?,?,?,?,?)";
			try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {

				pstmt.setInt(1, book.getBookId());
				pstmt.setString(2, book.getBookName());
				pstmt.setDouble(3, book.getBookPrice());
				pstmt.setString(4, book.getbookCategories().toString());
				pstmt.setString(5, book.getBookImageUrl());
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
	 * @param bookId //
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public Book readBook(int bookId) throws DAOException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) { // Get the connections
			String selectQuery = GET_BOOKID; // query is constant
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) { //
				psmt.setInt(1, bookId);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						Book book = new Book();
						book.setBookId(rs.getInt("book_id"));
						book.setBookName(rs.getString("title"));
						book.setAuthor(rs.getString("author"));
						String categoryString = rs.getString("category");

						// Convert to the string and set the values
						if (categoryString != null) {
							Categories category = Categories.valueOf(categoryString);
							book.setbookCategories(category);
						}
						book.setBookDescription(rs.getString("description"));
						book.setBookImageUrl(rs.getString("image_url"));
						book.setBookPrice(rs.getInt("price"));
						book.setBooklanguage(rs.getString("language"));
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
			String deleteQuery = "DELETE FROM books WHERE book_id = ?";
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
	public void updateBookPrice(int bookId, double bookPrice) throws DAOException, SQLException {
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

		// Below the code for update the query

		try (Connection connection = connectionUtil.getConnection()) {
			String updateQuery = "UPDATE books set Price = ? WHERE book_id = ?";
			try (PreparedStatement psmt = connection.prepareStatement(updateQuery)) {
				psmt.setDouble(1, bookPrice);
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
			String updateQuery = "UPDATE books set quantity = ? WHERE book_id = ?";
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

	public Set<Book> getAllBookByCateName(String catgyName) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		Set<Book> listOfBooksByCategory = new HashSet<>();

		try (Connection connection = connectionUtil.getConnection()) {
			String readQuery = "SELECT * FROM books WHERE category = ?";
			try (PreparedStatement psmt = connection.prepareStatement(readQuery)) {
				psmt.setString(1, catgyName);
				try (ResultSet rs = psmt.executeQuery()) {
					while (rs.next()) {
						Book book = new Book();
						book.setBookId(rs.getInt("book_id"));
						book.setBookName(rs.getString("title"));
						book.setBookPrice(rs.getDouble("price"));
						book.setBookImageUrl(rs.getString("image_url"));
						String categoryString = rs.getString("category");

						// Convert to the string and set the values
						if (categoryString != null) {
							Categories category = Categories.valueOf(categoryString);
							book.setbookCategories(category);
						}
						book.setQuantity(rs.getInt("quantity"));
						book.setAuthor(rs.getString("author"));
						book.setBookDescription(rs.getString("description"));
						book.setBooklanguage(rs.getString("language"));
						listOfBooksByCategory.add(book);
						Logger.info(listOfBooksByCategory);
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while changing the book qty " + e.getMessage());
		}
		 return listOfBooksByCategory;
	}

}
