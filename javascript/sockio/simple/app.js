/*
* run with debugging: DEBUG=socket.io:* node app.js
*/

var express = require('express');
var app = express();
var path = require('path');
var http = require('http').Server(app);
var io = require('socket.io')(http);
var cookieParser = require('cookie-parser');
var session = require('express-session');
var RedisStore = require('connect-redis')(session);
var config = require('./config');
var cookie = require('cookie');
var redis = require('redis');
var redisSession = new RedisStore({host: config.redisHost, port: config.redisPort});
var redisAdapter = require('socket.io-redis');

//app.use(express.static(path.join(__dirname, 'public')));
app.use(cookieParser());
app.use(session({
  secret: config.secret,
  resave: false,
  saveUninitialized: true,
  store: new RedisStore(
  	{host: config.redisHost, port: config.redisPort})
}));

app.get('/', function(req,res) {
	console.log(__dirname + '/public/index.html');
	res.cookie('dogcookie','baldur is a dog');
	res.sendFile(__dirname + '/public/index.html');
});
// use the above path for / and the below paths for everything else
app.use(function(req, res, next) {
	if(req.session.pageCount) {
		req.session.pageCount++;
	} else {
		req.session.pageCount = 1;
	}
	console.log('pageCount: ' + req.session.pageCount);
	next(); // this will forward to the next app.use
});
app.use(express.static(path.join(__dirname, 'public')));

var users = {};

// use redis for socket.io application state
io.adapter(redisAdapter({host: config.redisHost, port: config.redisPort}));

// set up math namespace 
var math = io.of('/math');

// set up authenticate for the math namespace
var socketAuth = function(socket, next) {
	// socket io passes in handshake data (including cookies) when the connection
	// is being established
	var handshakeData = socket.request;
	// get all the cookies, one will be the signed connect.sid cookie
	var parsedCookie = cookie.parse(handshakeData.headers.cookie);
	console.log(parsedCookie);
	// decrypt cookie
	var sid = cookieParser.signedCookie(parsedCookie['connect.sid'], config.secret);
	console.log('-->' + sid);
	console.log('-->' + parsedCookie['connect.sid']);

	redisSession.get(sid, function(err, session) {
		console.log(session);
		if (session && session.isAuthenticated) {
			socket.user = session.user;
			socket.sid = sid;
			return next();
		}
	});
	 
	// return next() without anything and the middleware chain will continue
	// return next(Error) and the chain will stop
	return next(); 
	//return next(new Error('User not Authorized'));
};

// use the auth function
math.use(socketAuth);

math.on('connection', function(socket) {
	console.log('a user connected to the math namespace');

	// note io.sockets.connected has all the sockets connected to this server
	// io.sockets.connected[socket.id] will give you an individual socket

	// io.of('/math').connected contains all sockets in the math namespace

	socket.on('disconnect', function(data) {
		console.log('lost the user: ' + socket.name);
		// tell all the other users
		socket.broadcast.emit('math-message',socket.name + ' has left the building');
	});

	// send just to the connecting socket
	socket.emit('math-message', 'welcome to the math room...');

	socket.on('math-message', function(msg, done) {
		console.log(msg, socket.id);
		// when a message comes in on this socket, send to everyone in this namespace
		math.emit('math-message', users[socket.id] + ": " + msg);
		done('ack');
	});

	// rooms
	socket.on('list-rooms', function(msg) {
		// get associative array (keys are socket ids) of all sockets in a room
		// io.sockets.adapter.rooms -> all rooms and all clients that are in that room
		var rms = io.nsps['/math'].adapter.rooms;
		//console.log(rms);
		var rm = rms['Red'];
		console.log('Red: ' + JSON.stringify(rm));
		rm = rms['Green'];
		console.log('Green: ' + JSON.stringify(rm));
	});

	socket.on('register', function(msg) {
		console.log(msg);
		var reg = JSON.parse(msg);
		var name = reg.name;
		// attach the name to the socket
		socket.name = name;
		users[socket.id] = name;
		// send message back JUST to connecting socket
		socket.emit('math-message','thank you for registering ' + name);
		console.log('sent message back to ' + name);
		// send a note to all users (except the initiating socket) 
		// that *name* has joined - BROADCAST sends to everyone BUT you
		var welcome = name + ' has joined the server';
		socket.broadcast.emit('math-message', welcome);
		console.log(welcome);
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
	console.log('listening on *:'+config.port);
});
