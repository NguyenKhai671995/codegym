import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Contract} from "../../model/contract/Contract";


@Injectable({
  providedIn: 'root'
})
export class ContractService {
  url = 'http://localhost:8080/cont'

  constructor(private http: HttpClient) { }

  getAllContract(): Observable<GetResponse> {
    return this.http.get<GetResponse>(`${this.url}`);
  }

  save(contract: Contract):Observable<Contract> {
    console.log(contract)
    if(contract.id == null) return this.http.post(this.url,contract);
    return this.http.put(`${this.url}/${contract.id}`,contract);
  }

  findById(id:number){
    console.log(`${this.url}/${id}`);
    return this.http.get<Contract>(`${this.url}/${id}`)
  }

  deleteById(id: number): Observable<Contract> {
    return this.http.delete(`${this.url}/${id}`)
  }
}

interface GetResponse{
  content: Contract[];
  number: number;
  totalPages: number;
}
