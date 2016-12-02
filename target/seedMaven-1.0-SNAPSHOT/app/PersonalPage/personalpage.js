'use strict';

angular.module("myApp.personalpage", ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/personalpage', {
                    templateUrl: 'app/PersonalPage/viewPersonalPage.html',
                    controller: 'personalPageController',
                    controllerAs: 'ppctrl'
                });
            }])
        
        .controller('personalPageController', function ($http, $window, $scope, $uibModal ){
            $scope.listUsers ={};
            $scope.user = $scope.isUser;
            $http({
                url: 'api/profile/MAKE_SOMETHING_IN_REST_FOR_GETTING_USER',
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
            $scope.open = function (user) {
                var modalInstance = $uibModal.open({
                    animation: true,
                    templateUrl: 'upTemplate.html',
                    controller: 'ModalInstanceCtrl',
                    resolve: {
                        items: function () {
                            return user;
                        }
                    }
                });
            }
            ;
            }).controller('ModalInstanceCtrl', function ($scope, $uibModalInstance, items, $http)
{

    $scope.user = items;
    $scope.close = function() {
        $uibModalInstance.close();
    };
    $scope.ok = function () {
        var updates = $scope.user;
        console.log(updates);
        $http({
            url: 'api/profile/updateUser', /* WE*RE LACKING THE REST FOR UPDATE USER, ZYGI!*/
            dataType: 'json',
            method: 'PUT',
            data: updates,
            headers: {
                "Content-Type": "application/json"
            }
        }).then(function successCallback(res) {
            $scope.openSuccessModal("User has been updated!");
            $scope.isVisible = false;
        }, function errorCallback(res) {
            $scope.openErrorModal("Uknown error appeared!");
            $scope.isVisible = false;
        });
        $uibModalInstance.close();
    };
});
        
        


