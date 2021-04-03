CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer,
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'Lada');
insert into company(id, name) values (2, 'BMW');
insert into company(id, name) values (3, 'Mercedes');
insert into company(id, name) values (4, 'Volkswagen');
insert into company(id, name) values (5, 'Toyota');

insert into person(id, name, company_id) values (1, 'Vasya', 1);
insert into person(id, name, company_id) values (2, 'Petr', 1);
insert into person(id, name, company_id) values (3, 'Ivan', 2);
insert into person(id, name, company_id) values (4, 'Stas', 3);
insert into person(id, name, company_id) values (5, 'Sergei', 3);
insert into person(id, name, company_id) values (6, 'Andrey', 3);
insert into person(id, name, company_id) values (7, 'Boris', 4);
insert into person(id, name, company_id) values (8, 'Alex', 5);
insert into person(id, name, company_id) values (9, 'Jony', 5);
insert into person(id, name, company_id) values (10, 'Kalevtin', 5);
insert into person(id, name, company_id) values (11, 'Tanya', 1);
insert into person(id, name, company_id) values (12, 'Natasha', 4);
insert into person(id, name, company_id) values (13, 'Iiiiiigor', 5);

select ss.name, s.name from person as ss join company s on ss.company_id = s.id where s.id != 5;

select c.name, count(p.id) from person p left join company c on p.company_id = c.id 
group by c.name order by count(p.id) desc limit 1;