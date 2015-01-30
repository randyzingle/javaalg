
(function() {

	'use strict';

	var app = angular.module('baldur', []);

	app.controller('BodyCtrl', function($scope) {
		$scope.message = {};
		$scope.message.body = "";
		$scope.message.maxlength = 150; // maximum length of message
		$scope.message.warnlength = 10; // warn user when they have 10 char or less left

		$scope.remaining = function() {
			return $scope.message.maxlength - $scope.message.body.length;
		};

		$scope.send = function() {
			if ($scope.message.body === null || $scope.message.body === "") return;
			console.log('sending:');
			console.log($scope.message.body);
		};

		$scope.clear = function() {
			console.log('clear');
			$scope.message.body = "";
		};

	});

})();