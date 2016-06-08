/// <reference path="../../../typings/main.d.ts" />
/// <reference path="../services/web.data.service.ts" />
namespace app.catalogDetail {
    'use strict';

    import IWebDataService = services.IWebDataService;
    import ICatalog = models.ICatalog;

    interface ICatalogDetailStateParams extends ng.ui.IStateParamsService {
        id: number;
    }

    export class CatalogDetail {
        static $inject: Array<string> = ['$stateParams', 'webDataService'];

        catalog: ICatalog;

        constructor(
            $stateParams: ICatalogDetailStateParams,
            webDataService: IWebDataService
        ) {
            webDataService.getCatalog($stateParams.id).then(
                (success: ng.IHttpPromiseCallbackArg<ICatalog>) => {
                    this.catalog = success.data;
                });
        }
    }

    angular
        .module('app.catalogDetail', [])
        .controller('catalogDetail', CatalogDetail)
        .config(['$stateProvider', ($stateProvider: angular.ui.IStateProvider) => {
            $stateProvider.state('catalogDetail', {
                controller: CatalogDetail,
                controllerAs: 'cat',
                templateUrl: 'components/catalogDetail/catalogDetail.html',
                url: '/catalog/{id:int}'
            });
        }]);
}
