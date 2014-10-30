'use strict';
if (!window.bms) {
    window.bms = {};
}

(function(bms) {	
	bms.gf = 'melissa';
})(window.bms);

(function(bms) {
	bms.kid = 'rafael';
	bms.getGirlFriend = function() {
		return bms.gf;
	}
})(window.bms);

