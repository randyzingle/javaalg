var express = require('express');
var app = express();
var path = require('path');
var http = require('http').Server(app);
var cookieParser = require('cookie-parser');
var session = require('express-session');
var config = require('./config');
var cookie = require('cookie');
var RedisStore = require('connect-redis')(session);
var bodyParser = require('body-parser');


var redisSession = new RedisStore({host: config.redisHost, port: config.redisPort});

app.use(cookieParser());
app.use(session({
  secret: config.secret,
  resave: false,
  saveUninitialized: true,
  store: redisSession
}));

app.get('/', function(req,res) {
	res.sendFile(__dirname + '/public/index.html');
});
// use the above path for / and the below paths for everything else

app.use(express.static(path.join(__dirname, 'public')));

// handle the post request that registers the user and stores the session in redit
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({extended: false}));
// curl -X POST -H "Content-Type: application/json" -d '{"username":"baldur"}' http://localhost:8080/storesession
app.post('/storesession', function(req, res) {
	console.log(req.body);
	req.session.user = req.body; // store the user info in the redis store under the session key
	res.send(req.body);
});

http.listen(config.port,function() {
	console.log('listening on *:'+config.port);
});