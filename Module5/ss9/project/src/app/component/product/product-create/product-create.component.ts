import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {Category} from "../../../model/product/Category";
import {ProductService} from "../../../service/productservice/product.service";
import {CategoryService} from "../../../service/productservice/category.service";


@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  categorys: Category[] = [];
  formUpdate: FormGroup;
  message: boolean = false;
  constructor(private categoriesService: CategoryService,
              private produceService: ProductService,
              private route: Router) {

  }

  ngOnInit(): void {
    this.categorys = this.categoriesService.findAll();
    this.buildForm()

  }

  buildForm() {
    this.formUpdate = new FormGroup(
      {
        id: new FormControl(),
        name: new FormControl('', [Validators.required, Validators.minLength(3)]),
        dateOfBirth: new FormControl(new Date().toISOString().slice(0, 10), [Validators.required]),
        email: new FormControl('', [Validators.required, Validators.pattern("^[\\w\\-.]+@([\\w-]+\\.)+[\\w-]{2,4}$")]),
        phone: new FormControl('', [Validators.required, Validators.pattern("^([0-9]{9})$")]),
        manufacture: new FormControl('', [Validators.required]),
        category: new FormControl('', [Validators.required])
      }
    )
  }

  saveCreate() {
    this.produceService.save(this.formUpdate.value).subscribe(value => {
      this.message = true;
    })
  }

  removeMessage() {
    this.message = false;
    this.route.navigateByUrl('product-list').then(result => {
      this.formUpdate.reset();
    })
  }
}
