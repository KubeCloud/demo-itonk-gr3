/// <reference path="../../../typings/main.d.ts" />
/// <reference path="../../models/product.d.ts" />
namespace app.services {
    'use strict';

    import IProduct = models.IProduct;

    export interface IProductDataService {
        getProducts(): ng.IHttpPromise<Array<IProduct>>;
        getProduct(id: number): ng.IHttpPromise<IProduct>;
    }

    export class ProductDataService implements IProductDataService {
        apiUrl: string;

        constructor(private $http: ng.IHttpService, private $q: ng.IQService, apiConfigUrl: string) {
            this.apiUrl = apiConfigUrl + 'product/';
        }

        getProducts(): ng.IHttpPromise<Array<IProduct>> {
            return this.request({
                method: 'GET',
                url: 'products'
            });
        }

        getProduct(id: number): ng.IHttpPromise<IProduct> {
            return this.request<IProduct>({
                method: 'GET',
                url: 'products/' + id
            });
        }

        private request<T>(config: ng.IRequestConfig): ng.IHttpPromise<T> {
            config.url = this.apiUrl + config.url;

            return this.$http<T>(config);
        }
    }

    angular
        .module('app.services')
        .factory('productDataService', ['$http', '$q', 'apiConfigUrl',
            ($h: ng.IHttpService, $q: ng.IQService, a: string) => new ProductDataService($h, $q, a)]);
}
