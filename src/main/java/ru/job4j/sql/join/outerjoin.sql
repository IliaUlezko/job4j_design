create table departments(
    id serial primary key,
    name varchar(50)
);

create table employees(
    id serial primary key,
    name varchar(50),
    department_id int references departments(id)
);

insert into departments(name)
values
      ('Human Resources'),
      ('Finance'),
      ('Production'),
      ('IT'),
      ('Cleaning');

insert into employees(name, department_id)
values
      ('Irina',1),
      ('Victor',1),
      ('Fedor',2),
      ('Elena',3),
      ('Ivan',3),
      ('Alexey',3),
      ('Petr',4),
      ('Natalya',4),
      ('Olga',4);

select dep.name, emp.name
from departments dep left join employees emp
on dep.id = emp.department_id;

select d.name, e.name
from departments d right join employees e
on d.id = e.department_id;

select d.name, e.name
from departments d full join employees e
on d.id = e.department_id;

select d.name, e.name
from departments d cross join employees e;


select d.name as "Empty"
from departments d left join employees e
on d.id = e.department_id
where e."name" is null;

select e.name as "First_name", d.name as "Department"
from departments d left join employees e
on d.id = e.department_id;

select e.name as "First_name", d.name as "Department"
from employees e right join departments d
on d.id = e.department_id;
