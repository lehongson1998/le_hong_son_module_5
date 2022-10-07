import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Customer} from "../../model/customer/customer";
import {TypeCustomer} from "../../model/customer/type-customer";

const API_URL = `${environment.apiUrl}`
@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${API_URL}/customerRest`);
  }

  getAllTypeCustomer(): Observable<TypeCustomer[]> {
    return this.http.get<TypeCustomer[]>(`${API_URL}/customerRest/typeCustomer`)
  }

  saveCustomer(customer): Observable<Customer> {
    return this.http.post<Customer>(`${API_URL}/customerRest/create`, customer);
  }

  findByName(name, page): Observable<Customer[]> {
    return this.http.get<Customer[]>(API_URL + "/customerRest/search?page=" + page + "&name=" + name + "&address=" + name);
  }

  delete(id: Customer): Observable<Customer> {
    return this.http.delete<Customer>(`${API_URL}/customerRest/delete/${id}`)
  }
}
