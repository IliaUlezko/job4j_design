create table car_engines(
    id serial primary key,
    name varchar(30)
);

insert into car_engines(name)
values
    ('I4'),
    ('V4'),
    ('V6'),
    ('Hybrid engine'),
    ('Electro car');
