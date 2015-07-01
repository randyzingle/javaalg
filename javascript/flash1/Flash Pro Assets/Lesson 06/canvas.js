(function (lib, img, cjs) {

var p; // shortcut to reference prototypes

// library properties:
lib.properties = {
	width: 640,
	height: 360,
	fps: 30,
	color: "#000000",
	manifest: [
		{src:"images/sky_background.jpg", id:"sky_background"}
	]
};

// stage content:
(lib.canvas = function(mode,startPosition,loop) {
	this.initialize(mode,startPosition,loop,{});

	// Character
	this.instance = new lib.Character("synched",0);
	this.instance.setTransform(670,190);

	this.timeline.addTween(cjs.Tween.get(this.instance).wait(1).to({regX:-0.8,regY:13,scaleX:1,scaleY:1,x:657.8,y:209.3,startPosition:1},0).wait(1).to({scaleX:1.01,scaleY:1.01,x:646.2,y:215.3,startPosition:2},0).wait(1).to({scaleX:1.01,scaleY:1.01,x:634.5,y:221,startPosition:3},0).wait(1).to({scaleX:1.02,scaleY:1.02,x:622.6,y:226.3,startPosition:4},0).wait(1).to({scaleX:1.03,scaleY:1.03,x:610.6,y:231.4,startPosition:5},0).wait(1).to({scaleX:1.03,scaleY:1.03,x:598.5,y:236.3,startPosition:6},0).wait(1).to({scaleX:1.04,scaleY:1.04,x:586.2,y:240.9,startPosition:7},0).wait(1).to({scaleX:1.04,scaleY:1.04,x:574,y:245.3,startPosition:8},0).wait(1).to({scaleX:1.05,scaleY:1.05,x:561.6,y:249.5,startPosition:9},0).wait(1).to({scaleX:1.05,scaleY:1.05,x:549.2,y:253.5,startPosition:10},0).wait(1).to({scaleX:1.06,scaleY:1.06,x:536.8,y:257.3,startPosition:11},0).wait(1).to({scaleX:1.06,scaleY:1.06,x:524.3,y:261,startPosition:12},0).wait(1).to({scaleX:1.07,scaleY:1.07,x:511.7,y:264.5,startPosition:13},0).wait(1).to({scaleX:1.07,scaleY:1.07,x:499.2,y:268,startPosition:14},0).wait(1).to({scaleX:1.08,scaleY:1.08,x:486.6,y:271.2,startPosition:0},0).wait(1).to({scaleX:1.08,scaleY:1.08,x:473.9,y:274.4,startPosition:1},0).wait(1).to({scaleX:1.09,scaleY:1.09,x:461.3,y:277.4,startPosition:2},0).wait(1).to({scaleX:1.09,scaleY:1.09,x:448.6,y:280.3,startPosition:3},0).wait(1).to({scaleX:1.1,scaleY:1.1,x:435.8,y:283.1,startPosition:4},0).wait(1).to({scaleX:1.1,scaleY:1.1,x:423.1,y:285.9,startPosition:5},0).wait(1).to({scaleX:1.11,scaleY:1.11,x:410.3,y:288.5,startPosition:6},0).wait(1).to({scaleX:1.11,scaleY:1.11,x:397.5,y:291,startPosition:7},0).wait(1).to({scaleX:1.12,scaleY:1.12,x:384.7,y:293.5,startPosition:8},0).wait(1).to({scaleX:1.12,scaleY:1.12,x:371.9,y:295.8,startPosition:9},0).wait(1).to({scaleX:1.13,scaleY:1.13,x:359.1,y:298.1,startPosition:10},0).wait(1).to({scaleX:1.13,scaleY:1.13,x:346.3,y:300.3,startPosition:11},0).wait(1).to({scaleX:1.14,scaleY:1.14,x:333.4,y:302.5,startPosition:12},0).wait(1).to({scaleX:1.14,scaleY:1.14,x:320.6,y:304.6,startPosition:13},0).wait(1).to({scaleX:1.15,scaleY:1.15,x:307.7,y:306.6,startPosition:14},0).wait(1).to({scaleX:1.15,scaleY:1.15,x:294.8,y:308.6,startPosition:0},0).wait(1).to({scaleX:1.16,scaleY:1.16,x:281.9,y:310.4,startPosition:1},0).wait(1).to({scaleX:1.16,scaleY:1.16,x:269,y:312.2,startPosition:2},0).wait(1).to({scaleX:1.17,scaleY:1.17,x:256.1,y:314.1,startPosition:3},0).wait(1).to({scaleX:1.17,scaleY:1.17,x:243.2,y:315.8,startPosition:4},0).wait(1).to({scaleX:1.18,scaleY:1.18,x:230.3,y:317.4,startPosition:5},0).wait(1).to({scaleX:1.18,scaleY:1.18,x:217.4,y:319.1,startPosition:6},0).wait(1).to({scaleX:1.19,scaleY:1.19,x:204.5,y:320.6,startPosition:7},0).wait(1).to({scaleX:1.19,scaleY:1.19,x:191.5,y:322.1,startPosition:8},0).wait(1).to({scaleX:1.2,scaleY:1.2,x:178.6,y:323.7,startPosition:9},0).wait(1).to({scaleX:1.2,scaleY:1.2,x:165.7,y:325.1,startPosition:10},0).wait(1).to({scaleX:1.21,scaleY:1.21,x:152.7,y:326.5,startPosition:11},0).wait(1).to({scaleX:1.21,scaleY:1.21,x:139.8,y:327.8,startPosition:12},0).wait(1).to({scaleX:1.22,scaleY:1.22,x:126.8,y:329.1,startPosition:13},0).wait(1).to({scaleX:1.22,scaleY:1.22,x:113.8,y:330.4,startPosition:14},0).wait(1).to({scaleX:1.23,scaleY:1.23,x:100.9,y:331.7,startPosition:0},0).wait(1).to({scaleX:1.24,scaleY:1.24,x:87.9,y:332.9,startPosition:1},0).wait(1).to({scaleX:1.24,scaleY:1.24,x:75,y:334,startPosition:2},0).wait(1).to({scaleX:1.25,scaleY:1.25,x:62,y:335.2,startPosition:3},0).wait(1).to({scaleX:1.25,scaleY:1.25,x:49,y:336.3,startPosition:4},0).wait(1));

	// Cloud copy
	this.shape = new cjs.Shape();
	this.shape.graphics.f("rgba(255,255,255,0.286)").s().de(-115,-30,230,60);
	this.shape.setTransform(110,120,0.667,0.667);

	this.shape_1 = new cjs.Shape();
	this.shape_1.graphics.f("rgba(255,255,255,0.286)").s().p("AodCNQjgg7AAhSQAAhRDgg8QDhg5E8AAQE9AADhA5QDgA8AABRQAABSjgA7QjhA6k9AAQk8AAjhg6g");
	this.shape_1.setTransform(120.8,120.2);

	this.shape_2 = new cjs.Shape();
	this.shape_2.graphics.f("rgba(255,255,255,0.286)").s().p("AodCNQjgg7AAhSQAAhSDgg7QDhg5E8AAQE9AADhA5QDgA7AABSQAABSjgA7QjhA6k9AAQk8AAjhg6g");
	this.shape_2.setTransform(131.6,120.4);

	this.shape_3 = new cjs.Shape();
	this.shape_3.graphics.f("rgba(255,255,255,0.286)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg6E8gBQE9ABDhA6QDgA6AABSQAABTjgA5QjhA8k9AAQk8AAjhg8g");
	this.shape_3.setTransform(142.4,120.6);

	this.shape_4 = new cjs.Shape();
	this.shape_4.graphics.f("rgba(255,255,255,0.286)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg7E8AAQE9AADgA7QDhA6AABSQAABTjhA5QjgA7k9ABQk8gBjhg7g");
	this.shape_4.setTransform(153.3,120.8);

	this.shape_5 = new cjs.Shape();
	this.shape_5.graphics.f("rgba(255,255,255,0.285)").s().p("AodCNQjgg7AAhSQAAhRDgg8QDhg5E8AAQE9AADgA5QDhA8AABRQAABSjhA7QjgA6k9AAQk8AAjhg6g");
	this.shape_5.setTransform(164.1,121);

	this.shape_6 = new cjs.Shape();
	this.shape_6.graphics.f("rgba(255,255,255,0.285)").s().p("AodCNQjgg7AAhSQAAhSDgg7QDhg5E8AAQE9AADgA5QDhA7AABSQAABSjhA7QjgA6k9AAQk8AAjhg6g");
	this.shape_6.setTransform(174.9,121.2);

	this.shape_7 = new cjs.Shape();
	this.shape_7.graphics.f("rgba(255,255,255,0.285)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg6E8gBQE9ABDgA6QDhA6AABSQAABTjhA5QjgA8k9AAQk8AAjhg8g");
	this.shape_7.setTransform(185.7,121.4);

	this.shape_8 = new cjs.Shape();
	this.shape_8.graphics.f("rgba(255,255,255,0.285)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg7E8AAQE9AADhA7QDgA6AABSQAABTjgA5QjhA7k9ABQk8gBjhg7g");
	this.shape_8.setTransform(196.5,121.6);

	this.shape_9 = new cjs.Shape();
	this.shape_9.graphics.f("rgba(255,255,255,0.285)").s().p("AodCNQjgg6AAhTQAAhRDgg8QDhg5E8AAQE9AADhA5QDgA8AABRQAABTjgA6QjhA6k9AAQk8AAjhg6g");
	this.shape_9.setTransform(207.3,121.8);

	this.shape_10 = new cjs.Shape();
	this.shape_10.graphics.f("rgba(255,255,255,0.285)").s().p("AodCNQjgg7AAhSQAAhSDgg7QDhg5E8AAQE9AADhA5QDgA7AABSQAABSjgA7QjhA6k9AAQk8AAjhg6g");
	this.shape_10.setTransform(218.2,122);

	this.shape_11 = new cjs.Shape();
	this.shape_11.graphics.f("rgba(255,255,255,0.285)").s().p("AodCMQjgg5AAhTQAAhRDgg7QDhg6E8gBQE9ABDhA6QDgA7AABRQAABTjgA5QjhA8k9AAQk8AAjhg8g");
	this.shape_11.setTransform(229,122.2);

	this.shape_12 = new cjs.Shape();
	this.shape_12.graphics.f("rgba(255,255,255,0.284)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg7E8AAQE9AADgA7QDhA6AABSQAABTjhA5QjgA7k9ABQk8gBjhg7g");
	this.shape_12.setTransform(239.8,122.4);

	this.shape_13 = new cjs.Shape();
	this.shape_13.graphics.f("rgba(255,255,255,0.284)").s().p("AodCNQjgg6AAhTQAAhRDgg8QDhg5E8AAQE9AADgA5QDhA8AABRQAABTjhA6QjgA6k9AAQk8AAjhg6g");
	this.shape_13.setTransform(250.6,122.7);

	this.shape_14 = new cjs.Shape();
	this.shape_14.graphics.f("rgba(255,255,255,0.284)").s().p("AodCNQjgg7AAhSQAAhRDgg8QDhg5E8AAQE9AADgA5QDhA8AABRQAABSjhA7QjgA6k9AAQk8AAjhg6g");
	this.shape_14.setTransform(261.4,122.9);

	this.shape_15 = new cjs.Shape();
	this.shape_15.graphics.f("rgba(255,255,255,0.284)").s().p("AodCMQjgg5AAhTQAAhRDgg7QDhg6E8gBQE9ABDhA6QDgA7AABRQAABTjgA5QjhA8k9AAQk8AAjhg8g");
	this.shape_15.setTransform(272.2,123.1);

	this.shape_16 = new cjs.Shape();
	this.shape_16.graphics.f("rgba(255,255,255,0.284)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg7E8AAQE9AADhA7QDgA6AABSQAABTjgA5QjhA7k9ABQk8gBjhg7g");
	this.shape_16.setTransform(283.1,123.3);

	this.shape_17 = new cjs.Shape();
	this.shape_17.graphics.f("rgba(255,255,255,0.284)").s().p("AodCNQjgg6AAhTQAAhRDgg8QDhg5E8AAQE9AADhA5QDgA8AABRQAABTjgA6QjhA6k9AAQk8AAjhg6g");
	this.shape_17.setTransform(293.9,123.5);

	this.shape_18 = new cjs.Shape();
	this.shape_18.graphics.f("rgba(255,255,255,0.283)").s().p("AodCNQjgg7AAhSQAAhRDgg8QDhg5E8AAQE9AADhA5QDgA8AABRQAABSjgA7QjhA6k9AAQk8AAjhg6g");
	this.shape_18.setTransform(304.7,123.7);

	this.shape_19 = new cjs.Shape();
	this.shape_19.graphics.f("rgba(255,255,255,0.283)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg7E8AAQE9AADgA7QDhA6AABSQAABTjhA5QjgA8k9AAQk8AAjhg8g");
	this.shape_19.setTransform(315.5,123.9);

	this.shape_20 = new cjs.Shape();
	this.shape_20.graphics.f("rgba(255,255,255,0.283)").s().p("AodCNQjgg6AAhTQAAhRDgg8QDhg6E8AAQE9AADgA6QDhA8AABRQAABTjhA6QjgA6k9AAQk8AAjhg6g");
	this.shape_20.setTransform(337.1,124.3);

	this.shape_21 = new cjs.Shape();
	this.shape_21.graphics.f("rgba(255,255,255,0.283)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg6E8AAQE9AADhA6QDgA6AABSQAABTjgA5QjhA8k9AAQk8AAjhg8g");
	this.shape_21.setTransform(358.8,124.7);

	this.shape_22 = new cjs.Shape();
	this.shape_22.graphics.f("rgba(255,255,255,0.282)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg7E8AAQE9AADhA7QDgA6AABSQAABTjgA5QjhA8k9AAQk8AAjhg8g");
	this.shape_22.setTransform(369.6,124.9);

	this.shape_23 = new cjs.Shape();
	this.shape_23.graphics.f("rgba(255,255,255,0.282)").s().p("AodCNQjgg7AAhSQAAhRDgg8QDhg6E8AAQE9AADhA6QDgA8AABRQAABSjgA7QjhA6k9AAQk8AAjhg6g");
	this.shape_23.setTransform(380.4,125.1);

	this.shape_24 = new cjs.Shape();
	this.shape_24.graphics.f("rgba(255,255,255,0.282)").s().p("AodCNQjgg7AAhSQAAhRDgg8QDhg5E8AAQE9AADgA5QDhA8AABRQAABSjhA7QjgA6k9AAQk8AAjhg6g");
	this.shape_24.setTransform(391.2,125.3);

	this.shape_25 = new cjs.Shape();
	this.shape_25.graphics.f("rgba(255,255,255,0.282)").s().p("AodCMQjgg6AAhSQAAhSDgg7QDhg5E8AAQE9AADgA5QDhA7AABSQAABSjhA6QjgA8k9gBQk8ABjhg8g");
	this.shape_25.setTransform(402,125.5);

	this.shape_26 = new cjs.Shape();
	this.shape_26.graphics.f("rgba(255,255,255,0.282)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg7E8AAQE9AADgA7QDhA6AABSQAABTjhA5QjgA8k9AAQk8AAjhg8g");
	this.shape_26.setTransform(412.9,125.7);

	this.shape_27 = new cjs.Shape();
	this.shape_27.graphics.f("rgba(255,255,255,0.282)").s().p("AodCNQjgg7AAhSQAAhSDgg6QDhg7E8AAQE9AADhA7QDgA6AABSQAABSjgA7QjhA6k9ABQk8gBjhg6g");
	this.shape_27.setTransform(423.7,125.9);

	this.shape_28 = new cjs.Shape();
	this.shape_28.graphics.f("rgba(255,255,255,0.281)").s().p("AodCNQjgg7AAhSQAAhRDgg8QDhg5E8AAQE9AADhA5QDgA8AABRQAABSjgA7QjhA6k9AAQk8AAjhg6g");
	this.shape_28.setTransform(434.5,126.1);

	this.shape_29 = new cjs.Shape();
	this.shape_29.graphics.f("rgba(255,255,255,0.281)").s().p("AodCMQjgg6AAhSQAAhSDgg7QDhg5E8AAQE9AADhA5QDgA7AABSQAABSjgA6QjhA8k9gBQk8ABjhg8g");
	this.shape_29.setTransform(445.3,126.3);

	this.shape_30 = new cjs.Shape();
	this.shape_30.graphics.f("rgba(255,255,255,0.281)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg7E8AAQE9AADhA7QDgA6AABSQAABTjgA5QjhA8k9AAQk8AAjhg8g");
	this.shape_30.setTransform(456.1,126.5);

	this.shape_31 = new cjs.Shape();
	this.shape_31.graphics.f("rgba(255,255,255,0.281)").s().p("AodCNQjgg7AAhSQAAhSDgg6QDhg7E8AAQE9AADgA7QDhA6AABSQAABSjhA7QjgA6k9ABQk8gBjhg6g");
	this.shape_31.setTransform(466.9,126.7);

	this.shape_32 = new cjs.Shape();
	this.shape_32.graphics.f("rgba(255,255,255,0.281)").s().p("AodCNQjgg7AAhSQAAhRDgg8QDhg5E8AAQE9AADgA5QDhA8AABRQAABSjhA7QjgA6k9AAQk8AAjhg6g");
	this.shape_32.setTransform(477.8,126.9);

	this.shape_33 = new cjs.Shape();
	this.shape_33.graphics.f("rgba(255,255,255,0.281)").s().p("AodCNQjgg7AAhSQAAhSDgg7QDhg5E8AAQE9AADgA5QDhA7AABSQAABSjhA7QjgA6k9AAQk8AAjhg6g");
	this.shape_33.setTransform(488.6,127.1);

	this.shape_34 = new cjs.Shape();
	this.shape_34.graphics.f("rgba(255,255,255,0.281)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg6E8gBQE9ABDhA6QDgA6AABSQAABTjgA5QjhA8k9AAQk8AAjhg8g");
	this.shape_34.setTransform(499.4,127.3);

	this.shape_35 = new cjs.Shape();
	this.shape_35.graphics.f("rgba(255,255,255,0.28)").s().p("AodCMQjgg6AAhSQAAhSDgg6QDhg7E8AAQE9AADhA7QDgA6AABSQAABSjgA6QjhA7k9ABQk8gBjhg7g");
	this.shape_35.setTransform(510.2,127.6);

	this.shape_36 = new cjs.Shape();
	this.shape_36.graphics.f("rgba(255,255,255,0.28)").s().p("AodCNQjgg7AAhSQAAhRDgg8QDhg5E8AAQE9AADhA5QDgA8AABRQAABSjgA7QjhA6k9AAQk8AAjhg6g");
	this.shape_36.setTransform(521,127.8);

	this.shape_37 = new cjs.Shape();
	this.shape_37.graphics.f("rgba(255,255,255,0.28)").s().p("AodCNQjgg7AAhSQAAhSDgg7QDhg5E8AAQE9AADhA5QDgA7AABSQAABSjgA7QjhA6k9AAQk8AAjhg6g");
	this.shape_37.setTransform(531.8,128);

	this.shape_38 = new cjs.Shape();
	this.shape_38.graphics.f("rgba(255,255,255,0.28)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg6E8gBQE9ABDgA6QDhA6AABSQAABTjhA5QjgA8k9AAQk8AAjhg8g");
	this.shape_38.setTransform(542.7,128.2);

	this.shape_39 = new cjs.Shape();
	this.shape_39.graphics.f("rgba(255,255,255,0.28)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg7E8AAQE9AADgA7QDhA6AABSQAABTjhA5QjgA7k9ABQk8gBjhg7g");
	this.shape_39.setTransform(553.5,128.4);

	this.shape_40 = new cjs.Shape();
	this.shape_40.graphics.f("rgba(255,255,255,0.28)").s().p("AodCNQjgg6AAhTQAAhRDgg8QDhg5E8AAQE9AADgA5QDhA8AABRQAABTjhA6QjgA6k9AAQk8AAjhg6g");
	this.shape_40.setTransform(564.3,128.6);

	this.shape_41 = new cjs.Shape();
	this.shape_41.graphics.f("rgba(255,255,255,0.279)").s().p("AodCNQjgg7AAhSQAAhSDgg7QDhg5E8AAQE9AADgA5QDhA7AABSQAABSjhA7QjgA6k9AAQk8AAjhg6g");
	this.shape_41.setTransform(575.1,128.8);

	this.shape_42 = new cjs.Shape();
	this.shape_42.graphics.f("rgba(255,255,255,0.279)").s().p("AodCMQjgg5AAhTQAAhRDgg7QDhg6E8gBQE9ABDhA6QDgA7AABRQAABTjgA5QjhA8k9AAQk8AAjhg8g");
	this.shape_42.setTransform(585.9,129);

	this.shape_43 = new cjs.Shape();
	this.shape_43.graphics.f("rgba(255,255,255,0.279)").s().p("AodCMQjgg5AAhTQAAhSDgg6QDhg7E8AAQE9AADhA7QDgA6AABSQAABTjgA5QjhA7k9ABQk8gBjhg7g");
	this.shape_43.setTransform(596.7,129.2);

	this.shape_44 = new cjs.Shape();
	this.shape_44.graphics.f("rgba(255,255,255,0.279)").s().p("AodCNQjgg6AAhTQAAhRDgg8QDhg5E8AAQE9AADhA5QDgA8AABRQAABTjgA6QjhA6k9AAQk8AAjhg6g");
	this.shape_44.setTransform(607.6,129.4);

	this.shape_45 = new cjs.Shape();
	this.shape_45.graphics.f("rgba(255,255,255,0.279)").s().p("AodCNQjgg7AAhSQAAhRDgg8QDhg5E8AAQE9AADgA5QDhA8AABRQAABSjhA7QjgA6k9AAQk8AAjhg6g");
	this.shape_45.setTransform(618.4,129.6);

	this.shape_46 = new cjs.Shape();
	this.shape_46.graphics.f("rgba(255,255,255,0.279)").s().p("AodCMQjgg5AAhTQAAhRDgg7QDhg6E8gBQE9ABDgA6QDhA7AABRQAABTjhA5QjgA8k9AAQk8AAjhg8g");
	this.shape_46.setTransform(629.2,129.8);

	this.shape_47 = new cjs.Shape();
	this.shape_47.graphics.f("rgba(255,255,255,0.278)").s().de(-115,-30,230,60);
	this.shape_47.setTransform(640,130,0.667,0.667);

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.shape}]}).to({state:[{t:this.shape_1}]},1).to({state:[{t:this.shape_2}]},1).to({state:[{t:this.shape_3}]},1).to({state:[{t:this.shape_4}]},1).to({state:[{t:this.shape_5}]},1).to({state:[{t:this.shape_6}]},1).to({state:[{t:this.shape_7}]},1).to({state:[{t:this.shape_8}]},1).to({state:[{t:this.shape_9}]},1).to({state:[{t:this.shape_10}]},1).to({state:[{t:this.shape_11}]},1).to({state:[{t:this.shape_12}]},1).to({state:[{t:this.shape_13}]},1).to({state:[{t:this.shape_14}]},1).to({state:[{t:this.shape_15}]},1).to({state:[{t:this.shape_16}]},1).to({state:[{t:this.shape_17}]},1).to({state:[{t:this.shape_18,p:{x:304.7,y:123.7}}]},1).to({state:[{t:this.shape_19,p:{x:315.5,y:123.9}}]},1).to({state:[{t:this.shape_19,p:{x:326.3,y:124.1}}]},1).to({state:[{t:this.shape_20}]},1).to({state:[{t:this.shape_18,p:{x:348,y:124.5}}]},1).to({state:[{t:this.shape_21}]},1).to({state:[{t:this.shape_22}]},1).to({state:[{t:this.shape_23}]},1).to({state:[{t:this.shape_24}]},1).to({state:[{t:this.shape_25}]},1).to({state:[{t:this.shape_26}]},1).to({state:[{t:this.shape_27}]},1).to({state:[{t:this.shape_28}]},1).to({state:[{t:this.shape_29}]},1).to({state:[{t:this.shape_30}]},1).to({state:[{t:this.shape_31}]},1).to({state:[{t:this.shape_32}]},1).to({state:[{t:this.shape_33}]},1).to({state:[{t:this.shape_34}]},1).to({state:[{t:this.shape_35}]},1).to({state:[{t:this.shape_36}]},1).to({state:[{t:this.shape_37}]},1).to({state:[{t:this.shape_38}]},1).to({state:[{t:this.shape_39}]},1).to({state:[{t:this.shape_40}]},1).to({state:[{t:this.shape_41}]},1).to({state:[{t:this.shape_42}]},1).to({state:[{t:this.shape_43}]},1).to({state:[{t:this.shape_44}]},1).to({state:[{t:this.shape_45}]},1).to({state:[{t:this.shape_46}]},1).to({state:[{t:this.shape_47}]},1).wait(1));

	// Cloud
	this.shape_48 = new cjs.Shape();
	this.shape_48.graphics.f("rgba(255,255,255,0.498)").s().de(-115,-30,230,60);
	this.shape_48.setTransform(-60,70);

	this.shape_49 = new cjs.Shape();
	this.shape_49.graphics.f("rgba(255,255,255,0.498)").s().p("AssDTQlRhXABh8QgBh7FRhYQFRhYHbAAQHcAAFRBYQFRBYgBB7QABB8lRBXQlRBZncgBQnbABlRhZg");
	this.shape_49.setTransform(-47.3,70);

	this.shape_50 = new cjs.Shape();
	this.shape_50.graphics.f("rgba(255,255,255,0.498)").s().p("AssDTQlRhXAAh8QAAh7FRhYQFRhYHbAAQHcAAFRBYQFRBYgBB7QABB8lRBXQlRBZncgBQnbABlRhZg");
	this.shape_50.setTransform(-34.7,70);

	this.shape_51 = new cjs.Shape();
	this.shape_51.graphics.f("rgba(255,255,255,0.498)").s().p("AssDTQlRhXAAh8QAAh7FRhYQFRhYHbAAQHcAAFRBYQFRBYAAB7QAAB8lRBXQlRBZncgBQnbABlRhZg");
	this.shape_51.setTransform(-22,70);

	this.shape_52 = new cjs.Shape();
	this.shape_52.graphics.f("rgba(255,255,255,0.498)").s().p("AssDTQlRhXAAh8QAAh7FRhYQFRhYHbAAQHcAAFQBYQFRBYABB7QgBB8lRBXQlQBZncgBQnbABlRhZg");
	this.shape_52.setTransform(-9.4,70);
	this.shape_52._off = true;

	this.shape_53 = new cjs.Shape();
	this.shape_53.graphics.f("rgba(255,255,255,0.498)").s().p("AssDTQlRhXAAh8QAAh7FRhYQFRhYHbAAQHcAAFQBYQFSBYAAB7QAAB8lSBXQlQBZncgBQnbABlRhZg");
	this.shape_53.setTransform(53.9,70);
	this.shape_53._off = true;

	this.shape_54 = new cjs.Shape();
	this.shape_54.graphics.f("rgba(255,255,255,0.498)").s().p("AssDTQlQhXAAh8QAAh7FQhYQFRhYHbAAQHcAAFQBYQFSBYAAB7QAAB8lSBXQlQBZncgBQnbABlRhZg");
	this.shape_54.setTransform(104.5,70);

	this.shape_55 = new cjs.Shape();
	this.shape_55.graphics.f("rgba(255,255,255,0.498)").s().p("AssDTQlQhXAAh8QAAh7FQhYQFRhYHbAAQHcAAFQBYQFRBYAAB7QAAB8lRBXQlQBZncgBQnbABlRhZg");
	this.shape_55.setTransform(117.1,70);

	this.shape_56 = new cjs.Shape();
	this.shape_56.graphics.f("rgba(255,255,255,0.498)").s().p("AssDTQlQhXAAh8QAAh7FQhYQFRhYHbAAQHcAAFRBYQFQBYAAB7QAAB8lQBXQlRBZncgBQnbABlRhZg");
	this.shape_56.setTransform(142.4,70);
	this.shape_56._off = true;

	this.shape_57 = new cjs.Shape();
	this.shape_57.graphics.f("rgba(255,255,255,0.498)").s().p("AssDTQlQhXAAh8QAAh7FQhYQFRhYHbAAQHcAAFRBYQFRBYgBB7QABB8lRBXQlRBZncgBQnbABlRhZg");
	this.shape_57.setTransform(193.1,70);
	this.shape_57._off = true;

	this.shape_58 = new cjs.Shape();
	this.shape_58.graphics.f("rgba(255,255,255,0.498)").s().p("AssDTQlRhXAAh8QAAh7FRhYQFRhYHbAAQHcAAFRBYQFRBYgBB7QAAB8lQBXQlRBZncgBQnbABlRhZg");
	this.shape_58.setTransform(269,70);

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.shape_48,p:{x:-60}}]}).to({state:[{t:this.shape_49,p:{x:-47.3}}]},1).to({state:[{t:this.shape_50,p:{x:-34.7}}]},1).to({state:[{t:this.shape_51}]},1).to({state:[{t:this.shape_52}]},1).to({state:[{t:this.shape_52}]},1).to({state:[{t:this.shape_52}]},1).to({state:[{t:this.shape_52}]},1).to({state:[{t:this.shape_52}]},1).to({state:[{t:this.shape_53}]},1).to({state:[{t:this.shape_53}]},1).to({state:[{t:this.shape_53}]},1).to({state:[{t:this.shape_53}]},1).to({state:[{t:this.shape_54,p:{x:104.5}}]},1).to({state:[{t:this.shape_55,p:{x:117.1}}]},1).to({state:[{t:this.shape_55,p:{x:129.8}}]},1).to({state:[{t:this.shape_56}]},1).to({state:[{t:this.shape_56}]},1).to({state:[{t:this.shape_56}]},1).to({state:[{t:this.shape_56}]},1).to({state:[{t:this.shape_57}]},1).to({state:[{t:this.shape_57}]},1).to({state:[{t:this.shape_57}]},1).to({state:[{t:this.shape_57}]},1).to({state:[{t:this.shape_49,p:{x:243.7}}]},1).to({state:[{t:this.shape_50,p:{x:256.3}}]},1).to({state:[{t:this.shape_58}]},1).to({state:[{t:this.shape_52}]},1).to({state:[{t:this.shape_52}]},1).to({state:[{t:this.shape_52}]},1).to({state:[{t:this.shape_52}]},1).to({state:[{t:this.shape_52}]},1).to({state:[{t:this.shape_53}]},1).to({state:[{t:this.shape_53}]},1).to({state:[{t:this.shape_53}]},1).to({state:[{t:this.shape_53}]},1).to({state:[{t:this.shape_53}]},1).to({state:[{t:this.shape_54,p:{x:408.2}}]},1).to({state:[{t:this.shape_55,p:{x:420.8}}]},1).to({state:[{t:this.shape_56}]},1).to({state:[{t:this.shape_56}]},1).to({state:[{t:this.shape_56}]},1).to({state:[{t:this.shape_56}]},1).to({state:[{t:this.shape_56}]},1).to({state:[{t:this.shape_57}]},1).to({state:[{t:this.shape_57}]},1).to({state:[{t:this.shape_57}]},1).to({state:[{t:this.shape_49,p:{x:534.7}}]},1).to({state:[{t:this.shape_50,p:{x:547.3}}]},1).to({state:[{t:this.shape_48,p:{x:560}}]},1).wait(1));
	this.timeline.addTween(cjs.Tween.get(this.shape_52).wait(4).to({_off:false},0).wait(1).to({x:3.3},0).wait(1).to({x:15.9},0).wait(1).to({x:28.6},0).wait(1).to({x:41.2},0).to({_off:true},1).wait(18).to({_off:false,x:281.6},0).wait(1).to({x:294.3},0).wait(1).to({x:306.9},0).wait(1).to({x:319.6},0).wait(1).to({x:332.2},0).to({_off:true},1).wait(18));
	this.timeline.addTween(cjs.Tween.get(this.shape_53).wait(9).to({_off:false},0).wait(1).to({x:66.5},0).wait(1).to({x:79.2},0).wait(1).to({x:91.8},0).to({_off:true},1).wait(19).to({_off:false,x:344.9},0).wait(1).to({x:357.6},0).wait(1).to({x:370.2},0).wait(1).to({x:382.9},0).wait(1).to({x:395.5},0).to({_off:true},1).wait(13));
	this.timeline.addTween(cjs.Tween.get(this.shape_56).wait(16).to({_off:false},0).wait(1).to({x:155.1},0).wait(1).to({x:167.8},0).wait(1).to({x:180.4},0).to({_off:true},1).wait(19).to({_off:false,x:433.5},0).wait(1).to({x:446.1},0).wait(1).to({x:458.8},0).wait(1).to({x:471.4},0).wait(1).to({x:484.1},0).to({_off:true},1).wait(6));
	this.timeline.addTween(cjs.Tween.get(this.shape_57).wait(20).to({_off:false},0).wait(1).to({x:205.7},0).wait(1).to({x:218.4},0).wait(1).to({x:231},0).to({_off:true},1).wait(20).to({_off:false,x:496.7},0).wait(1).to({x:509.4},0).wait(1).to({x:522},0).to({_off:true},1).wait(3));

	// Background
	this.shape_59 = new cjs.Shape();
	this.shape_59.graphics.lf(["#2EA100","#0C6400"],[0,1],0,45,0,-45).s().dr(-320,-45,640,90);
	this.shape_59.setTransform(320,315);

	this.instance_1 = new lib.sky_background();

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.instance_1},{t:this.shape_59}]}).wait(50));

}).prototype = p = new cjs.MovieClip();
p.nominalBounds = new cjs.Rectangle(145,180,915,446.1);


// symbols:
(lib.sky_background = function() {
	this.initialize(img.sky_background);
}).prototype = p = new cjs.Bitmap();
p.nominalBounds = new cjs.Rectangle(0,0,640,360);


(lib.Leg_Right = function() {
	this.initialize();

	// Layer 1
	this.shape = new cjs.Shape();
	this.shape.graphics.f().s("#000000").ss(10,1,1).p("Ah9kXQgaATgYAdQhKBYAAB8QAAB7BKBYQBJBYBmAAQBnAABKhYQBJhYAAh7QAAgjgGgh");

	this.shape_1 = new cjs.Shape();
	this.shape_1.graphics.f("#703333").s().p("AivC/QhKhXAAh6QAAh9BKhYQAYgdAagSQAJAEAHAHQAJANACAZICUBQQBoA1BZAJQAHAhAAAkQgBB6hIBXQhKBZhngBQhmABhJhZg");

	this.addChild(this.shape_1,this.shape);
}).prototype = p = new cjs.Container();
p.nominalBounds = new cjs.Rectangle(-30,-33,60,66);


(lib.Leg_Left = function() {
	this.initialize();

	// Layer 1
	this.shape = new cjs.Shape();
	this.shape.graphics.f().s("#000000").ss(10,1,1).p("AB+kXQAaATAYAdQBKBYAAB8QAAB7hKBYQhJBYhnAAQhmAAhKhYQhJhYAAh7QAAgjAGgh");

	this.shape_1 = new cjs.Shape();
	this.shape_1.graphics.f("#993333").s().p("AiwC/QhIhXgBh6QAAgkAHghQBZgJBog1ICUhQQACgZAJgNQAHgHAIgEQAbASAYAdQBKBYAAB9QAAB6hKBXQhJBZhngBQhmABhKhZg");

	this.addChild(this.shape_1,this.shape);
}).prototype = p = new cjs.Container();
p.nominalBounds = new cjs.Rectangle(-30,-33,60,66);


(lib.Character = function(mode,startPosition,loop) {
	this.initialize(mode,startPosition,loop,{});

	// Left Leg
	this.instance = new lib.Leg_Left("synched",0);
	this.instance.setTransform(20,50.1,0.999,0.999,13.8,0,0,-11,-17.9);

	this.timeline.addTween(cjs.Tween.get(this.instance).wait(1).to({regX:0,regY:0,scaleX:1,scaleY:1,rotation:10.3,x:27.6,y:69.6},0).wait(1).to({rotation:6.6,x:28.8,y:69.1},0).wait(1).to({rotation:3,x:30,y:68.5},0).wait(1).to({rotation:-0.7,x:31.2,y:67.8},0).wait(1).to({rotation:-4.4,x:32.3,y:67.1},0).wait(1).to({rotation:-8,x:33.4,y:66.3},0).wait(1).to({rotation:-11.7,x:34.4,y:65.4},0).wait(1).to({rotation:-7.8,x:33.3,y:66.3},0).wait(1).to({rotation:-3.9,x:32.2,y:67.2},0).wait(1).to({rotation:0,x:31,y:68},0).wait(1).to({rotation:3.9,x:29.7,y:68.7},0).wait(1).to({rotation:7.8,x:28.4,y:69.3},0).wait(1).to({rotation:11.7,x:27.1,y:69.8},0).wait(1).to({rotation:15.5,x:25.7,y:70.2},0).wait(1));

	// Hair
	this.shape = new cjs.Shape();
	this.shape.graphics.f().s("#000000").ss(8,1,1).p("AiVBkQC8gpBvie");
	this.shape.setTransform(35,-70);

	this.shape_1 = new cjs.Shape();
	this.shape_1.graphics.f().s("#000000").ss(8,1,1).p("AiVBkQCog9CDiK");
	this.shape_1.setTransform(35,-70);

	this.shape_2 = new cjs.Shape();
	this.shape_2.graphics.f().s("#000000").ss(8,1,1).p("AiVBkQCVhRCWh2");
	this.shape_2.setTransform(35,-70);

	this.shape_3 = new cjs.Shape();
	this.shape_3.graphics.f().s("#000000").ss(8,1,1).p("AiVBkQCChkCphj");
	this.shape_3.setTransform(35,-70);

	this.shape_4 = new cjs.Shape();
	this.shape_4.graphics.f().s("#000000").ss(8,1,1).p("AiVBkQBvh3C8hQ");
	this.shape_4.setTransform(35,-70);

	this.shape_5 = new cjs.Shape();
	this.shape_5.graphics.f().s("#000000").ss(8,1,1).p("AiVBkQBbiLDQg8");
	this.shape_5.setTransform(35,-70);

	this.shape_6 = new cjs.Shape();
	this.shape_6.graphics.f().s("#000000").ss(8,1,1).p("AiVBkQBHifDkgo");
	this.shape_6.setTransform(35,-70);

	this.shape_7 = new cjs.Shape();
	this.shape_7.graphics.f().s("#000000").ss(8,1,1).p("AiVBkQAziyD4gV");
	this.shape_7.setTransform(35,-70);

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.shape}]}).to({state:[{t:this.shape_1}]},1).to({state:[{t:this.shape_2}]},1).to({state:[{t:this.shape_3}]},1).to({state:[{t:this.shape_4}]},1).to({state:[{t:this.shape_5}]},1).to({state:[{t:this.shape_6}]},1).to({state:[{t:this.shape_7}]},1).to({state:[{t:this.shape_6}]},1).to({state:[{t:this.shape_5}]},1).to({state:[{t:this.shape_4}]},1).to({state:[{t:this.shape_3}]},1).to({state:[{t:this.shape_2}]},1).to({state:[{t:this.shape_1}]},1).to({state:[{t:this.shape}]},1).wait(1));

	// Face
	this.shape_8 = new cjs.Shape();
	this.shape_8.graphics.f().s("#000000").ss(8,1,1).p("AETAAQAAApgeAdQgdAegpAAQgqAAgdgeQgdgdAAgpQAAgoAdgeQAdgdAqAAQApAAAdAdQAeAeAAAogAhKAAQAAApgdAdQgdAegqAAQgpAAgegeQgdgdAAgpQAAgoAdgeQAegdApAAQAqAAAdAdQAdAeAAAog");
	this.shape_8.setTransform(-12.5,-20);

	this.shape_9 = new cjs.Shape();
	this.shape_9.graphics.f().s("#000000").ss(10,1,1).p("AjHAhQDHiDDICD");
	this.shape_9.setTransform(-13,14.7);

	this.shape_10 = new cjs.Shape();
	this.shape_10.graphics.f("#FFCC00").s().p("ABoBGQgdgdgBgpQABgoAdgdQAdgdAqAAQApAAAdAdQAeAdAAAoQAAApgeAdQgdAdgpABQgqgBgdgdgAj0BGQgdgdAAgpQAAgoAdgdQAdgdAqAAQApAAAdAdQAdAdABAoQgBApgdAdQgdAdgpABQgqgBgdgdg");
	this.shape_10.setTransform(-12.5,-20);

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.shape_10},{t:this.shape_9},{t:this.shape_8}]}).wait(15));

	// Body
	this.shape_11 = new cjs.Shape();
	this.shape_11.graphics.f().s("#000000").ss(10,1,1).p("AKKAAQAAE2i/DcQi+DckNAAQkMAAi+jcQi/jcAAk2QAAk1C/jcQC+jcEMAAQENAAC+DcQC/DcAAE1g");

	this.shape_12 = new cjs.Shape();
	this.shape_12.graphics.f("#993333").s().p("AnKISQi/jcABk2QgBk1C/jcQC/jcELABQEMgBC/DcQC/DcgBE1QABE2i/DcQi/DbkMAAQkLAAi/jbg");

	this.timeline.addTween(cjs.Tween.get({}).to({state:[{t:this.shape_12},{t:this.shape_11}]}).wait(15));

	// Right Leg
	this.instance_1 = new lib.Leg_Right("synched",0);
	this.instance_1.setTransform(-20.1,50,0.999,0.999,-17.8,0,0,9.8,-15);

	this.timeline.addTween(cjs.Tween.get(this.instance_1).wait(1).to({regX:0,regY:0,scaleX:1,scaleY:1,rotation:-12.8,x:-26.3,y:66.8},0).wait(1).to({rotation:-7.9,x:-27.7,y:66.2},0).wait(1).to({rotation:-2.9,x:-29.1,y:65.5},0).wait(1).to({rotation:2,x:-30.4,y:64.6},0).wait(1).to({rotation:7,x:-31.6,y:63.7},0).wait(1).to({rotation:12,x:-32.7,y:62.6},0).wait(1).to({rotation:16.9,x:-33.8,y:61.5},0).wait(1).to({rotation:11.5,x:-32.6,y:62.7},0).wait(1).to({rotation:6,x:-31.4,y:63.9},0).wait(1).to({rotation:0.5,x:-30,y:64.9},0).wait(1).to({rotation:-4.9,x:-28.5,y:65.8},0).wait(1).to({rotation:-10.4,x:-27,y:66.5},0).wait(1).to({rotation:-15.8,x:-25.4,y:67.1},0).wait(1).to({rotation:-21.3,x:-23.7,y:67.5},0).wait(1));

}).prototype = p = new cjs.MovieClip();
p.nominalBounds = new cjs.Rectangle(-70,-84,140,187);

})(lib = lib||{}, images = images||{}, createjs = createjs||{});
var lib, images, createjs;