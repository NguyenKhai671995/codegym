import {Component, OnInit} from '@angular/core';
import {Customer} from "../../../model/customer/Customer";
import {CustomerType} from "../../../model/customer/Customer-type";
import {CustomerServiceService} from "../../../service/customer/customer-service.service";
import {CustomerTypeService} from "../../../service/customer/customer-type.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-customer-edit',
  templateUrl: './customer-edit.component.html',
  styleUrls: ['./customer-edit.component.css']
})
export class CustomerEditComponent implements OnInit {
  customerFormEdit: FormGroup;
  customerSelect: Customer = {customerType: {id: ""}};
  customerTypes: CustomerType[] = [];

  constructor(private customerService: CustomerServiceService,
              private customerTypeService: CustomerTypeService,
              private activatedRoute: ActivatedRoute,
              private route: Router) {
  }

  ngOnInit(): void {
    this.buildEditForm();
    this.customerTypeService.findAll().subscribe(data => {
      this.customerTypes = data;
    })
    this.activatedRoute.paramMap.subscribe(data => {
      const id = +(data.get('id'));
      this.customerService.findById(id).subscribe(value => {
        this.customerSelect = value;
        console.log(this.customerSelect);
        this.buildEditForm();
      })
    })
  }

  buildEditForm() {
    this.customerFormEdit = new FormGroup(
      {
        id: new FormControl(this.customerSelect.id),
        name: new FormControl(this.customerSelect.name, [Validators.required]),
        birthday: new FormControl(this.customerSelect.birthday),
        gender: new FormControl(this.customerSelect.gender),
        idCard: new FormControl(this.customerSelect.idCard),
        phone: new FormControl(this.customerSelect.phone),
        email: new FormControl(this.customerSelect.email),
        customerType: new FormControl(this.customerSelect.customerType.id),
        address: new FormControl(this.customerSelect.address),
        status: new FormControl("on")
      }
    )
  }

  saveEdit() {
    this.customerService.updateById(this.customerFormEdit.value).subscribe(data => {
      this.route.navigateByUrl('/customer/customer-list').then(result => {
        this.customerFormEdit.reset();
        this.customerSelect = {};
      })
    })

  }
}
