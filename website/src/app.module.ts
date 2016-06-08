/// <reference path="../typings/main.d.ts" />
namespace app {
    'use strict';

    angular.module('app', [
        'app.core',
        'app.services',

        'app.directives',
        'app.components',

        'app.home',
        'app.contact',
        'app.faq',
        'app.order',

        'app.catalogDetail',
        'app.productDetail'
    ]);
}
