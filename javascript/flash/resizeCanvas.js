// CreateJS community support: http://community.createjs.com/discussions/createjs/547-resizing-canvas-and-its-content-proportionally-cross-platform
// calculates the required scale factor of the stage & resizes the canvas
function onResize()
{
// browser viewport size
var w = window.innerWidth;
var h = window.innerHeight;

// stage dimensions
var ow = 640; // your stage width
var oh = 480; // your stage height

if (keepAspectRatio)
{
    // keep aspect ratio
    var scale = Math.min(w / ow, h / oh);
    stage.scaleX = scale;
    stage.scaleY = scale;

   // adjust canvas size
   stage.canvas.width = ow * scale;
  stage.canvas.height = oh * scale;
}
else
{
    // scale to exact fit
    stage.scaleX = w / ow;
    stage.scaleY = h / oh;

    // adjust canvas size
    stage.canvas.width = ow * stage.scaleX;
    stage.canvas.height = oh * stage.scaleY;
   }

 // update the stage
stage.update()
}

// trigger onResize in the onresize window event:
window.onresize = function()
{
     onResize();
}
// call as soon as the page is loaded and the stage is created
stage = new createjs.Stage("canvas");
onResize();

<head>
   <script src="http://code.createjs.com/createjs-2013.05.14.min.js"></script>
   <script type="text/javascript" src="MyGame.js"></script>
</head>

<body onload="MyGame.init();">
     <canvas id="canvas"></canvas>
</body>

MyGame = {};

MyGame.onResize = function()
{
   // the resizing code from the earlier example
}

MyGame.init = function()
{
   stage = new createjs.Stage("canvas");
   MyGame.onResize(); // call the resizing method

  window.onresize = function()
  {
     MyGame.onResize(); // also call the method when we resize the window
  }
}

