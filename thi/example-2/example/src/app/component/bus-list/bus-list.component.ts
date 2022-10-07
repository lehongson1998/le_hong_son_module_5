import {Component, OnInit} from '@angular/core';
import {Product} from "../../model/product";
import {FormControl, FormGroup, Validators} from "@angular/forms";
import Swal from "sweetalert2";
import {BusService} from "../../service/bus.service";
import {HomeBus} from "../../model/home-bus";
import {TypeBus} from "../../model/type-bus";
import {Locations} from "../../model/locations";

@Component({
  selector: 'app-bus-list',
  templateUrl: './bus-list.component.html',
  styleUrls: ['./bus-list.component.css']
})
export class BusListComponent implements OnInit {
  busPage: HomeBus[] = [];
  name: string = "";
  typeBus = "";
  homeBusForm: FormGroup;
  typeBusList: TypeBus[] = [];
  locationList: Locations[] = [];
  page: number = 0;
  totalPage: number;
  deleteBus: HomeBus;
  now: Date;
  sort: string = "asc"

  constructor(private busService: BusService) {
    setInterval(() => {
      this.now = new Date()
    }, 1000)
  }

  ngOnInit(): void {
    this.onSearch();
  }

  onSearch() {
    this.page = 0;
    return this.busService.getAllHomeBus(this.name, this.typeBus, this.page).subscribe(products => {
      // @ts-ignore
      this.busPage = products.content;
      // @ts-ignore
      this.totalPage = this.busPage.totalPages;
    })
  }

  getForm() {
    this.busService.getAllTypeBus().subscribe(typeBus => {
      this.typeBusList = typeBus;
    });
    this.busService.getAllLocations().subscribe(locations => {
      this.locationList = locations;
    })
    this.homeBusForm = new FormGroup({
      id: new FormControl("", [Validators.required]),
      name: new FormControl("", [Validators.required]),
      typeBus: new FormGroup({
        id: new FormControl("", [Validators.required])
      }),
      goLocations: new FormGroup({
        id: new FormControl("", [Validators.required])
      }),
      backLocations: new FormGroup({
        id: new FormControl("", [Validators.required])
      }),
      phone: new FormControl("", [Validators.required]),
      email: new FormControl("", [Validators.required]),
      startTime: new FormControl("", [Validators.required]),
      endTime: new FormControl("", [Validators.required]),
    })
  }

  createProduct() {
    console.log(this.homeBusForm.value)
    this.busService.saveHomeBus(this.homeBusForm.value).subscribe(() => {
      Swal.fire("Ting Ting", "Create successfuly", "success");
      this.homeBusForm.reset();
      this.onSearch();
    }, error => {
      console.log(error);
    })
  }


  getFormEdit(id: string) {
    this.busService.getAllTypeBus().subscribe(typeBus => {
      this.typeBusList = typeBus;
    });
    this.busService.getAllLocations().subscribe(locations => {
      this.locationList = locations;
    })
    var bus: HomeBus;
    this.busService.findHomeBusById(id).subscribe(busHome => {
      bus = busHome;
      this.homeBusForm = new FormGroup({
        id: new FormControl(bus.id, [Validators.required]),
        name: new FormControl(bus.name, [Validators.required]),
        typeBus: new FormGroup({
          id: new FormControl(bus.typeBus.id, [Validators.required])
        }),
        goLocations: new FormGroup({
          id: new FormControl(bus.goLocations.id, [Validators.required])
        }),
        backLocations: new FormGroup({
          id: new FormControl(bus.backLocations.id, [Validators.required])
        }),
        phone: new FormControl(bus.phone, [Validators.required]),
        email: new FormControl(bus.email, [Validators.required]),
        startTime: new FormControl(bus.startTime, [Validators.required]),
        endTime: new FormControl(bus.endTime, [Validators.required]),
      })
    })
  }

  updateProduct() {
    console.log(this.homeBusForm.value)
    var bus = this.homeBusForm.value;
    this.busService.updateHomeBus(bus.id, this.homeBusForm.value).subscribe(() => {
      Swal.fire("Ting Ting", "update successfuly", "success");
      this.homeBusForm.reset();
      this.onSearch();
    }, error => {
      console.log(error);
    })
  }

  getDelete(id: string) {
    this.busService.findHomeBusById(id).subscribe(prod => {
      this.deleteBus = prod;
    })
  }

  productDelete() {
    this.busService.deleteHomeBus(this.deleteBus.id).subscribe(() => {
      Swal.fire("FBI WARNING", "DELETED", "warning");
      this.onSearch();
    }, error => {
      console.log(error);
    })
  }

  changeSort() {
    if (this.sort === "asc") {
      this.sort = "desc";
      this.onSearch();
    } else if (this.sort === "desc") {
      this.sort = "asc";
      this.onSearch();
    }
  }

  previous() {
    this.page = this.page - 1;
    return this.busService.getAllHomeBus(this.name, this.typeBus, this.page).subscribe(products => {
      // @ts-ignore
      this.busPage = products.content;
      // @ts-ignore
      this.totalPage = this.busPage.totalPages;
    })
  }
  next(){
    this.page = this.page + 1;
    return this.busService.getAllHomeBus(this.name, this.typeBus, this.page).subscribe(products => {
      // @ts-ignore
      this.busPage = products.content;
      // @ts-ignore
      this.totalPage = this.busPage.totalPages;
    })
  }
}
