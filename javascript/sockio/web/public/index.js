// set up the top level application with support for angular routing
var app = angular.module('chatApp', ['ngRoute']);

// configure the routes
app.config(function($routeProvider, $locationProvider) {

	// this lets you creates routes without the '#' symbol
	$locationProvider.html5Mode({enabled: true, requireBase: false});

	$routeProvider.when('/register', {
		templateUrl: '/register.html'
	});
	$routeProvider.when('/chat', {
		templateUrl: '/chat.html'
	});
	$routeProvider.otherwise({
		templateUrl: '/register.html'
	});
});

var reginfo = {};

var User = function(name, role, room) {
	this.name = name;
	this.role = role;
	this.room = room;
}

app.controller('RegisterController', function($scope, $location, $http) {
	$scope.registered = false;

	$scope.register = function() {
		reginfo.user = {fname: $scope.fname, lname: $scope.lname, role: $scope.role, room: $scope.room};

		$scope.registered = true;
		reginfo.registered = true;
		if ($scope.role == 'teacher') {
			console.log('teacher....');
			reginfo.teacher = true;
		} else {
			console.log('student');
		}

		// post the data to the server for storage in the session
		$http.post('/storesession', JSON.stringify(reginfo.user)).
			success(function(data, status, headers, config) {
				console.log(data, status, headers, config);
			}).
			error(function(data, status, headers, config) {
				console.log('post bombed');
			});
		// navigate to the chat page
		$location.path('/chat');
	}
});

app.controller('ChatController', function($scope, $location) {
	$scope.messages = [];
	$scope.registered = reginfo.registered;
	$scope.user = reginfo.user;
	$scope.teacher = reginfo.teacher;

		if ($scope.role == 'teacher') {
			console.log('teacher....');
			$scope.teacher = true;
		} else {
			console.log('student');
		}

	$scope.sendMessage = function() {
		if (!$scope.message) return;
		$scope.messages.push($scope.message);
		$scope.message = '';
		$('#messageList')[0].scrollTop = $('#messageList')[0].scrollHeight;
	}

	$scope.students = studentsMath;
	$scope.studentConnected = function(student) {
		if (student.authenticated) return 'circle-green';
		return 'circle-black';
	}

	$scope.getClass = function(even) {
		if (even) return 'dgreym';
		return 'lgreym';
	}
});



