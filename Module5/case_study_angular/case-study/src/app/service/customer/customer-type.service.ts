import { Injectable } from '@angular/core';
import {CustomerType} from "../../model/customer/Customer-type";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CustomerTypeService {
  customerTypeis : CustomerType[] = []
  url = 'http://localhost:8080/type'
  constructor(private http: HttpClient) {

  }
  findAll(): Observable<CustomerType[]> {
    return this.http.get<CustomerType[]>(`${this.url}/cusType`);
  }



}
