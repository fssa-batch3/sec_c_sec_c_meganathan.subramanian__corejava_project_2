package com.fssa.book.validator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.book.ValidatorErrors.UserValidatorsErrors;

/**
 * Below the code for Test the all validator
 * 
 * @author MeganathanSubramania
 */

class TestUserValidator {

	// Below the code for test the username
	@Test
	void testValidUserName() {
		UserValidator uservalidator = new UserValidator();
		Assertions.assertTrue(uservalidator.validateUserName("dinesh"));
	}

	// Below the code for invalid user name
	@Test
	void testInvalidUserNameNull() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validateUserName(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_NAME_NULL, ex.getMessage());
		}
	}

	// below the code for test the invalid user name
	@Test
	void testInvalidUserNameEmptyString() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validateUserName("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_NAME, ex.getMessage());
		}
	}

	// Below the code for test the invalid
	@Test
	void testInvalidUserName() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validateUserName("kin");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_NAME, ex.getMessage());
		}

	}

	// Below the code for user phone number
	@Test
	void testValidUserPhoneNo() {
		UserValidator userValidator = new UserValidator();
		Assertions.assertTrue(userValidator.validatePhoneNumber("+918778719738"));
	}

	// Below the code for test the invalid phone number
	void testInvalidPhonenoNull() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validatePhoneNumber(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_PHONE_NUMBER, ex.getMessage());
		}
	}

	// Below the code for invalid phone number
	@Test
	void testInvalidPhoneNo() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validatePhoneNumber("+91987232372"); // given the 9 digits number
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_PHONE_NUMBER, ex.getMessage());
		}

	}

	// Below the code for valid user email
	@Test
	void testValidUserEmail() {
		UserValidator userValidator = new UserValidator();
		userValidator.validateEmail("Dinesh@gmail.com");
	}

	// Below the code for invalid email
	@Test
	void testInvalidUserEmail() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validateEmail("Dinesg.com");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_EMAIL, ex.getMessage());
		}
	}

	// Below the code for the null email
	@Test
	void testInvalidEmailNull() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validateEmail(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_EMAIL_NULL, ex.getMessage());
		}
	}

	// Below the code for test the invalid email empty 
	@Test
	void testInvalidUserEmailEmpty() {
		try { 
			UserValidator userValidator = new UserValidator();
			userValidator.validateEmail("");
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_EMAIL, ex.getMessage());
		}
		
	}
	
	// Below the code for test the valid password
	@Test
	void testValidUserPass() {
		UserValidator userValidator = new UserValidator();
		Assertions.assertTrue(userValidator.validatePassword("Dinesh@123"));
	}

}
