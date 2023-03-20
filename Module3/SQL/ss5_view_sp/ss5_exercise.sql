create database ss5;
use ss5;

create table product(
Id int primary key auto_increment,
product_code varchar(50),
product_name varchar(50),
product_price double,
product_amount int,
product_description varchar(50),
product_status int
);
insert into product (product_code,product_name,product_price,product_amount,product_description,product_status) values
('1','A',1,1,'A',1),
('2','B',2,2,'B',2),
('3','C',3,3,'C',3);

-- Tạo Unique Index trên bảng Products (sử dụng cột productCode để tạo chỉ mục)
ALTER TABLE product add INDEX idx_product_code(product_code);

-- Tạo Composite Index trên bảng Products (sử dụng 2 cột productName và productPrice)
ALTER TABLE product add INDEX composite_idx_name_price(product_name, product_price);

-- Sử dụng câu lệnh EXPLAIN để biết được câu lệnh SQL của bạn thực thi như nào
EXPLAIN SELECT * from product WHERE product_code = '1';

-- Tạo view lấy về các thông tin: productCode, productName, productPrice, productStatus từ bảng products.
CREATE view check_view 
as
SELECT product_code, product_name, product_price, product_status FROM product;
SELECT * from check_view;

-- Tiến hành sửa đổi view
update check_view set product_name = 'product_name2' WHERE product_code = '1';

-- Tiến hành xoá view
drop view check_view;


-- Tạo store procedure lấy tất cả thông tin của tất cả các sản phẩm trong bảng product
DELIMITER $$
CREATE PROCEDURE sp_getAll()
BEGIN
	SELECT * from product;
END $$
DELIMITER ;
call sp_getAll();

-- Tạo store procedure thêm một sản phẩm mới
DELIMITER $$
CREATE PROCEDURE sp_add_product(sp_code VARCHAR(50), sp_name VARCHAR(50), sp_price DOUBLE)
BEGIN
INSERT INTO product (product_code, product_name, product_price) VALUE(sp_code, sp_name, sp_price);
END $$
DELIMITER ;
CALL sp_add_product('codegym', 'student1', 123);


-- Tạo store procedure sửa thông tin sản phẩm theo id
DELIMITER $$
create procedure sp_edit_by_id(sp_id int,sp_code varchar(50),sp_name varchar(50),sp_price double, sp_amount int, sp_description varchar(50), sp_status int)
begin
update product
set product_code = sp_code, product_name = sp_name, product_price = sp_price, product_amount=sp_amount, product_description = sp_description, product_status = sp_status
where Id = sp_id;
end$$
DELIMITER ;
call sp_edit_by_id(1,'sss','ddd',23,12,'yes',10);

-- Tạo store procedure xoá sản phẩm theo id
DELIMITER $$
CREATE PROCEDURE sp_delete_by_id(sp_id int)
BEGIN
DELETE FROM product WHERE Id= sp_id;
END$$
DELIMITER ;
CALL sp_delete_by_id(1);
