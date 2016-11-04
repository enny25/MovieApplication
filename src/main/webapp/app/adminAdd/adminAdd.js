'use strict';

angular.module('myApp.adminAdd', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/adminAdd', {
                    templateUrl: 'app/adminAdd/add.html',
                    controller: 'adminAddController',
                    controllerAs: 'ctrl'
                });
            }])

        .controller('adminAddController', function ($scope, $http) {
            $scope.addMovie = function () {

                var movieGet = $scope.movie;
                var postObject = {};
                if (movieGet.type == 1) {
                    postObject.imdbid = movieGet.info;
                    var url = 'api/movies/createById';
                    console.log(postObject);
                } else {
                    postObject.title = movieGet.info;
                    var url = 'api/movies/createByName';
                    console.log(postObject);
                }
                console.log("Adding movie: " + postObject);
                $http({
                    url: url,
                    dataType: 'json',
                    method: 'POST',
                    data: postObject,
                    headers: {
                        "Content-Type": "application/json"
                    }



                }).then(function successCallback(res) {
                    console.log("Works");
                }, function errorCallback(res) {
                    console.log("Does not work");
                });

            };
        });