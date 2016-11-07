'use strict';
angular.module('myApp.ViewList', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/movieList', {
                    templateUrl: 'app/MovieList/listPage.html',
                    controller: 'listController'
                });
            }])

        .controller('listController', function ($http, $window, $scope, $uibModal) {
            $scope.listDetails = {};
            $scope.admin = $scope.isAdmin;
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
            $scope.open = function (movie) {
                var modalInstance = $uibModal.open({
                    animation: true,
                    templateUrl: 'movieTemplate.html',
                    controller: 'ModalInstanceCtrl',
                    resolve: {
                        items: function () {
                            return movie;
                        }
                    }
                });
            }
            ;
        }).controller('ModalInstanceCtrl', function ($scope, $uibModalInstance, items, $http)
{

    $scope.movie = items;
    $scope.ok = function () {
        var updates = $scope.movie;
        console.log(updates);
        $http({
            url: 'api/movies/updateMovie',
            dataType: 'json',
            method: 'PUT',
            data: updates,
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function successCallback(res) {
            $scope.openSuccessModal("Movie has been updated to the list!");
            $scope.isVisible = false;
        }, function errorCallback(res) {
            $scope.openErrorModal("Uknown error appeared!");
            $scope.isVisible = false;
        });
        $uibModalInstance.close();
    };
});
        