import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Contract} from "../../../model/contract/Contract";
import {Customer} from "../../../model/customer/Customer";
import {Facility} from "../../../model/facility/Facility";
import {ActivatedRoute, Router} from "@angular/router";
import {ContractService} from "../../../service/contract/contract.service";
import {CustomerServiceService} from "../../../service/customer/customer-service.service";
import {FacilityService} from "../../../service/facility/facility.service";
import {FacilityDTO} from "../../../model/facility/FacilityDTO";
import {Employee} from "../../../model/employee/Employee";
import {EmployeeService} from "../../../service/employee/employee.service";

@Component({
  selector: 'app-contract-update',
  templateUrl: './contract-update.component.html',
  styleUrls: ['./contract-update.component.css']
})
export class ContractUpdateComponent implements OnInit {
  formUpdate : FormGroup;
  contractUpdate : Contract = {};
  customers : Customer[] = [];
  facilities : Facility[] = [] ;
  employs: Employee[] = [];
  constructor(private formBuilder: FormBuilder,
              private route : Router,
              private activatedRoute : ActivatedRoute,
              private contractService : ContractService,
              private customerService : CustomerServiceService,
              private facilityService : FacilityService,
              private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.employeeService.findALl().subscribe(x => {
      this.employs = x.content;
    })
    this.customerService.getAllCustomer().subscribe(x => {
      this.customers = x.content;
     })
    this.facilityService.findALl().subscribe(x => {
      this.facilities = x.content;
     })
    this.buildForm();
    if (this.route.url.includes("create")) return;
    this.activatedRoute.paramMap.subscribe(value => {
      const id = +value.get("id");
      this.contractService.findById(id).subscribe(data => {
        console.log(data);
        this.contractUpdate = data;
        this.buildForm();
       })
    })
  }

  private buildForm() {
    this.formUpdate = this.formBuilder.group({
      id: [this.contractUpdate.id],
      customer: [this.contractUpdate.customer == undefined ? '' : this.contractUpdate.customer.id],
      facility: [this.contractUpdate.facility == undefined ? '' : this.contractUpdate.facility.id],
      employee: [this.contractUpdate.employee == undefined ? '' : this.contractUpdate.employee.id],
      startDate: [this.contractUpdate.startDate ,[Validators.required]],
      endDate: [this.contractUpdate.endDate,[Validators.required]],
      deposit: [this.contractUpdate.deposit,[Validators.required]],
      status: ["1"],
    })
  }
  saveData() {
    this.contractService.save(this.formUpdate.value).subscribe(value => {
      this.route.navigateByUrl("/contract/contract-list").then(data => {
        this.formUpdate.reset();
        this.contractUpdate = {};
      })
    });
  }
}
