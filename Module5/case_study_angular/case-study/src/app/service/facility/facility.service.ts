import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

import {Facility} from "../../model/facility/Facility";
import {FacilityDTO} from "../../model/facility/FacilityDTO";


@Injectable({
  providedIn: 'root'
})
export class FacilityService {
  url = 'http://localhost:8080/fac'

  constructor(private http: HttpClient) { }

  findALl(): Observable<GetResponse>{
    return this.http.get<GetResponse>(`${this.url}`);
  }
  save(facility: Facility):Observable<Facility> {
    if(facility.id == null)   return this.http.post(this.url,facility);
    return this.http.put(`${this.url}/${facility.id}`,facility);
  }

  deleteById(id: number): Observable<Facility> {
     return this.http.delete(`${this.url}/${id}`)
  }
  findById(id:number){
    return this.http.get<Facility>(`${this.url}/${id}`)
  }

  updateById(value:Facility){
    console.log(value)
    return this.http.put<Facility>(`${this.url}/${value.id}`,value)
  }

  findByIdRest(id: number):Observable<any> {
    return this.http.get(`${this.url}/${id}`)
  }
}
interface GetResponse{
  content: Facility[];
  number: number;
  totalPages: number;
}
