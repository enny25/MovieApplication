'use strict';

angular.module('myApp.MovieJS', ['ngRoute'])


        .controller('movieController', function ($http, $scope) {
            $scope.addMovie = function () {

                var postObject = {title: $scope.titleid};

                console.log("Adding movie: " + postObject);
                $http({
                    url: 'api/movies/createByName',
                    dataType: 'json',
                    method: 'POST',
                    data: postObject,
                    headers: {
                        'Content-Type': 'application/json'
                    }
                    


                }).then(function successCallback(res) {
                    console.log("Works");
                }, function errorCallback(res) {
                    console.log("Does not work");
                });

            };
        });