create table library_cards(
    id serial primary key,
    number int
);

create table readers(
    id serial primary key,
    name varchar(100),
    phone int
);

create table readers_cards(
    id serial primary key,
    passport_id int references library_cards(id) unique,
    people_id int references readers(id) unique
);