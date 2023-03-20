import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SinhVien} from "../../model/final2/SinhVien";
import {Product} from "../../model/product/Product";

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  url = 'http://localhost:3000/SinhVien';
  constructor(private http: HttpClient) { }

  findAll():Observable<SinhVien[]>{
    return this.http.get<SinhVien[]>(this.url);
  }

  deleteById(id : number): Observable<SinhVien>{
    return this.http.delete(`${this.url}/${id}`)
  }
  findById(id :number){
    return this.http.get<SinhVien>(`${this.url}/${id}`)
  }
  updateById(value: SinhVien) {
    return this.http.put<SinhVien>(`${this.url}/${value.id}`,value);
  }
}
