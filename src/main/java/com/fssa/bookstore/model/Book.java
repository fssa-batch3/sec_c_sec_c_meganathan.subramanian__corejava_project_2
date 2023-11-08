package com.fssa.bookstore.model;

import java.time.LocalDate;

import com.fssa.bookstore.enums.BookBinding;
import com.fssa.bookstore.enums.BookReturnable;
import com.fssa.bookstore.enums.Categories;

/**
 * Below the code for add the attribute and write the getter and setter
 *
 * @author MeganathanSubramanian
 */

public class Book {
	private int bookId;
	private int quantity;
	private String bookName;
	private String bookImageUrl;
	private String booklanguage;
	private String bookDescription;
	private String author;
	private String authorImgUrl;
	private String aboutAuthor;
	private String publisherImprint;
	private LocalDate publisherDate;
	private String bookIsbn;
	private double bookPrice;
	private double bookwidth;
	private int noOfPages;
	private double bookHeight;
	private double bookDepth;
	private double bookWeight;
	private Categories bookCategories;
	private BookBinding bookBinding;
	private BookReturnable returnable;

	/**
	 * Below the code getters and setters methods this will Return the which we set
	 * the set attribute.
	 * 
	 * @return this all methods return the value to the Attribute.
	 */

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

	public Categories getBookCategories() {
		return bookCategories;
	}

	public void setBookCategories(Categories bookCategories) {
		this.bookCategories = bookCategories;
	}

	public String getBookImageUrl() {
		return bookImageUrl;
	}

	public void setBookImageUrl(String bookImageUrl) {
		this.bookImageUrl = bookImageUrl;
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

	public String getAuthorImg() {
		return authorImgUrl;
	}

	public void setAuthorImgUrl(String authorImgUrl) {
		this.authorImgUrl = authorImgUrl;
	}

	public String getAboutAuthor() {
		return aboutAuthor;
	}

	public void setAboutAuthor(String aboutAuthor) {
		this.aboutAuthor = aboutAuthor;
	}

	public LocalDate getPublisherDate() {
		return publisherDate;
	}

	public void setPublisherDate(LocalDate publisherDate) {
		this.publisherDate = publisherDate;
	}

	public BookBinding getBookBinding() {
		return bookBinding;
	}

	public void setBookBinding(BookBinding bookBinding) {
		this.bookBinding = bookBinding;
	}

	public double getBookHeight() {
		return bookHeight;
	}

	public void setBookHeight(double bookHeight) {
		this.bookHeight = bookHeight;
	}

	public double getBookWeight() {
		return bookWeight;
	}

	public void setBookWeight(double bookWeight) {
		this.bookWeight = bookWeight;
	}

	public double getBookwidth() {
		return bookwidth;
	}

	public void setBookwidth(double bookwidth) {
		this.bookwidth = bookwidth;
	}

	public int getNoOfPages() {
		return noOfPages;
	}

	public void setNoOfPages(int noOfPages) {
		this.noOfPages = noOfPages;
	}

	public String getPublisherImprint() {
		return publisherImprint;
	}

	public void setPublisherImprint(String publisherImprint) {
		this.publisherImprint = publisherImprint;
	}

	public double getBookDepth() {
		return bookDepth;
	}

	public void setBookDepth(double bookDepth) {
		this.bookDepth = bookDepth;
	}

	public BookReturnable getReturnable() {
		return returnable;
	}

	public void setReturnable(BookReturnable returnable) {
		this.returnable = returnable;
	}

	public void setIsbn(String isbn) {
		this.bookIsbn = isbn;
	}

	public String getisbn() {
		return bookIsbn;
	}

	// Below the code convert the to string method in all
//	@Override
//	public String toString() {
//		return "Book [bookId= " + bookId + ", quantity= " + quantity + ", bookDepth= " + bookDepth + ", bookName= "
//				+ bookName + ", bookImageUrl= " + bookImageUrl + ", booklanguage= " + booklanguage + ", publisherImprint= "
//				+ publisherImprint + ", author= " + author + ", bookDescription= " + bookDescription + ", authorImg= "
//				+ authorImgUrl + ", aboutAuthorUrl= " + aboutAuthor + ", publisherDate= " + publisherDate + ", bookIsbn="
//				+ bookIsbn + ", bookPrice= " + bookPrice + ", bookHeight= " + bookHeight + ", bookWeight= " + bookWeight
//				+ ", bookwidth= " + bookwidth + ", noOfPages=" + noOfPages + ", bookCategories=" + bookCategories
//				+ ", bookBinding= " + bookBinding + ", returnable= " + returnable + "]";
//	}

}