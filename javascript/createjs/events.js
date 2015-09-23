(function () {
	var stage;
	var circles = [];
	var maxr = 0;
	var minr = 255;
	
	var queue = new createjs.LoadQueue();
	queue.installPlugin(createjs.Sound);
	queue.addEventListener("complete", setupStage);
	queue.loadManifest([
		{id:"traffic", src:"audio/traffic.mp3"}
	]);

	setupStage();

	function setupStage() {
		console.log('setting up the stage');
		stage = new createjs.Stage('canvas');
		stage.enableMouseOver();
		createjs.Ticker.setFPS(60);
		createjs.Ticker.addEventListener("tick", updateLoop);
		for (i = 0; i < 100; i++) {
			circles.push(createCircle());
		}
		createjs.Sound.play('traffic');
	};

	function createCircle() {
		var r = Math.floor(Math.random() * 255);
		if (r > maxr) maxr = r;
		if (r < minr) minr = r;
		var g = Math.floor(Math.random() * 255);
		var b = Math.floor(Math.random() * 255);
		var a = Math.random();
		if (a < 0.5) a = a + 0.5;
		var color = createjs.Graphics.getRGB(r, g, b, 1);
		//console.log(color);
		var circle = new createjs.Shape();
		circle.graphics.beginStroke(color);
		circle.graphics.beginFill(color);
		var radius = Math.floor(Math.random() * 50);
		if (radius < 5) radius += 5;
		var x = Math.floor(Math.random() * stage.canvas.width);
		if (x < radius) x = radius;
		if (x > stage.canvas.width - radius) x = stage.canvas.width - radius;
		var y = Math.floor(Math.random() * stage.canvas.width);
		if (y < radius) y = radius;
		if (y > stage.canvas.height - radius) y = stage.canvas.height - radius;

		circle.graphics.drawCircle(0, 0, radius);
		circle.x = x;
		circle.y = y;
		circle.radius = radius;
		circle.alpha = a;
		circle.oldAlpha = a;
		var baseSpeed = 6;
		circle.speedx = Math.floor(Math.random() * baseSpeed);
		circle.speedy = Math.floor(Math.random() * baseSpeed);
		circle.dx = 1;
		circle.dy = 1;
		circle.addEventListener('click', function (e) {
			var c = e.target;
			c.alpha == 1 ? c.alpha = c.oldAlpha : c.alpha = 1;
			console.log(c.alpha, c.oldAlpha);
			//var circle = circles.splice(circles.indexOf(e.target), 1)[0];
			//circle.alpha = 1;
			//stage.removeChild(circle);
		});
		circle.addEventListener("mouseover", function(e) {
			var c = e.target;
			c.alpha == 1 ? c.alpha = c.oldAlpha : c.alpha = 1;
			console.log('changing alpha');
		});
		circle.addEventListener('mouseout', function(e) {
			var c = e.target;
			c.alpha == 1 ? c.alpha = c.oldAlpha : c.alpha = 1;
			console.log('restoring alpha');
		});
		circle.addEventListener('mousedown', function(e) {
			var c = e.target;
			stage.addEventListener('stagemousemove', function(e) {
				c.x = stage.mouseX;
				c.y = stage.mouseY;
			});
			stage.addEventListener('stagemouseup', function(e) {
				e.target.removeAllEventListeners();
			});
		});
		
		stage.addChild(circle);
		return circle;
	}

	function moveCircles() {
		circles.forEach(function (c) {
			var nx = c.x + c.speedx * c.dx;
			if (nx > stage.canvas.width - c.radius) {
				nx = stage.canvas.width - c.radius;
				c.dx = -1 * c.dx;
			} else if (nx < c.radius) {
				nx = c.radius;
				c.dx = -1 * c.dx;
			}
			c.x = nx;

			var ny = c.y + c.speedy * c.dy;
			if (ny > stage.canvas.height - c.radius) {
				ny = stage.canvas.height - c.radius;
				c.dy = -1 * c.dy;
			} else if (ny < c.radius) {
				ny = c.radius;
				c.dy = -1 * c.dy;
			}
			c.y = ny;

		});

	};

	function updateLoop(e) {
		if (!e.paused) {
			moveCircles();
			stage.update();
			if (createjs.Ticker.getTime() > 100000) {
				console.log(createjs.Ticker.getMeasuredFPS());
				console.log(createjs.Ticker.getTime());
				console.log('wrapping up...');
				createjs.Ticker.paused = true;
				stage.removeAllChildren();
				stage.update();
			}
		}
	};
})();