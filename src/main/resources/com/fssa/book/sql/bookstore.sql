-- Create a new DB Table books

use meganathan_subramanian_corejava_project;
CREATE TABLE books(
    Id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    Name VARCHAR(100) NOT NULL,
    Price INT(200) not null,
    Categories VARCHAR(200) not null,
    Image VARCHAR(200) not null,
    Language VARCHAR(50) not null,
    quantity INT not null,
    author VARCHAR(100)not null, 
    Description TEXT
);
INSERT INTO books (Name, Price, Categories, Image, Language, quantity, author, Description)
VALUES 
    ('The Great Gatsby', 20, 'Fiction', 'gatsby.jpg', 'English', 2, 'F. Scott Fitzgerald', 'A classic novel about the American Dream.'),
    ('To Kill a Mockingbird', 18, 'Fiction', 'mockingbird.jpg', 'English', 2, 'Harper Lee', 'A powerful story addressing racial injustice.'),
    ('1984', 22, 'Science Fiction', '1984.jpg', 'English', 2, 'George Orwell', 'A dystopian novel exploring themes of totalitarianism.'),
    ('Pride and Prejudice', 15, 'Romance', 'pride.jpg', 'English', 2, 'Jane Austen', 'A beloved tale of love and societal norms.'),
    ('The Hobbit', 25, 'Fantasy', 'hobbit.jpg', 'English', 2, 'J.R.R. Tolkien', 'An adventurous fantasy journey.');

SELECT * FROM books;


--  Create the 2 milestone

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    phoneNumber VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    password VARCHAR(50) NOT NULL,
    state VARCHAR(50) NOT NULL,
    city VARCHAR(55) NOT NULL,
    pincode VARCHAR(10) NOT NULL
);

INSERT INTO users (name, phoneNumber, email, password, state, city, pincode)
VALUES
    ('John Doe', '123-456-7890', 'john@example.com', 'securePassword', 'California', 'Los Angeles', '90001'),
    ('Jane Smith', '987-654-3210', 'jane@example.com', 'strongPassword', 'New York', 'New York City', '10001'),
    ('Alice Johnson', '555-123-4567', 'alice@example.com', 'safePassword', 'Texas', 'Austin', '78701');

select * from users;
