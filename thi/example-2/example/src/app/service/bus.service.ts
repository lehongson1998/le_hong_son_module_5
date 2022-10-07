import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {HomeBus} from "../model/home-bus";
import {TypeBus} from "../model/type-bus";
import {Locations} from "../model/locations";

const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class BusService {

  constructor(private http: HttpClient) { }

  getAllHomeBus(name: string, typeBusName: string, page: number): Observable<HomeBus[]> {
    return this.http.get<HomeBus[]>(API_URL + "/bus?name=" + name + "&page=" + page);
  }

  getAllTypeBus(): Observable<TypeBus[]> {
    return this.http.get<TypeBus[]>(`${API_URL}/typeBus`)
  }

  deleteHomeBus(id: string): Observable<HomeBus> {
    return this.http.delete<HomeBus>(`${API_URL}/bus/${id}`)
  }

  saveHomeBus(homeBus: HomeBus): Observable<HomeBus> {
    return this.http.post<HomeBus>(`${API_URL}/bus`, homeBus);
  }

  findTypeBusById(id: number): Observable<TypeBus> {
    return this.http.get<TypeBus>(`${API_URL}/typeBus/${id}`)
  }

  updateHomeBus(id: number, homeBus: HomeBus): Observable<HomeBus> {
    return this.http.patch<HomeBus>(`${API_URL}/bus`, homeBus);
  }

  findHomeBusById(id: string): Observable<HomeBus> {
    return this.http.get<HomeBus>(`${API_URL}/bus/${id}`);
  }

  getAllLocations(): Observable<Locations[]> {
    return this.http.get<Locations[]>(`${API_URL}/locations`)
  }

  findLocationsById(id: number): Observable<Locations> {
    return this.http.get<Locations>(`${API_URL}/locations/${id}`)
  }
}
