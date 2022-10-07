import {TypeCustomer} from "./type-customer";

export interface Customer {
  id:number;
  name:string;
  dateOfBirth:string;
  idCard:string;
  phoneNumber:string;
  email:string;
  address:string;
  typeCustomer:TypeCustomer;
}
