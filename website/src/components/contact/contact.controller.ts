/// <reference path="../../../typings/main.d.ts" />
namespace app.contact {
    'use strict';

    export interface IContactController {
    }

    export class ContactController implements IContactController {
        static $inject: Array<string> = [];
    }

    angular
        .module('app.contact', [])
        .controller('contactController', ContactController)
        .config(['$stateProvider', ($stateProvider: angular.ui.IStateProvider) => {
            $stateProvider.state('contact', {
                controller: ContactController,
                controllerAs: 'contact',
                templateUrl: 'components/contact/contact.html',
                url: '/contact'
            });
        }]);
}
