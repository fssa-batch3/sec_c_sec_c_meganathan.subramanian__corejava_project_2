package com.fssa.bookstore.testvalidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.fssa.bookstore.model.User;
import com.fssa.bookstore.validator.UserValidator;
import com.fssa.bookstore.validatorerrors.UserValidatorsErrors;

/**
 * Below the code for Test the all Validators
 * 
 * @author MeganathanSubramania
 */

class TestUserValidator { 

	// Below the code for test the User name
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
	
	// Below the code for invalid test case for password

	@Test
	void testInvalidUserPass() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validatePassword("Dinesh1233");
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_PASSWORD, ex.getMessage());
		}
	}
	
	// Below the code for null check the password
	@Test
	void testInvalidUserPassNull() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validatePassword(null);
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_PASSWORD_NULL, ex.getMessage());
		}
	}
	
	// Below the code for check the empty string in password
	@Test
	void testInvalidUserPassEmptyStr() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validatePassword("");
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_PASSWORD, ex.getMessage());
		}
	}
	
	// Below the code for test the city
	@Test
	void testValidUserCity() {
		UserValidator userValidator = new UserValidator();
		Assertions.assertTrue(userValidator.validateCity("Chennai"));
	
	}
	
	 // Below the  code for test the Invalid test case
	@Test
	void testInvalidUserCity() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validateCity("Chenai12");
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_CITY, ex.getMessage());
		}
		
	}
	
	// Below the code test the invalid test case for city 
	@Test
	void testInvalidUserCityNull() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validateCity(null);
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_CITY_NULL, ex.getMessage());
		}
	}
	
	
	// Below the code for test the invalid for city
	@Test
	void testEmptyStrUsercity() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validateCity("");
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_CITY, ex.getMessage());
		}
	}
	
	// Below the code for test the valid state
	@Test
	void testValidUserState() {
		UserValidator userValidator = new UserValidator();
		userValidator.validateState("Tamil Nadu");
	}
	
	// Below the code for test the invalid state name
	@Test
	void testInvalidUserstate() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validateState("UNO");
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_STATE, ex.getMessage());
		}
	}
	
	// Below the code for null check
	@Test
	void testInvalidUserStateNull() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validateState(null);
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_STATE_NULL, ex.getMessage());
		}
	}
	
	// below the code for empty string in state
	@Test
	void testUserStateEmptyStr() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validateState("");
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_STATE, ex.getMessage());
		}
	}
	
	// Below the code for test the user Pincode
	@Test
	void testValidUserPincode() {
		UserValidator userValidator = new UserValidator();
		Assertions.assertTrue(userValidator.validatePincode("600081"));
	}
	
	// Below the code for test the invalid user pincode
	@Test
	void testInvalidUserPincode() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validatePincode("12356113");
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_PINCODE, ex.getMessage());
		}
		
	}
	
	// Below the code for invalid user Pincode 
	@Test
	void testInvalidUserPincodeEmptyStr() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validatePincode("");
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_PINCODE, ex.getMessage());
		}
	}
	
	// Below the code for invalid user pincode
	@Test
	void testInvalidUserPincodeNull() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validatePincode(null);
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USER_PINCODE, ex.getMessage());
		}
	}
	
	// Below the code for check the user obj
	@Test
	void testValidUserObj() {
		User validUser  = new User();
		UserValidator userValidator = new UserValidator();
		validUser.setName("Dinesh");
		validUser.setPassword("Dinesh@123");
		validUser.setEmail("Dinesh@gmail.com");
		validUser.setPhoneNumber("+918778719738");
		validUser.setCity("Chennai");
		validUser.setState("Tamil Nadu");
		validUser.setPincode("600081");
		Assertions.assertTrue(userValidator.validate(validUser));
		
	} 
	
	// below the code for check the user obj null or empty
	@Test
	void testInvalidUserObjNull() {
		try {
			UserValidator userValidator = new UserValidator();
			userValidator.validate(null);
		}
		catch(IllegalArgumentException ex) {
			Assertions.assertEquals(UserValidatorsErrors.INVALID_USEROBJ_NULL, ex.getMessage());
		}
	}
	
}
