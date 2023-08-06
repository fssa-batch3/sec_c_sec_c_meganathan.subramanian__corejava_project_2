package com.fssa.book.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.book.exception.DAOException;
import com.fssa.book.model.Book;

public class BookDAO {

	public static boolean createBook(Book book) throws DAOException, SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String insertQuery = "INSERT INTO books (bookId , bookName , bookPrice, bookCategories, bookImage, booklanguage , quantity, author , bookDescription) VALUES (?,?,?,?,?,?,?,?,?)";
			try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {

				pstmt.setInt(1, book.getBookId());
				pstmt.setString(2, book.getBookName());
				pstmt.setDouble(3, book.getBookPrice());
				pstmt.setString(4, book.getBookCategories());
				pstmt.setString(5, book.getBookImage());
				pstmt.setString(6, book.getBooklanguage());
				pstmt.setInt(7, book.getQuantity());
				pstmt.setString(8, book.getAuthor());
				pstmt.setString(9, book.getBookDescription());

				pstmt.executeUpdate();
				return true;

			} catch (SQLException e) {
				throw new DAOException("Error while creating task: " + e.getMessage());
			}

		}

	}

	// Below the code for read the book
	public static Book readBook(int bookId) throws DAOException, SQLException {

		try (Connection connection = ConnectionUtil.getConnection()) {
			String selectQuery = "SELECT * FROM books WHERE bookId=?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setInt(1, bookId);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						Book book = new Book();
						book.setBookId(rs.getInt("bookId"));
						book.setBookName(rs.getString("bookName"));
						book.setAuthor(rs.getString("author"));
						book.setBookCategories(rs.getString("bookCategories"));
						book.setBookDescription(rs.getString("bookDescription"));
						book.setBookImage(rs.getString("bookImage"));
						book.setBookPrice(rs.getInt("bookPrice"));
						book.setBooklanguage(rs.getString("bookLanguage"));
						book.setQuantity(rs.getInt("quantity"));
						return book;
						// System.out.println(book);
					} else {
						return null; // book object are not or not found
					}
				}
			}

		} catch (SQLException ex) {
			throw new DAOException("Error while reading the book" + ex.getMessage());
		}
	}

	public static boolean deleteBook(int BookId) throws DAOException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String deleteQuery = "DELETE FROM Books WHERE bookId=?";
			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {
				psmt.setInt(1, BookId);
				psmt.executeUpdate();
				return true;
			}
		} catch (SQLException e) {
			throw new DAOException("Error while deleting task: " + e.getMessage());
		}
	}

	public static boolean updateBookPrice(int BookId, int bookPrice) throws DAOException, SQLException {
		try (Connection connection = ConnectionUtil.getConnection()) {
			String existQuery = "SELECT * FROM books WHERE bookId = ?";
			try (PreparedStatement psmt = connection.prepareStatement(existQuery)) {
				psmt.setInt(1, BookId);
				int bookid = psmt.executeUpdate(); 
				return true;
			} catch (SQLException e) {
				throw new SQLException("Given bookid does not exist");
			}
		}
		

	}
}
