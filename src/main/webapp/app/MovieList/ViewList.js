'use strict';
angular.module('myApp.ViewList', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/movieList', {
                    templateUrl: 'app/MovieList/listPage.html',
                    controller: 'listController'
                });
            }])

        .controller('listController', function ($http, $window, $scope, $uibModal, usernameInfo, isAdmin) {
            $scope.listDetails = {};
            $scope.isAdmin = isAdmin.checkIsAdmin();
            $http({
                url: 'api/movies/getMovieList',
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
            $scope.openeditModal = function (movie) {
                var modalInstance = $uibModal.open({
                    animation: true,
                    templateUrl: 'movieTemplate.html',
                    controller: 'MovieListControler',
                    resolve: {
                        items: function () {
                            return movie;
                        }
                    }
                });
            };
            $scope.openaddModal = function (movie) {
                if (usernameInfo.getUsername() === undefined) {
                    $scope.openErrorModal("You Need To Log In If You Want To Add A Movie!");
                } else {
                    var modalInstance = $uibModal.open({
                        animation: true,
                        templateUrl: 'movielistTemplate.html',
                        controller: 'PersonalMovieControler',
                        resolve: {
                            items: function () {
                                return movie;
                            }
                        }
                    });
                }
                ;
            };
        }).controller('MovieListControler', function ($scope, $uibModalInstance, items, $http)
{

    $scope.movie = items;
    $scope.close = function () {
        $uibModalInstance.close();
    };
    $scope.ok = function () {
        var updates = $scope.movie;
//        console.log(updates);
        $http({
            url: 'api/movies/updateMovie',
            dataType: 'json',
            method: 'PUT',
            data: updates,
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function successCallback(res) {
            $scope.openSuccessModal("Movie has been updated!");
            console.log(res.data);
            console.log("Works");
            $scope.isVisible = false;
        }, function errorCallback(res) {
            $scope.openErrorModal("Uknown error appeared!");
            console.log("Does Not Work");
            $scope.isVisible = false;
        });
        $uibModalInstance.close();
    };
}).controller('PersonalMovieControler', function ($scope, $uibModalInstance, items, $http, usernameInfo)
{


    $scope.statuses = [
        {status: "Planning To Watch", value: "4", rate: "false"},
        {status: "Stopped Watching", value: "3", rate: "true"},
        {status: "Watching", value: "2", rate: "true"},
        {status: "Finished", value: "1", rate: "true"}
    ];
    $scope.isDisabled = true;
    $scope.selectedStatus = $scope.statuses[0];

    $scope.setStatus = function () {
        if ($scope.selectedStatus.rate == "false")
        {
            $scope.isDisabled = true;

        } else {
            $scope.isDisabled = false;
        }
        console.log($scope.selectedStatus.value);
    };
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
    $scope.ok = function () {
        $scope.movie = items;
        var allInfo = {movie: $scope.movie.imdbid, username: usernameInfo.getUsername(), status: $scope.selectedStatus.status, rating: $scope.selectedRating.rate};
        console.log(allInfo);


        $http({
            url: 'api/profile/personalMovieAdd',
            dataType: 'json',
            method: 'POST',
            data: allInfo,
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function successCallback(res) {
            $scope.openSuccessModal("Movie has been added to your Movie List!");

        }, function errorCallback(res) {
            $scope.openErrorModal("Uknown error appeared!");

        });
        $uibModalInstance.close();
    };
});
        
