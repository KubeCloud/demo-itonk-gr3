/// <reference path="../../../typings/main.d.ts" />
namespace app.home {
    'use strict';

    export interface IHomeController {
    }

    export class HomeController implements IHomeController {
        static $inject: Array<string> = [];
    }

    angular
        .module('app.home', [])
        .controller('homeController', HomeController)
        .config(['$stateProvider', ($stateProvider: angular.ui.IStateProvider) => {
            $stateProvider.state('home', {
                controller: HomeController,
                controllerAs: 'home',
                templateUrl: 'components/home/home.html',
                url: '/'
            });
        }]);
}
