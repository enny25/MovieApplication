'use strict';

angular.module('myApp.MovieJS', ['ngRoute'])


        .controller('movieController', function ($http, $window, $scope, $rootScope, $uibModal, usernameInfo) {

            $scope.checkImage = function (image) {
                if (image == "N/A") {
                    return "images/no-image.png";
                }
                return image;
            }
            $rootScope.$on("CallParentMethod", function (event, string) {
                $scope.movie = {type: "1", info: string};
                $scope.searchMovie();
            });

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

            $scope.options = [
                {info: "Search By Title", type: "0"},
                {info: "Search By ID", type: "1"}
            ];
            $scope.selectedOption = $scope.options[0];
            $scope.setOption = function () {
                $scope.movie.type = $scope.selectedOption; 
            };
            $scope.showButton = true;
            $scope.searchMovie = function () {


                $scope.showButton = true;

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
                    url: url,
                    dataType: 'json',
                    method: 'POST',
                    data: postObject,
                    headers: {
                        "Content-Type": "application/json"
                    }



                }).then(function successCallback(res) {


                    $scope.movieDetails = res.data;
                    $window.location.href = '#/movie';


                }, function errorCallback(res) {
                    $scope.openErrorModal("This movie does not exist in our List!");

                });

            };
        })
        // Review area.
        .controller('movieReviewController', function ($http, $window, $scope, $uibModalInstance, items, usernameInfo) {
            $scope.ratings = [
                {rate: "5", value: "5"},
                {rate: "4", value: "4"},
                {rate: "3", value: "3"},
                {rate: "2", value: "2"},
                {rate: "1", value: "1"}

            ];
            $scope.selectedRating = $scope.ratings[0];
            $scope.setRate = function () {
                console.log($scope.selectedRating.value);
            };
            $scope.close = function () {
                $uibModalInstance.close();
            };
            $scope.movie = items;
            console.log(items);
            $scope.ok = function () {
                console.log($scope.movieDetails);
                var movieReview = {review: $scope.movie.review, movie: $scope.movie.imdbid, username: usernameInfo.getUsername(), score: $scope.selectedRating.value};
                console.log(movieReview);

                $http({
                    url: 'api/movies/createReview',
                    dataType: 'json',
                    method: 'POST',
                    data: movieReview,
                    headers: {
                        "Content-Type": "application/json"
                    }

                })

                        .then(function sucessCallback(res) {
                            console.log(res.data)
                            $scope.movieDetails = res.data;
                        }
                        , function errorCallback(res) {
                            $scope.openErrorModal("This movie does not exist in our List!")

                        });



            };

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