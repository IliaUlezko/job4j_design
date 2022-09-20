create table store(
	id serial PRIMARY KEY,
	name VARCHAR(30)
);

create table buyer(
	id serial PRIMARY KEY,
	name VARCHAR(50)
);

create table seller(
	id serial PRIMARY KEY,
	name VARCHAR(50),
	store_id INT REFERENCES store(id)
);

create table product(
	id serial PRIMARY KEY,
	name VARCHAR(50),
	price INT,
	store_id INT REFERENCES store(id)
);

create table ordering(
	id serial PRIMARY KEY,
	seller_id INT REFERENCES seller(id),
	buyer_id INT REFERENCES buyer(id),
	product_id INT REFERENCES product(id)
);
