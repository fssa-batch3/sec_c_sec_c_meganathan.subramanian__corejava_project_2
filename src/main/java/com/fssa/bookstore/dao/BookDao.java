package com.fssa.bookstore.dao;

/**
 * Below the code for write the all query like create,read,delete,update
 * @author MeganathanSubramanian
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Binding;

import com.fssa.bookstore.enums.BookBinding;
import com.fssa.bookstore.enums.BookReturnable;
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
	 * @param book - It is the model object
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
			String insertQuery = "INSERT INTO books (book_id , title , price, category, image_url, language , quantity , author , description , authorImgUrl , aboutAuthor , publisherImprint, publisherDate, isbn, width, pages, height, depth, weight, binding, returnable) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try (PreparedStatement pstmt = connection.prepareStatement(insertQuery)) {

				pstmt.setInt(1, book.getBookId());
				pstmt.setString(2, book.getBookName());
				pstmt.setDouble(3, book.getBookPrice());
				pstmt.setString(4, book.getBookCategories().toString());
				pstmt.setString(5, book.getBookImageUrl());
				pstmt.setString(6, book.getBooklanguage());
				pstmt.setInt(7, book.getQuantity());
				pstmt.setString(8, book.getAuthor());
				pstmt.setString(9, book.getBookDescription());
				pstmt.setString(10, book.getAuthorImg());
				pstmt.setString(11, book.getAboutAuthor());
				pstmt.setString(12, book.getPublisherImprint());
				pstmt.setDate(13, java.sql.Date.valueOf(book.getPublisherDate()));
				pstmt.setString(14, book.getisbn());
				pstmt.setDouble(15, book.getBookwidth());
				pstmt.setDouble(16, book.getNoOfPages());
				pstmt.setDouble(17, book.getBookHeight());
				pstmt.setDouble(18, book.getBookDepth());
				pstmt.setDouble(19, book.getBookWeight());
				pstmt.setString(20, book.getBookBinding().toString());
				pstmt.setString(21, book.getReturnable().toString());

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
						String bookBindingString = rs.getString("binding");
						String bookReturnString = rs.getString("returnable");

						// Convert to the string and set the values
						if (categoryString != null || bookBindingString != null || bookReturnString != null) {
							Categories category = Categories.valueOf(categoryString);
							BookReturnable bookReturn = BookReturnable.valueOf(bookReturnString);
							BookBinding bookBinding = BookBinding.valueOf(bookBindingString);

							book.setBookCategories(category);
							book.setBookBinding(bookBinding);
							book.setReturnable(bookReturn);
						}
						book.setBookDescription(rs.getString("description"));
						book.setBookImageUrl(rs.getString("image_url"));
						book.setBookPrice(rs.getInt("price"));
						book.setBooklanguage(rs.getString("language"));
						book.setQuantity(rs.getInt("quantity"));
						book.setAboutAuthor(rs.getString("aboutAuthor"));
						book.setAuthorImgUrl(rs.getString("authorImgUrl"));
						book.setPublisherImprint(rs.getString("publisherImprint"));
						book.setPublisherDate(rs.getDate("publisherDate").toLocalDate());
						book.setIsbn(rs.getString("isbn"));
						book.setBookwidth(rs.getDouble("width"));
						book.setNoOfPages(rs.getInt("pages"));
						book.setBookHeight(rs.getDouble("height"));
						book.setBookDepth(rs.getDouble("depth"));
						book.setBookWeight(rs.getDouble("weight"));

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

	/**
	 * Below the code for update the whole book like user can update anything they
	 * want.
	 * 
	 * @param catgyName
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public void updateBook(int bookId, Book book) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String getProductQuery = "UPDATE books SET title=?, price=?, category=?, image_url=?, language=?, author=?, description=?, quantity=?, authorImgUrl=?, aboutAuthor=?,publisherImprint=?, publisherDate =?,isbn=?,width=?,pages=?,height=?,depth=?,weight=?,binding=?,returnable=? WHERE book_id=?";
			try (PreparedStatement psmt = connection.prepareStatement(getProductQuery)) {
				psmt.setString(1, book.getBookName());
				psmt.setDouble(2, book.getBookPrice());
				psmt.setString(3, book.getBookCategories().toString());
				psmt.setString(4, book.getBookImageUrl());
				psmt.setString(5, book.getBooklanguage());
				psmt.setString(6, book.getAuthor());
				psmt.setString(7, book.getBookDescription());
				psmt.setInt(8, book.getQuantity());
				psmt.setString(9, book.getAuthorImg());
				psmt.setString(10, book.getAboutAuthor());
				psmt.setString(11, book.getPublisherImprint());
				psmt.setDate(12, java.sql.Date.valueOf(book.getPublisherDate()));
				psmt.setString(13, book.getisbn());
				psmt.setDouble(14, book.getBookwidth());
				psmt.setDouble(15, book.getNoOfPages());
				psmt.setDouble(16, book.getBookHeight());
				psmt.setDouble(17, book.getBookDepth());
				psmt.setDouble(18, book.getBookWeight());
				psmt.setString(19, book.getBookBinding().toString());
				psmt.setString(20, book.getReturnable().toString());
				psmt.setInt(21, bookId);

				int rowsAffected = psmt.executeUpdate();
				if (rowsAffected > 0) {
					Logger.info("Successfully updated");
				} else {
					Logger.info("bookqty updation fails");
				}

			}
		} catch (SQLException e) {
			throw new DAOException("Error while getting the book details " + e.getMessage());
		}

	}

	/*
	 * Below the code for get the book by the category name
	 * 
	 * @param catgyname - This parameter pass the value as string
	 */

	public List<Book> getAllBookByCatgy(String catgyName) throws DAOException{
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<Book> listOfBooksByCategory = new ArrayList<>();

		try (Connection connection = connectionUtil.getConnection()) {
			String readQuery = "SELECT * FROM books WHERE category = ?";
			try (PreparedStatement psmt = connection.prepareStatement(readQuery)) {
				psmt.setString(1, catgyName);
				try (ResultSet rs = psmt.executeQuery()) {
					while (rs.next()) {
						Book book = new Book();

						String categoryString = rs.getString("category");
						String bookBindingString = rs.getString("binding");
						String bookReturnString = rs.getString("returnable");

						// Convert to the string and set the values
						if (categoryString != null || bookBindingString != null || bookReturnString != null) {
							Categories category = Categories.valueOf(categoryString);
							BookReturnable bookReturn = BookReturnable.valueOf(bookReturnString);
							BookBinding bookBinding = BookBinding.valueOf(bookBindingString);

							book.setBookCategories(category);
							book.setBookBinding(bookBinding);
							book.setReturnable(bookReturn);
							book.setBookId(rs.getInt("book_id"));
							book.setBookName(rs.getString("title"));
							book.setAuthor(rs.getString("author"));
							book.setBookDescription(rs.getString("description"));
							book.setBookImageUrl(rs.getString("image_url"));
							book.setBookPrice(rs.getInt("price"));
							book.setBooklanguage(rs.getString("language"));
							book.setQuantity(rs.getInt("quantity"));
							book.setAboutAuthor(rs.getString("aboutAuthor"));
							book.setAuthorImgUrl(rs.getString("authorImgUrl"));
							book.setPublisherImprint(rs.getString("publisherImprint"));
							book.setPublisherDate(rs.getDate("publisherDate").toLocalDate());
							book.setIsbn(rs.getString("isbn"));
							book.setBookwidth(rs.getDouble("width"));
							book.setNoOfPages(rs.getInt("pages"));
							book.setBookHeight(rs.getDouble("height"));
							book.setBookDepth(rs.getDouble("depth"));
							book.setBookWeight(rs.getDouble("weight"));
						} else {
							Logger.info("Enum is null");
						}

						listOfBooksByCategory.add(book);
						Logger.info(listOfBooksByCategory);
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while getting the book by catgy name" + e.getMessage());
		}
		return listOfBooksByCategory;
	}

	/**
	 * below the code for get all the book in the DATABASE
	 * 
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public List<Book> getAllBooks() throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<Book> listOfBooks = new ArrayList<>();
		try (Connection connection = connectionUtil.getConnection()) {
			String readAllBookQuery = "SELECT * FROM books";
			try (PreparedStatement psmt = connection.prepareStatement(readAllBookQuery)) {
				try (ResultSet rs = psmt.executeQuery()) {
					while (rs.next()) {
						Book book = new Book();

						String categoryString = rs.getString("category");
						String bookBindingString = rs.getString("binding");
						String bookReturnString = rs.getString("returnable");

						// Convert to the string and set the values
						if (categoryString != null || bookBindingString != null || bookReturnString != null) {
							Categories category = Categories.valueOf(categoryString);
							BookReturnable bookReturn = BookReturnable.valueOf(bookReturnString);
							BookBinding bookBinding = BookBinding.valueOf(bookBindingString);

							book.setBookCategories(category);
							book.setBookBinding(bookBinding);
							book.setReturnable(bookReturn);
							book.setBookId(rs.getInt("book_id"));
							book.setBookName(rs.getString("title"));
							book.setAuthor(rs.getString("author"));
							book.setBookDescription(rs.getString("description"));
							book.setBookImageUrl(rs.getString("image_url"));
							book.setBookPrice(rs.getInt("price"));
							book.setBooklanguage(rs.getString("language"));
							book.setQuantity(rs.getInt("quantity"));
							book.setAboutAuthor(rs.getString("aboutAuthor"));
							book.setAuthorImgUrl(rs.getString("authorImgUrl"));
							book.setPublisherImprint(rs.getString("publisherImprint"));
							book.setPublisherDate(rs.getDate("publisherDate").toLocalDate());
							book.setIsbn(rs.getString("isbn"));
							book.setBookwidth(rs.getDouble("width"));
							book.setNoOfPages(rs.getInt("pages"));
							book.setBookHeight(rs.getDouble("height"));
							book.setBookDepth(rs.getDouble("depth"));
							book.setBookWeight(rs.getDouble("weight"));
						} else {
							Logger.info("Enum is null");
						}

						listOfBooks.add(book);
					}
				}
			}

		}
		return listOfBooks;
	}
	
	
	/**
	 * Below the code for get the value list of
	 * books by lang name
	 * 
	 * @param langName
	 * @return
	 * @throws DAOException
	 */
	
	public List<Book> getTamilBookCategy(String langName)throws DAOException{
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<Book> listOfTamilBooks = new ArrayList<>();

		try (Connection connection = connectionUtil.getConnection()) {
			String readQuery = "SELECT * FROM books WHERE language = ?";
			try (PreparedStatement psmt = connection.prepareStatement(readQuery)) {
				psmt.setString(1, langName);
				try (ResultSet rs = psmt.executeQuery()) {
					while (rs.next()) {
						Book book = new Book();

						String categoryString = rs.getString("category");
						String bookBindingString = rs.getString("binding");
						String bookReturnString = rs.getString("returnable");

						// Convert to the string and set the values
						if (categoryString != null || bookBindingString != null || bookReturnString != null) {
							Categories category = Categories.valueOf(categoryString);
							BookReturnable bookReturn = BookReturnable.valueOf(bookReturnString);
							BookBinding bookBinding = BookBinding.valueOf(bookBindingString);

							book.setBookCategories(category);
							book.setBookBinding(bookBinding);
							book.setReturnable(bookReturn);
							book.setBookId(rs.getInt("book_id"));
							book.setBookName(rs.getString("title"));
							book.setAuthor(rs.getString("author"));
							book.setBookDescription(rs.getString("description"));
							book.setBookImageUrl(rs.getString("image_url"));
							book.setBookPrice(rs.getInt("price"));
							book.setBooklanguage(rs.getString("language"));
							book.setQuantity(rs.getInt("quantity"));
							book.setAboutAuthor(rs.getString("aboutAuthor"));
							book.setAuthorImgUrl(rs.getString("authorImgUrl"));
							book.setPublisherImprint(rs.getString("publisherImprint"));
							book.setPublisherDate(rs.getDate("publisherDate").toLocalDate());
							book.setIsbn(rs.getString("isbn"));
							book.setBookwidth(rs.getDouble("width"));
							book.setNoOfPages(rs.getInt("pages"));
							book.setBookHeight(rs.getDouble("height"));
							book.setBookDepth(rs.getDouble("depth"));
							book.setBookWeight(rs.getDouble("weight"));
						} else {
							Logger.info("Enum is null");
						}

						listOfTamilBooks.add(book);
						Logger.info(listOfTamilBooks);
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Error while getting the book by lang name" + e.getMessage());
		}
		return listOfTamilBooks; 
	}
	

	/**
	 * Below the code for check the book id is Already exists in the DB
	 * 
	 * @param bookId
	 * @throws DAOException
	 * @throws SQLException
	 */

	public void CheckBookIdExist(int bookId) throws DAOException, SQLException {
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
	}
	
	
	
	
	

}
