create database btspring;

use btspring;

create table  user(
	id int primary key auto_increment,
    name varchar(255),
    gender varchar(255),
    birthday DATE,
    address varchar(255)
);

create table product(
	id int primary key auto_increment,
	name varchar(255),
    quantity int
);	

create table user_product(
	id int primary key auto_increment,
    userId int ,
    productId int,
    
    foreign key (userId) references user(id),
    foreign key (productId) references product(id)
);