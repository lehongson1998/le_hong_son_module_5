import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  componentUrl: string = "";
  urlArray: string[] = [
    "bus"
  ]

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  load() {
    for (let i = 0; i < this.urlArray.length; i++){
      if (this.urlArray[i].includes(this.componentUrl)){
        this.componentUrl = this.urlArray[i];
      }
    }
    this.router.navigate(["/" + this.componentUrl])
  }
}
