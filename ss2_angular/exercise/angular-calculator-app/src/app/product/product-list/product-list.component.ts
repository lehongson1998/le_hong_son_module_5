import { Component, OnInit } from '@angular/core';
import {ProductService} from '../../service/product.service';
import {Product} from '../../model/product';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] = [];
  constructor(private productService: ProductService) { }

  ngOnInit(): void {
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
