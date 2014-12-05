var config = {
	host: process.env.HOST,
	port: 8000,
	secret: 'secret',
	redisUrl: 'redis://localhost',
	redisHost: 'localhost',
	redisPort: 6379
};

module.exports = config;
