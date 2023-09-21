package com.fssa.bookstore.service;

import java.util.List;

import com.fssa.bookstore.dao.OrderDAO;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.exception.ServiceException;
import com.fssa.bookstore.model.Orders;
import com.fssa.bookstore.validator.OrderValidator;

public class OrderService {

	/**
	 * Below the code for create the new user
	 * 
	 * @param user
	 * @return
	 * @throws DAOException
	 * @throws ServiceException 
	 */
	public boolean addOrder(Orders orders) throws ServiceException{
		OrderValidator orderValidator = new OrderValidator();
		OrderDAO orderDAO = new OrderDAO();
		try {
			orderValidator.validateOrder(orders);
			orderDAO.addOrder(orders);
			return true;

		} catch (DAOException ex) {
			throw new ServiceException(ex.getMessage());
		} 
	}
	
	public List<Orders> ordersByUserId(int userId)throws ServiceException{
		
		OrderValidator orderValidator = new OrderValidator();
		OrderDAO orderDAO = new OrderDAO();
		List<Orders> myOrder;
		try {
			orderValidator.validateUserId(userId);
			myOrder = orderDAO.ordersByUserId(userId);
		} catch(DAOException ex) {
			throw new ServiceException(ex.getMessage());
			
		}
		return myOrder;
	}
	
}
