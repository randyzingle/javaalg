var socket = io();
$(function() { // same as $(document.ready(function() {}))
	$('form').submit(function() {
		socket.emit('chat message', $('#m').val());
		$('#m').val('');
		return false;
	});

	$('#popupb').click(function() {
		$('.popup').toggle(1000);
	});

	socket.on('chat message', function(msg) {
		$('#messages').append($('<li>').text(msg));
	});
});