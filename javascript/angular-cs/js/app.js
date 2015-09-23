// Main module for my angular js application
(function () {
	var app = angular.module('store', []);
	
	var tea = 'earl grey';

	app.controller('PanelController', function () {
		this.tab = 1;
		this.setTab = function (tnumber) {
			this.tab = tnumber;
		};
		this.isActive = function (tnumber) {
			return this.tab === tnumber;
		};
	});
	
	app.controller('ReviewController', function() {
		this.review = {};
		this.addReview = function(product) {
			this.review.createdOn = Date.now();
			product.reviews.push(this.review);
			this.review = {};
		};
	});

	app.controller('StoreController', function () {
		this.products = gems;
	});

	var gems = [
		{
			name: 'Dodecahedron',
			price: 2.95,
			description: 'this is a fairly cheap dodecahedron',
			canPurchase: true,
			soldOut: false,
			reviews: [
				{
					stars: 5,
					body: 'this is a narly nasty nuub',
					author: 'ntg@gmail.com'
				},
				{
					stars: 2,
					body: 'this is NOT a narly nasty nuub',
					author: 'I AM the grinch'
				},
				{
					stars: 4,
					body: 'this is ok',
					author: 'baldur'
				}
			]
		},
		{
			name: 'Blue Diamond',
			price: 22,
			description: 'this is a fairly expensive diamond. It was mined on Europa, the largest moon of Jupiter',
			canPurchase: false,
			soldOut: false
		},
		{
			name: 'Mud',
			price: 0.95,
			description: 'this is our cheapest gem. It is made entirely of dried mud',
			canPurchase: true,
			soldOut: false,
			reviews: [
				{
					stars: 3,
					body: 'it was the best of gems, it was the worst of gems....',
					author: 'Mr Dickens'
				},
				{
					stars: 4,
					body: 'meh - this is ok',
					author: 'baldur'
				}
			]
		}
	]
})();