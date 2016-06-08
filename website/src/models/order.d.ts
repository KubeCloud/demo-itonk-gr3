/// <reference path="product.d.ts" />
/// <reference path="customer.d.ts" />
declare namespace models {
    export interface IOrder {
        id: number;
        customer?: ICustomer;
        date: Date;
        total: number;
        products: Array<IProduct>;
        status: string;
    }
}
