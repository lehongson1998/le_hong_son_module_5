import { Component, OnInit } from '@angular/core';
import {Product} from "../../model/product";
import {ActivatedRoute, ParamMap} from "@angular/router";
import {ProductService} from "../../service/product.service";
import {HomeBus} from "../../model/home-bus";
import {BusService} from "../../service/bus.service";

@Component({
  selector: 'app-detail',
  templateUrl: './detail.component.html',
  styleUrls: ['./detail.component.css']
})
export class DetailComponent implements OnInit {
  bus: HomeBus;

  constructor(private activatedRoute: ActivatedRoute, busService: BusService) {
    // activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
    //   let id = parseInt(paramMap.get("id"));
    //   busService.findHomeBusById(id).subscribe(pr => {
    //     this.bus = pr;
    //   })
    // })
  }

  ngOnInit(): void {
  }
}
