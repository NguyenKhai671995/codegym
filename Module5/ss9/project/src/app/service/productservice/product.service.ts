import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../../model/product/Product";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  url = 'http://localhost:3000/product';

  constructor(private http: HttpClient) { }
  findAllByNameAndCategory(name: string, category_id: string): Observable<Product[]> {
    return this.http.get<Product[]>(`${this.url}?_sort=id,name &_order=asc,desc&name_like=${name}&category_like=${category_id}`);
  }

  deleteById(id: number): Observable<Product> {
    return this.http.delete(`${this.url}/${id}`)
  }

  save(product: Product): Observable<Product> {
    return this.http.post(this.url,product);
  }

  findById(id: number) {
    return this.http.get<Product>(`${this.url}/${id}`);
  }

  updateById(value: Product) {
    return this.http.put<Product>(`${this.url}/${value.id}`,value);
  }
}
