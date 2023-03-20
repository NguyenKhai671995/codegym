import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../service/product.service";
import {Product} from "../model/product";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productFormEdit: FormGroup;
  producesSelect: Product = {};

  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private route: Router) {
    this.activatedRoute.paramMap.subscribe(data => {
      const id = parseInt(data.get('id'));
      this.productService.findById(id).subscribe(data => {
        this.producesSelect = data;
        console.log(data);
        this.productFormEdit = new FormGroup({
          id: new FormControl(data.id),
          name: new FormControl(data.name),
          price: new FormControl(data.price),
          description: new FormControl(data.description),
        });
      });
    });
  }

  ngOnInit(): void {
  }

  saveEdit() {
    this.productService.updateById(this.productFormEdit.value).subscribe(data => {
      this.route.navigateByUrl('list').then(result => {
        this.productFormEdit.reset();
        this.producesSelect = {};
      });
    });
  }
}
