(function(){
	var LOADER_WIDTH = 400;
	var stage, loaderBar, loadInterval;
	var circle;
	var percentLoaded = 0;
	
	setupStage();
	buildLoadBar();	
	startLoad();	
	
	function setupStage() {
		console.log('setting up the stage');
		stage = new createjs.Stage('canvas');
		createjs.Ticker.setFPS(60);
		createjs.Ticker.addEventListener("tick", updateLoop);
	}
	
	function updateLoop(e) {
		updateLoaderBar();
		stage.update();
		//console.log('kup');
	}
	
	function buildLoadBar() {
		console.log('building the load bar');
		loaderBar = new createjs.Shape();
		loaderBar.x = loaderBar.y = 100;
		loaderBar.graphics.setStrokeStyle(2);
		loaderBar.graphics.beginStroke("#000");
		loaderBar.graphics.drawRect(0,0,LOADER_WIDTH, 40);
		stage.addChild(loaderBar);
	}
	
	function updateLoaderBar() {
		loaderBar.graphics.clear();
		loaderBar.graphics.beginFill('#00ff00');
		loaderBar.graphics.drawRect(0,0,LOADER_WIDTH * percentLoaded, 40);
		loaderBar.graphics.endFill();
		loaderBar.graphics.setStrokeStyle(2);
		loaderBar.graphics.beginStroke("#000");
		loaderBar.graphics.drawRect(0,0,LOADER_WIDTH,40);
		loaderBar.graphics.endStroke();
	}
	
	function startLoad() {
		console.log('loading...');
		loadInterval = setInterval(updateLoad, 20);
	}
	
	function updateLoad() {
		percentLoaded += 0.005;
		updateLoaderBar();
		if (percentLoaded >=1) {
			clearInterval(loadInterval);
			stage.removeChild(loaderBar);
		}
	}
	
})();