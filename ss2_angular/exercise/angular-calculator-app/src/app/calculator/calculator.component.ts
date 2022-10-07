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

  calculate(numberA: number, numberB: number, operator: string) : string{
    switch (operator) {
      case '+':
        return (numberA / 1 + numberB / 1) + '';
      case '-':
        return numberA - numberB + '';
      case '*':
        return numberA * numberB + '';
      case '/':
        if (numberB == 0) {
          return 'can not div by zero';
        }
        return numberA / numberB + '';
    }
  }

  constructor() { }

  ngOnInit(): void {
  }

}
