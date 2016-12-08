'use strict';

/* Place your global Factory-service in this file */

angular.module('myApp.factories', [])
        .factory('usernameInfo', function () {

            return {
                getUsername: function () {
                    return this.updatedUsername;
                },
                setUsername: function (username) {
                    this.updatedUsername = username;
                }
            };
        })
        .factory('InfoFactory', function () {
            var info = "Hello World from a Factory";
            var getInfo = function getInfo() {
                return info;
            };
            return {
                getInfo: getInfo
            };
        })
        .factory('isAdmin', function () {

            return {
                checkIsAdmin: function () {
                    return this.isAdmin;
                },
                setToAdmin: function (isAdmin) {
                    this.isAdmin = isAdmin;
                }
            };
        })
        .factory('isUser', function () {

            return {
                checkIsUser: function () {
                    return this.isUser;
                },
                setToUser: function (isUser) {
                    this.isUser = isUser;
                }
            };
        });