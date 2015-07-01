function greeter(person) {
    return "Hello, " + person;
}
//var user = "Jane User";
var user = ["bob", "sally"];
console.log(greeter(user));
function pgreeter(person) {
    return "Hello, " + person.firstName + " " + person.lastName;
}
var p = { firstName: "Baldur", lastName: "Dog" };
console.log(pgreeter(p));
var x = 3.1415;
var y = function (x) {
    return x * x;
};
console.log(y(x));
// static checking, statement completion, code refactoring
var w = function (x) {
    return x * x;
};
console.log(w(x));
// typescript support in IntelliJ IDEA:  JavaScript Support and Node.js plugins
var Greeter = (function () {
    function Greeter(message) {
        this.gr = message;
    }
    Greeter.prototype.greet = function () {
        return "Hello, " + this.gr;
    };
    return Greeter;
})();
var gg = new Greeter("Baldur king of dogs");
console.log(gg.greet());
