import { Injectable } from '@angular/core';
import {Education} from "../../model/employee/Education";

@Injectable({
  providedIn: 'root'
})
export class EducationService {
  educations: Education[]=[]
  constructor() {
    this.educations.push({id: 1,name: 'Trung cấp'})
    this.educations.push({id: 2,name: 'Cao đẳng'})
    this.educations.push({id: 3,name: 'Đại học'})
    this.educations.push({id: 4,name: 'Sau đại học'})
  }

  findAll():Education[] {
    return this.educations;
  }
}
