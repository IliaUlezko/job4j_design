create table employees(
	id serial primary key,
	name VARCHAR(100),
	age INTEGER,
	salary float8
);

insert into employees(name, age, salary)
values('Anton Petrovich Ivanov', 27, 78694.13);

update employees set name = 'Victor Alekseevich Ivanov',
age = 32, salary = 75123.34;

delete from employees;