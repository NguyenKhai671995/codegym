import { Component, OnInit } from '@angular/core';
import {Employee} from "../../../model/employee/Employee";
import {Division} from "../../../model/employee/Division";
import {Education} from "../../../model/employee/Education";
import {PositionEmployee} from "../../../model/employee/PositionEmployee";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {EmployeeService} from "../../../service/employee/employee.service";
import {DivisonService} from "../../../service/employee/divison.service";
import {EducationService} from "../../../service/employee/education.service";
import {PositionEmployeeService} from "../../../service/employee/position-employee.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-employee-create',
  templateUrl: './employee-create.component.html',
  styleUrls: ['./employee-create.component.css']
})
export class EmployeeCreateComponent implements OnInit {
  // employees : Employee[]= [];
  divisions : Division[]= [];
  educations : Education[]= [];
  positionEmployees: PositionEmployee[]= [];
  formUpdate : FormGroup;
  constructor(private employeeService: EmployeeService,
              private divisionService: DivisonService,
              private educationService: EducationService,
              private positionEmployeeService: PositionEmployeeService,
              private route: Router) { }

  ngOnInit(): void {
    this.divisions = this.divisionService.findAll();
    this.educations = this.educationService.findAll();
    this.positionEmployees = this.positionEmployeeService.findAll();
    this.buildForm();
  }

   buildForm() {
     this.formUpdate = new FormGroup(
       {
         id : new FormControl(),
         name : new FormControl('',[Validators.required,Validators.minLength(3)]),
         birthday : new FormControl('',[Validators.required]),
         idCard : new FormControl('',[Validators.required]),
         salary : new FormControl('',[Validators.required]),
         phoneNumber : new FormControl('',[Validators.required,Validators.pattern("^([0-9]{9})$")]),
         email : new FormControl('',[Validators.required,Validators.pattern("^[\\w\\-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")]),
         address : new FormControl('',[Validators.required]),
         positionEmployee : new FormControl('',[Validators.required]),
         education : new FormControl('',[Validators.required]),
         division : new FormControl('',[Validators.required]),
       }
     )
  }
  saveCreate(){
    this.employeeService.save(this.formUpdate.value).subscribe(data =>{
      this.route.navigateByUrl('/employee/employee-list').then(result =>{
        this.formUpdate.reset();
      })
    })
  }
}
