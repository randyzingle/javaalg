// simple canvas script
var gt = {};

var init = function() {

	// hide the image that i've loaded in the html page
	var image = $('#skadi');
	image.hide();

	var canvas = $('#canvasg1')[0];
	gt.c = canvas.getContext('2d');

	var c = gt.c;

	// fill rectangles (x,y,width, height)
	c.fillRect(200,10,100,100);
	c.fillRect(50,70,90,30);

	// just draw outlines
	c.strokeRect(110,10,50,50);
	c.strokeRect(30,10,50,50);

	// clear out a rectangle
	c.clearRect(210,20,30,20);
	c.clearRect(260,20,30,20);

	// drawing a complex path
	// use beginPath() to start recording a shape
	c.beginPath();

	// use moveTo() lineTo() and arc() to create the shape
	c.moveTo(10,120);
	c.lineTo(10,180);
	c.lineTo(110,150);

	// optionally use closePath() to close the shape

	// use either stroke() or fill() to draw an outline or filled shape (fill autocloses any paths)
	c.fill();

	// more shapes
	c.beginPath();
	c.moveTo(140,160);
	c.lineTo(140,220);
	c.lineTo(40,190);
	c.closePath();
	c.stroke();

	c.beginPath();
	c.moveTo(160,160);
	c.lineTo(170,220);
	c.lineTo(240,210);
	c.lineTo(260,170);
	c.lineTo(190,140);
	c.closePath();
	c.stroke();

	c.beginPath();
	// x,y,radius,startAngle,endAngle,anticlockwise
	c.arc(100,300,40,0,Math.PI,true);
	c.stroke();

	c.beginPath();
	c.arc(100,300,30, 0,2*Math.PI, true);
	c.fill();

	// drawing text
	c.font = '32pt Arial';
	c.fillText('Baldur is a dog', 330, 40);

	// set stroke and fill styles
	c.fillStyle = 'red';
	c.fillRect(310,160,100,50);
	c.fillRect(420,160,100,50);
	c.strokeStyle = 'green';
	c.strokeRect(310,240,100,50);


	c.fillStyle = 'rgba(0,250,0,0.5)';
	c.shadowColor = 'rgba(0,250,0,0.30)';
	c.shadowOffsetX = 6;
	c.shadowOffsetY = 6;
	c.fillRect(450,180,100,50);

	// draw the images
	drawImage();


};