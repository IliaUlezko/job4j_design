 create table readers(
     id serial primary key,
     name varchar(100)
 );

 create table books(
     id serial primary key,
     title varchar(255),
     author_id int
 );

 create table readers_books(
     id serial primary key,
     readers_id int references readers(id),
     books_id int references books(id)
 );