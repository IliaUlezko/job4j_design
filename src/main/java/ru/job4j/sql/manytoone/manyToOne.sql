create table author(
    id serial primary key,
    name varchar(100),
    age int
);

create table books(
    id serial primary key,
    title varchar(255),
    author_id int references author(id)
);