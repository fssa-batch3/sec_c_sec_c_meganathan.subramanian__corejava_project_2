package com.fssa.bookstore.testvalidator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bookstore.validator.OrderValidator;
import com.fssa.bookstore.validatorerrors.OrderValidatorsErrors;

 class TestOrderValidator {

	
		@Test
		void testValidUserId() {
			OrderValidator OrderValidator = new OrderValidator();
			Assertions.assertTrue(OrderValidator.validateUserId(1));
		}
		
		@Test
		void testValidProductId() {
			OrderValidator OrderValidator = new OrderValidator();
			Assertions.assertTrue(OrderValidator.validateUserId(1));
		}

		
		@Test
		void testValidOrderrId() {
			OrderValidator OrderValidator = new OrderValidator();
			Assertions.assertTrue(OrderValidator.validateUserId(1));
		}


	// Below the code for user phone number
	@Test
	void testValidUserPhoneNo() {
		OrderValidator OrderValidator = new OrderValidator();
		Assertions.assertTrue(OrderValidator.validatePhoneNumber("8778719738"));
	}

	// Below the code for test the invalid phone number
	void testInvalidPhonenoNull() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validatePhoneNumber(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_PHONE_NUMBER, ex.getMessage());
		}
	}

	// Below the code for invalid phone number
	@Test
	void testInvalidPhoneNo() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validatePhoneNumber("+91987232372"); // given the 9 digits number
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_PHONE_NUMBER, ex.getMessage());
		}

	}


	// Below the code for test the city
	@Test
	void testValidUserCity() {
		OrderValidator OrderValidator = new OrderValidator();
		Assertions.assertTrue(OrderValidator.validateCity("Chennai"));

	}

	// Below the code for test the Invalid test case
	@Test
	void testInvalidUserCity() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validateCity("Chenai12");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_CITY, ex.getMessage());
		}

	}

	// Below the code test the invalid test case for city
	@Test
	void testInvalidUserCityNull() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validateCity(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_CITY_NULL, ex.getMessage());
		}
	}

	// Below the code for test the invalid for city
	@Test
	void testEmptyStrUsercity() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validateCity("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_CITY, ex.getMessage());
		}
	}

	// Below the code for test the valid state
	@Test
	void testValidUserState() {
		OrderValidator OrderValidator = new OrderValidator();
		OrderValidator.validateState("Tamil Nadu");
	}

	// Below the code for test the invalid state name
	@Test
	void testInvalidUserstate() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validateState("UNO");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_STATE, ex.getMessage());
		}
	}

	// Below the code for null check
	@Test
	void testInvalidUserStateNull() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validateState(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_STATE_NULL, ex.getMessage());
		}
	}

	// below the code for empty string in state
	@Test
	void testUserStateEmptyStr() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validateState("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_STATE, ex.getMessage());
		}
	}

	// Below the code for test the user Pincode
	@Test
	void testValidUserPincode() {
		OrderValidator OrderValidator = new OrderValidator();
		Assertions.assertTrue(OrderValidator.validatePincode("600081"));
	}

	// Below the code for test the invalid user pincode
	@Test
	void testInvalidUserPincode() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validatePincode("12356113");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_PINCODE, ex.getMessage());
		}

	}

	// Below the code for invalid user Pincode
	@Test
	void testInvalidUserPincodeEmptyStr() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validatePincode("");
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_PINCODE, ex.getMessage());
		}
	}

	// Below the code for invalid user pincode
	@Test
	void testInvalidUserPincodeNull() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validatePincode(null);
		} catch (IllegalArgumentException ex) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_PINCODE, ex.getMessage());
		}
	}

	// Below the code for test the user address
	@Test
	void testValidAddress() {

		OrderValidator OrderValidator = new OrderValidator();
		Assertions.assertTrue(OrderValidator.validateAddress("4/451, shanmuga sundharam street,  ranga nagar extension, old perungalathur, chennai - 63."));

	}
	
	//Below the code test the inavalid
	@Test
	void testInvalidAddressNull() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validateAddress(null);
		}
		catch(IllegalArgumentException e) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_ADDRESS_NULL, e.getMessage());
		}
	}
	
	// Below the code for check the empty
	@Test 
	void testInvalidAddressEmty() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validateAddress("");
		}
		catch(IllegalArgumentException e) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_ADDRESS, e.getMessage());
		}
	}
	
	// Below the code for check the wrong inpt to users
	@Test
	void testInvalidAddress() {
		try {
			OrderValidator OrderValidator = new OrderValidator();
			OrderValidator.validateAddress("7838789/fdiudfuiudffhjkdhfkdjkfh,");
		}
		catch(IllegalArgumentException e) {
			Assertions.assertEquals(OrderValidatorsErrors.INVALID_USER_ADDRESS, e.getMessage());
		}
	}
	
}
