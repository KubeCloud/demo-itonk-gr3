/// <reference path="../../../typings/main.d.ts" />
/// <reference path="../services/product.data.service.ts" />
/// <reference path="../services/web.data.service.ts" />
namespace app.productDetail {
    'use strict';

    import IProductDataService = services.IProductDataService;
    import IProduct = models.IProduct;
    import IWebDataService = services.IWebDataService;

    interface IProductDetailStateParams extends ng.ui.IStateParamsService {
        id: number;
    }

    export class ProductDetail {
        static $inject: Array<string> = ['$stateParams', '$rootScope', 'productDataService', 'webDataService'];

        product: IProduct;

        constructor(
            $stateParams: IProductDetailStateParams,
            private $rootScope: ng.IRootScopeService,
            productDataService: IProductDataService,
            private webDataService: IWebDataService
        ) {
            productDataService.getProduct($stateParams.id).then(
                (success: ng.IHttpPromiseCallbackArg<IProduct>) => {
                    this.product = success.data;
                });
        }

        buy(): void {
            this.webDataService.addProduct(this.product).then(() =>
                this.$rootScope.$broadcast('newItem'));
        }
    }

    angular
        .module('app.productDetail', [])
        .controller('productDetail', ProductDetail)
        .config(['$stateProvider', ($stateProvider: angular.ui.IStateProvider) => {
            $stateProvider.state('productDetail', {
                controller: ProductDetail,
                controllerAs: 'product',
                templateUrl: 'components/productDetail/productDetail.html',
                url: '/product/{id:int}'
            });
        }]);
}
