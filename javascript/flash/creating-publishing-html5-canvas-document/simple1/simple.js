(function (lib, img, cjs) {

var p; // shortcut to reference prototypes

// library properties:
lib.properties = {
	width: 550,
	height: 400,
	fps: 24,
	color: "#FFFFFF",
	manifest: [
		{src:"images/sky_background.jpg", id:"sky_background"}
	]
};



// symbols:



(lib.sky_background = function() {
	this.initialize(img.sky_background);
}).prototype = p = new cjs.Bitmap();
p.nominalBounds = new cjs.Rectangle(0,0,640,360);


(lib.right = function() {
	this.initialize();

	// Layer 1
	this.shape = new cjs.Shape();
	this.shape.graphics.f().s("#333333").ss(10,1,1).p("ABzkDQAPAPAPAUQA8BTAAB2QAAB0g8BUQg8BThVAAQhUAAg8hTQg8hUAAh0QAAgCAAgDAjMgdIAAgB");
	this.shape.setTransform(20.5,26.1);

	this.shape_1 = new cjs.Shape();
	this.shape_1.graphics.f("#CC0000").s().p("AiPCxQg9hUAAh0IAAgFIAAgBIAAgBQACgcAnAIQAPADAPgBIAhgZQAHgFAJAAIAUgWQAOgRAagVQAAgeAcAAIAVAAIAKgeIAngKQAUgYAQgMQAFgEAAgKIAAgBQAPAPAPAUQA7BTABB2QgBB0g7BUQg9BThUAAQhUAAg7hTg");
	this.shape_1.setTransform(20.5,26.1);

	this.addChild(this.shape_1,this.shape);
}).prototype = p = new cjs.Container();
p.nominalBounds = new cjs.Rectangle(-5,-5,51,62.2);


(lib.left = function() {
	this.initialize();

	// Layer 1
	this.shape = new cjs.Shape();
	this.shape.graphics.f().s("#333333").ss(10,1,1).p("AhtkDQgPAPgOAUQg6BTAAB2QAAB0A6BUQA6BTBQAAQBRAAA6hTQAagmAPguQARg2AAg+");
	this.shape.setTransform(19.7,26.1);

	this.shape_1 = new cjs.Shape();
	this.shape_1.graphics.f("#7A0000").s().p("AiKCxQg5hUgBh0QABh2A5hTQAOgUAPgPIAAABQAAAKAEAEQAQAMATAYIAmAKIAJAeIATAAQAcAAAAAeQAZAVAOARIASAWQAKAAAGAFIAgAZQAOABAOgDQANgDAKACQAQADABASIAAABIAAABIAAAFQgBA+gQA2QgPAugaAmQg6BThRAAQhQAAg6hTg");
	this.shape_1.setTransform(19.7,26.1);

	this.addChild(this.shape_1,this.shape);
}).prototype = p = new cjs.Container();
p.nominalBounds = new cjs.Rectangle(-5,-5,49.4,62.2);


(lib.Character1 = function(mode,startPosition,loop) {
	this.initialize(mode,startPosition,loop,{});

	// right
	this.instance = new lib.right("synched",0);
	this.instance.setTransform(68.2,171,0.999,0.999,-29.9,0,0,9.5,13.1);

	this.timeline.addTween(cjs.Tween.get(this.instance).wait(1).to({regX:20.5,regY:26.1,scaleX:1,scaleY:1,rotation:-30,x:84.2,y:176.7},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1).to({startPosition:0},0).wait(1));

	// Layer 1
	this.shape = new cjs.Shape();
	this.shape.graphics.f().s("#333333").ss(10,1,1).p("AHlAAQAAB9gcBuQgDAKgCAKQgkB9hJBoQiPDJjIAAQgQAAgSgCQg0gFgwgSQh0guhciCQiOjJAAkbQAAkaCOjJQCOjJDIAAQDIAACPDJQCODJAAEag");
	this.shape.setTransform(48.5,123.5);

	this.shape_1 = new cjs.Shape();
	this.shape_1.graphics.f("#7A0000").s().p("AjCEOQgbgagFgNQgIgNABgcQAAggATgIQAPATAGANIATAtIDugCQAIgMAMgDICDAAQAPAGAEAOIgHAUIh9AFQgEALgOAEgAhMhTIgIgmQAAg0ApgPIgzAAQgKgBgUgTQgTgSAAgLQgBgQACABIABAEIAEgHQADgDAQAAQAPAAAHAKQAEAFAEAMIA+gCQATgHAHgRQAEgNALACQALAFADADQAFAGABARQAAAIgOAOQgLALgOAKQAdAAAYANQAZAOAAARQAAAsgTAZQgZAhg2AAQglAAgPgjg");
	this.shape_1.setTransform(72.8,99);

	this.shape_2 = new cjs.Shape();
	this.shape_2.graphics.f("#CC0000").s().p("AgiKrQg0gFgvgSQh1guhbiDQiPjIAAkbQAAkaCPjJQCNjJDIAAQDIAACODJQCPDJAAEaQAAB9gcBtIgGAVQgjB9hKBnQiODJjIAAQgQAAgSgBgAAIg2QgBAdAIANQAFAMAbAZIEYAAQAOgEAEgMIB9gEIAHgSQgEgOgPgHIiDAAQgMAEgIALIjwADIgTgtQgGgOgPgSQgTAHAAAggABinjQAAAMATASQAUATAKABIAzAAQgpAOAAA1IAIAmQAPAiAlAAQA4ABAZghQATgaAAgrQAAgSgZgNQgYgNgfgBQAQgKALgKQAOgOAAgJQgBgRgFgFQgDgEgLgFQgLgBgFANQgIARgTAHIg+ACQgEgMgEgGQgHgKgPAAQgQAAgDADIgEAHIgBgDIAAgBQgCAAABAPg");
	this.shape_2.setTransform(48.5,123.5);

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.shape_2},{t:this.shape_1},{t:this.shape}]}).wait(15));

	// left
	this.instance_1 = new lib.left("synched",0);
	this.instance_1.setTransform(28.7,168.9,0.999,0.999,14.8,0,0,30.1,13.1);

	this.timeline.addTween(cjs.Tween.get(this.instance_1).wait(1).to({regX:19.7,regY:26.1,scaleX:1,scaleY:1,rotation:11.8,x:15.1,y:179.8},0).wait(1).to({rotation:8.5,x:15,y:180.8},0).wait(1).to({rotation:5.3,x:14.8,y:181.8},0).wait(1).to({rotation:2.1,x:14.7,y:182.7},0).wait(1).to({rotation:-1.1,x:-125.4,y:182.1},0).wait(1).to({rotation:-4.4,x:-124.6,y:182.6},0).wait(1).to({rotation:-7.6,x:-123.8,y:183.1},0).wait(1).to({rotation:-10.8,x:-123,y:183.6},0).wait(1).to({rotation:-14,x:-122.2,y:184},0).wait(1).to({rotation:-17.3,x:-121.3,y:184.4},0).wait(1).to({rotation:-20.5,x:-120.4,y:184.7},0).wait(1).to({rotation:-23.7,x:-119.5,y:185},0).wait(1).to({rotation:-27,x:-118.6,y:185.2},0).wait(1).to({rotation:-30.2,x:-117.7,y:185.4},0).wait(1));

}).prototype = p = new cjs.MovieClip();
p.nominalBounds = new cjs.Rectangle(-9.4,50,120,159.4);


// stage content:



(lib.simple = function() {
	this.initialize();

	// Character
	this.instance = new lib.Character1("synched",0);
	this.instance.setTransform(358.5,178.5,1,1,0,0,0,48.5,68.5);

	// Background
	this.shape = new cjs.Shape();
	this.shape.graphics.f("#FFFFFF").s().de(-26,-16.5,52,33);
	this.shape.setTransform(149,100.5);

	this.shape_1 = new cjs.Shape();
	this.shape_1.graphics.f("#FFFFFF").s().de(-35,-16.5,70,33);
	this.shape_1.setTransform(196,88.5);

	this.shape_2 = new cjs.Shape();
	this.shape_2.graphics.f("#FFFFFF").s().de(-54.5,-29.5,109,59);
	this.shape_2.setTransform(165.5,117.5);

	this.shape_3 = new cjs.Shape();
	this.shape_3.graphics.lf(["#004608","#12BD34"],[0,1],-194.3,194.8,195.3,-194.8).s().dr(-275,-39,550,78);
	this.shape_3.setTransform(275,361);

	this.instance_1 = new lib.sky_background();
	this.instance_1.setTransform(0,0,0.859,1);

	this.addChild(this.instance_1,this.shape_3,this.shape_2,this.shape_1,this.shape,this.instance);
}).prototype = p = new cjs.Container();
p.nominalBounds = new cjs.Rectangle(275,200,550,400);

})(lib = lib||{}, images = images||{}, createjs = createjs||{});
var lib, images, createjs;