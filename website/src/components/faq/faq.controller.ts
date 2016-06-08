/// <reference path="../../../typings/main.d.ts" />
namespace app.faq {
    'use strict';

    export interface IFAQController {
    }

    export class FAQController implements IFAQController {
        static $inject: Array<string> = [];
    }

    angular
        .module('app.faq', [])
        .controller('faqController', FAQController)
        .config(['$stateProvider', ($stateProvider: angular.ui.IStateProvider) => {
            $stateProvider.state('faq', {
                controller: FAQController,
                controllerAs: 'faq',
                templateUrl: 'components/faq/faq.html',
                url: '/FAQ'
            });
        }]);
}
