'use strict';

angular.module('myApp.view1', ['ngRoute'])

        .config(['$routeProvider', function ($routeProvider) {
                $routeProvider.when('/view1', {
                    templateUrl: 'app/view1/view1.html',
                    controller: 'View1Ctrl',
                    controllerAs: 'ctrl'
                });
            }])
        .controller('View1Ctrl', function ($http, $scope, $rootScope) {

            $scope.childmethod = function () {
                $rootScope.$emit("CallParentMethod", {});
            };


        })

        .controller('View1Ctrl', function ($http, $scope, $rootScope) {



            $scope.checkImage = function (image) {
                if (image == "N/A") {
                    return "images/no-image.png";
                }
                return image;
            }
            $scope.listDetails = {};

            $scope.movie = function (movie) {
                console.log(movie);
                $rootScope.$on("CallParentMethod", function () {
                    $scope.parentmethod();
                });

                $scope.parentmethod = function () {
                    console.log("Hello");
                };
            };
            $http({
                url: 'api/movies/getMovieList',
                dataType: 'json',
                method: 'GET',
                headers: {
                    "Content-Type": "application/json"
                }



            }).then(function successCallback(res) {

                $scope.listDetails = res.data;
                $scope.poster = $scope.listDetails[1].Poster;
                console.log($scope.poster);



            }, function errorCallback(res) {
                console.log("Does not work");
            });

            $(document).ready(function () {



            });
        }).directive("owlCarousel", function () {
    return {
        restrict: 'E',
        transclude: false,
        link: function (scope) {
            scope.initCarousel = function (element) {
//                $("data-owl-carousel").owlCarousel({
//                    autoPlay: 5000, //Set AutoPlay to 3 seconds
//
//                    items: 12,
//                    itemsDesktop: [1199, 3],
//                    itemsDesktopSmall: [979, 3]
//
//                });
                // provide any default options you want
                var defaultOptions = {autoPlay: 5000, items: 10
                };
                var customOptions = scope.$eval($(element).attr('data-options'));
                // combine the two options objects
                for (var key in customOptions) {
                    defaultOptions[key] = customOptions[key];
                }
                // init carousel
                var curOwl = $(element).data('owlCarousel');
                if (!angular.isDefined(curOwl)) {
                    $(element).owlCarousel(defaultOptions);
                }
                scope.cnt++;
            };
        }
    };
}
)
        .directive('owlCarouselItem', function () {
            return {
                restrict: 'A',
                transclude: false,
                link: function (scope, element) {
                    // wait for the last item in the ng-repeat then call init
                    if (scope.$last) {
                        scope.initCarousel(element.parent());
                    }
                }
            };
        });