import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  p:number = 1;
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
    Swal.fire("lồn", "vãi cặc", "warning");
    this.getAll();
  }

  getAll() {
    return this.productService.getAll().subscribe(products => {
      this.products = products;
    })
  }

  product: Product = {}

  setProduct(product: Product) {
    this.product =product;
  }

  deleteProduct(event: any) {
    this.productService.deleteProduct(event.id).subscribe(() => {
       this.getAll();
    });
  }
}
