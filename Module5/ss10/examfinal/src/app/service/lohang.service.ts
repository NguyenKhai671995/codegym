import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {SanPham} from "../model/SanPham";
import {HttpClient} from "@angular/common/http";
import {LoHang} from "../model/LoHang";

@Injectable({
  providedIn: 'root'
})
export class LohangService {
  url = "http://localhost:3000/LoHang"
  constructor(private http: HttpClient) {}
  findAll(sanpham:string):Observable<LoHang[]>{
    return this.http.get<LoHang[]>(`${this.url}?_sort=id,malohang &_order=asc,desc&sanpham_like=${sanpham}`)
  }
  save(lohang: LoHang):Observable<LoHang> {
    return this.http.post(this.url,lohang)
  }

  findById(id:number){
    console.log(`${this.url}/${id}`);
    return this.http.get<LoHang>(`${this.url}/${id}`)
  }
  deleteById(id: number): Observable<LoHang> {
    return this.http.delete(`${this.url}/${id}`)
  }
}
