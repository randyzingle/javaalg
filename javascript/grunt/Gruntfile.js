var fs = require('fs');
var request = require('request');

module.exports = function(grunt) {
	grunt.loadNpmTasks('grunt-contrib-jshint');
	grunt.loadNpmTasks('grunt-contrib-uglify');
	grunt.loadNpmTasks('grunt-contrib-concat');
	grunt.loadNpmTasks('grunt-aws');
	grunt.loadNpmTasks('grunt-contrib-clean');
	grunt.loadNpmTasks('grunt-contrib-watch');

	grunt.initConfig({
		// all javascript source files
		srcFiles: ['src/**/*.js'],

		watch: {
			target1: {
				files: "<%= srcFiles %>",
				tasks: ['clean','jshint']
			}
		},

		jshint: {
			options: {
				curly: true,
				eqeqeq: true
				// jshintrc: '.jshintrc'
			},
			target1: ['Gruntfile.js','src/**/*.js'],
			piano: ['src/test.js']
		}, 

		uglify: {
			// remove DEBUG code first
			options: {
				// create a source map
				sourceMap: true,
				sourceMapName: 'build/app.min.js.map',
				// conditional compilation to remove debug statements
				// this isn't working ....
				compress: {
					global_defs: {
						"DEBUG": false
					},
					dead_code: true,
				}
			},
			target1: {
				src: 'build/app.js',
				dest: 'build/app.min.js'
			}
		}, 

		clean: {
			build: ["build"],
			release: ["build"]
		},

		concat: {
			target1: {
				files: {
					"build/app.js": ['src/**/*.js']
				}
			}
		}, 

		aws : grunt.file.readJSON("s3-aws.json"),
		s3: {
			options: {
				accessKeyId: "<%= aws.key %>",
				secretAccessKey: "<%= aws.secret %>",
				bucket: "math-poc"
			},
			build: {
				cwd: "build/",
				src: "app.min.js"
			}
		}
	});

	grunt.registerTask('logit', function() {
		var message = 'Deployment on ' + new Date();
		fs.appendFileSync('deploy.log', message + '\n');
		grunt.log.writeln('Appended "' + message + '"');
	});

	grunt.registerTask('webget', 'Description - download a file from the web', function() {
		var url = 'https://github.com/request/request/blob/master/README.mdx';
		grunt.log.writeln('getting: ' + url);
		var done = this.async();
		request(url, function(err, response, contents) {
			if(!err && response.statusCode === 200) {
				grunt.log.writeln('found the web file...');
				grunt.file.write('build/File.md', contents);
				done();
			} else {
				done(new Error('this did not work!'));
			}
		});
	});

	grunt.registerTask('default', ['jshint']);

	grunt.registerTask('build', ['jshint', 'concat', 'uglify']);
};