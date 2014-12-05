var express = require('express');
var app = express();
var path = require('path');
var http = require('http').Server(app);
var cookieParser = require('cookie-parser');
var session = require('express-session');
var config = require('./config');
var cookie = require('cookie');
var RedisStore = require('connect-redis')(session);


var redisSession = new RedisStore({host: config.redisHost, port: config.redisPort});

app.use(cookieParser());
app.use(session({
  secret: config.secret,
  resave: false,
  saveUninitialized: true,
  store: redisSession
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

http.listen(config.port,function() {
	console.log('listening on *:'+config.port);
});
