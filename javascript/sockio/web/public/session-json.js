
// The key we are using is the Session ID (a UUID) usually stored in a cookie named 'sid' on the 
// user's browser.  
// The map is the session object, an example is below:
// This is the CS session:
{
  'authenticated' : true,
  'user' : 'teacher1@domain.com',
  'businessKey': '2b18c06e-8532-11e3-8e78-d231feb1dc81',
  'userId' : 2,
  'unique_id' : '4007c41327f58e438c564c88c99275e4f013d8b2',
  'roles' : [ 'ROLE_TEACHER' ],
  'firstName' : 'Malcolm',
  'lastName' : 'Reynolds',
  'displayName' : 'MalcomRaynolds123'
  'expiration' : 17074106508928,
  'current_time' : 17074105308928
}

// This is the Chester session:
{
  isValid: true,
  user: {
      id: res.headers['x-subject-id'],
      role: res.headers['x-subject-role'],
      email: res.headers['x-subject-email']
  }
}

/*

Curriculum Server Stuff
For auth check there is a status endpt:
wg-curriculum/auth/sso/status

when you auth you get a cookie called sid with value = session id token: 4b7e6378-115e-4e94-92e0-d2180107f820
http://cs.qa1.poc.ae1.currdc.net:8080/wg-curriculum/api/1.1/studentProfile

You are now logged in as student_teachersec01_1@amplify.com. 
Your session ID is f6097d67-38b9-4b77-8515-997ae4ae3ecd

http://cs.qa1.poc.ae1.currdc.net:8080/wg-curriculum/api/1.1/action/user/currentUser
{"lastName":"King","roles":"ROLE_STUDENT","notification":{"studentChannelName":"6c608887db1008f0c009bdb8079247cf0fe6c71d3545fc54ff4aa28f831310f1e1d192ae3056e7e5d9563daf2ab2f44556482ca5431aee2c4efdb0b7bd306597"},"userName":"student_teachersec01_1@amplify.com","firstName":"Lucas","key":"student_teachersec01_1"}

http://cs.qa1.poc.ae1.currdc.net:8080/wg-curriculum/api/1.1/action/user/currentSections


[
  {
    "entity": "userRosterEntry",
    "key": "5adf5d20-c2f1-431f-adf3-f9768dfdb947",
    "status": "ACTIVE",
    "user": {
      "lastName": "King",
      "entity": "user",
      "firstName": "Lucas",
      "key": "student_teachersec01_1"
    },
    "section": {
      "enactedComponent": "",
      "purchasedCourseGradeLevel": "7th Grade",
      "session": {
        "joinedStudents": 
        [
        ],
        "notification": {
          "sessionChannelName": "9051829a5bb2996b0dfb7df70790e442b1752d141eedb014eda90cea1c6de5082fec256ba0590efec9c0d5339f5f21169e60e740f064d89c20a31e98e2e3956c"
        },
        "activeLessonMapKey": "a5ae016f-cffe-41b1-9646-615a11226cfd",
        "teachers": 
        [
          {
            "status": "NOT_JOINED",
            "userkey": "fe12c981-e597-4f6a-8c31-91f28952fc23"
          },
          {
            "status": "PRESENT",
            "userkey": "teacher_teachersec01_1"
          }
        ],
        "key": "ebcaef10-b01a-48fd-b35d-b6bc52347ca2"
      },
      "status": "STARTED",
      "lastActive": true,
      "name": "teachersec01_1",
      "entity": "section",
      "purchasedCourseSubjects": "ELA",
      "key": "teachersec01_1",
      "purchasedCourseName": "teachersec01_Course"
    },
    "notification": {
      "sectionChannelName": "5341208c3e67d6f290f39c0650519bcd756979daba3b3e27727e22b8fe5ba9d27d541e52f4c4be373db7bed75a32be91293a0842b9ba7280715cb62b56e6bf62"
    }
  },
  {
    "entity": "userRosterEntry",
    "key": "7b355b44-e353-4706-baca-32cd7b0068b8",
    "status": "ACTIVE",
    "user": {
      "lastName": "King",
      "entity": "user",
      "firstName": "Lucas",
      "key": "student_teachersec01_1"
    },
    "section": {
      "enactedComponent": "",
      "purchasedCourseGradeLevel": "5th Grade",
      "session": {
        "joinedStudents": 
        [
        ],
        "notification": {
          "sessionChannelName": "d8872f3cc066bd22867439fe44423173812fec64d2dedf12fb3979c557ed45c09e6147b9fb3a38af88f9594851d398f3e73b9650a394f64d99afb6f601ba3d7a"
        },
        "activeLessonMapKey": "df921e74-a2bb-4a65-ab7f-a78e62238c11",
        "teachers": 
        [
          {
            "status": "PRESENT",
            "userkey": "teacher_teachersec01_1"
          }
        ],
        "key": "23894458-496a-4b0b-96f7-0e5fad0ad37b"
      },
      "status": "STARTED",
      "lastActive": false,
      "name": "sajits",
      "entity": "section",
      "purchasedCourseSubjects": "ELA",
      "key": "sajits_Gen",
      "purchasedCourseName": "test1"
    },
    "notification": {
      "sectionChannelName": "e06246334126754f13e49d38393d001ed787a4f0a0be3c110e23dd9ed547ee01b9bc10cee23c9cd42c6a314f08f43c6b510cff4588d5f7c3c681a4beb597b2f6"
    }
  },
  {
    "entity": "userRosterEntry",
    "key": "d10abfbf-4e68-4d6c-b2d6-f9c9769df32c",
    "status": "ACTIVE",
    "user": {
      "lastName": "King",
      "entity": "user",
      "firstName": "Lucas",
      "key": "student_teachersec01_1"
    },
    "section": {
      "enactedComponent": "",
      "purchasedCourseGradeLevel": "8th Grade",
      "session": {
        "joinedStudents": 
        [
        ],
        "notification": {
          "sessionChannelName": "e7955f8e34de2389441e8938a2cc220898f3ad013a0bdf7f32a94d122270eeaacaf3cf2c7feb216d10feebc51a89da733ab34c0c8bf75ede8b39d177ed498a1c"
        },
        "activeLessonMapKey": "3bc1a738-0c45-4742-b36e-2e759bc8f64e",
        "teachers": 
        [
          {
            "status": "PRESENT",
            "userkey": "teacher_Thomas_Hale"
          }
        ],
        "key": "6dd5d98f-47be-4ef7-8d4a-d8fe9a4e6c44"
      },
      "status": "STARTED",
      "lastActive": false,
      "name": "jason_testSection",
      "entity": "section",
      "purchasedCourseSubjects": "Science",
      "key": "jason_testSection_Gen",
      "purchasedCourseName": "jason_testSection_tempCourse"
    },
    "notification": {
      "sectionChannelName": "babd9310c341f6e7f71837a75cfa8dbbe48a13798a23daf73d38284388c310a1b3e345f64479ecdef25e4bfe954f6ac8aaab446a18f3502b456ef6d0e4beccd3"
    }
  },
  {
    "entity": "userRosterEntry",
    "key": "0a6b70ad-4efa-48ec-b241-b3b57b5833b5",
    "status": "ACTIVE",
    "user": {
      "lastName": "King",
      "entity": "user",
      "firstName": "Lucas",
      "key": "student_teachersec01_1"
    },
    "section": {
      "enactedComponent": "",
      "purchasedCourseGradeLevel": "8th Grade",
      "status": "STARTED",
      "lastActive": false,
      "name": "t3sec2",
      "entity": "section",
      "purchasedCourseSubjects": "ELA",
      "key": "t3sec2_Gen",
      "purchasedCourseName": "otherOnlyCourse"
    },
    "notification": {
      "sectionChannelName": "6ebced5494f69315e347cb9ceb8e1b4b3dbaeedd4f3a688eb8eaf5a288a87bee6756dd70fca6821553900fcbc746b306072f0366c70b834ca5985e6d014ccd53"
    }
  },
  {
    "entity": "userRosterEntry",
    "key": "bba4f24f-dcae-4d97-8830-0c7e9044c204",
    "status": "ACTIVE",
    "user": {
      "lastName": "King",
      "entity": "user",
      "firstName": "Lucas",
      "key": "student_teachersec01_1"
    },
    "section": {
      "enactedComponent": "",
      "purchasedCourseGradeLevel": "8th Grade",
      "status": "STARTED",
      "lastActive": false,
      "name": "5996testSection",
      "entity": "section",
      "purchasedCourseSubjects": "ELA",
      "key": "60c22b96-a900-43a3-8358-99cd4d1b08de",
      "purchasedCourseName": "Kitchensink1.1"
    },
    "notification": {
      "sectionChannelName": "125d39d10dc40c045930d1aa400c9612eac663352300e24d12af264cf5b3d55bfeb04ad84710e069ae09115a8fee248405b383aac72d0049b0837b1dd772f0cf"
    }
  },
  {
    "entity": "userRosterEntry",
    "key": "15de3a5a-d360-43d3-b1b1-2ed9bdbe5a33",
    "status": "ACTIVE",
    "user": {
      "lastName": "King",
      "entity": "user",
      "firstName": "Lucas",
      "key": "student_teachersec01_1"
    },
    "section": {
      "enactedComponent": "",
      "purchasedCourseGradeLevel": "5th Grade",
      "session": {
        "joinedStudents": 
        [
        ],
        "notification": {
          "sessionChannelName": "02eb9c746f3ebd9c525d90029528ac2ce4ae0db38dd007ffae28b7dab60c7a921ada319dae2d5753397d1a69e05b5c5752882810700ef64523a75b8a3a2c070e"
        },
        "activeLessonMapKey": "f55ca7ca-1b01-4178-80a7-c1726c0051fa",
        "teachers": 
        [
          {
            "status": "NOT_JOINED",
            "userkey": "teacher_Thomas_Hale"
          },
          {
            "status": "NOT_JOINED",
            "userkey": "teacher_teachersec02_1"
          },
          {
            "status": "NOT_JOINED",
            "userkey": "teacher_Alex_Fox"
          },
          {
            "status": "NOT_JOINED",
            "userkey": "teacher_Kathy_Rose"
          },
          {
            "status": "PRESENT",
            "userkey": "teacher_teachersec01_1"
          },
          {
            "status": "NOT_JOINED",
            "userkey": "teacher_teachersec03_1"
          },
          {
            "status": "NOT_JOINED",
            "userkey": "teacher_teachersec04_1"
          }
        ],
        "key": "e704661e-73d8-44fd-a73b-734e720e1394"
      },
      "status": "STARTED",
      "lastActive": false,
      "name": "aatTest",
      "entity": "section",
      "purchasedCourseSubjects": "ELA",
      "key": "67c11a09-b07b-4fdd-99d1-e2a3a5b76df2",
      "purchasedCourseName": "aatSample"
    },
    "notification": {
      "sectionChannelName": "0d83609c79adbab38246eb8160dfe02b2c594149e3bf698c8f2694101dd83b187bb0bb923a3b9c4c9cb96a90b374facf2c5c8c8721c165615388396b7d1ef7d5"
    }
  },
  {
    "entity": "userRosterEntry",
    "key": "956cd544-b03a-4503-b5f9-5f453e04cc81",
    "status": "ACTIVE",
    "user": {
      "lastName": "King",
      "entity": "user",
      "firstName": "Lucas",
      "key": "student_teachersec01_1"
    },
    "section": {
      "enactedComponent": "",
      "purchasedCourseGradeLevel": "8th Grade",
      "status": "STARTED",
      "lastActive": false,
      "name": "KitchenSink1.1Section",
      "entity": "section",
      "purchasedCourseSubjects": "ELA",
      "key": "774ba44b-5bc3-4199-be76-9ea710505f7b",
      "purchasedCourseName": "RaghavCourse"
    },
    "notification": {
      "sectionChannelName": "e027c897975a8010b867a922365c5cb54790194839cc831e2a5b340edc2af297069fcb1af107d921e43520710ccaf73da82fe4bc454134738268bdf14200cb32"
    }
  },
  {
    "entity": "userRosterEntry",
    "key": "757fa1ed-7711-472a-b434-b518d4ba7827",
    "status": "ACTIVE",
    "user": {
      "lastName": "King",
      "entity": "user",
      "firstName": "Lucas",
      "key": "student_teachersec01_1"
    },
    "section": {
      "enactedComponent": "",
      "purchasedCourseGradeLevel": "8th Grade",
      "status": "STARTED",
      "lastActive": false,
      "name": "Test3",
      "entity": "section",
      "purchasedCourseSubjects": "SubjectK",
      "key": "87375b2c-c649-405c-acad-d201e34df082",
      "purchasedCourseName": "Test3_tempCourse"
    },
    "notification": {
      "sectionChannelName": "5a5d1832ba06f16548bb226341512dca14732de7faedb47aa4b3b1ff8ee7f6ab9420f94959a9e411720daa52cc0c536c347da65aa580de049687c72276f5ba5a"
    }
  }
]

http://cs.qa1.poc.ae1.currdc.net:8080/wg-curriculum/api/1.2/data/section/teachersec01_1/sessions/current

http://cs.qa1.poc.ae1.currdc.net:8080/wg-curriculum/api/1.2/rest/social/session
*/

/*
AUTHENTICATION - MAKE SURE THE HANDSHAKE ISN'T INTERCEPTED
socket.io has middleware - before the connection event get fired, we can execute a function
and either allow the connection, or deny it.

we can authorize in two places - on the default namespace or on a named namespace connection. 
Both authorizations happen through the handshake. The function's signature is the same either way. 
It will pass in the socket server, which has some stuff we need such as the connection's headers.

var io = require('socket.io');
io = io.listen(httpserver);
var math = io.of('/math');
math.use(socketAuth); // this uses the auth middleware - can block connection event
math.on('connection', socketConnection);
var cookie = require('cookie'); // get cookies on request
var cookieParser = require('cookie-parser'); // deal with signed cookies

var socketAuth = function(socket, next) {

socket.io creates a cookie for use with the handshake - we need to check to see if it has the same 
connect.sid
socket.io will pass the cookie with the socket into the middleware

  var handshakeData = socket.request;
  var parsedCookies = cookie.parse(handshakeData.headers.cookie); // has the connect.sid
  var sid = cookieParser.signedCookie(parsedCookies['connect.sid'], config.secret); // unsign with secret
  if (parsedCookies['connect.sid'] === sid) {
    return next(new Error('Not Authenticated')); // failed to 'unsign'
  }
  redisSession.get(sid, function(err, session) { // assume we are using a redis session store
    if (session.isAuthenticated) {
      socket.user = session.user;
      socket.sid = sid;
      return next(); // blank next() will continue the middleware chain
    } else {
      return next(new Error('Not cool!')); // if next is executed with an error it will stop the chain
    }
  });

}

http://cs.qa1.poc.ae1.currdc.net:8080/wg-curriculum/api/{version}/data/section/{businessKey}/sessions/current

http://cs.qa1.poc.ae1.currdc.net:8080/wg-curriculum/api/{version}/data/section/{businessKey}/studentRoster/student

*/






















