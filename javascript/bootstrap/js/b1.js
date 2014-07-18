(function() {

    var app = angular.module('boot', []);

    var gems = [
        {name: 'Baldur', description: 'Large belligerent male labradoodle'},
        {name: 'Mymir', description: 'Kindly female labradoodle'},
        {name: 'Butters', description: 'Large belligerent male labrador'}
    ];

    app.controller('StoreController', function() {
        this.products = gems;
    });

    app.controller('TabController', function() {
        this.tab = 1;
        this.setTab = function(tab) {
            this.tab = tab;
        }                  ;
        this.isSet = function(tab) {
            return this.tab === tab;
        };
    });

    app.controller('UnController', function() {
        this.mydata = 'Hello from the UnController';
    });

    app.controller('ExScopeController', function($scope) {
        $scope.mydata = 'This is explicitely attached to the $scope';
    });

})();