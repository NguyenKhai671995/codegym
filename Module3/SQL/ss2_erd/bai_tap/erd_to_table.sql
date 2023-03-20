create database if not exists erd;

use erd;

create table phieu_xuat(
so_px int primary key,
ngay_xuat date
);

create table vat_tu(
ma_vt int primary key,
ten_vt varchar(50)
);

create table chi_tiet_phieu_xuat(
dg_xuat varchar(50),
sl_xuat int,
so_px int,
ma_vt int,
foreign key (so_px) references phieu_xuat (so_px),
foreign key (ma_vt) references vat_tu (ma_vt)
);

create table phieu_nhap(
so_pn int primary key,
ngay_nhap date
);

create table chi_tiet_phieu_nhap(
dg_nhap varchar(50),
so_luong int,
so_pn int,
ma_vt int,
foreign key (so_pn) references phieu_nhap(so_pn),
foreign key (ma_vt) references vat_tu(ma_vt)

);

create table nha_lien_he(
sdt int primary key,
ten_nha_lien_he varchar(50)

);

create table nha_cc (
ma_ncc int primary key,
ten_ncc varchar(50),
dia_chi varchar(50),
sdt int,
foreign key (sdt) references nha_lien_he(sdt)
);

create table don_dh(
so_dh int primary key ,
ngay_dh date,
ma_ncc int,
foreign key (ma_ncc) references nha_cc(ma_ncc)

);
create table chi_tiet_dh_vt(
ma_vt int,
so_dh int,
so_luong int,
foreign key (ma_vt) references vat_tu (ma_vt),
foreign key (so_dh) references don_dh(so_dh)
);












