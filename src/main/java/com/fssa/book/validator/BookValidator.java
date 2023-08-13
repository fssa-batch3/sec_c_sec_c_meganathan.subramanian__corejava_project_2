package com.fssa.book.validator;


/**
 * Below the code for validate the all attributes
 *
 * @author MeganathanSubramania
 */

import java.util.regex.Matcher;

import java.util.regex.Pattern;
import com.fssa.book.enums.BookCategoriesEnum;
import com.fssa.book.model.Book;
import com.fssa.book.model.BookValidateErrors;

public class BookValidator {
 
    /**
     * Below the code for validate the all attribute and get the value from it.
     *
     * @param book
     * @return
     * @throws IllegalArgumentException
     */
    public  boolean validate(Book book) throws IllegalArgumentException {

        if (book == null) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_NULL);
        }
        validateBookName(book.getBookName());
        validateBookPrice(book.getBookPrice());
        validateBookCategoriesName(book.getBookCategories());
        validateBookLanguages(book.getBooklanguage());
        validateBookQuantity(book.getQuantity());
        validateAuthorName(book.getAuthor());
        validateBookImageUrl(book.getBookImage());
        validateBookDescription(book.getBookDescription());
 
        return true;
    } 

    /**
     * Below the code for validate the book Name.
     *
     * @param bookName
     * @return
     * @throws IllegalArgumentException
     */
    public  boolean validateBookName(String bookName) throws IllegalArgumentException {
        if (bookName == null) { 
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_NAME_NULL);
        }

        // Below the code for Regex pattern
        String regx = "^[A-Za-z ]+$";
        Pattern pattern = Pattern.compile(regx);
        Matcher matcher = pattern.matcher(bookName);
        boolean isMatch = matcher.matches();
        if (" ".trim().equals(bookName) || bookName.trim().length() > 40 || bookName.trim().length() < 3 || !isMatch) {

            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_NAME);
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
    public  boolean validateBookPrice(int Price) throws IllegalArgumentException {
        if (Price <= 350 || Price > 1300) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_PRICE);
        }
        return true;
    }

    /**
     * Below the code for validate the book categories name,Remind this is constant.
     *
     * @param bookCategoriesName
     * @return
     * @throws IllegalArgumentException
     */
    public  boolean validateBookCategoriesName(String bookCategoriesName) throws IllegalArgumentException {

        if (bookCategoriesName == null || "".trim().equals(bookCategoriesName)) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_CATEGORIES_NULL);
        }

        // Code for Regex pattern
        String regex = "^[A-Za-z ]+$";
        Pattern pattern = Pattern.compile(regex); // Compile the pattern
        Matcher matcher = pattern.matcher(bookCategoriesName); // using matcher object of check the whether match or
        boolean isMatch = matcher.matches(); // And return the boolean value

        if (bookCategoriesName.toLowerCase().length() > 20 || bookCategoriesName.toLowerCase().length() < 2 || !isMatch) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_CATEGOIRES_NAME);
        } else {
            validateCategoryNameEnums(bookCategoriesName);
            return true;
        }

    }

    /**
     * Below the code for validate the book catgy name in enums
     *
     * @param mainCategory
     * @return
     * @throws IllegalArgumentException
     */
    public  boolean validateCategoryNameEnums(String mainCategory) throws IllegalArgumentException {

        if (mainCategory == null || "".trim().equals(mainCategory)) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_CATEGORIES_NULL);
        }

        for (BookCategoriesEnum category : BookCategoriesEnum.values()) {

            if (category.getValue().equals(mainCategory)) {
                return true;
            }
        }

        throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_CATEGOIRES_NAME);
    }

    /**
     * Below the code for validate the book image url
     *
     * @param bookImageUrl
     * @return
     * @throws IllegalArgumentException
     */

    public  boolean validateBookImageUrl(String bookImageUrl) throws IllegalArgumentException {

        if (bookImageUrl == null || bookImageUrl.trim().equals("")) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_IMAGE_URL);
        }

        // Code for Regex pattern
        String regex = "(?i)\\b((https?|ftp)://)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?\\.(jpg|jpeg|gif|png|bmp)\\b";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bookImageUrl);
        boolean isMatch = matcher.matches();

        if (!isMatch) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_IMAGE_URL);
        } else {
            return true;
        }

    }

    /**
     * Below the code for validate the book lang Name.
     *
     * @param bookLanguage
     * @return
     * @throws IllegalArgumentException
     */
    public  boolean validateBookLanguages(String bookLanguage) throws IllegalArgumentException {

        if (bookLanguage == null) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME_NULL);
        }

        // Code for Regex pattern
        String regex = "^[A-Za-z ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bookLanguage);
        boolean isMatch = matcher.matches(); // this is the new way to check the value

        if (bookLanguage.trim().equals("") || bookLanguage.trim().length() > 20 || !isMatch) {

            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_LANGUAGE_NAME);
        } else {
            return true;
        }
    }

    /**
     * Below the code for validate the book Qty.
     *
     * @param bookQuantity
     * @return
     * @throws IllegalArgumentException
     */

    public  boolean validateBookQuantity(int bookQuantity) throws IllegalArgumentException {
        if (bookQuantity <= 0 || bookQuantity > 20) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_QUANTITY);
        }
        return true;
    } 

    /**
     * Below the code for validate the book author name.
     *
     * @param authorName
     * @return
     * @throws IllegalArgumentException
     */ 

    public  boolean validateAuthorName(String authorName) throws IllegalArgumentException {

        if (authorName == null) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_AUTHOR_NAME_NULL);
        }

        // Code for Regex pattern
        String regex = "^[A-Za-z ]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(authorName);
        boolean isMatch = matcher.matches(); // this is the new way to check the value

        if (authorName.trim().equals("") || authorName.trim().length() > 20 || !isMatch) {
            throw new IllegalArgumentException(BookValidateErrors.INVAID_BOOK_AUTHOR_NAME);
        } else {
            return true;
        }

    }

    /**
     * Below the code validate the book description
     *
     * @param bookDescription
     * @return
     * @throws IllegalArgumentException
     */ 
    public  boolean validateBookDescription(String bookDescription) throws IllegalArgumentException {
        if (bookDescription == null) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_DESCRIPTION_NULL);

        }

        // Code for Regex pattern
        String regex = "^[A-Za-z0-9,@ ?.\s]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(bookDescription);
        boolean isMatch = matcher.matches(); // this is the new way to check the value

        if ("".trim().equals(bookDescription) || bookDescription.trim().length() > 400 || !isMatch) {
            throw new IllegalArgumentException(BookValidateErrors.INVALID_BOOK_DESCRIPTION);
        } 
        else {
            return true;
        }
    }
} 
