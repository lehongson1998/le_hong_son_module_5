import { Injectable } from '@angular/core';
import {environment} from "../../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Facility} from "../../model/facility/facility";
import {FacilityType} from "../../model/facility/facility-type";
import {RentType} from "../../model/facility/rent-type";

const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class FacilityServiceService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Facility[]> {
    return this.http.get<Facility[]>(`${API_URL}/facilityRest`);
  }

  getFacilityType(): Observable<FacilityType[]> {
    return this.http.get<FacilityType[]>(`${API_URL}/facilityRest/facilityType`);
  }

  getRentType(): Observable<RentType[]> {
    return this.http.get<RentType[]>(`${API_URL}/facilityRest/rentType`)
  }

  saveFacility(facility): Observable<Facility> {
    return this.http.post<Facility>(`${API_URL}/facilityRest/create`, facility);
  }
}
