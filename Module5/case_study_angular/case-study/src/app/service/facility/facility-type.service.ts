import { Injectable } from '@angular/core';
import {RentType} from "../../model/facility/RenType";
import {FacilityType} from "../../model/facility/FacilityType";

@Injectable({
  providedIn: 'root'
})
export class FacilityTypeService {
  facilities : FacilityType[] = [];
  constructor() {
    this.facilities.push({id:1,name:'Villa'})
    this.facilities.push({id:2,name:'House'})
    this.facilities.push({id:3,name:'Room'})

  }
  findALl(): RentType[]{
    return this.facilities;
  }

}
