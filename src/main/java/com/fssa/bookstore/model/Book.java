package com.fssa.bookstore.model;


import com.fssa.bookstore.enums.Categories;

/**
 * Below the code for add the attribute and write the getter and setter
 *
 * @author MeganathanSubramania
 */

public class Book {
	private int bookId;
	private String bookName;
	private double bookPrice;
	private Categories bookCategories; 
	private String bookImageUrl;
	private String booklanguage;
	private int quantity;
	private String author;
	private String bookDescription;

	@Override
	public String toString() {
		return "Book [\n" + "bookId=" + bookId + "\n" + "bookName=" + bookName + "\n" + "bookPrice=" + bookPrice + "\n"
				+ "bookCategories=" + bookCategories + "\n" + "bookImage=" + bookImageUrl + "\n" + "booklanguage="
				+ booklanguage + "\n" + "quantity=" + quantity + "\n" + "author=" + author + "\n" + "bookDescription="
				+ bookDescription + "\n" + "]";
	}

	// Default constructor
	public Book() {

	}

	// parameterized constructor
	public Book(int bookId, String bookName, double bookPrice, Categories bookCategories, String bookImageUrl,
			String booklanguage, int quantity) {

		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.bookCategories = bookCategories;
		this.bookImageUrl = bookImageUrl;
		this.booklanguage = booklanguage;
		this.quantity = quantity;

	}

	public Book(String bookDescription, String author) {
		this.bookDescription = bookDescription;
		this.author = author;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public double getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(double bookPrice) {
		this.bookPrice = bookPrice;
	}

	public Categories getbookCategories() {
		return bookCategories;
	}

	public void setbookCategories(Categories bookCategories) {
		this.bookCategories = bookCategories;
	}

	public String getBookImageUrl() {
		return bookImageUrl;
	}

	public void setBookImageUrl(String bookImage) {
		this.bookImageUrl = bookImage;
	}

	public String getBooklanguage() {
		return booklanguage;
	}

	public void setBooklanguage(String booklanguage) {
		this.booklanguage = booklanguage;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBookDescription() {
		return bookDescription;
	}

	public void setBookDescription(String bookDescription) {
		this.bookDescription = bookDescription;
	}

}