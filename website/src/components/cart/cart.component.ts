/// <reference path="../../../typings/main.d.ts" />
/// <reference path="../../models/cart.d.ts" />
/// <reference path="../services/web.data.service.ts" />
namespace app.components {
    'use strict';

    import IProduct = models.IProduct;
    import ICart = models.ICart;

    class CartComponent implements angular.IComponentOptions {
        static $inject: Array<string> = ['webDataService', '$rootScope', '$state'];
        items: Array<IProduct> = [];
        cart: ICart = undefined;

        constructor(
            private webDataService: services.IWebDataService,
            private $rootScope: ng.IRootScopeService,
            private $state: ng.ui.IStateService
        ) {
            this.getCart();
            $rootScope.$on('newItem', () => this.getCart());
        }

        checkout(): void {
            this.$state.go('order');
        }

        getCart(): void {
            this.webDataService.getCart(1).then(
                (success: ICart) => {
                    this.cart = success;

                    if (!this.cart.products) {
                        this.cart.products = [];
                    }
                    this.items = [];
                    this.cart.products.forEach((element: IProduct) => {
                        this.items.push(element);
                    });
                },
                (error: any) => {
                    console.error('WebDataService failed getting cart');
                }
            );
        }
    }

    angular
        .module('app.components')
        .component('psCart', {
            controller: CartComponent,
            controllerAs: 'cart',
            templateUrl: 'components/cart/cart.html'

        });
}
