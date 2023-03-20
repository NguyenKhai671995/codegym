import { Component, OnInit } from '@angular/core';
import {Customer} from "../../../model/customer/Customer";
import {CustomerServiceService} from "../../../service/customer/customer-service.service";
import {CustomerTypeService} from "../../../service/customer/customer-type.service";
import {CustomerType} from "../../../model/customer/Customer-type";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customers: Customer[] = [];
  customerSelect : Customer = {};
  customerTypes : CustomerType[] = [];


  constructor(private customerService: CustomerServiceService,
              private customerTypeService : CustomerTypeService) { }

  ngOnInit(): void {
    this.findALl();
  }


  private findALl(){
    this.customerTypeService.findAll().subscribe(data =>{
      this.customerTypes = data ;
    })
    this.customerService.getAllCustomer().subscribe(data => {
      this.customers = data.content;
      console.log(data)
    })
  }

  deleteThis(id: number) {
    this.customerService.deleteById(id).subscribe(value => {
      document.getElementById("deleteModal").click();
      this.ngOnInit();
    })
  }

  wantDeleteIt(customer: Customer) {
    this.customerSelect = customer;
  }
}
