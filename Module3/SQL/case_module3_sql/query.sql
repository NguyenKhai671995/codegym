use furama;

-- cau2:

SELECT 
    *
FROM
    nhan_vien
WHERE
    ho_ten REGEXP '^[htk]'
        AND CHAR_LENGTH(ho_ten) <= 15;

-- cau 3:

SELECT 
    *
FROM
    khach_hang
WHERE
    (dia_chi REGEXP ('Đà Nẵng')
        OR dia_chi REGEXP ('Quảng Trị'))
        AND TIMESTAMPDIFF(YEAR, ngay_sinh, NOW()) BETWEEN 18 AND 50
;

-- cau 4:

SELECT 
    khach_hang.ma_khach_hang, ho_ten, COUNT(hop_dong.ma_khach_hang) count_ma_kh
FROM
    khach_hang
        INNER JOIN
    loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
        AND ten_loai_khach = 'Diamond'
        INNER JOIN
    hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
GROUP BY ho_ten
order by count_ma_kh;

-- cau 5:

SELECT 
    khach_hang.ma_khach_hang,
    khach_hang.ho_ten,
    loai_khach.ten_loai_khach,
    hop_dong.ma_hop_dong,
    dich_vu.ten_dich_vu,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc_hop_dong,
    (chi_phi_thue + sum(IFNULL(gia * so_luong, 0))) tong_tien
FROM
    khach_hang
        LEFT JOIN
    loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
        LEFT JOIN
    hop_dong ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        LEFT JOIN
    dich_vu ON dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY hop_dong.ma_khach_hang;

-- cau 6:

SELECT 
    dich_vu.ma_dich_vu,
    dich_vu.ten_dich_vu,
    dich_vu.dien_tich,
    dich_vu.chi_phi_thue,
    loai_dich_vu.ten_loai_dich_vu
FROM
    dich_vu
        INNER JOIN
    hop_dong ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        AND MONTH(ngay_lam_hop_dong) BETWEEN 4 AND 12
        INNER JOIN
    loai_dich_vu ON loai_dich_vu.ma_loai_dich_vu = dich_vu.ma_loai_dich_vu
GROUP BY dich_vu.ma_dich_vu
;


-- cau 7:

SELECT 
    dich_vu.ma_dich_vu,
    ten_dich_vu,
    dien_tich,
    so_nguoi_toi_da,
    chi_phi_thue,
    ten_loai_dich_vu
FROM
    loai_dich_vu
        INNER JOIN
    dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
        INNER JOIN
    hop_dong ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        AND YEAR(ngay_lam_hop_dong) = 2020
        AND dich_vu.ma_dich_vu NOT IN (SELECT 
            dich_vu.ma_dich_vu
        FROM
            dich_vu
                INNER JOIN
            hop_dong ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
                AND YEAR(ngay_lam_hop_dong) = 2021)
GROUP BY dich_vu.ma_dich_vu;

-- cau 8
-- cach 1
SELECT 
    ho_ten
FROM
    khach_hang
GROUP BY ho_ten;
-- cach 2
SELECT DISTINCT
    ho_ten
FROM
    khach_hang;
-- cach 3
-- chua nghi ra

SELECT 
    MONTH(ngay_lam_hop_dong) AS thang, COUNT(ma_khach_hang)
FROM
    hop_dong
WHERE
    YEAR(ngay_lam_hop_dong) = 2021
GROUP BY thang
ORDER BY thang;


-- cau 10:

SELECT 
    hop_dong.ma_hop_dong,
    ngay_lam_hop_dong,
    ngay_ket_thuc_hop_dong,
    tien_dat_coc,
    SUM(so_luong)
FROM
    hop_dong
        LEFT JOIN
    hop_dong_chi_tiet ON hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
        LEFT JOIN
    dich_vu_di_kem ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY hop_dong.ma_hop_dong
ORDER BY hop_dong.ma_hop_dong
;


-- cau 11:

SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,ten_dich_vu_di_kem
FROM
    dich_vu_di_kem
        INNER JOIN
    hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
        INNER JOIN
    hop_dong ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        INNER JOIN
    khach_hang ON hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
        INNER JOIN
    loai_khach ON khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
        AND ten_loai_khach = 'Diamond'
        AND (dia_chi REGEXP ('Vinh') OR dia_chi REGEXP ('Quảng Ngãi'));
        
-- cau 12        
        
SELECT 
    hop_dong.ma_hop_dong,
    nhan_vien.ho_ten AS ho_ten_nhan_vien,
    khach_hang.ho_ten AS ho_ten_khach_hang,
    khach_hang.so_dien_thoai,
    ten_dich_vu,
    tien_dat_coc,
    SUM(so_luong)
FROM
    hop_dong
    left join nhan_vien on hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
    left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
    left join khach_hang on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
    left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
    left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
       where (ngay_lam_hop_dong BETWEEN '2020-10-01'and '2020-12-30')
        and (ngay_lam_hop_dong NOT BETWEEN '2021-01-01' and '2021-06-30')
    GROUP by ma_hop_dong
    ;
use furama;

-- cau 13:

SELECT 
    dich_vu_di_kem.ma_dich_vu_di_kem,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    SUM(so_luong) AS tong_sl
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
GROUP BY ma_dich_vu_di_kem
HAVING tong_sl >= (SELECT 
        sum(so_luong)
    FROM
        hop_dong_chi_tiet
    GROUP BY ma_dich_vu_di_kem
    ORDER BY sum(so_luong) DESC
    LIMIT 1);

-- cau 14

SELECT 
    hop_dong.ma_hop_dong,
    loai_dich_vu.ten_loai_dich_vu,
    dich_vu_di_kem.ten_dich_vu_di_kem,
    COUNT(dich_vu_di_kem.ma_dich_vu_di_kem) AS so_lan_su_dung
FROM
    dich_vu_di_kem
        JOIN
    hop_dong_chi_tiet ON dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
        JOIN
    hop_dong ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
        JOIN
    dich_vu ON hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
        JOIN
    loai_dich_vu ON dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
GROUP BY ten_dich_vu_di_kem
HAVING so_lan_su_dung = 1
ORDER BY ma_hop_dong;


-- cau 15


SELECT 
    nhan_vien.ma_nhan_vien,
    nhan_vien.ho_ten,
    trinh_do.ten_trinh_do,
    bo_phan.ten_bo_phan,
    nhan_vien.so_dien_thoai,
    nhan_vien.dia_chi,
    COUNT(hop_dong.ma_nhan_vien) AS hd
FROM
    hop_dong
        JOIN
    nhan_vien ON hop_dong.ma_nhan_vien = nhan_vien.ma_nhan_vien
        JOIN
    trinh_do ON nhan_vien.ma_trinh_do = trinh_do.ma_trinh_do
        JOIN
    bo_phan ON nhan_vien.ma_bo_phan = bo_phan.ma_bo_phan
        AND YEAR(hop_dong.ngay_lam_hop_dong) BETWEEN 2020 AND 2021
GROUP BY hop_dong.ma_nhan_vien
HAVING hd < 3
ORDER BY ma_nhan_vien;

-- cau 16
use furama;
delete from nhan_vien 
where nhan_vien.ma_nhan_vien in (select nhan_vien.ma_nhan_vien from nhan_vien
join hop_dong on nhan_vien.ma_nhan_vien = hop_dong.ma_nhan_vien
and year(ngay_lam_hop_dong) between 2019 and 2021 );

-- cau 17
use furama;
UPDATE
	khach_hang
SET
	ma_loai_khach = 1
WHERE
	ma_khach_hang in(
    select tmp.ma_khach_hang from
(select distinct hop_dong.ma_khach_hang, (chi_phi_thue + sum(IFNULL(gia * so_luong, 0))) as tong_tien
from khach_hang join hop_dong  on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
join dich_vu on dich_vu.ma_dich_vu = hop_dong.ma_dich_vu
join hop_dong_chi_tiet on hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
join dich_vu_di_kem on dich_vu_di_kem.ma_dich_vu_di_kem = hop_dong_chi_tiet.ma_dich_vu_di_kem
where khach_hang.ma_loai_khach = 2
and year(hop_dong.ngay_lam_hop_dong) = 2021
group by hop_dong.ma_hop_dong
having tong_tien >1000000) tmp
);


-- cau 18
alter table khach_hang
add column trang_thai varchar(50) default "on" after dia_chi;

update khach_hang set khach_hang.trang_thai = "off"
WHERE
   khach_hang.ma_khach_hang IN (SELECT 
        ma_khach_hang
    FROM
        hop_dong
    WHERE
        YEAR(ngay_lam_hop_dong) < 2021);


-- DELETE
-- FROM
	-- khach_hang WHERE NOT EXISTS (
		-- SELECT
			-- *
		-- FROM
			-- hop_dong
		-- WHERE
			-- YEAR(ngay_lam_hop_dong) >= 2021
			-- AND hop_dong.ma_khach_hang = khach_hang.ma_khach_hang);

 -- SELECT DISTINCT ma_khach_hang FROM hop_dong WHERE YEAR(ngay_lam_hop_dong) >= 2021
 
 -- cau 19
 
 UPDATE dich_vu_di_kem 
SET 
    gia = gia * 2
WHERE
    ma_dich_vu_di_kem = (SELECT 
            ma_dich_vu_di_kem
        FROM
            hop_dong_chi_tiet
                INNER JOIN
            hop_dong ON hop_dong_chi_tiet.ma_hop_dong = hop_dong.ma_hop_dong
                AND YEAR(ngay_lam_hop_dong) = 2020
        GROUP BY ma_dich_vu_di_kem
        HAVING SUM(so_luong) > 10);

-- cau 20

SELECT ma_nhan_vien id,ho_ten,email,so_dien_thoai,ngay_sinh,dia_chi FROM furama.nhan_vien
union
SELECT ma_khach_hang id,ho_ten,email,so_dien_thoai,ngay_sinh,dia_chi FROM furama.khach_hang;




