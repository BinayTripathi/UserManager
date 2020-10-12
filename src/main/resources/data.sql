

insert into address (city, post_code, state, address_id) values ('City1', 3000, 'Vic', 1000);
insert into address (city, post_code, state, address_id) values ('City2', 3000, 'Vic', 1001);
insert into address (city, post_code, state, address_id) values ('City3', 2000, 'NSW', 1002);
insert into address (city, post_code, state, address_id) values ('City4', 2000, 'NSW', 1003);
insert into address (city, post_code, state, address_id) values ('City5', 2000, 'NSW', 1004);

insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1000, 'FN1', 'male', 'LN1', 'pass1', 'mr', 'un1', 10001);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1000, 'FN2', 'female', 'LN2', 'pass2', 'mrs', 'un2', 10002);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1001, 'FN3', 'male', 'LN3', 'pass3', 'mr', 'un3', 10003);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1001, 'FN4', 'female', 'LN4', 'pass4', 'mrs', 'un4', 10004);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1002, 'FN5', 'male', 'LN5', 'pass5', 'mr', 'un5', 10005);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1002, 'FN6', 'female', 'LN6', 'pass6', 'mrs', 'un6', 10006);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1003, 'FN7', 'female', 'LN7', 'pass7', 'miss', 'un7', 10007);
insert into user (address_address_id, first_name, gender, last_name, password, title, user_name, user_id) values (1004, 'FN8', 'male', 'LN8', 'pass8', 'mr', 'un8', 10008);


insert into user_roles (user_user_id, roles) values (10001, 'ROLE_ADMIN');
insert into user_roles (user_user_id, roles) values (10002, 'ROLE_ADMIN');
insert into user_roles (user_user_id, roles) values (10003, 'ROLE_NON-ADMIN');
insert into user_roles (user_user_id, roles) values (10004, 'ROLE_NON-ADMIN');
insert into user_roles (user_user_id, roles) values (10005, 'ROLE_NON-ADMIN');
insert into user_roles (user_user_id, roles) values (10006, 'ROLE_NON-ADMIN');
insert into user_roles (user_user_id, roles) values (10007, 'ROLE_NON-ADMIN');
insert into user_roles (user_user_id, roles) values (10008, 'ROLE_NON-ADMIN');