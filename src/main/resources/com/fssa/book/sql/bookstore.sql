-- Create a new DB Table books

use bookstore;
Drop table books;
CREATE TABLE books(
    bookId INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    bookName VARCHAR(100) NOT NULL,
    bookPrice INT(200) not null,
    bookCategories VARCHAR(200) not null,
    bookImage VARCHAR(200) not null,
    bookLanguage VARCHAR(50) not null,
    quantity INT not null,
    author VARCHAR(100)not null,
    bookDescription TEXT
);

SELECT * FROM books;