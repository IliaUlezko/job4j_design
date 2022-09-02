create table course(
    id serial primary key,
    title varchar(50)
);

create table student(
    id serial primary key,
    first_name varchar(30),
    last_name varchar(50),
    age integer,
    course_id references course(id)
);

insert into course(title)
values ('Java');
insert into course(title)
values ('PHP');
insert into course(title)
values ('JavaScript');

insert into student(first_name, last_name, age, course_id)
values ('Ivan', 'Petrov', 18, 1);
insert into student(first_name, last_name, age, course_id)
values ('Maria', 'Ivanova', 19, 1);
insert into student(first_name, last_name, age, course_id)
values ('Petr', 'Andreev', 20, 2);
insert into student(first_name, last_name, age, course_id)
values ('Olga', 'Andreeva', 18, 3);
insert into student(first_name, last_name, age, course_id)
values ('Victor', 'Krum', 21);

select id, first_name as 'Имя', last_name as 'Фамилия', age as 'Возраст', course_id
from student
join course on stident.course_id = course.id;

select * from student as s
join course as c on s.course_id = c.id;

select s.first_name as 'NAME', s.age as 'AGE'
from student as s
join course on s.course_id = course.id;
