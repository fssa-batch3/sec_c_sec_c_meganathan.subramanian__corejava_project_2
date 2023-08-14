package com.fssa.book.model;

/**
 * Below the code for add the attributes for user details
 * 
 * @author MeganathanSubramania
 */

public class User {

	// Attributes
	
	private String name;
	private String phoneNumber;
	private String email; 
	private String password;

	// Constructor
	public User(String name, String phoneNumber, String email, String password) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.password = password;
	}

	// Getters and Setters
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

	// Below the code for toString Method
	@Override
	public String toString() {
		return "User [name=" + name + ", phoneNumber=" + phoneNumber + ", email=" + email + ", password=" + password
				+ "]";
	}

}
