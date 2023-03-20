CREATE DATABASE `demo_jdbc`;
use demo_jdbc;

create table users (
 id  int(3) AUTO_INCREMENT,
 `name` varchar(50) NOT NULL,
 email varchar(50) NOT NULL,
 country varchar(50),
 PRIMARY KEY (id)
);

insert into users(`name`, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('Kante','kante@che.uk','japan');
insert into users(`name`, email, country) values('khai','khai@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('tuan','tuan@che.uk','korea');

select * from users;

select * from users where id = 1;

select * from users where country = ?;

update users set `name` = ?, email = ? , country = ? where id = ?;

select * from users order by `name`;