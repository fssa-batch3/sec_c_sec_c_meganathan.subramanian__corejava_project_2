package com.fssa.bookstore.service;

import java.sql.SQLException;

/**
 * below the code for write the service to all DAO
 * @author MeganathanSubramania
 * 
 */
import com.fssa.bookstore.dao.UserDao;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.exception.ServiceException;
import com.fssa.bookstore.model.User;
import com.fssa.bookstore.validator.UserValidator;

public class UserService {

	/**
	 * Below the code for create the new user
	 * 
	 * @param user
	 * @return
	 * @throws DAOException
	 * @throws ServiceException 
	 */
	public boolean addUser(User user) throws DAOException,SQLException, ServiceException{
		UserValidator userValidator = new UserValidator();
		UserDao userdao = new UserDao();
		try {
			userValidator.validate(user);
			userValidator.checkUserEmailExists(user.getEmail());
			userdao.createUser(user);
			return true;

		} catch (DAOException | SQLException ex) {
			throw new ServiceException(ex.getMessage());
		} 
	}
	
	/*
	 * Below the code for login to user 
	 * 
	 */ 
	
	public User loginUser(String email)throws  ServiceException{
		
		UserDao userDao = new UserDao();
		User user = new User();
		try {
			user = userDao.userLogin(email); 
			return user;
		}
		catch(DAOException e) {
			throw new ServiceException(e.getMessage());
		}
	}
	
	
	/**
	 * Below the code for read the user details from the database
	 * @param id
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public User readUser(int id)throws DAOException, SQLException{
		UserValidator userValidator = new UserValidator();
		UserDao userdao = new UserDao();
		User user = new User();
		try {
			userValidator.validateUserId(id);
			userValidator.checkUserIdExists(id);
			user =  userdao.readUser(id);
			return user;
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
	public boolean deleteUser(String email)throws DAOException , SQLException{
		UserDao userdao = new UserDao();
		UserValidator userValidator = new UserValidator();
		try {
			userValidator.validateEmail(email);
			userdao.deleteUser(email);
			return true;
		}
		catch(DAOException | SQLException ex) {
			throw new DAOException("Id invalid or empty" + ex.getMessage());
		}
	}
	
	
	
	public boolean updatePhoneNo(int id, String phoneNumber)throws ServiceException{
		UserDao userDao = new UserDao();
		UserValidator userValidator = new UserValidator();
		try {
			userValidator.validatePhoneNumber(phoneNumber);
			userDao.updateUserPhoneNo(id, phoneNumber);
			return true;
		}
		catch(DAOException | SQLException ex) {
			throw new ServiceException("Phone number or id are invalid" + ex.getMessage());
		}
	}
	
	
	/**
	 * Below the code for service layer update the user
	 * 
	 * @param id
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	
	public boolean updateUser(String email,User user)throws ServiceException{
		UserDao dao = new  UserDao();
		UserValidator userValidator = new UserValidator();
		try {
//			userValidator.validate(user);
			dao.updateuser(email,user);
			return true;
		}
		catch(DAOException | IllegalArgumentException e) {
			e.printStackTrace();
			throw new ServiceException(e.getMessage()); 
		}
	}
}
