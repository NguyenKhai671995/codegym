import { Injectable } from '@angular/core';
import {Division} from "../../model/employee/Division";

@Injectable({
  providedIn: 'root'
})
export class DivisonService {
  divisions : Division[] = [];
  constructor() {
    this.divisions.push({id: 1,name: 'Sale-Marketing'})
    this.divisions.push({id: 2,name: 'Hành chính'})
    this.divisions.push({id: 3,name: 'Phục vụ'})
    this.divisions.push({id: 4,name: 'Quản lý'})
  }
  findAll(): Division[]{
    return this.divisions;
  }
}
