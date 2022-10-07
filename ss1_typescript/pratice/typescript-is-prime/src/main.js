"use strict";
exports.__esModule = true;
var retangle_1 = require("./retangle");
function isPrime(number) {
    var isPrime = true;
    if (number < 2) {
        isPrime = false;
    }
    else if (number > 2) {
        for (var i = 2; i < Math.sqrt(number); i++) {
            if (number % i == 0) {
                isPrime = false;
                break;
            }
        }
    }
    return isPrime;
}
var array = [1, 5, 9, 2, 6, 15, 19, 35, 51, 53];
var sum = 0;
for (var _i = 0, array_1 = array; _i < array_1.length; _i++) {
    var number = array_1[_i];
    if (isPrime(number)) {
        sum += number;
    }
}
// console.log("tổng các số nguyên tố trong mảng trên là:" + sum);
var rectange = new retangle_1.Retangle(5, 5, 10, 20);
console.log(rectange.toString());
console.log(rectange.area());
