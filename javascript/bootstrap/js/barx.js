(function(bms) {
	bms.speech = "it was the best of times, it was the worst of times.";

	bms.fillStyleBlack = 'rgba(0,0,0,1)';
	bms.fillStyleWhite = 'rgba(255,255,255,1)';
	bms.fillStyleBlue = 'rgba(0,0,255,1)';

	bms.Rectangle = function(idx,x,y,w,h,fillStyle) {
		this.idx = idx;
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.fillStyle = fillStyle;
	};

	bms.Percolation = function(n) {
		// n = size of the grid
		this.n = n;
		this.grid = [];
		this.rnd = [];
		this.getArrayIndex = function(i,j) {
			i = parseInt(i);
			j = parseInt(j);
			if (i < 1 || i > n) return;
			if (j < 1 || j > n) return;
			x = (i-1)*n + j - 1;
			console.log(i,j,n,x);
			return x;
		};
	};

})(window.bms = window.bms || {});