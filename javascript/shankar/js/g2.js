// use the graphics context obtained for the second canvas to draw some images

var skadi;

var loadImage = function() {
	var img = new Image();
	img.src = '../images/skadi.jpg';
	img.onload = function() {
		skadi = img;
		drawImage(skadi);
	};

};

var drawImage = function(img) {
	// get the graphics context
	var c = $('#canvasg2')[0].getContext('2d');

	// now draw some images
	// image ref, x, y
	c.drawImage(img,0,0);

	var w = img.width;
	var h = img.height;
	// image, x, y, width, height (scales the image)
	c.drawImage(img, 0, 370, 100,100);

	// image, sourcex, sourcey, sourceWidth, sourceHeight, x, y, width, height (use defined part of image)
	c.drawImage(img, 60, 60, 100, 100, 90, 370, 100, 100);

	// now traslate and rotate the context and draw the image
	c.translate(300, 370);
	c.rotate(Math.PI / 4);
	c.drawImage(img, 0,0, 200, 200);
	c.font = '26px Arial';
	c.fillText('This is skadi', 0, 0);

};