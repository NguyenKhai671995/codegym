use quan_ly_ban_hang;

insert into customer values 
(1,"Minh Quan",21),
(2,"Ngoc Oanh",32),
(3,"Hong Ha",40);

insert into orders (o_id,c_id,o_date) values 
(1,1,"2006-03-21"),
(2,2,"2006-03-23"),
(3,1,"2006-03-16");

insert into product values 
(1,"may giat",3),
(2,"tu lanh",5),
(3,"dieu hoa",7),
(4,"quat",1),
(5,"bep dien",2);

insert into order_detail values 
(1,1,3),
(1,3,7),
(1,4,2),
(2,1,1),
(3,1,8),
(2,5,4),
(2,3,3);


-- cau 1 --
SELECT 
    *
FROM
    orders;

-- cau 2 --
SELECT 
    c_name, p_name
FROM
    customer
        INNER JOIN
    orders ON orders.c_id = customer.c_id
        INNER JOIN
    order_detail ON order_detail.o_id = orders.o_id
        INNER JOIN
    product ON product.p_id = order_detail.p_id;

-- cau 3 -- 
SELECT 
    *
FROM
    customer
WHERE
    c_id NOT IN (SELECT 
            c_id
        FROM
            orders);

-- cau 4 -- 
SELECT 
    orders.o_id, o_date, (od_qty * p_price) o_total_price
FROM
    orders
        INNER JOIN
    order_detail ON order_detail.o_id = orders.o_id
        INNER JOIN
    product ON order_detail.p_id = product.p_id;