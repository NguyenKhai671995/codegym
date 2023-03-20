import { Injectable } from '@angular/core';
import {PositionEmployee} from "../../model/employee/PositionEmployee";

@Injectable({
  providedIn: 'root'
})
export class PositionEmployeeService {
  positions : PositionEmployee[]= []
  constructor() {
    this.positions.push({id: 1,name: 'Lễ tân'})
    this.positions.push({id: 2,name: 'Phục vụ'})
    this.positions.push({id: 3,name: 'Chuyên viên'})
    this.positions.push({id: 4,name: 'Giám sát'})
    this.positions.push({id: 5,name: 'Quản lý'})
    this.positions.push({id: 6,name: 'Giám đốc'})
  }
  findAll():PositionEmployee[]{
    return this.positions;
  }
}
