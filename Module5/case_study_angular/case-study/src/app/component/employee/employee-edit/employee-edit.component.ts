import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup,Validators} from "@angular/forms";
import {Employee} from "../../../model/employee/Employee";
import {Division} from "../../../model/employee/Division";
import {Education} from "../../../model/employee/Education";
import {PositionEmployee} from "../../../model/employee/PositionEmployee";
import {EmployeeService} from "../../../service/employee/employee.service";
import {DivisonService} from "../../../service/employee/divison.service";
import {EducationService} from "../../../service/employee/education.service";
import {PositionEmployeeService} from "../../../service/employee/position-employee.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent implements OnInit {
  employeeEditForm : FormGroup;
  employeeSelect: Employee = {};
  divisions: Division[] = [];
  educations: Education[] = [];
  positionEmployees: PositionEmployee[] = [];


  constructor(private employeeService: EmployeeService,
              private divisionService: DivisonService,
              private educationService: EducationService,
              private positionEmployeeService: PositionEmployeeService,
              private route: Router,
              private activatedRoute: ActivatedRoute,) {
  }
z
  ngOnInit(): void {
    this.buildEditForm();
    this.divisions = this.divisionService.findAll()
    this.educations = this.educationService.findAll()
    this.positionEmployees = this.positionEmployeeService.findAll()
    this.activatedRoute.paramMap.subscribe(data => {
      const id = +(data.get('id'));
      console.log(id)
      this.employeeService.findById(id).subscribe(data => {
        this.employeeSelect = data;
        this.buildEditForm();
        console.log(id);
      })
    })
  }

  buildEditForm() {
    this.employeeEditForm = new FormGroup(
      {
        id: new FormControl(this.employeeSelect.id),
        name: new FormControl(this.employeeSelect.name),
        birthday: new FormControl(this.employeeSelect.birthday),
        idCard: new FormControl(this.employeeSelect.idCard),
        salary: new FormControl(this.employeeSelect.salary),
        phoneNumber: new FormControl(this.employeeSelect.phoneNumber),
        email: new FormControl(this.employeeSelect.email),
        address: new FormControl(this.employeeSelect.address),
        positionEmployee: new FormControl(this.employeeSelect.positionEmployee),
        education: new FormControl(this.employeeSelect.education),
        division: new FormControl(this.employeeSelect.division),
      }
    )
  }


  saveEdit() {
    // @ts-ignore
    this.employeeService.updateById(this.employeeEditForm.value).subscribe(data => {
      this.route.navigateByUrl('employee/employee-list').then(result => {
        this.employeeEditForm.reset();
        // @ts-ignore
        this.employeeSelect = {};
      })
    })
  }


}
