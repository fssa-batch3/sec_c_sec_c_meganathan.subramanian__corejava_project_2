package com.fssa.bookstore.dao;

/**
 * Below the code for write the query for CRUD To DB
 * @author MeganathanSubramania
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.User;
import com.fssa.bookstore.utils.PasswordUtil;

public class UserDao {

	public static final String GET_ID = "SELECT * FROM users WHERE Id = ?";

	/**
	 * Below the code for add the new user
	 * 
	 * @param user
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public boolean createUser(User user) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String insertQuery = "INSERT INTO users (name, phoneNumber, email, password,state,city,pincode,address) VALUES (?,?,?,?,?,?,?,?)";
			try (PreparedStatement psmt = connection.prepareStatement(insertQuery)) {
				
				psmt.setString(1, user.getName());
				psmt.setString(2, user.getPhoneNumber());
				psmt.setString(3, user.getEmail());
				psmt.setString(4, user.getPassword());
				psmt.setString(5, user.getState());
				psmt.setString(6, user.getCity());
				psmt.setString(7, user.getPincode());
				psmt.setString(8, user.getAddress());

				psmt.executeUpdate();
				return true;

			} catch (SQLException ex) {
				throw new DAOException("Email is already Registerd " + ex.getMessage());
			}
		}

	}

	/**
	 * This method belongs to the login to the user
	 * 
	 * @param email
	 * @param password
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public User userLogin(String emailId) throws DAOException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String selectQuery = "SELECT id, name,phoneNumber, email, password,state,city,pincode,address, isActive FROM users WHERE isActive = 1 AND email = ?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, emailId);
				Logger.info(emailId);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setPhoneNumber(rs.getString("phoneNumber"));
						user.setEmail(rs.getString("email"));
						user.setPassword(rs.getString("password"));
						user.setState(rs.getString("state"));
						user.setCity(rs.getString("city"));
						user.setPincode(rs.getString("pincode"));
						user.setAddress(rs.getString("address"));
						user.setActive(rs.getBoolean("isActive"));
						Logger.info(user);
						return user;

					} else {
						throw new DAOException("Invalid Credentials");
					}
				}
			}
		} catch (SQLException e) {
			throw new DAOException("Database Connection Error: " + e.getMessage());
		}
	}

	/**
	 * Below the code for already check in the DB
	 * 
	 * @param emailId
	 * @param connection
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */

	public boolean emailExists(String email) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String selectQuery = "SELECT COUNT(*) FROM users WHERE email = ?";
			try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
				psmt.setString(1, email);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						return rs.getInt(1) > 0;

					} else {
						throw new DAOException("Mail-id is already regsiterd ");
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DAOException("Given mail id is not regsiter " + e.getMessage());
			}
		}

	}

	/**
	 * Below the code for read the user obj to mysql
	 * 
	 * @param bookId
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public User readUser(int id) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String readQuery = GET_ID;
			try (PreparedStatement psmt = connection.prepareStatement(readQuery)) {
				psmt.setInt(1, id);
				try (ResultSet rs = psmt.executeQuery()) {
					if (rs.next()) {
						User user = new User();
						user.setId(rs.getInt("id"));
						user.setName(rs.getString("name"));
						user.setEmail(rs.getString("email"));
						user.setPassword(rs.getString("password"));
						;
						Logger.info(user);
						return user;

					} else {
						Logger.info("Id Doesn't Exists in Database");
						return null;// This will return the null to user obj
					}
				} catch (SQLException ex) {
					throw new DAOException("Error while reading the user " + ex.getMessage());
				}
			}
		}

	}

	/**
	 * Below the code for delete the user
	 * 
	 * @param id
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public void deleteUser(String email) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		// Below the code for delete the row using id
		try (Connection connection = connectionUtil.getConnection()) {
			String deleteQuery = "UPDATE users SET isActive = 0 WHERE email = ?";
			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {
				psmt.setString(1, email);
				int rowAffected = psmt.executeUpdate();
				if (rowAffected > 0) {
					Logger.info("Deleted the row Sucessfully " + email);

				} else {
					Logger.info("Error while deleting the row");

				}
			}
		}
	}

	/**
	 * Below the code for update the user phone number.
	 * 
	 * @param id
	 * @param phoneNumber
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public boolean updateUserPhoneNo(int id, String phoneNumber) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String getId = GET_ID;
			try (PreparedStatement psmt = connection.prepareStatement(getId)) {
				psmt.setInt(1, id);
				try (ResultSet rs = psmt.executeQuery()) {
					if (!rs.next()) {
						throw new DAOException("Given Does not exists");
					}
				}
			} catch (DAOException | SQLException ex) {
				throw new DAOException("Error while finding the Id" + ex.getMessage());
			}
		}

		// below the code for update the user
		try (Connection connection = connectionUtil.getConnection()) {
			String updateQuery = "UPDATE users set phoneNumber= ? WHERE id = ?";
			try (PreparedStatement psmt = connection.prepareStatement(updateQuery)) {
				psmt.setString(1, phoneNumber);
				psmt.setInt(2, id);
				int rowAffected = psmt.executeUpdate();
				if (rowAffected > 0) {
					Logger.info("User phone Number Updated Sucessfully");
					return true;
				} else {
					Logger.info("User Phone Number Updation Fails");
					return false; // if false this will return to the method
				}
			}
		}
	}
	
	
	/**
	 * Below the code for validate the update user all the details
	 * @param userId
	 * @param user
	 * @return
	 * @throws DAOException
	 */

	public boolean updateuser(String email,User user) throws DAOException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String getUserQuery = "UPDATE users SET name =?, phoneNumber =? ,state =? , city =? , pincode =? ,address =? WHERE email = ? AND isActive = 1";
			try(PreparedStatement psmt = connection.prepareStatement(getUserQuery)){
				psmt.setString(1, user.getName());
				psmt.setString(2, user.getPhoneNumber());
				psmt.setString(3, user.getState());
				psmt.setString(4, user.getCity());
				psmt.setString(5, user.getPincode());
				psmt.setString(6, user.getAddress());
				psmt.setString(7, email);

				int rowAffected = psmt.executeUpdate();
				Logger.info(user);
				
				if(rowAffected > 0) {
					Logger.info("Success updated");
					return true;
				}
				else {
					Logger.info("error while update the row");
					
				}
			}
		}
		catch(SQLException e) {
			throw new DAOException("Error while getting the connection " + e.getMessage());
		}
		return false;
	}

}
