var app = angular.module('todo',['baldur']);

app.controller('NameCtrl', function($scope) {
	$scope.baldur = "Baldur Finnr Dogster";
	$scope.mymir = "Mymir Rafael Dogster";
	$scope.loadCode = function() {
		console.log("code loading....");
	};
});

var app2 = angular.module('baldur',[]);

app2.controller('BooCtrl', function($scope) {
	$scope.booName = "Gabriel1";
	$scope.loadCode = function() {
		console.log("boo load....");
	};
});

app2.controller('BaldurCtrl', function($scope) {
	$scope.kid1 = "Gabriel2";
});

