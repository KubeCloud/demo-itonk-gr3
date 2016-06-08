/// <reference path="../../../typings/main.d.ts" />
namespace app.components {
    'use strict';

    class FooterComponent implements angular.IComponentOptions {
        static $inject: Array<string> = [];
    }

    angular
        .module('app.components')
        .component('psFooter', {
            controller: FooterComponent,
            controllerAs: 'footer',
            templateUrl: 'components/footer/footer.html'
        });
}
