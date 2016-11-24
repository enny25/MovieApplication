'use strict';

angular.module("myApp.UserPage", ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/UserPageScript', {
                    templateUrl: 'app/userPage/UserPage.html',
                    controller: 'personalPageController',
                    controllerAs: 'ppctrl'
                });
            }])
        
        .controller('personalPageController', function ($http, $window, $scope ){
            $http({
                url:'api/personalpage/viewPersonalPage'
            })
            
            
        });


////angular.module('myApp.UserPage', ['ngRoute'])
//
//        .controller('userPageController', function ($http, $window, $scope) {
//            $http({
//                url: 'api/profile/UserPage',
//                dataType: 'json',
//                method: 'GET',
//                headers: {
//                    "Content-Type": "application/json"
//                }
//            }).then(function successCallback(res) {
//                $scope.listDetailts = res.data;
//            }, function errorCallback(res) {
//                console.log("Does not work");
//            });
//        });