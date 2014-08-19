(function() {

	var app = angular.module('drag', []);

	app.controller('DragCtrl', function($scope) {
		$scope.list1 = {title : 'Drag Me'};
		$scope.list2 = {};

	});

})();