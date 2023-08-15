package com.fssa.bookstore.model;

/**
 * Below the code for add the attributes for user details
 * 
 * @author MeganathanSubramania
 */

public class User {

	// Attributes
	private int id;
	private String name;
	private String phoneNumber;
	private String email;
	private String password;
	private String state;
	private String city;
	private String pincode;

	// Default constructor
	public User() {

	}

	// Constructor
	public User(String name, String phoneNumber, String email, String password, String state, String city,
			String pincode, int id) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.id = id;
	}

	// Code for getter and setters
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	// Below the code for to string method
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", password="
				+ password + ", state=" + state + ", city=" + city + ", pincode=" + pincode + "]";
	}

}
