-- Address table
CREATE TABLE address (
	address_id INT NOT NULL,
	street VARCHAR(64) NOT NULL,
    city VARCHAR(64) NOT NULL,
    state DATE NOT NULL,
    PRIMARY KEY (address_id)  
);

-- User table - 
CREATE TABLE user (
	user_id INT NOT NULL,
	title VARCHAR(64) NOT NULL,
    first_name VARCHAR(64) NOT NULL,
    last_name VARCHAR(64) NOT NULL,
    gender VARCHAR(64) NOT NULL,
    address_id INT NOT NULL,
    PRIMARY KEY (user_id),
    FOREIGN KEY (address_id) REFERENCES address(address_id)
);

