use furama;
-- cau 21


create view v_nhan_vien  as
select ho_ten , dia_chi
from nhan_vien nv
join hop_dong hd on hd.ma_nhan_vien = nv.ma_nhan_vien
and ngay_lam_hop_dong = '2021-04-25'
and dia_chi regexp 'Đà Nẵng';

-- cau 22

update v_nhan_vien
set dia_chi = 'Liên Chiểu';


-- cau 23

DELIMITER $$
CREATE PROCEDURE sp_xoa_khach_hang (sp_ma_khach_hang int)
BEGIN
DELETE FROM khach_hang WHERE ma_khach_hang = sp_ma_khach_hang;
END$$
DELIMITER ;


