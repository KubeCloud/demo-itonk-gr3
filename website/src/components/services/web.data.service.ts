/// <reference path="../../../typings/main.d.ts" />
/// <reference path="../../models/catalog.d.ts" />
/// <reference path="../../models/cart.d.ts" />
/// <reference path="product.data.service.ts" />
namespace app.services {
    'use strict';

    import ICatalog = models.ICatalog;
    import ICart = models.ICart;
    import IProduct = models.IProduct;

    export interface IWebDataService {
        getCatalogs(): ng.IHttpPromise<Array<ICatalog>>;
        getCatalog(id: number): ng.IHttpPromise<ICatalog>;
        getCart(id: number): ng.IHttpPromise<ICart>;
        getCarts(): ng.IHttpPromise<Array<ICart>>;
        addProduct(product: IProduct): ng.IHttpPromise<void>;
        clearCart(): ng.IHttpPromise<void>;
    }

    interface IPatchCartDto {
        id: number;
        products: Array<number>;
        price: number;
        customerId: number;
    }
    export class WebDataService implements IWebDataService {
        private apiUrl: string;

        constructor(
            private $http: ng.IHttpService,
            private $q: ng.IQService,
            apiConfigUrl: string,
            private productDataService: IProductDataService
        ) {
            this.apiUrl = apiConfigUrl + 'web/';
        }

        getCatalogs(): ng.IHttpPromise<Array<ICatalog>> {
            return this.request({
                method: 'GET',
                url: 'catalogs'
            });
        }

        getCatalog(id: number): ng.IHttpPromise<ICatalog> {
            return this.request({
                method: 'GET',
                url: `catalogs/${id}`
            }).then((catalogSuccess: ng.IHttpPromiseCallbackArg<any>) => {
                this.populateProductsFromIds(catalogSuccess.data.products)
                    .then((products: IProduct[]) => catalogSuccess.data.products = products);
                return catalogSuccess;
            });
        }

        getCart(id: number): ng.IPromise<ICart> {
            let cart: ICart;

            return this.request({
                method: 'GET',
                url: `carts/${id}`
            }).then((cartSuccess: ng.IHttpPromiseCallbackArg<any>) => {

                if (!cartSuccess.data.products) { cartSuccess.data.products = []; }

                cart = cartSuccess.data;
                return this.populateProductsFromIds(cartSuccess.data.products).then((products: IProduct[]) => {
                    cart.products = products;
                    return cart;
                });
            });
        }

        getCarts(): ng.IHttpPromise<Array<ICart>> {
            return this.request({
                method: 'GET',
                url: 'carts'
            });
        }

        addProduct(product: IProduct): ng.IHttpPromise<void> {
            return this.getCart(1).then(
                (cartSuccess: ICart) => {
                    cartSuccess.products.push(product);
                    return this.request<void>({
                        data: this.mapCart(cartSuccess),
                        method: 'PATCH',
                        url: 'carts/1'
                    });
                });
        }

        clearCart(): ng.IHttpPromise<void> {
            return this.getCart(1).then(
                (cartSuccess: ICart) => {
                    cartSuccess.products = [];
                    return this.request<void>({
                        data: this.mapCart(cartSuccess),
                        method: 'PATCH',
                        url: 'carts/1'
                    });
                });
        }

        private populateProductsFromIds(ids: number[]): ng.IPromise<Array<IProduct>> {
            const promises: Array<ng.IPromise<IProduct>> = [];

            ids.forEach((value: number) => {
                let deferred: ng.IDeferred<IProduct> = this.$q.defer<IProduct>();

                this.productDataService.getProduct(value)
                    .then((productSuccess: ng.IHttpPromiseCallbackArg<IProduct>) => {
                        deferred.resolve(productSuccess.data);
                    }, (error: any) => {
                        console.error(error);
                    });

                promises.push(deferred.promise);
            });

            return this.$q.all(promises);
        }

        private request<T>(config: ng.IRequestConfig): ng.IHttpPromise<T> {
            config.url = this.apiUrl + config.url;

            return this.$http<T>(config);
        }

        private mapCart(cart: ICart): IPatchCartDto {
            const productIds: Array<number> = [];
            let total: number = 0;

            if (cart.products) {
                for (let i: number = 0; i < cart.products.length; i++) {
                    productIds.push(cart.products[i].id);
                    total += cart.products[i].price;
                }
            }

            const cartDto: IPatchCartDto = {
                customerId: 1,
                id: cart.id,
                price: total,
                products: productIds
            };

            return cartDto;
        }
    }

    angular
        .module('app.services')
        .factory('webDataService', ['$http', '$q', 'apiConfigUrl', 'productDataService',
            ($h: ng.IHttpService, $q: ng.IQService, u: string, p: IProductDataService) => new WebDataService($h, $q, u, p)]);
}
