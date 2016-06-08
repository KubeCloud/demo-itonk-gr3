/// <reference path="product.d.ts" />
declare namespace models {
    export interface ICatalog {
        id: number;
        name: string;
        products: Array<IProduct>;
    }
}
