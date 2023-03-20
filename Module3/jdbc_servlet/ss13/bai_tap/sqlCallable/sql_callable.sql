create database if not exists ss13_callableStatement ;
use ss13_callableStatement;

create table users (
 id  int(3) AUTO_INCREMENT,
 `name` varchar(50) NOT NULL,
 email varchar(50) NOT NULL,
 country varchar(50),
 PRIMARY KEY (id)
);

insert into users(`name`, email, country) values('huy','minh@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('tai','kante@che.uk','japan');
insert into users(`name`, email, country) values('dyet','khai@codegym.vn','Viet Nam');
insert into users(`name`, email, country) values('long','tuan@che.uk','korea');

call sp_find_all_user();
delimiter $$
create procedure  sp_find_all_user()
begin
select * from users;
end $$
delimiter ;

call sp_find_all_user();




delimiter $$
create procedure  sp_delete_user(in id_delete int)
begin
delete from users where id = id_delete;
end $$
delimiter ;

call sp_delete_user(?);



delimiter $$
create procedure  sp_update_user(in id_update int, name_update varchar(50),email_update varchar(50), country_update varchar(50))
begin
update users set `name` = name_update, email = email_update , country = country_update where id = id_update;
end $$
delimiter ;

call sp_update_user(?,?,?,?);

delimiter $$
create procedure  sp_add_user(in name_add varchar(50), email_add varchar(50), country_add varchar(50))
begin
insert into users(`name`, email, country) values(`name`= name_add, email = email_add, country = country_add);
end $$
delimiter ;

call sp_add_user(?,?,?);

delimiter $$
create procedure sp_find_by_id(in id_find int)
begin
select * from users where id = id_find;
end $$
delimiter ;

call sp_find_by_id(2);

