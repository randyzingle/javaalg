function greeter(person: string[]) {
    return "Hello, " + person;
}

//var user = "Jane User";
var user = ["bob", "sally"];

console.log(greeter(user));

interface Person {
  firstName: string;
  lastName: string;
}

function pgreeter(person: Person) {
  return "Hello, " + person.firstName + " " + person.lastName;
}

var p = {firstName: "Baldur", lastName: "Dog"};

console.log(pgreeter(p));

var x = 3.1415;

var y = function(x) {
  return x*x;
}

console.log(y(x));

// static checking, statement completion, code refactoring
var w = function(x: number) {
  return x * x;
}

console.log(w(x));

// typescript support in IntelliJ IDEA:  JavaScript Support and Node.js plugins
class Greeter {
    gr: string;
    constructor(message: string) {
        this.gr = message;
    }
    greet() {
        return "Hello, " + this.gr;
    }
}

var gg = new Greeter("Baldur king of dogs");
console.log(gg.greet());