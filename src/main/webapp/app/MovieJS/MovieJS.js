'use strict';

angular.module('myApp.MovieJS', ['ngRoute'])


        .controller('movieController', function ($http, $window, $scope, $uibModal, usernameInfo) {
            $scope.username = usernameInfo.getUsername();
            $scope.openeditModal = function (movie) {
                var modalInstance = $uibModal.open({
                    animation: true,
                    templateUrl: 'movieReview.html',
                    controller: 'movieReviewController',
                    resolve: {
                        items: function () {
                            return movie;
                        }
                    }
                });
            };
            
            
            $scope.showButton = true;
            $scope.searchMovie = function () {
                console.log("Before" + $scope.showButton);
                $scope.showButton = true;
                console.log("After: " + $scope.showButton);
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
        // Review area.
        .controller('movieReviewController', function ($http, $window, $scope, $uibModalInstance,items,usernameinfo) {
            $scope.close = function () {
                $uibModalInstance.close();
            };
            $scope.movie=items;
            console.log(items);
            $scope.ok=function(){
                console.log($scope.movieDetails);
                var movieReview = {review : movie.review, movie: $scope.movie.imdbid, username: usernameInfo.getUsername()};
                console.log(movieReview);
            
            $http({
                    url: 'api/movies/movie',
                    dataType: 'json',
                    method: 'POST',
                    data: postReview,
                    headers: {
                        "Content-Type": "application/json"
                    }


            
                })};
            
        })
        .controller('datCtrl', function ($scope) {
            $scope.today = new Date();
        })
        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/movie', {
                    templateUrl: 'app/MovieJS/view2.html',
                    controller: 'movieController'
                });
            }]);