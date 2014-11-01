(function(bms) {
	"use strict";

	bms.barChartData = {
		labels : ["January","February","March","April","May","June","July"],
		datasets : [
			{
				fillColor : "rgba(220,220,220,0.5)",
				strokeColor : "rgba(220,220,220,1)",
				data : [65,59,90,81,56,55,40]
			},
			{
				fillColor : "rgba(151,187,205,0.5)",
				strokeColor : "rgba(151,187,205,1)",
				data : [28,48,40,19,96,27,100]
			},
							{
				fillColor : "rgba(0,187,205,0.5)",
				strokeColor : "rgba(0,187,205,1)",
				data : [24,28,12,19,96,24,23]
			}
		]
	};

	bms.pieData = [
		{
			value: 30,
			color:"#18063A"
		},
		{
			value : 50,
			color : "#2C1657"
		},
		{
			value : 80,
			color : "#665091"
		},
		{
			value : 20,
			color : "#462E74"
		}
	];

	var app = angular.module('bar', []);

	bms.mycanvas;

	app.controller('MasterCtrl', function($scope) {
		$scope.overlay = false;
		$scope.title="Bar Chart Demo";
		$scope.ngrid = 4;
		$scope.row = 1;
		$scope.col = 1;

		$scope.drawGrid = function() {
			var cnv = $("#mycanvas")[0];
			var ctx = cnv.getContext("2d");
			var w = cnv.width;
			var h = cnv.height;
			ctx.clearRect(0,0,w,h);
			var yoff = 10; // y-offset of grid
			var szg = h - 2*yoff; // height and width of the grid
			var xoff = (w-szg)/2.0; // x-offset of grid
			ctx.lineWidth=1;
			ctx.strokeStyle='rgba(0,0,0,0.5)';
			ctx.strokeRect(xoff, yoff, szg, szg);
			ctx.fillStyle=bms.fillStyleBlue;
			var sqr = szg / $scope.ngrid; // size of each square
			bms.perc = new bms.Percolation($scope.ngrid);
			for (var j=0; j<$scope.ngrid; j++) {
				for (var i=0; i<$scope.ngrid; i++) {
					// draw the grid
					ctx.strokeRect( (i*sqr) + xoff, (j*sqr) + yoff,sqr,sqr);
					// draw the rectangles
					var rect = new bms.Rectangle(
							bms.perc.getArrayIndex(i+1,j+1),
							(i*sqr) + xoff + 1,
							(j*sqr) + yoff + 1,
							sqr - 2,
							sqr - 2,
							bms.fillStyleBlack
						);
					bms.perc.grid.push(rect);
					bms.perc.rnd.push(0);
					ctx.fillStyle = rect.fillStyle;
					ctx.fillRect( rect.x, rect.y, rect.w, rect.h);
					//console.log(perc.getArrayIndex(i+1,j+1), i+1, j+1);
				};
			};
			console.log(bms.perc.grid);
			console.log(bms.perc.rnd);
		};

		var drawRect = function(rect) {
			var cnv = $("#mycanvas")[0];
			var ctx = cnv.getContext("2d");
			ctx.fillStyle = rect.fillStyle;
			ctx.fillRect( rect.x, rect.y, rect.w, rect.h);
		};

		$scope.openCell = function(i,j) {
			console.log(i,j);
			if(!bms.perc || !bms.perc.grid) return;
			var x = bms.perc.getArrayIndex(i,j);
			console.log("index: ", x);
			if (x === undefined || x < 0 || x >= bms.perc.grid.length) {
				console.log("Array Index out of Bounds: ",x);
				return;
			};
			var rect = bms.perc.grid[x];
			rect.fillStyle = bms.fillStyleWhite;
			drawRect(rect);
			i = 55; j=44;
		};

		$scope.makePie = function() {
			$scope.overlay = true;
			var cnv = $("#mycanvas")[0];
			var w = cnv.width;
			var h = cnv.height;
			var ctx = cnv.getContext("2d");
			ctx.clearRect(0,0,w,h);
			var chart = new Chart(ctx);
			var myPie = chart.Pie(bms.pieData);
		};

		$scope.makeChart = function() {
			$scope.overlay = true;
			var cnv = $("#mycanvas")[0];
			var w = cnv.width;
			var h = cnv.height;
			var ctx = cnv.getContext("2d");
			ctx.clearRect(0,0,w,h);
			var chart = new Chart(ctx);
			var myBar = chart.Bar(bms.barChartData, {barShowStroke: false});
			chart.Bar.defaults.animation = true;
		};

		$scope.makeGrid = function() {
			$scope.overlay = true;
			var cnv = $("#mycanvas")[0];
			var ctx = cnv.getContext("2d");
			var w = cnv.width;
			var h = cnv.height;
			ctx.clearRect(0,0,w,h);
			console.log(w,h);
			ctx.fillStyle = 'rgba(0,0,0,0.1)';
			ctx.fillRect(0,0,w,h);

		};


		$scope.hideOverlay = function() {
			$scope.overlay = false;
		};
	});

})( window.bms = window.bms || {});