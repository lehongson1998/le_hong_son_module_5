import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductListComponent } from './component/product/product-list/product-list.component';
import { ProductDeleteComponent } from './component/product/product-delete/product-delete.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {NgxPaginationModule} from "ngx-pagination";
import { ProductDetalComponent } from './component/product/product-detal/product-detal.component';
import { HeaderComponent } from './component/layout/header/header.component';
import { FooterComponent } from './component/layout/footer/footer.component';
import { HomeComponent } from './component/layout/home/home.component';
import { BusListComponent } from './component/bus-list/bus-list.component';
import { DetailComponent } from './component/detail/detail.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductListComponent,
    ProductDeleteComponent,
    ProductDetalComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent,
    BusListComponent,
    DetailComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
