package com.fssa.bookstore.dao;

/**
 * Below the code for write the query for CRUD To DB
 * @author MeganathanSubramania
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.User;

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
			String insertQuery = "INSERT INTO users (name, phoneNumber, email, password) VALUES (?,?,?,?)";
			try (PreparedStatement psmt = connection.prepareStatement(insertQuery)) {

				psmt.setString(1, user.getName());
				psmt.setString(2, user.getPhoneNumber());
				psmt.setString(3, user.getEmail());
				psmt.setString(4, user.getPassword());

				psmt.executeUpdate();
				return true;

			} catch (SQLException ex) {
				throw new DAOException("Error while adding the users Details :	" + ex.getMessage());
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
	public boolean userLogin(String emailId, String password) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
	    try (Connection connection = connectionUtil.getConnection()) {
	        if (emailExists(emailId, connection)) {
	            String selectQuery = "SELECT COUNT(*) FROM users WHERE email = ? AND password = ?";
	            try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
	                psmt.setString(1, emailId);
	                psmt.setString(2, password);

	                try (ResultSet rs = psmt.executeQuery()) { 
	                    if (rs.next()) {
	                        int count = rs.getInt(1);
	                        if (count > 0) {
	                            return true;
	                        } else {
	                            throw new DAOException("Incorrect Password");
	                        }
	                    }
	                }
	            }
	        } else {
	            throw new DAOException("Invalid Email Id");
	        }
	    }
	    return false;
	}
	
	
	/**
	 * Below the code for already check in the DB
	 * @param emailId
	 * @param connection
	 * @return
	 * @throws DAOException
	 * @throws SQLException 
	 */

	private boolean emailExists(String email, Connection connection) throws DAOException {
        String selectQuery = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (PreparedStatement psmt = connection.prepareStatement(selectQuery)) {
            psmt.setString(1, email);
            try (ResultSet rs = psmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Given mail id is not regsiter " + e.getMessage());
        }
        return false;
    }
	
	
	/**
	 * Below the code for read the user obj to mysql
	 * 
	 * @param bookId
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public boolean readUser(int id) throws DAOException, SQLException {
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
						user.setPassword(rs.getString("password"));;
						Logger.info(user);
						return true;

					} else {
						Logger.info("Id Doesn't Exists in Database");
						return false;// This will return the null to user obj
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
	public void deleteUser(int id) throws DAOException, SQLException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String getId = GET_ID;
			try (PreparedStatement psmt = connection.prepareStatement(getId)) {
				psmt.setInt(1, id);
				try (ResultSet rs = psmt.executeQuery()) {
					if (!rs.next()) {
						throw new DAOException("Given id doesn't exists");
					}
				}
			} catch (SQLException ex) {
				throw new DAOException("Error while getting the id" + ex.getMessage());
			}
		}

		// Below the code for delete the row using id
		try (Connection connection = connectionUtil.getConnection()) {
			String deleteQuery = "UPDATE users SET is_active = 0 WHERE is_active = 1 AND id = ?";
			try (PreparedStatement psmt = connection.prepareStatement(deleteQuery)) {
				psmt.setInt(1, id);
				int rowAffected = psmt.executeUpdate();
				if (rowAffected > 0) {
					Logger.info("Deleted the row Sucessfully " + id);

				} else {
					Logger.info("Error while deleting the row");

				}
			}
		}

		// Below the code for update the primary key by order
		try (Connection connection = connectionUtil.getConnection()) {
			String updateQuery = "SET @new_id = 0";
			try (Statement updateStatement = connection.createStatement()) {
				updateStatement.executeUpdate(updateQuery);
			}
			updateQuery = "UPDATE users SET Id = (@new_id := @new_id + 1) ORDER BY Id";
			try (Statement updateStatement = connection.createStatement()) {
				updateStatement.executeUpdate(updateQuery);
				Logger.info("Primary key values updated.");
			}
		} catch (SQLException ex) {
			throw new DAOException("Error while updating the primary key: " + ex.getMessage());
		}

	}
	

	/**
	 * Below the  code for update the user phone number.
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
			String updateQuery = "UPDATE users set phoneNumber= ? WHERE Id = ?";
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

}
