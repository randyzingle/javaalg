(function() {
	'use strict';

	var canvas = document.getElementById('canvas');

	var ctx = canvas.getContext('2d');
	var timer = null;
	var n = 0;

	function drawRobots() {
		ctx.drawImage(robot, 10, 10, 100, 100);
		timer = setInterval(moveRobot, 1000);
	}

	function moveRobot() {
		
		ctx.clearRect(0,0,canvas.width, canvas.height);
		var x = Math.random() * 500;
		var y = Math.random() * 400;
		ctx.drawImage(robot, x, y, 100, 100);
		n++;
		if (n > 20) {
			clearInterval(timer);
		}
	}

	var robot = new Image();
	robot.src = 'images/kareln.png';
	robot.onload = drawRobots;



})();