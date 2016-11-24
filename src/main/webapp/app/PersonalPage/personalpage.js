'use strict';

angular.module("myApp.personalpage", ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/personalpage', {
                    templateUrl: 'app/PersonalPage/viewPersonalPage.html',
                    controller: 'personalPageController',
                    controllerAs: 'ppctrl'
                });
            }])
        
        .controller('personalPageController', function ($http, $window, $scope ){
            $http({
                url:'api/personalpage/viewPersonalPage'
            })
            
            
        });
        
        


