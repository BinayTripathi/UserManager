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

insert into address (city, post_code, state, address_id) values ('City1', 3000, 'Vic', 1000);
insert into address (city, post_code, state, address_id) values ('City2', 3000, 'Vic', 1001);
insert into address (city, post_code, state, address_id) values ('City3', 2000, 'NSW', 1002);
insert into address (city, post_code, state, address_id) values ('City4', 2000, 'NSW', 1003);
insert into address (city, post_code, state, address_id) values ('City5', 2000, 'NSW', 1004);

insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1000, 'FN1', 'MALE', 'LN1', 'pass1', 'MR', 'un1', 10001);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1000, 'FN2', 'FEMALE', 'LN2', 'pass2', 'MRS', 'un2', 10002);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1001, 'FN3', 'MALE', 'LN3', 'pass3', 'MR', 'un3', 10003);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1001, 'FN4', 'FEMALE', 'LN4', 'pass4', 'MRS', 'un4', 10004);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1002, 'FN5', 'MALE', 'LN5', 'pass5', 'MR', 'un5', 10005);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1002, 'FN6', 'FEMALE', 'LN6', 'pass6', 'MRS', 'un6', 10006);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1003, 'FN7', 'FEMALE', 'LN7', 'pass7', 'MISS', 'un7', 10007);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1004, 'FN8', 'MALE', 'LN8', 'pass8', 'MR', 'un8', 10008);


insert into user_roles (user_user_id, roles) values (10001, 'ROLE_ADMIN');
insert into user_roles (user_user_id, roles) values (10002, 'ROLE_ADMIN');
insert into user_roles (user_user_id, roles) values (10003, 'ROLE_NON-ADMIN');
insert into user_roles (user_user_id, roles) values (10004, 'ROLE_NON-ADMIN');
insert into user_roles (user_user_id, roles) values (10005, 'ROLE_NON-ADMIN');
insert into user_roles (user_user_id, roles) values (10006, 'ROLE_NON-ADMIN');
insert into user_roles (user_user_id, roles) values (10007, 'ROLE_NON-ADMIN');
insert into user_roles (user_user_id, roles) values (10008, 'ROLE_NON-ADMIN');