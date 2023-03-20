import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Customer} from "../../model/customer/Customer";
import {HttpClient} from "@angular/common/http";
import {Contract} from "../../model/contract/Contract";

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  url = 'http://localhost:8080/cus'

  constructor(private http: HttpClient) {
  }

  getAllCustomer(): Observable<getResponse> {
    return this.http.get<getResponse>(`${this.url}`);
  }

  deleteById(id: number): Observable<Customer> {
    return this.http.delete(`${this.url}/${id}`)
  }

  save(customer: Customer): Observable<Customer> {
    console.log(customer)
    return this.http.post(this.url, customer);
  }

  findById(id: number) {
    return this.http.get<Customer>(`${this.url}/${id}`);
  }

  updateById(customer: Customer) {
    console.log(`${this.url}/${customer.id}`);
    return this.http.put<Customer>(`${this.url}/${customer.id}`, customer);
  }
}
interface getResponse {
  content: Customer[];
  number: number;
  totalPages: number;
}
