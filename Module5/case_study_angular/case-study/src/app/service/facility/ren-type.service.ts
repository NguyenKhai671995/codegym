import { Injectable } from '@angular/core';
import {RentType} from "../../model/facility/RenType";

@Injectable({
  providedIn: 'root'
})
export class RenTypeService {
  renTypeis : RentType[] = [];
  constructor() {
    this.renTypeis.push({id:1,name:'Year'})
    this.renTypeis.push({id:2,name:'Moon'})
    this.renTypeis.push({id:3,name:'Day'})
    this.renTypeis.push({id:4,name:'Hour'})
  }
  findALl(): RentType[]{
    return this.renTypeis;
  }
}
