import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductListComponent} from "./component/product/product-list/product-list.component";
import {ProductDetalComponent} from "./component/product/product-detal/product-detal.component";
import {HomeComponent} from "./component/layout/home/home.component";
import {BusListComponent} from "./component/bus-list/bus-list.component";
import {DetailComponent} from "./component/detail/detail.component";


const routes: Routes = [
  {path:"", component: HomeComponent},
  {path: "bus", component: BusListComponent},
  {path:"detail/:id", component: DetailComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
