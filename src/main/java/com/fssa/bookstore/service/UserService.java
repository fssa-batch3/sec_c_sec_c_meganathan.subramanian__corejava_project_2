package com.fssa.bookstore.service;

import java.sql.SQLException;

/**
 * below the code for write the service to all DAO
 * @author MeganathanSubramania
 * 
 */
import com.fssa.bookstore.dao.UserDao;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.model.User;
import com.fssa.bookstore.validator.UserValidator;

public class UserService {

	/**
	 * Below the code for create the new user
	 * 
	 * @param user
	 * @return
	 * @throws DAOException
	 */
	public boolean addUser(User user) throws DAOException,SQLException{
		UserValidator userValidator = new UserValidator();
		UserDao userdao = new UserDao();
		try {
			userValidator.validate(user);
			userdao.createUser(user);
			return true;

		} catch (DAOException | SQLException ex) {
			throw new DAOException("Object are null or empty or invalid" + ex.getMessage());
		} 
	}
	
	
	/**
	 * Below the code for read the user details from the database
	 * @param id
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public boolean readUser(int id)throws DAOException, SQLException{
		UserDao userdao = new UserDao();
		try {
			userdao.readUser(id);
			return true;
		}
		catch(DAOException | SQLException ex) { 
			throw new DAOException("Error while finding the id" + ex.getMessage());
		}
	}
	
	
	 /** 
	  *  Below the code for delete the user
	  * @param id
	  * @return true or false
	  * @throws DAOException
	  * @throws SQLException
	  */
	public boolean deleteUser(int id)throws DAOException , SQLException{
		UserDao userdao = new UserDao();
		try {
			userdao.deleteUser(id);
			return true;
		}
		catch(DAOException | SQLException ex) {
			throw new DAOException("Id invalid or empty" + ex.getMessage());
		}
	}
	
	
	
	public boolean updatePhoneNo(int id, String phoneNumber)throws DAOException,SQLException{
		UserDao userDao = new UserDao();
		UserValidator userValidator = new UserValidator();
		try {
			userValidator.validatePhoneNumber(phoneNumber);
			userDao.updateUserPhoneNo(id, phoneNumber);
			return true;
		}
		catch(DAOException | SQLException ex) {
			throw new DAOException("Phone number or id are invalid" + ex.getMessage());
		}
	}
}
