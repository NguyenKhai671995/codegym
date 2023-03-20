import { Injectable } from '@angular/core';
import {Category} from "../../model/product/Category";

@Injectable({
  providedIn: 'root'
})
export class CategoryService {
  categories: Category[] = [];

  constructor() {
    this.categories.push({id: 1, name: 'television'});
    this.categories.push({id: 2, name: 'phone'});
    this.categories.push({id: 3, name: 'car'});
  }

  findAll(): Category[] {
    return this.categories;
  }
}
