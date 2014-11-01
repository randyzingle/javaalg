/**
 * Created by rzingle on 6/27/14.
 */
(function() {
    var products = [];
    var app = angular.module('boot', []);
    app.controller('FormController', function() {
        this.age = 48;
    });

    app.controller('ReviewController', function() {
        this.review = {};

        this.addReview = function(product) {
            products.push(product);
        };
    });
})();