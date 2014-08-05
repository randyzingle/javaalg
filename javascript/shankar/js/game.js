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

		// get handle for game canvas and context
		game.canvas = $('#gamecanvas')[0];
		game.context = game.canvas.getContext('2d');
	},

	showLevelScreen: function() {
		$('.gamelayer').hide();
		$('#levelselectionscreen').show('slow');
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
		console.log(levelnumber);
	}
}