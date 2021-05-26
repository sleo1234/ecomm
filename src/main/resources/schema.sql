CREATE TABLE IF NOT EXISTS cart (
cart_id BIGINT NOT NULL DEFAULT nextval('cart_seq') PRIMARY KEY,
quantity INT NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS product_seq;

CREATE TABLE IF NOT EXISTS product (
product_id BIGINT NOT NULL DEFAULT nextval('product_seq') PRIMARY KEY,
name VARCHAR(100) NOT NULL,
manufacturer VARCHAR(100) NOT NULL,
category VARCHAR(100) NOT NULL,
price FLOAT(24) NOT NULL,
description VARCHAR(300) NOT NULL,
	cart_cart_id BIGINT,
CONSTRAINT fk_product_cart
	FOREIGN KEY (cart_cart_id) 
	REFERENCES cart
);
CREATE SEQUENCE IF NOT EXISTS cart_seq;



CREATE SEQUENCE IF NOT EXISTS customer_seq;

CREATE TABLE IF NOT EXISTS customer (

customer_id BIGINT NOT NULL DEFAULT nextval('customer_seq') PRIMARY KEY,
first_name VARCHAR(100) NOT NULL,
last_name VARCHAR(100) NOT NULL,
email VARCHAR(100) NOT NULL,
password VARCHAR(100) NOT NULL,
adress VARCHAR(100) NOT NULL,
phoneNumber VARCHAR(100) NOT NULL,
role VARCHAR(100) NOT NULL,
cart_cart_id BIGINT,
CONSTRAINT fk_customer_cart
	FOREIGN KEY (cart_cart_id)
	REFERENCES cart

);


