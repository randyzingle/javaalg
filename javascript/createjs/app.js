(function() {
	console.log('loaded');
	var stage;
	var circle;
	var queue = new createjs.LoadQueue();
	queue.installPlugin(createjs.Sound);
	queue.addEventListener("complete", loadComplete);
	queue.loadManifest([
		{id:"butterfly", src:"images/butterfly.png"},
		{id:"woosh", src:"audio/woosh.mp3"},
		{id:"chime", src:"audio/chime.mp3"}
	]);
	
	function loadComplete() {
		setupStage();
		buildButterflies();
	};
	
	function setupStage() {
		stage = new createjs.Stage('canvas');
		createjs.Ticker.setFPS(30);
		// on every tick update the stage to update all added, deleted, or updated sprites
		createjs.Ticker.addEventListener("tick", runGame);
		// create dynamic shapes
		createCircle();
	};
	
	function runGame(e) {
		if(!e.paused) {
			console.log(e);
			updateCircle();
			stage.update();
		}
	};
	
	function updateCircle() {
		var nextx = circle.x + circle.direction * circle.speed;
		if (nextx > stage.canvas.width - circle.radius) {
			nextx = stage.canvas.width - circle.radius;
			circle.direction *= -1;
		} else if (nextx < circle.radius) {
			nextx = circle.radius;
			circle.direction *= -1;
		}
		circle.x = nextx;
	}
	
	function createCircle() {
		circle = new createjs.Shape();
		circle.graphics.beginStroke('#000');
		circle.graphics.beginFill('#FFF000');
		circle.graphics.drawCircle(0,0,50);
		circle.radius = 50;
		circle.x = 100;
		circle.y = 300;
		circle.speed = 50;
		circle.direction = 1;
		stage.addChild(circle);
	}
	
	function buildButterflies() {
		var img = queue.getResult("butterfly");
		var i, sound, butterfly;
		for (i=0; i<3; i++) {
			butterfly = new createjs.Bitmap(img);
			butterfly.x = i * 200;
			stage.addChild(butterfly);
			createjs.Tween.get(butterfly).wait(i*1000).to({y:400}, 1000, createjs.Ease.quadOut)
				.call(butterflyComplete);
			sound = createjs.Sound.play('woosh', createjs.Sound.INTERRUPT_NONE, i*1000);
		}
	};
	
	function butterflyComplete() {
		stage.removeChild(this);		
		if(stage.getNumChildren() < 2) {
			createjs.Sound.play('chime');
			stage.removeChild(circle);
			createjs.Ticker.setPaused(true);
		}
	};
	
	
})();