package com.fssa.bookstore.validator;

import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.bookstore.dao.BookDao;
import com.fssa.bookstore.dao.UserDao;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.model.User;
import com.fssa.bookstore.validatorerrors.BookValidateErrors;
import com.fssa.bookstore.validatorerrors.UserValidatorsErrors;

/**
 * Below the code for validate the user
 * 
 * @author MeganathanSubramania
 */

public class UserValidator {

	/**
	 * below the code for validate the all methods
	 * 
	 * @param user
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validate(User user) throws IllegalArgumentException {
		if (user == null) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USEROBJ_NULL);
		}
		validateUserName(user.getName());
		validateEmail(user.getEmail());
		validatePassword(user.getPassword());
		validatePhoneNumber(user.getPhoneNumber());

		return true;
	}

	/**
	 * below the code for validate the user name
	 * 
	 * @param name
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validateUserName(String name) throws IllegalArgumentException {
		if (name == null) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_NAME_NULL);
		}
		// Below the code for Regex pattern
		String regx = "^\\w{5,20}$";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(name);
		boolean isMatch = matcher.matches();
		if ("".trim().equals(name) || name.trim().length() > 20 || name.trim().length() < 5 || !isMatch) {

			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_NAME);
		}

		return true;

	}

	/**
	 * Below the code for validate the user id
	 * 
	 * @param bookId
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validateUserId(int userId) throws IllegalArgumentException {
		if (userId <= 0) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_ID);
		}
		return true;
	}

	/**
	 * below the code for the check the user id is already exists or not
	 * 
	 * @param bookId 
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean checkUserIdExists(int userId) throws IllegalArgumentException {

		UserDao userDao = new UserDao();
		try {
			userDao.readUser(userId);
			return true;
		} catch (DAOException | SQLException e) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_ID);
		}

	}
	
	public boolean checkUserEmailExists(String email) throws IllegalArgumentException {

		UserDao userDao = new UserDao();
		try {
			userDao.emailExists(email);
			return true;
		} catch (DAOException | SQLException e) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_ID);
		}

	}

	/**
	 * Below the code for validate the phone number
	 * 
	 * @param phoneNumber
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean validatePhoneNumber(String phoneNumber) throws IllegalArgumentException {
		if (phoneNumber == null) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_PHONE_NUMBER);

		}

		String regex = "^[0-9]{10}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(phoneNumber) || !isMatch) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_PHONE_NUMBER);

		}
		return true;
	}

	/**
	 * below the code for validate the email
	 * 
	 * @param email
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean validateEmail(String email) throws IllegalArgumentException {
		if (email == null) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_EMAIL_NULL);
		}

		String regex = "^(?i)[a-z0-9.+-]{1,64}@[a-z0-9.-]{1,256}\\.[a-z]{2,6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(email) || !isMatch) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_EMAIL);
		}
		return true;

	}

	/**
	 * Below the code for validate the password
	 * 
	 * @param password
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validatePassword(String password) throws IllegalArgumentException {
		if (password == null) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_PASSWORD_NULL);
		}

		// Below the code for regex
		String regex = "^(?=.*[A-Z])(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,15}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(password);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(password) || !isMatch) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_PASSWORD);
		}

		return true;

	}

	/**
	 * below the code for validate the state
	 * 
	 * @param state
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validateState(String state) throws IllegalArgumentException {
		if (state == null) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_STATE_NULL);
		}

		// Below the code for REGEX
		String regex = "^[A-Za-z\\s-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(state);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(state) || state.trim().length() > 15 || state.trim().length() < 4 || !isMatch) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_STATE);
		}
		return true;
	}

	/**
	 * Below the code for validate the city
	 * 
	 * @param city
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validateCity(String city) throws IllegalArgumentException {
		if (city == null) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_CITY_NULL);
		}

		// Below the code for regex
		String regex = "^[A-Za-z\\s]+$|^$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(city);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(city) || city.trim().length() > 15 || city.trim().length() < 4 || !isMatch) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_CITY);
		}
		return true;
	}

	/**
	 * Below the code for validate the pincode
	 * 
	 * @param pincode
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validatePincode(String pincode) throws IllegalArgumentException {
		if (pincode == null) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_PINCODE);
		}

		// below the code for regex
		String regex = "^\\d{6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pincode);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(pincode) || pincode.trim().length() > 6 || !isMatch) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_PINCODE);
		}
		return true;
	}
	
	
	/**
	 * Below the code for validate the user address
	 * @param address
	 * @return
	 */
	
	public boolean validateAddress(String address) {
		if(address == null){
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_ADDRESS_NULL); 
		}
		
		String regex = "^[\\w\\s\\.,'/-]+,[\\w\\s\\.,'/-]+,[\\w\\s\\.,'/-]+,[\\w\\s\\.,'/-]+,[\\w\\s\\.,'/-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(address);
		boolean isMatch = matcher.matches();
		
		if(!isMatch || address.isEmpty() || address.trim().length() > 150 || address.trim().length() < 7 ) {
			throw new IllegalArgumentException(UserValidatorsErrors.INVALID_USER_ADDRESS);
		}
		return true;
	}

}
