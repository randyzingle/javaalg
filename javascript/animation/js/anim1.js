var cloud = document.querySelector("#mainContent");

cloud.addEventListener("transitionend", detectTheEnd, false);

function detectTheEnd(e) {
	console.log(e);
}

var requestAnimationFrame = window.requestAnimationFrame || 
							window.mozRequestAnimationFrame || 
							window.webkitRequestAnimationFrame || 
							window.msRequestAnimationFrame;