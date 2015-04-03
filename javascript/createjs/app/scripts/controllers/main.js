'use strict';

/**
 * @ngdoc function
 * @name createappApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the createappApp
 */
angular.module('createappApp')
  .controller('MainCtrl', function ($scope) {
    $scope.awesomeThings = [
      'HTML5 Boilerplate',
      'AngularJS',
      'Karma'
    ];
  });
