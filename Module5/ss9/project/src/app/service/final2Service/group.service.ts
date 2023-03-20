import { Injectable } from '@angular/core';
import {TenNhom} from "../../model/final2/TenNhom";

@Injectable({
  providedIn: 'root'
})
export class GroupService {
  groups: TenNhom[] = [];
  constructor() {
    this.groups.push({id: 1,name: 'nhom1'})
    this.groups.push({id: 2,name: 'nhom2'})
    this.groups.push({id: 3,name: 'nhom3'})
  }
  findAll(): TenNhom[]{
    return this.groups;
  }
}
