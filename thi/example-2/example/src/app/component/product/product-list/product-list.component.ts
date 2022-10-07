import {Component, DoCheck, OnChanges, OnInit} from '@angular/core';
import {ProductService} from "../../../service/product.service";
import {Product} from "../../../model/product";
import {FormControl, FormGroup} from "@angular/forms";
import Swal from 'sweetalert2';
import {Category} from "../../../model/category";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit{
  productPage: Product[] = [];
  name: string = "";
  categoryName = "";
  productForm: FormGroup;
  categoryList: Category[] = [];
  p: number = 1;
  deleteProduct: Product;
  now: Date;
  sort: string = "desc"

  constructor(private productService: ProductService) {
    setInterval(()=>{
      this.now = new Date()
    },1000)
  }

  ngOnInit(): void {
      this.onSearch();
  }

  onSearch() {
    return this.productService.getAllProduct(this.name, this.categoryName, this.sort).subscribe(products => {
      this.productPage = products;
    })
  }

  getForm() {
    this.productService.getAllCategory().subscribe(categorys => {
      this.categoryList = categorys;
    })
    this.productForm = new FormGroup({
      name: new FormControl(),
      price: new FormControl(),
      produce: new FormControl(),
      category: new FormGroup({
        id: new FormControl()
      })
    })
  }

  createProduct() {
    console.log(this.productForm.value)
    var product = this.productForm.value;
    this.productService.findCategoryById(product.category.id).subscribe(category => {
      product.category = category;
      this.productService.saveProduct(this.productForm.value).subscribe(() => {
        Swal.fire("Ting Ting", "Create successfuly", "success");
        this.productForm.reset();
        this.onSearch();
      }, error => {
        console.log(error);
      })
    })
  }


  getFormEdit(id: number) {
    var product1: Product;
    this.productService.getAllCategory().subscribe(categorys => {
      this.categoryList = categorys;
    })
    this.productService.findProductById(id).subscribe(product => {
      product1 = product;
      this.productForm = new FormGroup({
        id: new FormControl(product1.id),
        name: new FormControl(product1.name),
        price: new FormControl(product1.price),
        produce: new FormControl(product1.produce),
        category: new FormGroup({
          id: new FormControl(product1.category.id)
        })
      })
    })
  }

  updateProduct(){
    var product = this.productForm.value;
    this.productService.findCategoryById(product.category.id).subscribe(category => {
      product.category = category;
      this.productService.updateProduct(product.id, product).subscribe(() => {
        Swal.fire("Ting Ting", "UPDATE SUCCESSFULY", "success");
        this.productForm.reset();
        this.onSearch();
      }, error => {
        console.log(error);
      })
    })
  }

  getDelete(id: number) {
    this.productService.findProductById(id).subscribe(prod => {
      this.deleteProduct = prod;
    })
  }

  productDelete() {
    this.productService.deleteProduct(this.deleteProduct.id).subscribe(() => {
      Swal.fire("FBI WARNING", "DELETED", "warning");
      this.onSearch();
    }, error => {
      console.log(error);
    })
  }

  changeSort() {
    if (this.sort.includes("asc")){
      return this.sort = "desc";
    }else if(this.sort.includes("desc")){
      return this.sort = "asc";
    }
  }
}
