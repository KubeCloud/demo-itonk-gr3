/// <reference path="../../../typings/main.d.ts" />
namespace app.core {
    'use strict';

    export interface ICoreController {
    }


    export class CoreController implements ICoreController {
        static $inject: Array<string> = [];
    }

    angular.module('app.core', [
        'ui.router',
        'ui.bootstrap'
    ])
        .controller('coreController', CoreController);
}
