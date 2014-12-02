	
(function(ns) {
	// Socket.io socket lifecycle
	// connecting, connected, disconnecting, disconnected
	socket = io.connect('http://localhost:3000/chat');
	socket.on('connect', function() {
		console.log('connected...');
	});
	socket.on('reconnecting', function() {
		console.log('trying to reconnect...');
	});
	socket.on('disconnect', function() {
		console.log('lost contact with server...');
	});
}('math');