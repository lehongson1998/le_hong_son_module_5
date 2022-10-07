import { Injectable } from '@angular/core';
import {environment} from "../../environments/environment";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Product} from "../model/product";
import {Category} from "../model/category";

const API_URL = `${environment.apiUrl}`;
@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private http: HttpClient) { }

  getAllProduct(name: string, categoryName: string, sort): Observable<Product[]> {
    return this.http.get<Product[]>(API_URL + "/products?name_like=" + name + "&category.name_like=" + categoryName + "&_sort=name&_order=" + sort);
  }

  getAllCategory(): Observable<Category[]> {
    return this.http.get<Category[]>(`${API_URL}/category`)
  }

  deleteProduct(id: number): Observable<Product> {
    return this.http.delete<Product>(`${API_URL}/products/${id}`)
  }

  saveProduct(product: Product): Observable<Product> {
    return this.http.post<Product>(`${API_URL}/products`, product);
  }

  findCategoryById(id: number): Observable<Category> {
    return this.http.get<Category>(`${API_URL}/category/${id}`)
  }

  updateProduct(id: number, product: Product): Observable<Product> {
    return this.http.patch<Product>(`${API_URL}/products/${id}`, product);
  }

  findProductById(id: number): Observable<Product> {
    return this.http.get<Product>(`${API_URL}/products/${id}`);
  }
}
