select product.name
from product
join type on type.id = product.type_id
where type.name like '%Сыр%';

select product.name, product.price
from product
join type on type.id = product.type_id
where product.name like '%Мороженое%';

select product.name as "Продукты с истекщим сроком годности", product.price, product.expired_date
from product
where product.expired_date < current_date
order by product.price desc;

select product.name as "Продукт", product.price as "Стоимость"
from product
join type on type.id = product.type_id
where product.price = (select(max(price)) from product);

select type.name as "Тип продукта", count(product) as "Количество"
from type
join type on product.type_id = type.id
group by type.name;

select p.name as "Продукт", p.price as "Цена"
from product as p
join type as t on t.id = p.type_id
where t.name like '%Сыр%' or t.name like '%Молоко%'
order by p.price;

select t.name
from type as t
join product as p on p.type_id = t.id
group by t.name
having count(p.name) < 10;

select type.name, product.name
from product
join type on product.type_id = type.id;
