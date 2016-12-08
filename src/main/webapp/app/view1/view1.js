'use strict';

angular.module('myApp.view1', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'app/view1/view1.html',
    controller: 'View1Ctrl',
    controllerAs : 'ctrl'
  });
}])

.controller('View1Ctrl', ["InfoFactory","InfoService",function(InfoFactory,InfoService) {
  this.msgFromFactory = InfoFactory.getInfo();
  this.msgFromService = InfoService.getInfo();
  $(document).ready(function () {

                $("#slider").owlCarousel({
                    autoPlay: 1000, //Set AutoPlay to 3 seconds

                    items: 4,
                    itemsDesktop: [1199, 3],
                    itemsDesktopSmall: [979, 3]

                });

            });
}]);