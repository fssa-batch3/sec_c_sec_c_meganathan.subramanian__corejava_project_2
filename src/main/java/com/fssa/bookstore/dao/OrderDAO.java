package com.fssa.bookstore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fssa.bookstore.exception.DAOException;
import com.fssa.bookstore.logger.Logger;
import com.fssa.bookstore.model.Orders;
import com.fssa.bookstore.service.OrderService;

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
						order.setId(rs.getInt("id"));
						order.setBookImgUrl(rs.getString("imgUrl"));
						order.setBookName(rs.getString("name"));
						order.setPrice(rs.getDouble("price"));
						order.setAddress(rs.getString("address"));
						order.setCity(rs.getString("city"));
						order.setPincode(rs.getString("pincode"));
						order.setState(rs.getString("state"));
						ZoneId istZone = ZoneId.of("Asia/Kolkata"); // IST time zone
						ZonedDateTime istDateTime = ZonedDateTime.now(istZone);
						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy hh:mm:ss a");
						String formattedDateTime = istDateTime.format(formatter);

						order.setOrderDate(formattedDateTime);
						order.setQuantity(rs.getInt("quantity"));
						order.setStatus(rs.getBoolean("status"));
						myOrderByUserId.add(order);
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

	/**
	 * Below the code for update the users status
	 * 
	 * @param orderId
	 * @throws DAOException
	 */

	public void cancellOrderByOrderId(int orderId) throws DAOException {
		ConnectionUtil connectionUtil = new ConnectionUtil();

		try (Connection connection = connectionUtil.getConnection()) {
			String query = "UPDATE orders SET status=? WHERE status=1 AND id=?";
			try (PreparedStatement psmt = connection.prepareStatement(query)) {
				psmt.setBoolean(1, false);
				psmt.setInt(2, orderId);
				int rowsUpdated = psmt.executeUpdate();
				if (rowsUpdated > 0) {
					Logger.info("Order with ID " + orderId + " has been cancelled successfully.");
				} else {
					Logger.info("Order with ID " + orderId + " not found.");
				}
			} catch (SQLException e) {
				throw new DAOException("error while changing the order status" + e.getMessage());
			}

		} catch (SQLException e) {
			throw new DAOException("Error while getting the connection" + e.getMessage());
		}
	}

	/**
	 * Below the code for get the all orders list it the DB
	 * 
	 * @return
	 * @throws DAOException
	 */

	public List<Orders> getListOfOrders() throws DAOException {
		ConnectionUtil connectionUtil = new ConnectionUtil();
		List<Orders> orderList = new ArrayList<>();
		try (Connection connection = connectionUtil.getConnection()) {
			String query = "SELECT * FROM orders";
			try (PreparedStatement psmt = connection.prepareStatement(query)) {
				try (ResultSet rs = psmt.executeQuery()) {
					while (rs.next()) {
						Orders orders = new Orders();
						orders.setId(rs.getInt("id"));
						orders.setPrice(rs.getDouble("price"));
						orders.setAddress(rs.getString("address"));
						orders.setCity(rs.getString("city"));
						orders.setState(rs.getString("state"));
						orders.setBookImgUrl(rs.getString("imgUrl"));
						orders.setBookName(rs.getString("name"));
						orders.setUserId(rs.getInt("userId"));
						orders.setProductId(rs.getInt("productId"));
						orders.setQuantity(rs.getInt("quantity"));
						orders.setStatus(rs.getBoolean("status"));
						orders.setOrderDate(rs.getString("date"));
						orderList.add(orders);
					}
				} catch (SQLException e) {
					Logger.info(e.getMessage());
					e.printStackTrace();
					throw new DAOException("Error while getting information" + e.getMessage());

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			Logger.info(e.getMessage());
			throw new DAOException("Error while getting the connections" + e.getMessage());
		}
		return orderList;
	}

}
