import {SanPham} from "./SanPham";

export interface LoHang {
  id?: number;
  malohang?: string;
  sanpham?: SanPham;
  soluong?: number;
  ngaynhap?: Date;
  ngaysanxuat?: Date;
  ngayhet?: Date;
}
