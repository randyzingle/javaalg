var express = require('express');
var app = express();
var http = require('http').Server(express);
var io = require('socket.io')(http);
var session = require('express-session');
var redisstore = require('connect-redis')(session);
var redisio = require('socket.io-redis');
var redis = require('redis');
var config = require('./config');
var log = require('log4js').getLogger();

var redisClient = redis.createClient();

// store express session in redis instead of the local node server memory
app.use(session({
  secret: config.secret,
  resave: false,
  saveUninitialized: true,
  store: new redisstore({host: config.redisHost, port: config.redisPort})
}));

// store socket.io info in redis
io.adapter(redisio({host: config.redisHost, port: config.redisPort}));

// set up math namespace 
var math = io.of('/math');

math.on('connection', function(socket) {
	log.info('a user connected to the math namespace');

	// note io.sockets.connected has all the sockets connected to this server
	// io.sockets.connected[socket.id] will give you an individual socket

	// io.of('/math').connected contains all sockets in the math namespace

	socket.on('disconnect', function(data) {
		log.info('lost the user: ' + socket.name);
		// tell all the other users
		socket.broadcast.emit('math-message',socket.name + ' has left the building');
	});

	// send just to the connecting socket
	socket.emit('math-message', 'welcome to the math room...');

	socket.on('math-message', function(msg, done) {
		log.info(msg, socket.id);
		// when a message comes in on this socket, send to everyone in this namespace
		math.emit('math-message', users[socket.id] + ": " + msg);
		done('ack');
	});

	// rooms
	socket.on('list-rooms', function(msg) {
		// get associative array (keys are socket ids) of all sockets in a room
		// io.sockets.adapter.rooms -> all rooms and all clients that are in that room
		var rms = io.nsps['/math'].adapter.rooms;
		//log.info(rms);
		var rm = rms['Red'];
		log.info('Red: ' + JSON.stringify(rm));
		rm = rms['Green'];
		log.info('Green: ' + JSON.stringify(rm));
	});

	socket.on('register', function(msg) {
		log.info(msg);
		log.info('host: ' + config.host);
		var reg = JSON.parse(msg);
		var name = reg.name;
		// attach the name to the socket
		socket.name = name;
		users[socket.id] = name;
		// send message back JUST to connecting socket
		socket.emit('math-message','thank you for registering ' + name);
		log.info('sent message back to ' + name);
		// send a note to all users (except the initiating socket) 
		// that *name* has joined - BROADCAST sends to everyone BUT you
		var welcome = name + ' has joined the server';
		socket.broadcast.emit('math-message', welcome);
		log.info(welcome);
		// join the room the user selected - the room will be created if
		// it does not already exist
		var room = reg.room;
		socket.join(room);
		// send a message to everyone on that namespace in that room
		// this includes the intitiating socket
		math.to(room).emit('math-message', 'Everyone! ' + name + ' in the ' + room + ' room');
		// to leave a room call socket.leave(room)
		// send a message to everyone in a room *except* the initiating socket
		socket.in(room).broadcast.emit('math-message', 'Others! ' + name + ' in the ' + room + ' room');

	});
});

http.listen(config.port,function() {
	log.info(config.host+'-listening on *:'+config.port);
});
