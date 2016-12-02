'use strict';

angular.module('myApp.PersonalProfile', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/profile', {
                    templateUrl: 'app/PersonalProfile/profile.html',
                    controller: 'profileCtrl'
                });
            }])

        .controller('profileCtrl', function (InfoFactory, $scope, usernameInfo) {
            $http({
                url: 'api/profile/'+usernameInfo.getUsername(),
                dataType: 'json',
                method: 'GET',
                headers: {
                    "Content-Type": "application/json"
                }



            }).then(function successCallback(res) {

                $scope.listDetails = res.data;
            }, function errorCallback(res) {
                console.log("Does not work");
            });
        });