import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {Product} from "../../../model/product/Product";
import {Category} from "../../../model/product/Category";
import {ProductService} from "../../../service/productservice/product.service";
import {CategoryService} from "../../../service/productservice/category.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productFormEdit: FormGroup;
  productSelect: Product = {};
  categorys: Category[] = [];
  message: boolean = false;

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router,
              private categoriesService: CategoryService) {

  }

  ngOnInit(): void {
    this.buildForm();
    this.categorys = this.categoriesService.findAll()
    this.activatedRoute.paramMap.subscribe(data => {
      const id = +(data.get('id'));
      this.productService.findById(id).subscribe(value => {
        this.productSelect = value;
        this.buildForm();
      })
    })
  }

  buildForm() {
    this.productFormEdit = new FormGroup({
      id: new FormControl(this.productSelect.id),
      name: new FormControl(this.productSelect.name),
      dateOfBirth: new FormControl(this.productSelect.dateOfBirth),
      email: new FormControl(this.productSelect.email),
      phone: new FormControl(this.productSelect.phone),
      manufacture: new FormControl(this.productSelect.manufacture),
      category: new FormControl(this.productSelect.category),
    })
  }

  saveEdit() {
    this.productService.updateById(this.productFormEdit.value).subscribe(value => {
      this.message = true;
    });
  }


  removeMessage() {
    this.router.navigateByUrl("").then(result => {
      this.productFormEdit.reset();
      this.productSelect = {};
    })
  }
}
