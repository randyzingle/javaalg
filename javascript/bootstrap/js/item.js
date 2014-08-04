(function() {
    var app = angular.module('item',[]);

    // create a service that loads the data for the items Baldur likes/doesn't like
    app.factory('Items', function($http) {
        var items = {};
        items.getItems = function() {
            return $http.get('data/baldurlikes.json');
        };
        return items;
    });
})();