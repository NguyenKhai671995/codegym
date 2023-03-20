import {Component, OnInit} from '@angular/core';
import {CustomerType} from "../../../model/customer/Customer-type";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerServiceService} from "../../../service/customer/customer-service.service";
import {CustomerTypeService} from "../../../service/customer/customer-type.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-create',
  templateUrl: './customer-create.component.html',
  styleUrls: ['./customer-create.component.css']
})
export class CustomerCreateComponent implements OnInit {
  customerTypes: CustomerType[] = [];
  formUpdate: FormGroup;

  constructor(private customerService: CustomerServiceService,
              private customerTypeService: CustomerTypeService,
              private route: Router) {}

  ngOnInit(): void {
    this.customerTypeService.findAll().subscribe(data =>{
      this.customerTypes = data ;
    });
    this.buildForm()
  }

  buildForm() {
    this.formUpdate = new FormGroup(
      {
        id: new FormControl(),
        name: new FormControl('', [Validators.required, Validators.minLength(3)]),
        birthday: new FormControl('', [Validators.required]),
        gender: new FormControl('', [Validators.required]),
        idCard: new FormControl('', [Validators.required]),
        phone: new FormControl('', [Validators.required, Validators.pattern("^(\\+84|0)\\d{9}$")]),
        email: new FormControl('', [Validators.required, Validators.pattern("^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")]),
        customerType: new FormControl('', [Validators.required]),
        address: new FormControl('', [Validators.required]),
        status: new FormControl('on', [Validators.required]),
      }
    )
  }

  saveCreate() {

    this.customerService.save(this.formUpdate.value).subscribe(value => {
      this.route.navigateByUrl('/customer/customer-list').then(result => {
        this.formUpdate.reset();
      })
    })
  }
}
