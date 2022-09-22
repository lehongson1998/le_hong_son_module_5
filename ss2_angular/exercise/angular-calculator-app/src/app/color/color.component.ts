import { Component, OnInit } from '@angular/core';
import {Color} from "../../model/Color";

@Component({
  selector: 'app-color',
  templateUrl: './color.component.html',
  styleUrls: ['./color.component.css']
})
export class ColorComponent implements OnInit {
  color: Color = {
    id:1,
    color:"#00ff86"
  }

  constructor() { }

  ngOnInit(): void {
  }

  changeColor(target: any) {
    this.color.color = target.value;
  }
}
