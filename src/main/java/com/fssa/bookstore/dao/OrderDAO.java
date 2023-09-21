package com.fssa.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.fssa.bookstore.enums.BookBinding;
import com.fssa.bookstore.enums.BookReturnable;
import com.fssa.bookstore.enums.Categories;
import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.Book;
import com.fssa.bookstore.model.Orders;
import com.mysql.cj.x.protobuf.MysqlxCrud.Order;

public class OrderDAO {

	/**
	 * Below the code for placed the new order
	 * 
	 * @param order
	 * @return
	 * @throws DAOException
	 * @throws SQLException
	 */
	public boolean addOrder(Orders order) throws DAOException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		try (Connection connection = connectionUtil.getConnection()) {
			String insertQuery = "INSERT INTO orders (userId, productId, name , imgUrl, price, address, pincode, city, state, quantity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			try (PreparedStatement psmt = connection.prepareStatement(insertQuery)) {

				psmt.setInt(1, order.getUserId());
				psmt.setInt(2, order.getProductId());
				psmt.setString(3, order.getBookName());
				psmt.setString(4, order.getBookImgUrl());
				psmt.setDouble(5, order.getPrice());
				psmt.setString(6, order.getAddress());
				psmt.setString(7, order.getPincode());
				psmt.setString(8, order.getCity());
				psmt.setString(9, order.getState());
				psmt.setInt(10, order.getQuantity());

				psmt.executeUpdate();
				return true;

			} catch (SQLException ex) {
				throw new DAOException("Email is already Registerd " + ex.getMessage());
			}
		} catch (SQLException ex) {
			throw new DAOException("error while getting connections " + ex.getMessage());
		}

	}

	public List<Orders> ordersByUserId(int userId) throws DAOException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<Orders> myOrderByUserId = new ArrayList<>();

		try (Connection connection = connectionUtil.getConnection()) {
			String readQuery = "SELECT * FROM orders WHERE userId = ?";
			try (PreparedStatement psmt = connection.prepareStatement(readQuery)) {
				psmt.setInt(1, userId);
				try (ResultSet rs = psmt.executeQuery()) {
					while (rs.next()) {

						Orders order = new Orders();

						order.setBookImgUrl(rs.getString("imgUrl"));
						order.setBookName(rs.getString("name"));
						order.setPrice(rs.getDouble("price"));
						order.setAddress(rs.getString("address"));
						order.setCity(rs.getString("city"));
						order.setPincode(rs.getString("pincode"));
						order.setState(rs.getString("state"));
						order.setOrderDate(rs.getDate("orderDate").toLocalDate());
						order.setQuantity(rs.getInt("quantity"));
					}

				} catch (SQLException e) {
					throw new DAOException("Error while getting the book by catgy name" + e.getMessage());
				}
			}
		} catch (DAOException | SQLException e) {
			throw new DAOException("error while getting conection" + e.getMessage());
		}
		return myOrderByUserId;
	}

}
