'use strict';

angular.module('myApp.MovieJS', ['ngRoute'])


        .controller('movieController', function ($http, $window, $scope) {
            
            
            $scope.searchMovie = function () {

                var movieGet = $scope.movie;

                var postObject = {};
                $scope.movie = {};
                if (movieGet.type == 1) {
                    postObject.imdbid = movieGet.info;
                    var url = 'api/movies/movieById';
                    console.log(postObject);
                } else {
                    postObject.title = movieGet.info;
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
                    console.log(res.data)
                    $scope.movieDetails = res.data;
                    $window.location.href = '#/movie';
                    
                }, function errorCallback(res) {
                     $scope.openErrorModal("This movie does not exist in our List!");
                    
                });

            };
        })
        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/movie', {
                    templateUrl: 'app/MovieJS/view2.html',
                    controller: 'movieController'
                });
            }]);