create database db_qlbanhang_ck;
use db_qlbanhang_ck;

create table account
(
	acc_id int not null auto_increment,
    acc_name nvarchar(40) not null,
    acc_username nvarchar(40) not null,
    acc_password varchar(40) not null,
    acc_access int not null,
    acc_address nvarchar(40) not null,
    acc_contact varchar(11) not null,
    acc_condition int,
    primary key(acc_id)
);

create table Orders
(
		order_id varchar(50) not null,
        acc_id int not null,
        order_address nvarchar(50) not null,
        paymentmethod nvarchar(50),
        dateofpurchase date,
        order_condition varchar(40),
        primary key(order_id),
        foreign key(acc_id) references account(acc_id)
);
create table Category
(
	category_id int not null auto_increment,
    category_name nvarchar(40),
    category_description nvarchar(100),
    primary key (category_id)
);

create table Product
(
	product_id int not null auto_increment,
    product_name nvarchar(40) not null,
    product_price double not null,
    product_quantity int not null,
    product_img varchar(40),
    product_description nvarchar(100),
    category_id int not null,
    primary key(product_id),
    foreign key(category_id) references Category(category_id)
);

create table order_detail
(
	orderdetail_id int not null auto_increment,
    order_id varchar(50) not null,
    product_id int not null,
    quantity int,
    price int,
    primary key(orderdetail_id),
    foreign key	(order_id) references Orders(order_id),
    foreign key(product_id) references Product(product_id)
);
insert into account (acc_name,acc_username,acc_password,acc_access,acc_address,acc_contact)
values (N'Lê Quang Lưu','luyenluuchimai@gmail.com','Cntt@9876',1,N'Quảng Trị','0889347459');

insert into Category(category_name,category_description)
values ("Men and women","large size"),
		("Kid and baby","small size"),
        ("Fashion and beauty","for rich customer");

insert into Product(product_name,product_price,product_quantity,product_img,product_description,category_id)
values  ("Ao tam",100,26,"aotam.png","Ao tam danh cho phu nu",1),
		("T-shirt",30,5,"T_shirt.png","Ao phong mua dong",2);
		