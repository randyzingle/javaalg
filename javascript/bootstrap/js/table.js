(function() {
    var app = angular.module('boot',[]);

    app.controller('TableCtrl', function($scope) {
        $scope.tdata = {
            user: 'Baldur Zingle',
            count: 0,
            data: [
                {name: 'food', value: 'Pizza', likes: true},
                {name: 'lodging', value: 'Cary', likes: true},
                {name: 'dog', value: 'Butters', likes: false},
                {name: 'dog', value: 'Mymir', likes: true}
            ]
        };
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

        $scope.tdata.count = $scope.recount();
    });

})();
