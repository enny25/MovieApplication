'use strict';

angular.module('myApp.view2', ['ngRoute'])


        .controller('movieController', function ($http, $scope) {
            $scope.addMovie = function () {
                
                var postObject = $scope.titleid;
                var title = {title:postObject}; 
                console.log("Adding movie: "+postObject);
                $http({
                    url: 'api/movies/createByName',
                    dataType: 'json',
                    method: 'POST',
                    data: title,
                    headers: {
                        "Content-Type": "application/json"
                    }

                }).then(function successCallback(res) {
                    $scope.data = res.data.message;
                }, function errorCallback(res) {
                    $scope.error = res.status + ": " + res.data.statusText;
                });
                
            };
        });