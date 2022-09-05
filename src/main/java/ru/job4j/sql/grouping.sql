create table devices(
    id serial primary key,
    name varchar(255),
    price float
);

create table people(
    id serial primary key,
    name varchar(255)
);

create table devices_people(
    id serial primary key,
    device_id int references devices(id),
    people_id int references people(id)
);

insert into devices(name, price)
values ('TV', 44990.21);
insert into devices(name, price)
values ('phone', 19863.72);
insert into devices(name, price)
values ('laptop', 64783.06);

insert into people(name)
values ('Ivan');
insert into people(name)
values ('Petr');
insert into people(name)
values ('Maria');
insert into people(name)
values ('Elena');

insert into devices_people(device_id, people_id)
values (1, 2);
insert into devices_people(device_id, people_id)
values (1, 3);
insert into devices_people(device_id, people_id)
values (1, 4);
insert into devices_people(device_id, people_id)
values (2, 1);
insert into devices_people(device_id, people_id)
values (2, 2);
insert into devices_people(device_id, people_id)
values (2, 3);
insert into devices_people(device_id, people_id)
values (2, 4);
insert into devices_people(device_id, people_id)
values (3, 3);
insert into devices_people(device_id, people_id)
values (3, 2);

select cast(avg(price) as float(24)) as "Средняя цена"
from devices;

select p.name, cast(avg(price) as float(24))
from devices_people as dp
join people as p
on dp.people_id = p.id
join devices as d
on dp.device_id = d.id
group by p.name;

select p.name, cast(avg(price) as float(24))
from devices_people as dp
join people as p
on dp.people_id = p.id
join devices as d
on dp.device_id = d.id
group by p.name
having avg(price) > 5000;
