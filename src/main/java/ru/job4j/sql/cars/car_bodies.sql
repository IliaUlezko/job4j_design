create table car_bodies(
    id serial primary key,
    name varchar(30)
);

insert into car_bodies(name)
values
    ('Sedan'),
    ('Coupe'),
    ('Truck'),
    ('Hatchback'),
    ('Minivan');
