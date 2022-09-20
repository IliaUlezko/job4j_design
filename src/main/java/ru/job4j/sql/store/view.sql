create view show_max_value_of_products
as SELECT b.name AS "Покупатель",
	sum(p.price) AS "Сумма покупки",
	count(p.id) AS "Количество товаров"
FROM buyer b
JOIN ordering o ON o.buyer_id = b.id
JOIN product p ON p.id = o.product_id
GROUP BY b.name
ORDER BY 2 DESC;

SELECT * FROM show_max_value_of_products;