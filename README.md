# Welcome to My project!

Hello! My project name is book-Store and it is purely E- commerce website.My website is fully focus on Buying and Selling the books through my website.

# Project Setup
 Create a new Java project
 Set up a MySQL database
 Add necessary libraries
 JDBC,
 MySQL Connector,
 JUnit,
 Dotenv.

# My project tables: 

##  This table Contains the book details:

## Books Detail Table :

This table stores information about books, including details such as name, price, categories, image, language, quantity, author, and description.

| Field       | Type           | Description                            |
|-------------|----------------|----------------------------------------|
| Id          | INT            | Unique book identifier (auto-increment) |
| Name        | VARCHAR(100)   | Book's title                           |
| Price       | INT            | Book's price                           |
| Categories  | VARCHAR(200)   | Book's categories                      |
| Image       | VARCHAR(200)   | URL to the book's cover image          |
| Language    | VARCHAR(50)    | Book's language                        |
| Quantity    | INT            | Available quantity of the book         |
| Author      | VARCHAR(100)   | Book's author                          |
| Description | TEXT           | Description or summary of the book     |


# This table for Users : CRUD 

###  User Profile Table :
This table stores user profile information, including details such as name, contact information,  and preferences.

| Field        | Type           | Description                           |
|--------------|----------------|---------------------------------------|
| id           | INT            | Unique user identifier (auto-increment)|
| name         | VARCHAR(255)   | User's full name                      |
| email        | VARCHAR(255)   | User's email address                  |
| phoneNumber  | VARCHAR(20)    | User's contact phone number           |
| password     | VARCHAR(255)   | Encrypted user password               |
| state        | VARCHAR(255)   | User's state or province              |
| city         | VARCHAR(255)   | User's city                           |
| pincode      | VARCHAR(6)     | User's postal code                    |

# Key feature:
	
 1.  **User Side** : User can buy book easly form my webiste and they can buy tamil language books also in our webiste tamil books is the first priority to users.
  
 2. **Seller Side** : In my website not only user can buy books seller also sell their own book through my webiste and earn the money with profit

 #  Architecture and DataBase Design:

