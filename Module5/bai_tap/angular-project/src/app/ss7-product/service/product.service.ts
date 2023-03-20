import { Injectable } from '@angular/core';
import {Product} from '../model/product';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  URL = 'http://localhost:3000/product';
  constructor(private httpClient: HttpClient) { }


  getAll(): Observable<any> {
    return this.httpClient.get(this.URL);
  }

  saveProduct(product): Observable<Product> {
    return this.httpClient.post(this.URL, product);
  }

  findById(id: number) {
    return this.httpClient.get<Product>(`${this.URL}/${id}`);
  }
  updateById(value: Product ) {
    return this.httpClient.put<Product>(`${this.URL}/${value.id}`, value);
  }
}
