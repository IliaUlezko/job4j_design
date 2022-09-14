create table cars(
    id serial primary key,
    name varchar(50),
    body_id int references car_bodies(id),
    engine_id int references car_engines(id),
    transmission_id int references car_transmissions(id)
);

insert into cars(name, body_id, engine_id, transmission_id)
values
    ('Volvo', 3, 3, 1),
    ('BMW', 2, 3, 4),
    ('Audi', 1, 1, 3),
    ('Renault', 1, 1, 4),
    ('Honda', 4, 2, 1),
    ('Nissan', 2, 3, 2),
    ('Toyota', 4, 4, 1),
    ('Mazda', 2, 2, 2),
    ('Repaired car', 3, null, 2),
    ('Repaired car2', 1, null, null);

select c.name as "Brand", b.name  as "Type", e.name as "Engine", t.name as "Transmission"
from cars c
left join car_bodies b on b.id = c.body_id
left join car_engines e on e.id = c.engine_id
left join car_transmissions t on t.id = c.transmission_id;

select b.name as "Type"
from cars c
right join car_bodies b on c.body_id = b.id
where c.body_id is null;

select e.name as "Engine"
from car_engines e
left join cars c on c.engine_id = e.id
where c.engine_id is null;

select t.name as "Transmission"
from car_transmissions t
left join cars c on c.transmission_id = t.id
where c.transmission_id is null;