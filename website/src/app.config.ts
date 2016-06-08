/// <reference path="../typings/main.d.ts" />
namespace app {
    'use strict';

    angular
        .module('app')
        .config(['$urlRouterProvider', ($urlRouterProvider: angular.ui.IUrlRouterProvider) => {
            $urlRouterProvider.otherwise('/');
        }])
        .constant('apiConfigUrl', 'http://192.168.1.31/');
        // .constant('apiConfigUrl', 'http://localhost:8080/');
}
