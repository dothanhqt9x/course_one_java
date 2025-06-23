create database btspring;

use btspring;

create table  user(
	id int primary key auto_increment,
    name varchar(255),
    username varchar(255),
    password varchar(255),
    role varchar(100),
    gender int,
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