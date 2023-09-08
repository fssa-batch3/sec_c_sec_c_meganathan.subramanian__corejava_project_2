-- Create a new DB Table books

use meganathan_subramanian_corejava_project;
-- Create a new DB Table books
use meganathan_subramanian_corejava_project;
drop table books;
CREATE TABLE books (
  book_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255),
    price DECIMAL(10, 2),
    category VARCHAR(255),
    image_url VARCHAR(255),
    language VARCHAR(50),
    quantity INT,
    author VARCHAR(255),
    description TEXT,
    authorImgUrl VARCHAR(255),
    aboutAuthor TEXT,
    publisherImprint VARCHAR(255),
    publisherDate DATE,
    isbn VARCHAR(20),
    width DECIMAL(5, 2),
    pages INT,
    height DECIMAL(5, 2),
    depth DECIMAL(5, 2),
    weight DECIMAL(10, 2),
    binding VARCHAR(50),
    returnable VARCHAR(10)
);

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
