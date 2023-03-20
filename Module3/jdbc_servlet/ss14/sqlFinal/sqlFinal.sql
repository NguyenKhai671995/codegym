create database if not exists final_md3;
use final_md3;

create table trang_thai(
ma_trang_thai int,
ten_tran_thai varchar(50),
primary key (ma_trang_thai)
);
insert into trang_thai(ma_trang_thai,ten_tran_thai) values (1,'trong'),(2,'ha tang'),(3,'day du');

create table van_phong(
ma_van_phong int,
loai_phong varchar(50),
primary key (ma_van_phong)
);

insert into van_phong(ma_van_phong,loai_phong) values (1,'cho thue'),(2,'tron goi');


create table mat_bang(
ma_mb varchar(50),
dien_tich int,
trang_thai int,
tang int,
van_phong int,
gia int,
ngay_vao date,
ngay_het date,
primary key(ma_mb),
foreign key(trang_thai) references trang_thai(ma_trang_thai),
foreign key(van_phong) references van_phong(ma_van_phong)
);

insert into mat_bang(ma_mb,dien_tich,trang_thai,tang,van_phong,gia,ngay_vao,ngay_het)
values('MB001',100,1,2,1,30000,'2021-1-3','2022-1-1');
insert into mat_bang(ma_mb,dien_tich,trang_thai,tang,van_phong,gia,ngay_vao,ngay_het)
values('MB002',1003,2,4,2,3033000,'2019-11-3','2022-1-1');

insert into mat_bang(ma_mb,dien_tich,trang_thai,tang,van_phong,gia,ngay_vao,ngay_het)
values('MB003',1003,2,4,2,3033000,'2019-11-3','2022-1-1');

insert into mat_bang(ma_mb,dien_tich,trang_thai,tang,van_phong,gia,ngay_vao,ngay_het)
values('MB004',1003,2,4,2,3033000,'2019-11-3','2022-1-1');