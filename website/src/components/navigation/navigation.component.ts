/// <reference path="../../../typings/main.d.ts" />
namespace app.components {
    'use strict';

    class NavigationDirective implements angular.IComponentOptions {
        static $inject: Array<string> = [];
    }

    angular
        .module('app.components')
        .component('psNavigation', {
            controller: NavigationDirective,
            controllerAs: 'nav',
            templateUrl: 'components/navigation/navigation.html'
        });
}
