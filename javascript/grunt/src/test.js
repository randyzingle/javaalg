
if (!window.bms) {
    window.bms = {};
}

(function(bms) {	
	'use strict';
	// Socket IO Stuff
	var socket = io.connect('http://localhost:3000');

	socket.on('chat message', function(msg) {
		
	});
	// END Socket IO Stuff

	bms.dog = 'baldur';
	var app = angular.module('baldur',[]);
	app.controller('MainCtrl', function($scope) {
		$scope.dog = bms.dog;
		$scope.europop = [
			{name: "Russia", population: 143455000},
			{name: "Germany", population: 80996685},
			{name: "France", population: 66475000},
			{name: "United Kingdom", population: 64097000},
			{name: "Italy", population: 59862000},
			{name: "Spain", population: 46610000},
			{name: "Poland", population: 38548000},
			{name: "Romania", population: 19858000}
		];

		$scope.message = 'hello';
		$scope.sendMessage = function() {
			socket.emit('chat message', $scope.message);
		};

		$scope.calcTotalPop = function() {
			var pop = 0;
			for (var i=0; i<$scope.europop.length; i++) {
				console.log($scope.europop[i].population);
				pop = pop + $scope.europop[i].population;
			}
			return pop;
		};

		$scope.totalPop = 0;
		if ($scope.totalPop === 0) {
			$scope.totalPop = $scope.calcTotalPop();	
		} 

		$scope.europercent = function(pop) {
			return pop / $scope.totalPop * 100;
		};

	});
})(window.bms);