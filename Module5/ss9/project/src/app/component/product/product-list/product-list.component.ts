import {Component, OnInit} from '@angular/core';
import {Product} from "../../../model/product/Product";
import {Category} from "../../../model/product/Category";
import {FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../../service/productservice/product.service";
import {Router} from "@angular/router";
import {CategoryService} from "../../../service/productservice/category.service";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  categorys: Category[] = [];
  produceSelect: Product = {};
  formSearch: FormGroup;
  config: any;
  message: boolean = false;

  constructor(private productService: ProductService,
              private route: Router,
              private categoriesService: CategoryService) {
  }

  ngOnInit(): void {
    this.loadPage('', '');
    this.removeMessage();
    this.formSearch = new FormGroup({
      name: new FormControl(""),
      category_id: new FormControl("")
    });
  }


  loadPage(name: string, category: string) {
    this.config = {
      itemsPerPage: 4,
      currentPage: 1,
      totalItems: this.products.length
    };
    this.productService.findAllByNameAndCategory(name, category).subscribe(value => {
      this.categorys = this.categoriesService.findAll();
      this.products = value;
      this.config = {
        itemsPerPage: 4,
        currentPage: 1,
        totalItems: this.products.length
      };
    });
  }
  wantDeleteIt(product: Product) {
    this.produceSelect = product;
  }

  deleteThis(id: number) {
    this.productService.deleteById(id).subscribe(data => {
      this.produceSelect = {};
      document.getElementById("deleteModal").click();
      this.message = true;
      this.loadPage('', '');
    })
  }

  searchByNameAndCategory() {
    this.loadPage(this.formSearch.value.name, this.formSearch.value.category_id)
  }

  pageChanged(event: number) {
    this.config.currentPage = event;
  }

  removeMessage() {
    this.message = false
  }

  resetPage() {
    this.formSearch.reset();
    this.ngOnInit();
  }
}
