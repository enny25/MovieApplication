'use strict';
angular.module('myApp.adminAdd', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/adminAdd', {
                    templateUrl: 'app/adminAdd/add.html',
                    controller: 'adminAddController',
                    controllerAs: 'ctrl'
                });
            }])

        .controller('adminAddController', function ($scope, $http, $uibModal) {
        $scope.options = [
        {info: "Add By Title", type: "0"},
        {info: "Add By ID", type: "1"}
        ];
                $scope.selectedOption = $scope.options[0];
                $scope.setOption = function () {
                console.log($scope.selectedOption.type);
                };
            $scope.addMovie = function () {


                var movieGet = $scope.selectedOption;
                console.log(movieGet);
                console.log(movieGet[0]);
                var postObject = {};
                if (movieGet.type == 1) {
                    postObject.imdbid = $scope.movieSearch.info;
                    var url = 'api/movies/createById';
                    console.log(postObject);
                } else {
                    postObject.title = $scope.movieSearch.info;
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
                    $scope.openSuccessModal("Movie has been added to the list!");
                    $scope.isVisible = false;
                }, function errorCallback(res) {
                    $scope.openErrorModal("Movie does not exist or is already Added!");
                    $scope.isVisible = false;
                });
            };
        });