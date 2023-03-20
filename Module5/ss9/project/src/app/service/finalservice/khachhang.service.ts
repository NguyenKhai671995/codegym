import {Injectable} from '@angular/core';
import {Observable} from "rxjs";
import {Khachhang} from "../../model/final/Khachhang";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class KhachhangService {
  url = 'http://localhost:3000/khachhang'

  constructor(private http: HttpClient) {
  }

  findAll(): Observable<Khachhang[]> {
    return this.http.get<Khachhang[]>(this.url);
  }

  save(khachhang: Khachhang): Observable<Khachhang> {
    console.log(khachhang)
    return this.http.post(this.url, khachhang);
  }

  findById(id: number): Observable<Khachhang> {
    return this.http.get<Khachhang>(`${this.url}/${id}`);
  }

  updateById(khachHangFormEdit: Khachhang): Observable<Khachhang> {
    return this.http.put<Khachhang>(`${this.url}/${khachHangFormEdit.id}`, khachHangFormEdit);
  }
}
