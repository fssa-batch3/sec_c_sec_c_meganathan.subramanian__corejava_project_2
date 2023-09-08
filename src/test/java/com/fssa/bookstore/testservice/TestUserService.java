package com.fssa.bookstore.testservice;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.SQLException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.exception.ServiceException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.User;
import com.fssa.bookstore.service.UserService;

/**
 * Below the code for test all the all service layer give the input
 */
class TestUserService {

	// Below the code for create the new user test
	@Test
	void testCreateUser() {

		UserService userservice = new UserService();
		User user = new User();
		// Set the value to all attributes
		try { 
			user.setName("Vickey");
			user.setEmail("Vickey@gmail.com");
			user.setPassword("Saran@123");
			user.setPhoneNumber("8463546871");
			user.setCity("Chennai");
			user.setState("Tamil Nadu");
			user.setPincode("600021");

			boolean success = userservice.addUser(user);
			Assertions.assertTrue(success);
			Logger.info("User Details Inserted Successfully");

		} catch (DAOException | SQLException | ServiceException ex) {
			Assertions.assertEquals("Object are null or empty or invalid" + ex.getMessage(), ex.getMessage());

		}

	}

	// Below the code for read from the table
	@Test
	void testReadUser() {
		User user = new User();
		UserService userservice = new UserService();
		user.setId(1);
		assertDoesNotThrow(() -> userservice.readUser(user.getId()));

	}

	// Below the code for delete the user
	@Test
	void testDeleteUser() {
		User user = new User();
		UserService userservice = new UserService();
		user.setId(1);
		assertDoesNotThrow(() -> userservice.deleteUser(user.getId()));

	}

	// Below the code update the User phone number
	@Test
	void testUpdateUserPhoneNo() {
		User user = new User();
		UserService userservice = new UserService();
		user.setId(1);
		user.setPhoneNumber("9092063763");
		assertDoesNotThrow(() -> userservice.updatePhoneNo(user.getId(), user.getPhoneNumber()));
	}

}
