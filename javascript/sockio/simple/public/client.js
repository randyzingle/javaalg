/*
* for debugging run the following in console (and refresh page) 
* localStorage.debug = 'socket.io:*' 
* turn off debugging:
* localStorage.debug = ''
*/
var app = angular.module('chatApp', []);
var socket = "";

app.run(function() {
	console.log('firing up sockets...');
	// Socket.io socket lifecycle
	// connecting, connected, disconnecting, disconnected
	// socket = io.connect('http://local.amplify.com/math');
	socket = io.connect('http://local.amplify.com:3000/math', {foo: "bar"});
	socket.on('connect', function() {
		console.log('connected...');
		// this is where the socket id is stored on the client - available after connect
		console.log(socket.io.engine.id);
	});
	socket.on('reconnecting', function() {
		console.log('trying to reconnect...');
	});
	socket.on('disconnect', function() {
		console.log('lost contact with server...');
	});
	// socket.on('connect_failed', function(){}) -> can not connect
	// socket.on('error', function() {}) -> error that can not be handled
	// by standard error types

	// user is typing functionality
	var $window = $(window);
	$window.keydown(function(event) {
		//console.log(event);
	});
});

app.controller('mainCtrl', function($scope) {
	$scope.registered = false;
	$scope.message = "";
	$scope.messages = [];
	$scope.messagebck;
	$scope.socketid = socket.id;

	$scope.register = function() {
		var reg = {name: $scope.name, role: $scope.role, room: $scope.room};
		reg = JSON.stringify(reg);
		socket.emit('register', reg);
		$scope.registered = true;
	}

	$scope.listRooms = function() {
		socket.emit('list-rooms', 'now!');
	}

	$scope.leaveRoom = function() {

	}

	$scope.joinRoom = function() {

	}

	socket.on('math-message', function(msg) {
		if ($scope.messages.length > 25) $scope.messages.shift();
		$scope.messages.push(msg);
		$scope.$apply();
		$('#messageList')[0].scrollTop = $('#messageList')[0].scrollHeight;
		//console.log(socket);
	}); 

	$scope.sendMessage = function() {
		socket.emit('math-message', $scope.message, function(msg) {
			if (msg === 'ack') {
				console.log('message was received!');
			}
			console.log(msg);
		});
		$scope.message="";
	}

	$scope.getClass = function(even) {
		if (even) return 'dgreym';
		return 'lgreym';
	}
});
