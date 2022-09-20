INSERT INTO store(name)
VALUES
	('Magnit'),
	('X5_Group');

INSERT INTO seller(name, store_id)
VALUES
	('Ivan', 1),
	('Maria', 1),
	('Anton', 2);

INSERT INTO product(name, price, store_id)
VALUES
	('Milk', 100, 1),
	('Bread', 34, 1),
	('Fish', 527, 1),
	('Watermelon', 25, 1),

	('Milk', 97, 2),
	('Bread', 39, 2),
	('Meat', 429, 2),
	('Water', 75, 2),
	('Orange', 93, 2);

INSERT INTO buyer(name)
VALUES
	('Olga'),
	('Andrey'),
	('Victor'),
	('Fedor'),
	('Anastasia');

INSERT INTO ordering(seller_id,buyer_id, product_id)
VALUES
	(1, 1, 3),
	(1, 1, 2),
	(1, 1, 4);

INSERT INTO ordering(seller_id,buyer_id, product_id)
VALUES
	(2, 2, 1),
	(1, 2, 2);

INSERT INTO ordering(seller_id,buyer_id, product_id)
VALUES
    (2, 3, 1),
	(2, 3, 2),
	(2, 3, 3);

INSERT INTO ordering(seller_id,buyer_id, product_id)
VALUES
    (3, 4, 1),
	(3, 4, 2),
	(3, 4, 3);

INSERT INTO ordering(seller_id,buyer_id, product_id)
VALUES
    (3, 5, 1),
	(3, 5, 2),
	(3, 5, 3),
	(3, 5, 4),
	(3, 5, 5),
	(1, 5, 3),
	(2, 5, 4);