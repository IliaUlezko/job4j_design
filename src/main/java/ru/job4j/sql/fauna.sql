create table fauna(
    id serial primary key,
    name text,
    avg_age int,
    discovery_date date
);

insert into fauna(name, avg_age, discovery_date)
values ('horse', 3000, null);
insert into fauna(name, avg_age, discovery_date)
values ('penguin', 11000, '1778-07-11');
insert into fauna(name, avg_age, discovery_date)
values ('camel', 7500, null);
insert into fauna(name, avg_age, discovery_date)
values ('butterfly', 100, '1971-02-06');
insert into fauna(name, avg_age, discovery_date)
values ('swordfish', 20500, '1932-09-03');

select name, avg_age
from fauna
where name like '%fish%';

select name, avg_age
from fauna
where avg_age > 10000 AND avg_age < 21000;

select id, name, avg_age, discovery_date
from fauna
where discovery_date is null;

select id, name, avg_age, discovery_date
from fauna
where discovery_date < '1950-01-01';
