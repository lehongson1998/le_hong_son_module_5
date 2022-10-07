import { Component, OnInit } from '@angular/core';
import {FacilityServiceService} from "../../../service/facility/facility-service.service";
import {Facility} from "../../../model/facility/facility";

@Component({
  selector: 'app-facility-list',
  templateUrl: './facility-list.component.html',
  styleUrls: ['./facility-list.component.css']
})
export class FacilityListComponent implements OnInit {
  facilityList: Facility[] = [];

  constructor(private facilityServiceService: FacilityServiceService) {
  }

  ngOnInit(): void {
    this.getAll()
  }

  getAll(){
    return this.facilityServiceService.getAll().subscribe(facility => {
      this.facilityList = facility;
      console.log(this.facilityList)
    })
  }

}
