
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