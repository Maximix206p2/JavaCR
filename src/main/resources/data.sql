delete from person;
delete from passport;

insert into person (first_name, last_name) values('Ivan', 'Ivanov');
insert into person (first_name, last_name) values('John', 'Smith');

insert into passport (number,country,person_id) values('DB2351345', 'BY',1);
insert into passport (number,country,person_id) values('DB1233346', 'BY',2);

delete from comment;
delete from post;

insert into post (content) values('Post 1');
insert into post (content) values('Post 2');

insert into comment(content) values('Comment 1');
insert into comment(content) values('Comment 2');

UPDATE comment SET post_id = 1 WHERE id=1;
UPDATE comment SET post_id = 1 WHERE id=2;

delete from address;
delete from employee;

insert into address (city, street) values('Vitebsk', 'Moskowsky st.');
insert into address (city, street) values('Minsk', 'Pobedy st.');
insert into address (city, street) values('Vitebsk', 'Stroiteley st.');

insert into employee (first_name, last_name, age, address_id) values('Jonny', 'Ramone', 20, 1);
insert into employee (first_name, last_name, age, address_id) values('Joey', 'Ramone', 23, 2);
insert into employee (first_name, last_name, age, address_id) values('Marky', 'Ramone', 25, 3);

delete from phone;
delete from subscriber;

insert into subscriber (first_name, last_name) values ('John', 'Doe');
insert into subscriber (first_name, last_name) values ('Jane', 'Deer');

insert into phone(number, subscriber_id) values ('111', 1);
insert into phone(number, subscriber_id) values ('222', 2);

delete from book;
delete from author;

insert into author (name) values ('Stephen King');
insert into author (name) values ('Mark Twain');
insert into author (name) values ('Marcel Proust');

insert into book(title) values ('11/22/63: A Novel');
insert into book(title) values ('Doctor Sleep: A Novel');
insert into book(title) values ('In Search of Lost Time');

insert into author_books(author_id, book_id) values (1, 1);
insert into author_books(author_id, book_id) values (1, 2);
insert into author_books(author_id, book_id) values (2, 2);