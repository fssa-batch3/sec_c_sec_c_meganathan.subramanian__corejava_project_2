package com.fssa.bookstore.model;

/**
 * Below the code for add the attribute and write the getter and setter
 *
 * @author MeganathanSubramania
 */

public class Book {
	private int bookId;
	private String bookName;
	private int bookPrice;
	private String BookCategories;
	private String bookImage;
	private String booklanguage;
	private int quantity;
	private String author;
	private String bookDescription; 
	private String bookFilter;
	
@Override
public String toString() {
    return "Book [\n"
            + "bookId=" + bookId + "\n"
            + "bookName=" + bookName + "\n"
            + "bookPrice=" + bookPrice + "\n"
            + "bookCategories=" + BookCategories + "\n"
            + "bookImage=" + bookImage + "\n"
            + "booklanguage=" + booklanguage + "\n"
            + "quantity=" + quantity + "\n"
            + "author=" + author + "\n"
            + "bookDescription=" + bookDescription + "\n"
            + "bookFilter=" + bookFilter + "\n"
            + "]";
}

	//	 Default constructor 
	public Book() {
		
	}
	
	// parameterized constructor 
	public Book(int bookId, String bookName, int bookPrice, String BookCategories, String bookImage,
			String booklanguage, int quantity, String author, String bookDescription, String bookFilter) {
	
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookPrice = bookPrice;
		this.BookCategories = BookCategories;
		this.bookImage = bookImage;
		this.booklanguage = booklanguage;
		this.quantity = quantity;
		this.author = author;
		this.bookDescription = bookDescription;
		this.bookFilter = bookFilter;
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

	public int getBookPrice() {
		return bookPrice;
	}

	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}

	public String getBookCategories() {
		return BookCategories;
	}

	public void setBookCategories(String BookCategories) {
		this.BookCategories = BookCategories;
	}

	public String getBookImage() {
		return bookImage;
	}

	public void setBookImage(String bookImage) {
		this.bookImage = bookImage;
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

	public String getBookFilter() {
		return bookFilter;
	}

	public void setBookFilter(String bookFilter) {
		this.bookFilter = bookFilter;
	}

}