'use strict';

angular.module('myApp.PersonalProfile', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/profile', {
                    templateUrl: 'app/PersonalProfile/profile.html',
                    controller: 'profileCtrl'
                });
            }])

        .controller('profileCtrl', function (InfoFactory, $scope, usernameInfo, $http, $rootScope) {
            $scope.cout = function (movie) {
                $rootScope.$broadcast('CallParentMethod', movie.movie.imdbid);
            };
            $http({
                url: 'api/profile/' + usernameInfo.getUsername(),
                dataType: 'json',
                method: 'GET',
                headers: {
                    "Content-Type": "application/json"
                }




            }).then(function successCallback(res) {

                $scope.listDetails = res.data;
                console.log($scope.listDetails);
            }, function errorCallback(res) {
                console.log("Does not work");
            }
            );
        });