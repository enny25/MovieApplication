'use strict';

angular.module('myApp.DocumentationView', ['ngRoute'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/docview', {
    templateUrl: 'app/Documentation/docview.html',
    controller: 'viewdoc'
  });
}])

.controller('viewdoc', ["InfoFactory","InfoService",function(InfoFactory,InfoService) {

}]);