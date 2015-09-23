(function () {

	var stage;
	var shapes = [];
	var slots = [];
	var score = 0;
	var w, h, bs;
	
	var queue = new createjs.LoadQueue();
	queue.installPlugin(createjs.Sound);
	queue.addEventListener("complete", init);
	queue.loadManifest([
		{id:"chime", src:"audio/chime.mp3"},
		{id:"evil-laugh", src:"audio/elaugh.mp3"},
		{id:"cheer", src:"audio/cheer.mp3"},
	]);
	
	// function declaration - hoisted vs function expression (var x = function() {...})
	function init() {
		stage = new createjs.Stage('canvas');
		w = stage.canvas.width;
		h = stage.canvas.height;
		buildShapes();
		setBlocks();
		startGame();
	}

	function buildShapes() {
		var colors = ['olive', 'green', 'blue', 'yellow', 'orange'];
		n = colors.length;
		bs = Math.floor(0.6 * w / n);
		var sbx = (w - n * bs) / (n + 1);
		var sby = (h - 2 * bs) / 4;
		var shape;
		// create the drop boxes
		for (i = 0; i < n; i++) {
			shape = new createjs.Shape();
			shape.graphics.beginFill("#FFF");
			shape.graphics.beginStroke(colors[i]);
			shape.graphics.drawRect(0, 0, bs, bs);
			shape.x = (i + 1) * sbx + i * bs;
			shape.y = sby;
			slots.push(shape);
		}
		
		// create the blocks
		var scolors = shuffle(colors);
		for (i = 0; i < n; i++) {
			shape = new createjs.Shape();
			shape.graphics.beginFill(scolors[i]);
			shape.graphics.drawRect(0, 0, bs, bs);
			shape.regX = Math.floor(bs / 2);
			shape.regY = Math.floor(bs / 2);
			shape.x = (i + 1) * sbx + (i * bs) + shape.regX;
			shape.y = 3 * sby + bs + shape.regY;
			shape.hx = shape.x;
			shape.hy = shape.y;
			shape.key = colors.indexOf(scolors[i]);
			shapes.push(shape);
		}
	}

	function shuffle(s) {
		var sc = s.slice();
		var n = s.length;
		for (var i = 0; i < n; i++) {
			var r = Math.floor(Math.random() * n);
			var c = sc[i];
			sc[i] = sc[r];
			sc[r] = c;
		}
		return sc;
	}

	function setBlocks() {
		var i, shape;
		// add the slots first so the blocks will be on top of them
		for (i = 0; i < shapes.length; i++) {
			stage.addChild(slots[i]);
		}

		for (i = 0; i < shapes.length; i++) {
			shape = shapes[i];
			console.log(shape.key);
			shape.addEventListener('mousedown', startDrag);
			stage.addChild(shape);
		}
	}

	function startDrag(e) {
		console.log(e);
		var s = e.target;
		var slot = slots[s.key];
		stage.addEventListener('stagemousemove', function (e) {
			s.x = stage.mouseX;
			s.y = stage.mouseY;
		});
		stage.addEventListener('stagemouseup', function (e) {
			e.target.removeAllEventListeners();

			var pt = slot.globalToLocal(stage.mouseX, stage.mouseY);
			console.log(pt.x, pt.y);
			if (s.hitTest(pt.x, pt.y)) {
				// if it overlaps its slot drop it in
				s.removeEventListener('mousedown', startDrag);
				score++;
				createjs.Sound.play('chime');
				createjs.Tween.get(s).to({ x: slot.x+s.regX, y: slot.y +s.regY},
					200, createjs.Ease.quadOut).call(checkGame);
			} else {
				// send the block home
				createjs.Sound.play('evil-laugh');
				createjs.Tween.get(s).to({x:s.hx, y:s.hy},
					300, createjs.Ease.quadOut);
				s.x = s.hx;
				s.y = s.hy;
			}
		});
	}

	function checkGame() {
		if (score == shapes.length) {
			createjs.Sound.play('cheer');
		}
	}

	function startGame() {
		createjs.Ticker.setFPS(60);
		createjs.Ticker.addEventListener('tick', function (e) {
			stage.update();
		});
	}

})();