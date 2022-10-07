import {Country} from './country';

export interface User {
  email: string;
  password: string;
  confirmPassword: string;
  country: Country;
  age: number;
  gender: string;
  phone: string;
}
