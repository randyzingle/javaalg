'use strict';

/**
 * @ngdoc function
 * @name createappApp.controller:AboutCtrl
 * @description
 * # AboutCtrl
 * Controller of the createappApp
 */
angular.module('createappApp')
  .controller('AboutCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
