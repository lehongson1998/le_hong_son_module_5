import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from "@angular/common/http";

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ContractListComponent } from './component/contract/contract-list/contract-list.component';
import { ContractAddComponent } from './component/contract/contract-add/contract-add.component';
import { ContractEditComponent } from './component/contract/contract-edit/contract-edit.component';
import { ContractDeleteComponent } from './component/contract/contract-delete/contract-delete.component';
import { CustomerListComponent } from './component/customer/customer-list/customer-list.component';
import { CustomerEditComponent } from './component/customer/customer-edit/customer-edit.component';
import { CustomerDeleteComponent } from './component/customer/customer-delete/customer-delete.component';
import { EmployeeListComponent } from './component/employee/employee-list/employee-list.component';
import { EmployeeAddComponent } from './component/employee/employee-add/employee-add.component';
import { EmployeeEditComponent } from './component/employee/employee-edit/employee-edit.component';
import { EmployeeDeleteComponent } from './component/employee/employee-delete/employee-delete.component';
import { FacilityListComponent } from './component/facility/facility-list/facility-list.component';
import { FacilityAddComponent } from './component/facility/facility-add/facility-add.component';
import { FacilityEditComponent } from './component/facility/facility-edit/facility-edit.component';
import { FacilityDeleteComponent } from './component/facility/facility-delete/facility-delete.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {RouterModule} from "@angular/router";
import { HeaderComponent } from './component/layout/header/header.component';
import { FooterComponent } from './component/layout/footer/footer.component';
import { HomeComponent } from './component/layout/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    ContractListComponent,
    ContractAddComponent,
    ContractEditComponent,
    ContractDeleteComponent,
    CustomerListComponent,
    CustomerEditComponent,
    CustomerDeleteComponent,
    EmployeeListComponent,
    EmployeeAddComponent,
    EmployeeEditComponent,
    EmployeeDeleteComponent,
    FacilityListComponent,
    FacilityAddComponent,
    FacilityEditComponent,
    FacilityDeleteComponent,
    HeaderComponent,
    FooterComponent,
    HomeComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
