create table teens(
	id serial primary key,
	first_name varchar(30),
	gender varchar(6)
);

insert into teens(first_name, gender)
values
        ('Elena','female'),
        ('Olga','female'),
        ('Natalya','female'),
        ('Fedor','male'),
        ('Victor','male'),
        ('Ivan','male');

select g.first_name, b.first_name
from teens as g cross join teens as b
where g.gender != b.gender;
