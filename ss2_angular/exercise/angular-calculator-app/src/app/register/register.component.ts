import { Component, OnInit } from '@angular/core';
import {Country} from '../../model/country';
import {AbstractControl, AbstractFormGroupDirective, FormControl, FormGroup, Validators} from '@angular/forms';
import validate = WebAssembly.validate;
import {User} from '../../model/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  users: User[] = [];
  // @ts-ignore
  user: User = {};
  country: Country[] = [
    {id:1, name:"Việt Nam"},
    {id:2, name:'Trung Quốc'},
    {id:3, name:"Nhật Bản"},
    {id:4, name:"Đài Loan"},
    {id:5, name:"Lào"},
    {id:6, name:"Thái Lan"},
    {id:7, name:"Hàn Quốc"},
    {id:8, name:"Triều Tiên"},
    {id:9, name:"Hoa Kỳ"},
    {id:10, name:"Indonesia"},
    {id:11, name:"Ấn độ"}
    ];

  registerForm = new FormGroup({
    email: new FormControl("", [Validators.required, Validators.email]),
    password: new FormControl("", [Validators.required, Validators.minLength(6)]),
    confirmPassword: new FormControl("", [Validators.required, Validators.minLength(6)]),
    country: new FormControl("", [Validators.required]),
    age: new FormControl("", [Validators.required, Validators.min(18)]),
    gender: new FormControl("", [Validators.required]),
    phone: new FormControl("", [Validators.required, Validators.pattern("^\\+84\\d{9,10}$")])
  }, [this.validatePassword])
  constructor() { }

  ngOnInit(): void {
  }

  validatePassword(registerForm: AbstractControl){
    let tempPassword = registerForm.value.password;
    let tempConfirmPassword = registerForm.value.confirmPassword;
    if (tempConfirmPassword !== tempPassword){
      return {"invalidPassword": true}
    }
    return null;
  }

  onSubmit() {
    this.user = this.registerForm.value;
    this.users.push(this.user);
    alert("register success");
  }

  get email(){
    return this.registerForm.get("email");
  }
  get password(){
    return this.registerForm.get("password");
  }
  get confirmPassword(){
    return this.registerForm.get("confirmPassword");
  }
  get countrys(){
    return this.registerForm.get("country");
  }
  get age(){
    return this.registerForm.get("age");
  }
  get gender(){
    return this.registerForm.get("gender");
  }
  get phone(){
    return this.registerForm.get("phone");
  }
}
