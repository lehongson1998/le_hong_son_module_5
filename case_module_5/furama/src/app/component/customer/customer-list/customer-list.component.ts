import {Component, OnInit} from '@angular/core';
import {Customer} from "../../../model/customer/customer";
import {CustomerServiceService} from "../../../service/customer/customer-service.service";
import {FormControl, FormGroup, NgForm} from "@angular/forms";
import {TypeCustomer} from "../../../model/customer/type-customer";
import {Router} from "@angular/router";

@Component({
  selector: 'app-customer-list',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.css']
})
export class CustomerListComponent implements OnInit {
  customerList: Customer[] = [];
  name: string = "";
  page: number = 0;
  totalPage: number;

  customer: FormGroup = new FormGroup({
    name: new FormControl(),
    dateOfBirth: new FormControl(),
    idCard: new FormControl(),
    phoneNumber: new FormControl(),
    email: new FormControl(),
    address: new FormControl(),
    typeCustomer: new FormGroup({
      typeCustomerId: new FormControl()
    })
  });

  typeCustomers: TypeCustomer[] = [];
  customers: Customer;

  constructor(private customerServiceService: CustomerServiceService, private router: Router) {
    customerServiceService.getAllTypeCustomer().subscribe(typeCustomer => {
      this.typeCustomers = typeCustomer;
    })
  }

  ngOnInit(): void {
    this.onSearch();
  }

  submit() {
    const customer = this.customer.value;
    return this.customerServiceService.saveCustomer(customer).subscribe(() => {
      this.customer.reset();
      this.router.navigate([""])
      alert("thêm mới thành công nhé");
      this.onSearch();
    }, error => {
      console.log(error);
    })
  }

  onSearch() {
    this.page = 0;
    return this.customerServiceService.findByName(this.name, this.page).subscribe(cus => {
      // @ts-ignore
      this.customerList = cus.content;
      // @ts-ignore
      this.totalPage = cus.totalPages;
      console.log(this.totalPage)
    })
  }

  previous() {
    this.page = this.page - 1;
    return this.customerServiceService.findByName(this.name, this.page).subscribe(cus => {
      // @ts-ignore
      this.customerList = cus.content;
      // @ts-ignore
      this.totalPage = cus.totalPages;
    })
  }

  next() {
    this.page = this.page + 1;
    return this.customerServiceService.findByName(this.name, this.page).subscribe(cus => {
      // @ts-ignore
      this.customerList = cus.content;
      // @ts-ignore
      this.totalPage = cus.totalPages;
    })
  }

  deleteCustomer(event: Customer) {
    return this.customerServiceService.delete(event).subscribe(() => {
      alert("xóa thành công");
      this.onSearch();
    }, error => {
      console.log(error);
    })
  }

  setCustomer(customer: Customer) {
    return this.customers = customer;
    console.log(this.customers);
  }
}
