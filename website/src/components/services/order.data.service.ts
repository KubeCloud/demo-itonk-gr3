/// <reference path="../../../typings/main.d.ts" />
/// <reference path="../../models/order.d.ts" />
namespace app.services {
    'use strict';

    import IOrder = models.IOrder;

    export interface IPostOrderDto {
        customerId: number;
        productIds: Array<number>;
        total: number;
    }

    export interface IOrderDataService {
        placeOrder(order: IOrder): ng.IHttpPromise<void>;
    }

    export class OrderDataService implements IOrderDataService {
        private apiUrl: string;

        constructor(
            private $http: ng.IHttpService,
            private $q: ng.IQService,
            apiConfigUrl: string
        ) {
            this.apiUrl = apiConfigUrl + 'order/';
        }

        placeOrder(order: IOrder): ng.IHttpPromise<void> {
            return this.request<void>({
                data: this.mapOrder(order),
                method: 'POST',
                url: 'orders'
            });
        }

        /**
         * Map IOrder to IPostOrderDto object.
         */
        private mapOrder(order: IOrder): IPostOrderDto {
            const productIds: Array<number> = [];
            let total: number = 0;

            if (order.products) {
                for (let i: number = 0; i < order.products.length; i++) {
                    productIds.push(order.products[i].id);
                    total += order.products[i].price;
                }
            }

            const orderDto: IPostOrderDto = {
                customerId: 1,
                productIds: productIds,
                total: total
            };

            return orderDto;
        }

        private request<T>(config: ng.IRequestConfig): ng.IHttpPromise<T> {
            config.url = this.apiUrl + config.url;

            return this.$http<T>(config);
        }
    }

    angular
        .module('app.services')
        .factory('orderDataService', ['$http', '$q', 'apiConfigUrl', 'productDataService',
            ($h: ng.IHttpService, $q: ng.IQService, u: string) => new OrderDataService($h, $q, u)]);
}
