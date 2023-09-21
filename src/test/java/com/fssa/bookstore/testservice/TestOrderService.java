package com.fssa.bookstore.testservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.fssa.bookstore.exception.ServiceException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.Orders;
import com.fssa.bookstore.service.OrderService;

class TestOrderService {

	
	
	// Below the code for create the new Orders test
		@Test
		void testCreateOrders() {  

			OrderService OrderService = new OrderService();
			Orders Orders = new Orders();
			// Set the value to all attributes
			try { 
			
				Orders.setBookName("attitude is everything");
				Orders.setBookImgUrl("https://m.media-amazon.com/images/I/71Rcjb+1yLL.jpg");
				Orders.setUserId(3);
				Orders.setProductId(1);
				Orders.setPrice(800.00);
				Orders.setPhoneNumber("8463546871");
				Orders.setCity("Chennai");
				Orders.setState("Tamil Nadu");
				Orders.setPincode("600021");
				Orders.setQuantity(1);
				Orders.setAddress("4/451, shanmuga sundharam street,  ranga nagar extension, old perungalathur, chennai - 63.");
				

				boolean success = OrderService.addOrder(Orders);
				Assertions.assertTrue(success);
				Logger.info("Orders Details Inserted Successfully");

			} catch (ServiceException ex) {
				Assertions.assertEquals("Object are null or empty or invalid" + ex.getMessage(), ex.getMessage());

			}

		}
}
