/// <reference path="catalog.d.ts" />
/// <reference path="order.d.ts" />
declare namespace models {
    export interface IProduct {
        id: number;
        name: string;
        description: string;
        price: number;
        status: string;
        catalogs?: Array<ICatalog>;
        campaigns?: Array<any>;
        orders?: Array<IOrder>;
    }
}
