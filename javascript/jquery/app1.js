$(document).ready(function() {
	console.log('jquery loaded');
	var ws = new WebSocket("ws://local.amplify.com:8080/rest1/chat");
	$('.photos').on('mouseenter', 'li', function() {
		console.log('mouseenter', this);
		$(this).find('span').slideDown();
		ws.send("Hi from " + $(this).find('span').text());
	});
	$('.photos').on('mouseleave', 'li', function() {
		console.log('mouseleave');
		$(this).find('span').slideUp();
	});
	ws.onmessage = function(event) {
		console.log(event.data);
	}
	
});