import { Component, OnInit } from '@angular/core';
import {AbstractControl, FormControl, FormGroup, Validators} from '@angular/forms';
import {LoginUser} from '../../model/loginUser';
import {isFromDtsFile} from '@angular/compiler-cli/src/ngtsc/util/src/typescript';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginUser = new FormGroup({
    email: new FormControl("", [Validators.required]),
    password: new FormControl("", [Validators.required])
  }, [this.validateAcc]);

  logUser: LoginUser[] = [
    {email: "lhongson2909@gmail.com", password: "Avaicalon123"},
    {email: "tricho123@gmail.com", password: "Cailonma123"}
    ];

  constructor() {
  }

  ngOnInit(): void {
    console.log(this.logUser)
  }

  validateAcc(loginUser: AbstractControl){
    let acc = loginUser.value.email;
    let pass = loginUser.value.password;
    let count = 0;
    for (let i = 0; i < this.logUser.length; i++){
      if (acc !== this.logUser[i].email && pass !== this.logUser[i].password){
        count++;
      }
    }
    if (count != 0){
      return {"error": true}
    }
    return null;
  }

  onSubmit() {
    console.log(this.loginUser);
  }
}
