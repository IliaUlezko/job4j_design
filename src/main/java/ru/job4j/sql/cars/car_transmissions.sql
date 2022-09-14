create table car_transmissions(
    id serial primary key,
    name varchar(30)
);

insert into car_transmissions(name)
values
    ('Auto'),
    ('Manual'),
    ('DSG'),
    ('Robot'),
    ('CVT'),
    (null);
