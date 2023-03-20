import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employee} from "../../model/employee/Employee";
import {Customer} from "../../model/customer/Customer";
import {Facility} from "../../model/facility/Facility";

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  url = 'http://localhost:8080/emp'
  constructor(private http: HttpClient) { }

  findALl(): Observable<GetResponse>{
    return this.http.get<GetResponse>(`${this.url}`);
  }

  save(employee: Employee):Observable<Employee[]> {
    // @ts-ignore
    return this.http.post(this.url,employee);
  }

  deleteById(id: number): Observable<Employee> {
    // @ts-ignore
    return this.http.delete(`${this.url}/${id}`)
  }
  findById(id:number){
    return this.http.get<Employee>(`${this.url}/${id}`)
  }

  updateById(value:Employee){
    console.log(value)
    return this.http.put<Employee>(`${this.url}/${value.id}`,value)
  }
}
interface GetResponse{
  content: Employee[];
  number: number;
  totalPages: number;
}
