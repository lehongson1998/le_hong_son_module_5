import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {FacilityServiceService} from "../../../service/facility/facility-service.service";
import {FacilityType} from "../../../model/facility/facility-type";
import {RentType} from "../../../model/facility/rent-type";

@Component({
  selector: 'app-facility-add',
  templateUrl: './facility-add.component.html',
  styleUrls: ['./facility-add.component.css']
})
export class FacilityAddComponent implements OnInit {

  facility: FormGroup;
  facilityType: FacilityType[] = [];
  rentType: RentType[] = [];

  constructor(private facilityServiceService: FacilityServiceService) {
    this.facility = new FormGroup({
      name: new FormControl(),
      cost: new FormControl(),
      maxPeople: new FormControl(),
      area: new FormControl(),
      standardRoom: new FormControl(),
      descriptionOtherConvenience: new FormControl(),
      poolArea: new FormControl(),
      numberOfFloors: new FormControl(),
      facilityFree: new FormControl(),
      facilityId: new FormGroup({
        id: new FormControl()
      }),
      rentType: new FormGroup({
        id: new FormControl()
      })
    })
  }

  ngOnInit(): void {
    this.getFacilityType();
    this.getRentType();
  }

  saveFacility(){
    console.log(this.facility.value)
    const facility = this.facility.value;
    this.facilityServiceService.saveFacility(facility).subscribe(() => {
      this.facility.reset();
      alert('Tạo thành công');
    }, e => {
      console.log(e);
    });
  }

  getFacilityType(){
    return this.facilityServiceService.getFacilityType().subscribe(facilityType => {
       this.facilityType = facilityType;
       console.log(this.facilityType);
    })
  }

  private getRentType() {
    return this.facilityServiceService.getRentType().subscribe(rentType => {
      this.rentType = rentType;
      console.log(this.rentType);
    })
  }
}
