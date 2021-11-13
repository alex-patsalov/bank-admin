drop table if exists account CASCADE;
drop table if exists customer CASCADE;
drop table if exists customers_employers CASCADE;
drop table if exists employer CASCADE;
drop table if exists r_customer_account CASCADE;

create table customer
(
    customer_id int not null generated by default as identity,
    age         int,
    email       varchar(255),
    name        varchar(255),
    primary key (customer_id)
);

create table account
(
    account_id           int not null generated by default as identity,
    balance              double,
    currency             varchar(255),
    number               varchar(255),
    customer_id int,
    primary key (account_id),
    foreign key (customer_id) references customer (customer_id)
);

create table employer
(
    employer_id int not null generated by default as identity,
    address     varchar(255),
    name        varchar(255),
    primary key (employer_id)
);

create table customers_employers
(
    cus_id int not null,
    emp_id int not null,
    foreign key (cus_id) references customer (customer_id),
    foreign key (emp_id) references employer (employer_id)
);

insert into customer (age, email, name)
values (21, 'customer1@gmail.com', 'name1');

insert into customer (age, email, name)
values (22, 'customer2@gmail.com', 'name2');

insert into customer (age, email, name)
values (23, 'customer3@gmail.com', 'name3');

insert into account (balance, currency, customer_id, number)
values (1000.0, 'USD', 1, 'USD111');

insert into account (balance, currency, customer_id, number)
values (1000.0, 'USD', 2, 'USD211');

insert into account (balance, currency, customer_id, number)
values (200.0, 'USD', 3, 'USD311');

insert into account (balance, currency, customer_id, number)
values (157.0, 'USD', 1, 'USD411');

insert into employer (name, address)
values ('employer1', 'address1');

insert into employer (name, address)
values ('employer2', 'address2');

insert into employer (name, address)
values ('employer3', 'address3');