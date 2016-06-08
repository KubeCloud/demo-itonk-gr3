/// <reference path="../../../typings/main.d.ts" />
/// <reference path="../../models/catalog.d.ts" />
/// <reference path="../services/web.data.service.ts" />
namespace app.components {
    'use strict';

    import ICatalog = models.ICatalog;

    class CatalogsComponent implements angular.IComponentOptions {
        static $inject: Array<string> = ['webDataService'];
        cats: Array<models.ICatalog> = [];

        constructor(private webDataService: services.IWebDataService) {
            this.webDataService.getCatalogs().then(
                (success: ng.IHttpPromiseCallbackArg<Array<ICatalog>>) => {
                    this.cats = success.data;
                },
                (error: any) => {
                    console.error('WebDataService failed getting catalogs');
                }
            );
        }
    }

    angular
        .module('app.components')
        .component('psCatalogs', {
            controller: CatalogsComponent,
            controllerAs: 'cats',
            templateUrl: 'components/catalogs/catalogs.html'
        });
}
