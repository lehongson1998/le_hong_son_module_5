import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {LoginUser} from '../../model/loginUser';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUser = new FormGroup({
    email: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required])
  }, [this.validateAccount]);

  logUser: LoginUser[] = [
    {email: "lhongson2909@gmail.com", password: "Avaicalon123"},
    {email: "tricho123@gmail.com", password: "Cailonma123"}
    ];

  constructor() {
  }

  ngOnInit(): void {
  }

  validateAccount(loginUser: AbstractControl){
    let userName = loginUser.value.email;
    let password = loginUser.value.password;
    if (userName !== password){
      return {"valon": true}
    }
    return null;
  }

  onSubmit() {
    console.log(this.loginUser);
  }

  get email(){
    return this.loginUser.get("email");
  }

  get password(){
    return this.loginUser.get("password")
  }
}
