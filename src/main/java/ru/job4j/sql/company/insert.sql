insert into role(name)
values ('owner');
insert into role(name)
values ('mentor');
insert into role(name)
values ('student');

insert into rules(title)
values ('create');
insert into rules(title)
values ('read');
insert into rules(title)
values ('update');
insert into rules(title)
values ('delete');
insert into rules(title)
values ('kick');

insert into role_rules(role_id, rules_id)
values (1, 1);
insert into role_rules(role_id, rules_id)
values (1, 2);
insert into role_rules(role_id, rules_id)
values (1, 3);
insert into role_rules(role_id, rules_id)
values (1, 4);
insert into role_rules(role_id, rules_id)
values (1, 5);
insert into role_rules(role_id, rules_id)
values (2, 1);
insert into role_rules(role_id, rules_id)
values (2, 2);
insert into role_rules(role_id, rules_id)
values (2, 3);
insert into role_rules(role_id, rules_id)
values (2, 4);
insert into role_rules(role_id, rules_id)
values (3, 2);

insert into category(name)
values ('default');
insert into category(name)
values ('private');

insert into state(name)
values ('new');
insert into state(name)
values ('in progress');
insert into state(name)
values ('completed');

insert into users(name, role_id)
values ('Petr', 1);
insert into users(name, role_id)
values ('Lana', 2);
insert into users(name, role_id)
values ('Ilia', 3);

insert into item(name, user_id, category_id, state_id)
values ('Question about task', 3, 1, 1);
insert into item(name, user_id, category_id, state_id)
values ('Check task', 2, 2, 3);
insert into item(name, user_id, category_id, state_id)
values ('Update site', 1, 2, 2);

insert into attachs(name, item_id)
values (script.sql, 1);

insert into comments(comment, item_id)
values ('What`s wrong?', 1);