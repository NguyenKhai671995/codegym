import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {Sotietkiem} from "../../model/final/Sotietkiem";

@Injectable({
  providedIn: 'root'
})
export class SotietkiemService {
  url = 'http://localhost:3000/sotietkiem';
  constructor(private http:HttpClient) { }


  findAll():Observable<Sotietkiem[]>{
    return this.http.get<Sotietkiem[]>(this.url)
  }
  findById(id :number): Observable<Sotietkiem>{
    return this.http.get<Sotietkiem>(`${this.url}/${id}`)
  }

  deleteById(id: number): Observable<Sotietkiem> {
    return this.http.delete(`${this.url}/${id}`);
  }


  save(sotietkiem: Sotietkiem):Observable<Sotietkiem> {
    return this.http.post(this.url,sotietkiem);
  }
  updateById(value: Sotietkiem) {
    return this.http.put<Sotietkiem>(`${this.url}/${value.id}`,value);
  }
}
