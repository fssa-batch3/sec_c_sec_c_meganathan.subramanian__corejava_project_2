package com.fssa.bookstore.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fssa.bookstore.constants.BookValidatorConstants;
import com.fssa.bookstore.model.Orders;
import com.fssa.bookstore.validatorerrors.BookValidateErrors;
import com.fssa.bookstore.validatorerrors.OrderValidatorsErrors;

/**
 * Below the code for validator Here i validate the all model
 * 
 * @author MeganathanSubramania
 * 
 */
public class OrderValidator {

	public boolean validateOrder(Orders orders) throws IllegalArgumentException {
		if (orders == null) {
			throw new IllegalArgumentException(OrderValidatorsErrors.ORDER_OBJ_NULL);
		}
		validateUserId(orders.getUserId());
		validateBookName(orders.getBookName());
		validateProductId(orders.getProductId());
		validateBookPrice(orders.getPrice());
		validateCity(orders.getCity());
		validatePincode(orders.getPincode());
		validateState(orders.getState());
		validateAddress(orders.getAddress());
		validateQty(orders.getQuantity());

		return true;

	}

	/**
	 * Below the code for validate the book Name.
	 *
	 * @param bookName
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validateBookName(String bookName) throws IllegalArgumentException {
		if (bookName == null) {
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_BOOK_NAME_NULL);
		}

		// Below the code for Regex pattern
		String regx = BookValidatorConstants.REGEX_NAMES;
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(bookName);
		boolean isMatch = matcher.matches();
		if ("".trim().equals(bookName) || bookName.trim().length() > BookValidatorConstants.FORTY
				|| bookName.trim().length() < BookValidatorConstants.THREE || !isMatch) {

			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_BOOK_NAME);
		}

		return true;
	}

	/**
	 * Below the code for i validate the user id
	 * 
	 * @param userId
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean validateUserId(int userId) throws IllegalArgumentException {
		if (userId <= 0) {
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_USER_ID);
		}
		return true;
	}

	/**
	 * I Below the code for i validate the order id
	 * 
	 * @param orderId
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean validateOrderrId(int orderId) throws IllegalArgumentException {
		if (orderId <= 0) {
			throw new IllegalArgumentException(OrderValidatorsErrors.INVAILD_ORDER_ID);
		}
		return true;
	}

	/**
	 * Below the code for i validate the product id
	 * 
	 * @param orderId
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean validateProductId(int productId) throws IllegalArgumentException {
		if (productId <= 0) {
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_PRODUCT_ID);
		}
		return true;
	}

	/**
	 * Below the code for validate the book price
	 *
	 * @param Price
	 * @return
	 * @throws IllegalArgumentException
	 */
	public boolean validateBookPrice(double price) throws IllegalArgumentException {
		if (price <= BookValidatorConstants.THREE_FIFTY || price > BookValidatorConstants.THOUSAND_THREE_HUNDRED) {
			throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_PRICE);
		}
		return true;
	}

	/**
	 * Below the code for validate the qty
	 * 
	 * @param qty
	 * @return
	 * @throws IllegalArgumentException
	 */

	public boolean validateQty(int qty) throws IllegalArgumentException {
		if (qty <= 0 || qty > 10) {
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_QTY);
		}
		return true;
	}

	/**
	 * Below the code for validate the user address
	 * 
	 * @param address
	 * @return
	 */

	public boolean validateAddress(String address) {
		if (address == null) {
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_USER_ADDRESS_NULL);
		}

		String regex = "^[\\w\\s\\.,'/-]+,[\\w\\s\\.,'/-]+,[\\w\\s\\.,'/-]+,[\\w\\s\\.,'/-]+,[\\w\\s\\.,'/-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(address);
		boolean isMatch = matcher.matches();

		if (!isMatch || address.isEmpty() || address.trim().length() > 150 || address.trim().length() < 7) {
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_USER_ADDRESS);
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
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_USER_STATE_NULL);
		}

		// Below the code for REGEX
		String regex = "^[A-Za-z\\s-]+$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(state);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(state) || state.trim().length() > 15 || state.trim().length() < 4 || !isMatch) {
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_USER_STATE);
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
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_USER_CITY_NULL);
		}

		// Below the code for regex
		String regex = "^[A-Za-z\\s]+$|^$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(city);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(city) || city.trim().length() > 15 || city.trim().length() < 4 || !isMatch) {
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_USER_CITY);
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
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_USER_PINCODE);
		}

		// below the code for regex
		String regex = "^\\d{6}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(pincode);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(pincode) || pincode.trim().length() > 6 || !isMatch) {
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_USER_PINCODE);
		}
		return true;
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
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_USER_PHONE_NUMBER);

		}

		String regex = "^[0-9]{10}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(phoneNumber);
		boolean isMatch = matcher.matches();

		if ("".trim().equals(phoneNumber) || !isMatch) {
			throw new IllegalArgumentException(OrderValidatorsErrors.INVALID_USER_PHONE_NUMBER);

		}
		return true;
	}

}
