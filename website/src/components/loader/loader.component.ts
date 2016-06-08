 /// <reference path="../../../typings/main.d.ts" />
namespace app.components {
    'use strict';

    class LoaderComponent implements angular.IComponentOptions {
        static $inject: Array<string> = ['$scope'];

        showSpinner: boolean;

        constructor($scope: angular.IScope) {
            this.showSpinner = true;
            $scope.$on('$stateChangeStart', () => {
                this.showSpinner = true;
            });

            $scope.$on('$stateChangeSuccess', () => {
                this.showSpinner = false;
            });
        }
    }

    angular
        .module('app.components')
        .component('psLoader', {
            controller: LoaderComponent,
            controllerAs: 'loader',
            templateUrl: 'components/loader/loader.html'
        });
}
