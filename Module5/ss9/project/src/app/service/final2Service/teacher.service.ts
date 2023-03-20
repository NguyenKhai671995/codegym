import { Injectable } from '@angular/core';
import {TenNhom} from "../../model/final2/TenNhom";
import {GiaoVien} from "../../model/final2/GiaoVien";

@Injectable({
  providedIn: 'root'
})
export class TeacherService {
  techers: GiaoVien[] = [];
  constructor() {
    this.techers.push({id: 1,name: 'ChanhTV'})
    this.techers.push({id: 2,name: 'HaiTT'})
    this.techers.push({id: 3,name: 'TrungTD'})
  }
  findAll(): GiaoVien[]{
    return this.techers;
  }
}

