import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, ParamMap} from "@angular/router";
import {Product} from "../../../model/product";
import {ProductService} from "../../../service/product.service";

@Component({
  selector: 'app-product-detal',
  templateUrl: './product-detal.component.html',
  styleUrls: ['./product-detal.component.css']
})
export class ProductDetalComponent implements OnInit {
  product: Product;

  constructor(private activatedRoute: ActivatedRoute, productService: ProductService) {
    activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      let id = parseInt(paramMap.get("id"));
      productService.findProductById(id).subscribe(pr => {
        this.product = pr;
      })
    })
  }

  ngOnInit(): void {
  }

}
