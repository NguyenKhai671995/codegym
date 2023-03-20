import { Component, OnInit } from '@angular/core';
import {Contract} from "../../../model/contract/Contract";
import {Customer} from "../../../model/customer/Customer";
import {Facility} from "../../../model/facility/Facility";
import {ContractService} from "../../../service/contract/contract.service";
import {CustomerServiceService} from "../../../service/customer/customer-service.service";
import {FacilityService} from "../../../service/facility/facility.service";
import {FacilityDTO} from "../../../model/facility/FacilityDTO";
import {EmployeeService} from "../../../service/employee/employee.service";

@Component({
  selector: 'app-contract-list',
  templateUrl: './contract-list.component.html',
  styleUrls: ['./contract-list.component.css']
})
export class ContractListComponent implements OnInit {
  contracts: Contract[] = [];
  customers: Customer[]= [];
  facilities: Facility[]= [];
  contractDelete : Contract = {};


  constructor(private contractService: ContractService,
              private customerService: CustomerServiceService,
              private facilityService: FacilityService,
              private employeeService: EmployeeService) { }

  ngOnInit(): void {
   this.customerService.getAllCustomer().subscribe(x => {
     this.customers = x.content;
    })
    this.facilityService.findALl().subscribe(x => {
      this.facilities = x.content;
     })
    this.contractService.getAllContract().subscribe(x => {
      this.contracts = x.content;
      console.log(x);
    })
    this.employeeService.findALl().subscribe(x => {
      this.customers = x.content;
    })
  }

  wantDeleteIt(check: Contract) {
    this.contractDelete = check

  }

  deleteThis(id: number) {
    this.contractService.deleteById(id).subscribe(data => {
      this.contractDelete = {};
      alert("delete ok");
      document.getElementById("deleteModal").click();
      this.ngOnInit();
    })
  }
}
