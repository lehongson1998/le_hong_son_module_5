import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {Customer} from "../../../model/customer/customer";

@Component({
  selector: 'app-customer-delete',
  templateUrl: './customer-delete.component.html',
  styleUrls: ['./customer-delete.component.css']
})
export class CustomerDeleteComponent implements OnInit {

  @Input() customerDelete: Customer;

  @Output() customers: EventEmitter<Customer> = new EventEmitter();

  constructor() { }

  ngOnInit(): void {
  }

  getCustomer(){
    this.customers.emit(this.customerDelete);
  }
}
