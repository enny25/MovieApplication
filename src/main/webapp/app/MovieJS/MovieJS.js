'use strict';

angular.module('myApp.MovieJS', ['ngRoute'])


        .controller('movieController', function ($http, $window, $scope) {
            $scope.movieInfo = {Name: "ASDF"};
            $scope.addMovie = function () {

                var postObject = $scope.titleid;

                console.log("Adding movie: " + postObject);
                $http({
                    url: 'api/movies/createByName',
                    dataType: 'json',
                    method: 'POST',
                    data: {title: postObject},
                    headers: {
                        "Content-Type": "application/json"
                    }



                }).then(function successCallback(res) {
                    console.log("Works");
                }, function errorCallback(res) {
                    console.log("Does not work");
                });

            };
            $scope.searchMovie = function () {

                var postObject = $scope.movie;
                $scope.movie = {};
                if (postObject.type == 1) {
                    postObject.imdbid = postObject.info;
                    var url = 'api/movies/movieById';
                    console.log(postObject);
                } else {
                    postObject.title = postObject.info;
                    var url = 'api/movies/movie';
                    console.log(postObject);
                }


                $http({
                    url: 'api/movies/movie',
                    dataType: 'json',
                    method: 'POST',
                    data: postObject,
                    headers: {
                        "Content-Type": "application/json"
                    }



                }).then(function successCallback(res) { 
                    $scope.movieInfo = res.data;
                    $window.location.href = '#/movie';
                    
                }, function errorCallback(res) {
                    console.log("Does not work");
                    
                });

            };
        })
        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/movie', {
                    templateUrl: 'app/MovieJS/view2.html',
                    controller: 'movieController'
                });
            }]);