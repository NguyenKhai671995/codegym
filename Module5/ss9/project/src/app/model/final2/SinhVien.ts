import {TenNhom} from "./TenNhom";
import {GiaoVien} from "./GiaoVien";

export interface SinhVien {
  id?: number;
  name?: string;
  tennhom?: TenNhom;
  tendetai?: string;
  giaovien?:GiaoVien;
  email?: string;
  sodienthoai?:number;
}
