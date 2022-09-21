function fibonaci(number) {
    if (number == 0) {
        return 0;
    }
    if (number <= 1) {
        return 1;
    }
    return (fibonaci(number - 1) + fibonaci(number - 2));
}
var sum = 0;
for (var i = 0; i < 20; i++) {
    sum += fibonaci(i);
    console.log(i + 1 + ": " + fibonaci(i));
}
console.log("tổng 10 số fibonaci đầu tiên là: " + sum);
console.log(fibonaci(5));
