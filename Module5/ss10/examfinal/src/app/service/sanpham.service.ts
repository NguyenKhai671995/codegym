import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {SanPham} from "../model/SanPham";

@Injectable({
  providedIn: 'root'
})
export class SanphamService {
  url = "http://localhost:3000/SanPham"

  constructor(private http: HttpClient){ }

  findAll():Observable<SanPham[]>{
    return this.http.get<SanPham[]>(`${this.url}`)
  }

  searchByName(name: String):Observable<SanPham[]>{
  return this.http.get<SanPham[]>(`${this.url}?name_like=${name}`)
  }
}
