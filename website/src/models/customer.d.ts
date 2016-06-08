/// <reference path="order.d.ts" />
declare namespace models {
    export interface ICustomer {
        id: number;
        name: string;
        address: string;
        email: string;
        cart?: any;
        country: { name: string };
        orders?: Array<IOrder>;
        invoices?: Array<any>;
        tickets?: Array<any>;
    }
}
