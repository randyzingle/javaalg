'use strict';

$(window).load(function() {
	game.init();
});

var game = {
	init: function() {
		// hide all gamelayers and show start screen
		$('.gamelayers').hide();
		$('#gamestartscreen').show();
		// intialize the levels
		levels.init();
		// load the game assets
		loader.init();

		// get handle for game canvas and context
		game.canvas = $('#gamecanvas')[0];
		game.context = game.canvas.getContext('2d');
	},

	showLevelScreen: function() {
		$('.gamelayer').hide();
		$('#levelselectionscreen').show('slow');
	}
};

var loader = {
	loaded: true,
	loadedCount:0, // number of assets loaded so far
	totalCount:0, // total number of assets that we plan to load

	init : function() {
		// check sound support
		var mp3Support, oggSupport;
		var audio = document.createElement('audio');
		if (audio.canPlayType) {
			mp3Support = "" != audio.canPlayType('audio/mpeg');
			oggSupport = "" != audio.canPlayType('audio/ogg; codecs="vorbis"')
		} else {
			mp3Support = false;
			oggSupport = false;
		};
		//set the sound file extension
		loader.soundFileExtn = oggSupport?'.ogg':(mp3Support?'.mp3':undefined);
	},

    loadImage : function(url) {
        this.totalCount++;
        this.loaded = false;
        $('#loadingscreen').show();
        var image = new Image();
        image.src = url;
        image.onload = loader.itemLoaded;
        return image;
    },

    // why do I need this soundF change?
    soundFileExtn: "ogg",

    loadSound: function(url) {
    	this.totalCount++;
    	this.loaded = false;
    	$('#loadingscreen').show();
    	var audio = new Audio();
    	audio.src = url + loader.soundFileExtn;
    	audio.addEventListener("canplaythrough", loader.itemLoaded, false);
    	return audio;
    },

    itemLoaded : function() {
    	loader.loadedCount++;
    	$('#loadingmessage').html('Loaded ' + loader.loadedCount 
    		+ ' of ' + loader.totalCount);
    	if (loader.loadedCount === loader.totalCount) {
    		loader.loaded = true;
    		$('#loadingscreen').hide();
    		if(loader.onload) {
    			loaded.onload();
    			loader.onload = undefined;
    		}
    	}
    }
};

var levels = {
	data: [
		{
			foreground:'desert-foreground',
			background:'clouds-background',
			entities:[]
		},
		{
			foreground:'desert-foreground',
			background:'clouds-background',
			entities:[]
		}
	],
	init: function() {
		// create the level selection buttons
		var html = '';
		for (var i=0; i<levels.data.length; i++) {
			html += '<input type="button" value="'+(i+1)+'">';
		};
		$('#levelselectionscreen').html(html);
		// add event handlers
		$('#levelselectionscreen input').click(function() {
			levels.load(this.value-1);
			$('#levelselectionscreen').hide();
		});
	},

	// load data and images for the selected level
	load: function(levelnumber) {
		game.currentLevel = {number: levelnumber, hero:[]};
		game.score = 0;
		$('#score').html('Score: ' + game.score);
		var level = levels.data[levelnumber];
		// load background, foreground, and slingshot images
		game.currentLevel.backgroundImage = loader.loadImage('images/backgrounds/'
			+ level.background + '.png');
		game.currentLevel.foregroundImage = loader.loadImage('images/backgrounds/'
			+ level.foreground + '.png');
		game.slingshotImage = loader.loadImage('images/slingshot.png');
		game.slingshotFrontImage = loader.loadImage('images/slingshot-front.png');

		if (loader.loaded) {
			game.start();
		} else {
			loader.onload = game.start;
		}
	}
}