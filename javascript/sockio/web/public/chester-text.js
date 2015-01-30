Chester uses a cookie-based authorization strategy - set the token in your browser:

document.cookie = oauth_token=fake-tokenYu5aFceFAHpHCR

Development config:
{
  "appSettings": {
    "client_id": "Ch3$TeR_API",
    "client_secret": "@MPL!FY"
  },
  "authSettings": {
    "serviceName" : "amplifyAuth",
    "promiscuousUser" : {
    	"id": "235",
  		"role": "TEACHER",
  		"email": "amplifytest2@amplifydev.net"
    }
  },
  "sisSettings": {
    "url" : "http://localhost.amplifydev.net:8888",
    "client-id" : "@MPL!FY_API",
    "client-secret" : "PLUMB3RS_plunge"
  },
  "notebookServerSettings": {
    "url" : "http://localhost.amplifydev.net:9000",
    "client-id" : "notebook",
    "client-secret" : "YfLlPmA"
  },
  "logSettings": {
    "appenders": [
      {
        "type": "console"
      }
    ]
  }
}

getAuthenticatedUser: 
var user;
user = 	{
			id: res.headers['x-subject-id'],
			role: res.headers['x-subject-role'],
			email: res.headers['x-subject-email']
		};

amplifyAuth.js
module.exports = {
    validate: function(token, callback) {
      if (!token) {
        callback({
          isValid: false
        });
      }
      return apiGateway.getAuthenticatedUser(token, function(user) {
        if (user != null) {
          return callback({
            isValid: true,
            user: user
          });
        } else {
          return callback({
            isValid: false
          });
        }
      });
    }
  };

  authMiddleware.js
  socketAuthenticate: function(socket, next) {
      var cookieString;
      cookieString = socket.handshake.headers.cookie;
      return validateAuthRequest(cookieString, next, function(result) {
        if (result.isValid) {
          socket.user = result.user;
          return next();
        } else {
          return next(new Error('unauthorized'));
        }
      });
    }

