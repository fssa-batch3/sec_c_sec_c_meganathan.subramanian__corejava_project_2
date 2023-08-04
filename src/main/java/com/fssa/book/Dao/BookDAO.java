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

	public static boolean updateBook(int bookId, int bookPrice) throws SQLException, DAOException {
		boolean bookExists = false;

		try (Connection connection = ConnectionUtil.getConnection()) {
			final String existsQuery = "SELECT * FROM books WHERE bookId = ?";
			try (PreparedStatement pstmt = connection.prepareStatement(existsQuery)) {
				pstmt.setInt(1, bookId);
				try (ResultSet resultSet = pstmt.executeQuery()) {
					bookExists = resultSet.next(); // Check if the book exists in the result set
				}
			}

		} catch (SQLException e) {
			throw new DAOException("Error checking if book exists: " + e.getMessage());
		}

		if (bookExists) {
			try (Connection connection = ConnectionUtil.getConnection()) {
				String updateQuery = "UPDATE books SET bookPrice = ? WHERE bookId = ?";
				try (PreparedStatement pstmt = connection.prepareStatement(updateQuery)) {
					pstmt.setInt(1, bookPrice);
					pstmt.setInt(2, bookId);
					pstmt.executeUpdate();
				}
			} catch (SQLException e) {
				throw new DAOException("Error updating book price: " + e.getMessage());
			}
			return true;
		} else {
			throw new DAOException("Given book_id does not exist");
		}
	}

	public Book getBookById(int id) throws SQLException {

		Connection connection = ConnectionUtil.getConnection();
		Book book = null;

		try {

			String query = "SELECT * FROM  books WHERE bookId= ? ";
			PreparedStatement stmt = connection.prepareStatement(query);

			stmt.setInt(1, id);

			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {

				book = new Book();
				book.setBookName(rs.getString("bookName"));
				book.setBookPrice(rs.getDouble("bookPrice"));
				book.setBookCategories(rs.getString("bookCategories"));

				book.setBookImage(rs.getString("bookImage"));

				book.setBooklanguage(rs.getString("bookLanguage"));
				book.setQuantity(rs.getInt("quantity"));
				book.setAuthor(rs.getString("author"));
				book.setBookDescription(rs.getString("bookDescription"));

			}
			rs.close();

			stmt.close();

		} catch (SQLException e) {
			e.getMessage();
		}
		
		return book;
	}

}
