package com.fssa.bookstore.model;

import java.time.LocalDate;

public class Orders {

	private int id;
	private int userId;
	private int productId;
	private String bookName;
	private String bookImgUrl;
	private double price;
	private String phoneNumber;
	private String address;
	private String pincode;
	private String city;
	private String state;
	private int quantity;
	private LocalDate orderDate;

	// Below the code for create the getters setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookImgUrl() {
		return bookImgUrl;
	}

	public void setBookImgUrl(String bookImgUrl) {
		this.bookImgUrl = bookImgUrl;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}



	// Below the code for to string method
	@Override
	public String toString() {
		return "Orders [id=" + id + ", userId=" + userId + ", productId=" + productId + ", bookName=" + bookName
				+ ", bookImgUrl=" + bookImgUrl + ", price=" + price + ", phoneNumber=" + phoneNumber + ", address="
				+ address + ", pincode=" + pincode + ", city=" + city + ", state=" + state + ", quantity=" + quantity
				+ ", orderDate=" + orderDate + "]";
	}
	

}
