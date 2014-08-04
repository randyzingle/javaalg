var bms = {};

(function(bms) {
    var model = {
        user: 'Baldur',
        count: 0,
        data: [
            {name: 'Food', value: 'Pizza', likes: true},
            {name: 'Lodging', value: 'Cary', likes: true},
            {name: 'Dog', value: 'Butters', likes: false},
            {name: 'Province', value: 'Alberta', likes: false},
            {name: 'Dog', value: 'Mymir', likes: true}
        ]
    };

    var app = angular.module('boot',['item']);



    // angular.module has a run method that is executed once Angular has performed its initial setup
    // its used for one off tasks
    app.run(function($http, Items) {
        // make our service (Items) query for the data and set it on the model
        // this is asynchronous so we can't ask for the data in a return function
        Items.getItems().success(function(data) {

                model.data = data;
                console.log(data);
 

        });
        // above we have moved the data retrieval to the Items service
        //$http.get('data/baldurlikes.json').success(function(data) {
           // model.data = data;
        //});
    });

    app.filter('likesFilter', function() {
        return function(items, showLikes) {
            var tarr = [];
            angular.forEach(items, function(item) {
                if (!item.likes || showLikes) {
                    tarr.push(item);
                };
            });
            return tarr;
        };
    });


    // create a directive
    app.directive('bluediv', function() {
        return {
            restrict: 'E',
            templateUrl: 'directives/bluediv.html',
            replace: true,
            link: function(scope, elem, attr) {
                elem.bind('click', function() {
                    elem.css('background-color', 'olive');
                });
                elem.bind('mouseover', function() {
                    elem.css('cursor', 'pointer');
                });
            }

        };
    });

    app.controller('TableCtrl', function(Items, $scope, $http, $compile) {
        $scope.tdata = model;
        $scope.recount = function() {
            var cnt = 0;
            angular.forEach($scope.tdata.data, function(d) {
                if(!d.likes) {
                    cnt++;
                }
            });
            $scope.tdata.count = cnt;
            return cnt;
        };

        $scope.logMe = function(event) {
            console.log(event);
            console.log(event.currentTarget.innerText);
            event.currentTarget.innerText = 
                'clientX: ' + event.clientX + ', clientY: ' + event.clientY +
                'offsetx: ' + event.offsetX + ', offsetY: ' + event.offsetY;
        };

        $scope.warning = function() {
            return $scope.recount() < 3 ? 'label-success' : 'label-warning';
        };

        $scope.tdata.count = $scope.recount();

        $scope.addNewRow = function() {
            var newItem = {name: $scope.name, value: $scope.value, likes: false};
            $scope.tdata.data.push(newItem);
        };

        // dynamically load some HTML that has model data and compile with angular
        $scope.loadSubDiv1 = function() {
            $http.get('data/subdiv1.html').success(function(data) {
                angular.element('#subdivx').contents().remove();
                var e = angular.element('#subdivx').append(data);
                $compile(e.contents())($scope);
            });
        };
                
        $scope.loadSubDiv2 = function() {
            angular.element('#subdivx').contents().remove();
            var e = angular.element('#subdivx').append('<bluediv></bluediv>');
            $compile(e.contents())($scope);

        };


    });

})(bms);
