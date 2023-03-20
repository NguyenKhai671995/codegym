import {Component, OnInit} from '@angular/core';
import {Employee} from "../../../model/employee/Employee";
import {Division} from "../../../model/employee/Division";
import {Education} from "../../../model/employee/Education";
import {PositionEmployee} from "../../../model/employee/PositionEmployee";
import {EmployeeService} from "../../../service/employee/employee.service";
import {DivisonService} from "../../../service/employee/divison.service";
import {EducationService} from "../../../service/employee/education.service";
import {PositionEmployeeService} from "../../../service/employee/position-employee.service";

@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Employee[] = [];
  divisions: Division[] = [];
  educations: Education[] = [];
  positionEmployees: PositionEmployee[] = [];
  employeeSelect: Employee = {};
  constructor(private employeeService: EmployeeService,
              private divisionService: DivisonService,
              private educationService: EducationService,
              private positionEmployeeService: PositionEmployeeService) {
  }

  ngOnInit(): void {
    this.findALl();
  }

  private findALl() {
    this.divisions = this.divisionService.findAll();
    this.educations = this.educationService.findAll();
    this.positionEmployees = this.positionEmployeeService.findAll();
    this.employeeService.findALl().subscribe(data => {
      console.log(data)
      this.employees = data.content;
    })
  }

  wantDeleteIt(employee: Employee) {
    this.employeeSelect = employee;
  }

  deleteThis(id: number) {
    this.employeeService.deleteById(id).subscribe(data => {
      this.employeeSelect = {};
      document.getElementById("deleteModal").click();
      this.ngOnInit();
    })
  }
}
