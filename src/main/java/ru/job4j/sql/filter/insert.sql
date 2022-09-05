insert into type(name)
values ('Сыр');
insert into type(name)
values ('Овощи');
insert into type(name)
values ('Молоко');
insert into type(name)
values ('Прочие продукты');

insert into product(name, type_id, expired_date, price)
values ('Российский', 1, '2022-10-21',600);
insert into product(name, type_id, expired_date, price)
values ('Моцарелла', 1, '2022-09-03',750);
insert into product(name, type_id, expired_date, price)
values ('Плавленный', 1, '2023-01-04',660);
insert into product(name, type_id, expired_date, price)
values ('Чеддер', 1, '2022-08-01',350);

insert into product(name, type_id, expired_date, price)
values ('Свёкла', 2, '2022-09-07',45);
insert into product(name, type_id, expired_date, price)
values ('Огурец', 2, '2022-09-04',35);
insert into product(name, type_id, expired_date, price)
values ('Помидор', 2, '2022-09-05',40);
insert into product(name, type_id, expired_date, price)
values ('Картофель', 2, '2022-09-17',50);

insert into product(name, type_id, expired_date, price)
values ('Сливки', 3, '2022-11-28',105);
insert into product(name, type_id, expired_date, price)
values ('Кефир', 3, '2022-09-19',63);

insert into product(name, type_id, expired_date, price)
values ('Вода', 4, '2023-01-01',76);
insert into product(name, type_id, expired_date, price)
values ('Лимонад', 4, '2023-03-15',78);
insert into product(name, type_id, expired_date, price)
values ('Мороженое', 4, '2022-05-13',17);
insert into product(name, type_id, expired_date, price)
values ('Шоколад', 4, '2022-12-16',112);
