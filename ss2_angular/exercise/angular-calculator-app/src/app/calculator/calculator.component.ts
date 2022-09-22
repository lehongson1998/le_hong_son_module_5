import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  numberA: number;
  numberB: number;
  operator: string;

  calculate(numberA:number, numberB:number, operator:string){
    switch (operator) {
      case "+":
        return (numberA/1 + numberB/1);
        break;
      case "-":
        return numberA - numberB;
        break;
      case "*":
        return numberA * numberB;
        break;
      case "/":
        return numberA / numberB;
        break;
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}
