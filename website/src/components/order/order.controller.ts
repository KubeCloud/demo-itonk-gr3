/// <reference path="../../../typings/main.d.ts" />
/// <reference path="../../models/order.d.ts" />
/// <reference path="../services/order.data.service.ts" />
/// <reference path="../services/web.data.service.ts" />
namespace app.order {
    'use strict';

    import IOrder = models.IOrder;

    export interface IOrderController {
        details: IOrder;
        confirmed: boolean;
    }

    export class OrderController implements IOrderController {
        static $inject: Array<string> = ['$rootScope', 'orderDataService', 'webDataService'];

        details: IOrder;
        confirmed: boolean;

        constructor(
            private $rootScope: ng.IRootScopeService,
            private orderDataService: services.IOrderDataService,
            private webDataService: services.IWebDataService
        ) {
        }

        placeOrder(): void {
            this.orderDataService.placeOrder(this.details).then(() => {
                this.confirmed = true;
                this.webDataService.clearCart()
                    .then(() =>
                        this.$rootScope.$broadcast('newItem'));
            }, () => {
                console.error('Error creating order');
            });
        }
    }

    angular
        .module('app.order', [])
        .controller('orderController', OrderController)
        .config(['$stateProvider', ($stateProvider: angular.ui.IStateProvider) => {
            $stateProvider.state('order', {
                controller: OrderController,
                controllerAs: 'order',
                templateUrl: 'components/order/order.html',
                url: '/order'
            });
        }]);
}
