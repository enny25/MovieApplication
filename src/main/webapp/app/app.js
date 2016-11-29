'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
    'ngRoute',
    'ngAnimate',
    'angular-jwt',
    'ui.bootstrap',
    'myApp.security',
    'myApp.PersonalProfile',
    'myApp.MovieJS',
    'myApp.adminAdd',
    'myApp.ViewList',
    'myApp.DocumentationView',
    'myApp.personalpage',
    'myApp.view1',
    'myApp.filters',
    'myApp.directives',
    'myApp.factories',
    'myApp.services'
]).
        config(['$routeProvider', function ($routeProvider) {
                $routeProvider.otherwise({redirectTo: '/view1'});
            }]).
        config(function ($httpProvider) {
            $httpProvider.interceptors.push('AuthInterceptor');
        });


